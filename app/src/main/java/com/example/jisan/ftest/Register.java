package com.example.jisan.ftest;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Register extends AppCompatActivity {

    EditText rName;
    EditText rLocation;
    EditText rBloodTpe;
    EditText rContact;
    Button rBtn;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        rName=(EditText) findViewById(R.id.name);
        rLocation=(EditText) findViewById(R.id.location);
        rBloodTpe=(EditText) findViewById(R.id.blood);
        rContact=(EditText) findViewById(R.id.contact);
        rBtn=(Button) findViewById(R.id.regBtn);
        mDatabase= FirebaseDatabase.getInstance().getReference();

        rBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=rName.getText().toString().trim();
                String location=rLocation.getText().toString().trim();
                String bloodType=rBloodTpe.getText().toString().trim();
                String contact=rContact.getText().toString().trim();
                HashMap<String,String> dataMap= new HashMap<String, String>();
                dataMap.put("Name",name);
                dataMap.put("Location",location);
                dataMap.put("Blood TYPE",bloodType);
                dataMap.put("Contact",contact);
                mDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Register.this,"You just Completed First stage to save lives!!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this,BloodBankPage.class));
                        }
                        else {
                            Toast.makeText(Register.this,"Your Data didn't stored... Please try Agrain ..",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
