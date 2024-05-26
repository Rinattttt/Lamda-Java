import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int size = input.nextInt();
        int[] array = new int[size];
        System.out.println("Введите каждый элемент: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        System.out.println("Выберите вариант сортировки и видите номер варианта: 1) по возрастанию 2) по убыванию ");
        int number = input.nextInt();

        Sorting sortDown = (int x, int y) -> {
            if (x < y) {
                return true;
            } else return false;
        };
        Sorting sortUp = (int x, int y) -> {
            if (x > y) {
                return true;
            } else return false;
        };

        if (number == 1) {
            SortArray(array, sortUp);
            for (int element : array) System.out.print(element + " ");
        } else if (number == 2) {
            SortArray(array, sortDown);
            for (int element : array) System.out.print(element + " ");
        } else System.out.println("Ошибка");


    }

    public static void SortArray(int[] array, Sorting arraySort) {
        double factor = 1.247;
        int step = array.length - 1;
        while (step >= 1) {
            for (int i = 0; i + step < array.length; i++) {
                if (arraySort.sort(array[i], array[i + step])) {
                    swap(array, i, i + step);
                }
            }
            step /= factor;
        }
    }

    public static void swap(int[] s, int i, int b) {
        int temp = s[i];
        s[i] = s[b];
        s[b] = temp;
    }

}

interface Sorting {
    boolean sort(int x, int y);
}