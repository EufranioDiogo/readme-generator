package com.readme.logic.services.api.linkedin;


import com.readme.logic.services.utils.types.linkedin.BodySchema;
import com.readme.logic.services.utils.types.linkedin.ShareContent;
import com.readme.logic.services.utils.types.linkedin.ShareMedia;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LinkedinPublisher {
    private final BodySchema bodySchema;
    private final ShareContent shareContent;
    private final ShareMedia shareMedia;

    public LinkedinPublisher() {
        LinkedinAsker linkedinAsker = new LinkedinAsker();
        linkedinAsker.startLinkedinAsker();

        this.bodySchema = linkedinAsker.getBodySchema();
        this.shareContent = linkedinAsker.getShareContent();
        this.shareMedia = linkedinAsker.getShareMedia();

    }


    public boolean sharePost() {
        if (this.bodySchema != null) {
            return publishBodySchema();
        } else if (this.shareContent != null) {
            return publishShareContent();
        }
        return publishShareMedia();
    }

    private boolean publishShareMedia() {
        return false;
    }

    private boolean publishShareContent() {
        return false;
    }

    private boolean publishBodySchema() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.linkedin.com/v2/ugcPosts"))
                    .headers("X-Restli-Protocol-Version", "2.0.0")
                    .headers("Content-Type", "text/plain;charset=UTF-8")
                    .headers("Authorization", "Bearer " + LinkedinUtils.API_TOKEN)
                    .POST(HttpRequest.BodyPublishers.ofString(this.bodySchema.getJSONMap().toString()))
                    .build();

            HttpResponse<String> send = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            if (send.statusCode() != 201) {
                throw new RuntimeException("Happened a not pretended action: " + send.body());
            }
            return true;
        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}
