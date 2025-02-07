package com.abdolphininfratech.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.abdolphininfratech.Model.KYCUPLOAD.ResKYCUPLOAD;
import com.abdolphininfratech.Model.UploadKycList.LstKycdocument;
import com.abdolphininfratech.Model.UploadKycList.ReqUploadKycList;
import com.abdolphininfratech.Model.UploadKycList.ResUploadKycList;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.constants.BaseActivity;
import com.abdolphininfratech.databinding.ActivityKycuploadBinding;
import com.abdolphininfratech.retrofit.ApiServices;
import com.abdolphininfratech.retrofit.RetrofitClient;
import com.squareup.picasso.Picasso;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class KYCUploadActivity extends BaseActivity {
    ActivityKycuploadBinding binding;
    private static final int PICK_IMAGE1 = 1;
    private static final int PICK_IMAGE2 = 2;
    private static final int PICK_IMAGE3 = 3;
    private static final int PICK_IMAGE4 = 4;
    private static final int TAKE_PHOTO1 = 5;
    private static final int TAKE_PHOTO2 = 6;
    private static final int TAKE_PHOTO3 = 7;
    private static final int TAKE_PHOTO4 = 8;
    private ImageView imageView1, imageView2, imageView3;
    private int currentImageView;
    private static final int aadhar_front_request_code = 100;
    private static final int aadhar_back_request_code = 101;
    private static final int pan_request_code = 102;
    private static final int document_request_code = 103;
    private String aadharFrontPath, aadharBackPath, panPath, documentPath, selectedImagePath;
    private Uri aadhar_front, aadhar_back, pan, document;
    private int camera = 1, gallery = 2, flag = 0;
    private int currentRequestCode;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_PICK_IMAGE = 2;
    private Uri photoURI;
    private Object BuildConfig;

     private static final String BASE_URL="https://abdolphininfratech.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityKycuploadBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

          getKycList();
          onclicklistener();
          initview();

    }

    private void initview() {

    }

    private void onclicklistener() {
        binding.backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KYCUploadActivity.this, ContainerActivity.class);
                startActivity(intent);
            }
        });

        binding.submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(binding.adharNumber.getText().toString())) {
                    Toast.makeText(KYCUploadActivity.this, "Enter Aadhar Number", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(binding.PanCardNumber.getText().toString())) {
                    Toast.makeText(KYCUploadActivity.this, "Enter Pan Number", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(binding.accountNumber.getText().toString())) {
                    Toast.makeText(KYCUploadActivity.this, "Enter document Number", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(binding.adharFront.toString())) {
                    Toast.makeText(KYCUploadActivity.this, "Upload Adhar Front", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(binding.adharback.toString())) {
                    Toast.makeText(KYCUploadActivity.this, "Upload adhar back", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(binding.panImage.toString())) {
                    Toast.makeText(KYCUploadActivity.this, "Upload PAN CARD", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(binding.DocImage.toString())) {
                    Toast.makeText(KYCUploadActivity.this, "Upload Document", Toast.LENGTH_SHORT).show();
                } else {
                    uploadKyC();
                }
            }
        });


        binding.adharcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.panCardLayout.setVisibility(View.GONE);
                binding.adharCardLayout.setVisibility(View.VISIBLE);
                binding.adharcard.setBackgroundColor(Color.parseColor("#7b2f00"));
                binding.pancard.setBackgroundColor(Color.parseColor("#f9d98d"));

            }
        });
        binding.pancard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.adharCardLayout.setVisibility(View.GONE);
                binding.panCardLayout.setVisibility(View.VISIBLE);
                //binding.pancard.setBackgroundColor(Color.BLUE);
                binding.pancard.setBackgroundColor(Color.parseColor("#7b2f00"));
                binding.adharcard.setBackgroundColor(Color.parseColor("#f9d98d"));

            }
        });
        binding.idprooflayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.IDProof.setVisibility(View.VISIBLE);
                binding.bankdetails.setVisibility(View.GONE);
                binding.id.setTextColor(Color.parseColor("#f9d98d"));
                binding.bank.setTextColor(Color.parseColor("#fafcfc"));
                binding.idview.setBackgroundColor(Color.parseColor("#f9d98d"));
                binding.bankview.setBackgroundColor(Color.parseColor("#fafcfc"));
                binding.nextbutton.setVisibility(View.VISIBLE);
                binding.submitbutton.setVisibility(View.GONE);

            }
        });

        binding.bankdetailslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.IDProof.setVisibility(View.GONE);
                binding.bankdetails.setVisibility(View.VISIBLE);
                binding.bank.setTextColor(Color.parseColor("#f9d98d"));
                binding.id.setTextColor(Color.parseColor("#fafcfc"));
                binding.bankview.setBackgroundColor(Color.parseColor("#f9d98d"));
                binding.idview.setBackgroundColor(Color.parseColor("#fafcfc"));
                binding.nextbutton.setVisibility(View.GONE);
                binding.submitbutton.setVisibility(View.VISIBLE);

            }
        });


        binding.camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissionCheck();
                currentImageView = R.id.adharFront;
                openCamera(TAKE_PHOTO1);
            }
        });

        binding.camera1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissionCheck();
                currentImageView = R.id.adharback;
                openCamera(TAKE_PHOTO2);

            }
        });
        binding.pancamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissionCheck();
                currentImageView = R.id.panImage;
                openCamera(TAKE_PHOTO3);

            }
        });
        binding.Doccamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissionCheck();
                currentImageView = R.id.DocImage;
                openCamera(TAKE_PHOTO4);

            }
        });

        binding.gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageView = R.id.adharFront;
                openGallery(PICK_IMAGE1);
            }
        });
        binding.gallery2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageView = R.id.adharback;
                openGallery(PICK_IMAGE2);
            }
        });
        binding.pangallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageView = R.id.panImage;
                openGallery(PICK_IMAGE3);
            }
        });
        binding.docgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageView = R.id.DocImage;
                openGallery(PICK_IMAGE4);
            }
        });

    }


    private void openGallery(int requestCode) {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, requestCode);
    }


    private void openCamera(int requestCode) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Handle error
                ex.printStackTrace();
            }
            if (photoFile != null) {
                photoURI = FileProvider.getUriForFile(this,
                        "com.abdolphininfratech.fileprovider",
                        photoFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(cameraIntent, requestCode);
            }
        }
    }


    private File createImageFile() throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri imageUri = null;
            ImageView imageView = findViewById(currentImageView);

            if (data != null) {
                if (requestCode == PICK_IMAGE1 || requestCode == PICK_IMAGE2 || requestCode == PICK_IMAGE3 || requestCode == PICK_IMAGE4) {
                    imageUri = data.getData();
                    if (imageUri != null) {
                        loadImageWithPicasso(imageUri, imageView);
                        processImage(imageUri);
                        saveImagePath(imageUri, requestCode);
                    } else {
                        Toast.makeText(this, "Failed to get image URI from gallery", Toast.LENGTH_SHORT).show();
                    }
                } else if (requestCode == TAKE_PHOTO1 || requestCode == TAKE_PHOTO2 || requestCode == TAKE_PHOTO3 || requestCode == TAKE_PHOTO4) {
                    imageUri = photoURI;
                    if (imageUri != null) {
                        loadImageWithPicasso(imageUri, imageView);
                        processImage(imageUri);
                        saveImagePath(imageUri, requestCode);
                    } else {
                        Toast.makeText(this, "Failed to get image URI from camera", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                Toast.makeText(this, "Data is null", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Result not OK", Toast.LENGTH_SHORT).show();
        }
    }


    private void loadImageWithPicasso(Uri uri, ImageView imageView) {
        Picasso.get()
                .load(uri)
                .placeholder(R.drawable.bg)
                .error(R.drawable.baseline_photo_camera_24)
                .into(imageView);
    }

    private void saveImagePath(Uri imageUri, int requestCode) {
        if (imageUri == null) {
            Toast.makeText(this, "Invalid image URI", Toast.LENGTH_SHORT).show();
            return;
        }
        String imagePath = imageUri.toString();

        switch (requestCode) {
            case PICK_IMAGE1:
            case TAKE_PHOTO1:
                aadharFrontPath = imagePath;
                break;
            case PICK_IMAGE2:
            case TAKE_PHOTO2:
                aadharBackPath = imagePath;
                break;
            case PICK_IMAGE3:
            case TAKE_PHOTO3:
                panPath = imagePath;
                break;
            case PICK_IMAGE4:
            case TAKE_PHOTO4:
                documentPath = imagePath;
                break;
            default:
                Toast.makeText(this, "Unexpected request code: " + requestCode, Toast.LENGTH_SHORT).show();
                break;
        }
    }


    private File getFileFromUri(Uri uri) {
        String fileName = "image_" + System.currentTimeMillis() + ".jpg";
        File file = new File(getCacheDir(), fileName);

        try (InputStream inputStream = getContentResolver().openInputStream(uri);
             OutputStream outputStream = new FileOutputStream(file)) {

            if (inputStream == null) {
                Log.e("getFileFromUri", "InputStream is null for URI: " + uri.toString());
                return null;
            }

            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }

        } catch (IOException e) {
            Log.e("getFileFromUri", "Error while converting Uri to File: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        return file;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                Toast.makeText(this, "Camera permission is required", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void permissionCheck() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA}, 1);
            }
        }
    }



    private void uploadKyC() {
        showLoading();
        RequestBody userId = RequestBody.create(MultipartBody.FORM, PreferencesManager.getInstance(this).getUserId());
        RequestBody documentNumber = RequestBody.create(MultipartBody.FORM, binding.accountNumber.getText().toString());
        RequestBody panNumber = RequestBody.create(MultipartBody.FORM, binding.PanCardNumber.getText().toString());
        RequestBody adharNumber = RequestBody.create(MultipartBody.FORM, binding.adharNumber.getText().toString());
        RequestBody accountHolderName = RequestBody.create(MultipartBody.FORM, binding.accountHolderName.getText().toString());
        RequestBody bankName = RequestBody.create(MultipartBody.FORM, binding.bankName.getText().toString());
        RequestBody ifscCode = RequestBody.create(MultipartBody.FORM, binding.ifscCode.getText().toString());
        RequestBody bankBranch = RequestBody.create(MultipartBody.FORM, binding.branchName.getText().toString());

        File fileAadharFront = getFileFromUri(Uri.parse(aadharFrontPath));
        File fileAadharBack = getFileFromUri(Uri.parse(aadharBackPath));
        File filePan = getFileFromUri(Uri.parse(panPath));
        File fileDocument = getFileFromUri(Uri.parse(documentPath));

        Log.d("uploadKyC", "File AadharFront: " + (fileAadharFront != null ? fileAadharFront.getAbsolutePath() : "null"));
        Log.d("uploadKyC", "File AadharBack: " + (fileAadharBack != null ? fileAadharBack.getAbsolutePath() : "null"));
        Log.d("uploadKyC", "File Pan: " + (filePan != null ? filePan.getAbsolutePath() : "null"));
        Log.d("uploadKyC", "File Document: " + (fileDocument != null ? fileDocument.getAbsolutePath() : "null"));

        MultipartBody.Part bodyAadharFront = fileAadharFront != null ?
                MultipartBody.Part.createFormData("AdharImage", fileAadharFront.getName(), RequestBody.create(MediaType.parse("image/jpeg"), fileAadharFront)) : null;
        MultipartBody.Part bodyAadharBack = fileAadharBack != null ?
                MultipartBody.Part.createFormData("AdharBacksideImage", fileAadharBack.getName(), RequestBody.create(MediaType.parse("image/jpeg"), fileAadharBack)) : null;
        MultipartBody.Part bodyPan = filePan != null ?
                MultipartBody.Part.createFormData("PanImage", filePan.getName(), RequestBody.create(MediaType.parse("image/jpeg"), filePan)) : null;
        MultipartBody.Part bodyDocument = fileDocument != null ?
                MultipartBody.Part.createFormData("DocumentImage", fileDocument.getName(), RequestBody.create(MediaType.parse("image/jpeg"), fileDocument)) : null;

        ApiServices apiServices = RetrofitClient.getClient("https://abdolphininfratech.com/").create(ApiServices.class);

        Call<ResKYCUPLOAD> call = apiServices.UploadKyc(
                userId,
                documentNumber,
                panNumber,
                adharNumber,
                accountHolderName,
                bankName,
                ifscCode,
                bankBranch,
                bodyAadharFront,
                bodyAadharBack,
                bodyPan,
                bodyDocument
        );

        call.enqueue(new Callback<ResKYCUPLOAD>() {
            @Override
            public void onResponse(Call<ResKYCUPLOAD> call, Response<ResKYCUPLOAD> response) {
                if (response.isSuccessful() && response.body() != null) {
                    hideLoading();
                    Toast.makeText(KYCUploadActivity.this, "Document Uploaded Successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(KYCUploadActivity.this, "Response unsuccessful: " + response.message(), Toast.LENGTH_SHORT).show();
                    Log.e("Response Error", response.toString());
                }
            }

            @Override
            public void onFailure(Call<ResKYCUPLOAD> call, Throwable t) {
                Toast.makeText(KYCUploadActivity.this, "Upload Failed: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Upload Error", t.toString());
            }
        });
    }


    private MultipartBody.Part createMultipartBodyPart(String partName, String filePath) {
        if (filePath != null && !filePath.isEmpty()) {
            File file = new File(filePath);
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), file);
            return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
        }
        return null;
    }


    private void getKycList() {
        ReqUploadKycList requestObject = new ReqUploadKycList();
        try {
            requestObject.setUserID(Integer.parseInt(PreferencesManager.getInstance(this).getUserId()));
        } catch (NumberFormatException e) {
            Log.e("API_ERROR", "Invalid user ID format", e);
            return;
        }
        LoggerUtil.logItem(requestObject);
        ApiServices apiServices = RetrofitClient.getClient("https://abdolphininfratech.com/").create(ApiServices.class);
        Call<ResUploadKycList> call = apiServices.getKYCList(requestObject);  // Make sure this matches your ApiServices method
        call.enqueue(new Callback<ResUploadKycList>() {
            @Override
            public void onResponse(Call<ResUploadKycList> call, Response<ResUploadKycList> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ResUploadKycList result = response.body();
                    List<LstKycdocument> kycDocuments = result.getLstKycdocuments();
                    if (kycDocuments != null && !kycDocuments.isEmpty()) {
                        LstKycdocument lstKycDocument = kycDocuments.get(0);

                        binding.adharNumber.setText(lstKycDocument.getAdharNumber());
                        binding.accountNumber.setText(lstKycDocument.getDocumentNumber());
                        binding.PanCardNumber.setText(lstKycDocument.getPanNumber());
                        binding.accountHolderName.setText(lstKycDocument.getBankBranch());
                        binding.branchName.setText(lstKycDocument.getBankBranch());
                        binding.bankName.setText(lstKycDocument.getBankName());
                        binding.ifscCode.setText(lstKycDocument.getiFSCCode());

                        binding.adharfrontStatus.setText("Status: " + lstKycDocument.getAdharStatus());
                        binding.adharbackStatus.setText("Status: " + lstKycDocument.getAdharStatus());
                        binding.panStatus.setText("Status: " + lstKycDocument.getPanStatus());
                        binding.DocStatus.setText("Status: " + lstKycDocument.getDocumentStatus());

                        if ("Approved".equals(lstKycDocument.getDocumentStatus())) {
                            hideAllEditingElements();
                        } else {
                            showAllEditingElements();
                        }

                        loadImage(binding.adharFront, lstKycDocument.getAdharImage());
                        loadImage(binding.panImage, lstKycDocument.getPanImage());
                        loadImage(binding.DocImage, lstKycDocument.getDocumentImage());
                        loadImage(binding.adharback, lstKycDocument.getAdharBacksideImage());
                    }

                } else {
                    Log.e("API_ERROR", "Response unsuccessful or empty body");
                }
            }

            @Override
            public void onFailure(Call<ResUploadKycList> call, Throwable t) {
                Log.e("API_ERROR", "Request failed", t);
            }
        });
    }

    private void hideAllEditingElements() {
        binding.camera.setVisibility(View.GONE);
        binding.gallery.setVisibility(View.GONE);
        binding.camera1.setVisibility(View.GONE);
        binding.gallery2.setVisibility(View.GONE);
        binding.pancamera.setVisibility(View.GONE);
        binding.pangallery.setVisibility(View.GONE);
        binding.Doccamera.setVisibility(View.GONE);
        binding.docgallery.setVisibility(View.GONE);
        binding.submitbtn.setVisibility(View.GONE);

        setFieldsFocusable(false);
    }

    private void showAllEditingElements() {
        binding.camera.setVisibility(View.VISIBLE);
        binding.gallery.setVisibility(View.VISIBLE);
        binding.camera1.setVisibility(View.VISIBLE);
        binding.gallery2.setVisibility(View.VISIBLE);
        binding.pancamera.setVisibility(View.VISIBLE);
        binding.pangallery.setVisibility(View.VISIBLE);
        binding.Doccamera.setVisibility(View.VISIBLE);
        binding.docgallery.setVisibility(View.VISIBLE);
        binding.submitbtn.setVisibility(View.VISIBLE);

        setFieldsFocusable(true);
    }

    private void setFieldsFocusable(boolean focusable) {
        binding.accountNumber.setFocusable(focusable);
        binding.adharNumber.setFocusable(focusable);
        binding.PanCardNumber.setFocusable(focusable);
        binding.branchName.setFocusable(focusable);
        binding.bankName.setFocusable(focusable);
        binding.ifscCode.setFocusable(focusable);
    }

    private void loadImage(ImageView imageView, String imagePath) {
        if (imagePath != null && !imagePath.isEmpty()) {
            Picasso.get()
                    .load(BASE_URL + imagePath.substring(1))
                    .placeholder(R.drawable.box_bg)
                    .into(imageView);
        }


    }


    private void loadImageIntoImageView(String imagePath, ImageView imageView) {
        if (!TextUtils.isEmpty(imagePath)) {
            Picasso.get()
                    .load(new File(imagePath))
                    .placeholder(R.drawable.bg)
                    .error(R.drawable.baseline_photo_camera_24)
                    .into(imageView);
        } else {
            Toast.makeText(this, "Image path is empty", Toast.LENGTH_SHORT).show();
        }
    }


    private Bitmap getBitmapFromUri(Uri uri) {
        try {
            InputStream inputStream = getContentResolver().openInputStream(uri);
            return BitmapFactory.decodeStream(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void saveImageToInternalStorage(Uri imageUri) {
        File file = getFileFromUri(imageUri);
        if (file != null) {
            File internalFile = new File(getFilesDir(), "saved_image.jpg");
            try {
                InputStream inputStream = new FileInputStream(file);
                OutputStream outputStream = new FileOutputStream(internalFile);

                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }

                inputStream.close();
                outputStream.close();
                Toast.makeText(this, "Image saved to internal storage", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Failed to get file from URI", Toast.LENGTH_SHORT).show();
        }
    }

    private void processImage(Uri imageUri) {
        File file = getFileFromUri(imageUri);
        if (file != null) {
        } else {
            Toast.makeText(this, "Failed to get file from URI", Toast.LENGTH_SHORT).show();
        }
    }





}