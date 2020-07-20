package com.common;


import org.apache.log4j.Logger;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySqlDbOperator {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.3.30:3306/eagle";
    //账户密码
    static final String USER_NAME = "root";
    static final String USER_PASSWD = "shuqinkeji";
    private String SQL;
    private String resultDate;
    private String fieldName;
    private Connection conn;
    private Statement smtm;
    private PreparedStatement persmtm;
    private static Logger log=Logger.getLogger(MySqlDbOperator.class);

    static {
        try{
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void setConnection(){
        Connection conn = null;
        try{
            conn = (Connection) DriverManager.getConnection(DB_URL,USER_NAME,USER_PASSWD);
        } catch (SQLException e) {
            log.error("数据库登录失败："+e);
        }
        log.info("数据库登录成功");
        this.conn = conn;
    }

    void dbClose() throws SQLException {
        conn.close();
        log.info("数据库关闭连接");
    }




    private void setSelectOnerDta(String sql, String fieldName) throws SQLException {
        this.smtm = conn.createStatement();
        try {
            ResultSet data = smtm.executeQuery(sql);
            while (data.next()) {
                String str = data.getString(fieldName);
                log.info("查询结果：" + str);
            }
        }catch (Exception erro){
            log.error("查询失败："+erro);
        }
    }



    void setControldata(String sql) throws SQLException {
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
        dba.setControldata("update user set name = 'bq-1589424711' where phone_number = '13333333333'");
        dba.dbClose();
    }
}




