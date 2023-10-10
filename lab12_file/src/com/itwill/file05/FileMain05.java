package com.itwill.file05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 프로그램 ===> ObjectOutputStream ===> FileOutputStream ===> 파일
 *   ObjectOutputStream.writeObject(): 자바 객체를 파일에 쓸 수 있는 형태로 변환(직렬화, serialization)
 * 
 * 프로그램 <=== ObjectInputStream <=== FileInputStream <=== 파일
 *   ObjectInputStream.readObject(): 파일에서 읽은 데이터를 자바 객체로 변환(역직렬화, de-serialization)
 *
 * OIS, OOS에서 읽고 쓸 수 있는 자바 클래스는 반드시 Serializable 인터페이스를 구현해야 함!
 */

public class FileMain05 {

    public static void main(String[] args) {
        // 자바 객체를 파일에 쓰고 읽기:
        String file = "data/product.dat";
        
        // (1) 파일 쓰기
        try (
                // 리소스 생성
                FileOutputStream out = new FileOutputStream(file);
                ObjectOutputStream oout = new ObjectOutputStream(out);
        ) {
            // 파일에 쓸 Product 객체 생성.
            Product p = new Product(1, "노트북", 10_000);
            
            // 자바 객체를 write.
            oout.writeObject(p);
            
            System.out.println("파일 작성 성공");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // (2) 파일 읽기
        FileInputStream in = null;
        ObjectInputStream oin = null;
        try {
            in = new FileInputStream(file);
            oin = new ObjectInputStream(in);
            
            Product prod = (Product) oin.readObject();
            System.out.println(prod);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
