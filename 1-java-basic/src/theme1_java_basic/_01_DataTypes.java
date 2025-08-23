package theme1_java_basic;

public class _01_DataTypes {
    public static void main(String[] args){
        usePrimitive();
        useWrapper();
    }
    public static void usePrimitive(){
        int age = 31;
        char grade = 'A';
        double score = 91.14; // float 이었음 score = 91.14f
        boolean isStudent = true;
        String name = "Jeongmo"; // java 엔 문자열 원시타입은 없음

        if (isStudent){
            System.out.println("이름: " + name);
            System.out.printf("나이: %d, 성적: %s(%.2f)\n", age, grade, score);
        }
    }
    public static void useWrapper(){
        String name = "Jeongmo";
        Double wrapperScore = new Double(81.14); // 기본 자료형을 boxing
        Character wrapperGrade = new Character('B'); // 기본 자료형을 boxing
        Integer wrapperAge = Integer.valueOf(31); // 동일한 결과지만 이걸 더 선호
        Boolean isStudent = false;
        if (!isStudent){
            System.out.println("이름: " + name);
            System.out.printf("나이: %d, 성적: %s(%.2f)\n", wrapperAge.intValue(), wrapperGrade.charValue(), wrapperScore.doubleValue());
        }

    }

}
