package com.example.repasoexamen_trimestre1;

import android.content.Intent;
import android.os.Bundle;

import com.example.repasoexamen_trimestre1.databinding.ActivityAddProductoBinding;
import com.example.repasoexamen_trimestre1.models.ProductoModel;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.repasoexamen_trimestre1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<ProductoModel> productoModelsList;
    private RecyclerView.LayoutManager layoutManager;
    private ActivityResultLauncher<Intent> launcherAddProducto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        productoModelsList = new ArrayList<>();
        inicializa();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherAddProducto.launch(new Intent(MainActivity.this, AddProductoActivity.class));
            }
        });
    }

    private void inicializa() {
        launcherAddProducto = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null && result.getData().getExtras() != null) {
                        ProductoModel p = (ProductoModel) result.getData().getExtras().getSerializable("PROD");
                        productoModelsList.add(p);

                    }
                }
            }
        });
    }
}