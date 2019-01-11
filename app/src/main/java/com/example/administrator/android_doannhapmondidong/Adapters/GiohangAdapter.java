package com.example.administrator.android_doannhapmondidong.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.android_doannhapmondidong.Activities.GiohangActivity;
import com.example.administrator.android_doannhapmondidong.Models.Donhang;
import com.example.administrator.android_doannhapmondidong.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GiohangAdapter extends BaseAdapter {

    Context context;
    ArrayList<Donhang> giohang;

    public GiohangAdapter(Context context, ArrayList<Donhang> giohang) {
        this.context = context;
        this.giohang = giohang;
    }

    @Override
    public int getCount() {
        return giohang.size();
    }

    @Override
    public Object getItem(int position) {
        return giohang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        public TextView txtTenSanpham, txtGiaSanpham, txtSoluongSanpham;
        public ImageView imgSanpham;
        public Button btntru, btncong;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_giohang, null);
            viewHolder.txtTenSanpham = convertView.findViewById(R.id.textviewtensanphamgiohang);
            viewHolder.txtGiaSanpham = convertView.findViewById(R.id.textviewgiasanphamgiohang);
            viewHolder.txtSoluongSanpham = convertView.findViewById(R.id.textviewsoluong);
            viewHolder.imgSanpham = convertView.findViewById(R.id.imageviewsanphamgiohang);
            viewHolder.btntru = convertView.findViewById(R.id.buttontru);
            viewHolder.btncong = convertView.findViewById(R.id.buttoncong);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Donhang donhang = (Donhang) getItem(position);
        viewHolder.txtTenSanpham.setText(donhang.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGiaSanpham.setText("Giá: " + decimalFormat.format(donhang.getGiasp()) + " VNĐ");
        viewHolder.txtSoluongSanpham.setText(donhang.getSoluongsp() + "");
        Picasso.get().load(donhang.getHinhsp())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imgSanpham);

        viewHolder.btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (donhang.getSoluongsp() - 1 == 0){
                    GiohangActivity.DeleteDonhang(donhang);
                }
                else {
                    donhang.setSoluongsp(donhang.getSoluongsp() - 1);
                    GiohangActivity.giohangAdapter.notifyDataSetChanged();
                    GiohangActivity.CalculateTongtien();
                }
            }
        });

        viewHolder.btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (donhang.getSoluongsp() < 10) {
                    donhang.setSoluongsp(donhang.getSoluongsp() + 1);
                    GiohangActivity.giohangAdapter.notifyDataSetChanged();
                    GiohangActivity.CalculateTongtien();
                }
            }
        });

        return convertView;
    }
}