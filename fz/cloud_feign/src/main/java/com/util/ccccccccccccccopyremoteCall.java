package com.util;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.*;


public class ccccccccccccccopyremoteCall {
    Connection conn;
    private String ip;
    private String userName;
    private String userPwd;

    //字符编码默认是utf-8
    private static String DEFAULTCHART = "UTF-8";

    private static final int TIME_OUT = 1000 * 5 * 60;

    public ccccccccccccccopyremoteCall() {
    }

    public ccccccccccccccopyremoteCall(String ip, String userName, String userPwd) {
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
        ccccccccccccccopyremoteCall r = new ccccccccccccccopyremoteCall();
        r.login();
        ccccccccccccccopyremoteCall rec = new ccccccccccccccopyremoteCall("192.168.2.136", "phil", "ph");
        // rec.execute("sh /home/phil/genius/ud710/userdebug.sh");  //userdebug.sh    user.sh
        //  rec.execute("cd /home/phil/genius/ud710 && ./ty.sh");
        String ty = rec.execute("cd /home/phil/genius/ud710 && ./userdebug.sh 710_N5Z1S1 T201 remake");


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
        BufferedReader bufferedReader = null;
        String charsetString = "utf-8";

        // 接收执行脚本错误时返回的信息
        BufferedReader errBufferedReader = null;

        StringBuffer sb = new StringBuffer();

        try {
            System.out.println("登录" + login() + "登录");
            int ret = -1;
            if (login()) {
                System.out.println("编译中的结果");
                session = conn.openSession();//打开一个会话
                System.out.println(session + "打开一个会话");
                session.execCommand(cmd);//执行命令
                session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);

//                // 获取执行命令输出的信息
//                InputStream stdout = session.getStdout();
//                // 获取执行命令出现的错误信息
//                InputStream stderr = session.getStderr();
//                bufferedReader = new BufferedReader(
//                        new InputStreamReader(stdout, charsetString));
//                // 接收读取到的返回信息
//                String returnMessage = null;
//                while ((returnMessage = bufferedReader.readLine()) != null) {
//                    System.out.println("1111111" + returnMessage);
//                    sb.append(returnMessage);
//                    System.out.println(sb+"SBYONGH 用户");
//                }


//                errBufferedReader = new BufferedReader(
//                        new InputStreamReader(stderr, charsetString));
//                while ((returnMessage = errBufferedReader.readLine()) != null) {
//                    System.out.println("222222" + returnMessage);
//                }


                System.out.println("出来了");
                //  ret = session.getExitStatus(); //得到脚本运行成功与否的标志 ：0 成功,非0 失败
                // System.out.println(ret+"状态 状态");

//                result=processStdout(session.getStdout(),DEFAULTCHART);
//                System.out.println(result+"编译中的结果");
//                //如果为得到标准输出为空，说明脚本执行出错了
//                if(StringUtils.isBlank(result)){
//                    result=processStdout(session.getStderr(),DEFAULTCHART);
//                    System.out.println(result+"结果");
//                }
//                System.out.println("返回结果"+result+"结果");

            }
        } catch (IOException e) {
            System.out.println(e + "异常了");
            e.printStackTrace();
        } finally {
            conn.close();
            session.close();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (errBufferedReader != null) {
                errBufferedReader.close();
            }
//            if (connection != null) {
//                connection.close();
//            }

        }
        System.out.println("废品" + sb + " 垃圾");
        return String.valueOf(sb);
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


