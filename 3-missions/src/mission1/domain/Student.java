package mission1.domain;

public class Student {
    private String id;
    private String name;
    private int koreanScore;
    private int englishScore;
    private int mathScore;
    private int totalScore;
    private double averageScore;

    public Student(String id, String name, int koreanScore, int englishScore, int mathScore) {
        this.id = id;
        this.name = name;
        this.koreanScore = koreanScore;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
        calculateTotalScore();
        calculateAverageScore();
    }
    private void calculateTotalScore(){
        this.totalScore = koreanScore + englishScore + mathScore;
    }
    private void calculateAverageScore(){
        this.averageScore = (koreanScore + englishScore + mathScore) / 3 ;
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
        calculateTotalScore();
        calculateAverageScore();

    }
    public int getEnglishScore() {
        return englishScore;
    }
    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
        calculateTotalScore();
        calculateAverageScore();

    }
    public int getMathScore() {
        return mathScore;
    }
    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
        calculateTotalScore();
        calculateAverageScore();
    }

    public int getTotalScore() {
        return totalScore;
    }
    public double getAverageScore() {
        return averageScore;
    }
}
