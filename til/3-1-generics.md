# 2025-08-10 TIL

## Generics
- 타입에 대한 의존성을 없애, 코드 중복을 줄일 수 있음
```java
    public static void main(String[] args) {
        Integer[] iArray = {1,2,3,4,5};
        Double[] dArray = {1.0,2.0,3.0,4.0,5.0};
        String[] sArray = {"a","b","c","d","e"};

        printAnyArray(iArray);
        printAnyArray(dArray);
        printAnyArray(sArray);
    }
    private static <T> void printAnyArray(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
```
- Generics - 객체만 지원 - primitive 불가능
- <> -> T : Type / K : Key / V : Value / E : Element

## Generic Class

