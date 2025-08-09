package theme2_object_oriented_programming;

public class _14_Enum {
    public static void main(String[] args) {
        // 열거형(Enum)
        // 달력 : JAN , FEB, MAR...
        // OS :  MacOS , Win , Linux ...
        OperationSystem os = OperationSystem.MACOS ;
        System.out.println(os);
        System.out.println("======================");
        System.out.print("운영체제는 : ");
        os = OperationSystem.valueOf("LINUX");
        switch (os){
            case WIN :
                System.out.println("윈도우 입니다.");
                break;
            case LINUX:
                System.out.println("리눅스 입니다.");
                break;
            case MACOS:
                System.out.println("맥OS 입니다.");
                break;
        }
        System.out.println("======================");
        for (OperationSystem myos : OperationSystem.values()){
            System.out.println(myos.name() + " : Ordered " + myos.ordinal());
        }
        System.out.println("======================");
        for (OperationSystem myos: OperationSystem.values()){
            System.out.println(myos.name() + " : osNo  " + myos.getOsNo());
        }
    }
}
enum OperationSystem {
    WIN(1) , LINUX(2) , MACOS(3);
    private final int osNo ;
    OperationSystem(int osNo){
        this.osNo = osNo;
    }
    public int getOsNo() {
        return osNo;
    }
}
