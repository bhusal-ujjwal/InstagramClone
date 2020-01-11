package com.ujjwal.instagram.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ujjwal.instagram.models.PostModel;
import com.ujjwal.instagram.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{

    private List<PostModel> list;

    public PostAdapter(List<PostModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.insta_post_card, parent, false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostModel post = list.get(position);
        holder.tvUsername.setText(post.getPostBy());
        holder.tvCaption.setText(post.getCaption());
        holder.imgProfilePicPost.setImageResource(post.getAuthorPic());
        holder.imgPost.setImageResource(post.getPost());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imgProfilePicPost;
        ImageView imgPost;
        TextView tvUsername, tvCaption;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfilePicPost = itemView.findViewById(R.id.imgProfilePicPost);
            imgPost = itemView.findViewById(R.id.imgPost);
            tvCaption = itemView.findViewById(R.id.tvCaption);
            tvUsername = itemView.findViewById(R.id.tvUsername);

        }
    }

}
