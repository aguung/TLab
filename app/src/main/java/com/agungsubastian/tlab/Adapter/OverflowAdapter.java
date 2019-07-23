package com.agungsubastian.tlab.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.agungsubastian.tlab.Model.Overflow;
import com.agungsubastian.tlab.R;

import java.util.ArrayList;
import java.util.List;

public class OverflowAdapter extends ArrayAdapter<Overflow> implements View.OnClickListener {

    ArrayList<Overflow> dataSet;
    Context mContext;
    List<Overflow> listdata = null;

    private static class ViewHolder {
        TextView name;
        TextView title;
        TextView created;
        ImageView image;
    }

    public OverflowAdapter(List<Overflow> data, Context context) {
        super(context, R.layout.item_overflow, data);
        listdata = data;
        mContext = context;
        dataSet = new ArrayList<>();
        dataSet.addAll(listdata);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Overflow data = getItem(position);
        ViewHolder viewHolder;
        final View result;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.loker, parent, false);
            viewHolder.nama_loker = convertView.findViewById(R.id.nama_loker);
            viewHolder.deskripsi = convertView.findViewById(R.id.deskripsi);

            viewHolder.nama_industri = convertView.findViewById(R.id.nama_industri);
            viewHolder.post = convertView.findViewById(R.id.post);
            viewHolder.huruf = convertView.findViewById(R.id.huruf);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        String text = kerja.getNama_industri();
        char first = text.charAt(0);
        String hur = String.valueOf(first).toLowerCase();
        int imageResource = mContext.getResources().getIdentifier("drawable/" + hur, null, mContext.getPackageName());
        viewHolder.huruf.setImageResource(imageResource);
        viewHolder.nama_loker.setText(kerja.getNama_loker());
        viewHolder.deskripsi.setText(kerja.getDeskripsi());
        viewHolder.nama_industri.setText(kerja.getNama_industri());
        viewHolder.post.setText(kerja.getPost());
        // Return the completed view to render on screen
        return result;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        listdata.clear();
        if (charText.length() == 0) {
            listdata.addAll(dataSet);
        } else {
            for (loker wp : dataSet) {
                if (wp.getNama_loker().toLowerCase(Locale.getDefault()).contains(charText)) {
                    listdata.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
