package com.jihad.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jihad.login.MahasiswaAdapter.*;
import com.mnurulefendi202102256.login_forex.R;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter {
    private List<MahasiswaModel> _mahasiswaModelList;

    public MahasiswaAdapter (Context aThis, List<MahasiswaModel> mahasiswaModelList)
    {
        this._mahasiswaModelList = mahasiswaModelList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_mahasiswa, parent, false);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }


    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position)
    {
        MahasiswaModel mm = _mahasiswaModelList.get(position);

        holder._jkImageView.setImageResource(R.drawable.boy);

        if (mm.getJenisKelamin ().toLowerCase().equals("perempuan"))
        {
            holder._jkImageView.setImageResource(R.drawable.girl);
        }

        holder._nimTextView.setText(mm.getNIM());
        holder._namaTextView.setText(mm.getNama());
        holder._jkTextView.setText(mm.getJenisKelamin());

        String jp = mm.getJP();
        jp = jp.substring(0, 2); // hanya mengambil 2 karakter depan
        holder._jpTextView.setText(jp);
    }

    @Override
    public int getItemCount()
    {
        int count = 0;

        if (_mahasiswaModelList != null)
        {
            count = _mahasiswaModelList.size();
        }

        return count;
    }
}
