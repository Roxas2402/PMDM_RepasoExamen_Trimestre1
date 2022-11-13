package com.example.repasoexamen_trimestre1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.repasoexamen_trimestre1.databinding.ActivityAddProductoBinding;
import com.example.repasoexamen_trimestre1.models.ProductoModel;

public class AddProductoActivity extends AppCompatActivity {
    private ActivityAddProductoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddProductoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAnyadirAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = binding.txtNombreAdd.getText().toString();
                String edadS = binding.txtEdadAdd.getText().toString();
                String alturaS = binding.txtAlturaAdd.getText().toString();

                if (!nombre.isEmpty() && !edadS.isEmpty() && !alturaS.isEmpty()) {
                    ProductoModel p = new ProductoModel(nombre, Integer.parseInt(edadS), Float.parseFloat(alturaS));
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("PROD", p);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                    Toast.makeText(AddProductoActivity.this, p.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}