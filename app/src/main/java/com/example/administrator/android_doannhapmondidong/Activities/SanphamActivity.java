package com.example.administrator.android_doannhapmondidong.Activities;

import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.android_doannhapmondidong.Adapters.SanphamAdapter;
import com.example.administrator.android_doannhapmondidong.Models.Sanpham;
import com.example.administrator.android_doannhapmondidong.R;
import com.example.administrator.android_doannhapmondidong.Utils.SwitchScreen;
import com.example.administrator.android_doannhapmondidong.Utils.ToastScreen;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SanphamActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView lvSanpham;
    SanphamAdapter sanphamAdapter;
    View footerview;

    ArrayList<Sanpham> mangSanpham;
    int idLoaisp = 0;
    int page = 1;
    boolean isLoading = false;
    boolean isEndOfData = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanpham);
        
        AnhXa();
        ActionBar();
        GetData(page);
        LoadMoreData();
        ShowDetail();
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

    private void ShowDetail() {
        lvSanpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SwitchScreen.SwitchView(getApplicationContext(), ChiTietSanphamActivity.class, "sanpham", mangSanpham.get(position));
            }
        });
    }

    private void LoadMoreData() {
        lvSanpham.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (!isEndOfData){
                    if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0 && !isLoading){
                        lvSanpham.addFooterView(footerview);
                        isLoading = true;

                        new android.os.Handler().postDelayed(
                                new Runnable() {
                                    public void run() {
                                        GetData(++page);
                                    }
                                }, 2000);
                    }
                }
            }
        });
    }

    private void GetData(int page) {
        MainActivity.apiService.getSanpham(page, idLoaisp).enqueue(new Callback<ArrayList<Sanpham>>() {
            @Override
            public void onResponse(Call<ArrayList<Sanpham>> call, Response<ArrayList<Sanpham>> response) {

                if (response.isSuccessful()){
//                    ToastScreen.ShowToast_Short(getApplicationContext(), response.body().size() + "");

                    if (response.body().size() > 0){

                        ArrayList<Sanpham> Response = response.body();
                        mangSanpham.addAll(Response);

                        sanphamAdapter.notifyDataSetChanged();

                        isLoading = false;
                        lvSanpham.removeFooterView(footerview);
                    }
                    else {
                        isEndOfData = true;
                        lvSanpham.removeFooterView(footerview);
                        ToastScreen.ShowToast_Short(getApplicationContext(),"Đã load toàn bộ sản phẩm!");
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Sanpham>> call, Throwable t) {

            }
        });
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
        toolbar = findViewById(R.id.toolbarManHinhSanpham);
        lvSanpham = findViewById(R.id.listviewManHinhSanpham);

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview = inflater.inflate(R.layout.progressbar, null);

        mangSanpham = new ArrayList<>();
        sanphamAdapter = new SanphamAdapter(getApplicationContext(), mangSanpham);
        lvSanpham.setAdapter(sanphamAdapter);

        idLoaisp = Integer.parseInt(getIntent().getStringExtra("idloaisanpham"));
        toolbar.setTitle(MainActivity.mangloaisp.get(idLoaisp).getTenloaiqt());
    }
}
