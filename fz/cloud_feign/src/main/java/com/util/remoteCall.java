package com.util;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import java.io.*;


public class remoteCall {
    Connection conn;
    private String ip;
    private String userName;
    private String userPwd;

    //字符编码默认是utf-8
    private static String DEFAULTCHART = "UTF-8";

    private static final int TIME_OUT = 1000 * 5 * 60;

    public remoteCall() {
    }

    public remoteCall(String ip, String userName, String userPwd) {
        this.ip = ip;
        this.userName = userName;
        this.userPwd = userPwd;
    }


    /**
     * 必须使用绝对路径
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        remoteCall r = new remoteCall();
        r.login();
        remoteCall rec = new remoteCall("192.168.2.136", "phil", "ph");
        // rec.execute("sh /home/phil/genius/ud710/userdebug.sh");  //userdebug.sh    user.sh
        //  rec.execute("cd /home/phil/genius/ud710 && ./ty.sh");
       // String ty = rec.execute("cd /home/phil/genius/ud710 && ./userdebug.sh 710_N5Z1S1 T201 remake");


        //rec.executeSuccess("cd /home/phil/genius/ud710 && ./ty.sh");
    }


    /**
     * 远程登录linux
     *
     * @return
     */
    public Boolean login() {

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
            System.out.println(isAuthenticated + "isAuthenticated  ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isAuthenticated;
    }

    /**
     * @param cmd 即将执行的命令
     * @return 命令执行完后返回的结果值
     * @author Ickes
     * 远程执行shll脚本或者命令
     * @since V0.1
     */
    public String execute(String cmd) throws IOException {

        System.out.println("开始执行脚本方法");
        String result = "";
        Session session = null;
        String charsetString = "utf-8";


        try {
            System.out.println("登录" + login() + "登录");
            int ret = -1;
            if (login()) {
                System.out.println("编译中的结果");
                session = conn.openSession();//打开一个会话
                System.out.println(session + "打开一个会话");

                session.execCommand(cmd);//执行命令

//                session.startShell();

                String   r=processStdout(session.getStderr(),DEFAULTCHART);
                System.out.println("错误的打印:"+r+"错误的打印:");

                String   b=processStdout(session.getStdout(),DEFAULTCHART);
                System.out.println("正确的打印"+b+"正确的打印");

                 session.getStdin();




            }
        } catch (IOException e) {
            System.out.println(e + "异常了");
            e.printStackTrace();
        } finally {
            conn.close();
            session.close();



        }

        return "`12";
    }


    /**
     * @param cmd 即将执行的命令
     * @return 命令执行成功后返回的结果值，如果命令执行失败，返回空字符串，不是null
     * @author Ickes
     * 远程执行shll脚本或者命令
     * @since V0.1
     */
    public String executeSuccess(String cmd) {
        String result = "";
        try {
            if (login()) {
                Session session = conn.openSession();//打开一个会话
                session.execCommand(cmd);//执行命令
                result = processStdout(session.getStdout(), DEFAULTCHART);
                conn.close();
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result + "数据");
        return result;
    }


    /**
     * 解析脚本执行返回的结果集
     *
     * @param in      输入流对象
     * @param charset 编码
     * @return 以纯文本的格式返回
     * @author Ickes
     * @since V0.1
     */
    private String processStdout(InputStream in, String charset) {
        InputStream stdout = new StreamGobbler(in);
        StringBuffer buffer = new StringBuffer();
        ;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout, charset));
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line + "\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}


