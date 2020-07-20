package com.common;


import com.jcraft.jsch.JSchException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.*;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public  class UiBase {
    protected static WebDriver driver;
    private String code;
    private XSSFCell cell0;

    private static WebDriver CreateDriver(){
        WebDriver createDriver = null;
        System.setProperty("webdriver.chrome.driver",ChooseDriverEXE.Chrome_Driver_File);
        createDriver = new ChromeDriver();
        return createDriver;
    }

    @BeforeClass
    public void ClearData() throws SQLException {
        MySqlDbOperator dba =new MySqlDbOperator();
        dba.setConnection();
        for(int i=0; i <41; i = i+1){
            dba.setControldata(readExcel(i));
        }
        dba.dbClose();

    }
    @BeforeClass
    public void startDriver() throws InterruptedException, IOException, JSchException {
        ConnectionLinux connectionLinux = new ConnectionLinux();
        connectionLinux.deletePngDate("rm -rf /tmp/.eagle/images/*.png");
        Thread.sleep(1000);
        driver = CreateDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.3.30:81/sign-in?lang=zh");
        driver.manage().window().maximize();
        this.code = connectionLinux.getCode();
    }
    public String getCode(){
        return code;
    }

    @AfterClass
    public void endDriver(){
        driver.quit();
    }

    private String readExcel(int i) {
        try {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("D:\\ObjectInformation\\BaoQuanWang\\UI\\src\\test\\java\\com\\data\\sqldata.xlsx"));
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            XSSFRow row = sheet.getRow(i);
            this.cell0 = row.getCell(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cell0.toString();
    }

    public static void main(String[] args) {
        for(int i =0;i<10;++i){
            System.out.println(i);
        }

    }
}
