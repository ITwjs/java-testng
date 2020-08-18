package com.testng.testcase;

import com.common.UiBase;
import com.common.screenShot;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class testFourProcessEvidence extends UiBase {

    private static Logger log = Logger.getLogger(testFourProcessEvidence.class);

    private static screenShot screen = new screenShot();

    private String count;

    private String information1;

    private String information2;

    private String information3;

    private String information4;

     @Test
    public void test1SelectSearch(){
         try{
             driver.navigate().refresh();
             driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[3]/div[1]/input")).click();
             Thread.sleep(200);
             this.information3 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[2]/span")).getText();
             Thread.sleep(200);
             driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[2]/span")).click();
             Thread.sleep(1000);
             this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
             this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div")).getText();
             this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/div/span")).getText();
         }catch (Exception erro){
             log.error("元素定位失败，原因：" + erro);
         }
         try {
             Assert.assertEquals(count,"共 1 条");
             Assert.assertEquals(information1,"testprocess3");
             Assert.assertEquals(information2,"取证取消");
             log.info("标签：" + information3 + "筛选成功");
         }catch (AssertionError erro){
             log.error("断言失败原因："+ erro);
             log.info("断言失败，开始截图...");
             screen.screenShot();
         }
         Assert.assertEquals(count,"共 1 条");
         Assert.assertEquals(information1,"testprocess3");
         Assert.assertEquals(information2,"取证取消");
     }


    @Test
    public void test2SelectSearch(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[3]/div[1]/input")).click();
            Thread.sleep(200);
            this.information3 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[3]/span")).getText();
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[3]/span")).click();
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/span[1]")).getText();
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div")).getText();
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/div/span")).getText();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[3]/div[1]/input")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[1]/span")).click();
        }catch (Exception erro){
            log.error("元素定位失败，原因：" + erro); 
        }
        try {
            Assert.assertEquals(count,"共 1 条");
            Assert.assertEquals(information1,"testprocess2");
            Assert.assertEquals(information2,"取证成功");
            log.info("标签：" + information3 + "筛选成功");
        }catch (AssertionError erro){
            log.error("断言失败原因："+ erro);
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"共 1 条");
        Assert.assertEquals(information1,"testprocess2");
        Assert.assertEquals(information2,"取证成功");
    }
}
