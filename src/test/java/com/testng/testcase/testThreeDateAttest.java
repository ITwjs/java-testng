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
import java.util.*;

public class testThreeDateAttest extends UiBase {
    private String information;
    private String handle1;
    private String count;
    private String baoquanNO;
    private String assertBaoquanNO;
    private String fileHash;
    private String dealHash;
    private String Name;
    private String phoneNumber;
    private String idCard;
    private String fileName;
    private String table1;
    private String table2;
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static Calendar nowDate = Calendar.getInstance();
    private String time;
    private static Logger log =Logger.getLogger(Test.class);
    private  screenShot screen = new screenShot();

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
            Thread.sleep(2000);
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
        screen.screenShot();
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
            screen.screenShot();
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
            screen.screenShot();
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
            screen.screenShot();
        }
        Assert.assertEquals(count,"存证条目（条）：5");
    }



    @Test
    public void test5ViewDetails(){
        try{
            this.handle1 = driver.getWindowHandle();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/input")).sendKeys("world.docx");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div/button")).click();
            Thread.sleep(2000);
            this.baoquanNO = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr/td[1]/div")).getText();
            log.info(baoquanNO);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr/td[7]/div/div/span")).click();
            Thread.sleep(3000);
            String handle = getLastHandle(driver);
            driver.switchTo().window(handle);
            this.table1= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/span")).getText();
            this.assertBaoquanNO = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/h3/span")).getText();
            this.fileHash = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[1]/p/span[2]")).getText();
            this.dealHash = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/span[2]")).getText();
            this.Name = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[2]/table/tbody/tr[1]/td[2]/span")).getText();
            this.phoneNumber = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[2]/table/tbody/tr[2]/td[2]/span")).getText();
            this.idCard = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[2]/table/tbody/tr[3]/td[2]/span")).getText();
            this.fileName = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/p/div/div[2]/table/tbody/tr[4]/td[2]/span")).getText();
            this.table2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/button/span")).getText();
            driver.close();
            log.info("存证用户姓名："+Name);
            log.info("存证用户电话："+phoneNumber);
            log.info("存证用户的身份证："+idCard);
            log.info("存证文件名称："+fileName);
            log.info("存证文件hash："+fileHash);
            log.info("存证文件交易hash："+dealHash);
        }catch (Exception erro){
            log.error(erro);
        }
        try {
            Assert.assertEquals(baoquanNO,assertBaoquanNO);
            Assert.assertEquals(Name,"王家森");
            Assert.assertEquals(phoneNumber,"178****1968");
            Assert.assertEquals(idCard,"342425********4233");
            Assert.assertEquals(fileName,"world.docx");
            assert fileHash != null;
            assert dealHash != null;
            Assert.assertEquals(table1,"下载证据");
            Assert.assertEquals(table2,"打印证书");
        }catch (AssertionError erro){
            screen.screenShot();
            log.error(erro);
        }
        Assert.assertEquals(baoquanNO,assertBaoquanNO);
        Assert.assertEquals(Name,"王家森");
        Assert.assertEquals(phoneNumber,"178****1968");
        Assert.assertEquals(idCard,"342425********4233");
        Assert.assertEquals(fileName,"world.docx");
        assert fileHash != null;
        assert dealHash != null;
        Assert.assertEquals(table1,"下载证据");
        Assert.assertEquals(table2,"打印证书");
    }

    @Test
    public void test6DeleteData(){
        String count1 = null;
        try{
            driver.switchTo().window(handle1);
            driver.navigate().refresh();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/div/button/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]/span")).click();
            log.info("取消成功");
            Thread.sleep(2000);
            count1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/span[1]")).getText();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/div/button/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]/span")).click();
            log.info("删除成功");
            Thread.sleep(500);
            driver.navigate().refresh();
            Thread.sleep(500);
            count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/span[1]")).getText();
        }catch (Exception erro){
            log.error(erro);
        }
        try {
            Assert.assertEquals(count1,"共 5 条");
            Assert.assertEquals(count,"共 4 条");
        }catch (AssertionError erro){
            screen.screenShot();
            log.error(erro);
        }
        Assert.assertEquals(count1,"共 5 条");
        Assert.assertEquals(count,"共 4 条");
    }
    


    public static String getLastHandle(WebDriver driver) {
        //获取当前打开窗口的所有句柄
        Set<String> Allhandles = driver.getWindowHandles();
        ArrayList<String> lst = new ArrayList<String>(Allhandles);
        return lst.get(lst.size()-1);
    }
    public static void main(String[] args) throws ParseException {
        testThreeDateAttest t= new testThreeDateAttest();
        t.setTime(0,0,0);
        System.out.println(t.time);
        }
}
