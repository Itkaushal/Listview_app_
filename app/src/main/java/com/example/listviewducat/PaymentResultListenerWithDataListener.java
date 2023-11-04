package com.example.listviewducat;

public interface PaymentResultListenerWithDataListener {
    void onPaymentSuccess(String s);

    void onPaymentError(int i, String s);
}
