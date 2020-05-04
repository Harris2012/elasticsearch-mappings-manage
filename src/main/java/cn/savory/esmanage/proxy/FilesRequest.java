package cn.savory.esmanage.proxy;

import com.google.gson.annotations.SerializedName;

public class FilesRequest {

    @SerializedName("branch")
    private String branch;

    @SerializedName("author_email")
    private String authorEmail;

    @SerializedName("author_name")
    private String authorName;

    @SerializedName("content")
    private String content;

    @SerializedName("commit_message")
    private String commitMessage;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommitMessage() {
        return commitMessage;
    }

    public void setCommitMessage(String commitMessage) {
        this.commitMessage = commitMessage;
    }
}
