import java.util.Scanner;


public class task2 {
    public static void main(String[] args) {
        Man man = new ChangableMan();
        Scanner scan = new Scanner(System.in);
        int age = scan.nextInt(); // <- 93

        System.out.println(man.sayAge()); // prints '0'
        changeAge((ChangableMan)man, age);
        System.out.println(man.sayAge()); // prints '93'
        
        scan.close();
    }

    public static void changeAge(ChangableMan a, int age){
        a.setAge(age); 
    }
}

class ChangableMan extends Man {
    public int age;

    public ChangableMan() { age = 0; }
    public ChangableMan(int a) { age = a; }
    public void setAge(int a) { age = a; }
    @Override public int sayAge() { return age; }
}

class Man {
    private int age;

    public Man(){
        age = 0;
    }

    public Man(int age){
        this.age = age;
    }

    public int sayAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Man{" +
                "age=" + age +
                '}';
    }
}