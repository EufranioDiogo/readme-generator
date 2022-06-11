package com.readme.logic.services.utils.types.linkedin;

import org.json.JSONObject;

public class BodySchema {
    private String author;
    private String lifecycleState;
    private String specificContent;
    private MemberNetworkVisibility visibility;

    public BodySchema() {}

    public BodySchema(String author, String lifecycleState, String specificContent, MemberNetworkVisibility visibility) {
        this.author = author;
        this.lifecycleState = lifecycleState;
        this.specificContent = specificContent;
        this.visibility = visibility;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLifecycleState() {
        return lifecycleState;
    }

    public void setLifecycleState(String lifecycleState) {
        this.lifecycleState = lifecycleState;
    }

    public String getSpecificContent() {
        return specificContent;
    }

    public void setSpecificContent(String specificContent) {
        this.specificContent = specificContent;
    }

    public MemberNetworkVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(MemberNetworkVisibility visibility) {
        this.visibility = visibility;
    }

    public JSONObject getJSONMap() {
        JSONObject response = new JSONObject();
        JSONObject shareContent = (new JSONObject())
                .put("shareCommentary",
                        (new JSONObject())
                                .put("text", this.specificContent));

        shareContent.put("shareMediaCategory", "NONE");

        response.put("author", "urn:li:person:" + this.author);
        response.put("lifecycleState", this.lifecycleState);
        response.put("specificContent",
                (new JSONObject())
                        .put("com.linkedin.ugc.ShareContent",
                                shareContent));
        response.put("visibility",
                (new JSONObject())
                        .put("com.linkedin.ugc.MemberNetworkVisibility", this.visibility));
        return response;
    }
}
