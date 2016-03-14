package com.xd.tttfive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xd.tttfive.divider.MyDivider;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;
    private String[] mDatas = new String[15];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initDatas();
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main);
    }

    private void initDatas() {
        for (int i = 0; i < mDatas.length; i++)
            mDatas[i] = "我是第" + i + "项数据";

        mAdapter = new MyRecyclerViewAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new MyDivider(this));
        mRecyclerView.setAdapter(mAdapter);
    }


    private class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(
                    R.layout.item_main, parent, false
            );
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mDatas[position]);
        }

        @Override
        public int getItemCount() {
            return mDatas.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tv_item);
            }
        }
    }
}
