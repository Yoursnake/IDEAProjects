package test;

public class Test {

    public static class People {
        String name;
        int age;
        int money;

        public People(String name, int age, int money) {
            this.name = name;
            this.age = age;
            this.money = money;
        }
    }

    public static class RichPeople extends People {
        int money;

        public RichPeople(String name, int age, int money) {
            super(name, age, money);
        }
    }


    public static void main(String[] args) throws Exception {
        RichPeople[] rich = new RichPeople[10];
        People[] poor = rich;
        poor[0] = new People("John", 18, 100);
    }
}
