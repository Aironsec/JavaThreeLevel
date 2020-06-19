package lesson6DZ;


import java.util.Arrays;

public class Main {

    public int[] newArray(int[] inArray) {
        int i = inArray.length;
        while (i > 0) {
            i--;
            if (inArray[i] == 4) {
                return Arrays.copyOfRange(inArray, ++i, inArray.length);
            }
        }
        throw new RuntimeException();
    }

    public boolean arrayCheck(int[] inArray) {
        boolean item1 = false;
        boolean item4 = false;
        for (int i : inArray) {
            if (i != 1 && i != 4) return false;
            if (i == 1) item1 = true;
            if (i == 4) item4 = true;
        }
        return item1 && item4;
    }
}
