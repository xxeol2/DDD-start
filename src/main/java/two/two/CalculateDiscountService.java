package two.two;

import java.util.Arrays;
import java.util.List;

public class CalculateDiscountService {

    private DroolsRuleEngine ruleEngine;

    public CalculateDiscountService() {
        ruleEngine = new DroolsRuleEngine();
    }

    public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
        Customer customer = findCustomer(customerId);

        // Drools에 특화된 코드: 연산결과를 받기 위해 추가한 타입
        MutableMoney money = new MutableMoney(0);

        // Drools에 특화된 코드: 룰에 필요한 데이터(지식)
        List<?> facts = Arrays.asList(customer, money);
        facts.addAll(orderLines);

        // Drools에 특화된 코드: Drools의 세션 이름
        ruleEngine.evaluate("discountCalculation", facts);

        return money.toImmutableMoney();
    }
}
