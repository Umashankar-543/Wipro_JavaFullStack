import com.insurance.beans.Policy;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PolicyValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Policy.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Policy policy = (Policy) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "policyNumber", "NotEmpty.policy.policyNumber");
        if (policy.getAmount() == null || policy.getAmount() <= 0) {
            errors.rejectValue("amount", "Positive.policy.amount");
        }
    }
}