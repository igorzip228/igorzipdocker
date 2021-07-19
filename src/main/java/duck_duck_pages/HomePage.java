package duck_duck_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends DuckBasePage{

    @FindBy(id="search_form_input_homepage")
    private WebElement searchField;

    @FindBy(id="search_button_homepage")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public SearchResultsPage doSearch(String searchWord){
        waiter.until(ExpectedConditions.visibilityOf(this.searchField));
        this.searchField.sendKeys(searchWord);
        this.searchButton.click();
        return new SearchResultsPage(driver);
    }

}
