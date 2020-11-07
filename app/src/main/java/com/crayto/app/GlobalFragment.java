package com.crayto.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;


import com.crayto.app.Adapters.GlobalGridPostsAdapter;
import com.crayto.app.Adapters.GlobalTrendingGridAdapter;
import com.crayto.app.Classes.ExpandableHeightGridView;
import com.crayto.app.Classes.GlobalPost;
import com.crayto.app.Classes.GlobalTrending;
import com.crayto.app.Classes.MyUtils;

import java.util.ArrayList;
import java.util.List;

public class GlobalFragment extends Fragment {

    // View decalration
    private View mGlobalNotch;
    private ExpandableHeightGridView mMainGridView, mTrendingGridView;
    private SwipeRefreshLayout mRootLayout;

    // Trending Grid posts and adapter
    private GlobalTrendingGridAdapter mTrendingAdapter;
    private List<GlobalTrending> mTrendings = new ArrayList<>();

    // Main Grid posts and adapter
    private GlobalGridPostsAdapter mMainAdapter;
    private List<GlobalPost> mPosts = new ArrayList<>();

    // Class declarations
    private MyUtils mMyUtils = new MyUtils();

    public GlobalFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         View rootview = inflater.inflate(R.layout.fragment_global, container, false);

        // Connecting view to code
        mGlobalNotch = (View) rootview.findViewById(R.id.global_top_notch);
        mMainGridView = (ExpandableHeightGridView) rootview.findViewById(R.id.global_main_gridview);
        mTrendingGridView = (ExpandableHeightGridView) rootview.findViewById(R.id.global_trending_gridview);
        mRootLayout = (SwipeRefreshLayout) rootview.findViewById(R.id.global_root_holder);

        // For the different color effects
        mGlobalNotch.getLayoutParams().height = mMyUtils.getPixelsFromDp(55, getContext()) + mMyUtils.getStatusBarHeight(getContext());
        mGlobalNotch.requestLayout();

        // Setting up trending Grid View and adapter
        mTrendingAdapter = new GlobalTrendingGridAdapter(getContext(), mTrendings);
        mTrendingGridView.setAdapter(mTrendingAdapter);
        mTrendingGridView.setExpanded(true);
        mMainGridView.setFocusable(false);

        // TODO remove test posts
        insertTrendings();

        // Setting up main Grid View and adapter
        mMainAdapter = new GlobalGridPostsAdapter(getContext(), mPosts);
        mMainGridView.setAdapter(mMainAdapter);
        mMainGridView.setExpanded(true);
        mMainGridView.setFocusable(false);

        // TODO remove test posts
        insertPostsToAdapter();

        return rootview;

    }

    private void insertPostsToAdapter(){


        for(int i = 0; i < 12; i++){

            GlobalPost post = new GlobalPost(0, 100, 3900);
            mPosts.add(post);

        }

        mMainAdapter.notifyDataSetChanged();

    }

    private void insertTrendings(){

        GlobalTrending trending = new GlobalTrending("#aneeklives", 1000);
        mTrendings.add(trending);

        trending = new GlobalTrending("#caritbitch", 2938);
        mTrendings.add(trending);

        trending = new GlobalTrending("#yolo", 199);
        mTrendings.add(trending);

        trending = new GlobalTrending("#whymylyfgottabesosad?", 29);
        mTrendings.add(trending);

        trending = new GlobalTrending("#needbitches",215888);
        mTrendings.add(trending);

        trending = new GlobalTrending("#sexitupnuggah", 12992139);
        mTrendings.add(trending);

        trending = new GlobalTrending("#myfirstcummings", 21939);
        mTrendings.add(trending);

        trending = new GlobalTrending("#itsonbruvvv", 5250392);
        mTrendings.add(trending);

        mTrendingAdapter.notifyDataSetChanged();

    }

    // TODO Remove this block if not needed (Trending holder size method)
    private void setTrendingHolderSize(RecyclerView v){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int displayWidth = displayMetrics.widthPixels;

        final float scale = getContext().getResources().getDisplayMetrics().density;
        int pixelsFrom24Dp = (int) (24 * scale + 0.5f);
        int pixelsFrom60Dp = (int) (80 * scale + 0.5f);

        int adjustedWidthPerIV = ( displayWidth - pixelsFrom24Dp ) / 3;
        int adjustedHeightPerIV = adjustedWidthPerIV + pixelsFrom60Dp;

        v.getLayoutParams().height = adjustedHeightPerIV;
        v.requestLayout();

    }

}
