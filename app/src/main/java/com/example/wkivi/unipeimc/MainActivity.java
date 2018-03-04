package com.example.wkivi.unipeimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPeso;
    private EditText editTextAltura;
    private Button buttonCalcular;
    private TextView editTextResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        editTextResultado = findViewById(R.id.textViewResultado);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pesoString = String.valueOf(editTextPeso.getText());
                String alturaString = String.valueOf(editTextAltura.getText());

                if ( (null != pesoString && pesoString.length() > 0) && (null != alturaString && alturaString.length() > 0) )
                {
                    double peso = Double.parseDouble(pesoString);
                    double altura = Double.parseDouble(alturaString);

                    if (peso > 0 && altura > 0) {
                        double resultado = peso / (Math.pow(altura, 2));

                        editTextResultado.setText("IMC: "+String.valueOf(resultado));
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Valor Invalido", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Erro de Entrada", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
