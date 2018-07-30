package org.tests;

import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.pages.GooglePage;
import org.utils.DriverBase;
import static org.utils.DriverBase.driver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainCI extends DriverBase {
    
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    private GooglePage googlePage = new GooglePage(driver);
    
    @Test
    public void AgoogleSearch(){
        logger.info("Google search -- calculator");
        Assert.assertTrue(googlePage.searchOnGoogle(ic.getProperty("calculatorSearch")));
    }
    
    @Test
    public void BcalculatorOp(){
        logger.info("Calculator page -- Operation");
        Assert.assertTrue("Not expected result****",googlePage.calculatorOperations(ic.getProperty("expectedResult")));
    }
    
    @Test
    public void CgoToWeather(){
        logger.info("Google search -- weather");
        Assert.assertTrue(googlePage.goToWeather(ic.getProperty("weatherSearch")));

    }

}
