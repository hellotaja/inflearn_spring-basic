package taja.withoutSpringProject.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
        this.price = price; //여기가 문제! 싱글톤 객체는 무상태(stateless)로 설계해야 한다!
    }

    public int getPrice() {
        return price;
    }
}
