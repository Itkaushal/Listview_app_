package com.example.listviewducat;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.listviewducat.databinding.ActivitySecondPageBinding;
import com.razorpay.Checkout;

import org.json.JSONObject;

public class SecondPage extends AppCompatActivity implements PaymentResultListenerWithDataListener {
    ActivitySecondPageBinding secondPageBinding;
    Checkout checkout = new Checkout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondPageBinding=ActivitySecondPageBinding.inflate(getLayoutInflater());
        setContentView(secondPageBinding.getRoot());

        int pos = getIntent().getIntExtra("index",0);
        secondPageBinding.imageview.setBackgroundResource(MainActivity.image[pos]);
        secondPageBinding.textview.setText(MainActivity.product_name[pos]);
        secondPageBinding.textview2.setText(MainActivity.price[pos]+"");

        /**
         * Preload payment resources
         */
        Checkout.preload(getApplicationContext());
        checkout.setKeyID("rzp_test_e1z8lc1JE5Vnvu");
        // ...

         //checkout.setKeyID("rzp_test_e1z8lc1JE5Vnvu");


        secondPageBinding.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPayment();

            }
        });

    }
    public void startPayment(){
        /**
         * Instantiate Checkout
         */



        /**
         * Set your logo here
         */
        checkout.setImage(R.drawable.kaushal);

        /**
         * Reference to current activity
         */
        final Activity activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject options = new JSONObject();

            options.put("name", "Kaushlendra Kumar");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg");
            options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", "50000");//pass amount in currency subunits
            options.put("prefill.email", "kaushal.kumar@example.com");
            options.put("prefill.contact","9953857495");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            checkout.open(activity, options);

        } catch(Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout",e);
        }

    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Success", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Error", Toast.LENGTH_SHORT).show();


    }
}