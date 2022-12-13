package two.four;

import one.six.ShippingInfo;

public class Order {

    // 주문 도메인 모델의 데이터
    private OrderNo number;
    private Orderer orderer;
    private ShippingInfo shippingInfo;

    // 도메인 모델 엔티티는 도메인 기능도 함께 제공
    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        checkShippingInfoChangable();
        setShippingInfo(newShippingInfo);
    }

    private void setShippingInfo(ShippingInfo newShippingInfo) {
        if (newShippingInfo == null) {
            throw new IllegalArgumentException();
        }
        // 밸류 타입의 데이터를 변경할 때는 새로운 객체로 교체한다.
        this.shippingInfo = newShippingInfo;
    }
}
