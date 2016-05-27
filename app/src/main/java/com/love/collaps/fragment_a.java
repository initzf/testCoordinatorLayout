package com.love.collaps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：zf on 2016/5/26 10:56
 * 邮箱：initzf@126.com
 */
public class fragment_a extends Fragment implements MyRecyclerAdapter.OnItemClickListener {
    private static final String TAG = "fragment_a";
    private String str;
    private List<Users> strings;
    private MyRecyclerAdapter adapter;
    @Bind(R.id.recycler)
    RecyclerView recycler;

    public fragment_a() {
    }

    public fragment_a(String string, List<Users> strings) {
        this.str = string;
        this.strings = strings;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);*/
        //recycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        recycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recycler.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyRecyclerAdapter(strings, this);
        recycler.setAdapter(adapter);
        recycler.addItemDecoration(new SpacesItemDecoration(30));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void onItemClick(Users users, int postion) {

    }

    @Override
    public void onItemLongClick(Users users, int postion) {
        adapter.removeItem(postion);
    }
}
