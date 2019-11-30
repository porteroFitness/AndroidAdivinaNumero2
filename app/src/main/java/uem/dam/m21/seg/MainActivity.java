package uem.dam.m21.seg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText etNombreJ;
    private EditText etIntentosJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombreJ = findViewById(R.id.etNombre);
        etIntentosJ = findViewById(R.id.etIntentos);

    }

    public void clickAcceder(View view) {
        String nombre = etNombreJ.getText().toString();
        String sIntentos = etIntentosJ.getText().toString();
        int intentos = Integer.parseInt(sIntentos);


        if (nombre.isEmpty() && intentos == 0 || nombre.isEmpty() && sIntentos.isEmpty()){
            Toast.makeText(this, R.string.toast_err_todo, Toast.LENGTH_LONG).show();
        } else if (nombre.isEmpty()){
            Toast.makeText(this, R.string.toast_err_nombre, Toast.LENGTH_LONG).show();
        } else if (intentos == 0 || sIntentos.isEmpty()){
            Toast.makeText(this, R.string.toast_err_intento, Toast.LENGTH_LONG).show();
        } else if (!nombre.isEmpty() && !sIntentos.isEmpty()){
            /* USAR UNA CLASE OBJETO PARA AHORRARNOS EL PUT EXTRA */
            AdivinaNumeroApplication ana = (AdivinaNumeroApplication)getApplicationContext();
            ana.setNombreUsuario(nombre);
            ana.setNumIntentos(intentos);
            /*********************************/

            Intent accederMain2 = new Intent(this, MainActivity2.class);
            startActivity(accederMain2);
        }


    }
}
