package com.ujjwal.instagram.models;

public class PostModel {

    private String postId, postBy, caption;
    int post, authorPic;
//    int loveCount, loveReacts, comments;


    public PostModel(String postId, String postBy, String caption, int post, int authorPic) {
        this.postId = postId;
        this.postBy = postBy;
        this.caption = caption;
        this.post = post;
        this.authorPic = authorPic;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostBy() {
        return postBy;
    }

    public void setPostBy(String postBy) {
        this.postBy = postBy;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public int getAuthorPic() {
        return authorPic;
    }

    public void setAuthorPic(int authorPic) {
        this.authorPic = authorPic;
    }

}
