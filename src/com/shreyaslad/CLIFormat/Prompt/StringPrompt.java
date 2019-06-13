/***
 * StringPrompt.java
 * @author Shreyas Lad
 */

package com.shreyaslad.CLIFormat.Prompt;

public class StringPrompt extends Prompt {
    /**
     * {@code Prompt prompt = new StringPrompt(true, '> ');}
     * @param isRecursive Specify if the prompt is supposed to be recursive or single question based
     * @param character Specify the beginning character for the start of the prompt
     */
    public StringPrompt(boolean isRecursive, char character) {
        super(isRecursive, character);
    }
}
