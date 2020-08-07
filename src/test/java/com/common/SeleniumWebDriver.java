package com.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class SeleniumWebDriver {
    private static WebDriver driver = null;
    private static String driver_type = "Chrome";
    private static int SENCENDS = 10 ;
    private DesiredCapabilities caps;


    public void SeleniumWebDriver() throws InterruptedException {
        driver  = CreateDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(SENCENDS,TimeUnit.SECONDS);
    }

    private  WebDriver CreateDriver(){
        WebDriver createDriver = null;
        if(ChooseDriverEXE.TEST_BROWSER_TYPE_IE.equalsIgnoreCase(driver_type)){
            System.setProperty("webdriver.ie.driver",ChooseDriverEXE.IE_Driver_File);
        }else if(ChooseDriverEXE.TEST_BROWSER_TYPE_CHROME.equalsIgnoreCase(driver_type)){
            System.setProperty("webdriver.chrome.driver",ChooseDriverEXE.Chrome_Driver_File);
            DesiredCapabilities caps = getDownloadsPath();
            createDriver = new ChromeDriver(caps);
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


    public DesiredCapabilities getDownloadsPath() {
        File downloadfilepath = new File("src\\test\\java\\com\\downloadfiles");
        String downloadsPath = downloadfilepath.getAbsolutePath().toString();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", downloadsPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        this.caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        return caps;
    }

    public static void main(String[] args) {
        File downloadfilepath = new File("src\\test\\java\\com\\downloadfiles");
        System.out.println(downloadfilepath.getAbsolutePath());
    }
}
