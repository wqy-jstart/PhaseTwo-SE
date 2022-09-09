package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 *  使用当前类测试对象序列化与反序列化
 *
 *  JAVA BEAN 咖啡豆
 */
//Person对象可序列化(签名接口)
public class Person implements Serializable {
    private String name;
    private int age;
    private String gender;
//transient关键字，保证该属性的值不被存入文件中,若没有实现Serializable接口,用则没有意义
    private transient String[] otherInfo;
    public Person(){}

    public Person(String name, int age, String gender, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }
}
