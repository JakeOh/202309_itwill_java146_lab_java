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
    /**
     * TV 전원 ON/OFF 기능. 켜져 있으면(true) 끄고, 꺼져 있으면(false) 킴.
     * 
     * @return 전원 ON이면 true, 전원 OFF이면 false.
     */
    public boolean powerOnOff() {
        // TODO: 켜져 있으면(powerOn == true), 전원을 false로 바꾸고
        // 꺼져 있으면(powerOn == false), 전원을 true로 바꾸고, 그 상태를 리턴.
        
        return powerOn;
    }
    
    // 2. 채널 값 1 증가
    /**
     * 현재 채널 값을 1 증가시킴.
     * 만약 현재 채널이 최댓값(MAX_CHANNEL)에 도달한 경우에는 
     * 채널의 최솟값(MIN_CHANNEL)으로 변경.
     * 
     * @return 바뀐 채널 값.
     */
    public int channelUp() {
        // TODO
        return channel;
    }
    
    // 3. 채널 값 1 감소
    /**
     * 현재 채널 값을 1 감소시킴.
     * 만약 현재 채널이 최솟값(MIN_CHANNEL)에 도달한 경우에는 
     * 채널의 최댓값(MAX_CHANNEL)으로 변경.
     * 
     * @return 바뀐 채널 값.
     */
    public int channelDown() {
        // TODO
        return channel;
    }
    
    // 4. 음량 크기 1 증가
    /**
     * 현재 음량을 1 증가시킴.
     * 만약 현재 음량이 최댓값(MAX_VOLUME)에 도달한 경우에는 음량을 변경하지 않음.
     * 
     * @return 바뀐 음량.
     */
    public int volumeUp() {
        // TODO
        return volume;
    }
    
    // 5. 음량 크기 1 감소
    /**
     * 현재 음량을 1 감소시킴.
     * 만약 현재 음량이 최솟값(MIN_VOLUME)에 도달한 경우에는 음량을 변경하지 않음.
     * 
     * @return 바뀐 음량.
     */
    public int volumeDown() {
        // TODO
        return volume;
    }
    
}
