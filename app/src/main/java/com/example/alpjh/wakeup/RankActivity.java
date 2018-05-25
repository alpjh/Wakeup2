package com.example.alpjh.wakeup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class RankActivity extends AppCompatActivity {

    //리스트뷰 선언
    private ListView listView;
    //리스트를 위한 어레이리스트 선언
    public ArrayList arrayList = new ArrayList();
    //리스트를 위한 어뎁터 선언
    ArrayAdapter adapter;

    //파이어베이스 레퍼런스
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        //simple_list_item1로 심플리스트를 사용할것. 어뎁터와 어레이리스트를 연결해줌
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView = (ListView)findViewById(R.id.listView);

        //파이어베이스에서 데이터를 받아옴.
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            //데이터를 받아오는데 성공했을 경우
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //서버 데이터베이스의 모든 정보를 순회하며 받아옴.
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //어레이리스트에 key 값과 value 값을 더한 스트링을 넣는다.
                    String temp = "";
                    temp += snapshot.getKey() + " : " + snapshot.getValue();
                    arrayList.add(temp);
                    listView.setAdapter(adapter);
                }
                //어뎁터와 리스트뷰를 연결해준다.

            }
            //실패했을 경우
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //로그출력
                Log.e("ERROR", "FirebaseDatabase RankActivity");
            }
        });

    }
}
