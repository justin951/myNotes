package revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PuppyPage {

    @FindBy(tagName = "title")
    private WebElement title;

    private WebDriver driver;

    private WebDriverWait wait;

    public PuppyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);

    }

    public boolean verifyOnPuppyPage() {
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Wikipedia")));
        String titleText = driver.getTitle();
        return "Puppy - Wikipedia".equals(titleText);
    }

}
