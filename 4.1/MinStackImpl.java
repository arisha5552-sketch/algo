public class MinStackImpl implements MinStack<Integer> {

    private static class Node {
        int value;
        int minSoFar;
        Node next;

        Node(int value, int minSoFar, Node next) {
            this.value = value;
            this.minSoFar = minSoFar;
            this.next = next;
        }
    }

    private Node head;

    @Override
    public void push(Integer value) {
        int minSoFar = (head == null)
                ? value
                : Math.min(value, head.minSoFar);
        head = new Node(value, minSoFar, head);
    }

    @Override
    public Integer pop() {
        if (head == null) {
            return null;
        }
        Integer value = head.value;
        head = head.next;
        return value;
    }

    @Override
    public Integer top() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    @Override
    public Integer min() {
        if (head == null) {
            return null;
        }
        return head.minSoFar;
    }
}