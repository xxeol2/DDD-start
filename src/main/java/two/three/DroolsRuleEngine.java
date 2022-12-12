package two.three;

import java.util.List;

public class DroolsRuleEngine implements RuleDiscounter {

    private KieContainer kContainer;

    public DroolsRuleEngine() {
        KieService ks = KieServices.Factory.get();
        kContainer = ks.getKieClasspathContainer();
    }

    @Override
    public Money applyRules(Customer customer, List<OrderLine> orderLines) {
        KieSession kSession = kContainer.newKieSession(sessionName);
        try {
            // ... 코드 생략
            kSession.fireAllRules();
        } finally {
            kSession.dispose();
        }
        return money.toImmutableMoney();
    }
}
