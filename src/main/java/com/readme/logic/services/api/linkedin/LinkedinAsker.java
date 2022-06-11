package com.readme.logic.services.api.linkedin;

import com.readme.logic.services.utils.types.linkedin.BodySchema;
import com.readme.logic.services.utils.types.linkedin.MemberNetworkVisibility;
import com.readme.logic.services.utils.types.linkedin.ShareContent;
import com.readme.logic.services.utils.types.linkedin.ShareMedia;

import java.util.Scanner;

public class LinkedinAsker {
    private final Scanner readScanner = new Scanner(System.in);
    private BodySchema bodySchema;
    private ShareContent shareContent;
    private ShareMedia shareMedia;


    protected void startLinkedinAsker() {
        System.out.println("Hello :-)\nWhich type of pub would you like to share?\nNormal - N\nArticle - A\nComposed - C\n:");
        String insertedLine;
        char typeOfShare = ' ';

        while (typeOfShare != 'n' && typeOfShare != 'a' && typeOfShare != 'c') {
            insertedLine = readScanner.nextLine().trim().toLowerCase();
            typeOfShare = insertedLine.length() > 0 ? insertedLine.charAt(0) : ' ';

            switch (typeOfShare) {
                case 'n':
                    bodySchema = bodySchemaLoading();
                    break;
                case 'a':
                    shareContent = shareContentLoading();
                    break;
                case 'c':
                    shareMedia = shareMediaLoading();
                    break;
            }

        }
    }

    private ShareMedia shareMediaLoading() {
        return null;
    }

    private ShareContent shareContentLoading() {
        return null;
    }

    private BodySchema bodySchemaLoading() {
        BodySchema bodySchema = new BodySchema();

        System.out.print("Author: ");
        bodySchema.setAuthor(readScanner.nextLine());

        bodySchema.setLifecycleState("PUBLISHED");// PUBLISHED: For the purposes of creating a share, the lifecycleState will always be PUBLISHED.

        System.out.println("Content: ");
        bodySchema.setSpecificContent(readScanner.nextLine());

        System.out.print("Visibility [CONNECTIONS - C, PUBLIC - P]: ");
        bodySchema.setVisibility(MemberNetworkVisibility.CONNECTIONS.getMemberNetworkVisibilityByCharacter(readScanner.nextLine().charAt(0)));

        return bodySchema;
    }

    public BodySchema getBodySchema() {
        return bodySchema;
    }

    public ShareContent getShareContent() {
        return shareContent;
    }

    public ShareMedia getShareMedia() {
        return shareMedia;
    }
}