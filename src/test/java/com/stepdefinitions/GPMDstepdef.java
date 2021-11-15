package com.stepdefinitions;

import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import com.GPMDtest.MainpageforGPMDtest;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GPMDstepdef extends MainpageforGPMDtest {

    WebDriver driver;

    @Given("^Access WebdriverManager$")
    public void access_webdriver_Manager_for_Google() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Then("^Launch chrome \"([^\"]*)\" browser$")
    public void launch_chrome_browser(String URL) throws IOException {
        // Launching Dashboard URL
        driver.get(getValueFromDataConfig(URL));
        driver.getWindowHandle();
        driver.manage().window().maximize();
    }

    @Then("^Enter mobile number$")
    public void enter_mobile_number() throws IOException {
        // mobile number as input
        entermobilenumber(driver, getValueFromDataConfig("mobile"));
    }

    @Then("^click on continue button$")
    public void click_continue_button() throws IOException {
        // clicking on continue button after entered moblie number
        clickcontinuebutton(driver);
    }

    @Then("^confirm the mobile number$")
    public void confirm_the_mobile_number() throws IOException {
        confirmmobilenumber(driver);
    }

    // @Then("^wait for otp$")
    // public void wait_for_otp() throws IOException {
    //     waitforotp(driver);
    // }

    // @Then("^click on continue after otp$")
    // public void click_on_continue_after_otp() throws IOException {
    //     continueafterotp(driver);
    // }

    // @Then("^validate the user name$")
    // public void validate_the_user_name() throws IOException {
    //     validateusername(driver);
    // }

    @Then("^assert login$")
    public void assert_login() throws IOException {
        verificationAssert(driver);
    }

    @Then("^validate the user name$")
    public void validate_user_name() throws IOException {
        validateusername(driver);
    }
    
    @Then("^display all dashboard names$")
    public void display_all_dashboard_names() throws IOException{
        alldashboardnames(driver);
    }

    // @Then("^click on reservoir dashboard$")
    // public void click_on_reservoir_dashboard() throws IOException{
    //     clickdashboard(driver);
    // }
}