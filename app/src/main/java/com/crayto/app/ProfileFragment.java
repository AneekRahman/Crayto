package com.crayto.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.crayto.app.Adapters.ProfileUserPostsAdapter;
import com.crayto.app.Classes.ExpandableHeightGridView;
import com.crayto.app.Classes.MyUtils;
import com.crayto.app.Classes.ProfileUserGridPost;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    // View declaration
    private ImageView mUserDpImageView;
    private ExpandableHeightGridView mGridView;
    private SwipeRefreshLayout mRootLayout;

    // Class Declarations
    private MyUtils mMyUtils = new MyUtils();

    // Profile grid posts list and adapter
    private ProfileUserPostsAdapter mAdapter;
    private List<ProfileUserGridPost> mPosts = new ArrayList<>();

    public ProfileFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_profile, container, false);

        // Connecting view to code
        mUserDpImageView = (ImageView) rootview.findViewById(R.id.profile_user_dp_imageview);
        mGridView = (ExpandableHeightGridView) rootview.findViewById(R.id.profile_posts_gridview);
        mRootLayout = (SwipeRefreshLayout) rootview.findViewById(R.id.profile_root_layout);

        // For the different color effects
        mRootLayout.setPadding(0, mMyUtils.getPixelsFromDp(55, getContext()) + mMyUtils.getStatusBarHeight(getContext()), 0, 0);

        // Load the users profile
        Glide.with(this)
                .load(getString(R.string.aneek_dp_url))
                .apply(RequestOptions.centerCropTransform())
                .into(mUserDpImageView);

        // Setting up the Gridview and its adapter
        mAdapter = new ProfileUserPostsAdapter(getContext(), mPosts);
        mGridView.setAdapter(mAdapter);
        mGridView.setExpanded(true);
        mGridView.setFocusable(false);

        // TODO remove test posts
        insertPostsToAdapter();

        return rootview;

    }

    private void insertPostsToAdapter(){

        ProfileUserGridPost post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        post = new ProfileUserGridPost(0, "");
        mPosts.add(post);

        mAdapter.notifyDataSetChanged();

    }

}
