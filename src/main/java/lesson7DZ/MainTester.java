package lesson7DZ;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class MainTester {

    public static class TestStructureMeted {
        private final Method method;
        private final int priority;

        public TestStructureMeted(Method method, int priority) {
            this.method = method;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "TestStructureMeted{" +
                    "method=" + method +
                    ", priority=" + priority +
                    '}';
        }
    }

    public static Comparator<TestStructureMeted> priorityComparator = ((o1, o2) -> o2.priority - o1.priority);

    public static void startTest(Class<?> testClass) throws InvocationTargetException, IllegalAccessException {

        ArrayList<Method> beforeMethods = new ArrayList<>();
        ArrayList<Method> afterMethods = new ArrayList<>();

        Queue<TestStructureMeted> testMethods = new PriorityQueue<>(priorityComparator);

        Method[] methodsAll = testClass.getDeclaredMethods();
        int countBs = 0;
        int countAf = 0;
        for (Method m : methodsAll) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                countBs++;
                if (countBs < 2)
                    beforeMethods.add(m);
                else
                    throw new RuntimeException();
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                countAf++;
                if (countAf < 2)
                    afterMethods.add(m);
                else
                    throw new RuntimeException();
            }
            if (m.isAnnotationPresent(Test.class)) {
                testMethods.add(new TestStructureMeted(m, m.getAnnotation(Test.class).value()));
            }
        }

        System.out.println(beforeMethods);
        System.out.println(afterMethods);
        System.out.println(testMethods);

        TestClass t = new TestClass();
        for (Method m : beforeMethods) {
            m.invoke(t, 10, 2);
        }

        while (true) {
            TestStructureMeted m = testMethods.poll();
            if (m == null) break;
            System.out.println(m.priority);
            m.method.invoke(t, 10, 2);
        }

        for (Method m : afterMethods) {
            m.invoke(t, 10, 2);
        }

    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        startTest(TestClass.class);
    }
}
