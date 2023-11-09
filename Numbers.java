package org.example;
/*Задание 1.
Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет,
является ли переданное число четным или нечетным. (код приложен в презентации)
Задание 2.
Разработайте и протестируйте метод numberInInterval, который проверяет,
попадает ли переданное число в интервал (25;100). (код приложен в презентации) */

public class Numbers {
    public boolean EvenOddNumber(int n) {
        if(n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }


    public boolean NumberInInterval (int n) {
        int intervalBegin = 25;
        int intervalEnd = 100;
        return intervalBegin <= n && n <= intervalEnd;
    }
}

