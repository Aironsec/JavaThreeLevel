package lesson1DZ.task;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    List<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public int getWeight () {
        if (box.size() < 1) return -1;
        int weight = 0;
        for (T item : box) {
            weight += item.weight;
        }
        return weight;
    }

    public boolean compare (Box<?> otherBox) {
        return getWeight() == otherBox.getWeight();
    }

    public void pourOut(Box<T> otherBox) {
        otherBox.box.addAll(box);
        box.clear();
    }

    public static void main(String[] args) {
        Box<Apple> boxApple = new Box<>();
        Box<Orange> boxOrange = new Box<>();

        boxApple.box.add(new Apple(5));
        boxApple.box.add(new Apple(1));
        boxApple.box.add(new Apple(2));
        boxApple.box.add(new Apple(6));

        System.out.println(boxApple.getWeight());

        boxOrange.box.add(new Orange(2));
        boxOrange.box.add(new Orange(9));
        boxOrange.box.add(new Orange(5));
        boxOrange.box.add(new Orange(3));

        System.out.println(boxOrange.getWeight());

        System.out.println(boxApple.compare(boxOrange));
        System.out.println(boxOrange.compare(boxOrange));

        Box<Apple> boxApple2 = new Box<>();
        boxApple2.box.add(new Apple(9));
        boxApple2.box.add(new Apple(7));

        boxApple.pourOut(boxApple2);

        System.out.println(boxApple.getWeight());
        System.out.println(boxApple2.getWeight());
    }
}
