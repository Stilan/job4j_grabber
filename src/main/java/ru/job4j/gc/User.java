package ru.job4j.gc;
// Заголовок: 8 байт
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

        /*
        new User()
        Пустой объект занимает 16 байт
        int age = 4 байта
        String name =
        {
         Пустой объект занимает 16 байт
         byte[] value =
         {
         Заголовок: 8 байт + 4 байта на длину массива
         byte 1 одна ячейка = 1 байт
         Выравнивание для кратности 8 байт
         }
         byte coder = 1 байт
         int hash = 4 байта
         boolean hashIsZero = 1 байт
         Выравнивание для кратности 8 байт
        }
        Один объект будет занимать 43 байта
        Создается очень много объектов User и GC начинает освобождать место в хипи.
         */
        for (int i = 0; i < 2500; i++) {
            new User(i, "N" + i);
        }
    }
}
