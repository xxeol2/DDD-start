package two.three;

public interface RuleDiscounter {

    Money applyRules(Customer customer, List<OrderLine> orderLines);
}
