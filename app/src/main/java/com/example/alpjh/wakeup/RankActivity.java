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

    private ListView listView;

    public ArrayList arrayList = new ArrayList();

    ArrayAdapter adapter;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView = (ListView)findViewById(R.id.listView);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String temp = "";
                    temp += snapshot.getKey() + " : " + snapshot.getValue();
                    arrayList.add(temp);

                    listView.setAdapter(adapter);

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ERROR", "FirebaseDatabase RankActivity");
            }
        });

    }
}
