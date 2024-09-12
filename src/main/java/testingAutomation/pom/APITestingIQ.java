package testingAutomation.pom;

import org.openqa.selenium.WebDriver;

public class APITestingIQ extends BasePage {
    private final String url = "https://revaturelabs.github.io/interviewquestions/InterviewSpecificQuestions/Java%20Automation/APITesting.html";

    public APITestingIQ(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getUrl() {
        return url;
    }
}
