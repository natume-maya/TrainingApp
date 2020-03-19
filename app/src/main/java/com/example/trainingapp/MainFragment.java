package com.example.trainingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class MainFragment extends Fragment {

    private boolean isEnable = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button button = view.findViewById(R.id.button);
        button.setText("button");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbar("test");
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_item, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_first:
                activity.getSupportActionBar().invalidateOptionsMenu();
                isEnable = false;
                return true;
            case R.id.menu_second:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        menu.findItem(R.id.menu_second).setEnabled(isEnable);
    }

    private void showSnackbar(String message) {
        View view = getView();
        if (view == null) return;

        Snackbar snackbar = Snackbar.make(view.findViewById(R.id.button), message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}
