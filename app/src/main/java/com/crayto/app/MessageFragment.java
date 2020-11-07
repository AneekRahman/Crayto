package com.crayto.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.crayto.app.Adapters.MessageListAdapter;
import com.crayto.app.Classes.MessageListRow;
import com.crayto.app.Classes.MyUtils;

import java.util.ArrayList;
import java.util.List;


public class MessageFragment extends Fragment {

    // View declarations
    private RecyclerView mMessageRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshView;

    // Class decalrations
    private MyUtils mMyUtils = new MyUtils();

    // Declaring recyclerview stuff
    private RecyclerView.LayoutManager mRecyclerViewLayoutManager;
    private List<MessageListRow> mMessageList;
    private MessageListAdapter mMessageAdapter;

    public MessageFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_message, container, false);

        // Connecting views to code
        mMessageRecyclerView = (RecyclerView) rootview.findViewById(R.id.message_recycler_view);
        mSwipeRefreshView = (SwipeRefreshLayout) rootview.findViewById(R.id.message_swipe_refresh_view);

        // For the different color effects
        mSwipeRefreshView.setPadding(0, mMyUtils.getPixelsFromDp(55, getContext()) + mMyUtils.getStatusBarHeight(getContext()), 0, 0);

        // Assign recyclerview stuff
        mRecyclerViewLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mMessageList = new ArrayList<>();
        mMessageAdapter = new MessageListAdapter(mMessageList, getContext());

        // Setting up the recyclerview
        mMessageRecyclerView.setAdapter(mMessageAdapter);
        mMessageRecyclerView.setLayoutManager(mRecyclerViewLayoutManager);
        mMessageRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mMessageRecyclerView.setFocusable(false);
        mMessageRecyclerView.setNestedScrollingEnabled(false);

        testMessageRows();

        return rootview;

    }

    private void testMessageRows(){

        MessageListRow messageListRow = new MessageListRow(MessageListRow.TYPE_MSG_RECEIVED_NOT_SEEN, 0, "Aneek Nibba", getString(R.string.aneek_dp_url), "Demmo message bixxxes", "6:09PM");
        mMessageList.add(messageListRow);

        messageListRow = new MessageListRow(MessageListRow.TYPE_MSG_RECEIVED_SEEN, 0, "Aneek Rahman", getString(R.string.aneek_dp_url), "Demmo message bixxxes", "6:09PM");
        mMessageList.add(messageListRow);

        messageListRow = new MessageListRow(MessageListRow.TYPE_MSG_SENT_NOT_SEEN, 0, "Not aneek Nibba", getString(R.string.aneek_dp_url), "Demmo message bixxxes", "6:09PM");
        mMessageList.add(messageListRow);

        messageListRow = new MessageListRow(MessageListRow.TYPE_MSG_SENT_SEEN, 0, "Not aneek Nibba", getString(R.string.aneek_dp_url), "Demmo message bixxxes", "6:09PM");
        mMessageList.add(messageListRow);

        mMessageAdapter.notifyDataSetChanged();

    }

}
