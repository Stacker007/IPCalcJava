package com.company;

/**
 * Created by Student on 28.02.2018.
 */
public class IPCalc {
    private int[] ip;
    private int[] mask;

    IPCalc(int[] ip, int[] mask) {
        this.ip = ip;
        this.mask = mask;
    }

    public IPv4 adress() {
        IPv4 net = new IPv4(ip);
        return net;
    }
    public IPv4 mask() {
        IPv4 net = new IPv4(mask);
        return net;
    }

    public IPv4 wildCard(){
        int[] wild = {0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            wild[i] = 255- mask[i];
        }
        IPv4 net = new IPv4(wild);
        return net;
    }
    public IPv4 broadcast(){
        ////////////////
        IPv4 net = new IPv4(wild);
        return net;
    }

    public IPv4 network() {
        int[] netWIP = {0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            netWIP[i] = ip[i] & mask[i];
        }
        IPv4 net = new IPv4(netWIP);
        return net;
    }
    /*public void createNet(){
        IPv4 netWorkEQ = new IPv4(network());
    }*/


}
