import java.util.List;

public class MergeSort implements Sorting<Integer> {

    @Override
    public void sort(List<Integer> nums) {
        //запускаем рекурсию от начала до конца
        slice(nums, 0, nums.size() - 1);
    }

    // рекурсивная функция делит массив
    private void slice(List<Integer> nums, int start, int end) {
        // если start >= end, значит в кусочке 1 элемент или он пуст
        if (start >= end) {
            return;
        }

        //находим середину
        int middle = start + (end - start) / 2;

        //сортируем левую половину
        slice(nums, start, middle);
        //сортируем правую половину
        slice(nums, middle + 1, end);

        //сливаем две отсортированные половины
        merge(nums, start, middle, end);
    }

    //функция слияния двух отсортированных половин
    private void merge(List<Integer> nums, int start, int middle, int end) {
        //создаем временный список 
       
        int[] temp = new int[end - start + 1];//
        
        int i = start;      //указатель для левой половины
        int j = middle + 1; //указатель для правой половины
        int k = 0;          //указатель для временного массива

        //пока обе половины не закончились, сравниваем элементы
        while (i <= middle && j <= end) {
            if (nums.get(i) <= nums.get(j)) {
                temp[k++] = nums.get(i++);
            } else {
                temp[k++] = nums.get(j++);
            }
        }

        //если левая половина осталась, копируем остатки
        while (i <= middle) {
            temp[k++] = nums.get(i++);
        }

        //если правая половина осталась, копируем остатки
        while (j <= end) {
            temp[k++] = nums.get(j++);
        }

        //копируем из временного массива обратно в список
        for (int l = 0; l < temp.length; l++) {
            nums.set(start + l, temp[l]);
        }
    }
}