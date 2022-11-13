package one.five;

import java.util.List;

public class Order {
	private List<OrderLine> orderLines;
	private ShippingInfo shippingInfo;
	private Money totalAmounts;
	private OrderState state;

	public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
		setOrderLines(orderLines);
		setShippingInfo(shippingInfo);
	}

	private void setOrderLines(List<OrderLine> orderLines) {
		verifyAtLeastOneOrMoreOrderLines(orderLines);
		this.orderLines = orderLines;
		calculateTotalAmounts();
	}

	private void setShippingInfo(ShippingInfo shippingInfo) {
		if (shippingInfo == null) {
			throw new IllegalArgumentException("no ShippingInfo");
		}
		this.shippingInfo = shippingInfo;
	}

	public void cancel() {
		verifyNotYetShipped();
		this.state = OrderState.CANCELED;
	}

	private void verifyNotYetShipped() {
		if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
			throw new IllegalStateException("already shipped");
		}
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
}
