package com.itwill.file04;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * InputStream, OutputStream과 같은 클래스 객체들은 사용한 이후에 반드시 close() 메서드를 호출해서
 * 사용했던 리소스들을 해제해야 함.
 * try-catch-finally 구문에서는,
 * 리소스 생성은 try 블록에서 하고, 리소스 해제는 finally 블록에서 작성.
 * 리소스를 생성하면 자동으로 close() 메서드를 호출해 주는 try-with-resource 문법이 생김.
 * 
 * try (리소스 생성;) {
 *     정상적인 상황에서 실행할 코드 블록;
 * } catch (예외 타입 변수 선언) {
 *     예외 상황을 처리하는 코드 블록;
 * }
 */

public class FileMain04 {

    public static void main(String[] args) {
        // try-with-resource 구문
        
        String origin = "data/hello.txt";
        String dest = "data/hello_copy3.txt";
        
        try (
            FileInputStream in = new FileInputStream(origin);
            FileOutputStream out = new FileOutputStream(dest);
            //-> try ()에서 선언된 변수들의 close는 자동으로 호출됨.
        ) {
            while (true) {
                int read = in.read();
                if (read == -1) {
                    break;
                }
                
                out.write(read);
            }
            System.out.println(dest + " 파일 복사 성공");
            
        } catch (Exception e) {
            
        }

    }

}
