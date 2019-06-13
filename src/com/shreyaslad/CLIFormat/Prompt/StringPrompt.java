/***
 * StringPrompt.java
 * @author Shreyas Lad
 */

/**
 * TODO:
 *
 * 1. Add user supplying arrays of questions in recursive mode (this can be done in a later release)
 * 2. Add custom escape messages
 * 3. Add prompt titles
 * 4. Converting and parsing multiple values with a defined separator
 */

package com.shreyaslad.CLIFormat.Prompt;

import java.util.LinkedList;
import java.util.Scanner;

public class StringPrompt {

    private boolean isRecursive;
    private char beginCharacter;
    private String question;
    private String answer;
    private String escapeSequence;

    /**
     * @param isRecursive Boolean value to set whether it is recursive or single question
     */
    public void setIsRecursive(boolean isRecursive) {
        this.isRecursive = isRecursive;
    }

    public void setBeginCharacter(char beginCharacter) {
        this.beginCharacter = beginCharacter;
    }

    public void setEscapeSequence(String escapeSequence) {
        this.escapeSequence = escapeSequence;
    }

    public String getEscapeSequence() {
        return this.escapeSequence;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public LinkedList<String> getAllQuestions() {
        return questionsList;
    }

    public LinkedList<String> getAllAnswers() {
        return answersList;
    }

    public boolean getIsRecursive() {
        return this.isRecursive;
    }

    public char getBeginCharacter() {
        return this.beginCharacter;
    }

    /**
     * {@code StringPrompt prompt = new StringPrompt(true, '> ');}
     * @param isRecursive Boolean value to set whether it is recursive or single question
     * @param character Specify the beginning character for the start of the prompt
     * @param escapeSequence The sequence that the user has to enter in order to exit the prompt
     */
    public StringPrompt(boolean isRecursive, char character, String escapeSequence) {
        setIsRecursive(isRecursive);
        setBeginCharacter(character);
        setEscapeSequence(escapeSequence);
    }

    private LinkedList<String> questionsList = new LinkedList<>();
    private LinkedList<String> answersList = new LinkedList<>();

    public void setNextQuestion(String question) {
        if (isRecursive) {
            throw new IllegalArgumentException("You cannot set a question in recursive mode. Switch to single question mode to enable this.");
        } else {
            this.question = question;
            notRecursive();
        }

        if (beginCharacter == ' ') {
            throw new IllegalArgumentException("The prompt begin character must be set.");
        }

        if (escapeSequence.equals(" ")) {
            throw new IllegalArgumentException("You have not set an escape command.");
        }

    }

    // Yes IntelliJ I know that it's recursive. That's the damn point of this function
    private void keep() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(this.beginCharacter);
            this.answer = scanner.nextLine();
            if (this.answer.equals(escapeSequence)) {
                // Instead of clearing the question and answer list, define functions above which the user can invoke
                System.out.println("\nExiting...\n");
                System.exit(0);
            } else {
                answersList.add(this.answer);
            }
            keep();

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void notRecursive() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(this.question);
            System.out.println(this.beginCharacter);
            this.answer = scanner.nextLine();
            if (this.answer.equals(escapeSequence)) {
                // Instead of clearing the question and answer list, define functions above which the user can invoke
                System.out.println("\nExiting...\n");
                System.exit(0);
            } else {
                answersList.add(this.answer);
            }

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}