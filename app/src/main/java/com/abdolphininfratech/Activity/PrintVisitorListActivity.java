package com.abdolphininfratech.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.abdolphininfratech.Adapter.PdfPrintDocumentAdapter;
import com.abdolphininfratech.Adapter.PrintVisitor;
import com.abdolphininfratech.Fragment.VisistorListFragment;
import com.abdolphininfratech.Model.PrintVisitorList.ResPrintVisitorList;
import com.abdolphininfratech.Model.PrintVisitorList.Visitorlst;
import com.abdolphininfratech.R;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.constants.BaseActivity;
import com.abdolphininfratech.databinding.ActivityPrintVisitorListBinding;
import com.abdolphininfratech.retrofit.ApiServices;
import com.abdolphininfratech.retrofit.RetrofitClient;
import com.google.gson.JsonObject;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PrintVisitorListActivity extends BaseActivity {
    ActivityPrintVisitorListBinding binding;
    private List<Visitorlst> lstvisitors;
    private static final int REQUEST_WRITE_STORAGE = 112;

    private PrintVisitor adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrintVisitorListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initview();
        onclicklisner();

        binding.txtHeading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestStoragePermissionForPrint();
            }
        });

    }


    private void requestStoragePermissionForPrint() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE,}, REQUEST_WRITE_STORAGE);
        } else {
            generatePDF();
        }
    }


    private void onclicklisner() {
        binding.backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(new VisistorListFragment());
            }
        });
    }

    private void initview() {
        lstvisitors = new ArrayList<>();
        adapter = new PrintVisitor(lstvisitors);
        binding.printrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.printrecyclerview.setAdapter(adapter);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("PK_VisitorId")) {
            String visitorId = intent.getStringExtra("PK_VisitorId");
            PrintData(visitorId);
        }
    }

    public void PrintData(String id ) {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("PK_VisitorId",Integer.parseInt(id));
        LoggerUtil.logItem(object);
        Log.d("req datsa: ",""+object);
        ApiServices apiService = RetrofitClient.getClient("https://abdolphininfratech.com/").create(ApiServices.class);
        Call<ResPrintVisitorList> call = apiService.getprintVisitor(object);
        call.enqueue(new Callback<ResPrintVisitorList>() {
            @Override
            public void onResponse(Call<ResPrintVisitorList> call, Response<ResPrintVisitorList> response) {
                int statusCode = response.code();
                Log.d(TAG, "HTTP Status Code: " + statusCode);
                if (response.isSuccessful() && response.body() != null) {
                    hideLoading();
                    ResPrintVisitorList resVisitorList = response.body();
                    LoggerUtil.logItem(resVisitorList);
                    String apiStatus = resVisitorList.getStatus();
                    String apiMessage = resVisitorList.getMessage();

                    // Set data to TextViews
                    binding.text1.setText(resVisitorList.getSiteName());
                    binding.text2.setText(resVisitorList.getLoginId());
                    binding.text3.setText(resVisitorList.getAssociateName());
                    binding.text4.setText(resVisitorList.getAmount());
                    binding.text5.setText(resVisitorList.getVisitDate());
                   // loginIdTextView.setText(resVisitorList.getLoginId());
                    Log.d(TAG, "API Status: " + apiStatus);
                    Log.d(TAG, "API Message: " + apiMessage);
                    lstvisitors.clear();
                    lstvisitors.addAll(resVisitorList.getVisitorlst());
                    adapter.notifyDataSetChanged();

//                    if ("success".equalsIgnoreCase(apiStatus)) {
//                        if (resVisitorList.getVisitorlst() != null) {
//                            lstvisitors.clear();
//                            lstvisitors.addAll(resVisitorList.getVisitorlst());
//                            adapter.notifyDataSetChanged();
//                        }
//                    } else {
//                        Log.e(TAG, "API Error Message: " + apiMessage);
//                    }
                } else {
                    Log.e(TAG, "Response Error: " + response.message());

                    switch (statusCode) {
                        case 404:
                            Log.e(TAG, "Error: Resource not found.");
                            break;
                        case 500:
                            Log.e(TAG, "Error: Server error.");
                            break;
                        default:
                            Log.e(TAG, "Error: Unexpected status code.");
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<ResPrintVisitorList> call, Throwable t) {
                Log.e(TAG, "Network Failure: " + t.getMessage());
            }
        });
    }








//    public void PrintData(String id) {
//        showLoading();
//        JsonObject object = new JsonObject();
//        object.addProperty("PK_VisitorId", Integer.parseInt(id));
//        LoggerUtil.logItem(object);
//        Log.d("req data: ", "" + object);
//
//        ApiServices apiService = RetrofitClient.getClient("https://abdolphininfratech.com/").create(ApiServices.class);
//        Call<ResPrintVisitorList> call = apiService.getprintVisitor(object);
//        call.enqueue(new Callback<ResPrintVisitorList>() {
//            @Override
//            public void onResponse(Call<ResPrintVisitorList> call, Response<ResPrintVisitorList> response) {
//                int statusCode = response.code();
//                Log.d(TAG, "HTTP Status Code: " + statusCode);
//
//                if (response.isSuccessful() && response.body() != null) {
//                    hideLoading();
//                    ResPrintVisitorList resVisitorList = response.body();
//                    LoggerUtil.logItem(resVisitorList);
//
//                    binding.text1.setText(resVisitorList.getSiteName());
//                    binding.text2.setText(resVisitorList.getLoginId());
//                    binding.text3.setText(resVisitorList.getAssociateName());
//                    binding.text4.setText(resVisitorList.getAmount());
//                    binding.text5.setText(resVisitorList.getVisitDate());
//
//                    TableLayout tableLayout = binding.tableLayout;
//                    tableLayout.removeAllViews();
//
//                    TableRow headerRow = new TableRow(PrintVisitorListActivity.this);
//                    addRowWithBorder(headerRow, true); // Apply border for header
//                    addTextViewToRow(headerRow, "Name", true);
//                    addTextViewToRow(headerRow, "Mobile", true);
//                    addTextViewToRow(headerRow, "Address", true);
//                    tableLayout.addView(headerRow);
//
//                    for (Visitorlst visitor : resVisitorList.getVisitorlst()) {
//                        TableRow row = new TableRow(PrintVisitorListActivity.this);
//                        addRowWithBorder(row, false);
//                        addTextViewToRow(row, visitor.getCustomerName(), false);
//                        addTextViewToRow(row, visitor.getMobile(), false);
//                        addTextViewToRow(row, visitor.getAddress(), false);
//                        tableLayout.addView(row);
//                    }
//
//                    // Generate PDF
////                    createPDF(PrintVisitorListActivity.this, resVisitorList);
//                } else {
//                    Log.e(TAG, "Response Error: " + response.message());
//
//                    switch (statusCode) {
//                        case 404:
//                            Log.e(TAG, "Error: Resource not found.");
//                            break;
//                        case 500:
//                            Log.e(TAG, "Error: Server error.");
//                            break;
//                        default:
//                            Log.e(TAG, "Error: Unexpected status code.");
//                            break;
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResPrintVisitorList> call, Throwable t) {
//                Log.e(TAG, "Network Failure: " + t.getMessage());
//            }
//        });
//    }




    private void generatePDF() {
        if (lstvisitors != null && !lstvisitors.isEmpty()) {
            ResPrintVisitorList resVisitorList = new ResPrintVisitorList();
            resVisitorList.setVisitorlst((ArrayList<Visitorlst>) lstvisitors);
            createPDF(PrintVisitorListActivity.this, resVisitorList);
        } else {
            Log.d(TAG, "No data available to generate PDF");
            Toast.makeText(this, "No data available to generate PDF", Toast.LENGTH_SHORT).show();
        }
    }

    private void createPDF(Context context, ResPrintVisitorList resVisitorList) {
        Document document = new Document();
        File file = null;
        try {
            File dir = new File(context.getExternalFilesDir(null), "PDFs");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            file = new File(dir, "VisitorList.pdf");
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            // Ensure there is content to be added
            if (resVisitorList.getVisitorlst() == null || resVisitorList.getVisitorlst().isEmpty()) {
                throw new IOException("No visitor data to add to PDF.");
            }

            document.add(new Paragraph("Visitor List"));
            document.add(new Paragraph("Site Name: " + resVisitorList.getSiteName()));
            document.add(new Paragraph("Visitor ID: " + resVisitorList.getpK_VisitorId()));
            document.add(new Paragraph("Associate Name: " + resVisitorList.getAssociateName()));
            document.add(new Paragraph("Amount: " + resVisitorList.getAmount()));
            document.add(new Paragraph("Visit Date: " + resVisitorList.getVisitDate()));

            PdfPTable table = new PdfPTable(3);
            table.addCell("Name");
            table.addCell("Mobile");
            table.addCell("Address");

            for (Visitorlst visitor : resVisitorList.getVisitorlst()) {
                table.addCell(visitor.getCustomerName());
                table.addCell(visitor.getMobile());
                table.addCell(visitor.getAddress());
            }

            document.add(table);
            Log.d(TAG, "PDF Created: " + file.getAbsolutePath());

        } catch (DocumentException e) {
            e.printStackTrace();
            Log.e(TAG, "PDF Creation Error: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "IO Error: " + e.getMessage());
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }

        // Check if the file was created and has content
        if (file.exists() && file.length() > 0) {
            printPDF(file.getAbsolutePath());
        } else {
            Log.e(TAG, "PDF File is empty or not created.");
        }
    }


    private void openPDF(Context context, File file) {
        Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "application/pdf");
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        context.startActivity(Intent.createChooser(intent, "Open PDF with"));
    }


    private void addTextViewToRow(TableRow row, String text, boolean isHeader) {
        TextView textView = new TextView(PrintVisitorListActivity.this);
        textView.setText(text);
        textView.setPadding(10, 16, 10, 16);

        textView.setBackgroundResource(R.drawable.border);

        if (isHeader) {
            textView.setBackgroundColor(Color.parseColor("#7b2f00"));
            textView.setTextColor(Color.WHITE);
        } else {
            textView.setTextColor(Color.BLACK);
        }

        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT ,
                TableRow.LayoutParams.WRAP_CONTENT,
                1.0f);
        textView.setLayoutParams(params);
        row.addView(textView);
    }

    private void setTableRowPadding(TableRow row) {
        TableRow.LayoutParams params = (TableRow.LayoutParams) row.getLayoutParams();
        if (params == null) {
            params = new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT);
        }
        params.setMargins(0, 8, 0, 8);
        row.setLayoutParams(params);
    }

    private void addRowWithBorder(TableRow row, boolean isHeader) {
        if (isHeader) {
            row.setBackgroundColor(Color.parseColor("#7b2f00"));
        } else {
            row.setBackgroundResource(R.drawable.border);
        }
        setTableRowPadding(row);
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }






    public void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE,}, REQUEST_WRITE_STORAGE);
        } else {
            generatePDF();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_WRITE_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                generatePDF();
            } else {
                Toast.makeText(this, "Permission denied to write to external storage", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void printPDF(String filePath) {
        PrintManager printManager = (PrintManager) this.getSystemService(Context.PRINT_SERVICE);

        try {
            File file = new File(filePath);
            PrintDocumentAdapter printAdapter = new PdfPrintDocumentAdapter(this, file);
            printManager.print("Document", printAdapter, null);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Print failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
