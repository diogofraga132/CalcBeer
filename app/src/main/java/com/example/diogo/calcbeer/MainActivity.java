package com.example.diogo.calcbeer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static float dados[]= new float[4];

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText garrafa = (EditText) findViewById(R.id.precoGarrafa);
        final EditText Lata = (EditText) findViewById(R.id.precoLata);
        final EditText Latao = (EditText) findViewById(R.id.precoLatao);
        final EditText longneck = (EditText) findViewById(R.id.precoLongneck);

        Button calcular = (Button) findViewById(R.id.calcular);
        
        calcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                try {

                    float precoGarrafaMl =  Float.valueOf(garrafa.getText().toString())/300*1000;
                    float precoLongneckMl =  Float.valueOf(longneck.getText().toString())/330*1000 ;
                    float precoLataMl =  Float.valueOf(Lata.getText().toString())/350*1000;
                    float precoLataoMl =  Float.valueOf(Latao.getText().toString())/473*1000 ;

                    dados[0] = precoGarrafaMl;
                    dados[1] = precoLongneckMl;
                    dados[2] = precoLataMl;
                    dados[3] = precoLataoMl;
                    float min = dados[3];
                    for (int i=0; i<4;i++){
                        if(min> dados[i]){
                            min= dados[i];
                        }
                    }
                    if(min == dados[0]){
                        alertDialog.setMessage("compre 300ml");
                    }
                    if(min == dados[1]){
                        alertDialog.setMessage("compre Long neck 330ml");
                    }
                    if(min == dados[2]){
                        alertDialog.setMessage("compre Lata 350ml");
                    }
                    if(min == dados[3]){
                        alertDialog.setMessage("compre Latão 473ml");
                    }
                    //alertDialog.setMessage(Float.toString(min));

                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ver Dados",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                            Intent intencao = new Intent(MainActivity.this, DadosActivity.class);
                                            MainActivity.this.startActivity(intencao);

                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                }catch (Exception E){
                    alertDialog.setTitle("Erro:");
                    alertDialog.setMessage("Preencha os campos corretamente e tente novamente");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
    }
}
