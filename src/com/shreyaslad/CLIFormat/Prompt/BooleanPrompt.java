package com.shreyaslad.CLIFormat.Prompt;

import java.util.LinkedList;
import java.util.Scanner;

public class BooleanPrompt {
    private boolean defaultChoice;
    private String question;
    private String[] questions;
    private LinkedList<Boolean> answers;
    private String answer;
    private boolean lastAnswer;
    private char beginPromptCharacter;
    private String currentQuestion;
    private String lastQuestionInArray;

    private char character;
    private char character2;

    public BooleanPrompt(char beginPromptCharacter, boolean defaultChoice) {
        this.beginPromptCharacter = beginPromptCharacter;
        this.defaultChoice = defaultChoice;

        if (defaultChoice) {
            character = 'Y';
            character2 = 'n';

        } else {
            character = 'y';
            character2 = 'N';
        }
    }

    public LinkedList<Boolean> createPromptWithMultipleQuestions(String[] questions) {
        this.questions = questions;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questions.length; i++) {
            this.currentQuestion = questions[i];
            this.lastQuestionInArray = questions[i-1];
            System.out.println(beginPromptCharacter + " " + questions[i] + "[" + character + "/" + character2 + "]: ");
            this.answer = scanner.next();
            if (this.answer.toLowerCase().equals("y") ||  this.answer.toLowerCase().equals("yes")) {
                answers.add(true);
                this.lastAnswer = true;
            } else if (this.answer.toLowerCase().equals("n") || this.answer.toLowerCase().equals("no")) {
                answers.add(false);
                this.lastAnswer = false;
            } else if (this.answer.equals(Boolean.toString(defaultChoice))) {
                this.lastAnswer = defaultChoice;
                answers.add(defaultChoice);
            } else {
                // put recursive prompt here (god this is going to be hard)
                keep();
            }
        }
        return answers;
    }

    public String createPromptWithOneQuestion(String question) {
        this.question = question;
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        this.answer = scanner.next();
        return answer;
    }

    public boolean getLastAnswer() {
        return this.lastAnswer;
    }

    // yes IntelliJ I know that it's duplicate code that's the entire point
    private void keep() {
        Scanner scanner = new Scanner(System.in);
        if (this.currentQuestion.equals(this.lastQuestionInArray)) {
            System.out.println(currentQuestion);
            this.answer = scanner.next();
            if (this.answer.toLowerCase().equals("y") ||  this.answer.toLowerCase().equals("yes")) {
                answers.add(true);
                this.lastAnswer = true;
            } else if (this.answer.toLowerCase().equals("n") || this.answer.toLowerCase().equals("no")) {
                answers.add(false);
                this.lastAnswer = false;
            } else if (this.answer.equals(Boolean.toString(defaultChoice))) {
                this.lastAnswer = defaultChoice;
                answers.add(defaultChoice);
            } else {
                // put recursive prompt here (god this is going to be hard)
                keep();
            }
        }
    }
}
