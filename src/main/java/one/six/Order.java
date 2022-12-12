package one.six;

import java.util.List;
import one.five.OrderState;

public class Order {

    private OrderNo id;
    private Orderer orderer;
    private List<OrderLine> orderLines;
    private ShippingInfo shippingInfo;
    private OrderState orderState;
    private Money totalAmounts;


    public Order(Orderer orderer, List<OrderLine> orderLines, ShippingInfo shippingInfo,
            OrderState orderState) {
        setOrderer(orderer);
        setOrderLines(orderLines);
        // ...
    }

    private void setOrderer(Orderer orderer) {
        if (orderer == null) {
            throw new IllegalArgumentException("no orderer");
        }
        this.orderer = orderer;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts() {
        int sum = orderLines.stream()
                .mapToInt(x -> x.getAmounts())
                .sum();
        this.totalAmounts = new Money(sum);
    }

    public OrderNo getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != Order.class) {
            return false;
        }
        Order other = (Order) obj;
        if (this.id == null) {
            return false;
        }
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
        return result;
    }
}
