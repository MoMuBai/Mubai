package com.mb.mubai.ui.test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.mb.mubai.R;
import com.mb.mubai.base.listener.StartDragListener;
import com.mb.mubai.ui.test.adapter.RecyclerViewAdapter;
import com.mb.mubai.view.widget.MyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: lzw
 * @date: 2017/11/23 下午3:38
 * @desc:
 */

public class RecyclerViewMoveActivity extends AppCompatActivity implements StartDragListener {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
//    private RecyclerViewMoveAdapter adapter;

    private RecyclerViewAdapter recyclerViewAdapter;

    private List<String> mList;

    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_move);
        ButterKnife.bind(this);
        mList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mList.add("");
        }
        recyclerViewAdapter = new RecyclerViewAdapter();
//        adapter = new RecyclerViewMoveAdapter(mList, this, this);
        recyclerView.setLayoutManager(new MyLinearLayoutManager());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.addRefreshData(mList);
//        MyItemTouchHelperCallback callback = new MyItemTouchHelperCallback(adapter);
//        itemTouchHelper = new ItemTouchHelper(callback);
//        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
//        itemTouchHelper.startDrag(viewHolder);
    }
}
