package com.love.collaps;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：zf on 2016/5/26 11:58
 * 邮箱：initzf@126.com
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private List<Users> strings;
    private OnItemClickListener onItemClickListener;

    public MyRecyclerAdapter(List<Users> strings, OnItemClickListener onItemClickListener) {
        this.strings = strings;
        this.onItemClickListener = onItemClickListener;
    }


    public interface OnItemClickListener {
        void onItemClick(Users users, int postion);

        void onItemLongClick(Users users, int postion);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Users users = strings.get(position);
        holder.masonry_item_img.setImageResource(users.getImageUrl());
        holder.tvName.setText(users.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(users, holder.getLayoutPosition());
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemClickListener.onItemLongClick(users, holder.getLayoutPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return strings == null ? 0 : strings.size();
    }


    public void removeItem(int postion) {
        strings.remove(postion);
        notifyItemRemoved(postion);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.masonry_item_title)
        TextView tvName;

        @Bind(R.id.masonry_item_img)
        ImageView masonry_item_img;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
