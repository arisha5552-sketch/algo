import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriorityQueueImpl implements PriorityQueue<Integer> {

    private static class Entry {
        int value;
        long operation;

        Entry(int value, long operation) {
            this.value = value;
            this.operation = operation;
        }
    }

    private final List<Entry> heap = new ArrayList<>();
    private final Map<Long, Integer> indexByOperation = new HashMap<>();
    private long operationCounter = 0;

    private void swap(int i, int j) {
        Entry ei = heap.get(i);
        Entry ej = heap.get(j);
        heap.set(i, ej);
        heap.set(j, ei);
        indexByOperation.put(ei.operation, j);
        indexByOperation.put(ej.operation, i);
    }

    private void siftUp(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (heap.get(idx).value <= heap.get(parent).value) {
                break;
            }
            swap(idx, parent);
            idx = parent;
        }
    }

    private void siftDown(int idx) {
        int size = heap.size();
        while (true) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int largest = idx;

            if (left < size && heap.get(left).value > heap.get(largest).value) {
                largest = left;
            }
            if (right < size && heap.get(right).value > heap.get(largest).value) {
                largest = right;
            }
            if (largest == idx) {
                break;
            }
            swap(idx, largest);
            idx = largest;
        }
    }

    @Override
    public void enqueue(Integer value) {
        operationCounter++;
        heap.add(new Entry(value, operationCounter));
        indexByOperation.put(operationCounter, heap.size() - 1);
        siftUp(heap.size() - 1);
    }

    @Override
    public Integer dequeueMax() {
        if (heap.isEmpty()) {
            System.out.println("*");
            return null;
        }

        Entry root = heap.get(0);
        int lastIdx = heap.size() - 1;
        swap(0, lastIdx);
        heap.remove(lastIdx);
        indexByOperation.remove(root.operation);

        if (!heap.isEmpty()) {
            siftDown(0);
        }

        System.out.println(root.operation + " " + root.value);
        return root.value;
    }

    @Override
    public void increment(long operation, Integer addition) {
        Integer idx = indexByOperation.get(operation);
        if (idx == null) {
            return;
        }
        heap.get(idx).value += addition;
        siftUp(idx);
    }
}