package com.example.commerce.adapter.shop;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.commerce.R;
import com.example.commerce.bean.ShopPingBean;

import java.util.ArrayList;

public class ShopCartAdapter extends RecyclerView.Adapter {

    private PriceCallBackListener priceCallBackListener;

    private ArrayList<ShopPingBean.DataDTO.CartListDTO> cartList;

    public ShopCartAdapter(ArrayList<ShopPingBean.DataDTO.CartListDTO> cartList) {
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shopping, parent, false);

        return new BZViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        BZViewHolder bzViewHolder = (BZViewHolder) holder;

        bzViewHolder.shop_cart_item_cb.setChecked(cartList.get(position).isChecked());

        Glide.with(holder.itemView.getContext()).load(cartList.get(position).getList_pic_url()).into(bzViewHolder.shop_cart_item_iamge);
        bzViewHolder.shop_cart_name.setText(cartList.get(position).getGoods_name());
        bzViewHolder.shop_cart_price.setText("￥"+cartList.get(position).getRetail_price());
        bzViewHolder.shop_cart_count.setText("X"+cartList.get(position).getNumber());


        bzViewHolder.shop_cart_item_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(cartList.get(position).isChecked()){
                    bzViewHolder.shop_cart_item_cb.setChecked(false);
                    cartList.get(position).setChecked(false);
                }else{
                    bzViewHolder.shop_cart_item_cb.setChecked(true);
                    cartList.get(position).setChecked(true);
                }
                priceCallBackListener.priceChange();

            }
        });


    }


    public void setPriceListener(PriceCallBackListener priceListener){
        priceCallBackListener = priceListener;
    }

    public interface PriceCallBackListener{
        void priceChange();

    }


    @Override
    public int getItemCount() {
        return cartList.size();
    }


    class BZViewHolder extends RecyclerView.ViewHolder {

        public CheckBox shop_cart_item_cb;
        public ImageView shop_cart_item_iamge;
        public TextView shop_cart_name;
        public TextView shop_cart_price;
        public TextView shop_cart_count;

        public BZViewHolder(@NonNull View itemView) {
            super(itemView);
            shop_cart_item_cb = itemView.findViewById(R.id.shop_cart_item_cb);
            shop_cart_item_iamge = itemView.findViewById(R.id.shop_cart_item_iamge);
            shop_cart_name = itemView.findViewById(R.id.shop_cart_name);
            shop_cart_price = itemView.findViewById(R.id.shop_cart_price);
            shop_cart_count = itemView.findViewById(R.id.shop_cart_count);

        }
    }


}

