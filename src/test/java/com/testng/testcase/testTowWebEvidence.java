package com.testng.testcase;

import com.common.UiBase;
import com.common.screenShot;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testTowWebEvidence extends UiBase {
    private String count;

    private static Logger log=Logger.getLogger(testTowWebEvidence.class);

    private screenShot screen =new screenShot();

    private String information1;

    private String information2;

    private String information3;

    private String information4;

    private String information5;

    private String information6;

    private String count1;


    @Test
    public void test1WebEvidenceStatusSearch(){
        try{
            driver.navigate().refresh();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div/input")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[2]/span")).click();
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            log.info("元素定位失败，原因：" + erro);
        }
        try{
            Assert.assertEquals(count,"共 3 条");
            log.info("列表网页取证记录为：" + count);
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"共 3 条");
    }


    @Test
    public void test2WebEvidenceStatusSearch(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div/input")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[3]/span")).click();
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div/div[3]/div/span")).getText();
        }catch (Exception erro){
            log.info("元素定位失败，原因：" + erro);
        }
        try{
            Assert.assertEquals(information1,"暂无数据");
            log.info("列表网页取证记录为：" + information1);
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(information1,"暂无数据");
    }

    @Test
    public void test3WebEvidenceLableSearch(){
        try {
            driver.navigate().refresh();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[3]/div[1]/input")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[2]/span")).click();
            Thread.sleep(500);
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div/span")).getText();
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[1]/div/span")).getText();
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            log.error("元素定位失败，原因为：" + erro);
        }
        try {
            Assert.assertEquals(count,"共 2 条");
            Assert.assertEquals(information1,"webnametest2");
            Assert.assertEquals(information2,"webnametest2");
            log.info("断言成功");
            log.info("列表网页取证记录为：" + count);
            log.info(String.format("取证名称分别为：%s、%s.",information1,information2));
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"共 2 条");
        Assert.assertEquals(information1,"webnametest2");
        Assert.assertEquals(information2,"webnametest2");
    }

    @Test
    public void test4WebEvidenceLableSearch(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[3]/div[1]/input")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[3]/span")).click();
            Thread.sleep(500);
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div/span")).getText();
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            log.error("元素定位失败，原因为：" + erro);
        }
        try {
            Assert.assertEquals(count,"共 1 条");
            Assert.assertEquals(information1,"webnametest1");
            log.info("断言成功");
            log.info("列表网页取证记录为：" + count);
            log.info(String.format("取证名称为：%s",information1));
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"共 1 条");
        Assert.assertEquals(information1,"webnametest1");
    }


    @Test
    public void test5WebEvidenceNameSearch(){
        try{
            driver.navigate().refresh();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/input")).sendKeys("webnametest1");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            Thread.sleep(500);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr/td[1]/div/span")).getText();
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr/td[3]/div/div/p/span")).getText();
        }catch (Exception erro){
            log.error("元素定位失败，原因："+ erro);
        }
        try{
            Assert.assertEquals(count,"共 1 条");
            Assert.assertEquals(information1,"webnametest1");
            Assert.assertEquals(information2,"webnametest1");
            log.info("断言成功");
            log.error("列表存证记录为："+count);
            log.info(String.format("搜索列表存证记录为：name=%s、lable=%s。",information1,information2));
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"共 1 条");
        Assert.assertEquals(information1,"webnametest1");
        Assert.assertEquals(information2,"webnametest1");
    }


    @Test
    public void test6WebEvidenceNameSearch(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/input")).clear();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/input")).sendKeys("webnametest2");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            Thread.sleep(500);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div/span")).getText();
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[1]/div/span")).getText();
            this.information3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div/div/p/span")).getText();
            this.information4 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[3]/div/div/p/span0")).getText();
            this.information5 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div/span")).getText();
            this.information6 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[2]/div/span")).getText();
        }catch (Exception erro){
            log.error("元素定位失,原因为：" + erro);
        }
        try{
            Assert.assertEquals(count,"共 2 条");
            Assert.assertEquals(information1,"webnametest2");
            Assert.assertEquals(information2,"webnametest2");
            Assert.assertEquals(information3,"webnametest2");
            Assert.assertEquals(information4,"webnametest2");
            Assert.assertEquals(information5,"https://www.baoquan.com");
            Assert.assertEquals(information6,"http://192.168.3.236/home");
            log.info("断言成功");
            log.info(String.format("第一跳取证记录：name = %s、url = %s 、label = %s",information1,information3,information5));
            log.info(String.format("第二条取证记录：name = %s、url = %s 、label = %s",information2,information4,information6));
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"共 2 条");
        Assert.assertEquals(information1,"webnametest2");
        Assert.assertEquals(information2,"webnametest2");
        Assert.assertEquals(information3,"webnametest2");
        Assert.assertEquals(information4,"webnametest2");
        Assert.assertEquals(information5,"https://www.baoquan.com");
        Assert.assertEquals(information6,"http://192.168.3.236/home");
    }

    @Test
    public void test7WebEvidenceNameDimSearch(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/input")).clear();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/input")).sendKeys("webnametest");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            Thread.sleep(500);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            Assert.assertEquals(count,"共 3 条");
            log.info("断言成功");
            log.info("模糊查询的取证列表记录为：" + count);
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"共 3 条");
    }

    @Test
    public void test8WebEvidenceDeleteData(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/input")).clear();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/input")).sendKeys("webnametest1");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr/td[6]/div/div/div/button/span")).click();
            Thread.sleep(500);
            this.information1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/p")).getText();
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click();
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr/td[1]/div/span")).getText();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr/td[6]/div/div/div/button/span")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click();
            Thread.sleep(1000);
            this.count1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div/div[3]/div/span")).getText();
        }catch (Exception erro){
            log.error("元素定位失败，原因为：" + erro);
        }
        try {
            Assert.assertEquals(count,"共 1 条");
            Assert.assertEquals(information2,"webnametest1");
            Assert.assertEquals(information1,"是否删除本条取证记录?");
            Assert.assertEquals(count1,"暂无数据");
            log.info("断言成功");
            log.info("弹窗提示信息："+ information1);
            log.info("取消删除，列表取证为："+ information2);
            log.info("删除后列表取证记录为：" + count1);
        }catch (Exception erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"共 1 条");
        Assert.assertEquals(information2,"webnametest1");
        Assert.assertEquals(information1,"是否删除本条取证记录?");
        Assert.assertEquals(count1,"暂无数据");
    }
}
