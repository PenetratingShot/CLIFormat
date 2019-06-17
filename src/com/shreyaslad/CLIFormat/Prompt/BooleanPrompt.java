package com.shreyaslad.CLIFormat.Prompt;

import java.util.LinkedList;
import java.util.Scanner;

public class BooleanPrompt {
    private boolean defaultChoice;
    private String question;
    private String[] questions;
    private LinkedList<Boolean> answers = new LinkedList<>();
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

    @SuppressWarnings("Duplicates")
    public void createPromptWithMultipleQuestions(String[] questions) {
        this.questions = questions;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questions.length; i++) {
            this.currentQuestion = questions[i];
            this.lastQuestionInArray = questions[questions.length-1];
            System.out.println(questions[i] + " " + "[" + character + "/" + character2 + "]: ");
            System.out.println(beginPromptCharacter + " ");
            this.answer = scanner.next();
            if (this.answer.toLowerCase().equals("y") ||  this.answer.toLowerCase().equals("yes")) {
                this.lastAnswer = true;
                answers.add(true);
            } else if (this.answer.toLowerCase().equals("n") || this.answer.toLowerCase().equals("no")) {
                this.lastAnswer = false;
                answers.add(false);
            } else if (this.answer.equals("")) {
                this.lastAnswer = defaultChoice;
                answers.add(defaultChoice);
            } else {
                keep(); // If none of the actual characters are supplied, then re-prompt the question
            }
        }
    }

    public LinkedList<Boolean> getAllAnswers() {
        return answers;
    }

    @SuppressWarnings("Duplicates")
    public void createPromptWithOneQuestion(String question) {
        this.question = question;
        Scanner scanner = new Scanner(System.in);
        System.out.println(question + "[" + character + "/" + character2 + "]: ");
        System.out.println(beginPromptCharacter + " ");
        this.answer = scanner.next();
        if (this.answer.toLowerCase().equals("y") || this.answer.toLowerCase().equals("yes")) {
            this.lastAnswer = true;
        } else if (this.answer.toLowerCase().equals("n") || this.answer.toLowerCase().equals("no")) {
            this.lastAnswer = false;
        } else if (this.answer.toLowerCase().equals("")) {
            this.lastAnswer = this.defaultChoice;
        } else {
            keep2();
        }
        boolean middleAnswer = Boolean.parseBoolean(this.answer); // Solves weird bug where outputted answer is inverse of what user inputted
        this.lastAnswer = !middleAnswer;
    }

    public boolean getLastAnswer() {
        return this.lastAnswer;
    }

    // Recursive functions for when the user enters something other than the desired inputs
    @SuppressWarnings("Duplicates")
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
                keep();
            }
        }
    }

    @SuppressWarnings("Duplicates")
    private void keep2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(beginPromptCharacter + " " + question + "[" + character + "/" + character2 + "]: ");
        this.answer = scanner.next();
        if (this.answer.toLowerCase().equals("y") || this.answer.toLowerCase().equals("yes")) {
            this.lastAnswer = true;
        } else if (this.answer.toLowerCase().equals("n") || this.answer.toLowerCase().equals("no")) {
            this.lastAnswer = false;
        } else if (this.answer.toLowerCase().equals("")) {
            this.lastAnswer = this.defaultChoice;
        } else {
            keep2();
        }
    }
}
