package EfficientQuickSort;

class Sorting {
    void sort(Person[] persons, int left, int right) {
        if ((right - left) > 1) {
            int newBorder = sortWithPivot(persons, left, right);
            sort(persons, left, newBorder);
            sort(persons, newBorder + 1, right);
        }
    }

    int sortWithPivot(Person[] persons, int left, int right) {
        Person pivot = persons[left];
        int i = left + 1;
        int j = right - 1;
        while (true) {
            if (i <= j && pivot.compareTo(persons[i]) > 0) {
                i++;
            } else if (i <= j && pivot.compareTo(persons[j]) < 0) {
                j--;
            }
            if (i <= j) {
                swap(persons, i, j);
            } else {
                swap(persons, left, j);
                return j;
            }
        }
    }

    void swap(Person[] persons, int i, int j) {
        Person temp = persons[i];
        persons[i] = persons[j];
        persons[j] = temp;
    }
}
