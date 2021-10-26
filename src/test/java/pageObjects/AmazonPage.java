package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AmazonPage {
    public WebDriver Idriver;

    public AmazonPage(WebDriver rdriver)
    {
        Idriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    String firstResultPrice;
    @FindBy(id="twotabsearchtextbox")
    @CacheLookup
    WebElement txtSearch;

    @FindBy(id="nav-search-submit-button")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
    @CacheLookup
    WebElement firstResult;

    @FindBy(xpath="(//div[@class='a-row a-size-base a-color-base'])[1]")
    @CacheLookup
    WebElement firstPrice;

    @FindBy(xpath="(//span[@id='priceblock_ourprice'])[1]")
    @CacheLookup
    WebElement firstPriceDetails;

    @FindBy(id="add-to-cart-button")
    @CacheLookup
    WebElement btnAddtocart;

    @FindBy(xpath="//a[@id='hlb-view-cart-announce']")
    @CacheLookup
    WebElement btnGotocart;

    @FindBy(xpath="//a[@href='/-/es/gp/cart/view.html?ref_=nav_cart']")
    @CacheLookup
    WebElement btnGotocart2;

    @FindBy(xpath="(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[1]")
    @CacheLookup
    WebElement firstCartProduct;

    @FindBy(xpath="//input[@value='Eliminar']")
    @CacheLookup
    WebElement btnDelete;

    @FindBy(xpath="//*[text() = 'se ha eliminado del Carrito.']")
    @CacheLookup
    WebElement deletedMessage;


    public void searchItem(String item) throws InterruptedException {
        System.out.println("Searching item: [" + item + "]");
        txtSearch.clear();
        txtSearch.sendKeys(item);
        clickSearch();
    }

    public void clickSearch() throws InterruptedException {
        System.out.println("Searching item");
        btnSearch.click();
        Thread.sleep(500);
    }

    public void storeFirstPrice() throws Exception {
        System.out.println("Verifying item [" + firstResult.getText() + "] is displayed");
        Thread.sleep(500);
        if (firstResult.isDisplayed()) {
            //Store first value
            firstResultPrice = firstPrice.getText();
            System.out.println("Stored price: [" + firstResultPrice + "]");
        } else {
            System.out.println("Results not displayed.");
        }
    }

    public void clickFirstResult() throws Exception{
        Thread.sleep(500);
        try {
            firstResult.click();
            Thread.sleep(500);
        }catch(Exception e){
            System.out.println("Unable to click on first price");
        }
    }

    String purchaseValue;
    public void validateAamazonResults(){
        if(firstPriceDetails.isDisplayed()){
            String firstItemPrice = firstPriceDetails.getText();
        System.out.println("Price on details page is: [" + firstItemPrice + "]");
        System.out.println("Price already stores is: [" + firstResultPrice + "]");

        String cleanFirstItemPrice, cleanDetailsPrice;
        cleanFirstItemPrice = firstResultPrice;
        cleanDetailsPrice = firstItemPrice;

        cleanFirstItemPrice = cleanDetailsPrice.replaceAll("\\s", "");
        cleanFirstItemPrice = cleanDetailsPrice.replaceAll("US$", "");
        System.out.println("Clean: cleanFirstItemPrice = " + cleanFirstItemPrice);

        Assert.assertTrue(cleanFirstItemPrice.contains(firstItemPrice));

        System.out.println("Prices are the same: [" + firstItemPrice + "]");
        purchaseValue = firstItemPrice;
        }

    }

    public void cartFlow() throws InterruptedException {
        System.out.println("Adding to cart . . .");
        btnAddtocart.click();
        Thread.sleep(200);
        System.out.println("Going to cart . . .");
        try {
            btnGotocart2.click();
            //btnGotocart.click();
        }catch(Exception e){
            btnGotocart.click();
        }
        Thread.sleep(200);
        System.out.println("First item on the product price is: [" + firstCartProduct.getText() + "]");


        String cartPrice = firstCartProduct.getText();
        String purchaseValueClean = purchaseValue.replaceAll("\\s", "");

        System.out.println("Stored price clean: [" + purchaseValueClean + "]");
        System.out.println("Compared with: [" + cartPrice +"]");

        Assert.assertTrue(cartPrice.equals(purchaseValueClean));

        System.out.println("The prices are the same: [" + purchaseValueClean + "]");

    }

    public void deleteProduct() throws InterruptedException {
        System.out.println("Deleting product from cart . . .");
        System.out.println(btnDelete.getText());
        btnDelete.click();
        Thread.sleep(500);
        if(deletedMessage.isDisplayed()){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }

}