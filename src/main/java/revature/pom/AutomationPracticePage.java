package revature.pom;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticePage {
    private WebDriver driver;

    private final String url = "https://cosmocode.io/automation-practice-webtable/";

    // WebElements
    @FindBy(id = "countries")
    private WebElement countriesTable;

    public AutomationPracticePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void goToAutomationPracticePage() {
        driver.get(url);
    }

    public List<WebElement> getAllSelectedRows() {
        List<WebElement> selectedRows = new ArrayList<>();
        List<WebElement> rows = countriesTable.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            WebElement checkbox = row.findElement(By.cssSelector("input.hasVisited"));
            if (checkbox.isSelected()) {
                selectedRows.add(row);
            }
        }
        System.out.println(selectedRows);
        return selectedRows;
    }

    public WebElement getFirstSelectedRow() {
        List<WebElement> rows = countriesTable.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            WebElement checkbox = row.findElement(By.tagName("input"));
            if (checkbox.isSelected()) {
                return row;
            }
        }
        System.out.println(getFirstSelectedRow());
        return null;
    }
}
