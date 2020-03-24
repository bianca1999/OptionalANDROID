package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myshop.database.Product;

import java.util.List;

public class ShowProductsActivity extends AppCompatActivity {
    private TextView txtInfo;

   @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_show_products);
       txtInfo=findViewById(R.id.text_display_info);
        List<Product> products=MainActivity.appDatabase.myDao().getUsers();

        String info= "";

        for(Product product: products){
            int id=product.getId();
            String name=product.getName();
            String description=product.getDescription();
            String price=product.getPrice();

            info=info+ "\n\n\n"+"ID :"+id+"\nName :"+name+
                    "\nDescription :"+description+
                    "\n     Price :"+price;
        }

        txtInfo.setText(info);
   }
}
