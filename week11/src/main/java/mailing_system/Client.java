package mailing_system;

import lombok.Getter;

@Getter
public class Client {
    @Template(value = "%ID%")
    private int id;
    @Template(value = "%NAME%")
    public String name;
    @Template(value = "%AGE%")
    public int age;
    @Template(value = "%SEX%")
    public boolean sex;

    public Client(String name, int age, boolean sex) {
        this.id = ClientIdGenerator.generateId();
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public static class ClientIdGenerator {
        private static int id = 0;

        public static int generateId() {
            id++;
            return id;
        }
    }
}
