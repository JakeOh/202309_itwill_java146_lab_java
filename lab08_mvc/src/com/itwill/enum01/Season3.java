package com.itwill.enum01;

class Season3 {
    private String name;
    
    private Season3(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static final Season3 SPRING = new Season3("봄");
    public static final Season3 SUMMER = new Season3("여름");
}

enum Season4 {
    SPRING("봄"), SUMMER("여름");
    
    private String seasonName;
    private Season4(String season) {
        this.seasonName = season;
    }
    public String getSeasonName() {
        return seasonName;
    }
}
