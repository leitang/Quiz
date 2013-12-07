package com.star.Quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class LoginActivity extends Activity {

    private TextView textName, textID, textGrade;
    private EditText editName, editID;
    private Spinner chooseGrade;
    private Button beginQuiz;
    private View textEdit_Name, textEdit_ID, textSpinner_Grade;
    private String gradeNumber;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textEdit_Name = findViewById(R.id.textEdit_Name);
        textEdit_ID = findViewById(R.id.textEdit_ID);
        textSpinner_Grade = findViewById(R.id.textSpinner_Grade);
        beginQuiz = (Button) findViewById(R.id.begin);
        textName = (TextView) textEdit_Name.findViewById(R.id.text);
        textID = (TextView) textEdit_ID.findViewById(R.id.text);
        textGrade = (TextView) textSpinner_Grade.findViewById(R.id.text);
        editName = (EditText) textEdit_Name.findViewById(R.id.input_text);
        editID = (EditText) textEdit_ID.findViewById(R.id.input_text);
        chooseGrade = (Spinner) textSpinner_Grade.findViewById(R.id.choose_grade);

        textName.setText("姓名");
        textID.setText("学号");
        textGrade.setText("年级");
        beginQuiz.setText("开始测试");

        beginQuiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                gradeNumber = chooseGrade.getSelectedItem().toString();
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, QuizActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("gradeNumber", gradeNumber);
                intent.putExtras(bundle);
                startActivity(intent);

            }

        });

    }

}
