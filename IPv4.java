package com.company;

/**
 * Created by Student on 27.02.2018.
 */
public class IPv4 {
    int ipv4[];

    IPv4(int ipv4[]) { // Если в конструктор передается готовый IP
        this.ipv4 = ipv4;
    }

    IPv4(String ipStr) { //Если в конструктор передается строка
        char charIn;
        String tmpStr = "";
        int dotNow = 0;
        int octNow = 0;

        for (int i = 0; i < ipStr.length(); i++) {
            charIn = ipStr.charAt(i);
            //if (octNow>3) throw new Exception("Число октетов больше 4!");
            //if (charIn > '0' & charIn < 9 & charIn != '.') throw new Exception("Неверный символ в IP адресе");
            if (charIn == '.') {
                for (int j = dotNow; j < i; j++) {
                    tmpStr += ipStr.charAt(j);
                }
                dotNow = i + 1;
                ipv4[octNow] = Byte.parseByte(tmpStr);
                octNow++;
            }

        }


    }

    public String printDecBin() {
        String allStr = printIPDec();
        int countOfSpace = 15 - allStr.length()+5;
        for (int i = 0; i < countOfSpace; i++) allStr += ' ';
        allStr += printIPBin();
        return allStr;
    }

    public String printIPBin() {
        String decStr = "";
        for (int i = 0; i < 4; i++) {
            if (i < 3) decStr += intToEightDigBin(ipv4[i]) + ".";
            else decStr += intToEightDigBin(ipv4[i]);
        }
        return decStr;
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


}
