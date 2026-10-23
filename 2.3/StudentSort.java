import java.util.List;

public class StudentSort implements Sorting<Student> {

    @Override
    public void sort(List<Student> students) {
        //сначала сортируем по имени
        mergeSort(students, 0, students.size() - 1, true);
        
        //затем сортируем по возрасту
        mergeSort(students, 0, students.size() - 1, false);
    }

    //рекурсивная функция слияния
    private void mergeSort(List<Student> students, int start, int end, boolean sortByName) {
        if (start >= end) return;
        
        int middle = start + (end - start) / 2;
        mergeSort(students, start, middle, sortByName);
        mergeSort(students, middle + 1, end, sortByName);
        
        merge(students, start, middle, end, sortByName);
    }

    private void merge(List<Student> students, int start, int middle, int end, boolean sortByName) {
        Student[] temp = new Student[end - start + 1];
        int i = start;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= end) {
            boolean condition;
            if (sortByName) {
                //сравниваем по имени
                condition = students.get(i).getName().compareTo(students.get(j).getName()) <= 0;
            } else {
                //сравниваем по возрасту
                condition = students.get(i).getAge() <= students.get(j).getAge();
            }

            if (condition) {
                temp[k++] = students.get(i++);
            } else {
                temp[k++] = students.get(j++);
            }
        }

        while (i <= middle) temp[k++] = students.get(i++);
        while (j <= end) temp[k++] = students.get(j++);

        for (int l = 0; l < temp.length; l++) {
            students.set(start + l, temp[l]);
        }
    }
}