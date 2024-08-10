package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] numbers = {41, 12, 68, 2, 58, 21, 55, 44, 97, 6, 54, 28, 77, 31, 93};


        System.out.print("Початковий вигляд масиву: [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");


        insertionSort(numbers);


        System.out.print("Відсортований масив: [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");


        Scanner scanner = new Scanner(System.in);


        System.out.print("Введіть число для пошуку: ");
        int target = scanner.nextInt();


        int index = binarySearch(numbers, target);


        if (index >= 0) {
            System.out.printf("Індекс числа %d у відсортованому масиві: %d%n", target, index);
        } else {
            System.out.printf("Число %d не знайдено в масиві.%n", target);
        }


    }


    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;


            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }


    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
