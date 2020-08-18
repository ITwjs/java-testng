package com.testng.testcase;

import com.common.ConnectionLinux;
import com.common.UiBase;
import com.common.screenShot;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;



public class testLogin extends UiBase {
    private static String user_number = "";

    private static Logger log=Logger.getLogger(Test.class);
    @Test
    public void loginTest1(){
        try {
            ConnectionLinux connectionLinux = new ConnectionLinux();
            connectionLinux.setCode("ls -lt /var/backend/current/public/captcha/*.jpg");
            String code = connectionLinux.getCode();
            log.info("登录验证码："+code);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[2]/div/ul/form/div[1]/div/div/input")).sendKeys("17805121968");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[2]/div/ul/form/div[2]/div/div/input")).sendKeys("a123456");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[2]/div/ul/form/div[3]/div/div[1]/input")).sendKeys(code);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[2]/div/ul/button")).click();
        }catch (Exception erro){
            log.error(erro);
        }
        try {
            user_number = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/h1")).getText();
            log.info("获取的user_number:"+user_number);
        }catch (Exception erro){
            log.error(erro);
        }
        try{
            Assert.assertEquals(user_number,"数据存证");
        }catch (AssertionError  erro){
            screenShot s = new screenShot();
            s.screenShot();
        }
        Assert.assertEquals(user_number,"数据存证");
        log.info(user_number+"用户登录成功");
        log.info("登录测试用例通过");
    }
}
