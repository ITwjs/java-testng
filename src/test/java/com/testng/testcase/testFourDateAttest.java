package com.testng.testcase;

import com.common.UiBase;
import com.common.screenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.File;
import java.util.List;

public class testFourDateAttest extends UiBase {
    private String count;
    private String filePath;
    private static Logger log = Logger.getLogger(testFourDateAttest.class);
    private  screenShot screen = new screenShot();
    private String information1;
    private String information2;
    private String information3;
    private String information4;
    private String information5;
    private String message1;
    private String message2;
    private String fileName;
    private int count1s;
    private int count2s;



    @Test
    public void test1BatchAttest(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            setFilePath("world1.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            setFilePath("world2.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            setFilePath("world3.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            setFilePath("world4.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            setFilePath("world5.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            setFilePath("world6.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            setFilePath("world7.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            setFilePath("world8.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            setFilePath("world9.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            setFilePath("world10.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/input")).sendKeys("test10");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            Thread.sleep(2000);
            count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/span[1]")).getText();
        }catch(Exception erro){
            log.error(erro);
        }
        try{
            Assert.assertEquals(count,"共 14 条");
        }catch (AssertionError erro){
            log.error("断言失败："+ erro+"---开始截图---");
            screen.screenShot();
        }
        Assert.assertEquals(count,"共 14 条");
    }


//    @Test
    public void test2DeleteData(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();

        }catch (Exception erro){
            log.error("元素定位失败：" + erro);
        }
    }



    @Test
    public void test3InformationVerification(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/p[5]/span[2]")).getText();
            log.info(information1);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/div[2]/label/span[1]/span")).click();
            information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/p[5]/span[2]")).getText();
            log.info(information2);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/div[3]/label/span[1]/span")).click();
            information3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/p[5]/span[2]")).getText();
            log.info(information3);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/div[4]/label/span[1]/span")).click();
            information4 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/p[5]/span[2]")).getText();
            log.info(information4);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/div[5]/label/span[1]/span")).click();
            information5 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/p[5]/span[2]")).getText();
            log.info(information5);
            driver.navigate().back();
        }catch (Exception erro){
            log.error("元素定位失败："+erro);
        }
        try{
            Assert.assertEquals(information1,".doc，.docx，.dot，.dtd，.js，.json，.mpp，.pdf，.pot，.pps，.ppt，.ppts，.rtf，.wdb，.wps，.xhtml，.xlc，.xlm，.xls，.xlt，.xlw，.xml，.css，.csv，.htm，.html，.txt");
            Assert.assertEquals(information2,".dwg，.dxf，.gif，.jp2，.jpe，.jpeg，.jpg，.png，.svf，.tif，.tiff，.bmp，.webp，.bmp，.pcx，.tif，.tga，.exif，.fpx，.svg，.psd，.cdr，.ico");
            Assert.assertEquals(information3,".ac3，.au，.mp2，.ogg，.flac，.ape，.wav，.mp3，.aac，.wma");
            Assert.assertEquals(information4,".3gpp，.mp4，.mpeg，.mpg，.3gp，.wmv，.asf，.asx，.rm，.rmvb，.3gp，.mov，.m4v，.avi，.dat，.mkv，.flv，.vob");
            Assert.assertEquals(information5,".rar，.zip，.arj，.z，.iso，.jar，.bz2，.gz，.tar，.ace，.lzh，.cab，.arj");
        }catch (AssertionError error){
            log.info("断言失败，开始截图...");
        }
        Assert.assertEquals(information1,".doc，.docx，.dot，.dtd，.js，.json，.mpp，.pdf，.pot，.pps，.ppt，.ppts，.rtf，.wdb，.wps，.xhtml，.xlc，.xlm，.xls，.xlt，.xlw，.xml，.css，.csv，.htm，.html，.txt");
        Assert.assertEquals(information2,".dwg，.dxf，.gif，.jp2，.jpe，.jpeg，.jpg，.png，.svf，.tif，.tiff，.bmp，.webp，.bmp，.pcx，.tif，.tga，.exif，.fpx，.svg，.psd，.cdr，.ico");
        Assert.assertEquals(information3,".ac3，.au，.mp2，.ogg，.flac，.ape，.wav，.mp3，.aac，.wma");
        Assert.assertEquals(information4,".3gpp，.mp4，.mpeg，.mpg，.3gp，.wmv，.asf，.asx，.rm，.rmvb，.3gp，.mov，.m4v，.avi，.dat，.mkv，.flv，.vob");
        Assert.assertEquals(information5,".rar，.zip，.arj，.z，.iso，.jar，.bz2，.gz，.tar，.ace，.lzh，.cab，.arj");
    }

    @Test
    public void test4DeleteDatas(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            setFilePath("world.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/ul/li/div[1]/p/button/span")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            Thread.sleep(500);
            this .message1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div")).getText();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/input")).sendKeys("test1");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            Thread.sleep(500);
            this.message2 = driver.findElement(By.xpath("/html/body/div[3]/p")).getText();
            driver.navigate().back();
        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
        try{
            Assert.assertEquals(message1,"请输入标签名选择或新增");
            Assert.assertEquals(message2,"请上传需存证的证件");
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
        }
        Assert.assertEquals(message1,"请输入标签名选择或新增");
        Assert.assertEquals(message2,"请上传需存证的证件");
    }


    @Test
    public void test5UpdateDataAttest(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            setFilePath("world.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/ul/li/div[1]/p/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/ul/li/div[2]/input")).sendKeys("test");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/ul/li/div[2]/img[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/input")).sendKeys("worldtest");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/input")).sendKeys("worldtest.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div/button")).click();
            Thread.sleep(1000);
            this.fileName = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div")).getText();
        }catch (Exception erro){
            log.error("元素定位失败：" + erro);
        }
        try{
            Assert.assertEquals(fileName,"worldtest.docx");
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(fileName,"worldtest.docx");
    }

    @Test
    public void test6PageData(){
        try{
            driver.navigate().refresh();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/ul/li[2]")).click();
            Thread.sleep(500);
            List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr"));
            this.count1s = elements.size();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/button[1]")).click();
            Thread.sleep(500);
            List<WebElement> elements1 = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr"));
            this.count2s = elements1.size();
        }catch (Exception erro){
            log.error(erro);
        }
        try{
            Assert.assertEquals(count2s,10);
            Assert.assertEquals(count1s,5);
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
            log.info("断言失败，刷新页面...");
            driver.navigate().refresh();
        }
        Assert.assertEquals(count2s,10);
        Assert.assertEquals(count1s,5);
    }
    private void setFilePath(String FileName){
        File filePath = new File("src\\test\\java\\com\\data\\" + FileName);
        String filePaths = filePath.getAbsolutePath().toString();
        this.filePath = filePaths;
    }
}
