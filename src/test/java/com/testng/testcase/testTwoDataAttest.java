package com.testng.testcase;

import com.common.UiBase;
import com.common.screenShot;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testTwoDataAttest extends UiBase {

    private static Logger log = Logger.getLogger(testTwoDataAttest.class);

    private screenShot screen = new screenShot();

    private String count;

    private String information1;

    private String information2;

    private String information3;


    @Test
    public void test1TypeSelect(){
        try {
            driver.navigate().refresh();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/span/span/i")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[2]/span")).click();
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/span[1]")).getText();
            log.info("列表记录个数：:"+count);
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div")).getText();
            log.info("文档筛选存证名称为：" + information1);
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div")).getText();
            log.info("存证文件类型为：" + information2);
            this.information3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div")).getText();
            log.info("文档存证保全号：" + information3);
        }catch (Exception erro){
            log.error("元素定位失败：" + erro);
        }
        try {
            Assert.assertEquals(count,"存证条目（条）：1");
            Assert.assertEquals(information1,"world.docx");
            Assert.assertEquals(information2,"文档");
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"存证条目（条）：1");
        Assert.assertEquals(information1,"world.docx");
        Assert.assertEquals(information2,"文档");
    }

    @Test
    public void test2TypeSelect(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/span/span/i")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[3]/span")).click();
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/span[1]")).getText();
            log.info("列表记录个数：:"+count);
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div")).getText();
            log.info("文档筛选存证名称为：" + information1);
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div")).getText();
            log.info("存证文件类型为：" + information2);
            this.information3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div")).getText();
            log.info("文档存证保全号：" + information3);
        }catch (Exception erro){
            log.error("元素定位失败：" + erro);
        }
        try {
            Assert.assertEquals(count,"存证条目（条）：1");
            Assert.assertEquals(information1,"laoshu.png");
            Assert.assertEquals(information2,"图片");
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"存证条目（条）：1");
        Assert.assertEquals(information1,"laoshu.png");
        Assert.assertEquals(information2,"图片");
    }

    @Test
    public void test3TypeSelect(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/span/span/i")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[4]/span")).click();
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/span[1]")).getText();
            log.info("列表记录个数：:"+count);
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div")).getText();
            log.info("文档筛选存证名称为：" + information1);
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div")).getText();
            log.info("存证文件类型为：" + information2);
            this.information3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div")).getText();
            log.info("文档存证保全号：" + information3);
        }catch (Exception erro){
            log.error("元素定位失败：" + erro);
        }
        try {
            Assert.assertEquals(count,"存证条目（条）：1");
            Assert.assertEquals(information1,"yinpin.mp3");
            Assert.assertEquals(information2,"音频");
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"存证条目（条）：1");
        Assert.assertEquals(information1,"yinpin.mp3");
        Assert.assertEquals(information2,"音频");
    }


    @Test
    public void test4TypeSelect(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/span/span/i")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[5]/span")).click();
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/span[1]")).getText();
            log.info("列表记录个数：:"+count);
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div")).getText();
            log.info("文档筛选存证名称为：" + information1);
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div")).getText();
            log.info("存证文件类型为：" + information2);
            this.information3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div")).getText();
            log.info("文档存证保全号：" + information3);
        }catch (Exception erro){
            log.error("元素定位失败：" + erro);
        }
        try {
            Assert.assertEquals(count,"存证条目（条）：1");
            Assert.assertEquals(information1,"P4.mp4");
            Assert.assertEquals(information2,"视频");
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"存证条目（条）：1");
        Assert.assertEquals(information1,"P4.mp4");
        Assert.assertEquals(information2,"视频");
    }

    @Test
    public void test5TypeSelect(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/span/span/i")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[6]/span")).click();
            Thread.sleep(1000);
            this.count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/span[1]")).getText();
            log.info("列表记录个数：:"+count);
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div")).getText();
            log.info("文档筛选存证名称为：" + information1);
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div")).getText();
            log.info("存证文件类型为：" + information2);
            this.information3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div")).getText();
            log.info("文档存证保全号：" + information3);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/span/span/i")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/ul/li[1]/span")).click();
        }catch (Exception erro){
            log.error("元素定位失败：" + erro);
        }
        try {
            Assert.assertEquals(count,"存证条目（条）：1");
            Assert.assertEquals(information1,"nacicatzc.zip");
            Assert.assertEquals(information2,"其他");
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(count,"存证条目（条）：1");
        Assert.assertEquals(information1,"nacicatzc.zip");
        Assert.assertEquals(information2,"其他");
    }
}
