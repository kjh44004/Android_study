package com.example.user.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //어댑터 준비
        ArrayAdapter<CharSequence> Adapter;
        Adapter = ArrayAdapter.createFromResource(this, R.array.Korean, android.R.layout.simple_list_item_1);

      /*simple_list_itme_1 : 하나의 텍스트뷰로 구성된 레이아웃;
        simple_list_itme_2 : 두개의 텍스트뷰로 구성된 레이아웃;
        simple_list_itme_checked : 체크표시 포함;
        simple_list_itme_single_choice : 라디오 표시 포함;
        simple_list_itme_multiple_chocie : 체크 버튼 포함;*/
        
        //어댑터 연결
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(Adapter);
    }


}
