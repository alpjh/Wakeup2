package com.example.alpjh.wakeup;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity  {

    public static int classScore = 0;

    public static boolean gameClear = false;
    public static boolean gameOver = false;

    ArrayList<Student> students = new ArrayList<>();

    public static TextView totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView stu_health1, stu_health2, stu_health3, stu_health4, stu_health5, stu_health6;
        View student1, student2, student3, student4, student5, student6;
        ImageButton stu_btn1, stu_btn2, stu_btn3, stu_btn4,stu_btn5,stu_btn6;

        student1= findViewById(R.id.student1);
        student2= findViewById(R.id.student2);
        student3= findViewById(R.id.student3);
        student4= findViewById(R.id.student4);
        student5= findViewById(R.id.student5);
        student6= findViewById(R.id.student6);

        //이미지 버튼연결
        stu_btn1 = student1.findViewById(R.id.item_imgb_stu);
        stu_btn2 = student2.findViewById(R.id.item_imgb_stu);
        stu_btn3 = student3.findViewById(R.id.item_imgb_stu);
        stu_btn4 = student4.findViewById(R.id.item_imgb_stu);
        stu_btn5 = student5.findViewById(R.id.item_imgb_stu);
        stu_btn6 = student6.findViewById(R.id.item_imgb_stu);

        //클래스스코어 텍스트뷰 연결
        totalScore = (TextView)findViewById(R.id.tv_classScore);

        //체력 텍스트뷰 연결
        stu_health1 = student1.findViewById(R.id.item_tv_health);
        stu_health2 = student2.findViewById(R.id.item_tv_health);
        stu_health3 = student3.findViewById(R.id.item_tv_health);
        stu_health4 = student4.findViewById(R.id.item_tv_health);
        stu_health5 = student5.findViewById(R.id.item_tv_health);
        stu_health6 = student6.findViewById(R.id.item_tv_health);

        Student stu1 = new Student(stu_health1, stu_btn1);
        Student stu2 = new Student(stu_health2, stu_btn2);
        Student stu3 = new Student(stu_health3, stu_btn3);
        Student stu4 = new Student(stu_health4, stu_btn4);
        Student stu5 = new Student(stu_health5, stu_btn5);
        Student stu6 = new Student(stu_health6, stu_btn6);

        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);
        students.add(stu5);
        students.add(stu6);

        for(int i=0; i<6; i++) {
            students.get(i).testStart();
        }











        if(gameClear) {
            AlertDialog.Builder alert = new AlertDialog.Builder(GameActivity.this);
            alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();     //닫기
                }
            });
            alert.setMessage("성공!");
            alert.show();

        }

     }
}
