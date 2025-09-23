package com.example.jessappuno;

import android.view.View;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView texto;// 1. Declara la variable como miembro de la clase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("info", "mensajes de informacion");

        // 2. Inicializa la variable DESPUÉS de setContentView
        texto = findViewById(R.id.textTexto);

        // 3. (Opcional pero buena práctica si no usas View Binding) Comprueba si es null
        //if (texto != null) {
        texto.setTextColor(getResources().getColor(R.color.azulito, null));
        //} else {
        // El TextView no se encontró, esto podría indicar un problema
        // con tu ID en el XML o el layout que estás inflando.
        //  Log.e("MainActivity", "Error: TextView con ID 'txtTexto' no encontrado.");
        // Podrías incluso lanzar una excepción o mostrar un mensaje al usuario
        // si esta vista es crítica para tu app.
        //}//esto es para cambiar de color de texto
        //control+ALTTTT + L


    }

    public void ModificaTexto(View vista) {
        //todos los botones deben cumplir esto, public void,y nombreespecifico
        //esto es un metodo para pulsar min 23:29
        //vist es cualquier cosa que puedas interacctuar
        texto.setText("Texto modificado");
        texto.setTextColor(getResources().getColor(R.color.black, null));
        texto.setTextSize(26);


    }
}