package com.jihad.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.jihad.login.MenuActivity.*;
import com.mnurulefendi202102256.login_forex.R;

import cz.msebera.android.httpclient.Header;

public class MenuActivity extends AppCompatActivity {

    private Button _btnMahasiswa, _btnForex;
    private Intent _tampilMahasiswaIntent, _tampilForexIntent, _tampilCuacaIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        _btnMahasiswa = findViewById(R.id.btnMahasiswa);
        _btnForex = findViewById(R.id.btnForex);

        initTampilMahasiswaButton();
        initTampilForexButton();
    }

    private void initTampilMahasiswaButton()
    {
        _btnMahasiswa = (Button) findViewById(R.id.btnMahasiswa);
        _btnMahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncHttpClient asyncHttpClient;
                String url = "https://stmikpontianak.net/011100862/tampilMahasiswa.php";
                asyncHttpClient = new AsyncHttpClient();

                asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Toast.makeText(getApplicationContext(), "Selamat Datang, di Menu Mahasiswa", Toast.LENGTH_SHORT).show();
                        _tampilMahasiswaIntent = new Intent(getApplicationContext(), TampilMahasiswaActivity.class);
                        startActivity(_tampilMahasiswaIntent);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    private void initTampilForexButton() {
        _btnForex = (Button) findViewById(R.id.btnForex);

        _btnForex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilForexIntent = new Intent(getApplicationContext(), ForexMainActivity.class);
                startActivity(_tampilForexIntent);
            }
        });
    }}