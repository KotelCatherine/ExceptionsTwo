package ru.geekbrains.lessons;

import java.util.Scanner;

public class ExceptionsTwo {

    public static void main(String[] args) {
      //Первое задание
        echoMethod();

      //Второе задание (из файла)
        excepMethod(new int[]{1,2,3});

      //Третье задание (из файла)
        excepTwoMethod();

      //Четвертое задание
        emptyString();
    }

    //Первое задание
    private static void echoMethod() {
        System.out.println("Пожалуйста, введите дробное число!");

        Scanner scanner = new Scanner(System.in);
        float numF = 0;
        boolean isNum = false;

        while(!isNum){
            try {
                numF = scanner.nextFloat();
                isNum = true;
            } catch (RuntimeException e) {
                System.out.println("Необходимо ввести дробное число! Попробуйте еще раз: ");
                String sc = scanner.nextLine();
            }

        }

        System.out.println("Ваше число: " + numF);
    }

    //Второе задание
    private static void excepMethod(int[] intArray) {
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (IndexOutOfBoundsException e) { // на случай если на вход подают массив с меньшим размером,
                                                // где index = 8 отсутствует
            System.out.println("Catching exception: " + e);
        }

    }

    //Третье задание
    private static void excepTwoMethod() {  //не увидела смысла в пробрасывании Exception,
                                            // если мы перехватываем исключения
        try {                               // также здесь лучше ловить исключения, которые могут возникнуть и указать на ошибку,
                                            // чем ловить Throwable и гадать "что-то пошло не так"
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;


        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }

    public static void printSum(int a, int b) { // здесь Integer не нужен
                                                // также не нужно пробрасывать исключение FileNotFoundException
                                                // с файлами не работаем здесь
        System.out.println(a + b);
    }

    //Четвертое задание
    private static void emptyString() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        if (str.equals("")) {
            throw new RuntimeException("Ошибка! Введена пустая строка");
        }

    }
}
