package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
public class Main {
    public static void main(String[] args) throws Exception {
        List<Student> student = new ArrayList<>();
        student.add(new Student("Ivan", 24, 4.4));
        student.add(new Student("Kate", 22, 4.2));
        student.add(new Student("Lena", 19, 4.5));

        for (Student student1 : student) {
            System.out.println("Name: " + student1.getName());
            System.out.println("Age: " + student1.getAge());
            System.out.println("GPA: " + student1.getGPA());
            System.out.println();
        }

        /*System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("GPA: " + student.getGPA());*/

        /*try (FileOutputStream fileOut = new FileOutputStream("userdata.bin");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            out.writeObject(student);
            System.out.println("Объект Student сериализован.");
        }*/

        IOStudent.inFile(IOStudent.FILE_BIN, student);
        IOStudent.inFile(IOStudent.FILE_JSON, student);
        IOStudent.inFile(IOStudent.FILE_XML, student);
        System.out.println("Объект Student сериализован.");
        System.out.println();

        /*try (FileInputStream fileIn = new FileInputStream("userdata.bin");
             ObjectInputStream in = new ObjectInputStream(fileIn))
        {
            student = (Student) in.readObject();
            System.out.println("Объект Student десериализован.");
        }*/

        student = IOStudent.outFile(IOStudent.FILE_BIN);
        IOStudent.outFile(IOStudent.FILE_JSON);
        IOStudent.outFile(IOStudent.FILE_XML);

        System.out.println("Объект Student десериализован:");

        for (Student student1 : student) {
            System.out.println("Name: " + student1.getName());
            System.out.println("Age: " + student1.getAge());
            System.out.println("GPA: " + student1.getGPA());
            System.out.println();
        }

        /*System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Пароль (должен быть null, так как transient): " + student.getGPA());*/
    }
}