package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ListView memberList;
    Button suvcBtn;
    Button editBtn;
    Button addMemberBtn;
    TextView teamEdittv;
    Button profile;
    Button notificationBtn;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getScreenElements();
        //Need to modify this method to add dynamic members.
        addMembers();
        openNotificationActivity();


    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        openNotificationActivity();

    }



    private void openNotificationActivity() {
        suvcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( HomeActivity.this,AboutUsActivity.class));
            }
        });



        addMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( HomeActivity.this,AddMemberActivity.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( HomeActivity.this,ProfileActivity.class));
            }
        });

        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( HomeActivity.this, NotificationActivity.class));
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, EditTeamActivity.class));
                st=getIntent().getExtras().getString("Value");
                teamEdittv.setText(st);
            }
        });
    }

    private void addMembers() {

        ArrayList<String> memberArrayList = new ArrayList<>();
        for (int i=0;i<20;i++){
            memberArrayList.add("Team Member "+(i+1));
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,memberArrayList);
        memberList.setAdapter(arrayAdapter);
    }

    private void getScreenElements(){
        memberList = findViewById(R.id.memberList);
        suvcBtn = findViewById(R.id.suvcBtn);
        editBtn=findViewById(R.id.editBtn);
        addMemberBtn=findViewById(R.id.addMemberBtn);
        profile=findViewById(R.id.profile);
        notificationBtn=findViewById(R.id.notificationBtn);
        teamEdittv =findViewById(R.id.teamName);
    }

}
