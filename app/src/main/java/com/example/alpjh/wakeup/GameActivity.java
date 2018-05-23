package com.example.alpjh.wakeup;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

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

        //View (인클루드) 선언
        View student1, student2, student3, student4, student5,
                student6, student7, student8, student9, student10,
                student11, student12, student13, student14, student15,
                student16, student17, student18, student19, student20,
                student21, student22, student23, student24, student25;

        //학생 체력 텍스트 선언
//        TextView stu_health2, stu_health3, stu_health4, stu_health5,
//                stu_health6, stu_health7, stu_health8, stu_health9, stu_health10,
//                stu_health11, stu_health12, stu_health13, stu_health14, stu_health15,
//                stu_health16, stu_health17, stu_health18, stu_health19, stu_health20,
//                stu_health21, stu_health22, stu_health23, stu_health24, stu_health25;
        ImageView stu_health1, stu_health2, stu_health3, stu_health4, stu_health5,
                stu_health6, stu_health7, stu_health8, stu_health9, stu_health10,
                stu_health11, stu_health12, stu_health13, stu_health14, stu_health15,
                stu_health16, stu_health17, stu_health18, stu_health19, stu_health20,
                stu_health21, stu_health22, stu_health23, stu_health24, stu_health25;

        //이미지버튼 선언
        ImageButton stu_btn1, stu_btn2, stu_btn3, stu_btn4, stu_btn5,
                    stu_btn6, stu_btn7, stu_btn8, stu_btn9, stu_btn10,
                    stu_btn11, stu_btn12, stu_btn13, stu_btn14, stu_btn15,
                    stu_btn16, stu_btn17, stu_btn18, stu_btn19, stu_btn20,
                    stu_btn21, stu_btn22, stu_btn23, stu_btn24, stu_btn25;

        //Include 변수와 이어주기
        student1 = findViewById(R.id.student1);
        student2 = findViewById(R.id.student2);
        student3 = findViewById(R.id.student3);
        student4 = findViewById(R.id.student4);
        student5 = findViewById(R.id.student5);
        student6 = findViewById(R.id.student6);
        student7 = findViewById(R.id.student7);
        student8 = findViewById(R.id.student8);
        student9 = findViewById(R.id.student9);
        student10 = findViewById(R.id.student10);
        student11 = findViewById(R.id.student11);
        student12 = findViewById(R.id.student12);
        student13 = findViewById(R.id.student13);
        student14 = findViewById(R.id.student14);
        student15 = findViewById(R.id.student15);
        student16 = findViewById(R.id.student16);
        student17 = findViewById(R.id.student17);
        student18 = findViewById(R.id.student18);
        student19 = findViewById(R.id.student19);
        student20 = findViewById(R.id.student20);
        student21 = findViewById(R.id.student21);
        student22 = findViewById(R.id.student22);
        student23 = findViewById(R.id.student23);
        student24 = findViewById(R.id.student24);
        student25 = findViewById(R.id.student25);

        //이미지 버튼연결
        stu_btn1 = student1.findViewById(R.id.item_imgb_stu);
        stu_btn2 = student2.findViewById(R.id.item_imgb_stu);
        stu_btn3 = student3.findViewById(R.id.item_imgb_stu);
        stu_btn4 = student4.findViewById(R.id.item_imgb_stu);
        stu_btn5 = student5.findViewById(R.id.item_imgb_stu);
        stu_btn6 = student6.findViewById(R.id.item_imgb_stu);
        stu_btn7 = student7.findViewById(R.id.item_imgb_stu);
        stu_btn8 = student8.findViewById(R.id.item_imgb_stu);
        stu_btn9 = student9.findViewById(R.id.item_imgb_stu);
        stu_btn10 = student10.findViewById(R.id.item_imgb_stu);
        stu_btn11 = student11.findViewById(R.id.item_imgb_stu);
        stu_btn12 = student12.findViewById(R.id.item_imgb_stu);
        stu_btn13 = student13.findViewById(R.id.item_imgb_stu);
        stu_btn14 = student14.findViewById(R.id.item_imgb_stu);
        stu_btn15 = student15.findViewById(R.id.item_imgb_stu);
        stu_btn16 = student16.findViewById(R.id.item_imgb_stu);
        stu_btn17 = student17.findViewById(R.id.item_imgb_stu);
        stu_btn18 = student18.findViewById(R.id.item_imgb_stu);
        stu_btn19 = student19.findViewById(R.id.item_imgb_stu);
        stu_btn20 = student20.findViewById(R.id.item_imgb_stu);
        stu_btn21 = student21.findViewById(R.id.item_imgb_stu);
        stu_btn22 = student22.findViewById(R.id.item_imgb_stu);
        stu_btn23 = student23.findViewById(R.id.item_imgb_stu);
        stu_btn24 = student24.findViewById(R.id.item_imgb_stu);
        stu_btn25 = student25.findViewById(R.id.item_imgb_stu);

        //클래스스코어 텍스트뷰 연결
        totalScore = (TextView)findViewById(R.id.tv_classScore);

        //체력 텍스트뷰 연결
