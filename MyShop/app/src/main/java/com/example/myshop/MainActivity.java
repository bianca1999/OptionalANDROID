package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;
public class MainActivity extends AppCompatActivity {
    int[] IMAGES = {R.drawable.rujmaybelline, R.drawable.rujmelkior, R.drawable.rimelmaybelline,R.drawable.rujmaybelline,R.drawable.eyelineringrid,R.drawable.paletalancome, R.drawable.rujmelkior,};
    String[] NAMES={"Ruj Maybelline","Ruj Melkior", "Rimel Maybelline","Ruj Maybelline", "Eyliner Liquid LANCOME ", "Paleta cu farduri LANCOME","Ruj Melkior"};
    String[] DESCRIPTION={"Descriere1","Descriere2","Descriere3","Descriere4","Descriere5","Descriere6","Descriere7"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView) findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "clicked item:" + position + " " + listView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.shop_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
            Intent intent;
            switch (item.getItemId()){

                case R.id.item1:
                    Toast.makeText(MainActivity.this,"Login selected",Toast.LENGTH_LONG).show();
                    intent = new Intent(MainActivity.this,LoginActivity.class);
                    //  intent.putExtra("Type",myList.getItemAtPosition(position).toString());
                    startActivity(intent);
                    return true;
                case R.id.item2:
                    Toast.makeText(MainActivity.this,"Products selected",Toast.LENGTH_LONG).show();
                    intent = new Intent(MainActivity.this,MainActivity.class);
                    //  intent.putExtra("Type",myList.getItemAtPosition(position).toString());
                    startActivity(intent);
                    return true;
                case R.id.item3:
                    intent = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.item4:
                    intent = new Intent(MainActivity.this,ContactUsActivity.class);
                    startActivity(intent);
                    return true;

            }
        return super.onOptionsItemSelected(item);
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
        Log.d("onPause","onPause invoked");
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

    public class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return NAMES[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getLayoutInflater().inflate(R.layout.layout,null);

            ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);
            TextView textView_name=(TextView)convertView.findViewById(R.id.textView_name);
            TextView textView_description=(TextView)convertView.findViewById(R.id.textView_description);

            imageView.setImageResource(IMAGES[position]);
            textView_name.setText(NAMES[position]);
            textView_description.setText(DESCRIPTION[position]);

            return convertView;
        }
    }




}



