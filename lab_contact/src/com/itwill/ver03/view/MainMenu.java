package com.itwill.ver03.view;

public enum MainMenu {
    QUIT, SELECT_ALL, CREATE, SELECT_BY_INDEX, UPDATE, DELETE, UNKONWN;
    
    public static MainMenu getMenu(int n) {
        MainMenu[] values = values();
        if (n >= 0 && n < values.length) {
            return values[n];
        } else {
            return UNKONWN;
        }
    }
}
