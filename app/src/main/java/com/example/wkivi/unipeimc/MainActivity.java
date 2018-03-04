package com.example.wkivi.unipeimc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPeso;
    private EditText editTextAltura;
    private Button buttonCalcular;

    private String m_Text = "";

    private void inputDialog(String resultado)
    {
        final String imc = resultado;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Insira o seu nome:");

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();

                Toast toast = Toast.makeText(getApplicationContext(), m_Text+"\r\nIMC: "+imc, Toast.LENGTH_LONG);
                toast.show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        buttonCalcular = findViewById(R.id.buttonCalcular);

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

                        inputDialog(String.valueOf(resultado));

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
