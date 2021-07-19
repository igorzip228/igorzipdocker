package duckDuck_tests;

import base_class.BaseTestClass;
import duck_duck_pages.HeaderMenuEnum;
import duck_duck_pages.HomePage;
import duck_duck_pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DuckDuckTests extends BaseTestClass {

    @Test(priority = 1)
    @Parameters({"keyword"})
    public void findResults(String keyword){

        SearchResultsPage searchResultsPage = new HomePage(driver)
                .goTo("https://duckduckgo.com/")
                .doSearch(keyword);
        Assert.assertTrue(searchResultsPage.getDuckBar().isDisplayed());
    }

    @Test(priority = 2)
    public void checkNumOfVideous(){
        int numberOfSearchedVideos = new SearchResultsPage(driver)
                .openHeaderMenu(HeaderMenuEnum.Videos)
                .getNumberOfSearchedVideos();

        Assert.assertTrue(numberOfSearchedVideos > 0);
    }
}
