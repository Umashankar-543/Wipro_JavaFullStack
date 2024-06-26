import com.insurance.beans.Policy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PolicyService {
    private final Map<String, Policy> policyMap = new HashMap<>();

    public void savePolicy(Policy policy) {
        policy.setPolicyId("POL" + (int) (Math.random() * 10000));
        policyMap.put(policy.getPolicyId(), policy);
    }

    public Policy getPolicyById(String policyId) {
        return policyMap.get(policyId);
    }
}