package duck_duck_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultsPage extends DuckBasePage{
    @FindBy(id = "duckbar")
    private WebElement duckBar;

    @FindBy(xpath = "//div[@class='tile  tile--c--w  tile--vid  has-detail  opt--t-xxs']")
    private List<WebElement> listOfSearchedVideos;

    private By listOfElements = By.xpath("//div[@class='tile  tile--c--w  tile--vid  has-detail  opt--t-xxs']");


    public SearchResultsPage(WebDriver driver) {
        super(driver);
        waiter.until(ExpectedConditions.visibilityOf(duckBar));
    }

    public SearchResultsPage openHeaderMenu(HeaderMenuEnum headerMenu) {
        duckBar.findElement(By.xpath(String.format("//a[contains(text(), '%s')]", headerMenu))).click();
        waiter.until(ExpectedConditions.numberOfElementsToBeMoreThan(listOfElements, 0));
        return this;
    }

    public WebElement getDuckBar() {
        return duckBar;
    }

    public int getNumberOfSearchedVideos() {
        System.out.println(listOfSearchedVideos.size());
        return listOfSearchedVideos.size();
    }
}
