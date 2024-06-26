import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Policy {
    private String policyId;

    @NotEmpty(message = "Policy number is required")
    private String policyNumber;

    @NotEmpty(message = "Policyholder name is required")
    @Size(min = 2, max = 50, message = "Policyholder name must be between 2 and 50 characters")
    private String policyholderName;

    @NotNull(message = "Amount is required")
    private Double amount;

    public Policy() {}

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public void setPolicyholderName(String policyholderName) {
        this.policyholderName = policyholderName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}