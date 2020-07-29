package com.common;


import com.jcraft.jsch.JSchException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
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

    @BeforeSuite
    public void ClearData() throws SQLException {
        MySqlDbOperator dba =new MySqlDbOperator();
        dba.setConnection();
        for(int i=0; i <13; i = i+1){
            dba.setControldata(readExcel(i));
        }
        dba.dbClose();

    }
    @BeforeSuite
    public void startDriver() throws InterruptedException, IOException, JSchException {
        ConnectionLinux connectionLinux = new ConnectionLinux();
        connectionLinux.deletePngDate("rm -rf /var/backend/current/public/captcha/*.jpg");
        Thread.sleep(1000);
        driver = CreateDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.3.236/login");
        driver.manage().window().maximize();
        this.code = connectionLinux.getCode();
    }
    public String getCode(){
        return code;
    }

    @AfterSuite
    public void endDriver(){
        driver.quit();
    }

    private String readExcel(int i) {
        try {
            File sqlDataPath = new File("src\\test\\java\\com\\data\\sqldata.xlsx");
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(sqlDataPath.getAbsolutePath()));
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

    public static void main(String[] args) throws ParseException {
        File path = new File("src\\test\\java\\com\\data\\sqldata.xlsx");
        System.out.println(path.getAbsolutePath());
        System.out.println("蔡徐坤");
    }
}
