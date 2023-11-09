import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.example.Numbers;




/*Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет,
является ли переданное число четным или нечетным. (код приложен в презентации)*/
public class TestNumberEvenOdd {
    Numbers numbs = new Numbers();

    int[] numbersOdd = new int[]{-1, 3, 5, 9};
    int[] numbersEven = new int[] {-2, 4, 8, 0};

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -9, 13, 11, Integer.MAX_VALUE})
    void isOdd(int number) {
        assertThat(numbs.EvenOddNumber(number)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4, 10, -6, 18, 2, Integer.MIN_VALUE})
    void isEven(int number) {
        assertThat(numbs.EvenOddNumber(number)).isTrue();
    }


    /*Разработайте и протестируйте метод numberInInterval, который проверяет,
попадает ли переданное число в интервал (25;100). (код приложен в презентации) **/

    @ParameterizedTest
    @ValueSource(ints = {25, 60, 99})
    void inInterval (int number) {
        assertThat(numbs.NumberInInterval(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 12, 120, 133})
    void beyondInterval(int number) {
        assertThat(numbs.NumberInInterval(number)).isFalse();
    }
}














