import java.util.List;

// класс реализует интерфейс Sorting для типа Integer (целые числа)
public class InsertionSort implements Sorting<Integer> {
    
    @Override
    public void sort(List<Integer> nums) {
        // проходим по массиву, начиная со второго элемента 
        for (int i = 1; i < nums.size(); i++) {
            
            // запоминаем текущий элемент
            Integer key = nums.get(i);
            
            // начинаем сравнивать с элементами слева (от i-1 до 0)
            int j = i - 1;
            
            // пока j >= 0 и элемент слева больше, чем наш key
            // мы сдвигаем элемент слева вправо
            while (j >= 0 && nums.get(j).compareTo(key) > 0) {
                nums.set(j + 1, nums.get(j)); // Сдвигаем вправо
                j--;
            }
            
            // вставляем наш key на освободившееся место
            nums.set(j + 1, key);
        }
    }
}