package es.joseljg.examen_hamburguesa_repaso_22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_OBJETO_PEDIDO = "es.joseljg.examen_hamburguesa_repaso_22_23.mainactivity.pedido";
    private EditText edt_nombre_hamburguesa= null;
    private EditText edt_nombre_complemento = null;

    private String nombreComplemento = null;
    private String nombreHamburguesa = null;
    private Pedido pedido = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_nombre_hamburguesa = (EditText) findViewById(R.id.edt_nombre_hamburguesa);
        edt_nombre_complemento = (EditText) findViewById(R.id.edt_nombre_complemento);
        nombreHamburguesa ="Mc Pollo";
        nombreComplemento = "Patata";
        pedido = new Pedido();
    }


public void siguiente(View view)
{
    // validamos el nombre de la hamburguesa
    String nombreh = String.valueOf(edt_nombre_hamburguesa.getText());
    String nombrec = String.valueOf(edt_nombre_complemento.getText());
    boolean hayErrores = false;
    //------------------------------------------------------------------------------------------------------
    if(nombreh.isEmpty())
    {
        edt_nombre_hamburguesa.setError("el nombre de la hamburguesa no puede estar vacio ");
        hayErrores = true;
    }
    else if (nombreh.equalsIgnoreCase("XXL") || nombreh.equalsIgnoreCase("Mac Pollo"))
    {
        nombreHamburguesa = nombreh;
    }
    else{
        edt_nombre_hamburguesa.setError("solamente disponible XXL y Mac Pollo");
        hayErrores = true;
    }
    //-----------------------------------------------------------------------------------------------------
    if(nombrec.isEmpty())
    {
        edt_nombre_complemento.setError("el nombre del complemento no puede estar vacio ");
        hayErrores = true;
    }
    else if(nombrec.equalsIgnoreCase("patatas") || nombrec.equalsIgnoreCase("coca cola"))
    {
        nombreComplemento = nombrec;
    }
    else{
        edt_nombre_complemento.setError("solamente disponemos de patatas y coca cola");
        hayErrores = true;
    }
    //----------------------------------------------------------------------------------------------------
    if(hayErrores)
    {
        return;
    }
    // si ha llegado aquí es que no hay errores de validacion, entonces preparo el objeto pedido con los datos correctos
    pedido.setNombreh(nombreHamburguesa);
    pedido.setNombrec(nombreComplemento);
    // mandamos el objeto pedido a la siguiente pantalla
    Intent intent = new Intent(this, Pantalla2Activity.class);
    intent.putExtra(EXTRA_OBJETO_PEDIDO, pedido);
    startActivity(intent);
}
}