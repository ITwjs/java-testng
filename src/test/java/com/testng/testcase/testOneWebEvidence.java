package com.testng.testcase;

import com.common.MySqlDbOperator;
import com.common.UiBase;
import com.common.screenShot;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class testOneWebEvidence extends UiBase {

    private String time = null;

    private static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static Calendar nowDate = Calendar.getInstance();

    private String count;

    private static Logger log = Logger.getLogger(testOneWebEvidence.class);

    private screenShot screen = new screenShot();

    private String information1 = null;

    private String information2 = null;

    private String information3 = null;

    private ArrayList statusLists =new ArrayList();

    private String balance = null;

    private void setTime(int dayNumber,int monthNumber,int yearNumber){
        nowDate.setTime(new Date());
        nowDate.add(Calendar.YEAR,yearNumber);
        nowDate.add(Calendar.MONTH,monthNumber);
        nowDate.add(Calendar.DAY_OF_YEAR,dayNumber);
        this.time = timeFormat.format(nowDate.getTime());
    }

    @Test
    public void test1addWebEvidenceData(){
        try{
            driver.findElement(By.xpath("//*[@id=\"tab-0\"]")).click();//进入网页取证页面
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/button[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div[1]/div/div[1]/input")).sendKeys("webnametest1");
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div[1]/div/div[1]/input")).getText();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div[2]/div/div/input")).sendKeys("weblabletest1");
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div[1]/div/div[1]/input")).getText();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/div/p/input")).sendKeys("https://www.baidu.com");
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/div/button")).click();//点击立即截图
            for(int i=0;i<10;i++){
                Thread.sleep(1000);
                log.info("网页取证：正在截图中...");
            }
            while(true){
                MySqlDbOperator dba = new MySqlDbOperator();
                dba.setConnection();
                this.statusLists= dba.getSelectOnerDatas("select u.mobile,w.user_id,w.`name`,w.label,o.pay_status,o.`status` from web_forensics w join obtain_address o on w.id = o.wid  join user u on w.user_id = u.user_id where w.user_id = '282' and w.name = 'webnametest1';","status");
                dba.dbClose();
                if(statusLists.get(0).toString().equals("SUCCESS")){
                        log.info("网页截图成功");
                        break;
                }
                Thread.sleep(3000);
            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/p[2]/button")).click();
            Thread.sleep(400);
            this.balance = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            log.error("元素定位失败，原因：" + erro);
        }
        try{
//            Assert.assertEquals(balance,"可用积分：9,755.00");
            Assert.assertEquals(count,"共 1 条");
            log.info("断言成功");
            log.info("余额：" + balance);
            log.info("取证列表当前条数为：" + count);
        }catch (AssertionError erro){
            log.info("断言失败，开始截图");
            screen.screenShot();
        }
//        Assert.assertEquals(balance,"可用积分：9,755.00");
        Assert.assertEquals(count,"共 1 条");
    }


    @Test
    public void test2addWebEvidenceDatas(){
        try{
            driver.findElement(By.xpath("//*[@id=\"tab-0\"]")).click();//进入网页取证页面
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/button[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div[1]/div/div[1]/input")).sendKeys("webnametest2");
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div[1]/div/div[1]/input")).getText();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div[2]/div/div/input")).sendKeys("weblabletest2");
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div[1]/div/div[1]/input")).getText();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/div/p/input")).sendKeys("http://192.168.3.236/home");
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/div/button")).click();//点击立即截图
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/div/p/input")).clear();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/div/p/input")).sendKeys("https://www.baoquan.com");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/div/button")).click();//点击立即截图
            for(int i=0;i<20;i++){
                Thread.sleep(1000);
                log.info("网页取证：正在截图中...");
            }
            while(true){
                log.info("数据库截图状态校验中...");
                MySqlDbOperator dba = new MySqlDbOperator();
                dba.setConnection();
                this.statusLists= dba.getSelectOnerDatas("select u.mobile,w.user_id,w.`name`,w.label,o.pay_status,o.`status` from web_forensics w join obtain_address o on w.id = o.wid  join user u on w.user_id = u.user_id where w.user_id = '282' and w.name = 'webnametest2';","status");
                dba.dbClose();
                if(statusLists.get(0).toString().equals("SUCCESS")){
                    if(statusLists.get(1).toString().equals("SUCCESS")) {
                        log.info("网页截图成功");
                        break;
                    }
                }
                Thread.sleep(3000);
            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/p[2]/button")).click();
            Thread.sleep(400);
            this.balance = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            log.error("元素定位失败，原因：" + erro);
        }
        try{
//            Assert.assertEquals(balance,"可用积分：9,755.00");
            Assert.assertEquals(count,"共 3 条");
            log.info("断言成功");
            log.info("余额：" + balance);
            log.info("取证列表当前条数为：" + count);
        }catch (AssertionError erro){
            log.info("断言失败，开始截图");
            screen.screenShot();
        }
//        Assert.assertEquals(balance,"可用积分：9,755.00");
        Assert.assertEquals(count,"共 3 条");
    }

    @Test
    public void test3TimeSearchWebData(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(500);
            setTime(-1,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[2]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            Thread.sleep(1000);
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div/div[3]/div/span")).getText();
        }catch (Exception erro){
            log.error("元素定位失败：" + erro);
        }
        try {
            Assert.assertEquals(information1,"暂无数据");
            log.info("断言成功");
            log.info("列表取证记录为："+ information1);
        }catch (AssertionError erro){
            log.error("断言失败，开始截图");
            screen.screenShot();
        }
        Assert.assertEquals(information1,"暂无数据");
    }

    @Test
    public void test4TimeSearchWebData(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/i[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(500);
            setTime(0,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[2]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            Thread.sleep(1000);
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            log.error("元素定位失败：" + erro);
        }
        try {
            Assert.assertEquals(information1,"共 3 条");
            log.info("断言成功");
            log.info("列表取证记录为："+ information1);
        }catch (AssertionError erro){
            log.error("断言失败，开始截图");
            screen.screenShot();
        }
        Assert.assertEquals(information1,"共 3 条");
    }

    @Test
    public void test5TimeSearchWebData(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/i[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(500);
            setTime(1,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[2]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            Thread.sleep(1000);
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div/div[3]/div/span")).getText();
        }catch (Exception erro){
            log.error("元素定位失败：" + erro);
        }
        try {
            Assert.assertEquals(information1,"暂无数据");
            log.info("断言成功");
            log.info("列表取证记录为："+ information1);
        }catch (AssertionError erro){
            log.error("断言失败，开始截图");
            screen.screenShot();
        }
        Assert.assertEquals(information1,"暂无数据");
    }

    @Test
    public void test6TimeSearchWebData(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/i[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(500);
            setTime(-1,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(time);
            setTime(1,0,0);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/input[2]")).sendKeys(time);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            Thread.sleep(1000);
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            log.error("元素定位失败：" + erro);
        }
        try {
            Assert.assertEquals(information1,"共 3 条");
            log.info("断言成功");
            log.info("列表取证记录为："+ information1);
        }catch (AssertionError erro){
            log.error("断言失败，开始截图");
            screen.screenShot();
        }
        Assert.assertEquals(information1,"共 3 条");
    }
}
