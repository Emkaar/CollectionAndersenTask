package customLinkedList;

import java.util.Objects;

public class CustomLinkedList<T> {
    CustomLinkedListNode<T> firstNode;
    CustomLinkedListNode<T> lastNode;
    private int size = 0;

    public boolean add(T newValue){
        CustomLinkedListNode<T> newNode = new CustomLinkedListNode<>(newValue, null, null);
        if(isEmpty()){
            firstNode = newNode;
        }else {
            CustomLinkedListNode<T>previous = lastNode;
            previous.nextNode = newNode;
            newNode.previousNode = previous;
            previous.nextNode = newNode;
        }
        lastNode = newNode;
        size++;
        return true;
    }

    public boolean remove(T deletedValue){
        for(CustomLinkedListNode<T> node = firstNode; node != null; node = node.nextNode){
            if(node.value.equals(deletedValue)){
                delete(node);
                return true;
            }
        }
        return false;
    }

    public T get(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        CustomLinkedListNode<T> node = firstNode;
        for ( int i = 0; i < index;i++) {
            node = node.nextNode;
        }
        return node.value;
    }

    public int size(){return size;}

    public void clear(){
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    private void delete(CustomLinkedListNode<T> node) {
        T element = node.value;
        CustomLinkedListNode<T> next = node.nextNode;
        CustomLinkedListNode<T> prev = node.previousNode;

        if (prev == null) {
            firstNode = next;
        } else {
            prev.nextNode = next;
            node.previousNode = null;
        }

        if (next == null) {
            lastNode = prev;
        } else {
            next.previousNode = prev;
            node.nextNode = null;
        }

        node.value = null;
        size--;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    public void reverseList(){
        CustomLinkedListNode<T>newFirst = lastNode;
        this.clear();
        for(CustomLinkedListNode<T> node = newFirst; node != null; node = node.previousNode){
            this.add(node.value);
        }
        firstNode.previousNode = null;
        lastNode.nextNode = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CustomLinkedList [ ");
        for (CustomLinkedListNode<T> node = firstNode; node !=null; node = node.nextNode){
            if(node.equals(lastNode)) {
                sb.append(node.value + " ]");
            }else {
                sb.append(node.value + ", ");
            }
        }
        return new String(sb);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomLinkedList<T> that = (CustomLinkedList<T>) o;
        if(this.size() == that.size()){
            CustomLinkedListNode<T>thisNode = this.firstNode;
            CustomLinkedListNode<T>thatNode = that.firstNode;
            for(int i = 0; i < size; i++){
                if(!thisNode.value.equals(thatNode.value)){
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNode, lastNode, size);
    }
}
