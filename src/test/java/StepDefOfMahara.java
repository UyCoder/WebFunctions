import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.FileSystems;
import java.util.concurrent.TimeUnit;

/**
 * Project:     WebFunctions
 * Package:     PACKAGE_NAME
 * Created:     12/5/2021 22:32
 * Author:      Ahmed-UTI
 * Email:       AhmedBughra@gmail.com
 * CreatedWith: IntelliJ IDEA
 */

public class StepDefOfMahara  {
    WebDriver driver;

    @Given("Open chrome and prepare to login")
    public void openChromeAndPrepareToLogin() {
        // setup system variable for chromedriver
        System.setProperty("webdriver.chrome.driver", FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "\\chromedriver_win32\\chromedriver.exe");
//        // define a webdriver variable
        driver = new ChromeDriver();
        // maximize browser window
        driver.manage().window().maximize();
        // set maximun page time out
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        // navigate to the testing site
        driver.get("http://mahara.unitedcoderschool.com/mahara/");
    }



    // create the waitUtilElementVisible method
    public static void waitUntilElementVisiable(WebDriver driver, WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    @When("Insert username in the username field")
    public void insertUsernameInTheUsernameField() {
        // Enter username in the username field
        waitUntilElementVisiable(driver, driver.findElement(By.id("login_login_username")));
        driver.findElement(By.id("login_login_username")).sendKeys("ahmed");
    }

    @Then("Insert Password in the password field")
    public void insertPasswordInThePasswordField() {
        // Enter Password in the password field
        WebElement passwordElement = driver.findElement(By.id("login_login_password"));
        waitUntilElementVisiable(driver, passwordElement);
        passwordElement.sendKeys("Demo123456789!");
    }

    @When("click sign-in button")
    public void clickSignInButton() {
        // Click on the sign-in button
        WebElement submitButton = driver.findElement(By.id("login_submit"));
        waitUntilElementVisiable(driver, submitButton);
        submitButton.click();
    }


    @Then("Verify login")
    public void verifyLogin() {
        // Verify login
        WebElement userMenu = driver.findElement(By.xpath("//button/span[@class='icon icon-chevron-down collapsed']"));
        waitUntilElementVisiable(driver, userMenu);
        boolean isLoginSuccess = userMenu.isDisplayed();
        if (isLoginSuccess){
            System.out.println("=================================");
            System.out.println("0. User logged in successfully. ");
        }
        System.out.println("=================================");
    }


    @When("Click on main menu")
    public void clickOnMainMenu() {
        // Click on main menu
        WebElement mainMenu = driver.findElement(By.xpath("//button[@class='main-nav-toggle navbar-toggle collapsed']"));
        waitUntilElementVisiable(driver,mainMenu);
        mainMenu.click();
    }

    @Then("Click on {string}")
    public void clickOn(String arg0) {
        //Click on "Create"
        WebElement create = driver.findElement(By.xpath("//a[@class='create menu-dropdown-toggle']"));
        waitUntilElementVisiable(driver, create);
        create.click();
    }

    @Then("Click the {string} button")
    public void clickTheButton(String arg0) {
        //Click on "Plans"
        WebElement plans = driver.findElement(By.xpath("//a[contains(text(),'Plans')]"));
        waitUntilElementVisiable(driver, plans);
        plans.click();
        //Click the "New plan" button on the Plans overview page.
        WebElement newPlan = driver.findElement(By.xpath("//a[@class='btn btn-secondary']"));
        waitUntilElementVisiable(driver, newPlan);
        newPlan.click();
    }

    @When("Enter the title of the new plan")
    public void enterTheTitleOfTheNewPlan() {
        //Enter the title of the new plan on Title field     //input[@id='addplan_title']
        WebElement titleOfNewPlan = driver.findElement(By.id("addplan_title"));
        waitUntilElementVisiable(driver, titleOfNewPlan);
        titleOfNewPlan.sendKeys("New_plan_ahmed");
    }

    @And("Enter the description")
    public void enterTheDescription() {
        //Enter the description of the new plan on the Description text field.    //textarea[@id='addplan_description']
        WebElement descriptionOfNewPlan= driver.findElement(By.id("addplan_description"));
        waitUntilElementVisiable(driver, descriptionOfNewPlan);
        descriptionOfNewPlan.sendKeys("This plan is created by ahmed.");
    }


    @And("Select {string} on the drop-down list")
    public void selectOnTheDropDownList(String arg0) {
        //Select "Yes" on the drop-down list from "Template"
        WebElement templateDropDown = driver.findElement(By.xpath("//div[@id='addplan_template_container']//span[@class='state-label off'][contains(text(),'No')]"));
        waitUntilElementVisiable(driver, templateDropDown);
        templateDropDown.click();
    }


    @And("Enter tags")
    public void enterTags() {
        //Enter tags on tags textfield
        WebElement tags = driver.findElement(By.xpath("//input[@placeholder='Type in a search term']"));
        waitUntilElementVisiable(driver, tags);
        tags.sendKeys("student_plan");
    }


    @Then("Click on the {string} button")
    public void clickOnTheButton(String arg0) {
        //Click on the "Save Plan" button    //button[@id='addplan_submit']
        WebElement savePlan = driver.findElement(By.id("addplan_submit"));
        waitUntilElementVisiable(driver, savePlan);
        savePlan.click();
    }

    @Then("Verify The Plan saved successfully")
    public void verifyThePlanSavedSuccessfully() {
        //Verify The Plan saved successfully
        WebElement planSaved = driver.findElement(By.xpath("//div[contains(text(),'Plan saved successfully.')]"));
        waitUntilElementVisiable(driver, planSaved);
        boolean isPlanSaved=planSaved.isDisplayed();
        if (isPlanSaved){
            System.out.println("1. Test case 1 passed.\t✓ ");
            System.out.println("=================================");
        }
    }
    @After("@lougoutAndCloseWebDriver")
    public void lougoutAndCloseWebDriver() {
        //Click on "Main menu"
        WebElement mainMenuLogout = driver.findElement(By.xpath("//span[@class='icon icon-chevron-down collapsed']"));
        waitUntilElementVisiable(driver, mainMenuLogout);
        mainMenuLogout.click();

        //Click on "Logout"     //a[@id='logoutbutton']
        WebElement logout = driver.findElement(By.id("logoutbutton"));
        waitUntilElementVisiable(driver, logout);
        logout.click();

        //Verify user logged out successfully
        WebElement loggedOut = driver.findElement(By.xpath("//div[contains(text(),'You have been logged out successfully')]"));
        waitUntilElementVisiable(driver,loggedOut);
        boolean isLoggedOut = loggedOut.isDisplayed();
        if (isLoggedOut) {
            System.out.println("User logged out successfully.");
            System.out.println("================================");
        }
        System.out.println("\nAll Test Case is over.");

        // close the browser and terminate the process
        driver.close();
        driver.quit();
    }
}
