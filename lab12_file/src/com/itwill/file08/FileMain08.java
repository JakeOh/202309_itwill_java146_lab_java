package com.itwill.file08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/*
 * IO Stream: 바이트 스트림(byte stream). 읽기/쓰기의 기본 단위는 byte 단위.
 * - 모든 종류의 파일(txt, jpg, mp4, pptx, ...)에서 사용 가능.
 * InputStream
 * |__ FileInputStream, BufferedInputStream, ObjectInputStream, ...
 * OutputStream
 * |__ FileOutputStream, BufferedOutputStream, ObjectOutputStream, ...
 * 
 * Reader/Writer: 문자 스트림(character stream). 읽기/쓰기의 기본 단위는 "문자(character)" 단위.
 * - 텍스트 파일(txt, csv, ...)에서만 사용.
 * Reader
 * |__ InputStreamReader, BufferedReader
 *     |__ FileReader
 * Writer
 * |__ OutputStreamWriter, BufferedWriter
 *     |__ FileWriter
 *     
 * 인코딩(encoding): 문자를 그 문자에 해당하는 코드(정수)로 변환. (예) 'A' -> 65
 * 디코딩(decoding): 문자 코드(정수)를 그 코드에 해당하는 문자로 변환. (예) 65 -> 'A'
 * 운영체제(OS)의 기본 인코딩 방식:
 *   - 한글 MS Windows: EUC-KR(MS949, CP949), 영문 MS Windows: CP1252, ...
 *   - MacOS, Linux, Unix, ...: UTF-8
 */

public class FileMain08 {

    public static void main(String[] args) {
        // 파일 이름
        String ansiFile = "data/ansi.txt";
        String utf8File = "data/utf8.txt";
        
        // Java 11 버전 이전에서 문자 스트림과 인코딩을 다루는 방법:
        // FileReader, FileWriter 클래스는 인코딩 설정 방법이 없음.
        try (
                // 1. FileInputStream (바이트 스트림) 생성
                FileInputStream fis = new FileInputStream(ansiFile);
                // 2. 인코딩을 설정한 InputStreamReader (문자 스트림) 생성
                InputStreamReader isr = new InputStreamReader(fis, "EUC-KR");
                // 3. 읽기 속도를 빠르게 하기 위해서 BufferedReader (문자 스트림) 생성
                BufferedReader br = new BufferedReader(isr);
        ) {
            while (true) {
                int read = br.read(); // 1글자씩 읽음.
                if (read == -1) { // 끝까지 다 읽었으면
                    break;
                }
                System.out.print((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        
        // Java 11 버전부터 FileReader, FileWriter 객체에서 인코딩 방식을 설정할 수 있게 됨.
        try (
                // 1. FileReader 객체를 생성할 때 인코딩 방식을 설정.
                FileReader reader = new FileReader(utf8File, Charset.forName("UTF-8"));
                // 2. 읽기 속도를 빠르게 하기 위해서 BufferedReader 객체를 생성.
                BufferedReader br = new BufferedReader(reader);
        ) {
//            while (true) {
//                int read = br.read();
//                if (read == -1) {
//                    break;
//                }
//                System.out.print((char) read);
//            }
            
            while (true) {
                String line = br.readLine();
                if (line == null) { // EOF(end-of-file, 파일 끝)
                    break;
                }
                System.out.println(line);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
