package com.example.administrator.android_doannhapmondidong.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.android_doannhapmondidong.Activities.ChiTietSanphamActivity;
import com.example.administrator.android_doannhapmondidong.Models.Sanpham;
import com.example.administrator.android_doannhapmondidong.R;
import com.example.administrator.android_doannhapmondidong.Utils.SwitchScreen;
import com.example.administrator.android_doannhapmondidong.Utils.ToastScreen;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanphamnoibatAdapter extends RecyclerView.Adapter<SanphamnoibatAdapter.ItemHolder> {

    Context context;
    ArrayList<Sanpham> arrayListSanpham;

    public SanphamnoibatAdapter(Context context, ArrayList<Sanpham> arrayListSanpham) {
        this.context = context;
        this.arrayListSanpham = arrayListSanpham;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dong_sanphamnoibat, null);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        Sanpham sanpham = arrayListSanpham.get(i);
        itemHolder.txtTenSanpham.setText(sanpham.getTenqt());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        itemHolder.txtGiaSanpham.setText("Giá: " + decimalFormat.format(Integer.parseInt(sanpham.getGiaqt())) + " VNĐ");
        Picasso.get().load(sanpham.getHinhanhqt())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(itemHolder.imgHinhSanpham);
    }

    @Override
    public int getItemCount() {
        return arrayListSanpham.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imgHinhSanpham;
        public TextView txtTenSanpham, txtGiaSanpham;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhSanpham = itemView.findViewById(R.id.imageviewsanphamnoibat);
            txtTenSanpham = itemView.findViewById(R.id.textviewtensanphamnoibat);
            txtGiaSanpham = itemView.findViewById(R.id.textviewgiasanphamnoibat);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SwitchScreen.SwitchView(context, ChiTietSanphamActivity.class, "sanpham", arrayListSanpham.get(getLayoutPosition()));
                }
            });
        }
    }
}
