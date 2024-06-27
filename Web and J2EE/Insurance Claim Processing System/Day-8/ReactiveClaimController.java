import com.insurance.claim.entity.Claim;
import com.insurance.claim.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/claims-reactive")
public class ReactiveClaimController {

    private final ClaimRepository claimRepository;

    @Autowired
    public ReactiveClaimController(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Claim> getClaimById(@PathVariable Long id) {
        return claimRepository.findById(id);
    }

    @PostMapping
    public Mono<Claim> addClaim(@RequestBody Claim claim) {
        return claimRepository.save(claim);
    }

    @PutMapping("/{id}")
    public Mono<Claim> updateClaim(@PathVariable Long id, @RequestBody Claim claim) {
        claim.setId(id);
        return claimRepository.save(claim);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteClaim(@PathVariable Long id) {
        return claimRepository.deleteById(id);
    }
}
