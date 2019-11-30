package uem.dam.m21.seg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    static final int MIN = 1;
    static final int MAX = 100;

    private TextView tvNombreJ;
    private TextView tvIntentosJ;
    private EditText etIntentoJ;

    private int aleatorio;
    private int contIntentos;

    AdivinaNumeroApplication ana;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etIntentoJ = findViewById(R.id.etIntentos);

        r = new Random();
        aleatorio = r.nextInt(MAX - MIN + 1) + MIN;

        ana = ((AdivinaNumeroApplication)getApplication());

        tvNombreJ = findViewById(R.id.tvNombre);
        tvIntentosJ = findViewById(R.id.tvIntentos);

        String claveUsuario = ana.getNombreUsuario();
        contIntentos = ana.getNumIntentos();

        tvNombreJ.setText(String.format(getString(R.string.tv_nombre), claveUsuario));
        tvIntentosJ.setText(String.format(getString(R.string.tv_intentos), contIntentos));

    }

    public void clickIntentar(View view) {

        String sIntentoUsuario = etIntentoJ.getText().toString();
        int intentoUsuario = Integer.parseInt(sIntentoUsuario);

        if (intentoUsuario != aleatorio && contIntentos > 0){
            Toast.makeText(this, R.string.toast_error_adivinar, Toast.LENGTH_LONG).show();
            contIntentos = contIntentos - 1;
            tvIntentosJ.setText(String.format(getString(R.string.tv_intentos), contIntentos));

        } else if (contIntentos <= 0) {
            Toast.makeText(this, R.string.toast_error_sin_intentos, Toast.LENGTH_LONG).show();
            tvIntentosJ.setText(String.format(getString(R.string.tv_intentos), 0));
        }

    }
}
