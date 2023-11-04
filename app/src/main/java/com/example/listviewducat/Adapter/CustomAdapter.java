package com.example.listviewducat.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.listviewducat.MainActivity;
import com.example.listviewducat.databinding.CustomLayoutBinding;

public class CustomAdapter extends BaseAdapter {
    LayoutInflater inflater;
    String[] product_name;
    String[] price;
    int[] image;
    public CustomAdapter(MainActivity mainActivity, String[] product_name, String[] price, int[] image) {
        inflater= LayoutInflater.from(mainActivity);
        this.product_name = product_name;
        this.price = price;
        this.image = image;
    }
    @Override
    public int getCount() {
        return product_name.length;
    }
    @Override
    public Object getItem(int i) {
        return i;
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        CustomLayoutBinding customLayoutBinding = CustomLayoutBinding.inflate(inflater);
        customLayoutBinding.image.setBackgroundResource(image[i]);
        customLayoutBinding.name.setText(product_name[i]);
        customLayoutBinding.price.setText(price[i]);
        return customLayoutBinding.getRoot();
    }
}
