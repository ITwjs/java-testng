package com.testng.testcase;

import com.common.MySqlDbOperator;
import com.common.ReadDownLoadFiles;
import com.common.UiBase;
import com.common.screenShot;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.html.HTMLDocument;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.Set;

public class testThreeWebEvidence extends UiBase {

    private static Logger log = Logger.getLogger(testThreeWebEvidence.class);

    private screenShot screen = new screenShot();

    private String count;

    private String information1;

    private String information2;

    private String information3;

    private String url;

    private String userName;

    private String evidenceType;

    private String evidenceName;

    private String phoneNumber;

    private String idCard;

    private String BaoQuanTime;

    private String BaoQuanOrganization;

    private String fileHash;

    private String dealHash;

    private String handle1;

    private String BaoQuanNumber;

    private String dbBaoQuabNumber;

    private String dbFileHash;

    private ArrayList filesList;



    public static String getLastHandle(WebDriver driver) {
        //获取当前打开窗口的所有句柄
        Set<String> Allhandles = driver.getWindowHandles();
        ArrayList<String> lst = new ArrayList<String>(Allhandles);
        return lst.get(lst.size()-1);
    }


    @Test
    public void test1WebEvidenceDetails(){
        try {
            this.handle1 = driver.getWindowHandle();
            driver.navigate().refresh();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/input")).sendKeys("webnametest2");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[4]/div/button")).click();
            Thread.sleep(100);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[6]/div/div/div/span[1]")).click();
            Thread.sleep(2000);
            String handle = getLastHandle(driver);
            driver.switchTo().window(handle);
            this.BaoQuanNumber = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/h3/span")).getText();
            this.fileHash = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/span[2]")).getText();
            this.dealHash = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/span[2]")).getText();
            this.evidenceType = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[1]/table/tbody/tr[1]/td[2]/span")).getTagName();
            this.evidenceName = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[1]/table/tbody/tr[2]/td[2]/span")).getTagName();
            this.userName = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[1]/table/tbody/tr[3]/td[2]/span")).getTagName();
            this.idCard = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[1]/table/tbody/tr[4]/td[2]/span")).getText();
            this.url = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[1]/table/tbody/tr[5]/td[2]/span")).getText();
            this.BaoQuanTime = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[1]/table/tbody/tr[6]/td[2]/span")).getText();
            this.BaoQuanOrganization = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[1]/table/tbody/tr[7]/td/span")).getText();
            this.information1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/span")).getText();
            this.information2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/button/span")).getText();
        } catch (Exception erro){
            log.error("元素定位失败,原因：" + erro);
        }
        try {
            MySqlDbOperator db = new MySqlDbOperator();
            db.setConnection();
            this.dbBaoQuabNumber = db.getSelectOnerData("select o.zip_sm3,o.zip_sm3,o.baoquan_no from obtain_address o left join web_forensics w on w.id = o.wid where w.user_id = '282' and o.url = 'https://www.baoquan.com'","baoquan_no");
            this.dbFileHash= db.getSelectOnerData("select o.zip_sm3,o.zip_sm3 from obtain_address o left join web_forensics w on w.id = o.wid where w.user_id = '282' and o.url = 'https://www.baoquan.com'","zip_sm3");
            db.dbClose();
        }catch (Exception erro){
            log.error("数据库数据库查询失败...");
        }
        try{
            Assert.assertEquals(BaoQuanNumber,dbBaoQuabNumber);
            Assert.assertEquals(fileHash,dbFileHash);
            Assert.assertEquals(evidenceType,"网页取正");
            Assert.assertEquals(evidenceName,"webnametest2");
            Assert.assertEquals(userName,"王家森");
            Assert.assertEquals(idCard,"3424**********4233");
            Assert.assertEquals(url,"https://www.baoquan.com");
            Assert.assertEquals(BaoQuanOrganization,"浙江省杭州市杭州互联网公证处");
            Assert.assertEquals(information1,"下载证据");
            Assert.assertEquals(information2,"打印证书");
            log.info("断言成功");
            log.info("网页取证保全号："+BaoQuanNumber);
            log.info("网页取正数字指纹hash："+fileHash);
            log.info("网页取证区块交易hash："+ dealHash);
            log.info("网页取证类型："+ evidenceType);
            log.info("网页取证名称：" + evidenceName);
            log.info("网页取证主体："+ userName);
            log.info("网页取证主体身份标识："+ idCard);
            log.info("网页取证url："+ url);
            log.info("网页取证保全时间：" + BaoQuanTime);
            log.info("网页取证保全机构：" + BaoQuanOrganization);
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        Assert.assertEquals(BaoQuanNumber,dbBaoQuabNumber);
        Assert.assertEquals(fileHash,dbFileHash);
        Assert.assertEquals(evidenceType,"网页取正");
        Assert.assertEquals(evidenceName,"webnametest2");
        Assert.assertEquals(userName,"王家森");
        Assert.assertEquals(idCard,"3424**********4233");
        Assert.assertEquals(url,"https://www.baoquan.com");
        Assert.assertEquals(BaoQuanOrganization,"浙江省杭州市杭州互联网公证处");
        Assert.assertEquals(information1,"下载证据");
        Assert.assertEquals(information2,"打印证书");
    }

    @Test
    public void test2WebEvidenceDownLoadFile(){
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/span")).click();
            Thread.sleep(3000);
            driver.close();
            Thread.sleep(500);
            driver.switchTo().window(handle1);
        }catch (Exception erro){
            log.error("元素定位失败：" + erro);
        }
        try {
            ReadDownLoadFiles download = new ReadDownLoadFiles();
            this.filesList = download.getDownLoadFilesName();
        }catch (Exception erro){
            log.error("文件名获取失败");
        }
        try {
            assert filesList.size() > 0;
            log.info("断言成功");
        }catch (AssertionError erro){
            log.info("断言失败，开始截图...");
            screen.screenShot();
        }
        assert filesList.size() > 0;
    }
}
