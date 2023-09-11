package com.itwill.condition07;

import java.util.Random; // 난수를 생성할 수 있는 타입.
import java.util.Scanner; // 입력을 받을 수 있는 타입.

public class RpsMain {

    public static void main(String[] args) {
        // 가위바위보 게임:
        // 가위 - 0, 바위 - 1, 보 - 2
        
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        // 사용자에게 콘솔에서 키보드로 가위(0)/바위(1)/보(2)를 입력하도록 안내.
        System.out.println("가위바위보 게임");
        System.out.println("---------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("---------------");
        System.out.println("선택>>>");
        
        // 사용자가 입력한 숫자를 변수에 저장:
        int user = scanner.nextInt();
        System.out.println("user: " + user);
        
        // 컴퓨터의 선택은 난수로 만듦:
        int computer = random.nextInt(3);
        System.out.println("computer: " + computer);

        // 가위바위보 결과 출력:
        if (user == 0 && computer == 0) {
            
        } else if (user == 0 && computer == 1) {
            
        } else if (user == 0 && computer == 2) {
            
        } else if (user == 1 && computer == 0) {
            
        } else if (user == 1 && computer == 1) {
            
        } else if (user == 1 && computer == 2) {
            
        } else if (user == 2 && computer == 0) {
            
        } else if (user == 2 && computer == 1) {
            
        } else {
            
        }
        
        if (user == 0) { // user: 가위
            if (computer == 0) { // computer: 가위
                
            } else if (computer == 1) { // computer: 바위
                
            } else { // computer: 보
                
            }
        } else if (user == 1) { // user: 바위
            if (computer == 0) { // computer: 가위
                
            } else if (computer == 1) { // computer: 바위
                
            } else { // computer: 보
                
            }
        } else { // user: 보
            if (computer == 0) { // computer: 가위
                
            } else if (computer == 1) { // computer: 바위
                
            } else { // computer: 보
                
            }
        }
        
        if (user == computer) { // 비긴 경우
            
        } else if (user == 0) { // user: 가위
            if (computer == 1) { // computer: 바위
                
            } else { // computer: 보
                
            }
        } else if (user == 1) { // user: 바위
            if (computer == 0) { // computer: 가위
                
            } else { // computer: 보
                
            }
        } else { // user: 보
            if (computer == 0) { // computer: 가위
                
            } else { // computer: 바위
                
            }
        }
        
        if (user == computer) {
            // 비긴 경우
        } else if ((user == 0 && computer == 2) || 
                (user == 1 && computer == 0) || 
                (user == 2 && computer == 1)) { 
            // user가 이긴 경우
        } else {
            // computer가 이긴 경우
        }
        
    }

}
