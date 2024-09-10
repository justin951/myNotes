package testingAutomation.pom;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestingAutomationIQ {
    private WebDriver driver;

    private final String url = "https://revaturelabs.github.io/interviewquestions/InterviewSpecificQuestions/Java%20Automation/TestingAutomation.html";

    private WebDriverWait wait;

    private HashMap<Integer, HashMap<String, String>> questionAndAnswerMap = new HashMap<>();

    public TestingAutomationIQ(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    // WEB ELEMENTS
    @FindBy(xpath = "//div[contains(@class, 'container-lg')]")
    private WebElement body;

    @FindBy(tagName = "title")
    private WebElement title;

    // METHODS
    public void goToTestingAutomationIQ() {
        driver.get(url);
    }

    public boolean verifyOnTestingAutomationIQPage() {
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("other")));
        String titleText = driver.getTitle();
        System.out.println("titleText = " + titleText);
        return ("interviewquestions | repo to hold the interview preparation questions".equals(titleText));
    }

    public List<String> getAllQuestions() {
        List<String> questoinTexts = new ArrayList<>();
        List<WebElement> questions = body
                .findElements(By.xpath("//hr/following-sibling::p[1] | //h1/following-sibling::p[1]"));
        int questionNumber = 1;
        for (WebElement question : questions) {
            String questionText = question.getText();
            questoinTexts.add(questionText);

            HashMap<String, String> qaPair = new HashMap<>();
            qaPair.put("question", questionText);
            qaPair.put("answer", "");

            questionAndAnswerMap.put(questionNumber, qaPair);
            questionNumber++;
        }
        return questoinTexts;
    }

    public List<String> getAllAnswers() {
        List<String> answerTexts = new ArrayList<>();
        List<WebElement> detailsElements = body.findElements(By.xpath("//details"));

        int questionNumber = 1;
        for (WebElement details : detailsElements) {
            if (details.getAttribute("open") == null) {
                details.click();
            }

            WebElement blockquote = details.findElement(By.xpath(".//blockquote"));
            // String answerHtml = blockquote.getAttribute("outerHTML");
            String answerText = blockquote.getText();
            answerTexts.add(answerText);

            if (questionAndAnswerMap.containsKey(questionNumber)) {
                questionAndAnswerMap.get(questionNumber).put("answer", answerText);
            }

            questionNumber++;
        }
        return answerTexts;
    }

    public HashMap<Integer, HashMap<String, String>> getQuestionAndAnswerMap() {
        return questionAndAnswerMap;
    }

    public void printQuestionAndAnswerMap() {
        for (Integer questionNumber : questionAndAnswerMap.keySet()) {
            HashMap<String, String> qaPair = questionAndAnswerMap.get(questionNumber);
            String question = qaPair.get("question");
            String answer = qaPair.get("answer");

            System.out.println("Question:");
            System.out.println(question);
            System.out.println();
            System.out.println("Answer " + questionNumber + ":");
            System.out.println(answer);
            System.out.println();
            System.out.println("===================================================");
        }
    }

    public void saveQuestionAndAnswerMapToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Integer questionNumber : questionAndAnswerMap.keySet()) {
                HashMap<String, String> qaPair = questionAndAnswerMap.get(questionNumber);
                String question = qaPair.get("question");
                String answer = qaPair.get("answer");

                writer.write("Question: " + questionNumber + ":");
                writer.newLine();
                writer.write(question);
                writer.newLine();
                writer.newLine();
                writer.write("Answer:");
                writer.newLine();
                writer.write(answer);
                writer.newLine();
                writer.newLine();
                writer.write("===================================================");
                writer.newLine();
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
