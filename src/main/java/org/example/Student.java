package org.example;

import java.io.*;

/*
Разработайте класс Student с полями
String name, int age, transient double GPA (средний балл).
Обеспечьте поддержку сериализации для этого класса.
Создайте объект класса Student и инициализируйте его данными.
Сериализуйте этот объект в файл.
Десериализуйте объект обратно в программу из файла.
Выведите все поля объекта, включая GPA, и ответьте на вопрос,
почему значение GPA не было сохранено/восстановлено.

2. * Выполнить задачу 1 используя другие типы сериализаторов
(в xml и json документы).
 */
public class Student implements Serializable {
    private String name;
    private int age;
    private transient double GPA;


    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public Student() {
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }
    /*
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        out.writeDouble(GPA);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
        GPA = in.readDouble();
    }*/
}
