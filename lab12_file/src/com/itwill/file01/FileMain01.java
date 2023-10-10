package com.itwill.file01;

/*
 * 입/출력 스트림(Input/Output Stream): 프로그램에서 값을 입력받거나 출력하는 통로.
 *   (예) System.in: 입력 스트림 객체, System.out: 출력 스트림 객체.
 * 프로그램 <=== InputStream <=== 입력장치(키보드, 마우스, 터치스크린, 파일, ...)
 * 프로그램 ===> OutputStream ===> 출력장치(모니터, 프린터, 프로젝터, 파일, ...)
 * 
 * 프로그램 <=== FileInputStream <=== 파일
 * 프로그램 ===> FileOutputStream ===> 파일
 * 
 * java.io.InputStream: 프로그램이 데이터를 읽어오는 통로.
 * |__ FileInputStream: 프로그램이 파일에서 데이터를 읽어오는 통로.
 *   1. FileInputStream 객체 생성.
 *   2. FIS 객체의 read 관련 메서드를 사용.
 *   3. FIS 객체를 close.
 *   
 * java.io.OutputStream: 프로그램에서 데이터를 쓰는(write) 통로.
 * |__ FileOutputStream: 프로그램에서 파일에 데이터를 쓰는 통로.
 *   1. FileOutputStream 객체 생성.
 *   2. FOS 객체의 write 관련 메서드를 사용.
 *   3. FOS 객체를 close.
 */

public class FileMain01 {
    
    public static void main(String[] args) {
        
    }
    
}
