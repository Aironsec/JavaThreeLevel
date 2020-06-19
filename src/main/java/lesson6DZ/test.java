package lesson6DZ;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class test {
    private Main main;

    @Before
    public void init() {
        main = new Main();
    }

    /*@ParameterizedTest
    @MethodSource("mas")*/
    @Test
    public void testArray(/*int[] ex, int[] ac*/) {
//        Assertions.assertArrayEquals(ex, main.newArray(ac));
        Assertions.assertArrayEquals(new int[]{2, 3, 5, 3, 7}, main.newArray(new int[]{1, 2, 4, 4, 2, 3, 5, 3, 7}));
        Assertions.assertArrayEquals(new int[]{2, 7, 9, 2, 3, 5, 3, 7}, main.newArray(new int[]{4, 2, 7, 9, 2, 3, 5, 3, 7}));
        Assertions.assertArrayEquals(new int[]{}, main.newArray(new int[]{1, 2, 4, 4, 2, 3, 5, 3, 4}));
        Assertions.assertThrows(RuntimeException.class, () -> main.newArray(new int[]{1, 2, 5, 8}));
    }
// TODO: 15.06.2020 Подскажите, почету не работает парометризация?? как передать массив в качестве параметра?
    /*public static Stream<Arguments> mas(){
        List<Arguments> out = new ArrayList<>();
        int[] ex = {1, 7};
        int[] ac = {1, 2, 4, 4, 2, 3, 5, 3, 7};
        out.add(Arguments.arguments(ex, ac));
        return out.stream();
    }*/

    @Test
    public void test2() {
        Assertions.assertTrue(main.arrayCheck(new int[]{1, 1, 4, 4}));
        Assertions.assertFalse(main.arrayCheck(new int[]{1, 1, 2, 4}));
        Assertions.assertFalse(main.arrayCheck(new int[]{1, 1, 1, 1}));
        Assertions.assertFalse(main.arrayCheck(new int[]{4, 4, 4, 4}));

    }
}
