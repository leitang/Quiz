package com.star.Quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class QuizActivity extends Activity {

    private String gradeNumber ;
    private TextView quizPrompt;
    private TextView[] questions = new TextView[3];
    private EditText inputAnswer1, inputAnswer2, inputAnswer3;
    private Button submit;
    private int correctAnswer1, correctAnswer2, correctAnswer3, answer1, answer2, answer3;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        gradeNumber = bundle.getString("gradeNumber");
        submit = (Button) findViewById(R.id.submit);
        quizPrompt = (TextView) findViewById(R.id.quizprompt);
        quizPrompt.setText("以下是适合"+gradeNumber+"同学的习题：");

        createQuestions(gradeNumber);

    }

    public void createQuestions(String gradeNumber) {

        questions[0] = (TextView) findViewById(R.id.question1);
        questions[1] = (TextView) findViewById(R.id.question2);
        questions[2] = (TextView) findViewById(R.id.question3);
        inputAnswer1 = (EditText) findViewById(R.id.answer1);
        inputAnswer2 = (EditText) findViewById(R.id.answer2);
        inputAnswer3 = (EditText) findViewById(R.id.answer3);

        Random random = new Random();
        String temp = new String();
        int x, y = 0, z;
        int[] numbers = new int[90];
        int[] randomNumbers12 = new int[3];
        int[] randomNumbers34 = new int[3];
        String[] operators12 = {"+","-"};
        String[] operators34 = {"+","-","*","/"};

        if(gradeNumber.equals("1年级") || gradeNumber.equals("2年级")) {

            for(int i=0;i<3;i++){

                for (int j = 10;j<=99;j++){

                    numbers[j-10] = j;

                }
                for (int j = 89; j > 86; j--) {
                    x = random.nextInt(j+1);
                    randomNumbers12[y] = numbers[x];
                    z = numbers[j];
                    numbers[j] = numbers[x];
                    numbers[x] = z;
                    z = 2;
                    temp += randomNumbers12[y]+operators12[random.nextInt(z)];
                    y++;
                }
                questions[i].setText(temp);
            }
            /*int i;
            int[] randomNumber = new int[9];

            for (i=0;i<=8;i++){

                randomNumber[i] = random.nextInt(100);

            }

            question1.setText(String.valueOf(randomNumber[0])+" + "+String.valueOf(randomNumber[1])+" - "+String.valueOf(randomNumber[2])+" =");
            question2.setText(String.valueOf(randomNumber[3])+" + "+String.valueOf(randomNumber[4])+" - "+String.valueOf(randomNumber[5])+" =");
            question3.setText(String.valueOf(randomNumber[6])+" + "+String.valueOf(randomNumber[7])+" - "+String.valueOf(randomNumber[8])+" =");

            correctAnswer1 = randomNumber[0]+randomNumber[1]-randomNumber[2];
            correctAnswer2 = randomNumber[3]+randomNumber[4]-randomNumber[5];
            correctAnswer3 = randomNumber[6]+randomNumber[7]-randomNumber[8];*/

        }
        else {

            /*int i;
            int[] randomNumber = new int[15];

            for (i=0;i<=14;i++){

                randomNumber[i] = random.nextInt(100);

            }

            question1.setText(String.valueOf(randomNumber[0])+" + "+String.valueOf(randomNumber[1])+" - "+String.valueOf(randomNumber[2])+" * "+String.valueOf(randomNumber[3])+" / "+String.valueOf(randomNumber[4])+" =");
            question2.setText(String.valueOf(randomNumber[5])+" + "+String.valueOf(randomNumber[6])+" - "+String.valueOf(randomNumber[7])+" * "+String.valueOf(randomNumber[8])+" / "+String.valueOf(randomNumber[9])+" =");
            question3.setText(String.valueOf(randomNumber[10])+" + "+String.valueOf(randomNumber[11])+" - "+String.valueOf(randomNumber[12])+" * "+String.valueOf(randomNumber[13])+" / "+String.valueOf(randomNumber[14])+" =");

            correctAnswer1 = randomNumber[0]+randomNumber[1]-randomNumber[2]*randomNumber[3]/randomNumber[4];
            correctAnswer2 = randomNumber[5]+randomNumber[6]-randomNumber[7]*randomNumber[8]/randomNumber[9];
            correctAnswer3 = randomNumber[10]+randomNumber[11]-randomNumber[12]*randomNumber[13]/randomNumber[14];
*/
        }

    }

}
