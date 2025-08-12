package theme4_collection_framework;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class _02_LinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList.getClass());
        System.out.println("=================================");
        // 데이터 추가
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            linkedList.add(random.nextInt(10000));
        }
        System.out.println(linkedList);
        System.out.println("=================================");
        // 데이터 조회
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println("=================================");
        // 추가
        linkedList.addFirst(150);
        linkedList.addLast(1);
        System.out.println(linkedList);
        int mid = linkedList.size() / 2;
        System.out.println(mid);
        linkedList.add(mid + 1, 51);
        System.out.println(linkedList);
        System.out.println("=================================");
        if (linkedList.contains(51)) {
            System.out.println("51 있음");
        }

        //삭제
        System.out.println("=================================");
        int first = linkedList.remove(0);
        System.out.println(first + " : " + linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(first + " : " + linkedList);

        // 변경
        System.out.println("=================================");
        linkedList.set(0, 0);
        System.out.println(linkedList);

        // contains , isEmpty , Collections.sort
        System.out.println("=================================");
        boolean doIter = true;
        int iterCount = 0;
        int num = 9999;
        while (doIter) {
            iterCount += 1;
            if (linkedList.contains(num)) {
                doIter = false;
                System.out.println(iterCount + "th iter : " + num + "을 포함합니다. ::: " + linkedList);
            } else {
                System.out.println(iterCount + "th iter : " + num + "을 포함하지 않습니다. ::: " + linkedList);
                linkedList.clear();
            }
            if (linkedList.isEmpty()) {
                for (int i = 0; i < 20; i++) {
                    Random random = new Random();
                    linkedList.add(random.nextInt(10000));
                }
            }else{
                System.out.println("내림차순 정렬합니다.");
                Collections.sort(linkedList, Collections.reverseOrder());
            }
        }
        System.out.println(num + "을 포함하여 루프를 종료합니다. ::: iterCount = " + iterCount + " ::: " + linkedList);
    }
}
