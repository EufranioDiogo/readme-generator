package com.readme.logic.utils;


import java.util.Locale;
import java.util.ResourceBundle;

public enum ReadmeTemplateParam {
    USER_NAME("user_name_param", true) {
    },
    REPO_NAME("repo_name_param", true) {
    },
    DOMAIN_NAME("domain_name_param", false) {
    },
    ABOUT_PROJECT("about_project_param", false) {
    },
    BUILT_WITH("built_with_param", false) {
    },
    GETTING_STARTED("getting_started_param", false) {
    },
    PREREQUISITES("prerequisites_param", false) {
    },
    USAGE_EXAMPLES("usage_examples_param", false) {
    },
    TASKS("tasks_param", false) {
    },
    LICENSE("license_param", false) {
    },
    ACKNOWLEDGMENTS("acknowledgments_param", false) {
    },
    SCREENSHOT("screenshot_param", false) {};
    private final String paramName;
    private final boolean isObligated;

    ReadmeTemplateParam(String paramName, boolean isObligated) {
        this.paramName = paramName;
        this.isObligated = isObligated;
    }

    public String getParamQuestion() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("labels", Locale.getDefault());
        String questionParam = this.toString().replace("param", "question");
        boolean containsKey = resourceBundle.containsKey(questionParam);

        return containsKey ? resourceBundle.getString(questionParam) : resourceBundle.getString("");
    }

    public boolean isObligated() {
        return isObligated;
    }

    @Override
    public String toString() {
        return paramName;
    }
}
