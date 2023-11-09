import org.example.Calculator;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {


    @Test
    public void evaluatesExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2,6, '+')).isEqualTo(8);
    }

    @Test
    public void subctractionExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2,1,'-')).isEqualTo(1);
    }

    @Test
    public void multiplacitionExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2,4,'*')).isEqualTo(8);
    }

    @Test
    public void divisionExpresson() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(8,2, '/')).isEqualTo(4);
    }

    @Test
    public void expectedIllegalStateExceptionOnInvalidOperatorSymbol() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculation(8,2,'_'))
                .isInstanceOf(IllegalStateException.class);
    }

//    @Test
//    @Override
//    public void getOperandCompletesCorrectlyWithNotNumbers() {
//        String testedValue = "k";
//        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
//        ByteArrayInputStream out = new ByteArrayInputStream();
//        InputStream inputStream = System.in;
//        System.setIn(in);
//        System.setOut(new PrintStream(out));
//
//        assertThatThrownBy(() -> Calculator.getOperand()).isInstanceOf(IllegalStateException.class)
//                .describedAs("Ошибка в вводимых данных");
//
//        System.setIn(inputStream);
//        System.setOut(null);
//
//    }

    @Test
    public void computeCirculeRadiusWorksCorrectly() {
        assertThat(Calculator.computeAreaCircle(10)).isEqualTo(314.1592653589793);
    }


    @Test
    public void CalculateDiscountTest() {
        Calculator calculator = new Calculator();
        // проверяем корректность расчёта скидки
        double result1 = calculator.calculateDiscount(100.0, 10.0);
    assertThat(result1).isEqualTo(90.0);
        // проверяем корректность расчета скидки, если сумма покупки равна 0
        double result2 = calculator.calculateDiscount(0.0, 20.0);
        assertThat(result2).isEqualTo(0.0);
        //проверка на выброс исключения при отрицательной сумме покупки
        assertThatThrownBy(() -> calculator.calculateDiscount(-100.0, 15.0))
                .isInstanceOf(ArithmeticException.class).hasMessage("Invalid arguments");
        // проверка выброса исключения при отрицательном значении процента скидки
        assertThatThrownBy(() -> calculator.calculateDiscount(200.0, -10.0))
                .isInstanceOf(ArithmeticException.class).hasMessage("Invalid arguments");
        // проверка выброса исключения при проценте скидки более 100%
        assertThatThrownBy(() -> calculator.calculateDiscount(150.0, 110.0))
                .isInstanceOf(ArithmeticException.class).hasMessage("Invalid arguments");

    }
}


