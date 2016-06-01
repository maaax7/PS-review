package br.com.fiap.revisaops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.revisaops.bean.Movel;

public class MainActivity extends AppCompatActivity {

    Spinner _spSofa;
    Spinner _spRevestimento;
    RadioGroup _rgLugares;
    CheckBox _ckClientePref;
    TextView _txtQtd;
    TextView _txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _txtQtd = (TextView)findViewById(R.id.txtQtd);
        _spSofa = (Spinner)findViewById(R.id.spnSofa);
        _spRevestimento = (Spinner)findViewById(R.id.spnRevestimento);
        _rgLugares = (RadioGroup)findViewById(R.id.rgLugares);
        _ckClientePref = (CheckBox)findViewById(R.id.ckCliente);
        _txtResultado = (TextView)findViewById(R.id.lblResultado);

        carregarMoveis();
    }

    public void carregarMoveis(){
        List<Movel> moveis = new ArrayList<Movel>();

        moveis.add(new Movel("Gonzaga", 1500f));
        moveis.add(new Movel("Embare", 1200f));
        moveis.add(new Movel("Campo Grande", 1000f));

        ArrayAdapter<Movel> adpMovel = new ArrayAdapter<Movel>(this, android.R.layout.simple_spinner_item, moveis);
        _spSofa.setAdapter(adpMovel);

    }

    public void calcularCompra(View v){
        float calculo = 0;

        if(_txtQtd.toString().equals("")){
            Toast.makeText(this, "Informe a quantidade de móveis", Toast.LENGTH_SHORT).show();
            return;
        }

        int qtd = Integer.parseInt(_txtQtd.toString());

        Movel sofa = (Movel) _spSofa.getSelectedItem();
        calculo = sofa.getValor() * qtd;

        String revestimento = (String)_spRevestimento.getSelectedItem();

        if(revestimento.toUpperCase().equals("COURINO")){
            calculo += 200f;
        }
        else if(revestimento.toUpperCase().equals("COURO")){
            calculo += 100f;
        }

        int idLugar = _rgLugares.getCheckedRadioButtonId();
        RadioButton rbLugar = (RadioButton)findViewById(idLugar);

        if(idLugar == 1){
            if(_ckClientePref.isChecked()){
                calculo += (calculo * 0.2);
            }
            else {
                calculo += (calculo * 0.3);
            }
        }
        else if(idLugar == 2){
            if(_ckClientePref.isChecked()){
                calculo += (calculo * 0.5);
            }
            else {
                calculo += (calculo * 0.6);
            }
        }

        _txtResultado.setText("R$ " + calculo);
    }
}
