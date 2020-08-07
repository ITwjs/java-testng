package com.testng.testcase;

import com.common.UiBase;
import com.common.screenShot;
import org.apache.log4j.Logger;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class testOneDateAttest extends UiBase {
    private String count;
    private String balance;
    private String fileName;
    private String filePath;
    private String str = "1";
    private static Logger log=Logger.getLogger(Test.class);
    @Test
    public void test0WordAttest(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            log.info("跳转到新增存证");
            setFilePath("world.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            Thread.sleep(3000);
            log.info("上传world文件成功");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/input")).sendKeys("test");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            log.info("存证成功");
        }catch (Exception erro){
            log.error("操控元素失败，原因："+erro);
        }
        try{
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/span[1]")).getText();
            this.balance = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
            log.info("余额："+balance);
        }catch (Exception erro){
            log.error("元素操控失败，原因："+erro);
        }
        try {
            Assert.assertEquals(count,"共 1 条");
            Assert.assertEquals(balance,"可用积分：9,995.00");
        }catch (AssertionError error){
            log.error(error);
            log.info("断言失败，开始截图...");
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(balance,"可用积分：9,995.00");
        Assert.assertEquals(count,"共 1 条");
    }

    @Test
    public void test1SearchWorldName(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/input")).sendKeys("world.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div/button")).click();
            this.fileName = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr/td[2]/div")).getText();
            log.info("获取文件名："+fileName);
        }catch (Exception erro){
            log.error(erro);
        }
        try {
            Assert.assertEquals(fileName,"world.docx");
        }catch (AssertionError erro){
            log.error(erro);
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(fileName,"world.docx");
    }

    @Test
    public void test2PngAttest(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            log.info("跳转到新增存证");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/div[2]/label/span[1]/span")).click();
            log.info("勾选图片存证按钮");
            setFilePath("laoshu.png");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            Thread.sleep(3000);
            log.info("上传图片文件成功");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/input")).sendKeys("test");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            log.info("存证成功");
        }catch (Exception erro){
            log.error("操控元素失败，原因："+erro);
        }
        try{
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/span[1]")).getText();
            this.balance =driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
            log.info("余额："+balance);
        }catch (Exception erro){
            log.error("元素操控失败，原因："+erro);
        }
        try {
            Assert.assertEquals(count,"共 2 条");
            Assert.assertEquals(balance,"可用积分：9,990.00");
        }catch (AssertionError error){
            log.error(error);
            log.info("断言失败，开始截图...");
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(count,"共 2 条");
        Assert.assertEquals(balance,"可用积分：9,990.00");
    }

    @Test
    public void test3SearchPngName(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/input")).sendKeys("laoshu.png");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div/button")).click();
            this.fileName = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr/td[2]/div")).getText();
            log.info("获取文件名："+fileName);
        }catch (Exception erro){
            log.error(erro);
        }
        try {
            Assert.assertEquals(fileName,"laoshu.png");
        }catch (AssertionError erro){
            log.error(erro);
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(fileName,"laoshu.png");
    }
    @Test
    public void test4YinPinAttest(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            log.info("跳转到新增存证");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/div[3]/label/span[1]/span")).click();
            log.info("勾选图片存证按钮");
            setFilePath("yinpin.mp3");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            Thread.sleep(3000);
            log.info("上传MP3文件成功");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/input")).sendKeys("test");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            log.info("存证成功");
        }catch (Exception erro){
            log.error("操控元素失败，原因："+erro);
        }
        try{
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/span[1]")).getText();
            this.balance =driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
            log.info("余额："+balance);
        }catch (Exception erro){
            log.error("元素操控失败，原因："+erro);
        }
        try {
            Assert.assertEquals(count,"共 3 条");
            Assert.assertEquals(balance,"可用积分：9,985.00");
        }catch (AssertionError error){
            log.error(error);
            log.info("断言失败，开始截图...");
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(count,"共 3 条");
        Assert.assertEquals(balance,"可用积分：9,985.00");
    }

    @Test
    public void test5YinPinSearchName(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/input")).sendKeys("yinpin.mp3");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div/button")).click();
            this.fileName = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr/td[2]/div")).getText();
            log.info("获取文件名："+fileName);
        }catch (Exception erro){
            log.error(erro);
        }
        try{
            Assert.assertEquals(fileName,"yinpin.mp3");
        }catch (AssertionError erro){
            log.error(erro);
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(fileName,"yinpin.mp3");
    }
    @Test
    public void test6VideoAttest(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            log.info("跳转到新增存证");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/div[4]/label/span[1]/span")).click();
            log.info("勾选图片存证按钮");
            setFilePath("P4.mp4");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            Thread.sleep(3000);
            log.info("上传mp4文件成功");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/input")).sendKeys("test");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            log.info("存证成功");
        }catch (Exception erro){
            log.error("操控元素失败，原因："+erro);
        }
        try{
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/span[1]")).getText();
            this.balance =driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
            log.info("余额："+balance);
        }catch (Exception erro){
            log.error("元素操控失败，原因："+erro);
        }
        try {
            Assert.assertEquals(count,"共 4 条");
            Assert.assertEquals(balance,"可用积分：9,980.00");
        }catch (AssertionError error){
            log.error(error);
            log.info("断言失败，开始截图...");
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(count,"共 4 条");
        Assert.assertEquals(balance,"可用积分：9,980.00");
    }

    @Test
    public void test7SearchVideoName(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/input")).sendKeys("P4.mp4");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div/button")).click();
            this.fileName = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr/td[2]/div")).getText();
            log.info("获取文件名："+fileName);
        }catch (Exception erro){
            log.error(erro);
        }
        try{
            Assert.assertEquals(fileName,"P4.mp4");
        }catch (AssertionError erro){
            log.error(erro);
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(fileName,"P4.mp4");
    }

    @Test
    public void test8OtherAttest(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            log.info("跳转到新增存证");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/div[5]/label/span[1]/span")).click();
            log.info("勾选图片存证按钮");
            setFilePath("nacicatzc.zip");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys(filePath);
            Thread.sleep(3000);
            log.info("上传压缩包文件成功");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/input")).sendKeys("test");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            log.info("存证成功");
        }catch (Exception erro){
            log.error("操控元素失败，原因："+erro);
        }
        try{
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/span[1]")).getText();
            this.balance =driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
            log.info("余额："+balance);
        }catch (Exception erro){
            log.error("元素操控失败，原因："+erro);
        }
        try {
            Assert.assertEquals(count,"共 5 条");
            Assert.assertEquals(balance,"可用积分：9,975.00");
        }catch (AssertionError error){
            log.error(error);
            log.info("断言失败，开始截图...");
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(count,"共 5 条");
        Assert.assertEquals(balance,"可用积分：9,975.00");
    }

    @Test
    public void test9SearchPngName(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/input")).sendKeys("nacicatzc.zip");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div/button")).click();
            this.fileName = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr/td[2]/div")).getText();
            log.info("获取文件名："+fileName);
        }catch (Exception erro){
            log.error(erro);
        }
        try {
            Assert.assertEquals(fileName,"nacicatzc.zip");
        }catch (AssertionError erro){
            log.error(erro);
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(fileName,"nacicatzc.zip");
    }

    private void setFilePath(String FileName){
        File filePath = new File("src\\test\\java\\com\\data\\" + FileName);
        String filePaths = filePath.getAbsolutePath().toString();
        this.filePath = filePaths;
    }

    public static void main(String[] args) {

    }
}
