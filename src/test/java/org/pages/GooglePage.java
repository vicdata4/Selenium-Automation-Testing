package org.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.utils.PageObject;

public class GooglePage extends PageObject{
       
    @FindBy(id = "lst-ib")
    private WebElement browserRef;
    
    @FindBy(id = "cwbt14")
    private WebElement eightButton;
    
    //xpath example
    @FindBy (xpath = "//*[@id=\"cwbt46\"]/div/span")
    private WebElement pluskey;
    
    @FindBy (id = "cwbt13")
    private WebElement sevenButton;
    
    @FindBy (id = "cwbt45")
    private WebElement equalButton;
    
    @FindBy (id = "cwos")
    private WebElement operationResult;
    
    
    public GooglePage(WebDriver wd) { super(wd); }
    
    
    public boolean searchOnGoogle(String adress){
        actionInputEnter(browserRef, adress);
        return true;
    }
      
    public boolean calculatorOperations(String value){
        actionClick(eightButton);
        actionClick(pluskey);
        actionClick(sevenButton);
        actionClick(equalButton);
        return value.equals(operationResult.getText());
    }
    
    public boolean goToWeather(String adress){ 
        return searchOnGoogle(adress);
    }
    
}
