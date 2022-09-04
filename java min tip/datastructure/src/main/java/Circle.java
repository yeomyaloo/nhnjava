public class Circle {
    int radius;
    String name;

    public Circle() {
    }

    public Circle(int radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    public double getArea(){
        return 3.14*radius*radius;
    }

    public static void main(String[] args) {
        Circle pizza = new Circle();
        pizza.radius = 10;
        pizza.name = "자바 피자";
        double javaPizzaSize = pizza.getArea();
        System.out.println(pizza.name+"의 면적은 "+javaPizzaSize);

        Circle pizza2 = new Circle(15, "생성자로 초기화 피자");
        double constructorPizza = pizza.getArea();
        System.out.println(pizza2.name+"의 면적은 "+constructorPizza);
    }

}
