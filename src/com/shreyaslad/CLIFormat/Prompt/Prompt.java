/***
 * Prompt.java
 * Copyright Shreyas Lad 2019
 *
 * Contains a small abstract class with a getter and a setter to serve as a high level foundation for other types of prompts
 */

package com.shreyaslad.CLIFormat.Prompt;

public abstract class Prompt {
    private boolean isRecursive; //Set whether the prompt is recursive or single comman
    private char promptBeginCharacter; // Set the character to signify the start of a new prompt

    /**
     * @param recursive Sets whether the prompt is recursive or not. Accessed from StringPrompts and NumericalPrompts, not the user
     */
    public void setRecursive(boolean recursive) {
        this.isRecursive = recursive;
    }

    /**
     * @param character the character for which the prompt will start with
     */
    public void setBeginString(char character) {
        this.promptBeginCharacter = character;
    }

    /**
     * @return isRecursive true for recursive, false for single question
     */
    public boolean getIsRecursive() {
        return isRecursive;
    }

    /**
     * @return promptBeginCharacter
     */
    public char getPromptBeginCharacter() {
        return promptBeginCharacter;
    }

    /**
     * @param recursive Whether the prompt is recursive or single question (accessible to StringPrompt and NumericalPrompt
     * @param begin The character signifying the start of a new prompt
     */
    public Prompt(boolean recursive, char begin) {
        setRecursive(recursive);

    }
}
