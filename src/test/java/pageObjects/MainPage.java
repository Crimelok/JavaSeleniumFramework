package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver Idriver;

    public MainPage(WebDriver rdriver)
    {
        Idriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }


    //WebElements from page
    @FindBy(id="shellmenu_1")
    @CacheLookup
    WebElement menuOffice;

    @FindBy(id="shellmenu_2")
    @CacheLookup
    WebElement menuWindows;

    @FindBy(id="shellmenu_3")
    @CacheLookup
    WebElement menuSurface;

    @FindBy(id="shellmenu_4")
    @CacheLookup
    WebElement menuXbox;

    @FindBy(id="shellmenu_5")
    @CacheLookup
    WebElement menuDeals;

    @FindBy(id="shellmenu_6")
    @CacheLookup
    WebElement menuSupport;

    //Methods from page


    public void validateMenus() throws InterruptedException {
        Thread.sleep(5000);
        if(menuOffice.isDisplayed()){
            Assert.assertTrue(true);
        }else{
            System.out.println("Menu elements not displayed successfuly");
        }

    }


    public void clickWindows() throws InterruptedException {
        Thread.sleep(3000);
        menuWindows.click();
    }

}
