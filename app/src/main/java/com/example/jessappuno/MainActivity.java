package com.example.jessappuno;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar; // <-- IMPORTADO
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// 1. Quitar 'abstract' e implementar 'OnClickListener'
public class MainActivity extends AppCompatActivity implements View.OnKeyListener, View.OnClickListener {

    // --- 2. Declarar TODAS las variables de vista aquí ---
    TextView texto, resultado, textoHola, textoHello;
    EditText cajaTexto;
    Button botonTamano, botonCambiar, botonEntero;
    RatingBar barraValoracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("info", "onCreate: Vista creada y enlazando componentes.");

        // --- 3. Inicializar TODAS las vistas en un solo lugar ---
        // TextViews
        texto = findViewById(R.id.textoUno);
        resultado = findViewById(R.id.textoUno); // Asume que tienes un TextView con este ID en tu XML
        // Suponiendo que tienes estos IDs en tu XML para el ejemplo de onClick
        textoHola = findViewById(R.id.textoHola);
        textoHello = findViewById(R.id.textoHello);


        // EditText
        cajaTexto = findViewById(R.id.editText);

        // Buttons
        botonTamano = findViewById(R.id.BtnTamano);
        botonCambiar = findViewById(R.id.BtnCambiar);
        botonEntero = findViewById(R.id.btnEntero);

        // RatingBar
        barraValoracion = findViewById(R.id.valoracion); // Asume que tienes un RatingBar con este ID

        // --- 4. Configurar TODOS los listeners en un solo lugar ---

        // Asignar listener 'this' a los botones que serán manejados por el onClick de la clase
        botonTamano.setOnClickListener(this);
        botonCambiar.setOnClickListener(this);

        // Listener específico para el botón "Entero"
        botonEntero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtiene un valor entero desde los recursos (res/values/integers.xml)
                resultado.setText("" + getResources().getInteger(R.integer.edad));
            }
        });

        // Listener para la barra de valoración
        barraValoracion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {
                if (fromUser) {
                    resultado.setText("Se ha calificado con " + v);
                }
            }
        });

        // Listener para el campo de texto
        cajaTexto.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Pulsación prolongada en el editText", Toast.LENGTH_SHORT).show();
                return true; // 'true' para indicar que el evento fue consumido
            }
        });
        cajaTexto.setOnKeyListener(this); // El onKey será manejado por el método de la clase

        // --- 5. Lógica de inicialización adicional ---
        texto.setTextColor(getResources().getColor(R.color.azulito, null));
    }

    // --- 6. Métodos de la clase (FUERA de onCreate) ---

    /**
     * Este método se llama cuando se hace clic en una vista a la que se le asignó
     * setOnClickListener(this).
     */
    @Override
    public void onClick(View v) {
        // Usa if/else if para determinar qué botón fue presionado
        int viewId = v.getId();
        if (viewId == R.id.BtnTamano) { // Asumo que este es el botón para cambiar tamaño
            // Cambia el tamaño de ambos TextViews
            if (textoHola != null) textoHola.setTextSize(40);
            if (textoHello != null) textoHello.setTextSize(20);
        } else if (viewId == R.id.BtnCambiar) {
            // Cambia el texto de ambos TextViews
            if (textoHola != null) textoHola.setText("Texto Hola cambiado");
            if (textoHello != null) textoHello.setText("Texto Hello cambiado");
        }
    }

    /**
     * Este método se llama cuando se presiona una tecla en una vista a la que se le asignó
     * setOnKeyListener(this).
     */
    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        // Ejemplo: Si se presiona Enter en el EditText
        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
            Toast.makeText(this, "Enter presionado", Toast.LENGTH_SHORT).show();
            return true; // Evento consumido
        }
        return false; // Evento no consumido
    }

    /**
     * Este método se puede llamar desde un atributo android:onClick="ComprobacionBooleano" en el XML.
     */
    public void ComprobacionBooleano(View vista) {
        // Obtiene un valor booleano de los recursos (res/values/bools.xml)
        resultado.setText("¿Es azul? " + getResources().getBoolean(R.bool.esAzul));
    }

    /**
     * Este método se puede llamar desde un atributo android:onClick="ModificaTexto" en el XML.
     */
    public void ModificaTexto(View vista) {
        texto.setText("Texto modificado");
        texto.setTextColor(getResources().getColor(R.color.black, null));
        texto.setTextSize(26);
    }
}
