package com.example.administrator.listview_callback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private List<String> listDATA;
    private Myadapter myadapter;

    private ICallBack1 callBack=new ICallBack1() {
        @Override
        public void show() {
            Toast.makeText(MainActivity.this, "你点击了一下哦！", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void showData(String data) {

            Toast.makeText(MainActivity.this, "你获得了此行的数据-------"+data, Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewId();//初始化id
        setData();

    }

    private void setData() {
        listDATA = new ArrayList<>();
        listDATA.add("希望");
        listDATA.add("这个");
        listDATA.add("简单");
        listDATA.add("DEMO");
        listDATA.add("对于");
        listDATA.add("你来");
        listDATA.add("说有");
        listDATA.add("所帮");
        listDATA.add("助！");
        myadapter=new Myadapter(this,listDATA,callBack);
        list.setAdapter(myadapter);
    }

    private void findViewId() {
        list = findViewById(R.id.list_item);
    }
}
