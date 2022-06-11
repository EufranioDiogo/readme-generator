package com.readme.logic;
import com.readme.logic.services.api.linkedin.LinkedinPublisher;
import com.readme.logic.utils.api.PublishPlace;

public class PostPublisher {
    public static boolean publishPost(PublishPlace publishPlace) {
        if (publishPlace == PublishPlace.LINKEDIN_API) {
            LinkedinPublisher linkedinPublisher = new LinkedinPublisher();
            return linkedinPublisher.sharePost();
        }
        return false;
    }
}
