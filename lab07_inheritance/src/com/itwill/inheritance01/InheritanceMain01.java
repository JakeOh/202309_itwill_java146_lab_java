package com.itwill.inheritance01;

public class InheritanceMain01 {

    public static void main(String[] args) {
        // BasicTv 타입의 객체 생성
        BasicTv tv1 = new BasicTv();
        System.out.println(tv1.toString());
        
        tv1.powerOnOff();
        tv1.channelUp();
        tv1.channelUp();
        tv1.channelUp();
        
        tv1.channelDown();
        tv1.channelDown();
        
        tv1.volumeUp();
        tv1.volumeUp();
        tv1.volumeUp();
        
        tv1.volumeDown();
        tv1.volumeDown();
        tv1.volumeDown();
        
        tv1.powerOnOff();
        
        // SmartTv 타입의 객체 생성
        SmartTv tv2 = new SmartTv();
        tv2.powerOnOff();
        
    }

}
