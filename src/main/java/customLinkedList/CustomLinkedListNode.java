package customLinkedList;

import java.util.Objects;

public class CustomLinkedListNode<T> {
    T value;
    CustomLinkedListNode<T> nextNode;
    CustomLinkedListNode<T> previousNode;

    public CustomLinkedListNode(T value, CustomLinkedListNode<T> nextNode, CustomLinkedListNode<T> previousNode) {
        this.value = value;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
    }

}
