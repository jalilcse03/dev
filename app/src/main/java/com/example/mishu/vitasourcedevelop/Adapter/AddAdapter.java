package com.example.mishu.vitasourcedevelop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mishu.vitasourcedevelop.Model.IncomeAdd;
import com.example.mishu.vitasourcedevelop.R;

import java.util.ArrayList;



/**
 * Created by Murtuza on 4/19/2016.
 */
public class AddAdapter extends ArrayAdapter<IncomeAdd>{

    private ArrayList<IncomeAdd> todayDietList;
    private Context context;


    public AddAdapter(Context context, ArrayList<IncomeAdd> todayDietList) {
        super(context, R.layout.custom_row,todayDietList);
        this.context = context;
        this.todayDietList = todayDietList;
    }
    static class ViewHolder {
        TextView name;
        TextView cost;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_row, null);

            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.cost = (TextView) convertView.findViewById(R.id.cost);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(todayDietList.get(position).getName());
        viewHolder.cost.setText(todayDietList.get(position).getAmount());

        return convertView;
    }
}
