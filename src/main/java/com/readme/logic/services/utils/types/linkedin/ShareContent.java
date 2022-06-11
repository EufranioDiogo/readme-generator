package com.readme.logic.services.utils.types.linkedin;

public class ShareContent {
    private String shareCommentary;
    private String shareMediaCategory;
    private ShareMedia[] media;

    public ShareContent(String shareCommentary, String shareMediaCategory, ShareMedia[] media) {
        this.shareCommentary = shareCommentary;
        this.shareMediaCategory = shareMediaCategory;
        this.media = media;
    }

    public ShareContent() {

    }
}
