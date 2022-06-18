package com.util;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import lombok.SneakyThrows;

import java.io.*;


public class re {
    Connection conn;
    private String ip;
    private String userName;
    private String userPwd;

    //字符编码默认是utf-8
    private static String DEFAULTCHART="UTF-8";

    private static final int TIME_OUT = 1000 * 5 * 60;

    public re(){}

    public re(String ip, String userName, String userPwd){
        this.ip = ip;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    /**
     * 远程登录linux
     * @return
     */
    public Boolean login(){

//        SSHClient sshClient = new SSHClient("服务器A ip", "username", "password");

        Boolean isAuthenticated = null;
        // 首先构造一个连接器，传入一个需要登陆的ip地址
        conn = new Connection("192.168.2.136");
        try {
            conn.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //它会返回一个布尔值，true 代表成功登陆目的服务器，否则登陆失败
        try {
            isAuthenticated = conn.authenticateWithPassword("phil", "ph");
            System.out.println(isAuthenticated+"isAuthenticated  ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isAuthenticated;
    }

    /**
     * 必须使用绝对路径
     * @param args
     */
    @SneakyThrows
    public static void main(String[] args)   {
        re r=new re();
        r.login();
        re rec=new re("192.168.2.136","phil","ph");
        String shpath="/home/phil/genius/ud710/userdebug.sh 710_N5Z1S1 T201 remake";
        Process ps = Runtime.getRuntime().exec(shpath);
        ps.waitFor();

        BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        String result = sb.toString();
        System.out.println(result);
    }

}










