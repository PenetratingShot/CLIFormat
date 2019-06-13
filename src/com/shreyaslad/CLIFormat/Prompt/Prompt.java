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
     *
     * @param recursive Sets whether the prompt is recursive or not. Accessed from StringPrompts and NumericalPrompts, not the user
     *                  
     */
    public void setRecursive(boolean recursive) {
        this.isRecursive = recursive;
    }

    public void setBeginString(char character) {
        this.promptBeginCharacter = character;
    }

    public boolean getIsRecursive() {
        return isRecursive;
    }

    public char getPromptBeginCharacter() {
        return promptBeginCharacter;
    }

    public Prompt(boolean recursive, char begin) {
        setRecursive(recursive);

    }
}
