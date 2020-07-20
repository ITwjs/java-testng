package com.common;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screenShot extends UiBase {
    private static Logger log=Logger.getLogger(Test.class);
    public void screenShot(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String filePath ="D:\\ObjectInformation\\BaoQuanWang\\UI\\screenshotFail\\"+df.format(new Date())+".jpg";
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//OutputType.FILE--截幕保存为图片
            FileUtils.copyFile(scrFile, new File(filePath));
            log.info("截图成功："+filePath);
        } catch (
        IOException e) {
            log.error("截图失败："+e);
        }
    }

    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(df.format(new Date()));
    }
}
