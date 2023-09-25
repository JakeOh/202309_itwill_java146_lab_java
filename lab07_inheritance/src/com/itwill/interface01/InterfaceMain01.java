package com.itwill.interface01;

import com.itwill.database.DatabaseModule;
import com.itwill.database.OracleDatabase;

import static com.itwill.database.DatabaseModule.DB_VERSION;
// import static 문장:
// 인터페이스 또는 클래스에서 static으로 선언된 필드 또는 메서드 이름을 임포트하는 문장.

/*
 * 인터페이스(interface):
 * 사용 목적: 팀/회사 간의 분업/협업을 하기 위해서 메서드들의 signature를 약속하기 위한 규약.
 * 인터페이스가 가질 수 있는 멤버들:
 *   (1) public static final 필드. "public static final" 수식어는 보통 생략.
 *   (2) public abstract 메서드. "public abstract" 수식어는 보통 생략.
 * 인터페이스를 작성할 때는 "interface" 키워드로 선언.
 * 인터페이스는 객체를 생성할 수 없고, 인터페이스를 "구현"하는 클래스를 작성해서 객체를 생성.
 *   class 클래스이름 implements 인터페이스 { ... }
 * 클래스는 단일 상속만 가능하지만, 인터페이스 구현은 개수 제한이 없음.
 * 인터페이스는 상위 인터페이스를 상속(확장)할 수도 있음.
 *   interface 하위인터페이스 extends 상위인터페이스 { ... }
 */

public class InterfaceMain01 {

    public static void main(String[] args) {
        // OracleDatabase 타입 객체 생성
//        OracleDatabase db = new OracleDatabase();
        DatabaseModule db = new OracleDatabase();
        // SuperType var = new SubType(); 다형성.
        
        int result = db.insert("데이터");
        System.out.println("삽입 결과=" + result);
        
        result = db.select();
        System.out.println("검색 결과=" + result);
        
        //DatabaseModule.DB_VERSION = 2; //-> 컴파일 에러: final 변수는 변경 불가.
        //System.out.println("버전=" + DatabaseModule.DB_VERSION);
        System.out.println("버전=" + DB_VERSION);

    }

}
