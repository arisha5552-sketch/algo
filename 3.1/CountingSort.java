import java.util.List;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        //проверка на пустой список (защита от ошибок)
        if (nums == null || nums.isEmpty()) {
            return;
        }

        //по условию числа от 0 до 127, нужно 128 ячеек
        int maxVal = 127;
        int[] counts = new int[maxVal + 1];

        //считаем, сколько раз встречается каждое число.
        //проходим по списку и увеличиваем счетчик для нужного числа.
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i);
            counts[value]++;
        }

        //перезаписываем исходный список отсортированными значениями.
        //идем по массиву counts слева направо (от 0 до 127).
        int index = 0; // Указатель для записи в исходный список
        for (int value = 0; value <= maxVal; value++) {
            while (counts[value] > 0) {
                nums.set(index, value);
                index++; //сдвигаем указатель
                counts[value]--; //уменьшаем счетчик
            }
        }
    }
}