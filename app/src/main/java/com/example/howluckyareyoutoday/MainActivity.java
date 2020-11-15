package com.example.howluckyareyoutoday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText inputEditText;
    int randomNumber;
    int a = 0;
    int i = 0;


    public void generateRandomNumbers(){
        Random random = new Random();
        randomNumber = random.nextInt(20)+1;
    }

    public void guess(View view){
        int inputNumber = Integer.parseInt(inputEditText.getText().toString());
        String message;
        int length = String.valueOf(inputNumber).length();

        if(length == 0){
            return;
        }


        if (inputNumber > 20 || inputNumber < 1){
            message = "Liczba z poza zakresu." +  "\n" + "Wpisz liczbę z zakresu 1-20";
        } else if (inputNumber > randomNumber){
            message = "Wpisz mniejszą liczbę";
            a++;
        }else if (inputNumber < randomNumber){
            message = "Wpisz większą liczbę";
            a++;
        }else{
            message = "Trafiłeś!! Graj dalej :)";
            a++;
            i++;
            generateRandomNumbers();
        }
        String scoreNumber = String.valueOf(i);
        String shootsNumber = String.valueOf(a);
        TextView score = findViewById(R.id.numberOfScore);
        score.setText(scoreNumber);
        TextView shoots = findViewById(R.id.numberOfShots);
        shoots.setText(shootsNumber);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
    public void restart(View view){
        a = 0;
        i = 0;
        generateRandomNumbers();
        String scoreNumber = String.valueOf(i);
        String shootsNumber = String.valueOf(a);
        TextView score = findViewById(R.id.numberOfScore);
        score.setText(scoreNumber);
        TextView shoots = findViewById(R.id.numberOfShots);
        shoots.setText(shootsNumber);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);

        generateRandomNumbers();
    }
}

