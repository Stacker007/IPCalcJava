package com.company;

import java.util.Scanner;

/**
 * Created by Student on 28.02.2018.
 */
public class PrintNet {

   public static void letPrint(){
       System.out.println("Введите IP адрес: ");

       Scanner in = new Scanner(System.in);
       String ipString = in.nextLine();
       System.out.println("Введите маску: ");
       String maskStr = in.nextLine();
       try {
           IPv4 three = new IPv4(ipString);
           IPv4 mask = new IPv4(maskStr);

           IPCalc net1 = new IPCalc(three.ipv4,mask.ipv4);
           System.out.println("Adress:  " + net1.adress().printDecBin());
           System.out.println("Netmask: " + net1.mask().printDecBin());
           System.out.println("Wildcard:" + net1.wildCard().printDecBin());
           System.out.println("Network: " + net1.network().printDecBin());

       }catch (Exception e){
           System.out.println(e.getMessage());
       }
   }

}
