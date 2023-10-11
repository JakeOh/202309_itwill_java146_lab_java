package com.itwill.file09;

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
 */

public class FileMain09 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
