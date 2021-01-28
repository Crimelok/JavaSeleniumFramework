package stepDefinitions;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.WindowsPage;

import java.text.ParseException;

public class Steps {

    public WebDriver driver;
    public LoginPage loginPage;
    public MainPage mainPage;
    public WindowsPage windowsPage;

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Crimelok\\IdeaProjects\\InterviewFramework\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        mainPage=new MainPage(driver);
        windowsPage=new WindowsPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_URL(String url){
        driver.get(url);
    }

    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_and_password(String email, String password) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Username is: [" + email + "]");
        System.out.println("Password is: [" + password + "]");
        loginPage.setUserName(email);
        loginPage.setPassword(password);
    }

    @When("Click on login")
    public void click_on_login(){
    loginPage.clickLogin();
    }

    @When("Page title should be {string}")
    public void page_title_should_be(String title){
    if(driver.getPageSource().contains("Login was unsuccessful.")){
        driver.close();
        Assert.assertTrue(false);
    }else{
        Assert.assertTrue(true);
    }
    }

    @When("User click on log out link")
    public void user_click_on_logout_link() throws InterruptedException {
    loginPage.clickLogout();
    Thread.sleep(5000);
    }

    @When("Close browser")
    public void close_browser(){
    driver.quit();
    }

    @When("Clicks on Windows")
    public void clicks_on_windows() throws InterruptedException {
        mainPage.clickWindows();
        System.out.println("clicked on Windows option");
    }

    @When("Validate menus")
    public void validate_menus() throws InterruptedException {
        mainPage.validateMenus();
    }

    @When("Validate menu options")
    public void validate_menu_options() throws InterruptedException {
        windowsPage.clickWindowsAndPrint();
    }

    @When("User search {string} on search bar")
    public void user_search_on_search_bar(String search) throws InterruptedException {
        windowsPage.searchSomething(search);
    }

    @When("User checks prices")
    public void user_checks_prices() throws InterruptedException {
        windowsPage.prices();
    }

    @When("Validate same prices")
    public void validate_same_prices(){
        windowsPage.validateSamePrices();
    }

    @When("User makes paying flow")
    public void user_makes_paying_flow() throws InterruptedException, ParseException {
        windowsPage.payingFlow();
    }

}
