package com.itwill.ver04.fileutil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.itwill.ver04.model.Contact;

// 도우미 클래스(helper class) - 파일 관련(read, write, 폴더 생성) 기능을 제공하는 클래스.
// 모든 필드와 메서드를 static으로 선언, 객체를 생성하지 못하도록 작성.
public class FileUtil {
    // 상수 정의
    public static final String DATA_DIR = "data"; // 데이터 파일을 저장하는 폴더 이름
    public static final String DATA_FILE = "contacts.dat"; // 데이터 파일 이름
    
    // private 생성자 -> 다른 클래스에서는 객체 생성할 수 없음.
    private FileUtil() {}
    
    /**
     * 연락처 데이터 파일을 저장하는 폴더가 만들어져 있지 않으면, 폴더를 새로 생성하고
     * File 객체를 리턴. 이미 폴더가 만들어져 있으면, 그 폴더의 File 객체를 리턴.
     * 
     * @return 데이터 파일을 저장하는 폴더의 File 객체.
     */
    public static File initDataDir() {
        File dir = new File(DATA_DIR);
        // TODO: 폴더가 없는 경우, 폴더를 만들기.
        
        return dir;
    }
    
    /**
     * 파일에 저장된 연락처 정보를 읽고, 그 결과를 List<Contact> 타입 객체로 리턴.
     * 
     * @return 연락처들의 리스트.
     */
    public static List<Contact> readDataFromFile() {
        List<Contact> list = null;
        
//        String file = DATA_DIR + File.separator + DATA_FILE; //-> "data/contacts.dat"
        File file = new File(DATA_DIR, DATA_FILE); //-> data/contacts.dat 파일 객체
        
        // TODO: 파일을 읽어서 List<Contact>를 생성.
        
        return list;
    }
    
    /**
     * 연락처들의 리스트를 파일에 쓰기.
     * 
     * @param list 파일에 쓸 연락처 리스트.
     */
    public static void writeDataToFile(List<Contact> list) {
        File file = new File(DATA_DIR, DATA_FILE);
        
        // TODO: list를 file에 write
    }
    
    /**
     * 연락처 파일이 있으면, 파일의 내용을 읽어서 리스트를 생성하고 리턴.
     * 연락처 파일이 없으면, 빈 리스트를 리턴.
     * 
     * @return 연락처(Contact)를 원소로 갖는 리스트.
     */
    public static List<Contact> initData() {
        File file = new File(DATA_DIR, DATA_FILE);
        
        List<Contact> list = new ArrayList<>();
        if (file.exists()) { // 데이터 파일이 만들어져 있으면
            list = readDataFromFile();
        }
        
        return list;
    }

}
