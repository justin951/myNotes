package revature;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import revature.pom.AutomationPracticePage;
import revature.pom.PuppyPage;
import revature.pom.WikiHome;

import java.time.Duration;

public class Main {
  public static void main(String[] args) {
    WebDriver driver = null;
    try {
      driver = new EdgeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
      WikiHome wikiHome = new WikiHome(driver);
      PuppyPage puppyPage = new PuppyPage(driver);

      wikiHome.gotToWikipediaHome();
      wikiHome.enterTextIntoSearchBar("puppy");
      wikiHome.clickSearchButton();
      puppyPage.verifyOnPuppyPage();
      System.out.println(puppyPage.verifyOnPuppyPage());
    } finally {
      if (driver != null) {
        driver.quit();
      }
    }

    WebDriver driver2 = null;
    try {
      driver2 = new ChromeDriver();
      driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

      AutomationPracticePage autoPage = new AutomationPracticePage(driver);
      autoPage.goToAutomationPracticePage();
      autoPage.getAllSelectedRows();
      autoPage.getFirstSelectedRow();
    } finally {
      if (driver2 != null) {
        driver2.quit();
      }
    }
  }
}
