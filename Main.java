package com.company;

import java.io.*;

public class Main{

    public static void main(String[] args){

        int[] one = {192,168,0,1};
        int[] two = {192,168,200,111};

        IPv4 ohe = new IPv4(one);
        IPv4 tw = new IPv4(two);
        IPv4 three = new IPv4("192.168.12.111");

        System.out.println(ohe.printIPBin());
        System.out.println(ohe.printIPDec());
        System.out.println(ohe.printDecBin());
        System.out.println(tw.printDecBin());

        System.out.println(tw.printIPBin());
        System.out.println(tw.printIPDec());
        System.out.println(three.printDecBin());

        System.out.println(three.printIPBin());
        System.out.println(three.printIPDec());







    }

}
