package com.itwill.method06;

import java.util.Random;

public class MethodMain06 {

    public static void main(String[] args) {
        // 메서드 작성 연습:
        
        Random random = new Random();
        
        // Ex 1.
        int genderCode = random.nextInt(5); // [0, 5) 범위의 정수 난수를 저장.
        System.out.println("genderCode = " + genderCode);
        
        // parseGenderCode()는 아규먼트가 1 또는 3이면 "male" 리턴,
        // 2 또는 4 이면 "female" 리턴, 그 이외의 숫자인 경우에는 "unknown" 리턴.
        String gender = parseGenderCode(genderCode);
        System.out.println("gender = " + gender);
        
        // Ex 2.
        int number = random.nextInt(100); // [0, 100) 범위의 난수를 저장.
        System.out.println("number = " + number);
        
        // isEven(정수): 정수가 짝수이면 true, 그렇지 않으면 false를 리턴.
        boolean result = isEven(number);
        System.out.println("result = " + result);

        // Ex 3. 
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        System.out.println("x=" + x + ", y=" + y);
        
        // whoIsBigger(x, y): x, y 중에서 더 큰 수를 리턴.
        int bigger = whoIsBigger(x, y);
        System.out.println("bigger = " + bigger);
        
    }
    
    public static int whoIsBigger(int x, int y) {
//        return (x > y) ? x : y;
        
//        if (x > y) {
//            return x;
//        } else {
//            return y;
//        }
        
        int result = 0;
        if (x > y) {
            result = x;
        } else {
            result = y;
        }
        
        return result;
    }
    
    public static boolean isEven(int n) {
//        return (n % 2 == 0) ? true : false;
        
//        if (n % 2 == 0) {
//            return true;
//        } else {
//            return false;
//        }
        
        boolean result = false;
        if (n % 2 == 0) {
            result = true;
        }
        
        return result;
    }

    public static String parseGenderCode(int code) {
        String gender = "";
        
//        if (code == 1 || code == 3) {
//            gender = "male";
//        } else if (code == 2 || code == 4) {
//            gender = "female";
//        } else {
//            gender = "unknown";
//        }
        
        switch (code) {
        case 1:
        case 3:
            gender = "male";
            break;
        case 2:
        case 4:
            gender = "female";
            break;
        default:
            gender = "unknown";
        }
        
        return gender;
    }
    
}
