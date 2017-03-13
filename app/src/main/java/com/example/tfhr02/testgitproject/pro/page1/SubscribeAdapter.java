package com.example.tfhr02.testgitproject.pro.page1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tfhr02.testgitproject.Bean.attention;
import com.example.tfhr02.testgitproject.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by TFHR02 on 2017/3/13.
 */
public class SubscribeAdapter extends RecyclerView.Adapter {
    private List<attention> lists;
    private Context context;

    public SubscribeAdapter(Context context, List<attention> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_attention_layout, null);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        attention bean = lists.get(position);
        myviewholder viewholder= (myviewholder) holder;
        ImageLoader.getInstance().displayImage(bean.getImage_list(), viewholder.iv_header);
        viewholder.tv_name.setText(bean.getTheme_name());
        viewholder.tv_attention_count.setText(bean.getSub_number());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class myviewholder extends ViewHolder {
        public CircleImageView iv_header;
        public TextView tv_name;
        public TextView tv_attention_count;
        public Button bt_attention;

        public myviewholder(View convertView) {
            super(convertView);
            iv_header = (CircleImageView) convertView.findViewById(R.id.iv_header);
            tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            tv_attention_count = (TextView) convertView.findViewById(R.id.tv_attention_count);
            bt_attention = (Button) convertView.findViewById(R.id.bt_attention);
        }
    }
}
