package com.itwill.file01;

import java.io.FileInputStream;
import java.io.FileOutputStream;

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
        String fileName = "data/hello.txt"; // 읽을 파일 경로, 이름.
        String copyFile = "data/hello_copy.txt"; // 복사할 파일 경로, 이름.
        
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            // 1. FIS 객체 생성.
            in = new FileInputStream(fileName);
            
            // 1. FOS 객체 생성.
            out = new FileOutputStream(copyFile);
            
            while (true) {
                // 2. read 메서드 사용.
                int read = in.read();
                if (read == -1) { // 파일 끝(EOF, end-of-file)에 도달하면
                    break;
                }
                // System.out.println((char) read);
                
                // 2. FOS의 write 메서드 사용.
                out.write(read);
            }
            
            System.out.println("파일 복사 성공");
            
        } catch (Exception e) {
            e.printStackTrace(); // 예외 이름, 메시지, 발생 위치를 출력.
        } finally {
            try {
                in.close(); // 3. FIS 객체를 닫음.
                out.close(); // 3. FOS 객체를 닫음.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
