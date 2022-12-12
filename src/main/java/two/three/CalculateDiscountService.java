package two.three;

import java.util.List;

public class CalculateDiscountService {

    private RuleDiscounter ruleDiscounter;
    private CustomerRepository customerRepository;

    public CalculateDiscountService(RuleDiscounter ruleDiscounter,
            CustomerRepository customerRepository) {
        this.ruleDiscounter = ruleDiscounter;
        this.customerRepository = customerRepository;
    }

    public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
        Customer customer = findCustomer(customerId);
        return ruleDiscounter.applyRules(customer, orderLines);
    }

    private Customer findCustomer(String customerId) {
        Customer customer = customerRepository.findById(customerId);
        if (customer == null)
            throw new NoCustomerException();
        return customer;
    }
}
