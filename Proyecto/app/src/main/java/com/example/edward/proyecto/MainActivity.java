package com.example.edward.proyecto;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.edward.proyecto.R;

public class MainActivity extends ActionBarActivity {
    boolean punto=false;
    boolean limpia=true;
    float ope1=0f;
    float ope2=0f;
    float resul=0f;
    String ope="";

    String resultado,estado;
    public EditText Valor;

    double angulo,resulta;
    float operador;

    Button s,c,log,lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       botones();

    }

    public void botones(){
        Valor =(EditText)findViewById(R.id.Display);
        s =(Button)findViewById(R.id.BotonSen);
        c =(Button)findViewById(R.id.BotonCos);
        log =(Button)findViewById(R.id.BotonLog);
        lon =(Button)findViewById(R.id.BotonPot);

        final Button Exe = (Button) findViewById(R.id.BotonExe);

        final ToggleButton shift = (ToggleButton) findViewById(R.id.toggleButton);
        shift.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if (shift.isChecked()){
                    shift.setTextColor(Color.RED);
                    s.setTextColor(Color.YELLOW);
                    c.setTextColor(Color.YELLOW);
                    log.setTextColor(Color.YELLOW);
                    lon.setTextColor(Color.YELLOW);
                    Valor.setText("0");

                }

                else{

                    shift.setTextColor(Color.BLACK);
                    s.setTextColor(Color.RED);
                    c.setTextColor(Color.RED);
                    log.setTextColor(Color.RED);
                    lon.setTextColor(Color.RED);
                    Valor.setText("0");
                }


            }
        });

        final Button Seno = (Button) findViewById(R.id.BotonSen);
        Seno.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                if (shift.isChecked()){

                    operador = Float.parseFloat(Valor.getText().toString());
                    resulta=(Math.sinh(operador *2.0* Math.PI / 360.0));
                    Valor.setText(""+resulta);
                    }



                else{
                    operador = Float.parseFloat(Valor.getText().toString());
                    resulta=(Math.sin(operador *2.0* Math.PI / 360.0));
                    Valor.setText(""+resulta);

                }



            }


        });



        final Button Coseno = (Button) findViewById(R.id.BotonCos);

        Coseno.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if (shift.isChecked()){

                    operador = Float.parseFloat(Valor.getText().toString());
                    resulta=(Math.cosh(operador * Math.PI / 180));
                    Valor.setText(""+resulta);
                }

                else{

                        operador = Float.parseFloat(Valor.getText().toString());
                        resulta=(Math.cos(operador * Math.PI / 180));
                        Valor.setText(""+resulta);
                }


            }
        });


        final Button Logaritmo = (Button) findViewById(R.id.BotonLog);
        Logaritmo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if (shift.isChecked()){
                    operador=Float.parseFloat(Valor.getText().toString());
                    Valor.setText("" +Math.exp(Float.parseFloat(Valor.getText().toString())));
                }

                else{
                    operador=Float.parseFloat(Valor.getText().toString());
                    Valor.setText("" + Math.log10(Float.parseFloat(Valor.getText().toString())));

                }


            }
        });


        final Button Logaritmonatural = (Button) findViewById(R.id.BotonPot);
        Logaritmonatural.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {



                if (shift.isChecked()){
                    operador = Float.parseFloat(Valor.getText().toString());
                    resulta=(Math.tan(operador * 2.0 * Math.PI / 360.0));
                    Valor.setText(""+resulta);
                }

                else{
                    operador = Float.parseFloat(Valor.getText().toString());
                    Valor.setText("" + Math.log(Float.parseFloat(Valor.getText().toString())));
                }
            }
        });


    }


    public void agregaDisp(String s ) {
        EditText Despliega = (EditText) findViewById( R.id.Display );

        if( limpia ) {
            Despliega.setText("");
            limpia=false;
        }
        Despliega.append( s );
    }
    public void queOperador(String Oper) {

        EditText Despliega = (EditText) findViewById( R.id.Display );
        if( Oper.equals("+") ) {
            ope = "+";
            ope1=Float.parseFloat( Despliega.getText().toString());
            limpia=true;
        }
        else if( Oper.equals("√") ) {
            if( Despliega.getText().toString().length() > 0) {
                resul = (float) Math.sqrt(
                        Double.parseDouble(Despliega.getText().toString() ) );
                if( resul - (int) resul != 0)
                    Despliega.setText( ""+ resul );
                else
                    Despliega.setText( ""+ (int) resul );
            }
            limpia=true;
            ope1=0;
            ope2=0;
            resul=0;
            ope="";
        }
        else if( Oper.equals("1/x") ) {
            if( Despliega.getText().toString().length() > 0) {
                resul = 1.0f / Float.parseFloat(Despliega.getText().toString() );
                if( resul - (int) resul != 0)
                    Despliega.setText( ""+ resul );
                else
                    Despliega.setText( ""+ (int) resul );
            }
            limpia=true;
            ope1=0;
            ope2=0;
            resul=0;
            ope="";
        }
        else if( Oper.equals("-") ) {
            ope = "-";
            ope1=Float.parseFloat( Despliega.getText().toString());
        }


        else if( Oper.equals("*") ) {
            ope = "*";
            ope1=Float.parseFloat( Despliega.getText().toString());
        }
        else if( Oper.equals("/") ) {
            ope = "/";
            ope1=Float.parseFloat( Despliega.getText().toString());
        }
        else if( Oper.equals("^") ) {
            ope = "^";
            ope1=Float.parseFloat( Despliega.getText().toString());
        }
        else if( Oper.equals("%") ) {
            ope ="%";
            ope1=Float.parseFloat( Despliega.getText().toString());
        }
        else if( Oper.equals("=") ) {

            ope = "=";

            Resultado();

            limpia=true;
        }

        if( Despliega.getText().toString().length() > 0) {
            ope1 = Float.parseFloat(Despliega.getText().toString() );
        }
        limpia=true;
    }


    public void Resultado() {


        EditText Despliega = (EditText) findViewById( R.id.Display );

        if( Despliega.getText().toString().equals(".")) {
            Despliega.setText("0");
        }
        if( Despliega.getText().toString().length() > 0 ) {
            ope2= Float.parseFloat( Despliega.getText().toString() );
        }
        if( ope.equals("+") ) {
            resul = ope1 + ope2;
        } else if( ope.equals("-") ) {
            resul = ope1 - ope2;
        } else if( ope.equals("*") ) {
            resul = ope1 * ope2;
        } else if( ope.equals("/") ) {
            resul = ope1 / ope2;
        } else if( ope.equals("%") ) {
            resul = ope1 % ope2;
        }


        else if( ope.equals("^") ) {
            resul = (float) Math.pow(ope1, ope2);
        } else {
            resul = Float.parseFloat( Despliega.getText().toString() );
        }

        if( resul - (int) resul != 0)
            Despliega.setText( ""+ resul );
        else
            Despliega.setText( ""+ (int) resul );

    }
    public void ButtonClickHandler(View v){
        EditText Despliega = (EditText) findViewById( R.id.Display );

        switch(v.getId() ) {
            case R.id.Boton0: agregaDisp("0"); break;
            case R.id.Boton1: agregaDisp("1"); break;
            case R.id.Boton2: agregaDisp("2"); break;
            case R.id.Boton3: agregaDisp("3"); break;
            case R.id.Boton4: agregaDisp("4"); break;
            case R.id.Boton5: agregaDisp("5"); break;
            case R.id.Boton6: agregaDisp("6"); break;
            case R.id.Boton7: agregaDisp("7"); break;
            case R.id.Boton8: agregaDisp("8"); break;
            case R.id.Boton9: agregaDisp("9"); break;
            case R.id.BotonPunto:
                if (!Despliega.getText().toString().contains(".") ) {
                    agregaDisp(".");
                }
                break;
            case R.id.BotonDel:
                Despliega.setText(
                        Despliega.getText().toString().substring(0,
                                Despliega.getText().toString().length()-1));
                break;
            case R.id.BotonClear: 	limpia=true;
                ope1=0f;
                ope2=0f;
                resul=0f;
                Despliega.setText("0");
                ope="";
                break;

            case R.id.BotonRaiz: queOperador("√");
                break;
            case R.id.BotoInv: queOperador("1/x");
                break;
            case R.id.BotonMas: queOperador("+");
                break;
            case R.id.BotonMenos: queOperador("-");
                break;
            case R.id.BotonMul: queOperador("*");
                break;
            case R.id.BotonDiv: queOperador("/");
                break;

            case R.id.BotonMod: queOperador("%");
                System.out.println("%");
                break;
            case R.id.BotonExe:
                if( Despliega.getText().toString().length() > 0) {
                    Resultado();
                    limpia=true;
                    ope1=0f;
                    ope2=0f;
                    ope="";
                }
                break;
        }
    }

}
