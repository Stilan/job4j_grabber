package ru.job4j.ood.lsp;

/**
 * 3. Инварианты (Invariants) — все условия базового класса - также должны быть сохранены и в подклассе
 * класс Attraction имеет метод для проверки, что User может пройти на аттракцион, если новый класс NewAttraction наследник
 * Attraction где забыли сделать проверку на возраст и вес
 */
public class Attraction {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        validate(user);
        this.user = user;
    }

    public Attraction(User user) {
        validate(user);
        this.user = user;
    }
    protected void validate(User user) {
        if (user.getAge() > 18 && user.getWeight() < 120) {
            System.out.println("OK");
        }
    }

     static class NewAttraction extends Attraction {
        private   User user;
        public NewAttraction(User user) {
            super(user);
        }
        @Override
        public void setUser(User user) {
            this.user = user;
            System.out.println("ok");
        }
    }

    public static void main(String[] args) {
        Attraction attraction = new NewAttraction(new User(12, 900));
       attraction.setUser(new User(12, 433));
    }
}
