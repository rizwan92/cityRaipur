package android.com.cityraipur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginOption extends AppCompatActivity {

    TextView sinup,login;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_option);
        sinup=(TextView)findViewById(R.id.sign_up_textview);
        login=(TextView)findViewById(R.id.log_in_textview);
        home=(Button)findViewById(R.id.home_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginOption.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        sinup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginOption.this,SignUp.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginOption.this,LogIn.class);
                startActivity(intent);
            }
        });



    }


}
