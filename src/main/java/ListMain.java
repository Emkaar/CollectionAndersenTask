import customLinkedList.CustomLinkedList;

import java.util.LinkedList;

public class ListMain {
    public static void main(String[] args) {
        CustomLinkedList<Integer> integerCustomLinkedList = new CustomLinkedList<>();
        integerCustomLinkedList.add(15);
        integerCustomLinkedList.add(14);
        integerCustomLinkedList.add(11);
        integerCustomLinkedList.add(1);
        System.out.println(integerCustomLinkedList.get(1));
        System.out.println(integerCustomLinkedList.get(2));
        integerCustomLinkedList.reverseList();
        System.out.println(integerCustomLinkedList);
    }
}
