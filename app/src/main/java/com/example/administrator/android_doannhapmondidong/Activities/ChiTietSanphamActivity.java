package com.example.administrator.android_doannhapmondidong.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrator.android_doannhapmondidong.Models.Donhang;
import com.example.administrator.android_doannhapmondidong.Models.Sanpham;
import com.example.administrator.android_doannhapmondidong.R;
import com.example.administrator.android_doannhapmondidong.Utils.SwitchScreen;
import com.example.administrator.android_doannhapmondidong.Utils.ToastScreen;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class ChiTietSanphamActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView imgSanpham;
    TextView txtTenSanpham, txtGiaSanpham, txtMoTaSanpham;
    Spinner spinner;
    Button btnThemGioHang;
    Sanpham sanpham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_sanpham);

        AnhXa();
        ActionBar();
        GetInformation();
        CatchEventSpinner();
        CatchEventButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                SwitchScreen.SwitchView(getApplicationContext(), GiohangActivity.class, null, null);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void CatchEventButton() {
        btnThemGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soluong = Integer.parseInt(spinner.getSelectedItem().toString());

                boolean isExist = false;
                if (MainActivity.giohang.size() > 0){
                    for (int i = 0; i < MainActivity.giohang.size(); i++){
                        if (MainActivity.giohang.get(i).getIdsp() == Integer.parseInt(sanpham.getId())){
                            MainActivity.giohang.get(i).setSoluongsp(MainActivity.giohang.get(i).getSoluongsp() + soluong <= 10 ? MainActivity.giohang.get(i).getSoluongsp() + soluong : 10);
                            isExist = true;
                        }
                    }

                    if (!isExist) {
                        MainActivity.giohang.add(new Donhang(sanpham, soluong));
                    }
                }
                else {
                    MainActivity.giohang.add(new Donhang(sanpham, soluong));
                }

                ToastScreen.ShowToast_Short(getApplicationContext(), "Đã thêm vào giỏ hàng!");
            }
        });
    }

    private void CatchEventSpinner() {
        Integer[] soluong = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, soluong);
        spinner.setAdapter(arrayAdapter);
    }

    private void GetInformation() {
        sanpham = (Sanpham) getIntent().getSerializableExtra("sanpham");

        txtTenSanpham.setText(sanpham.getTenqt());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtGiaSanpham.setText("Giá: " + decimalFormat.format(Integer.parseInt(sanpham.getGiaqt())) + " VNĐ");
        txtMoTaSanpham.setText(sanpham.getMota());
        Picasso.get().load(sanpham.getHinhanhqt())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(imgSanpham);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void AnhXa() {
        toolbar = findViewById(R.id.toolbarManHinhChiTietSanpham);
        imgSanpham = findViewById(R.id.imageviewchitietsanpham);
        txtTenSanpham = findViewById(R.id.textviewtenchitietsanpham);
        txtGiaSanpham = findViewById(R.id.textviewgiachitietsanpham);
        txtMoTaSanpham = findViewById(R.id.textviewmotachitietsanpham);
        spinner = findViewById(R.id.spinnerchitietsanpham);
        btnThemGioHang = findViewById(R.id.buttonthemgiohang);
    }
}
