package com.example.mishu.vitasourcedevelop.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mishu.vitasourcedevelop.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminAccounts extends Fragment {


    public AdminAccounts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_accounts, container, false);
    }

}
