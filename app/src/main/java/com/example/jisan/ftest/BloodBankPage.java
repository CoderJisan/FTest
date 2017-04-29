package com.example.jisan.ftest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BloodBankPage extends AppCompatActivity {

    Button donorList;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank_page);
        donorList=(Button) findViewById(R.id.donorList);
        register=(Button) findViewById(R.id.registerList);

        donorList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BloodBankPage.this,DonorList.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BloodBankPage.this,Register.class));
            }
        });
    }
}
