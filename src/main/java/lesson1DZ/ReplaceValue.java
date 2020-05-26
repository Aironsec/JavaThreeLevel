package lesson1DZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceValue<T> {

    private T[] value;

    public ReplaceValue(T... value) {
        this.value = value;
    }

    public void replace() {
        if (value.length <= 0) System.out.println("массив пуст");
        for (int i = 0; i < value.length; i++) {
            if (i + 1 >= value.length) break;
            T tmp = value[i];
            value[i] = value[++i];
            value[i] = tmp;
        }
    }

    public List<?> toArrayList(ReplaceValue<?> mas) {
        return new ArrayList<>(Arrays.asList(mas));
    }

    @Override
    public String toString() {
        return "value = " + Arrays.toString(value) +
                '}';
    }

    public static void main(String[] args) {
        ReplaceValue<?> mas = new ReplaceValue<>(1,2,"три",4,5,6,7,8,"девять");
        System.out.println(mas);
        mas.replace();
        System.out.println(mas);
        List<?> list = mas.toArrayList(mas);
        System.out.println(list);
    }
}
