package com.company;

/**
 * Created by Student on 27.02.2018.
 */

public class IPv4 {
    public int ipv4[];

    IPv4(int ipv4[]) { // Если в конструктор передается готовый IP
        this.ipv4 = ipv4;
    }

    IPv4(String ipStr) throws Exception { //Если в конструктор передается строка
        char charIn;

        int dotNow = 0;
        int octNow = 0;
        int[] ipv4C = new int[4];
        if (ipStr.length() < 4) {
            int maskInt=0;
            String tmpMask="";
            for (int i = 0; i < ipStr.length(); i++) {
                charIn = ipStr.charAt(i);
                if (charIn == '/') continue;
                if (charIn != '0' && charIn != '1' && charIn != '2' && charIn != '3' && charIn != '4' && charIn != '5'
                        && charIn != '6' && charIn != '7' && charIn != '8' && charIn != '9' && charIn != '/')
                    throw new Exception("Неверный символ в IP адресе");
                tmpMask+=charIn;
            }
            maskInt = Integer.parseInt(tmpMask);
            ipv4=maskDecoder(maskInt);
        }
        else {


            for (int i = 0; i < ipStr.length(); i++) {
                charIn = ipStr.charAt(i);
                if (charIn != '0' && charIn != '1' && charIn != '2' && charIn != '3' && charIn != '4' && charIn != '5'
                        && charIn != '6' && charIn != '7' && charIn != '8' && charIn != '9' && charIn != '.')
                    throw new Exception("Неверный символ в IP адресе");
                try {
                    if (octNow < 3) {
                        if (charIn == '.') {
                            String tmpStr = "";
                            for (int j = dotNow; j < i; j++) {
                                tmpStr += ipStr.charAt(j);
                            }
                            dotNow = i + 1;
                            ipv4C[octNow] = Integer.parseInt(tmpStr);
                            octNow++;
                        }
                    } else {
                        String tmpStr = "";
                        for (int j = dotNow; j < ipStr.length(); j++) {
                            tmpStr += ipStr.charAt(j);
                        }

                        ipv4C[octNow] = Integer.parseInt(tmpStr);
                        break;

                    }
                } catch (Exception e) {
                    throw new Exception("Ошибка при ввода IP");

                }
                // if (octNow!=4) throw new Exception("Число октетов не равно 4!");
            }
            for (int i = 0; i < 4; i++) {
                if (ipv4C[i] > 255 || ipv4C[i] < 0) throw new Exception("Недопустимое значение октета! (0~255) ");
            }

            ipv4 = ipv4C;
        }

    }

    public String printDecBin() {
        String allStr = printIPDec();
        int countOfSpace = 15 - allStr.length() + 4;
        for (int i = 0; i < countOfSpace; i++) allStr += ' ';
        allStr += printIPBin();
        return allStr;
    }

    public String printIPBin() {
        String binStr = "";
        for (int i = 0; i < 4; i++) {
            if (i < 3) binStr += intToEightDigBin(ipv4[i]) + ".";
            else binStr += intToEightDigBin(ipv4[i]);
        }
        return binStr;
    }

    public String printIPDec() {
        String decStr = "";
        for (int i = 0; i < 4; i++) {
            if (i < 3) decStr += Integer.toString(ipv4[i]) + ".";
            else decStr += Integer.toString(ipv4[i]);
        }
        return decStr;
    }

    private String intToEightDigBin(int dec) {
        String octBinIn = Integer.toBinaryString(dec);
        String octBinOut = "";
        int countNull = 8 - octBinIn.length();
        for (int i = 0; i < countNull; i++) {
            octBinOut += "0";
        }
        octBinOut += octBinIn;
        return octBinOut;
    }

    public int[] maskDecoder(int mask) throws Exception {
        int ipv4[]={0,0,0,0};
        if (mask < 9) {
            String tempStr="";
            int bef, aft;
            bef = mask;//сколько единиц
            aft = 8 - mask;//Сколько нулей в первом октете
            for (int i=0;i<bef;i++) tempStr+="1";
            for (int i=0;i<aft;i++) tempStr+="0";
            ipv4[0]=Integer.parseInt(tempStr,2);
            return ipv4;
        }
        if (mask < 17) {
            ipv4[0]=255;
            String tempStr="";
            int bef, aft;
            bef =mask-8;//сколько единиц
            aft = 16 - mask;//Сколько нулей в первом октете
            for (int i=0;i<bef;i++) tempStr+="1";
            for (int i=0;i<aft;i++) tempStr+="0";
            ipv4[1]=Integer.parseInt(tempStr,2);
            return ipv4;
        }
        if (mask < 25) {
            ipv4[0]=ipv4[1]=255;
            String tempStr="";
            int bef, aft;
            bef =mask-16;//сколько единиц
            aft = 24 - mask;//Сколько нулей в первом октете
            for (int i=0;i<bef;i++) tempStr+="1";
            for (int i=0;i<aft;i++) tempStr+="0";
            ipv4[2]=Integer.parseInt(tempStr,2);
            return ipv4;
        }
        if (mask < 33) {
            ipv4[0]=ipv4[1]=ipv4[2]=255;
            String tempStr="";
            int bef, aft;
            bef =mask-24;//сколько единиц
            aft = 32 - mask;//Сколько нулей в первом октете
            for (int i=0;i<bef;i++) tempStr+="1";
            for (int i=0;i<aft;i++) tempStr+="0";
            ipv4[3]=Integer.parseInt(tempStr,2);
            return ipv4;
        }
        if (mask>32) throw new Exception("Неверное имя маски! (0~32)");

        return ipv4;

    }
}


