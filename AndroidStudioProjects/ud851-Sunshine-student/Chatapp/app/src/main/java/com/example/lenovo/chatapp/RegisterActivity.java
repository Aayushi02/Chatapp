package com.example.lenovo.chatapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
private EditText name, email,password;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        mAuth  = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
    }
    public void Signup(View view){
        final String name_content,email_content,password_content;
        name_content = name.getText().toString().trim();
        email_content = email.getText().toString().trim();
        password_content = password.getText().toString().trim();
        if(!TextUtils.isEmpty(name_content) && !TextUtils.isEmpty(email_content) && !TextUtils.isEmpty(password_content)){
            mAuth.createUserWithEmailAndPassword(email_content,password_content).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference current_user_db = mDatabase.child(user_id);
                    current_user_db.child("Name").setValue(name_content);
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                }
            });
        }
    }
    public void Login(){
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
    }
}
