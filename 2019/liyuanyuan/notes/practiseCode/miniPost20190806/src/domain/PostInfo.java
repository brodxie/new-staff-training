package domain;

public class PostInfo {

    public int postId;

    public String postTitle;

    public String postContent;

    public int userId;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public PostInfo() {
    }

    public PostInfo(String postTitle, int userId) {
        this.postTitle = postTitle;
        this.userId = userId;
    }

    public PostInfo(String postTitle, String postContent, int userId) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.userId = userId;
    }

}
