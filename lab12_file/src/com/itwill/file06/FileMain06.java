package com.itwill.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.itwill.file05.Product;

public class FileMain06 {

    public static void main(String[] args) {
        // 1) com.itwill.file05.Product 타입 객체 1,000,000개를 저장하는 ArrayList를 파일에 write:
        // FileOutputStream, BufferedOutputStream, ObjectOutputStream 사용.
        // ArrayList를 파일에 쓰는 시간을 측정하고 출력.
        
        // 파일에 쓸 상품 리스트 준비.
        ArrayList<Product> list = new ArrayList<>(); // 빈 리스트
        for (int i = 0; i < 1_000_000; i++) {
            Product p = new Product(i, "name_" + i, i);
            list.add(p);
        }
        
        // 저장할 파일 이름
        String file = "data/product_list.dat";
        
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);
            
            long start = System.currentTimeMillis();
            oos.writeObject(list);
            long end = System.currentTimeMillis();
            System.out.println("파일 작성 시간: " + (end - start) + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        // 2) 1)에서 작성된 파일에서 ArrayList를 읽고, 내용 확인:
        // FileInputStream, BufferedInputStream, ObjectInputStream 사용.
        // ArrayList를 파일에서 읽는 시간을 측정하고 출력.
        try (
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
        ) {
            long start = System.currentTimeMillis();
            ArrayList<Product> products = (ArrayList<Product>) ois.readObject();
            long end = System.currentTimeMillis();
            System.out.println("파일 읽기 시간: " + (end - start) + "ms");
            
            System.out.println("리스트 원소 개수: " + products.size()); //-> 1,000,000
            System.out.println(products.get(0)); //-> id=0
            System.out.println(products.get(100)); //-> id=100
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
