package com.itwill.file02;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileMain02 {

    public static void main(String[] args) {
        // 대용량 파일 복사:
        // data/ratings.dat 파일을 읽고, data/ratings_copy.dat 파릴에 복사.
        // (1) read(), write(int b) 사용할 때 시간 측정.
        // (2) read(byte[] b), write(byte[] b, int off, int len) 사용할 때 시간 측정.
        
        String origin = "data/ratings.dat"; // 원본 파일 경로, 이름.
        String dest = "data/ratings_copy.dat"; // 복사할 파일 경로, 이름.
        
        FileInputStream in = null; // 파일 읽기 통로.
        FileOutputStream out = null; // 파일 쓰기 통로.
        try {
            in = new FileInputStream(origin);
            out = new FileOutputStream(dest);
            
            long start = System.currentTimeMillis(); // 파일 복사 시작 시간
            
            while (true) {
//                int read = in.read(); // (1) 파일에서 1바이트를 읽음.
                
                byte[] buffer = new byte[4 * 1024]; // 4KB = 4,096 Bytes
                int read = in.read(buffer); // (2) 파일에서 4KB씩 읽음.
                // buffer: 파일에서 읽은 내용을 저장하기 위한 바이트 배열.
                // 리턴 값: 파일에서 실제로 읽은 바이트 수.
                
                if (read == -1) { // EOF(파일 끝)
                    break;
                }
                
//                out.write(read); // (1) 파일에 1바이트를 씀.
                
//                out.write(buffer); // (2) 파일에 4KB씩 씀.
                out.write(buffer, 0, read);
                // write(byte[] b, int off, int len)
                // b: 파일에 쓸 데이터를 가지고 있는 바이트 배열.
                // off: 배열 b에서 읽기 시작할 인덱스.
                // len: 파일에 쓸 바이트 수.
            }
            
            long end = System.currentTimeMillis(); // 파일 복사 종료 시간.
            long elapsed = end - start; // 복사할 때 경과된 시간.
            System.out.println("복사 시간: " + elapsed + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
