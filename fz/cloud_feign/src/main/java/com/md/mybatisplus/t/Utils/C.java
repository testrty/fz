package com.md.mybatisplus.t.Utils;

public class C {
    public static void main(String[] args) {

        String ac = "1，12，7，8，98";
        String[] t = ac.split(",");
        System.out.println(t);
        int i;
        for (i = 0; i < t.length; i++) {
            System.out.println(t[i]);

            int result1 = t[i].indexOf("122");
            System.out.println(result1);
        }



    }
}
