package domain;

public class PostDetail {

    public int detailId;

    public int postId;

    public int userId;

    public String detailTitle;

    public String detailContent;

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    public PostDetail(int postId, String detailTitle) {
        this.postId = postId;
        this.detailTitle = detailTitle;
    }

    public PostDetail(int postId, String detailTitle, String detailContent) {
        this.postId = postId;
        this.detailTitle = detailTitle;
        this.detailContent = detailContent;
    }

    public PostDetail(int detailId, int postId, String detailTitle, String detailContent) {
        this.detailId = detailId;
        this.postId = postId;
        this.detailTitle = detailTitle;
        this.detailContent = detailContent;
    }

    @Override
    public String toString() {
        return "PostDetail{" +
                "detailId=" + detailId +
                ", postId=" + postId +
                ", userId=" + userId +
                ", detailTitle='" + detailTitle + '\'' +
                ", detailContent='" + detailContent + '\'' +
                '}';
    }
}
