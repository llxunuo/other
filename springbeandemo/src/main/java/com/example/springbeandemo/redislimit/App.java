package com.example.springbeandemo.redislimit;

public class App {
    private static String arr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static int a = 0;

    public static void main(String[] args) {
        int b = 0;
        while(b < 1000000) {
            System.out.println(getCurrNo());
            b++;
        }
//        String str = "0000";
//        for(int i = 0;i<1000;i++) {
//            a = arr.indexOf(str.charAt(0)) * 238328 + arr.indexOf(str.charAt(1)) * 3844 + arr.indexOf(str.charAt(2)) * 62 + arr.indexOf(str.charAt(3));
//            System.out.println(a);
//            System.out.println(str=getCurrNo(a));
//            a++;
//        }
    }

    private synchronized static String getCurrNo(int a) {
        int z = arr.length();
        int i = a % z ;
        int j = (a / z) % z ;
        int k = (a / z / z) % z ;
        int m = (a / z / z / z) % z ;
        return "" + arr.charAt(m) + arr.charAt(k) + arr.charAt(j) + arr.charAt(i);
    }
    private synchronized static String getCurrNo() {
        int z = arr.length();
        int i = a % z ;
        int j = (a / z) % z ;
        int k = (a / z / z) % z ;
        int m = (a / z / z / z) % z ;
        a++;
        return "" + arr.charAt(m) + arr.charAt(k) + arr.charAt(j) + arr.charAt(i);
    }
}
