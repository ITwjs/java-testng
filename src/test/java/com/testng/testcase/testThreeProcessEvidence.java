package com.testng.testcase;

import com.common.UiBase;
import com.common.screenShot;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.BrokenBarrierException;

public class testThreeProcessEvidence extends UiBase {

    private static Logger log = Logger.getLogger(testThreeProcessEvidence.class);

    private static screenShot screen = new screenShot();

    private String count;

    private String information1;

    private String information2;

    private String information3;

    private String information4;


    @Test
    public void test1SelectSearch(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/div/div/a[2]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"tab-1\"]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div/input")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[2]/span")).click();
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
        try{
            assert count == null;
            log.info("等待取证筛选结果，断言成功。");
        }catch (AssertionError erro){
            log.error("断言失败，原因："+erro);
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        assert count == null;
    }

    @Test
    public void test2SelectSearch(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div/input")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[3]/span")).click();
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
        try{
            assert count == null;
            log.info("取证中筛选结果，断言成功。");
        }catch (AssertionError erro){
            log.error("断言失败，原因："+erro);
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        assert count == null;
    }

    @Test
    public void test3SelectSearch(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div/input")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[4]/span")).click();
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
        try{
            assert count == null;
            log.info("排队中取证筛选结果，断言成功。");
        }catch (AssertionError erro){
            log.error("断言失败，原因："+erro);
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        assert count == null;
    }


    @Test
    public void test4SelectSearch(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div/input")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[5]/span")).click();
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
        try{
            assert count == null;
            log.info("上传中筛选结果，断言成功。");
        }catch (AssertionError erro){
            log.error("断言失败，原因："+erro);
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        assert count == null;
    }


    @Test
    public void test5SelectSearch(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div/input")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[6]/span")).click();
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div")).getText();
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/div/span")).getText();
            this.information3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[6]/div/div/span")).getText();

        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
        try{
            Assert.assertEquals(count,"共 1 条");
            Assert.assertEquals(information1,"testprocess2");
            Assert.assertEquals(information2,"取证成功");
            log.info("取证成功筛选结果，断言成功。");
            log.info("过程取证时长为："+ information3);
        }catch (AssertionError erro){
            log.error("断言失败，原因："+erro);
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"共 1 条");
        Assert.assertEquals(information1,"testprocess2");
        Assert.assertEquals(information2,"取证成功");
    }


    @Test
    public void test6SelectSearch(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div/input")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[7]/span")).click();
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
        try{
            assert count == null;
            log.info("取证失败筛选结果，断言成功。");
        }catch (AssertionError erro){
            log.error("断言失败，原因："+erro);
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        assert count == null;
    }


    @Test
    public void test7SelectSearch(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div/input")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[8]/span")).click();
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div")).getText();
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[1]/div")).getText();
            this.information3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/div/span")).getText();
            this.information4 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[7]/div/div/span")).getText();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/input")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[1]/span")).click();
        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
        try{
            Assert.assertEquals(count,"共 2 条");
            Assert.assertEquals(information1,"testprocess3");
            Assert.assertEquals(information2,"testprocess1");
            Assert.assertEquals(information3,"取证取消");
            Assert.assertEquals(information4,"取证取消");
            log.info("取证取消筛选结果，断言成功。");
        }catch (AssertionError erro){
            log.error("断言失败，原因："+erro);
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"共 2 条");
        Assert.assertEquals(information1,"testprocess3");
        Assert.assertEquals(information2,"testprocess1");
        Assert.assertEquals(information3,"取证取消");
        Assert.assertEquals(information4,"取证取消");
    }
}
