package com.example.myshop;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private AlertDialog alertDialog = null;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        final AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
        final View view = getLayoutInflater().inflate(R.layout.custom_layout,null);

        alert.setTitle("Login");
        alert.setView(view);
        alert.setCancelable(false);
        alert.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                EditText user_name = view.findViewById(R.id.user_name);
                EditText user_pass = view.findViewById(R.id.user_pass);


                if(user_name.getText().toString().compareTo("admin")==0 && user_pass.getText().toString().compareTo("admin")==0){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(LoginActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        alertDialog = alert.create();
        alertDialog.show();


    }







    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause","onStart invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked");
        ContentValues values = new ContentValues();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoked");
    }


}
