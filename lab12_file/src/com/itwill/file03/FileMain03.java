package com.itwill.file03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 파일 ===> FileInputStream ===> BufferedInputStream ===> 프로그램
 *   FIS: 하드디스크에 있는 파일을 직접 접근해서 데이터를 읽고 메모리(RAM)에 적재.
 *   BIS: 메모리(RAM)에 있는 파일 내용을 읽는 메서드(read)를 제공.
 * 
 * 파일 <=== FileOutputStream <=== BufferedOutputStream <=== 프로그램
 *   FOS: 하드디스크의 파일에 데이터를 씀.
 *   BOS: 메모리(RAM)에 데이터를 쓰는 메서드 메서드(write)를 제공.
 */

public class FileMain03 {

    public static void main(String[] args) {
        // BIS, BOS을 사용한 파일 읽기, 쓰기:
        
        String origin = "data/ratings.dat";
        String dest = "data/ratings_copy2.dat";
        
        FileInputStream in = null;
        BufferedInputStream bin = null;
        FileOutputStream out = null;
        BufferedOutputStream bout = null;
        try {
            in = new FileInputStream(origin); // 파일에서 메모리까지의 읽기 통로.
            bin = new BufferedInputStream(in); // 메모리에서 프로그램까지의 읽기 통로.
//            bin = new BufferedInputStream(new FileInputStream(origin));
            
            out = new FileOutputStream(dest); // 메모리에서 파일까지의 쓰기 통로.
            bout = new BufferedOutputStream(out); // 프로그램에서 메모리까지의 쓰기 통로.
//            bout = new BufferedOutputStream(new FileOutputStream(dest));
            
            long start = System.currentTimeMillis(); // 복사 시작 시간.
            
            while (true) {
                byte[] buf = new byte[4 * 1024]; // 4KB 바이트 배열
                int len = bin.read(buf); // RAM(메모리)에서 4KB씩 읽음.
                if (len == -1) { // 파일 끝(EOF)
                    break;
                }
                
                bout.write(buf, 0, len); // RAM(메모리)에 바이트 배열의 내용을 씀.
            }
            
            long end = System.currentTimeMillis(); // 복사 종료 시간.
            System.out.println("복사 시간: " + (end - start) + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Stream 객체를 닫을(close) 때에는, 객체가 생성된 순서의 반대로 close 메서드를 호출.
                // BIS.close() -> FIS.close(); BOS.close() -> FOS.close();
                // 가장 마지막에 생성된 Stream 객체만 닫으면(close), 
                // 그 스트림 객체가 사용하던 다른 스트림 객체들은 자동으로 close 메서드가 호출됨.
                bin.close();
                bout.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
