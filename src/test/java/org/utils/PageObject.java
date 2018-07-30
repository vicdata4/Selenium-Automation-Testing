package org.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    
    private WebElement schamanLogo;

    private Actions actions;
    private WebDriver wd;
    private WebDriverWait wdw;

    public PageObject(WebDriver wd) {
        this.wd = wd;
        actions = new Actions(wd);
        
        wdw = new WebDriverWait(wd, 10);
        PageFactory.initElements(wd, this);
    }

    protected void actionClick(WebElement we){
        actions.click(we).build().perform();
    }

    protected void actionMoveMouse(WebElement webElement){
        actions.moveToElement(webElement).build().perform();
    }
    
    protected void actionInputEnter(WebElement we, String adress) {
        we.clear();
        we.sendKeys(adress);
        we.sendKeys(Keys.ENTER);
    }
    
    protected void fluidClick(WebElement we){
        wdw.until(ExpectedConditions.elementToBeClickable(we));
        we.click();
    }
    
}
