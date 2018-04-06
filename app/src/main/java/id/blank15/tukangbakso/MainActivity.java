package id.blank15.tukangbakso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail=(EditText) findViewById(R.id.edit_text_email);
        editTextPassword=(EditText) findViewById(R.id.edit_text_password);
        buttonLogin=(Button) findViewById(R.id.button);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextEmail.getText().toString().isEmpty() &&
                        !editTextPassword.getText().toString().isEmpty()){
                    if (editTextEmail.getText().toString().equals("yudha@gmail.com") &&
                            editTextPassword.getText().toString().equals("1234")){
                        Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Email dan Password salah", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Field ada yang kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}