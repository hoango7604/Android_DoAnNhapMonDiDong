package com.example.administrator.android_doannhapmondidong.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.administrator.android_doannhapmondidong.Adapters.LoaispAdapter;
import com.example.administrator.android_doannhapmondidong.Adapters.SanphamnoibatAdapter;
import com.example.administrator.android_doannhapmondidong.Models.Donhang;
import com.example.administrator.android_doannhapmondidong.Models.Loaisp;
import com.example.administrator.android_doannhapmondidong.Models.Sanpham;
import com.example.administrator.android_doannhapmondidong.R;
import com.example.administrator.android_doannhapmondidong.Services.APIService;
import com.example.administrator.android_doannhapmondidong.Utils.APIUtils;
import com.example.administrator.android_doannhapmondidong.Utils.CheckConnection;
import com.example.administrator.android_doannhapmondidong.Utils.SwitchScreen;
import com.example.administrator.android_doannhapmondidong.Utils.ToastScreen;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    ListView listViewManHinhChinh;

    public static ArrayList<Loaisp> mangloaisp;
    LoaispAdapter loaispAdapter;

    ArrayList<Sanpham> mangsanphamnoibat;
    SanphamnoibatAdapter sanphamnoibatAdapter;

    public static ArrayList<Donhang> giohang;

    public static APIService apiService;

    public static String tenkhachhang = "";
    public static String diachi = "";
    public static String sodienthoai = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        if (CheckConnection.isOnline(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();

            GetDuLieuLoaisp();
            GetDuLieuSanphammoinhat();

            CatchOnItemListView();
        }
        else {
            ToastScreen.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối!");
            finish();
        }
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

    private void CatchOnItemListView() {
        listViewManHinhChinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        SwitchScreen.SwitchView(getApplicationContext(), SanphamActivity.class, "idloaisanpham", mangloaisp.get(position).getId());
                        break;
                    case 5:
                        SwitchScreen.SwitchView(getApplicationContext(), ThongTinActivity.class, null, null);
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }

    private void GetDuLieuSanphammoinhat() {
        apiService.getSanphammoinhat().enqueue(new Callback<ArrayList<Sanpham>>() {
            @Override
            public void onResponse(Call<ArrayList<Sanpham>> call, Response<ArrayList<Sanpham>> response) {
                if (response.isSuccessful()){
//                    ToastScreen.ShowToast_Short(getApplicationContext(), response.body().size() + "");

                    ArrayList<Sanpham> Response = response.body();
                    mangsanphamnoibat.addAll(Response);

                    sanphamnoibatAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Sanpham>> call, Throwable t) {
                ToastScreen.ShowToast_Short(getApplicationContext(), t.getMessage());
                Log.d("Retrofit Failure", t.getMessage());
            }
        });
    }

    private void GetDuLieuLoaisp() {
        apiService.getLoaisp().enqueue(new Callback<ArrayList<Loaisp>>() {
            @Override
            public void onResponse(Call<ArrayList<Loaisp>> call, Response<ArrayList<Loaisp>> response) {
                if (response.isSuccessful()){
//                    ToastScreen.ShowToast_Short(getApplicationContext(), response.body().size() + "");

                    ArrayList<Loaisp> Response = response.body();
                    mangloaisp.addAll(Response);

                    mangloaisp.add(new Loaisp("5", "Thông tin", "http://icons.iconarchive.com/icons/graphicloads/100-flat-2/256/contacts-icon.png"));

                    loaispAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Loaisp>> call, Throwable t) {
                ToastScreen.ShowToast_Short(getApplicationContext(), t.getMessage());
                Log.d("Retrofit Failure", t.getMessage());
            }
        });
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangFlipper = new ArrayList<>();
        mangFlipper.add("http://avianinfluenza.org.vn/wp-content/uploads/2017/05/19428113052_a3f99660f1_h-815x459.jpg");
        mangFlipper.add("https://img.alicdn.com/imgextra/i3/2555784794/TB2AKVWXTwX61Bjy1zcXXX9RXXa_!!2555784794.jpg");
        mangFlipper.add("https://img.alicdn.com/imgextra/i1/2555784794/TB2latWXNQX61BjSspbXXcK0XXa_!!2555784794.jpg");
        mangFlipper.add("http://dulichfestival.com.vn/CustomFolder/images/bieutuongnhatban.jpg");
        mangFlipper.add("https://i.imgur.com/1Q6OJrT.jpg");

        for (int i = 0; i < mangFlipper.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mangFlipper.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }

        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);

        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);

        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    @SuppressLint("RestrictedApi")
    private void ActionBar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDefaultDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void AnhXa() {
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbarManHinhChinh);
        viewFlipper = findViewById(R.id.viewFlipperManHinhChinh);
        recyclerView = findViewById(R.id.recyclerviewManHinhChinh);
        navigationView = findViewById(R.id.navigationviewManHinhChinh);
        listViewManHinhChinh = findViewById(R.id.listviewManHinhChinh);

        mangloaisp = new ArrayList<>();
        mangloaisp.add(0, new Loaisp("0", "Trang chính", "http://icons.iconarchive.com/icons/graphicloads/100-flat/256/home-icon.png"));

        loaispAdapter = new LoaispAdapter(mangloaisp, getApplicationContext());
        listViewManHinhChinh.setAdapter(loaispAdapter);

        mangsanphamnoibat = new ArrayList<>();
        sanphamnoibatAdapter = new SanphamnoibatAdapter(getApplicationContext(), mangsanphamnoibat);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setAdapter(sanphamnoibatAdapter);

        apiService = APIUtils.getAPIService();

        if (giohang == null){
            giohang = new ArrayList<>();
        }
    }
}
