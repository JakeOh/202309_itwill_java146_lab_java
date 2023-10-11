package com.itwill.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileMain07 {

    public static void main(String[] args) {
        // 쓰기(write), 읽기(read)를 하기 위한 파일 이름
        String file = "data/student_list.dat";
        
        // Student를 원소로 하는 ArrayList를 생성, 1_000_000개의 Student 객체를 저장.
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            Score score = new Score(i, i, i);
            Student student = new Student(i, "name_" + i, score);
            list.add(student);
        }
        
        // 파일에 ArrayList를 write.
        try (
                FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos);
        ) {
            oos.writeObject(list);
            System.out.println("파일 쓰기 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 파일에서 ArrayList를 read.
        try (
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
        ) {
            ArrayList<Student> students = (ArrayList<Student>) ois.readObject();
            System.out.println("size=" + students.size());
            System.out.println(students.get(10));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
