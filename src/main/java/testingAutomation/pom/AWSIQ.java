package testingAutomation.pom;

import org.openqa.selenium.WebDriver;

public class AWSIQ extends BasePage {
        private final String url = "https://revaturelabs.github.io/interviewquestions/InterviewSpecificQuestions/AWS/AWS.html";

    public AWSIQ(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getUrl() {
        return url;
    }
}
