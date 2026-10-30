import java.util.List;

// интерфейс, который требует метод sort
public interface Sorting<T extends Comparable<T>> {
    void sort(List<T> nums);
}