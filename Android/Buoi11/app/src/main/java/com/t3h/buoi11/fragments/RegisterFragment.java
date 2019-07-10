package com.t3h.buoi11.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.t3h.buoi11.MainActivity;
import com.t3h.buoi11.R;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    private final String TAG = "RegisterFragment";

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnOk;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        View v = inflater.inflate(R.layout.activity_register,
                container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        edtPassword = getActivity().findViewById(R.id.edt_register_password);
        edtUserName = getActivity().findViewById(R.id.edt_register_user_name);
        btnOk = getActivity().findViewById(R.id.btn_register_ok);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onClick(View v) {
        MainActivity main = (MainActivity) getActivity();
        main.showFragment(main.getFmLogin());
        String userName = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();
        main.getFmLogin().setData(userName, password);
    }
}
