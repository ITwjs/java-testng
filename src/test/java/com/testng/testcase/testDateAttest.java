package com.testng.testcase;

import com.common.UiBase;
import com.common.screenShot;
import org.apache.log4j.Logger;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testDateAttest extends UiBase {
    private String count;
    private String balance;

    private static Logger log=Logger.getLogger(Test.class);
    @Test
    public void test1WordAttest(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            log.info("跳转到新增存证");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys("D:\\ObjectInformation\\BaoQuanWang\\UI\\src\\test\\java\\com\\data\\world.docx");
            Thread.sleep(1000);
            log.info("上传world文件成功");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/input")).sendKeys("test");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            log.info("存证成功");
        }catch (Exception erro){
            log.error("操控元素失败，原因："+erro);
        }
        try{
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/span[1]")).getText();
            this.balance = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
            log.info("余额："+balance);
        }catch (Exception erro){
            log.error("元素操控失败，原因："+erro);
        }
        try {
            Assert.assertEquals(count,"存证条目（条）：1");
            Assert.assertEquals(balance,"可用积分：9,995.00");
        }catch (AssertionError error){
            log.error(error);
            log.info("断言失败，开始截图...");
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(balance,"可用积分：9,995.00");
        Assert.assertEquals(count,"存证条目（条）：1");
    }

    @Test
    public void test2PngAttest(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            log.info("跳转到新增存证");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/div[2]/label/span[1]/span")).click();
            log.info("勾选图片存证按钮");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys("D:\\ObjectInformation\\BaoQuanWang\\UI\\src\\test\\java\\com\\data\\laoshu.png");
            Thread.sleep(1000);
            log.info("上传world文件成功");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/input")).sendKeys("test");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            log.info("存证成功");
        }catch (Exception erro){
            log.error("操控元素失败，原因："+erro);
        }
        try{
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/span[1]")).getText();
            this.balance =driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
            log.info("余额："+balance);
        }catch (Exception erro){
            log.error("元素操控失败，原因："+erro);
        }
        try {
            Assert.assertEquals(count,"存证条目（条）：1");
            Assert.assertEquals(balance,"可用积分：9,990.00");
        }catch (AssertionError error){
            log.error(error);
            log.info("断言失败，开始截图...");
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(count,"存证条目（条）：1");
        Assert.assertEquals(balance,"可用积分：9,990.00");
    }
    @Test
    public void test3YinPinAttest(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            log.info("跳转到新增存证");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/div[3]/label/span[1]/span")).click();
            log.info("勾选图片存证按钮");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys("D:\\ObjectInformation\\BaoQuanWang\\UI\\src\\test\\java\\com\\data\\yinpin.mp3");
            Thread.sleep(1000);
            log.info("上传world文件成功");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/input")).sendKeys("test");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            log.info("存证成功");
        }catch (Exception erro){
            log.error("操控元素失败，原因："+erro);
        }
        try{
            driver.navigate().back();
            this.balance =driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
            log.info("余额："+balance);
        }catch (Exception erro){
            log.error("元素操控失败，原因："+erro);
        }
        try {
            Assert.assertEquals(balance,"可用积分：9,985.00");
        }catch (AssertionError error){
            log.error(error);
            log.info("断言失败，开始截图...");
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(balance,"可用积分：9,985.00");
    }
    @Test
    public void test4VideoAttest(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            log.info("跳转到新增存证");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/div[4]/label/span[1]/span")).click();
            log.info("勾选图片存证按钮");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys("D:\\ObjectInformation\\BaoQuanWang\\UI\\src\\test\\java\\com\\data\\P4.mp4");
            Thread.sleep(1000);
            log.info("上传world文件成功");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/input")).sendKeys("test");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            log.info("存证成功");
        }catch (Exception erro){
            log.error("操控元素失败，原因："+erro);
        }
        try{
            driver.navigate().refresh();
            this.balance =driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
            log.info("余额："+balance);
        }catch (Exception erro){
            log.error("元素操控失败，原因："+erro);
        }
        try {
            Assert.assertEquals(balance,"可用积分：9,980.00");
        }catch (AssertionError error){
            log.error(error);
            log.info("断言失败，开始截图...");
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(balance,"可用积分：9,980.00");
    }
    @Test
    public void test5OtherAttest(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/button")).click();
            log.info("跳转到新增存证");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/div[5]/label/span[1]/span")).click();
            log.info("勾选图片存证按钮");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/div/div/input")).sendKeys("D:\\ObjectInformation\\BaoQuanWang\\UI\\src\\test\\java\\com\\data\\nacicatzc.zip");
            Thread.sleep(1000);
            log.info("上传world文件成功");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/input")).sendKeys("test");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/button")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            log.info("存证成功");
        }catch (Exception erro){
            log.error("操控元素失败，原因："+erro);
        }
        try{
            driver.navigate().back();
            this.balance =driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
            log.info("余额："+balance);
        }catch (Exception erro){
            log.error("元素操控失败，原因："+erro);
        }
        try {
            Assert.assertEquals(balance,"可用积分：9,975.00");
        }catch (AssertionError error){
            log.error(error);
            log.info("断言失败，开始截图...");
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(balance,"可用积分：9,975.00");
    }
}
