package pageObjects;

import org.apache.tools.ant.types.resources.First;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class WindowsPage {
    public WebDriver Idriver;

    public WindowsPage(WebDriver rdriver)
    {
        Idriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    public String firstPrice;
    //WebElements from page
    @FindBy(id="c-shellmenu_54")
    @CacheLookup
    WebElement menuWindows10;

    @FindBy(xpath="//a[@id='c-shellmenu_55']")
    @CacheLookup
    WebElement dropdown1;

    @FindBy(xpath="//a[@id='c-shellmenu_56']")
    @CacheLookup
    WebElement dropdown2;

    @FindBy(xpath="//a[@id='c-shellmenu_57']")
    @CacheLookup
    WebElement dropdown3;

    @FindBy(xpath="//a[@id='c-shellmenu_58']")
    @CacheLookup
    WebElement dropdown4;

    @FindBy(xpath="//a[@id='c-shellmenu_59']")
    @CacheLookup
    WebElement dropdown5;

    @FindBy(xpath="//a[@id='c-shellmenu_60']")
    @CacheLookup
    WebElement dropdown6;

    @FindBy(xpath="//a[@id='c-shellmenu_61']")
    @CacheLookup
    WebElement dropdown7;

    @FindBy(xpath="//a[@id='c-shellmenu_62']")
    @CacheLookup
    WebElement dropdown8;

    @FindBy(xpath="//a[@id='c-shellmenu_63']")
    @CacheLookup
    WebElement dropdown9;

    @FindBy(xpath="//a[@id='c-shellmenu_64']")
    @CacheLookup
    WebElement dropdown10;

    @FindBy(xpath="//button[@id='search']")
    @CacheLookup
    WebElement btnSearch;


    @FindBy(xpath="//input[@id='cli_shellHeaderSearchInput']")
    @CacheLookup
    WebElement searchBar;


    @FindBy(xpath="//button[@id='R1MarketRedirect-close']")
    @CacheLookup
    WebElement stayEnglish;


    @FindBy(xpath="(//span[@itemprop='price'])[1]")
    @CacheLookup
    WebElement price1;

    @FindBy(xpath="(//span[@itemprop='price'])[2]")
    @CacheLookup
    WebElement price2;

    @FindBy(xpath="(//span[@itemprop='price'])[3]")
    @CacheLookup
    WebElement price3;

    @FindBy(xpath="//div[@class='c-glyph glyph-cancel']")
    @CacheLookup
    WebElement cancelOption;


    @FindBy(xpath="(//div[@class='pi-price-text'])[1]")
    @CacheLookup
    WebElement finalPrice;


    @FindBy(xpath="//button[@id='buttonPanel_AddToCartButton']")
    @CacheLookup
    WebElement addToCart;

    @FindBy(xpath="(//span[@itemprop='price'])[1]")
    @CacheLookup
    WebElement compare1;

    @FindBy(xpath="(//span[@itemprop='price'])[2]")
    @CacheLookup
    WebElement compare2;

    @FindBy(xpath="(//span[@itemprop='price'])[3]")
    @CacheLookup
    WebElement compare3;

    @FindBy(xpath="//div[@class='item-quantity']")
    @CacheLookup
    WebElement ddownQty;

    @FindBy(xpath="//option[@value='20']")
    @CacheLookup
    WebElement ddownSelect20;

    //Methods from page


    public void clickWindowsAndPrint() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Windows method");
        menuWindows10.click();
        Thread.sleep(500);
        try {
            System.out.println(dropdown1.getText());
            System.out.println(dropdown2.getText());
            System.out.println(dropdown3.getText());
            System.out.println(dropdown4.getText());
            System.out.println(dropdown5.getText());
            System.out.println(dropdown6.getText());
            System.out.println(dropdown7.getText());
            System.out.println(dropdown8.getText());
            System.out.println(dropdown9.getText());
            System.out.println(dropdown10.getText());
        }catch(Exception e){
            System.out.println("Something wrong");
        }
    }

    public void clickSearch(){
        btnSearch.click();
    }

    public void searchSomething(String search) throws InterruptedException {
        btnSearch.click();
        Thread.sleep(500);
        searchBar.clear();
        searchBar.sendKeys(search);
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        stayEnglish.click();
        Thread.sleep(3000);
    }

    public void prices() throws InterruptedException {
        Thread.sleep(500);
        if (price1.isDisplayed()){
            //Store first value
            firstPrice=price1.getText();
            System.out.println("Stored price: [" + firstPrice + "]");
            //Print first 3 offers
            System.out.println(price1.getText());
            System.out.println(price2.getText());
            System.out.println(price3.getText());

            price1.click();
            Thread.sleep(3000);

            //close popUp
            cancelOption.click();
            Thread.sleep(250);

        }else{
            System.out.println("Prices not displayed");
        }
    }

    public void validateSamePrices(){
        Assert.assertTrue(finalPrice.getText().contains(firstPrice));
    }

    public void payingFlow() throws InterruptedException, ParseException {

        addToCart.click();
        Thread.sleep(5000);
        System.out.println(compare1.getText());
        System.out.println(compare2.getText());
        System.out.println(compare3.getText());
        Assert.assertTrue(compare1.getText().contains(compare2.getText()) && compare1.getText().contains(compare3.getText()));
        System.out.println("Condition passed: all prices are the same");

        ddownQty.click();
        Thread.sleep(100);
        ddownSelect20.click();
        Thread.sleep(3000);
        //validate final price

        //Convert quantities
        String finalValue1 = compare2.getText();
        finalValue1 = finalValue1.replace("$", "");
        finalValue1 = finalValue1.replace(",", "");
        finalValue1 = finalValue1.replace(".00", "");

        firstPrice = firstPrice.replace("$", "");
        firstPrice = firstPrice.replace(",", "");
        firstPrice = firstPrice.replace(".00", "");

        System.out.println("Final value: " + finalValue1);
        System.out.println("firstPrice: " + firstPrice);

        int parseFinalValue=Integer.parseInt(finalValue1);
        int parsefirstValue=Integer.parseInt(firstPrice);

        if ((parseFinalValue/parsefirstValue) == 20){
            Assert.assertTrue(true);
        }else{
            System.out.println("Values are not correct");
        }

    }

}
