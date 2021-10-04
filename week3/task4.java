// Implement class Student with attributes gender,
// and name and getters and setters for them.
// Class Student should inherit interface Learnable
// and abstract class Human with attribute age with
// getter and setter
import java.util.Scanner;

interface Learnable {
    public void learn();
}

class Human {
    protected int age = 0;

    public void setAge(int human_age) {
        this.age = human_age;
    }

    public int getAge() {
        return this.age;
    }
}

class Student extends Human implements Learnable {
    int age;
    String name;
    String gender;

    public Student() {
        ;
    }

    public Student(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public void learn() {
        ;
    }

    @Override
    public String toString() {
        return String.format("Student{age=%d, name='%s', gender='%s'}",
         this.age, this.name, this.gender);
    }
}


public class task4 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = sc.nextInt();
        Student st;
        if (choice == 0) {
            st = new Student();
            System.out.println((st instanceof Learnable) && (st instanceof Human));
        } else if (choice == 1) {
            st = new Student(18, "Oleh", "male");
            System.out.println(st);
        } else if (choice == 2) {
            Human hm = new Student();
            System.out.println(hm.getAge());
        }
    }
}