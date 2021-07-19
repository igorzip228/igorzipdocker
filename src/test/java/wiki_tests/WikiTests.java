package wiki_tests;

import base_class.BaseTestClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WikiTests extends BaseTestClass {
    @Test(priority = 1)
    public void openWiki(){
        driver.get("https://www.wikipedia.org/");
        Assert.assertEquals(
                driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/div[1]/h1/span")).getText(),
                "Wikipedia");
    }

    @Test(priority = 2)
    public void selectEnglish(){
        driver.findElement(By.cssSelector("#js-link-box-en")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#mp-welcome")).isDisplayed());
    }

    @Test(priority = 3)
    @Parameters("searchWord")
    public void searchSelenium(String searchWord) {
        driver.findElement(By.id("searchInput")).sendKeys(searchWord + "\n");
        String header = driver.findElement(By.id("firstHeading")).getText();
        Assert.assertEquals(header, "Search results");
    }
}
