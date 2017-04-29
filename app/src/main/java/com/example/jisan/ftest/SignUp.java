package com.example.jisan.ftest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText etext;
    EditText ptext;
    Button upSign;

    FirebaseAuth upSignAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etext=(EditText) findViewById(R.id.editmail);
        ptext=(EditText) findViewById(R.id.editpass);
        upSign=(Button) findViewById(R.id.up_sign);
        upSignAuth= FirebaseAuth.getInstance();

        upSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String upMail = etext.getText().toString();
                String upPass= ptext.getText().toString();
                upSignAuth.createUserWithEmailAndPassword(upMail,upPass).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                    }
                });
            }
        });
    }
}
