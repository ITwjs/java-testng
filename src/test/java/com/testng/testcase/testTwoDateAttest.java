package com.testng.testcase;


import com.common.UiBase;
import com.common.screenShot;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class testTwoDateAttest extends UiBase {
    private String count;
    private String information;
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static Calendar nowDate = Calendar.getInstance();
    private String time;
    private static Logger log =Logger.getLogger(Test.class);

    private void setTime(int dayNumber,int monthNumber,int yearNumber){
        nowDate.setTime(new Date());
        nowDate.add(Calendar.YEAR,yearNumber);
        nowDate.add(Calendar.MONTH,monthNumber);
        nowDate.add(Calendar.DAY_OF_YEAR,dayNumber);
       this.time = timeFormat.format(nowDate.getTime());
    }

    @Test
    public void test1TimeScopeSearch(){
        try{
            driver.navigate().refresh();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(4000);
            setTime(-1,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/input[1]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/input[2]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div/button")).click();
}catch (Exception erro){
        log.error("操控元素失败："+ erro);
        }
        try{
        Thread.sleep(2000);
        this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/span[1]")).getText();
        log.info("count:"+count);
        }catch (Exception erro){
        log.error(erro);
        }
        try{
        Assert.assertEquals(count,"存证条目（条）：0");
        }catch (AssertionError erro){
        log.error(erro);
        screenShot s = new screenShot();
        s.screenShot();
        }
        Assert.assertEquals(count,"存证条目（条）：0");
        }

    @Test
    public void test2TimeScopeSearch(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/i[2]")).click(); //清空时间
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(4000);
            setTime(0,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/input[1]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/input[2]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div/button")).click();
        }catch (Exception erro){
            log.error("操控元素失败："+erro);
        }
        try{
            Thread.sleep(2000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/span[1]")).getText();
            log.info("count:"+count);
        }catch (Exception erro){
            log.error(erro);
        }
        try{
            Assert.assertEquals(count,"存证条目（条）：5");
        }catch (AssertionError erro){
            log.error(erro);
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(count,"存证条目（条）：5");
    }

    @Test
    public void test3TimeScopeSearch(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/i[2]")).click(); //清空时间
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(4000);
            setTime(1,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/input[1]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/input[2]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div/button")).click();
        }catch (Exception erro){
            log.error("操控元素失败："+erro);
        }
        try{
            Thread.sleep(2000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/span[1]")).getText();
            log.info("count:"+count);
        }catch (Exception erro){
            log.error(erro);
        }
        try{
            Assert.assertEquals(count,"存证条目（条）：0");
        }catch (AssertionError erro){
            log.error(erro);
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(count,"存证条目（条）：0");
    }

    @Test
    public void test4TimeScopeSearch(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/i[2]")).click(); //清空时间
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(4000);
            setTime(-1,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/input[1]")).sendKeys(time);
            setTime(1,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/input[2]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div/button")).click();
        }catch (Exception erro){
            log.error("操控元素失败："+erro);
        }
        try{
            Thread.sleep(2000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/span[1]")).getText();
            log.info("count:"+count);
        }catch (Exception erro){
            log.error(erro);
        }
        try{
            Assert.assertEquals(count,"存证条目（条）：5");
        }catch (AssertionError erro){
            log.error(erro);
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(count,"存证条目（条）：5");
    }


    public void test5TypeSelect(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/i[2]")).click(); //清空时间
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/span/span/i")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[1]")).click();
        }catch (Exception erro){
            log.error(erro);
        }
        try {
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/span[1]")).getText();
            log.info("count:"+count);
        }catch (Exception erro){
            log.error(erro);
        }
        Assert.assertEquals(count,"存证条目（条）：1");
    }

    @Test
    public void test6ViewDetails(){
        try{
            String handle1 = driver.getWindowHandle();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/input")).sendKeys("world.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div/button")).click();
            String baoquanNO = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr/td[1]/div")).getText();
            log.info(baoquanNO);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr/td[7]/div/div/span")).click();
            Thread.sleep(3000);
            String handle = getLastHandle(driver);
            driver.switchTo().window(handle);
            String T= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/span")).getText();
            log.info(T);
            String assertBaoquanNo = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/h3/span")).getText();
            log.info(assertBaoquanNo);
        }catch (Exception erro){
            log.error(erro);
        }
    }
    public static String getLastHandle(WebDriver driver) {
        //获取当前打开窗口的所有句柄
        Set<String> Allhandles = driver.getWindowHandles();
        ArrayList<String> lst = new ArrayList<String>(Allhandles);
        return lst.get(lst.size()-1);
    }
    public static void main(String[] args) throws ParseException {
        testTwoDateAttest t= new testTwoDateAttest();
        t.setTime(0,0,0);
        System.out.println(t.time);
        }
}
