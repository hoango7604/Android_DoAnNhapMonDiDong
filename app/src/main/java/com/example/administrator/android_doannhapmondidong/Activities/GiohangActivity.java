package com.example.administrator.android_doannhapmondidong.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.android_doannhapmondidong.Adapters.GiohangAdapter;
import com.example.administrator.android_doannhapmondidong.Models.Donhang;
import com.example.administrator.android_doannhapmondidong.R;
import com.example.administrator.android_doannhapmondidong.Utils.ToastScreen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GiohangActivity extends AppCompatActivity {

    Toolbar toolbar;
    static ListView lvgiohang;
    static TextView txtthongbao, txttongtien;
    Button btnthanhtoan, btnlammoi;
    public static GiohangAdapter giohangAdapter;
    public static Context context;
    Dialog dialog;
    EditText edttenkhachhang, edtdiachi, edtsodienthoai;
    static Integer tongtien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);

        AnhXa();
        ActionBar();
        CheckData();
        CalculateTongtien();
        ButtonEvent();
    }

    public void onButtonXacnhanClick(View v) {
        MainActivity.tenkhachhang = edttenkhachhang.getText().toString();
        MainActivity.diachi = edtdiachi.getText().toString();
        MainActivity.sodienthoai = edtsodienthoai.getText().toString();

        if (!MainActivity.tenkhachhang.isEmpty() &&
            !MainActivity.diachi.isEmpty() &&
            !MainActivity.sodienthoai.isEmpty()) {
            MainActivity.apiService.postDonHang(MainActivity.tenkhachhang, MainActivity.diachi, Integer.parseInt(MainActivity.sodienthoai), tongtien).enqueue(new Callback<Integer>() {
                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    if (response.isSuccessful()) {
                        try {
                            Integer madonhang = Integer.parseInt(response.body().toString());

                            String JSONStringChitietDonhang = CreateJSONStringChitietDonhang(madonhang);
//                            JSONObject json = new JSONObject(JSONStringChitietDonhang);
                            JSONArray jsonArray = new JSONArray(JSONStringChitietDonhang);
                            MainActivity.apiService.postChitietDonhang(jsonArray).enqueue(new Callback<Integer>() {
                                @Override
                                public void onResponse(Call<Integer> call, Response<Integer> response) {
                                    if (response.isSuccessful()) {
                                        if (Integer.parseInt(response.body().toString()) == 1) {
                                            ToastScreen.ShowToast_Short(getApplicationContext(), "Xác nhận đơn hàng thành công. Đơn hàng đang chờ được duyệt");
                                            dialog.cancel();

                                            MainActivity.giohang.clear();
                                            giohangAdapter.notifyDataSetChanged();
                                            CheckData();
                                            CalculateTongtien();
                                        }
                                        else {
                                            ToastScreen.ShowToast_Short(getApplicationContext(), "Xác nhận đơn hàng thất bại. Vui lòng thử lại sau");
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<Integer> call, Throwable t) {
                                    Log.d("Chi tiet don hang", "onFailure: " + t.getMessage());
                                    ToastScreen.ShowToast_Short(getApplicationContext(), "Xác nhận đơn hàng thất bại. Vui lòng thử lại sau");
                                }
                            });
                        }
                        catch (NumberFormatException e) {
                            ToastScreen.ShowToast_Short(getApplicationContext(), "Xác nhận đơn hàng thất bại. Vui lòng thử lại sau");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            ToastScreen.ShowToast_Short(getApplicationContext(), "Xác nhận đơn hàng thất bại. Vui lòng thử lại sau");
                        }
                    }
                }

                @Override
                public void onFailure(Call<Integer> call, Throwable t) {
                    ToastScreen.ShowToast_Short(getApplicationContext(), "Xác nhận đơn hàng thất bại. Vui lòng thử lại sau");
                }
            });
        }
        else {
            ToastScreen.ShowToast_Short(getApplicationContext(), "Hãy điền đủ thông tin");
        }
    }

    private String CreateJSONStringChitietDonhang(Integer madonhang) {
        String result = "[";
        StringBuilder builder = new StringBuilder(result);
        for (int i = 0; i < MainActivity.giohang.size(); i++) {
            Donhang donhang = MainActivity.giohang.get(i);
            builder.append("{ \"madonhang\" : \"" + madonhang + "\", ");
            builder.append("\"masanpham\" : \"" + donhang.getIdsp() + "\", ");
            builder.append("\"tensanpham\" : \"" + donhang.getTensp() + "\", ");
            builder.append("\"giasanpham\" : \"" + donhang.getGiasp() + "\", ");
            builder.append("\"soluongsanpham\" : \"" + donhang.getSoluongsp() + "\" }");

            if (i < MainActivity.giohang.size() - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        result = builder.toString();

        return result;
    }

    public void onButtonHuyClick(View v) {
        dialog.cancel();
    }

    private void ButtonEvent() {
        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.giohang.size() > 0) {
                    dialog.show();

                    if (!MainActivity.tenkhachhang.isEmpty()) {
                        edttenkhachhang.setText(MainActivity.tenkhachhang);
                    }
                    if (!MainActivity.diachi.isEmpty()) {
                        edtdiachi.setText(MainActivity.diachi);
                    }
                    if (!MainActivity.sodienthoai.isEmpty()) {
                        edtsodienthoai.setText(MainActivity.sodienthoai);
                    }
                }
                else {
                    ToastScreen.ShowToast_Short(getApplicationContext(), "Giỏ hàng hiện tại chưa có sản phẩm để thanh toán");
                }
            }
        });

        btnlammoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Làm mới giỏ hàng?");
                builder.setMessage("Bạn muốn xóa toàn bộ sản phẩm?");
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Có",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.giohang.clear();
                                giohangAdapter.notifyDataSetChanged();
                                CheckData();
                                CalculateTongtien();
                                ToastScreen.ShowToast_Short(getApplicationContext(), "Đã làm mới giỏ hàng");
                            }
                        });

                builder.setNegativeButton(
                        "Không",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public static void DeleteDonhang(final Donhang donhang) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Xóa sản phẩm");
        builder.setMessage("Bạn muốn xóa sản phẩm?");
        builder.setCancelable(true);

        builder.setPositiveButton(
                "Có",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.giohang.remove(donhang);
                        giohangAdapter.notifyDataSetChanged();
                        CheckData();
                        CalculateTongtien();
                    }
                });

        builder.setNegativeButton(
                "Không",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void CalculateTongtien() {
        int sum = 0;

        for (int i = 0; i < MainActivity.giohang.size(); i++) {
            sum += MainActivity.giohang.get(i).getSoluongsp() * MainActivity.giohang.get(i).getGiasp();
        }

        tongtien = sum;
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txttongtien.setText(decimalFormat.format(tongtien) + " VNĐ");
    }

    private static void CheckData() {
        giohangAdapter.notifyDataSetChanged();

        if (MainActivity.giohang.size() <= 0){
            txtthongbao.setVisibility(View.VISIBLE);
            lvgiohang.setVisibility(View.INVISIBLE);
        }
        else {
            txtthongbao.setVisibility(View.INVISIBLE);
            lvgiohang.setVisibility(View.VISIBLE);
        }
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
        toolbar = findViewById(R.id.toolbarManHinhGiohang);
        lvgiohang = findViewById(R.id.listviewManHinhGiohang);
        txtthongbao = findViewById(R.id.textviewthongbao);
        txttongtien = findViewById(R.id.textviewtongtiengiohang);
        btnthanhtoan = findViewById(R.id.buttonthanhtoangiohang);
        btnlammoi = findViewById(R.id.buttonlammoigiohang);

        giohangAdapter = new GiohangAdapter(getApplicationContext(), MainActivity.giohang);
        lvgiohang.setAdapter(giohangAdapter);

        context = this;

        dialog = new Dialog(context);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.thongtinkhachhang_dialog_custom);

        edttenkhachhang = dialog.findViewById(R.id.edittexttenkhachhang);
        edtdiachi = dialog.findViewById(R.id.edittextdiachi);
        edtsodienthoai = dialog.findViewById(R.id.edittextsodienthoai);
    }
}
