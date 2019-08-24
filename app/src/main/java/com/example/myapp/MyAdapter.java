package com.example.myapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<word> arrayList;

    public MyAdapter(Context context,ArrayList<word> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }
    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater)context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        convertView=inflater.inflate( R.layout.mycoustomlistview,null);
        TextView t1_name=(TextView)convertView.findViewById( R.id.name_txt );
        TextView t2_question=(TextView)convertView.findViewById( R.id.question_txt );


        word word=arrayList.get( position );
        t1_name.setText( word.getName() );
        t2_question.setText( word.getQuestion() );

        return convertView;

    }
}
