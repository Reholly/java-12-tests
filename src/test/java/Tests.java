import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    //Тест преобразования положительных чисел.
    @Test
    public void testPositiveCorrectResults() {
        Assertions.assertThat(Integer.decode("+123"))
                .isEqualTo(123);
    }

    //Тест преобразования отрициательных чисел.
    @Test
    public void testNegativeCorrectResults() {
        Assertions.assertThat(Integer.decode("-123"))
                .isEqualTo(-123);
    }

    //Тест преобразования нулевых чисел.
    @Test
    public void testZeroCorrectResults() {
        //Проверка на успешный parse положительных чисел
        Assertions.assertThat(Integer.decode("0"))
                .isEqualTo(0);
    }

    //Тест преобразования нулевых чисел.
    @Test
    public void testWordStringParsing() {
        Assertions.assertThatThrownBy(() -> Integer.decode("this is just a string"))
                .isInstanceOf(NumberFormatException.class);
    }

    //Тест выхода за пределы СС
    @Test
    public void testFloatDecoding() {
        Assertions.assertThatThrownBy(() -> Integer.decode("35.2"))
                .isInstanceOf(NumberFormatException.class);
    }

    //Тест на выход за границы
    @Test
    public void testNumberParsingBorders() {
        Assertions.assertThatThrownBy(() -> Integer.decode(Long.toString((long) Integer.MAX_VALUE + 1)))
                .isInstanceOf(NumberFormatException.class);

        Assertions.assertThatThrownBy(() -> Integer.decode(Long.toString((long) Integer.MIN_VALUE - 1)))
                .isInstanceOf(NumberFormatException.class);
    }

    // Тест на корректность написания числа
    @Test
    public void testNumberCorrectRecord() {
        Assertions.assertThatThrownBy(() -> Integer.decode(","))
                .isInstanceOf(NumberFormatException.class);
        Assertions.assertThatThrownBy(() -> Integer.decode("="))
                .isInstanceOf(NumberFormatException.class);
        Assertions.assertThatThrownBy(() -> Integer.decode("."))
                .isInstanceOf(NumberFormatException.class);
        Assertions.assertThatThrownBy(() -> Integer.decode("-"))
                .isInstanceOf(NumberFormatException.class);
    }

    // Тест на преобразование null
    @Test
    public void testNullStringParsing() {
        Assertions.assertThatThrownBy(() -> Integer.decode(null))
                .isInstanceOf(NullPointerException.class);
    }

    // Тест на преобразование пустой строки
    @Test
    public void testEmptyStringParsing() {
        Assertions.assertThatThrownBy(() -> Integer.decode(""))
                .isInstanceOf(NumberFormatException.class);
    }

    //тест на нулевую строку подстроку сначала
    @Test
    public void testZeroStart() {
        Assertions.assertThat(Integer.decode("00001"))
                .isEqualTo(1);
    }

    @Test
    public void testHexRadix() {
        Assertions.assertThat(Integer.decode("#A"))
                .isEqualTo(10);
        Assertions.assertThat(Integer.decode("#C"))
                .isEqualTo(12);

        Assertions.assertThat(Integer.decode("-#A"))
                .isEqualTo(-10);
        Assertions.assertThat(Integer.decode("-#C"))
                .isEqualTo(-12);
    }
}
