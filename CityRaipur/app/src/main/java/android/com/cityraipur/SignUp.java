package android.com.cityraipur;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    public static final String LOG_TAG=SignUp.class.getName();
    private Button regButton;
    private EditText username,useremail,userphonenumber,userpassword,usercpassword;
    private String name,email,mnumber,password,cpassword;
    AlertDialog.Builder builder;
    private static final String rgstrUrl="https://www.directionclasses.com/eot/userRegisteration.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        builder=new AlertDialog.Builder(SignUp.this);
        username = (EditText)findViewById(R.id.username);
        useremail = (EditText)findViewById(R.id.useremail);
        userphonenumber = (EditText)findViewById(R.id.userphonenumber);
        userpassword = (EditText)findViewById(R.id.userpassword);
        usercpassword = (EditText)findViewById(R.id.usercpassword);
        regButton = (Button)findViewById(R.id.register);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=(String)username.getText().toString();
                email=(String)useremail.getText().toString();
                mnumber=(String)userphonenumber.getText().toString();
                password=(String)userpassword.getText().toString();
                cpassword=(String)usercpassword.getText().toString();

                if(name=="" || email=="" ||mnumber==""||name.isEmpty()||email.isEmpty()||mnumber.isEmpty()){
                   builder.setTitle("Field Must Not Be Empty");
                    builder.setMessage("PLease Fill All The Field");
                    displayAlert("input_error");
                }
                else{
                    if (!password.equals(cpassword)){
                        builder.setTitle("Something Went Wrong");
                        builder.setMessage("Passwords are Not Matching");
                        displayAlert("input_error");
                    }
                    else {

                        StringRequest stringRequest=new StringRequest(Request.Method.POST, rgstrUrl, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                Log.e(LOG_TAG,"response"+response);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Log.e(LOG_TAG,"error"+error.toString());
                            }
                        }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String,String> params=new HashMap<String, String>();
                                Log.e(LOG_TAG,"dibk");
                                params.put("email",email);
                                params.put("name",name);
                                params.put("number",mnumber);
                                params.put("password",password);
                                return params;
                            }
                        };
                        MySingleton.getInstance(SignUp.this).addToRequestQueue(stringRequest);
                    }
                }

            }
        });


    }

    public void displayAlert(final String code){

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                        if (code.equals("input_error")){
                                userpassword.setText("");
                                usercpassword.setText("");
                        }
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
