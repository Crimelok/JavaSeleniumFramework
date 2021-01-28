package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver Idriver;

    public LoginPage(WebDriver rdriver)
    {
        Idriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }


    //WebElements from page

    @FindBy(id="Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id="Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath="//input[@value='Log in']")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(linkText="Logout")
    @CacheLookup
    WebElement lnkLogout;


    //Methods from page

    public void setUserName(String userName){
        txtEmail.clear();
        txtEmail.sendKeys(userName);
    }

    public void setPassword(String pwd){
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void clickLogout(){
        lnkLogout.click();
    }

}
