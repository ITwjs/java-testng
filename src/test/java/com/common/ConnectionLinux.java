package com.common;


import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class ConnectionLinux {
    private String host = "192.168.3.236";
    private String user = "frog";
    private int port = 22;
    private String password = "shuqinkeji";
    private String Code = "";
    private String commond = "";

    public String ConnectionLinux(String command) throws JSchException, IOException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, port);
        session.setConfig("StrictHostKeyChecking", "no");
        //    java.util.Properties config = new java.util.Properties();
        //   config.put("StrictHostKeyChecking", "no");
        session.setPassword(password);
        session.connect();
        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
        InputStream in = channelExec.getInputStream();
        channelExec.setCommand(command);
        channelExec.setErrStream(System.err);
        channelExec.connect();
        String out = IOUtils.toString(in, "UTF-8");
        channelExec.disconnect();
        session.disconnect();
        return out;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public String getCode() {
        return Code;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCode(String Commond) throws IOException, JSchException {
        this.commond = Commond;
        String str = ConnectionLinux(commond);
        this.Code = str.substring(str.length()-9,str.length()).substring(0,4);
    }

    public void deletePngDate(String Commond) throws IOException, JSchException {
        this.commond = Commond;
        this.Code = ConnectionLinux(commond);

    }

    public static void main(String[] args) throws IOException, JSchException {
        ConnectionLinux connectionLinux = new ConnectionLinux();
//        connectionLinux.deletePngDate("ls -lt /var/backend/current/public/captcha/*.jpg");
        connectionLinux.setCode("ls -lt /var/backend/current/public/captcha/*.jpg");
        String code = connectionLinux.getCode();
        System.out.println(code);
    }
}