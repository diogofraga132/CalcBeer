package com.example.diogo.calcbeer;

import android.content.DialogInterface;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
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
                    double array[]= new double[4];

                    double precoGarrafaMl = Double.valueOf(garrafa.getText().toString()) / 300;
                    double precoLongneckMl = Double.valueOf(longneck.getText().toString()) / 330;
                    double precoLataMl = Double.valueOf(Lata.getText().toString()) / 350;
                    double precoLataoMl = Double.valueOf(Latao.getText().toString()) / 473;


                    array[0] = precoGarrafaMl;
                    array[1] = precoLongneckMl;
                    array[2] = precoLataMl;
                    array[3] = precoLataoMl;
                    double max = 0;
                    for (int i=0; i>3;i++){

                        if(array[i]>max){
                            max=array[i];
                        }
                    }

                    if(max==precoGarrafaMl){
                        alertDialog.setMessage(Double.toString(max));
//                        alertDialog.setTitle("compre:");
                      //  alertDialog.setMessage("Garrafa 300ml");
                }
                    else if (max==precoLongneckMl){
                        alertDialog.setTitle("compre:");
                        alertDialog.setMessage("Longneck 330ml");
                    }
                    else if(max==precoLataMl){
                        alertDialog.setTitle("compre:");
                        alertDialog.setMessage("Lata 350ml");
                    }
                    else{
                        alertDialog.setTitle("compre:");
                        alertDialog.setMessage("Latão 473ml");
                    }
                    alertDialog.show();

                }catch (Exception E){
                    alertDialog.setTitle("Erro:");
                    alertDialog.setMessage("Preencha os campos corretamente e tente novamente!");
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
