package two.two;

import java.util.List;

public class DroolsRuleEngine {

    private KieContainer kContainer;

    public DroolsRuleEngine() {
        KieService ks = KieServices.Factory.get();
        kContainer = ks.getKieClasspathContainer();
    }

    public void evaluate(String sessionName, List<?> facts) {
        KieSession kSession = kContainer.newKieSession(sessionName);
        try {
            facts.forEach(x -> kSession.insert(x));
            kSession.fireAllRules();
        } finally {
            kSession.dispose();
        }
    }
}
