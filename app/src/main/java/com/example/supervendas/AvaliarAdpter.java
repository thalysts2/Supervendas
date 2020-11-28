package com.example.supervendas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AvaliarAdpter extends ArrayAdapter<Avaliar> {
    public AvaliarAdpter(Context context, ArrayList<Avaliar> avaliars) {
        super(context, 0, avaliars);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Avaliar avaliar = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView textAvaliar = convertView.findViewById(R.id.avaliarUsuario);
        TextView textTexto = convertView.findViewById(R.id.avaliarTexto);

        textAvaliar.setText(avaliar.getUsuario());
        textTexto.setText(avaliar.getTexto());

        return convertView;
    }
}
