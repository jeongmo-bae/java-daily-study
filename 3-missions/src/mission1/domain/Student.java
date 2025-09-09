package mission1.domain;

import java.util.HashMap;

public class Student {
    private String id;
    private String name;
    private int koreanScore;
    private int englishScore;
    private int mathScore;
    private int sumScore;
    private long avgScore;
    
    public Student(String id, String name, int koreanScore , int englishScore , int mathScore){
        this.id = id;
        this.name = name;
        this.koreanScore = koreanScore;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
        this.sumScore = koreanScore + englishScore + mathScore;
        this.avgScore = sumScore/3;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getKoreanScore() {
        return koreanScore;
    }
    public void setKoreanScore(int koreanScore) {
        this.koreanScore = koreanScore;
    }
    public int getEnglishScore() {
        return englishScore;
    }
    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }
    public int getMathScore() {
        return mathScore;
    }
    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }
}
