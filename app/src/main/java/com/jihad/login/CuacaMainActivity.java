package com.jihad.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mnurulefendi202102256.login_forex.R;

import cz.msebera.android.httpclient.Header;

public class CuacaMainActivity extends AppCompatActivity {

    private RecyclerView _recyclerView2;
    private SwipeRefreshLayout _swipeRefreshLayout2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuaca_main);

        _recyclerView2 = findViewById(R.id.recyclerView1);
        _swipeRefreshLayout2 = findViewById(R.id.swipeRefreshLayout1);

        initRecyclerView2();
        initSwipeRefreshLayout();
    }
    private void initSwipeRefreshLayout(){
        _swipeRefreshLayout2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initRecyclerView2();
                _swipeRefreshLayout2.setRefreshing(false);
            }
        });
    }
    private void initRecyclerView2(){
        String url = "https://api.openweathermap.org/data/2.5/forecast?id=1630789&appid=29cc38b5df5d071927ec4736c1222837";
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                CuacaRootModel rm = gson.fromJson(new String(responseBody),CuacaRootModel.class);

                RecyclerView.LayoutManager lm = new LinearLayoutManager(CuacaMainActivity.this);
                CuacaAdapter ca = new CuacaAdapter(CuacaMainActivity.this, rm);

                _recyclerView2.setLayoutManager(lm);
                _recyclerView2.setAdapter(ca);

                _swipeRefreshLayout2.setRefreshing(false);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}