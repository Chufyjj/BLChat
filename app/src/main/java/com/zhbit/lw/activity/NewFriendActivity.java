package com.zhbit.lw.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zhbit.lw.blchat.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewFriendActivity extends ListActivity {

    private ListView newFriendListView;     // 新好友列表视图
    private List<Map<String, Object>> newFriendListData;    // 新好友列表适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_friend);

        initView();     // 初始化试图
        initData();     // 初始化数据
        initEvent();    // 初始化点击事件

    }

    // 初始化视图
    private void initView() {
        newFriendListView = getListView();
    }

    // 初始化数据
    private void initData() {
        newFriendListData = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", "一本正经、");
        map.put("requestMsg", "你好，asdklasdj我是一本正经、asdsaaskdjasld");
        newFriendListData.add(map);

        for(int i = 1;i < 10;i++) {
            map = new HashMap<String, Object>();
            map.put("userName", "一本正经、" + i);
            map.put("requestMsg", "你好，我是一本正经、" + i);
            newFriendListData.add(map);
        }

        newFriendListView.setAdapter(new NewFriendListAdapter());
    }

    // 初始化点击事件
    private void initEvent() {
        newFriendListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NewFriendActivity.this, UserInforActivity.class);
                intent.putExtra("userName", newFriendListData.get(position).get("userName").toString());
                startActivity(intent);
            }
        });
    }

    class NewFriendListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return newFriendListData.size();
        }

        @Override
        public Object getItem(int position) {
            return newFriendListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.listview_row_newfriend, null);
            TextView tvUserName = (TextView) convertView.findViewById(R.id.lvRow_newfriend_userName);
            TextView tvRequestMsg = (TextView) convertView.findViewById(R.id.lvRow_newfriend_requestMsg);
            tvUserName.setText(newFriendListData.get(position).get("userName").toString());
            tvRequestMsg.setText(newFriendListData.get(position).get("requestMsg").toString());

            return convertView;
        }
    }


}
