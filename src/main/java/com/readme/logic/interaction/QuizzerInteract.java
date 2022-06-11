package com.readme.logic.interaction;

import com.readme.logic.utils.ReadmeTemplateParam;

import java.util.HashMap;
import java.util.Scanner;

public class QuizzerInteract {

    private final HashMap<String, String> quizzerHashMap = new HashMap<>();

    public HashMap<String, String> askQuestions() {
        for (ReadmeTemplateParam paramElement : ReadmeTemplateParam.values()) {
            answerQuestionBasedOnParam(paramElement);
        }
        return quizzerHashMap;
    }

    private void answerQuestionBasedOnParam(ReadmeTemplateParam readmeParamElement) {
        Scanner scanner = new Scanner(System.in);
        String answer;

        if (readmeParamElement.isObligated()) {
            System.out.println(readmeParamElement.getParamQuestion());
            answer = scanner.nextLine().trim();

            while(answer.isEmpty()) {
                System.out.println(readmeParamElement.getParamQuestion());
                answer = scanner.nextLine().trim();
            }
        } else {
            System.out.print("Do you want put " + readmeParamElement + "?[Y/N](N): ");
            answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("y")) {
                System.out.println(readmeParamElement.getParamQuestion());
                answer = scanner.nextLine().trim();
            }
        }
        this.quizzerHashMap.put(readmeParamElement.toString(), answer);
    }
}
