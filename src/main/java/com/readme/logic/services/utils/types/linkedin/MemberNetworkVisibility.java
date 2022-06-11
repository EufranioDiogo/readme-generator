package com.readme.logic.services.utils.types.linkedin;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

public enum MemberNetworkVisibility implements Serializable {
    CONNECTIONS('C') {
        @Override
        public String toString() {
            return "CONNECTIONS";
        }
    },
    PUBLIC('P') {
        @Override
        public String toString() {
            return "PUBLIC";
        }
    };
    private final char designationLetter;

    MemberNetworkVisibility(char designationLetter) {
        this.designationLetter = designationLetter;
    }

    public MemberNetworkVisibility getMemberNetworkVisibilityByCharacter(char memberNetworkVisibilityCharacter) {
        return Arrays
                .stream(MemberNetworkVisibility.values())
                .filter(memberNetworkVisibility1 -> memberNetworkVisibility1.designationLetter == memberNetworkVisibilityCharacter)
                .findFirst()
                .orElseThrow(() -> {
                    throw new RuntimeException("Not type of post with this designation letter");
                });
    }
}
