package testingAutomation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testingAutomation.pom.APITestingIQ;
import testingAutomation.pom.TestingAutomationIQ;
import testingAutomation.pom.TestingFundamentalsIQ;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = null;
        String filepath;
        try {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            TestingAutomationIQ testingAutomationIQ = new TestingAutomationIQ(driver);
            testingAutomationIQ.goToTestingAutomationIQ();
            testingAutomationIQ.verifyOnTestingAutomationIQPage();
            testingAutomationIQ.getAllQuestions();
            testingAutomationIQ.getAllAnswers();
            testingAutomationIQ.printQuestionAndAnswerMap();
            filepath = "src\\main\\resources\\testingAutomationIQ.txt";
            testingAutomationIQ.saveQuestionAndAnswerMapToFile(filepath);

            APITestingIQ apiTestingIQ = new APITestingIQ(driver);
            apiTestingIQ.goToTestingAutomationIQ();
            apiTestingIQ.verifyOnTestingAutomationIQPage();
            apiTestingIQ.getAllQuestions();
            apiTestingIQ.getAllAnswers();
            apiTestingIQ.printQuestionAndAnswerMap();
            filepath = "src\\main\\resources\\apiTestingIQ.txt";
            apiTestingIQ.saveQuestionAndAnswerMapToFile(filepath);

            TestingFundamentalsIQ testingFundamentalsIQ = new TestingFundamentalsIQ(driver);
            testingFundamentalsIQ.goToTestingAutomationIQ();
            testingFundamentalsIQ.verifyOnTestingAutomationIQPage();
            testingFundamentalsIQ.getAllQuestions();
            testingFundamentalsIQ.getAllAnswers();
            testingFundamentalsIQ.printQuestionAndAnswerMap();
            filepath = "src\\main\\resources\\testingFundamentalsIQ.txt";
            testingFundamentalsIQ.saveQuestionAndAnswerMapToFile(filepath);
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
