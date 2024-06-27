import com.insurance.policy.client.model.Claim;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "claim-service")
public interface ClaimClient {

    @GetMapping("/claims")
    List<Claim> getAllClaims();

    @GetMapping("/claims/{id}")
    Claim getClaimById(@PathVariable("id") Long id);
}