//        stu_health1 = student1.findViewById(R.id.item_tv_health);
//        stu_health2 = student2.findViewById(R.id.item_tv_health);
//        stu_health3 = student3.findViewById(R.id.item_tv_health);
//        stu_health4 = student4.findViewById(R.id.item_tv_health);
//        stu_health5 = student5.findViewById(R.id.item_tv_health);
//        stu_health6 = student6.findViewById(R.id.item_tv_health);
//        stu_health7 = student7.findViewById(R.id.item_tv_health);
//        stu_health8 = student8.findViewById(R.id.item_tv_health);
//        stu_health9 = student9.findViewById(R.id.item_tv_health);
//        stu_health10 = student10.findViewById(R.id.item_tv_health);
//        stu_health11 = student11.findViewById(R.id.item_tv_health);
//        stu_health12 = student12.findViewById(R.id.item_tv_health);
//        stu_health13 = student13.findViewById(R.id.item_tv_health);
//        stu_health14 = student14.findViewById(R.id.item_tv_health);
//        stu_health15 = student15.findViewById(R.id.item_tv_health);
//        stu_health16 = student16.findViewById(R.id.item_tv_health);
//        stu_health17 = student17.findViewById(R.id.item_tv_health);
//        stu_health18 = student18.findViewById(R.id.item_tv_health);
//        stu_health19 = student19.findViewById(R.id.item_tv_health);
//        stu_health20 = student20.findViewById(R.id.item_tv_health);
//        stu_health21 = student21.findViewById(R.id.item_tv_health);
//        stu_health22 = student22.findViewById(R.id.item_tv_health);
//        stu_health23 = student23.findViewById(R.id.item_tv_health);
//        stu_health24 = student24.findViewById(R.id.item_tv_health);
//        stu_health25 = student25.findViewById(R.id.item_tv_health);
        stu_health1 = student1.findViewById(R.id.item_img_health);
        stu_health2 = student2.findViewById(R.id.item_img_health);
        stu_health3 = student3.findViewById(R.id.item_img_health);
        stu_health4 = student4.findViewById(R.id.item_img_health);
        stu_health5 = student5.findViewById(R.id.item_img_health);
        stu_health6 = student6.findViewById(R.id.item_img_health);
        stu_health7 = student7.findViewById(R.id.item_img_health);
        stu_health8 = student8.findViewById(R.id.item_img_health);
        stu_health9 = student9.findViewById(R.id.item_img_health);
        stu_health10 = student10.findViewById(R.id.item_img_health);
        stu_health11 = student11.findViewById(R.id.item_img_health);
        stu_health12 = student12.findViewById(R.id.item_img_health);
        stu_health13 = student13.findViewById(R.id.item_img_health);
        stu_health14 = student14.findViewById(R.id.item_img_health);
        stu_health15 = student15.findViewById(R.id.item_img_health);
        stu_health16 = student16.findViewById(R.id.item_img_health);
        stu_health17 = student17.findViewById(R.id.item_img_health);
        stu_health18 = student18.findViewById(R.id.item_img_health);
        stu_health19 = student19.findViewById(R.id.item_img_health);
        stu_health20 = student20.findViewById(R.id.item_img_health);
        stu_health21 = student21.findViewById(R.id.item_img_health);
        stu_health22 = student22.findViewById(R.id.item_img_health);
        stu_health23 = student23.findViewById(R.id.item_img_health);
        stu_health24 = student24.findViewById(R.id.item_img_health);
        stu_health25 = student25.findViewById(R.id.item_img_health);

