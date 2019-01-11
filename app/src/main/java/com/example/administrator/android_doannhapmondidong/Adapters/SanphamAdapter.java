package com.example.administrator.android_doannhapmondidong.Adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.android_doannhapmondidong.Models.Sanpham;
import com.example.administrator.android_doannhapmondidong.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanphamAdapter extends BaseAdapter {

    Context context;
    ArrayList<Sanpham> arrayListSanpham;

    public SanphamAdapter(Context context, ArrayList<Sanpham> arrayListSanpham) {
        this.context = context;
        this.arrayListSanpham = arrayListSanpham;
    }

    @Override
    public int getCount() {
        return arrayListSanpham.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListSanpham.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        public TextView txtTenSanpham, txtGiaSanpham, txtMoTaSanpham;
        public ImageView imgSanpham;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_sanpham, null);
            viewHolder.txtTenSanpham = convertView.findViewById(R.id.textviewtensanpham);
            viewHolder.txtGiaSanpham = convertView.findViewById(R.id.textviewgiasanpham);
            viewHolder.txtMoTaSanpham = convertView.findViewById(R.id.textviewmotasanpham);
            viewHolder.imgSanpham = convertView.findViewById(R.id.imageviewsanpham);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Sanpham sanpham = (Sanpham) getItem(position);
        viewHolder.txtTenSanpham.setText(sanpham.getTenqt());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGiaSanpham.setText("Giá: " + decimalFormat.format(Integer.parseInt(sanpham.getGiaqt())) + " VNĐ");
        viewHolder.txtMoTaSanpham.setText(sanpham.getMota());
        viewHolder.txtMoTaSanpham.setMaxLines(2);
        viewHolder.txtMoTaSanpham.setEllipsize(TextUtils.TruncateAt.END);
        Picasso.get().load(sanpham.getHinhanhqt())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imgSanpham);

        return convertView;
    }
}
