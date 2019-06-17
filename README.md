# CLIFormat

A library to create simple, intuitive prompts

## Development

- [ ] Prompts
    - [x] StringPrompt
        - [x] Recursive
        - [x] Getters and Setters
        - [x] Recursion
        - [x] Question Check
        - [x] Exception Throwing
        - [x] Single Question
    - [ ] NumericalPrompt
 
- [x] Format Class
    - [x] Variables
    - [x] Getters
    - [x] Setters
- [x] Function Builder
    - [x] Generics
- [ ] Flags
    - [x] "--" flags
    - [ ] "-" flags out of "--" flags
    - [ ] priority flags (0, 1, 2)
 

You can access the flagString, which in this case would be `--create` by doing `format.getFlagString`.

You can access the priority setting by doing `format.getTypeFlag`.

## Usage

This is only updated for BooleanPrompt because that's the only thing that works so far and the only one I've invested time into so far

### BooleanPrompt

`public BooleanPrompt(char beginPromptCharacter, boolean defaultChoice)`

`public void createPromptWithMultipleQuestions(String[] questions)`

`public void createPromptWithOneQuestion(String question)`

`public LinkedList<Boolean> getAllAnswers()`

`public boolean getLastAnswer()`

#### Examples

```java
// Creating a prompt with multiple questions
import com.shreyaslad.CLIFormat.Prompts.BooleanPrompt;

String[] questions = {"Question 1?", "Question 2?", "Question 3?"};
BooleanPrompt booleanPrompt = new BooleanPrompt('>', true);

booleanPrompt.createPromptWithMultipleQuestions(questions);
LinkedList<Boolean> list = booleanPrompt.getAllAnswers();

System.out.println(list);
```

```java
// Creating a prompt with one question
import com.shreyaslad.CLIFormat.Prompts.BooleanPrompt;

BooleanPrompt booleanPrompt = new BooleanPrompt('>', true);
booleanPrompt.createPromptWithOneQuestion("Continue?");

boolean answer = booleanPrompt.getAnswer();

System.out.println(answer);
```

#### Update 0.3.1

The StringPrompt class now has support for creating recursive and single question prompts. Note that you cannot supply questions when your prompt is in recursive mode.

**Constructor:**

```java
StringPrompt(boolean isRecursive, char promptBeginCharacter, String escapeSequence)
```

**Functions:**

- `getEscapeSequence()` Gets the current escape sequence that the user can input to terminate the program (String)
- `getQuestion()` Returns the last question that was set by you *(String)*
- `getAnswer()` Returns the last answer that the user gave *(String)*
- `getAllQuestions()` Returns a list of every single question set by you *(LinkedList<String>)*
- `getIsRecursive()` Returns whether the prompt is recursive or single question *(Boolean)*
- `getBeginCharacter()` Returns the character which signifies a new prompt *(Character)*

- `setNextQuestion(String question)` Sets a question that the user needs to see

**Currently, single question mode will ask one question, take one answer, and exit. This is all done through the setNextQuestion() function. Multi-question support might be added later, if I feel like it.**

**Example Usage:**

```java
StringPrompt prompt = new StringPrompt(true, '> ', "exit");
```

#### Update 0.2.0

- Added ability to parse data in between two "solid" flags (flags that will be in that specific order 100% of the time).
- Also flag priority doesn't work. Will be patched once prompt classes are done

```java
Format format = GenericBuilder.of(Format::new)
                .with(Format::setFlagString, "--create").with(Format::setTypeFlag, 0).build();
```

Two new functions: 

1. `CLIRegex.afterFlag(<string>, <flagString>)`
2. `CLIRegex.betweenFlags(<string>, <firstFlag>, <secondFlag>)`

#### Priority Settings

Basically priority settings tell whether the flag can be ignored or not. This is a WIP feature and might be removed because I', not smart enough :/

| Flag | Priority|
|:-----:|:--------:|
| 0 | Not Required |
| 1 | Required|