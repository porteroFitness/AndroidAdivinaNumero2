package uem.dam.m21.seg;

import android.app.Application;

public class AdivinaNumeroApplication extends Application {

    private String nombreUsuario;
    private int numIntentos;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getNumIntentos() {
        return numIntentos;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setNumIntentos(int numIntentos) {
        this.numIntentos = numIntentos;
    }
}
