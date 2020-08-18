package com.testng.testcase;

import com.common.UiBase;
import com.common.screenShot;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import javax.management.BadBinaryOpValueExpException;

public class testOneWebEvidence extends UiBase {
    private String count;

    private static Logger log = Logger.getLogger(testOneWebEvidence.class);

    private screenShot screen = new screenShot();

    private String information1;

    private String information2;

    private String information3;

    @Test
    public void test1addWebEvidenceData(){
        try{
            driver.findElement(By.xpath("//*[@id=\"tab-0\"]")).click();//进入网页取证页面
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/button[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div[1]/div/div[1]/input")).sendKeys("webnametest1");
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div[1]/div/div[1]/input")).getText();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div[1]/div/div[1]/input")).sendKeys("weblabletest1");
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div/form/div[1]/div/div[1]/input")).getText();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/div/p/input")).sendKeys("https://www.baidu.com");
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/div/button")).click();//立即截图
        }catch (Exception erro){
            log.error("元素定位失败，原因：" + erro);
        }
    }
}
