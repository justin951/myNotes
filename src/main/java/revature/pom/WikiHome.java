package revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHome {

    private WebDriver driver;

    private final String wikiUrl = "https://www.wikipedia.org/";

    @FindBy(id = "searchInput")
    private WebElement searchBar;

    @FindBy(xpath = "/html/body/main/div[2]/form/fieldset/button")
    private WebElement searchButton;

    public WikiHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void gotToWikipediaHome() {
        driver.get(wikiUrl);
    }

    public void enterTextIntoSearchBar(String input) {
        searchBar.sendKeys(input);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

}
