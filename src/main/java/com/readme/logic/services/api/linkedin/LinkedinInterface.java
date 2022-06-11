package com.readme.logic.services.api.linkedin;

import com.readme.logic.services.utils.types.linkedin.BodySchema;
import com.readme.logic.services.utils.types.linkedin.ShareContent;
import com.readme.logic.services.utils.types.linkedin.ShareMedia;

public interface LinkedinInterface {
    boolean sharePost(BodySchema bodySchema, ShareContent shareContent, ShareMedia shareMedia);
}
