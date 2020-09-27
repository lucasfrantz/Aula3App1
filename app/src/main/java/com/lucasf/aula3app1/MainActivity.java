package com.lucasf.aula3app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById( R.id.btnCalcular );

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView inicial = findViewById( R.id.txtInicial );
                TextView mensal = findViewById( R.id.txtMensal );
                TextView taxa = findViewById( R.id.txtTaxa );
                TextView meses = findViewById( R.id.txtTempo );

                try {

                    Double valorInicial = Double.valueOf(inicial.getText().toString());
                    Double valorMensal = Double.valueOf(mensal.getText().toString());
                    Double taxaMensal = Double.valueOf(taxa.getText().toString());
                    Integer numMeses = Integer.valueOf(meses.getText().toString());

                    Double valorFinal = valorInicial;
                    while (numMeses >= 0) {
                        valorFinal = (valorFinal + valorMensal) * (1 + taxaMensal);
                        numMeses--;
                    }

                    TextView txtFinal = findViewById(R.id.txtFinal);

                    txtFinal.setText(String.valueOf(valorFinal));
                }
                catch( Exception ex )
                {
                    Toast.makeText( MainActivity.this, getString(R.string.warning), Toast.LENGTH_LONG );
                }
            }
        });
    }
}