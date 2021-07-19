package duck_duck_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DuckBasePage {
    WebDriver driver;
    WebDriverWait waiter;

    public DuckBasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waiter = new WebDriverWait(this.driver, 10);
    }

    public HomePage goTo(String url){
        driver.get(url);
        return new HomePage(driver);
    }
}