//        Student stu1 = new Student(stu_health1, stu_btn1);
//        Student stu2 = new Student(stu_health2, stu_btn2);
//        Student stu3 = new Student(stu_health3, stu_btn3);
//        Student stu4 = new Student(stu_health4, stu_btn4);
//        Student stu5 = new Student(stu_health5, stu_btn5);
//        Student stu6 = new Student(stu_health6, stu_btn6);
//        Student stu7 = new Student(stu_health7, stu_btn7);
//        Student stu8 = new Student(stu_health8, stu_btn8);
//        Student stu9 = new Student(stu_health9, stu_btn9);
//        Student stu10 = new Student(stu_health10, stu_btn10);
//        Student stu11 = new Student(stu_health11, stu_btn11);
//        Student stu12 = new Student(stu_health12, stu_btn12);
//        Student stu13 = new Student(stu_health13, stu_btn13);
//        Student stu14 = new Student(stu_health14, stu_btn14);
//        Student stu15 = new Student(stu_health15, stu_btn15);
//        Student stu16 = new Student(stu_health16, stu_btn16);
//        Student stu17 = new Student(stu_health17, stu_btn17);
//        Student stu18 = new Student(stu_health18, stu_btn18);
//        Student stu19 = new Student(stu_health19, stu_btn19);
//        Student stu20 = new Student(stu_health20, stu_btn20);
//        Student stu21 = new Student(stu_health21, stu_btn21);
//        Student stu22 = new Student(stu_health22, stu_btn22);
//        Student stu23 = new Student(stu_health23, stu_btn23);
//        Student stu24 = new Student(stu_health24, stu_btn24);
//        Student stu25 = new Student(stu_health25, stu_btn25);

        Student stu1 = new Student(stu_health1, stu_btn1);
        Student stu2 = new Student(stu_health2, stu_btn2);
        Student stu3 = new Student(stu_health3, stu_btn3);
        Student stu4 = new Student(stu_health4, stu_btn4);
        Student stu5 = new Student(stu_health5, stu_btn5);
        Student stu6 = new Student(stu_health6, stu_btn6);
        Student stu7 = new Student(stu_health7, stu_btn7);
        Student stu8 = new Student(stu_health8, stu_btn8);
        Student stu9 = new Student(stu_health9, stu_btn9);
        Student stu10 = new Student(stu_health10, stu_btn10);
        Student stu11 = new Student(stu_health11, stu_btn11);
        Student stu12 = new Student(stu_health12, stu_btn12);
        Student stu13 = new Student(stu_health13, stu_btn13);
        Student stu14 = new Student(stu_health14, stu_btn14);
        Student stu15 = new Student(stu_health15, stu_btn15);
        Student stu16 = new Student(stu_health16, stu_btn16);
        Student stu17 = new Student(stu_health17, stu_btn17);
        Student stu18 = new Student(stu_health18, stu_btn18);
        Student stu19 = new Student(stu_health19, stu_btn19);
        Student stu20 = new Student(stu_health20, stu_btn20);
        Student stu21 = new Student(stu_health21, stu_btn21);
        Student stu22 = new Student(stu_health22, stu_btn22);
        Student stu23 = new Student(stu_health23, stu_btn23);
        Student stu24 = new Student(stu_health24, stu_btn24);
        Student stu25 = new Student(stu_health25, stu_btn25);

        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);
        students.add(stu5);
        students.add(stu6);
        students.add(stu7);
        students.add(stu8);
        students.add(stu9);
        students.add(stu10);
        students.add(stu11);
        students.add(stu12);
        students.add(stu13);
        students.add(stu14);
        students.add(stu15);
        students.add(stu16);
        students.add(stu17);
        students.add(stu18);
        students.add(stu19);
        students.add(stu20);
        students.add(stu21);
        students.add(stu22);
        students.add(stu23);
        students.add(stu24);
        students.add(stu25);

        for(int i=0; i<25; i++) {
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
