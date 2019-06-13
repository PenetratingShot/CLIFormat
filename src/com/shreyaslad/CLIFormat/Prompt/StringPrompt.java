/***
 * StringPrompt.java
 * @author Shreyas Lad
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
     * @param isRecursive Specify if the prompt is supposed to be recursive or single question based
     * @param character Specify the beginning character for the start of the prompt
     */
    public StringPrompt(boolean isRecursive, char character, String escapeSequence) {
        setIsRecursive(isRecursive);
        setBeginCharacter(character);
        setEscapeSequence(escapeSequence);
    }

    private LinkedList<String> questionsList = new LinkedList<>();
    private LinkedList<String> answersList = new LinkedList<>();
    // TODO: Set public getters for these two lists

    public void setNextQuestion(String question) {
        this.question = question;

        if (isRecursive) {
            keep();
        } else {
            // Create single question prompt some∞∞where below and reference here
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
            questionsList.add(question);
            System.out.println(this.beginCharacter);
            System.out.println(question);
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
}