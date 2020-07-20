package com.testng.testcase;

import com.common.ConnectionLinux;
import com.common.UiBase;
import com.jcraft.jsch.JSchException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import java.io.IOException;


public class testLogin extends UiBase {
    private static String user_number = "";

    private static Logger log=Logger.getLogger(Test.class);
    @Test
    public void loginTest1() throws InterruptedException, IOException, JSchException {
        try {
            ConnectionLinux connectionLinux = new ConnectionLinux();
            connectionLinux.setCode("ls -lt /tmp/.eagle/images/*.png");
            String code = connectionLinux.getCode();
            log.info("登录验证码："+code);
            driver.findElement(By.name("phoneNumber")).sendKeys("13333333333");
            driver.findElement(By.name("password")).sendKeys("a123456");
            driver.findElement(By.name("checkCode")).sendKeys(code);
            driver.findElement(By.className("login")).click();
        }catch (Exception erro){
            log.error(erro);
        }
        try {
            user_number = driver.findElement(By.xpath("//*[@class=\"account\"]/span[2]")).getText();
        }catch (Exception erro){
            log.error(erro);
        }
        Assert.assertEquals(user_number,"13333333333");
        log.info(user_number+"用户登录成功");
        log.info("登录测试用例通过");
    }

}
