package com.eru.and3_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText theme;
    EditText body;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        theme = findViewById(R.id.theme);
        body = findViewById(R.id.body);

        btn_send = findViewById(R.id.btn_send);

        btn_send.setOnClickListener(view -> {
            if(!email.getText().toString().isEmpty() && !theme.getText().toString().isEmpty()
                    && !body.getText().toString().isEmpty()){
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, body.getText().toString());

                    intent.setData(Uri.parse("mailto:"));
                    startActivity(intent);

            } else {
                Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            }
        });

    }
}