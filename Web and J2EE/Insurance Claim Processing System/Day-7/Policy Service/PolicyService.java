import com.insurance.policy.entity.Policy;
import com.insurance.policy.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public Policy getPolicyById(Long id) {
        return policyRepository.findById(id).orElse(null);
    }

    public Policy createPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public Policy updatePolicy(Long id, Policy policy) {
        Policy existingPolicy = policyRepository.findById(id).orElse(null);
        if (existingPolicy != null) {
            existingPolicy.setName(policy.getName());
            existingPolicy.setDescription(policy.getDescription());
            existingPolicy.setPremium(policy.getPremium());
            return policyRepository.save(existingPolicy);
        }
        return null;
    }

    public void deletePolicy(Long id) {
        policyRepository.deleteById(id);
    }
}
