package com.wen.professor;
/*
 *@author: Wendell Valim Mendes
 * @ra: 1110482413005
 */
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgProf;
    private RadioButton rbProfTitular, rbProfHorista;
    private EditText txty, txtHoras;
    private Button btnCalcular;
    private TextView txtMostraSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rgProf = findViewById(R.id.rgProfessor);
        rbProfTitular = findViewById(R.id.rbProfTitular);
        rbProfHorista = findViewById(R.id.rbProfHorista);
        txty = findViewById(R.id.txtAnos);
        txtHoras = findViewById(R.id.txtHoras);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtMostraSalario = findViewById(R.id.txtMostraSalario);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularSalario();
            }
        });
    }

    private void calcularSalario() {
        String anosExperienciaStr = txty.getText().toString();
        String horasTrabalhadasStr = txtHoras.getText().toString();

        if (anosExperienciaStr.isEmpty() || horasTrabalhadasStr.isEmpty()) {
            txtMostraSalario.setText("Por favor, insira todos os valores.");
            return;
        }

        int anosExperiencia = Integer.parseInt(anosExperienciaStr);
        int horasTrabalhadas = Integer.parseInt(horasTrabalhadasStr);
        double salario;

        if (rbProfTitular.isChecked()) {
            salario = calcularSalarioTitular(anosExperiencia);
            String salarioFormatado = String.valueOf(salario);
            txtMostraSalario.setText(salarioFormatado);
        } else if (rbProfHorista.isChecked()) {
            salario = calcularSalarioHorista(horasTrabalhadas);
            String salarioFormatado = String.valueOf(salario);
            txtMostraSalario.setText(salarioFormatado);
        } else {
            txtMostraSalario.setText("Selecione o tipo de professor.");
        }
    }

    private double calcularSalarioTitular(int anosExperiencia) {
        double salarioBase = 3000.00;
        double bonusPorAno = 200.00;
        return salarioBase + (anosExperiencia * bonusPorAno);
    }

    private double calcularSalarioHorista(int horasTrabalhadas) {
        double valorPorHora = 50.00;
        return horasTrabalhadas * valorPorHora;
    }
}