package Heapsort;

import java.util.ArrayList;

class Sorting {

    ArrayList<Person> pyramidalSort(Person[] persons) {
        ArrayList<Person> personsAfterFirstSort = new ArrayList<>();
        for (Person person : persons) {
            heapAdd(personsAfterFirstSort, person);
        }

        ArrayList<Person> personsAfterFinalSort = new ArrayList<>();
        for (int i = 0; i < persons.length; i++) {
            personsAfterFinalSort.add(popMax(personsAfterFirstSort));
        }
        return personsAfterFinalSort;
    }

    void heapAdd(ArrayList<Person> person, Person key) {
        int index = person.size();
        person.add(index, key);
        siftUp(person, index);
    }

    Person popMax(ArrayList<Person> person) {
        Person result = person.get(0);
        person.set(0, person.get(person.size() - 1));
        person.remove(person.size() - 1);
        siftDown(person, 0);
        return result;
    }

    void siftUp(ArrayList<Person> person, int index) {
        if (index == 0) {
            return;
        }

        int parentIndex;
        if (index % 2 == 0) {
            parentIndex = index / 2 - 1;
        } else {
            parentIndex = index / 2;
        }

        if (person.get(parentIndex).compareTo(person.get(index)) > 0) {
            swap(person, parentIndex, index);
            siftUp(person, parentIndex);
        }
    }

    void siftDown(ArrayList<Person> person, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int indexLargest;

        if (person.size() <= left) {
            return;
        }

        if (right < person.size() && person.get(left).compareTo(person.get(right)) > 0) {
            indexLargest = right;
        } else {
            indexLargest = left;
        }

        if (person.get(index).compareTo(person.get(indexLargest)) > 0) {
            swap(person, index, indexLargest);
            siftDown(person, indexLargest);
        }
    }

    void swap(ArrayList<Person> persons, int i, int j) {
        Person temp = persons.get(i);
        persons.set(i, persons.get(j));
        persons.set(j, temp);
    }
}
