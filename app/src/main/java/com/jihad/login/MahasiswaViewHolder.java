package com.jihad.login;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jihad.login.MenuActivity.*;
import com.mnurulefendi202102256.login_forex.R;

public class MahasiswaViewHolder
{
    public ImageView _jkImageView;
    public TextView _jkTextView;
    public TextView _jpTextView;
    public TextView _namaTextView;
    public TextView _nimTextView;

    public MahasiswaViewHolder (View itemView)
    {
        super();
        _jkImageView = (ImageView) itemView.findViewById(R.id.jkImageView);
        _jkTextView = (TextView) itemView.findViewById(R.id.jkTextView);
        _jpTextView = (TextView) itemView.findViewById(R.id.jpTextView);
        _namaTextView = (TextView) itemView.findViewById(R.id.namaTextView);
        _nimTextView = (TextView) itemView.findViewById(R.id.nimTextView);
    }
}
