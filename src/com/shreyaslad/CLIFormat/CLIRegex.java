package com.shreyaslad.CLIFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLIRegex {
    public static String afterFlag(String string, String flag1) {
        // bad interpolation but it works :/
        String regexPattern = "(?<=" + flag1 + ").*";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(string);
        return matcher.group(1);
    }

    // In the string, flag1 MUST BE BEFORE flag2 or else everything will break
    // Find some way to enforce that, or just don't use this shitty function
    public static String betweenFlags(String string, String flag1, String flag2) {
        String regexPattern = flag1 + "(.*)" + flag2;
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(string);
        return matcher.group(1);
    }
}
