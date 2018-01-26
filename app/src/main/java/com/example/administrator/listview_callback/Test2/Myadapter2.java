package com.example.administrator.listview_callback.Test2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.administrator.listview_callback.Myadapter;
import com.example.administrator.listview_callback.R;

import java.util.List;

/**
 * Created by Administrator on 2018/1/26 0026.
 */

public class Myadapter2 extends BaseAdapter {
    String myData="";
    private  List<String> data;
    private  ICallBack2 callBack2;
    private  Main2Activity context;

    public Myadapter2(ICallBack2 callBack2, List<String>data , Main2Activity main2Activity){

        this.callBack2=callBack2;
        this.data=data;
        this.context=main2Activity;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        MyViewHodler myViewHodler;
        if (view==null){
            view= LayoutInflater.from(context).inflate(R.layout.item,null);
            myViewHodler=new MyViewHodler(view);
            view.setTag(myViewHodler);
        }else {
            myViewHodler= (MyViewHodler) view.getTag();
        }
        myViewHodler.button.setText(data.get(position));
         myData = data.get(position);
        myViewHodler.button.setOnClickListener(new MyListener(position));

        return view;
    }

    class MyViewHodler{
        Button button;
        public MyViewHodler(View view){
            button=view.findViewById(R.id.bt);
        }
    }

    class MyListener implements View.OnClickListener{
        int position;
        public  MyListener(int position){
            this.position=position;
        }
        @Override
        public void onClick(View view) {
            callBack2.show();
            callBack2.showData(position);
        }
    }

    public interface  ICallBack2{
        void show();
        void showData(int data);
    }
}

