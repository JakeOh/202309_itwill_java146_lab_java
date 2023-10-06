package com.itwill.set04;

import java.util.Objects;

public class Score {
    private int java;
    private int sql;
    private int web;
    
    public Score() {}
    
    public Score(int java, int sql, int web) {
        this.java = java;
        this.sql = sql;
        this.web = web;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getSql() {
        return sql;
    }

    public void setSql(int sql) {
        this.sql = sql;
    }

    public int getWeb() {
        return web;
    }

    public void setWeb(int web) {
        this.web = web;
    }

    @Override
    public String toString() {
        return "Score(java=" + java + ", sql=" + sql + ", web=" + web +")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(java, sql, web);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Score other = (Score) obj;
        return java == other.java && sql == other.sql && web == other.web;
    }
    
    // equals와 hashCode를 override
    // java, sql, web의 값이 모두 같으면 equals가 true를 리턴.
    
//    @Override
//    public boolean equals(Object obj) {
//        boolean result = false;
//        if (obj instanceof Score) {
//            Score other = (Score) obj;
//            result = (java == other.java) && 
//                    (sql == other.sql) && 
//                    (web == other.web); 
//        }
//        
//        return result;
//    }
//    
//    @Override
//    public int hashCode() {
//        return Integer.valueOf(java).hashCode() 
//                + Integer.valueOf(sql).hashCode() 
//                + Integer.valueOf(web).hashCode();
//    }
}
