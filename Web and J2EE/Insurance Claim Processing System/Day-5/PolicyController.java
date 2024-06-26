import com.insurance.beans.Policy;
import com.insurance.services.PolicyService;
import com.insurance.validators.PolicyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/policy")
public class PolicyController {

    private final PolicyService policyService;
    private final PolicyValidator policyValidator;

    @Autowired
    public PolicyController(PolicyService policyService, PolicyValidator policyValidator) {
        this.policyService = policyService;
        this.policyValidator = policyValidator;
    }

    @GetMapping("/new")
    public String showPolicyForm(Model model) {
        model.addAttribute("policy", new Policy());
        return "policy-form";
    }

    @PostMapping("/save")
    public String savePolicy(@ModelAttribute("policy") Policy policy, BindingResult bindingResult, Model model) {
        policyValidator.validate(policy, bindingResult);
        if (bindingResult.hasErrors()) {
            return "policy-form";
        }
        policyService.savePolicy(policy);
        return "redirect:/policy/" + policy.getPolicyId();
    }

    @GetMapping("/{policyId}")
    public String showPolicyDetails(@PathVariable String policyId, Model model) {
        Policy policy = policyService.getPolicyById(policyId);
        if (policy == null) {
            return "error"; // Handle policy not found scenario
        }
        model.addAttribute("policy", policy);
        return "policy-details";
    }
}