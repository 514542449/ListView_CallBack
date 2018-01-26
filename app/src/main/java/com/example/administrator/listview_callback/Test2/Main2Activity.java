package com.example.administrator.listview_callback.Test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.listview_callback.R;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity  {
private ListView list;
private Myadapter2 myadapter2;

private Myadapter2.ICallBack2 callBack =new Myadapter2.ICallBack2() {
    @Override
    public void show() {
        Toast.makeText(Main2Activity.this, "你点击了一下", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showData(int data) {
        Toast.makeText(Main2Activity.this, "你获得了数据===="+data, Toast.LENGTH_SHORT).show();
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        List<String>data=new ArrayList<>();

        data = new ArrayList<>();
        data.add("希望");
        data.add("这个");
        data.add("简单");
        data.add("DEMO");
        data.add("对于");
        data.add("你来");
        data.add("说有");
        data.add("所帮");
        data.add("助！");
        list=this.findViewById(R.id.list);
        myadapter2= new Myadapter2(callBack,data,this);
        list.setAdapter(myadapter2);
        

        
    }

}
