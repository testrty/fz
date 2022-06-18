package com.util;

import java.io.*;

public class qwe {

    public static void main(String[] args) throws IOException {
      qwe.readFileByLine("1");
    }


    /**
     * 按行读取文件
     *
     * @param strFile
     */
    public static void readFileByLine(String strFile) {
        try {
//            File file = new File(strFile);

            String directory = "aaaaaaaaaa";
            String fileName = "myFile.txt";
            File file = new File(directory,fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String strLine = null;
            int lineCount = 1;
            while (null != (strLine = bufferedReader.readLine())) {
               // System.out.println();
                //System.out.println("di[" + lineCount + "]hang count:[" + strLine + "]");
                lineCount++;
            }

            System.out.println(strLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}