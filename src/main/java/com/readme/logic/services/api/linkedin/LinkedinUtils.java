package com.readme.logic.services.api.linkedin;

import io.github.cdimascio.dotenv.Dotenv;

public class LinkedinUtils {
    public static final String API_TOKEN = Dotenv.load().get("LINKEDIN_API_TOKEN");
}
