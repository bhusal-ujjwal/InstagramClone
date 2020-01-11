package com.ujjwal.instagram.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ujjwal.instagram.R;
import com.ujjwal.instagram.models.StoryModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

   List<StoryModel> listStories;
   Context mContext;

    public StoryAdapter(List<StoryModel> listStories, Context mContext) {
        this.listStories = listStories;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.insta_story_card, parent, false);

        return new StoryViewHolder(view, mContext, listStories);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        StoryModel story = listStories.get(position);
        holder.story.setImageResource(story.getDailyPhoto());
        holder.name.setText(story.getName());
    }

    @Override
    public int getItemCount() {
        return listStories.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder{

        CircleImageView story;
        TextView name;
        Context mContext;
        List<StoryModel> list;

        public StoryViewHolder(@NonNull View itemView, final Context mContext, final List<StoryModel> list) {
            super(itemView);
            story = itemView.findViewById(R.id.imgInstaStory);
            name = itemView.findViewById(R.id.tvStoryBy);
            this.mContext = mContext ;
            this.list = list;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StoryModel story = list.get(getAdapterPosition());
                    Toast.makeText(mContext, "" + story.getName(), Toast.LENGTH_SHORT).show();

                }
            });

        }

    }
}
