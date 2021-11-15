package com.GPMDtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import com.GPMDtest.superclass;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.functions.ExpectedCondition;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class MainpageforGPMDtest extends superclass {

    String username;

    public void entermobilenumber(WebDriver driver, String phoneNumber) throws IOException {
        getwaitdriver(driver).until(
                ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("enter.mobilenumber")));
        driver.findElement(getValueFromElementAddressConfig("enter.mobilenumber")).sendKeys(phoneNumber);
    }

    public void clickcontinuebutton(WebDriver driver) throws IOException {
        getwaitdriver(driver).until(ExpectedConditions
                .visibilityOfElementLocated(getValueFromElementAddressConfig("click.continue.mobilenumber")));
        driver.findElement(getValueFromElementAddressConfig("click.continue.mobilenumber")).click();
    }

    public void confirmmobilenumber(WebDriver driver) throws IOException {
        getwaitdriver(driver).until(ExpectedConditions
                .visibilityOfElementLocated(getValueFromElementAddressConfig("confirm.mobilenumber")));
        driver.findElement(getValueFromElementAddressConfig("confirm.mobilenumber")).click();
    }

    // public void waitforotp(WebDriver driver) throws IOException{
    // getwaitdriver(driver).until(ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("enter.otp")));
    // }

    // public void continueafterotp(WebDriver driver) throws IOException{
    // getwaitdriver(driver).until(ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("otp.continue")));
    // driver.findElement(getValueFromElementAddressConfig("otp.continue")).click();
    // }

    // public void validateusername(WebDriver driver) throws IOException {
    //     getwaitdriver(driver).until(ExpectedConditions
    //             .visibilityOfElementLocated(getValueFromElementAddressConfig("Username.verification")));
    //     System.out.println(driver.findElement(getValueFromElementAddressConfig("Username.verification")).getText());
    // }

    public void clickusernmae(WebDriver driver) throws IOException {
        getwaitdriver(driver).until(ExpectedConditions
                .visibilityOfElementLocated(getValueFromElementAddressConfig("Username.verification")));
        driver.findElement(getValueFromElementAddressConfig("Username.verification")).click();
    }

    public void verificationAssert(WebDriver driver) throws IOException {
        assertTrue(assertLogin(driver));
    }

    boolean assertLogin(WebDriver driver) throws IOException {
        getwaitdriver(driver)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(getValueFromElementAddressConfig("Username.verification")))
                .getText();
        // System.out.println(username);
        if (driver.findElement(getValueFromElementAddressConfig("Username.verification")).isDisplayed() == true) {

            return true;

        } else {

            return false;
        }
    }

    public void validateusername(WebDriver driver) throws IOException {
        assertTrue(validateusernameReturn(driver));
    }

    boolean validateusernameReturn(WebDriver driver) throws IOException {
        getwaitdriver(driver).until(ExpectedConditions
                .visibilityOfElementLocated(getValueFromElementAddressConfig("Username.verification")));
        // username =
        // driver.findElement(getValueFromElementAddressConfig("Username.verification")).getText();

        String expectedtext = getValueFromDataConfig("name");
        // System.out.println("Expected Name : "+expectedtext);

        String actualtext = driver.findElement(getValueFromElementAddressConfig("Username.verification")).getText();
        // System.out.println("actualtext Name : "+actualtext);

        // removing extra spaces in string
        String removeextraspace = actualtext.replaceAll("\\s+", " ").trim();
        // System.out.println(removeextraspace);

        // String removeallspace = actualtext.replaceAll("\\s", ""); - removing all space
        // System.out.println(removeallspace);

        if (removeextraspace.equals(expectedtext)) {
            //driver.findElement(getValueFromElementAddressConfig("Reservoir.dashboard.view")).click();
            return true;
            // System.out.println("yes");
        } else {
            // System.out.println("no");

            return false;
        }

    }
    //display all dashboard names
    public void alldashboardnames(WebDriver driver) throws IOException {
        getwaitdriver(driver).until(ExpectedConditions
                .visibilityOfElementLocated(getValueFromElementAddressConfig("alldashboard.name")));
        // driver.findElement(getValueFromElementAddressConfig("alldashboard.name"));
        
        
        List<WebElement> alldashboard = driver.findElements(getValueFromElementAddressConfig("alldashboard.name"));
        for(WebElement name : alldashboard)
        {

         System.out.println(name.getText());
        }
    }

    // public void clickdashboard(WebDriver driver) throws IOException {
    //     getwaitdriver(driver).until(ExpectedConditions
    //             .visibilityOfElementLocated(getValueFromElementAddressConfig("alldashboard.name")));
    //     driver.findElement(getValueFromElementAddressConfig("alldashboard.name"));
        
        
    //      List<WebElement> alldashboard = driver.findElements(getValueFromElementAddressConfig("alldashboard.name"));
    //      for(WebElement name : alldashboard)
    //     {
            
    //         String reservoir = getValueFromDataConfig("Reservoir");
    //         String dashboard = driver.findElement(getValueFromElementAddressConfig("Reservoir.dashboard.text")).getText();

    //         if (reservoir.equals(dashboard)) {
    //             driver.findElement(getValueFromElementAddressConfig("Reservoir.dashboard.view")).click();
    //         }
    //         else{
    //             driver.findElement(getValueFromElementAddressConfig("Dineshtester.dashboard.view")).click();
    //         }
    //     } 
        
    //}
}


