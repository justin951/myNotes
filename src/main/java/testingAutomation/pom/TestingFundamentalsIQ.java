package testingAutomation.pom;

import org.openqa.selenium.WebDriver;

public class TestingFundamentalsIQ extends BasePage {
    private final String url = "https://revaturelabs.github.io/interviewquestions/InterviewSpecificQuestions/Java%20Automation/TestingFundamentals.html";

    public TestingFundamentalsIQ(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getUrl() {
        return url;
    }
}