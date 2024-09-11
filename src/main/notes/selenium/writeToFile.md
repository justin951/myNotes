To capture the questions and answers in a document instead of printing them to the terminal, you can modify the `printQuestionAndAnswerMap` method to write the data into a file. Java provides several ways to write to a file, such as using `FileWriter` or `BufferedWriter`. Here's how you could adjust the method to save the output to a `.txt` file:

### Updated `printQuestionAndAnswerMap` Method:
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public void saveQuestionAndAnswerMapToFile(String fileName) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        for (Integer questionNumber : questionAndAnswerMap.keySet()) {
            HashMap<String, String> qaPair = questionAndAnswerMap.get(questionNumber);
            String question = qaPair.get("question");
            String answer = qaPair.get("answer");

            writer.write("Question " + questionNumber + ":");
            writer.newLine();
            writer.write(question);
            writer.newLine();
            writer.newLine();
            writer.write("Answer:");
            writer.newLine();
            writer.write(answer);
            writer.newLine();
            writer.write("===================================================");
            writer.newLine();
            writer.newLine();
        }
    } catch (IOException e) {
        System.out.println("An error occurred while writing to the file.");
        e.printStackTrace();
    }
}
```

### How it works:
- `FileWriter` is used to write to a file, and `BufferedWriter` is used for efficient writing.
- The method iterates through the `questionAndAnswerMap` and writes each question and its corresponding answer into a file.
- The `try-with-resources` statement ensures that the `BufferedWriter` is closed automatically after use, preventing resource leaks.

### Usage:
To use this new method, simply call it after you have populated the question and answer map:

```java
apiTestingIQ.saveQuestionAndAnswerMapToFile("api_testing_questions_and_answers.txt");
```

You can adjust the file path as necessary to save the file in a specific location.

