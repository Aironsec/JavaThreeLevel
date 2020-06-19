package lesson7DZ;

public class TestClass {
    int res;
    @BeforeSuite
    public int meted1(int x, int y) {
        System.out.println("Сложить");
        return res = x + y;
    }
    @Test
    public int meted2(int x, int y) {
        System.out.println("Вычесть");
        return x - y;
    }
    @Test(value = 9)
    public int meted3(int x, int y) {
        System.out.println("Умножить");
        return x * y;
    }
    @Test
    public int meted4(int x, int y) {
        System.out.println("Делить");
        return x / y;
    }
    @Test
    public int meted5(int x, int y) {
        System.out.println("Результат");
        return  res - meted1(x, y);
    }
}
