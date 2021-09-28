package ru.job4j.gc;

public class User {
    private int age;
    private String name;


    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        User user1 = new User(22, "USER1");
        User user2 = new User(33, "USER2");
        for (int i = 0; i < 2500; i++) {
            new User(i, "N" + i);
        }
    }
}
