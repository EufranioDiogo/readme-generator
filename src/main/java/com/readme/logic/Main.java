package com.readme.logic;


import com.readme.logic.utils.FileType;

import static com.readme.logic.utils.api.PublishPlace.LINKEDIN_API;

public class Main {
    public static void main(String[] args) {
        //TemplateGenerator.generateFile(FileType.README, "README.md");
        PostPublisher.publishPost(LINKEDIN_API);
    }
}