package com.shreyaslad.CLIFormat;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Format cliFormat = GenericBuilder.of(Format::new)
                .with(Format::setFlagString, "--create").with(Format::setTypeFlag, 0).build();
        System.out.println(cliFormat.getFlag());
    }
}
