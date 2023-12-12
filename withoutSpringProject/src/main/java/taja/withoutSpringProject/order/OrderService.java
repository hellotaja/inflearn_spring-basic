package taja.withoutSpringProject.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
