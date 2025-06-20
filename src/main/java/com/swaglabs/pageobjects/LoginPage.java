package com.swaglabs.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.swaglabs.actiondriver.Actions;
import com.swaglabs.base.BaseClass;

public class LoginPage {

private Actions action;
WebDriver driver;
private By enterusername=By.xpath("//input[@id='user-name']");
private By enterpassword=By.xpath("//input[@id='password']");
private By loginButton=By.xpath("//input[@id='login-button']");
private By errorMessage = By.xpath("//div[@class='error-message-container error']");
private By inventory = By.xpath("//div[@id='inventory_container']");

public LoginPage(WebDriver driver) {
    this.driver = driver;
    this.action = new Actions(driver);
}

public void enterUserName(String userName) {
	action.sendKeys(enterusername, userName);
	
}
public void enterPassword(String password) {
	action.sendKeys(enterpassword, password);
}
public void clickLoginButton() {
	action.click(loginButton);
}

public boolean isLoginSuccessful() {
    try {
        return driver.getCurrentUrl().contains("inventory") ||
               driver.findElement(inventory).isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
}


public boolean isLoginFailed() {
    try {
        return driver.findElement(errorMessage).isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
}
}

