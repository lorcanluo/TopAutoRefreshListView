package github.lorcanluo.topautorefreshlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import github.lorcanluo.topautorefreshlistview.widget.TopAutoRefreshListView;

public class MainActivity extends AppCompatActivity implements TopAutoRefreshListView.OnTopRefreshListener {

    private List<String> mDatas;
    private MyAdapter mAdapter;
    private TopAutoRefreshListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (TopAutoRefreshListView) findViewById(R.id.listView);
        mListView.setOnTopRefreshListener(this);
        mAdapter = new MyAdapter();
        mListView.setAdapter(mAdapter);

        //填充数据
        mDatas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mDatas.add(String.valueOf(10 - i));
        }
        mAdapter.notifyDataSetChanged();
        mListView.setSelection(mDatas.size());
    }

    @Override
    public void onTopRefresh() {

        //填充数据
        int size = mDatas.size();
        for (int i = 0; i < 10; i++) {
            mDatas.add(0, String.valueOf(size + i + 1));
        }
        mAdapter.notifyDataSetChanged();
        mListView.setSelection(10);

        mListView.onTopRefreshFinished();
    }


    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (mDatas != null) {
                return mDatas.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (mDatas != null) {
                return mDatas.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_layout, null);
                viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) convertView.findViewById(R.id.textView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }


            viewHolder.textView.setText("index:" + mDatas.get(position));

            return convertView;
        }

        private class ViewHolder {
            public TextView textView;
        }
    }
}
