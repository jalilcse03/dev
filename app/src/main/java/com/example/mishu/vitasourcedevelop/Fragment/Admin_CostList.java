package com.example.mishu.vitasourcedevelop.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mishu.vitasourcedevelop.Activity.SelectDate;
import com.example.mishu.vitasourcedevelop.Adapter.AddAdapter;
import com.example.mishu.vitasourcedevelop.Model.IncomeAdd;
import com.example.mishu.vitasourcedevelop.R;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class Admin_CostList extends Fragment {
    @Bind(R.id.selectDate_Tx)
    TextView selectDate_Tx;
    @Bind(R.id.listView) ListView listView;
    private Calendar mCalendarTo, mCalendarFrom;
    IncomeAdd incomeAdd;
    ArrayList<IncomeAdd> incomeAddArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_admin__income_list, container, false);
        ButterKnife.bind(this, view);
        mCalendarFrom = Calendar.getInstance();
        mCalendarTo = Calendar.getInstance();
        incomeAddArrayList=new ArrayList<>();
        setData();
        return view;
    }

    public void setData(){
        incomeAdd=new IncomeAdd("Project 1","20000");
        incomeAddArrayList.add(incomeAdd);
        incomeAdd=new IncomeAdd("Project 2","30000");
        incomeAddArrayList.add(incomeAdd);
        incomeAdd=new IncomeAdd("Project 3","30000");
        incomeAddArrayList.add(incomeAdd);
        incomeAdd=new IncomeAdd("Project 4","40000");
        incomeAddArrayList.add(incomeAdd);
        incomeAdd=new IncomeAdd("Project 5","50000");
        incomeAddArrayList.add(incomeAdd);
        incomeAdd=new IncomeAdd("Project 6","60000");
        incomeAddArrayList.add(incomeAdd);
        incomeAdd=new IncomeAdd("Project 7","70000");
        incomeAddArrayList.add(incomeAdd);

        AddAdapter adapter=new AddAdapter(getActivity(),incomeAddArrayList);
        listView.setAdapter(adapter);
    }

    @OnClick(R.id.selectDate_Tx)
    public void selectDate(){
        Toast.makeText(getActivity(), "select test", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(),SelectDate.class);
        intent.putExtra("calendarFrom", mCalendarFrom.getTimeInMillis());
        intent.putExtra("calendarTo", mCalendarTo.getTimeInMillis());
        startActivityForResult(intent, 1);
    }


}
