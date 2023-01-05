package jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 演示JDK1.8方法的引用-- ::
 *
 * @author java@Wqy
 * @version 0.0.1
 * @since 2023.1.5
 */
public class NewMethodUse {
    public static void main(String[] args) {
        // 构造器引用 Class::new
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
        // 静态方法的引用 Class::static_method
        cars.forEach(Car::collide);
        // 特定类的任意对象的方法引用 Class::method
        cars.forEach(Car::repair);
        // 特定对象的方法引用 instance::method
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);

        // 方法引用实例
        List<String> names = new ArrayList<>();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);
    }
}

// 该类中定义各种方法
class Car {
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}
