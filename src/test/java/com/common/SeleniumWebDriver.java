package com.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SeleniumWebDriver {
    private static WebDriver driver = null;
    private static String driver_type = "Chrome";
    private static int SENCENDS = 10 ;


    public void SeleniumWebDriver() throws InterruptedException {
        driver  = CreateDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(SENCENDS,TimeUnit.SECONDS);
    }

    private static WebDriver CreateDriver(){
        WebDriver createDriver = null;
        if(ChooseDriverEXE.TEST_BROWSER_TYPE_IE.equalsIgnoreCase(driver_type)){
            System.setProperty("webdriver.ie.driver",ChooseDriverEXE.IE_Driver_File);
        }else if(ChooseDriverEXE.TEST_BROWSER_TYPE_CHROME.equalsIgnoreCase(driver_type)){
            System.setProperty("webdriver.chrome.driver",ChooseDriverEXE.Chrome_Driver_File);
            createDriver = new ChromeDriver();
        }else if(ChooseDriverEXE.TEST_BROWSER_TYPE_FIREFOX.equalsIgnoreCase(driver_type)){
            System.setProperty("webdriver.gecko.driver", ChooseDriverEXE.Firefox_Driver_File);
        }else{
            System.out.printf("不支持%s类型浏览器",driver_type);
        }
        return createDriver;
    }

    public void CloseDriver(){
        this.driver.quit();
    }

    public void OpenUrl(String url){
        this.driver.get(url);
    }


    public WebDriver getDriver(){
        return this.driver;
    }


}
