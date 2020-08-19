package com.common;


import org.apache.log4j.Logger;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MySqlDbOperator {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.3.236:3306/notarial";
    //账户密码
    static final String USER_NAME = "root";
    static final String USER_PASSWD = "shuqinkeji";
    private Connection conn;
    private Statement smtm;
    private String str;
    private static Logger log=Logger.getLogger(MySqlDbOperator.class);

    static {
        try{
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setConnection(){
        Connection conn = null;
        try{
            conn = (Connection) DriverManager.getConnection(DB_URL,USER_NAME,USER_PASSWD);
        } catch (SQLException e) {
            log.error("数据库登录失败："+e);
        }
        log.info("数据库登录成功");
        this.conn = conn;
    }

    public void dbClose() throws SQLException {
        conn.close();
        log.info("关闭数据库连接");
    }




    public String getSelectOnerData(String sql, String fieldName) throws SQLException {
        this.smtm = conn.createStatement();
        ArrayList listDatas = new ArrayList();
        try {
            ResultSet data = smtm.executeQuery(sql);
            while (data.next()) {
                this.str = data.getString(fieldName);
                log.info("查询结果：" + str);
            }
        }catch (Exception erro){
            log.error("查询失败："+erro);
        }
        return str;
    }

    public ArrayList getSelectOnerDatas(String sql, String fieldName) throws SQLException {
        this.smtm = conn.createStatement();
        ArrayList listDatas = new ArrayList();
        try {
            ResultSet data = smtm.executeQuery(sql);
            while (data.next()) {
                this.str = data.getString(fieldName);
                listDatas.add(str);
                log.info("查询结果：" + str);
            }
        }catch (Exception erro){
            log.error("查询失败："+erro);
        }
        return listDatas;
    }




    void setControldata(String sql){
        try {
            PreparedStatement presmtm = (PreparedStatement) this.conn.prepareStatement(sql);
            presmtm.executeUpdate();
            log.info("执行成功："+sql);
        }catch (Exception erro){
            log.error("数据更新失败："+erro);
        }
    }



    public static void main(String[] args) throws SQLException {

        MySqlDbOperator dba =new MySqlDbOperator();
        dba.setConnection();
        ArrayList s= dba.getSelectOnerDatas("select u.mobile,w.user_id,w.`name`,w.label,o.pay_status,o.`status` from web_forensics w join obtain_address o on w.id = o.wid  join user u on w.user_id = u.user_id where w.user_id = '282' and w.name = '3';","status");
        System.out.println(s);
        dba.dbClose();
        System.out.println(s.get(0).toString());
    }
}




