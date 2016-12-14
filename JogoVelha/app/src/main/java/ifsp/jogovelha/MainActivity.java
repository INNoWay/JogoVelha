package ifsp.jogovelha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String atual = "O";

    Button[][] mTabuleiro = new Button[3][3];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabuleiro [0][0] = (Button) findViewById(R.id.bt1);
        mTabuleiro [0][1] = (Button) findViewById(R.id.bt2);
        mTabuleiro [0][2] = (Button) findViewById(R.id.bt3);

        mTabuleiro [1][0] = (Button) findViewById(R.id.bt4);
        mTabuleiro [1][1] = (Button) findViewById(R.id.bt5);
        mTabuleiro [1][2] = (Button) findViewById(R.id.bt6);

        mTabuleiro [2][0] = (Button) findViewById(R.id.bt7);
        mTabuleiro [2][1] = (Button) findViewById(R.id.bt8);
        mTabuleiro [2][2] = (Button) findViewById(R.id.bt9);
    }

        public void onClickBt(View view) {

            Button bt = (Button) findViewById(view.getId());

            if(atual=="O"){

                atual = "X";

            }else {

                atual = "O";

            }

            bt.setText(atual);
            bt.setClickable(false);

            verificaLinha();
            verificaColuna();
            verificaDiagonalPrincipal();
            verificaDiagonalSecundaria();
        }

        public void onclick(){
            Button bt1 = (Button) findViewById(R.id.bt1);
            Button bt2 = (Button) findViewById(R.id.bt2);
            Button bt3 = (Button) findViewById(R.id.bt3);
            Button bt4 = (Button) findViewById(R.id.bt4);
            Button bt5 = (Button) findViewById(R.id.bt5);
            Button bt6 = (Button) findViewById(R.id.bt6);
            Button bt7 = (Button) findViewById(R.id.bt7);
            Button bt8 = (Button) findViewById(R.id.bt8);
            Button bt9 = (Button) findViewById(R.id.bt9);

            bt1.setEnabled(false);
            bt1.setClickable(false);

            bt2.setEnabled(false);
            bt2.setClickable(false);

            bt3.setEnabled(false);
            bt3.setClickable(false);

            bt4.setEnabled(false);
            bt4.setClickable(false);

            bt5.setEnabled(false);
            bt5.setClickable(false);

            bt6.setEnabled(false);
            bt6.setClickable(false);

            bt7.setEnabled(false);
            bt7.setClickable(false);

            bt8.setEnabled(false);
            bt8.setClickable(false);

            bt9.setEnabled(false);
            bt9.setClickable(false);
        }

        private boolean verificaLinha(){
            TextView tv = (TextView) findViewById(R.id.edText);

            int contLinhaX = 0;
            int contLinhaY = 0;
            int velha=0;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(mTabuleiro[i][j].getText().equals("X")){
                        contLinhaX++;
                    }else if(mTabuleiro[i][j].getText().equals("O")){
                        contLinhaY++;
                    }

                    if(!mTabuleiro[i][j].getText().equals("")){
                        velha++;
                    }
                    if(contLinhaX==3){
                        tv.setText("X Ganhou");
                        onclick();
                    }
                    if(contLinhaY==3){
                        tv.setText("O Ganhou");
                        onclick();
                    }
                    if(velha == 9 && contLinhaX != 3 && contLinhaY != 3){
                        tv.setText("Velha Velha");
                        onclick();
                    }
                }
                contLinhaX=0;
                contLinhaY=0;
            }

            return false;
        }

        private boolean verificaColuna(){
            TextView tv = (TextView) findViewById(R.id.edText);
            int contColunaX = 0;
            int contColunaY = 0;
            int velha=0;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(mTabuleiro[j][i].getText().equals("X")){
                        contColunaX++;
                    }else if(mTabuleiro[j][i].getText().equals("O")){
                        contColunaY++;
                    }

                    if(!mTabuleiro[i][j].getText().equals("")){
                        velha++;
                    }
                    if(contColunaX==3){
                        tv.setText("X Ganhou");
                        onclick();
                    }
                    if(contColunaY==3){
                        tv.setText("O Ganhou");
                        onclick();
                    }
                    if(velha == 9 && contColunaX != 3 && contColunaY!=3){
                        tv.setText("Velha Velha");
                        onclick();
                    }
                }
                contColunaX=0;
                contColunaY=0;
            }

            return false;
        }

        private boolean verificaDiagonalPrincipal(){
            TextView tv = (TextView) findViewById(R.id.edText);
            int contDiagonalX = 0;
            int contDiagonalY = 0;
            int velha=0;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if((mTabuleiro[j][i].getText().equals("X")) && (i==j)){
                        contDiagonalX++;
                    }else if((mTabuleiro[j][i].getText().equals("O")) && (i==j)){
                        contDiagonalY++;
                    }

                    if(!mTabuleiro[i][j].getText().equals("")){
                        velha++;
                    }
                    if(contDiagonalX==3){
                        tv.setText("X Ganhou");
                        onclick();
                    }
                    if(contDiagonalY==3){
                        tv.setText("O Ganhou");
                        onclick();
                    }
                    if(velha == 9 && contDiagonalX != 3 && contDiagonalY != 3){
                        tv.setText("Velha Velha");
                        onclick();
                    }
                }
            }

            return false;
        }

        private boolean verificaDiagonalSecundaria(){
            TextView tv = (TextView) findViewById(R.id.edText);
            int contColunaX = 0;
            int contColunaO = 0;


                    if(mTabuleiro[0][2].getText().equals("X")){
                        contColunaX++;
                    }if(mTabuleiro[1][1].getText().equals("X")){
                        contColunaX++;
                    }if(mTabuleiro[2][0].getText().equals("X")){
                        contColunaX++;
                    }

                    if(mTabuleiro[0][2].getText().equals("O")){
                        contColunaO++;
                    }if(mTabuleiro[1][1].getText().equals("O")){
                        contColunaO++;
                    }if(mTabuleiro[2][0].getText().equals("O")){
                        contColunaO++;
                    }

                    if(contColunaX==3){
                        tv.setText("X Ganhou");
                        onclick();
                    }
                    if(contColunaO==3){
                        tv.setText("O Ganhou");
                        onclick();
                    }

            return false;
        }
    }

