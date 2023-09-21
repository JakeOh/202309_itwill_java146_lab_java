package com.itwill.inheritance01;

// 클래스: 속성(필드) + 생성자 + 기능(메서드) => 데이터 타입.
public class BasicTv {
    public static final int MIN_CHANNEL = 0;
    public static final int MAX_CHANNEL = 2;
    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 2;
    
    // 필드
    private boolean powerOn; // 전원이 켜져 있는 지(true), 꺼져 있는 지(false)를 저장하는 변수.
    private int channel; // 채널 번호를 저장.
    private int volume; // 음량을 저장.
    
    // 생성자
    public BasicTv() {}

    public BasicTv(boolean powerOn, int channel, int volume) {
        this.powerOn = powerOn;
        this.channel = channel;
        this.volume = volume;
    }

    // getters & setters
    public boolean isPowerOn() {
        return powerOn;
    }

    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    // 메서드 - TV의 기능들

    // 1. 전원 ON/OFF 기능
    public boolean powerOnOff() {
        // TODO: 켜져 있으면(powerOn == true), 전원을 false로 바꾸고
        // 꺼져 있으면(powerOn == false), 전원을 true로 바꾸고, 그 상태를 리턴.
        
        return powerOn;
    }
    
    // 2. 채널 값 1 증가
    public int channelUp() {
        // TODO
        return channel;
    }
    
    // 3. 채널 값 1 감소
    public int channelDown() {
        // TODO
        return channel;
    }
    
    // 4. 음량 크기 1 증가
    public int volumeUp() {
        // TODO
        return volume;
    }
    
    // 5. 음량 크기 1 감소
    public int volumeDown() {
        // TODO
        return volume;
    }
    
}
