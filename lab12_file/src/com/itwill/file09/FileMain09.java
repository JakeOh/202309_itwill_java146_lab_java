package com.itwill.file09;

import java.io.File;

/*
 * 파일, 폴더(디렉토리) 관리 - 정보, 생성, 삭제.
 * 
 * 현재 작업 디렉토리(CWD): 현재 프로그램(프로세스)가 실행되는 디렉토리 위치.
 * - 이클립스에서 자바 프로그램을 실행(Run as Java application)할 때, 작업 디렉토리 위치는 프로젝트 폴더.
 * 
 * 절대 경로(absolute path):
 * - 시스템의 루트(C:\, D:\, ...)부터 파일 또는 폴더가 있는 위치까지를 찾아가는 방식.
 * - (Windows 예) C:\workspace\lab_java\lab12_file\data\ansi.txt
 * - (MacOS, Linux 예) /users/itwill/documents/ansi.txt
 * 
 * 상대 경로(relative path):
 * - 현재 작업 디렉토리(CWD, current working directory)를 기준으로 파일 또는 폴더 위치를 찾아가는 방식.
 * - (Windows 예) data\ansi.txt
 * - (MacOS, Linux 예) data/ansi.txt
 * - 현재 디렉토리: .  (예) ./data/ansi.txt
 * - 상위 디렉토리: .. (예) ../src/com/itwill, ../bin, ../data
 * 
 * 파일 구분자(file separator):
 * - 상위 폴더와 하위 폴더, 폴더와 파일을 구분하기 위한 기호(문자).
 * - MS Windows: \(backslash)
 * - MS Windows를 제외한 다른 OS: /(slash)
 * - 문자열("") 안에서 백슬래쉬는 특별한 의미(escape 문자)
 *   - "\n": new line
 *   - "\t": tab
 *   - "\\": backslash
 * - MS Windows에서 경로를 문자열로 표현: "data\\ansi.txt"
 * - 다른 OS에서 경로를 문자열로 표현: "data/ansi.txt"
 * 
 */

public class FileMain09 {

    public static void main(String[] args) {
        // Java Runtime이 프로그램을 실행하고 있는 현재 디렉토리
        String cwd = System.getProperty("user.dir");
        System.out.println(cwd);
        
        String path = "C:\\workspace\\lab_java\\lab12_file"; // Windows에서 절대 경로
        System.out.println(path);
        
        String path2 = "data\\ansi.txt"; // Windows에서 상대 경로
        // 현재는 OS 구분없이 "data/ansi.txt" 표현해도 됨.
        System.out.println(path2);
        
        String path3 = "data" + File.separator + "ansi.txt";
        System.out.println(path3);
        
        // File 클래스: 
        // 파일(txt, jpg, mp4, pptx, ...)과 폴더(디렉토리)에 관련된 기능들을 가지고 있는 클래스.
        // File 객체 생성 - 파일(파일&폴더)을 관리하는 객체 생성.
        File f = new File(path3);
        System.out.println(f); // File 클래스는 toString 메서드를 재정의.
        System.out.println("경로: " + f.getPath());
        //-> File 객체를 생성할 때 상대경로로 생성한 경우에는, getPath()는 상대경로를 리턴.
        //-> File 객체를 생성할 때 절대경로로 생성한 경우에는, getPath()는 절대경로를 리턴.
        System.out.println("절대경로: " + f.getAbsolutePath());
        System.out.println("생성 여부: " + f.exists());
        System.out.println("파일 여부: " + f.isFile());
        System.out.println("폴더 여부: " + f.isDirectory());
        System.out.println("파일 크기: " + f.length() + "B");

        // 새 폴더 만들기
        File newFolder = new File("data", "test"); // new File(상위폴더, 하위폴더/파일)
        if (newFolder.exists()) {
            System.out.println("폴더가 이미 존재합니다...");
        } else {
            newFolder.mkdir(); // make directory
            System.out.println("폴더 생성 성공");
        }
        
        // 폴더 삭제하기
        if (newFolder.exists()) {
            newFolder.delete();
            System.out.println("폴더 삭제 성공");
        } else {
            System.out.println("삭제할 폴더가 없습니다!");
        }
        
    }

}
