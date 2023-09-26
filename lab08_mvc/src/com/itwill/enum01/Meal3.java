package com.itwill.enum01;

public enum Meal3 {
    BREAKFAST, LUNCH, DINNER;
    
    // enum은 특별한 종류의 클래스이기 때문에 메서드를 작성할 수 있음.
    public int getOrder() {
        if (this == BREAKFAST) {
            return 0;
        } else if (this == LUNCH) {
            return 1;
        } else {
            return 2;
        }
    }
}
