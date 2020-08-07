package com.testng.testcase;

import com.common.UiBase;
import com.common.screenShot;
import org.apache.log4j.Logger;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.java2d.pipe.AAShapePipe;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class testTwoProcessEvidence extends UiBase {
    private static Logger log = Logger.getLogger(testOneProcessEvidence.class);

    private static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static Calendar nowDate = Calendar.getInstance();

    private screenShot screen = new screenShot();

    private String time;

    private String count;

    private String information;

    private void setTime(int dayNumber,int monthNumber,int yearNumber){
        nowDate.setTime(new Date());
        nowDate.add(Calendar.YEAR,yearNumber);
        nowDate.add(Calendar.MONTH,monthNumber);
        nowDate.add(Calendar.DAY_OF_YEAR,dayNumber);
        this.time = timeFormat.format(nowDate.getTime());
    }


    @Test
    public void test1TimeSearchData(){
        try {
            driver.navigate().refresh();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(1000);
            setTime(-1,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[2]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            Thread.sleep(500);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
            log.info("列表记录数："+ count);
        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
        try{
            assert count == null;
        }catch (AssertionError error){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        assert count == null;
    }


    @Test
    public void test2TimeSearchData(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/i[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(1000);
            setTime(0,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[2]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            Thread.sleep(500);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
            log.info("列表记录数："+ count);
        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
        try{
           Assert.assertEquals(count,"共 3 条");
        }catch (AssertionError error){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"共 3 条");
    }


    @Test
    public void test3TimeSearchData(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/i[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(1000);
            setTime(1,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[2]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            Thread.sleep(500);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
            log.info("列表记录数："+ count);
        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
        try{
            assert count == null;
        }catch (AssertionError error){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        assert count == null;
    }


    @Test
    public void test4TimeSearchData(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/i[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(1000);
            setTime(-1,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(time);
            setTime(1,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[2]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            Thread.sleep(500);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
            log.info("列表记录数："+ count);
        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
        try{
            Assert.assertEquals(count,"共 3 条");
        }catch (AssertionError error){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"共 3 条");
    }

    @Test
    public void test5NameSearchData(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/i[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/input")).sendKeys("testprocess2");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
            log.info("列表记录数："+ count);
            this.information = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr/td[1]/div")).getText();
            log.info("过程取证名称为："+ information);
            Thread.sleep(100);
        }catch (Exception erro){
            log.error("元素定位失败："+erro);
        }
        try {
            Assert.assertEquals(count,"共 1 条");
            Assert.assertEquals(information,"testprocess2");
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
        }
        Assert.assertEquals(count,"共 1 条");
        Assert.assertEquals(information,"testprocess2");
    }


//    @Test
    public void test6DeleteCancelData(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/input")).clear();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/input")).sendKeys("");
        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
    }
}
