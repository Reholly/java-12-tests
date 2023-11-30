import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    //Тест преобразования положительных чисел.
    @Test
    public void testPositiveCorrectResults() {
        Assertions.assertThat(Integer.parseInt("123", 10))
                .isEqualTo(123);
    }

    //Тест преобразования отрициательных чисел.
    @Test
    public void testNegativeCorrectResults() {
        //Проверка на успешный parse положительных чисел
        Assertions.assertThat(Integer.parseInt("123", 10))
                .isEqualTo(123);
    }

    //Тест преобразования нулевых чисел.
    @Test
    public void testZeroCorrectResults() {
        //Проверка на успешный parse положительных чисел
        Assertions.assertThat(Integer.parseInt("0", 10))
                .isEqualTo(0);
    }

    //Тест преобразования нулевых чисел.
    @Test
    public void testWordStringParsing() {
        Assertions.assertThatThrownBy(() -> Integer.parseInt("this is just a string", 10))
                .isInstanceOf(NumberFormatException.class);
    }

    //Тест выхода за пределы СС
    @Test
    public void testCountingSystems() {
        Assertions.assertThatThrownBy(() -> Integer.parseInt("35", 2))
                .isInstanceOf(NumberFormatException.class);
    }

    //Тест на выход за границы
    @Test
    public void testNumberParsingBorders() {
        Assertions.assertThatThrownBy(() -> Integer.parseInt(Long.toString((long) Integer.MAX_VALUE + 1), 10))
                .isInstanceOf(NumberFormatException.class);

        Assertions.assertThatThrownBy(() -> Integer.parseInt(Long.toString((long) Integer.MIN_VALUE - 1), 10))
                .isInstanceOf(NumberFormatException.class);
    }

    // Тест на корректность написания числа
    @Test
    public void testNumberCorrectRecord() {
        Assertions.assertThatThrownBy(() -> Integer.parseInt(",", 10))
                .isInstanceOf(NumberFormatException.class);
        Assertions.assertThatThrownBy(() -> Integer.parseInt("=", 10))
                .isInstanceOf(NumberFormatException.class);
        Assertions.assertThatThrownBy(() -> Integer.parseInt(".", 10))
                .isInstanceOf(NumberFormatException.class);
        Assertions.assertThatThrownBy(() -> Integer.parseInt("-", 10))
                .isInstanceOf(NumberFormatException.class);
    }

    // Тест на преобразование null
    @Test
    public void testNullStringParsing() {
        Assertions.assertThatThrownBy(() -> Integer.parseInt(null, 10))
                .isInstanceOf(NumberFormatException.class);
    }

    // Тест на преобразование пустой строки
    @Test
    public void testEmptyStringParsing() {
        Assertions.assertThatThrownBy(() -> Integer.parseInt("", 10))
                .isInstanceOf(NumberFormatException.class);
    }

    // Тест на преобразование с минимальной системой счисления: 2
    @Test
    public void testNumberMinimumRadix() {
        Assertions.assertThatThrownBy(() -> Integer.parseInt("", 1))
                .isInstanceOf(NumberFormatException.class);
    }

    // Тест на преобразование с минимальной системой счисления: 36
    @Test
    public void testNumberMaximumRadix() {
        Assertions.assertThatThrownBy(() -> Integer.parseInt("", 36))
                .isInstanceOf(NumberFormatException.class);
    }
}
