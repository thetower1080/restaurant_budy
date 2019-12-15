package com.group.project.restaurantbuddy.ui.cart;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.group.project.restaurantbuddy.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private List<String[]> mDataset;
    private FragmentActivity activity;

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_cart_name, txt_price;
        public ImageView img_cart_count;
        public View parentView;

        public void setTxt_cart_name(TextView txt_cart_name) {
            this.txt_cart_name = txt_cart_name;
        }


        public CartViewHolder(View itemView) {

            super(itemView);
            txt_cart_name = (TextView) itemView.findViewById(R.id.cart_item_name);
            txt_price = (TextView) itemView.findViewById(R.id.cart_item_Price);
            img_cart_count = (ImageView) itemView.findViewById(R.id.cart_item_count);
        }



    }

    public CartAdapter(List<String[]> itemList, FragmentActivity _activity) {

        mDataset = itemList;
        activity = _activity;
        }

        @Override
        public CartAdapter.CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.cart_layout, parent, false);
            return new CartViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(CartViewHolder holder, final int position) {
            Locale locale = new Locale("en", "US");
            NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
            //int price = (Integer.parseInt(mDataset.get(position).getPrice())) * (Interger.parseInt(listData.get(position).getQuantity()));
           // holder.txt_price.setText(fmt.format(price));
            //holder.txt_cart_name.setText(listData.get(position).getProductName());
            holder.txt_cart_name.setText(mDataset.get(position)[0]);

            holder.txt_price.setText("$" + mDataset.get(position)[1]);
            Glide.with(holder.img_cart_count).load(mDataset.get(position)[3]).into(holder.img_cart_count);



        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }


    }
