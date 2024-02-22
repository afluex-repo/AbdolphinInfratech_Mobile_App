package com.abdolphininfratech.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.abdolphininfratech.Activity.ContainerActivity;
import com.abdolphininfratech.Activity.Login;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.NetworkUtils;
import com.abdolphininfratech.constants.BaseFragment;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;

public class ChangePassword extends BaseFragment {

    Unbinder unbinder;
    EditText et_oldpassword,et_newpassword,et_cunfpassword;
    Button changepassword;
    String oldpassword,newpassword,cunfpassword;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.change_pasword, container, false);
        unbinder = ButterKnife.bind(this, view);

        et_oldpassword=view.findViewById(R.id.et_currentpassword);
        et_newpassword=view.findViewById(R.id.et_newpassword);
        et_cunfpassword=view.findViewById(R.id.et_cnfpassword);
        changepassword=view.findViewById(R.id.btn_changepassword);


        changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldpassword = et_oldpassword.getText().toString().trim();
                newpassword = et_newpassword.getText().toString().trim();
                cunfpassword = et_cunfpassword.getText().toString().trim();

                if (newpassword.equals(cunfpassword)) {

                    CunPassword();
                }
                else
                {
                    Toast.makeText(getContext(), "plz check match cunf password", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }

    public void CunPassword()
    {
        final  String ForgotPassword="http://test.abdolphininfratech.com/WebAPI/ChangePassword";
        StringRequest stringRequest=new StringRequest(Request.Method.POST,ForgotPassword, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    final String  status=jsonObject.getString("Status");
                    final String message=jsonObject.getString("SuccessMessage");
                    final String errormessage=jsonObject.getString("ErrorMessage");

                    if (status.equalsIgnoreCase("0") && message.equalsIgnoreCase("Password Changed Successfuly."))
                    {
                        Toast.makeText(getContext(), message+"", Toast.LENGTH_SHORT).show();
                      //  Intent I=new Intent(getContext(), Login.class);
                        //startActivity(I);
                        goToActivityWithFinish(context, Login.class, null);

                    }
                    else if (status.equalsIgnoreCase("1") && errormessage.equalsIgnoreCase("Old Password is not correct.."))
                    {
                        Toast.makeText(getContext(), errormessage+"", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error+"", Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parms = new HashMap<String, String>();
                parms.put("Pk_userId", PreferencesManager.getInstance(context).getUserId());
                parms.put("OldPassword",oldpassword);
                parms.put("NewPassword",newpassword);

                return parms;

            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }
}
