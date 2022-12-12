package two.three;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculateDiscountServiceTest {

    @Test
    public void noCustomer_thenExceptionShouldBeThrown() {
        // 테스트 목적의 대역 객체
        CustomerRepository stubRepo = mock(CustomerRepository.class);
        when(stubRepo.findById("noCustId")).thenReturn(null);

        RuleDiscounter stubRule = (cust, lines) -> null;

        // 대용 객체를 주입 받아 테스트 진행
        CalculateDiscountService calDiscSvc = new CalculateDiscountService(stubRepo, stubRule);
        assertThrows(NoCustomerException.class,
                () -> calDiscSvc.calculateDiscount(someLines, "noCustId"));
    }
}