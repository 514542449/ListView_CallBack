package com.example.administrator.listview_callback;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.administrator.listview_callback.Test2.Main2Activity;
import com.example.administrator.listview_callback.Test2.Myadapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26 0026.
 */

public class Myadapter extends BaseAdapter{
    private ICallBack1 mycallBack;
    private  List<String> mylistData;
    private MainActivity myContext;



    public Myadapter(MainActivity mainActivity, List<String> data, ICallBack1 callBack) {
        this.myContext=mainActivity;
        this.mylistData=data;
        this.mycallBack=callBack;
    }

    @Override
    public int getCount() {
        return mylistData.size();
    }

    @Override
    public Object getItem(int i) {
        return mylistData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        MyViewHodler myViewHodler;
        if (view==null){
            view= LayoutInflater.from(myContext).inflate(R.layout.item,null);
            myViewHodler=new MyViewHodler(view);
            view.setTag(myViewHodler);
        }else {
            myViewHodler= (MyViewHodler) view.getTag();
        }
        myViewHodler.button.setText(mylistData.get(i));
        myViewHodler.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mycallBack.show();
                mycallBack.showData(mylistData.get(i));
            }
        });

        return view;
    }

    class MyViewHodler{
        Button button;
        public MyViewHodler(View view){
            button=view.findViewById(R.id.bt);
        }
    }
}
