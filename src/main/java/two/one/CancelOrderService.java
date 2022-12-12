package two.one;

public class CancelOrderService {

    @Transactional
    public void cancelOrder(String orderId) {
        Order order = findOrderById(orderId);
        if (order == null) {
            throw new OrderNotFoundException(orderId);
        }
        // 주문 취소 로직을 직접 구현하지 않고 Order 객체(도메인 모델)에 취소 처리 위임
        order.cancel();
    }

}
