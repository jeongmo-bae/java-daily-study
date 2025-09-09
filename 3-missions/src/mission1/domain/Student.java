package mission1.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String id;
    private String name;
    private int koreanScore;
    private int englishScore;
    private int mathScore;
    private int sumScore;
    private long avgScore;
    
    public Student(){}

    private boolean validateScore(int score){
        boolean res = true;
        if (score < 0 | score > 100){
            System.out.println("점수는 0~100 만 가능합니다.");
            res = false;
        }
        return res;
    }

//    public void setSumScore() {
//
//    }

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
        if(validateScore(koreanScore)){
            this.koreanScore = koreanScore;
        }
    }
    public int getEnglishScore() {
        return englishScore;
    }
    public void setEnglishScore(int englishScore) {
        if(validateScore(koreanScore)) {
            this.englishScore = englishScore;
        }
    }
    public int getMathScore() {
        return mathScore;
    }
    public void setMathScore(int mathScore) {
        if(validateScore(koreanScore)) {
            this.mathScore = mathScore;
        }
    }
}
