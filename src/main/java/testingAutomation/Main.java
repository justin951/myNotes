package testingAutomation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testingAutomation.pom.APITestingIQ;
import testingAutomation.pom.AWSIQ;
import testingAutomation.pom.BasePage;
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
            filepath = "src\\main\\resources\\apiTestingIQ.txt";
            runTest(apiTestingIQ, filepath);

            TestingFundamentalsIQ testingFundamentalsIQ = new TestingFundamentalsIQ(driver);
            filepath = "src\\main\\resources\\testingFundamentalsIQ.txt";
            runTest(testingFundamentalsIQ, filepath);

            AWSIQ awsIQ = new AWSIQ(driver);
            filepath = "src\\main\\resources\\awsIQ.txt";
            runTest(awsIQ, filepath);
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private static void runTest(BasePage page, String filepath) {
        page.gotToPage();
        page.verifyOnPage("interviewquestions | repo to hold the interview preparation questions");
        page.getAllQuestions();
        page.getAllAnswers();
        page.printQuestionAndAnswerMap();
        page.saveQuestionAndAnswerMapToFile(filepath);
    }
}
