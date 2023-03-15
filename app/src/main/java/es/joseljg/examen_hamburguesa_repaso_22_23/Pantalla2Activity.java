package es.joseljg.examen_hamburguesa_repaso_22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2Activity extends AppCompatActivity {

    private TextView txt_p2_hamburguesa = null;
    private TextView txt_p2_complemento = null;

    private TextView txt_p2_precio_hamburguesa = null;
    private TextView txt_p2_precio_complemento = null;
    private TextView txt_p2_precio_cupon = null;
    private TextView txt_p2_precio_iva = null;
    private TextView txt_p2_precio_total = null;
    //----------------------------------------------
    private String cupon_secreto = "mac123";
    private EditText edt_codigo = null;
    //----------------------------------------------
    private double precioh = 0.0;
    private double precioc = 0.0;
    private double precioiva = 0.0;
    private double preciototal = 0.0;
    private double preciocupon = 0.0;

    private Pedido pedido = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        //-------------------------------------------------------
        txt_p2_hamburguesa = (TextView) findViewById(R.id.txt_p2_hamburguesa);
        txt_p2_complemento = (TextView) findViewById(R.id.txt_p2_complemento);
        txt_p2_precio_hamburguesa = (TextView) findViewById(R.id.txt_p2_precio_hamburguesa);
        txt_p2_precio_complemento = (TextView) findViewById(R.id.txt_p2_precio_complemento);
        txt_p2_precio_cupon = (TextView) findViewById(R.id.txt_p2_precio_cupon);
        txt_p2_precio_iva = (TextView) findViewById(R.id.txt_p2_precio_iva);
        txt_p2_precio_total = (TextView) findViewById(R.id.txt_p2_precio_total);
        //------------------------------------------------------
        edt_codigo = (EditText) findViewById(R.id.edt_codigo);
        //------------------------------------------------------
        Intent intent = getIntent();
        if(intent != null)
        {
            pedido = (Pedido)intent.getSerializableExtra(MainActivity.EXTRA_OBJETO_PEDIDO);
            // aquí me aseguro que el pedido ha llegado y cojo sus nombres y los muestro
            txt_p2_hamburguesa.setText(pedido.getNombreh());
            txt_p2_complemento.setText(pedido.getNombrec());
            //---------------------------------------------------------
            // actualizo todos los precios de la pantalla
            if(pedido.getNombreh().equalsIgnoreCase("mac pollo"))
            {
                this.precioh = 3.0;
            }
            else if(pedido.getNombreh().equalsIgnoreCase("xxl"))
            {
                this.precioh = 5.0;
            }
            //---------------------------------------------------------------
            if(pedido.getNombrec().equalsIgnoreCase("patatas"))
            {
                this.precioc = 2.0;
            }
            else if(pedido.getNombrec().equalsIgnoreCase("coca cola"))
            {
                this.precioc = 2.5;
            }
            //-------------------------------------------------------------
            this.precioiva = (this.precioh+this.precioc-this.preciocupon)*0.21;
            this.preciototal = (this.precioh+this.precioc-this.preciocupon)+ this.precioiva;
            //-------------------------------------------------------------------------------
            actualizarPantalla();
            Toast.makeText(this,pedido.toString(),Toast.LENGTH_LONG).show();
        }

    }

    private void actualizarPantalla() {
        txt_p2_precio_hamburguesa.setText(String.valueOf(precioh));
        txt_p2_precio_complemento.setText(String.valueOf(precioc));
        txt_p2_precio_cupon.setText(String.valueOf(preciocupon));
        txt_p2_precio_iva.setText(String.valueOf(precioiva));
        txt_p2_precio_total.setText(String.valueOf(preciototal));
    }

    public void aplicar_cupon(View view) {
        String texto = String.valueOf(edt_codigo.getText());
        if(texto.equals(cupon_secreto))
        {
            // volver a calcular todos los precio de nuevo
            Toast.makeText(this,"cupon correcto, se le aplica un descuento de 1 euro", Toast.LENGTH_SHORT).show();
            this.preciocupon = 1.0;
            this.precioiva = (this.precioh+this.precioc-this.preciocupon)*0.21;
            this.preciototal = (this.precioh+this.precioc-this.preciocupon)+ this.precioiva;
            //-------------------------------------------------------------------------------
            // luego hay que actualizar la pantalla con los nuevos precios
            actualizarPantalla();
        }
        else{
            Toast.makeText(this,"cupon incorrecto", Toast.LENGTH_SHORT).show();
            this.preciocupon = 0.0;
            this.precioiva = (this.precioh+this.precioc-this.preciocupon)*0.21;
            this.preciototal = (this.precioh+this.precioc-this.preciocupon)+ this.precioiva;
            //-------------------------------------------------------------------------------
            // luego hay que actualizar la pantalla con los nuevos precios
            actualizarPantalla();
        }

    }
}