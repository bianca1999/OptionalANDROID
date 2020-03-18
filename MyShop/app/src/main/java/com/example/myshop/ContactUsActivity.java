package com.example.myshop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ContactUsActivity extends AppCompatActivity {
    private AlertDialog alertDialog = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        final TextView phone=(TextView) findViewById((R.id.phone));
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:0752881934");
                Intent callIntent= new Intent(Intent.ACTION_DIAL,number);
                startActivity(callIntent);
            }
        });

        /*final TextView email=(TextView) findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL,"calancea.bianca15@gmail.com");
                mail.putExtra(Intent.EXTRA_TEXT,"Help us");
                mail.putExtra(Intent.EXTRA_SUBJECT,"Problem report");
                mail.setType("plain/text");
                startActivity(mail);
            }
        });*/

        final AlertDialog.Builder alert = new AlertDialog.Builder(ContactUsActivity.this);
        final View view = getLayoutInflater().inflate(R.layout.contact_layout,null);

        alert.setTitle("Give FeedBack");
        alert.setView(view);
        alert.setCancelable(true);
        alert.setNeutralButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                EditText user_name = view.findViewById(R.id.user_name);
                EditText message = view.findViewById(R.id.message);
                    Intent intent = new Intent(ContactUsActivity.this,ContactUsActivity.class);
                    startActivity(intent);

            }
        });

        alertDialog = alert.create();
        alertDialog.show();

    }
}
