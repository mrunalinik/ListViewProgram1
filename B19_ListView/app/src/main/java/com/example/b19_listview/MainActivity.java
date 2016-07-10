package com.example.b19_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.b19_listview.data.SampleData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }

    static class ViewHolder{
        TextView tv;
    }

    private class MyAdapter extends BaseAdapter {

        private List<String> dataList = SampleData.getData();

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int position) {
            return dataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                view = inflater.inflate(R.layout.list_item, null);

                ViewHolder viewHolder = new ViewHolder();
                viewHolder.tv = (TextView) view.findViewById(R.id.itemData);
                view.setTag(viewHolder);
            }
            else{
                view = convertView;
            }

            //TextView tv = (TextView) view.findViewById(R.id.itemData);

            ViewHolder viewHolder = (ViewHolder) view.getTag();
            TextView tv = viewHolder.tv;
            tv.setText(dataList.get(position));

            return view;
        }
    }
}
