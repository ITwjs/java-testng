package com.testng.testcase;

import com.common.MySqlDbOperator;
import com.common.ReadDownLoadFiles;
import com.common.UiBase;
import com.common.screenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class testOneProcessEvidence extends UiBase {
    private static Logger log = Logger.getLogger(testOneProcessEvidence.class);

    private String handle1;

    private String information;

    private String blance;

    private screenShot screen = new screenShot();

    private String BaoQuanNo;

    private String FileHah;

    private String DealHash;

    private String PhoneNumber;

    private String Name;

    private String IdCard;

    private String EnvidenceType;

    private String EnvidenceName;

    private String information1;

    private String information2;

    private String BaoQuanNoSqlData;

    private String FileHahSqlData;

    private String DealHashSqlData;

    private String BaoQuanTime;

    private String BaoQuanTimeSqlData;



    @Test
    public void test1CancelProcessEvidence(){
        try{
            this.handle1 = driver.getWindowHandle();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/div/div/a[2]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"tab-1\"]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/form/div[1]/div/div/input")).sendKeys("testprocess1");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/form/div[2]/div/div/input")).sendKeys("testlable1");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/form/div[4]/div/div/textarea")).sendKeys("test1");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/button")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button/span")).click();
            Thread.sleep(3000);
            String handle = getLastHandle(driver);
            driver.switchTo().window(handle);
            Thread.sleep(1000);
            WebElement iframe = driver.findElement(By.xpath("//*[@id=\"iframe-copy\"]"));
            driver.switchTo().frame(iframe);
            driver.findElement(By.xpath("//*[@id=\"que-wrapper\"]/div[2]/button[1]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/button")).click();
            Thread.sleep(5000);
            driver.close();
            driver.switchTo().window(handle1);
            driver.navigate().back();
            this.information = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/div/span")).getText();
            this.blance = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
        }catch (Exception erro){
            log.error("元素定位失败："+erro);
        }
        try {
            Assert.assertEquals(information,"取证取消");
            log.info("取证状态为：" + information);
            Assert.assertEquals(blance,"可用积分：9,920.00");
            log.info("剩余余额：" + blance);
            log.info("断言成功");
        }catch (AssertionError erro){
            log.info("断言失败，开始截图");
            screen.screenShot();
        }
        Assert.assertEquals(information,"取证取消");
        Assert.assertEquals(blance,"可用积分：9,920.00");
    }

    @Test
    public void test2AddProcessEvidence(){
        try{
            this.handle1 = driver.getWindowHandle();
//            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/div/div/a[2]/span")).click();
//            driver.findElement(By.xpath("//*[@id=\"tab-1\"]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/form/div[1]/div/div/input")).sendKeys("testprocess2");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/form/div[2]/div/div/input")).sendKeys("testlable2");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/form/div[4]/div/div/textarea")).sendKeys("test2");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/button")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button/span")).click();
            Thread.sleep(3000);
            String handle = getLastHandle(driver);
            driver.switchTo().window(handle);
            Thread.sleep(1000);
            WebElement iframe = driver.findElement(By.xpath("//*[@id=\"iframe-copy\"]"));
            driver.switchTo().frame(iframe);
            driver.findElement(By.xpath("//*[@id=\"que-wrapper\"]/div[2]/button[2]")).click();
            Thread.sleep(10000);
            driver.findElement(By.xpath("//*[@id=\"idOuterDiv\"]/p[1]")).click();//结束取证
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/button")).click();
            Thread.sleep(3000);
            driver.close();
            Thread.sleep(500);
            driver.switchTo().window(handle1);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/div[1]/span[2]")).click();
            this.information = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/div/span")).getText();
            this.blance = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
        }catch (Exception erro){
            log.info("元素定位失败："+erro);
        }
        try {
            Assert.assertEquals(information,"上传中");
            log.info("取证状态为：" + information);
            Assert.assertEquals(blance,"可用积分：9,770.00");
            log.info("剩余余额为：" + blance);
            log.info("断言成功");
        }catch (AssertionError erro){
            log.info("断言失败，开始截图");
            screen.screenShot();
        }
        Assert.assertEquals(information,"上传中");
        Assert.assertEquals(blance,"可用积分：9,770.00");
    }

    @Test
    public void test3CancelQueueProcessEvidence(){
        try{
            this.handle1 = driver.getWindowHandle();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/div/div/a[2]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"tab-1\"]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/form/div[1]/div/div/input")).sendKeys("testprocess3");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/form/div[2]/div/div/input")).sendKeys("testlable3");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/form/div[4]/div/div/textarea")).sendKeys("test3");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/button")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button/span")).click();
            Thread.sleep(3000);
            String handle = getLastHandle(driver);
            driver.switchTo().window(handle);
            Thread.sleep(1000);
            WebElement iframe = driver.findElement(By.xpath("//*[@id=\"iframe-copy\"]"));
            driver.switchTo().frame(iframe);
            driver.findElement(By.xpath("//*[@id=\"que-wrapper\"]/div[2]/button")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/button")).click();
            Thread.sleep(3000);
            driver.close();
            driver.switchTo().window(handle1);
            driver.navigate().back();
            driver.navigate().refresh();
            this.information = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/div/span")).getText();
            this.blance = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/article/section[2]/span")).getText();
        }catch (Exception erro){
            log.error("元素定位失败："+erro);
        }
        try{
            Assert.assertEquals(information,"取证取消");
            log.info("排队取消，取证状态为：" + information);
            Assert.assertEquals(blance,"可用积分：9,770.00");
            log.info("剩余余额为：" + blance);
            log.info("断言成功");
        }catch (AssertionError erro){
            log.info("断言失败，开始截图");
            screen.screenShot();
        }
        Assert.assertEquals(information,"取证取消");
        Assert.assertEquals(blance,"可用积分：9,770.00");
    }


    @Test
    public void  test4ProcessEvidenceDetails(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/div/div/a[2]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"tab-1\"]/span")).click();
            this.handle1 = driver.getWindowHandle();
            for(int i =0; i < 50 ;i++){
                if(information.equals("取证成功")){
                    log.info(information);
                    log.info("取证成功，退出循环");
                    break;
                }
                else {
                    Thread.sleep(8000);
                    log.info("取证上传中，页面刷新。");
                    driver.navigate().refresh();
                    this.information = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[7]/div/div/span")).getText();
                    log.info(information);
                }
            }
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[8]/div/div/div/span[1]")).click();
            Thread.sleep(1000);
            String handle = getLastHandle(driver);
            driver.switchTo().window(handle);
            this.BaoQuanNo = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/h3/span")).getText();
            this.FileHah = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[1]/p/span[2]")).getText();
            this.DealHash = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/span[2]")).getText();
            this.EnvidenceType = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[2]/table/tbody/tr[1]/td[2]/span")).getText();
            this.Name = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[2]/table/tbody/tr[2]/td[2]/span")).getText();
            this.IdCard = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[2]/table/tbody/tr[3]/td[2]/span")).getText();
            this.PhoneNumber = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[2]/table/tbody/tr[4]/td[2]/span")).getText();
            this.EnvidenceName = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[2]/table/tbody/tr[5]/td[2]/span")).getText();
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/span")).getText();
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/button/span")).getText();
            this.BaoQuanTime = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[2]/table/tbody/tr[6]/td[2]/span")).getText();
            driver.close();
            driver.switchTo().window(handle1);
            log.info("保全号为："+BaoQuanNo);
            log.info("文件hash："+FileHah);
            log.info("区块链交易hash："+DealHash);
            log.info("取证类型+"+EnvidenceType);
            log.info("取证名称："+EnvidenceName);
            log.info("取证用户："+ Name);
            log.info("取证用户ID："+IdCard);
            log.info("取证用户手机号："+PhoneNumber);
        } catch (Exception erro){
            log.error("元素定位失败：" + erro);
        }
        try {
            MySqlDbOperator db= new MySqlDbOperator();
            db.setConnection();
            this.BaoQuanNoSqlData =db.getSelectOnerDta("SELECT * FROM process_evidence where user_id = '282' and status = 'SUCCESS'","attestation_id");
            this.FileHahSqlData = db.getSelectOnerDta("SELECT * FROM process_evidence where user_id = '282' and status = 'SUCCESS'","zip_sm3");
//            this.DealHashSqlData = db.getSelectOnerDta("SELECT * FROM process_evidence where user_id = '282' and status = 'SUCCESS'","attestation_id");
            db.dbClose();
        }catch (Exception erro){
            log.error("数据库操作失败："+erro);
        }
        try{
            Assert.assertEquals(BaoQuanNo,BaoQuanNoSqlData);
            Assert.assertEquals(FileHah,FileHahSqlData);
            Assert.assertEquals(information1,"下载证据");
            Assert.assertEquals(information2,"打印证书");
            Assert.assertEquals(EnvidenceType,"过程取证");
            Assert.assertEquals(Name,"王家森");
            Assert.assertEquals(IdCard,"3424**********4233");
            Assert.assertEquals(PhoneNumber,"178****1968");
            assert DealHash != null;
            Assert.assertEquals(EnvidenceName,"testprocess2");
            assert BaoQuanTime != null;
        }catch (AssertionError erro){
            log.error("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(BaoQuanNo,BaoQuanNoSqlData);
        Assert.assertEquals(FileHah,FileHahSqlData);
        Assert.assertEquals(information1,"下载证据");
        Assert.assertEquals(information2,"打印证书");
        Assert.assertEquals(EnvidenceType,"过程取证");
        Assert.assertEquals(Name,"王家森");
        Assert.assertEquals(IdCard,"3424**********4233");
        Assert.assertEquals(PhoneNumber,"178****1968");
        assert DealHash != null;
        Assert.assertEquals(EnvidenceName,"testprocess2");
        assert BaoQuanTime != null;

    }


    @Test
    public void test5DownloadProcessEnvidence(){
        try{
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/head/div/div/div/a[2]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"tab-1\"]/span")).click();
            this.handle1 = driver.getWindowHandle();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[8]/div/div/div/span[1]")).click();
            Thread.sleep(3000);
            String handle = getLastHandle(driver);
            driver.switchTo().window(handle);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/span")).click();
            Thread.sleep(5000);
            driver.close();
            driver.switchTo().window(handle1);
        }catch (Exception erro){
            log.error("元素定位失败："+ erro);
        }
        ReadDownLoadFiles readfile = new ReadDownLoadFiles();
        ArrayList<String> fileslist = readfile.getDownLoadFilesName();
        assert fileslist.size() > 0;

    }



    public static String getLastHandle(WebDriver driver) {
        //获取当前打开窗口的所有句柄
        Set<String> Allhandles = driver.getWindowHandles();
        ArrayList<String> lst = new ArrayList<String>(Allhandles);
        return lst.get(lst.size()-1);
    }

    public static void main(String[] args) {
        ReadDownLoadFiles readfile = new ReadDownLoadFiles();
        ArrayList<String> fileslist = readfile.getDownLoadFilesName();
        System.out.println(fileslist.size());
        System.out.println(fileslist.size()>0);
    }
}
