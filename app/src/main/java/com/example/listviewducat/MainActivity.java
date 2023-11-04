package com.example.listviewducat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.listviewducat.Adapter.CustomAdapter;
import com.example.listviewducat.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
   static String [] product_name = {"Vivo v29", "Lenevo i3","Mouse"};
   static String [] price = {"₹15000","₹25000","₹350"};
    static int [] image = {R.drawable.vivo29,R.drawable.tv,R.drawable.mouse};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        // Adapter configuration
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this,product_name,price,image);
        mainBinding.listview.setAdapter(customAdapter);

        mainBinding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l){

               Intent intent = new Intent(MainActivity.this,SecondPage.class);
               intent.putExtra("index",i);
                startActivity(intent);
                //finish();
            }
        });



    }
}