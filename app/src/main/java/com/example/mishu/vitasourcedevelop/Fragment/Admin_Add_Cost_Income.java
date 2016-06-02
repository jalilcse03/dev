package com.example.mishu.vitasourcedevelop.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mishu.vitasourcedevelop.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class Admin_Add_Cost_Income extends Fragment {
    @Bind(R.id.transaction_Sp)
    Spinner transaction_Sp;
    @Bind(R.id.save_bt)
    Button save_bt;
    @Bind(R.id.reset_bt)
    Button reset_bt;
    String items[]={"Income","Expense"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_admin__add__cost__income, container, false);
        ButterKnife.bind(this,view);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1 ,items);
        transaction_Sp.setAdapter(adapter);

        return view;
    }

    @OnClick(R.id.save_bt)
    public void save(){
        Toast.makeText(getActivity(), "save", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.reset_bt)
    public void reset(){
        Toast.makeText(getActivity(), "reset", Toast.LENGTH_SHORT).show();
    }


}
