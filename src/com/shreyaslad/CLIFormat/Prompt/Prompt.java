/***
 * Prompt.java
 * Copyright Shreyas Lad 2019
 *
 * Contains a small abstract class with a getter and a setter to serve as a high level foundation for other types of prompts
 */

package com.shreyaslad.CLIFormat.Prompt;

public abstract class Prompt {
    private boolean isRecursive; // Determines whether the prompt is recursive or not

    public static boolean isRecursive() {
        return recursive;
    }

    public static void setRecursive(boolean isRecursive) {
        this.isRecursive = isRecursive;
    }
}