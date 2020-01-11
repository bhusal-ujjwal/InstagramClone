package com.ujjwal.instagram.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ujjwal.instagram.adapters.PostAdapter;
import com.ujjwal.instagram.R;
import com.ujjwal.instagram.activities.MainActivity;
import com.ujjwal.instagram.adapters.StoryAdapter;

import static com.ujjwal.instagram.activities.MainActivity.listStories;

public class PostFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView rvStories;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        recyclerView = view.findViewById(R.id.postRecyclerView);
        rvStories = view.findViewById(R.id.rvStories);

        PostAdapter postAdapter = new PostAdapter(MainActivity.listPosts);
        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        StoryAdapter adapter = new StoryAdapter(listStories, getContext());
        rvStories.setAdapter(adapter);
        rvStories.setLayoutManager(layoutManager);


        return view;
    }

}
