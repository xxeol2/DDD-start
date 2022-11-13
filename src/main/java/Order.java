public class Order {
	private OrderState state;
	private ShippingInfo shippingInfo;

	public void changeShippingInfo(ShippingInfo newShippingInfo) {
		if (!state.isShippingChangeable()) {
			throw new IllegalStateException("can't change shipping in " + state);
		}
		this.shippingInfo = newShippingInfo;
	}
	// ...

	public enum OrderState {
		PAYMENT_WAITING {
			public boolean isShippingChangeable() {
				return true;
			}
		},
		PREPARING {
			public boolean isShippingChangeable() {
				return true;
			}
		},
		SHIPPED, DELIVERING, DELIVERY_COMPLETED;

		public boolean isShippingChangeable() {
			return false;
		}
	}
}
