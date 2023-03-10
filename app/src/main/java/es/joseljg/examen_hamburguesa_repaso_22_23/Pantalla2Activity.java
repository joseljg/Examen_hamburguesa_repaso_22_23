package es.joseljg.examen_hamburguesa_repaso_22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Pantalla2Activity extends AppCompatActivity {

    private Pedido pedido = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        Intent intent = getIntent();
        if(intent != null)
        {
            pedido = (Pedido)intent.getSerializableExtra(MainActivity.EXTRA_OBJETO_PEDIDO);
            Toast.makeText(this,pedido.toString(),Toast.LENGTH_LONG).show();
        }
    }
}