import beans.Claim;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/submitClaim")
public class ClaimServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String policyNumber = request.getParameter("policyNumber");
        String claimType = request.getParameter("claimType");
        String description = request.getParameter("description");
        double amount = Double.parseDouble(request.getParameter("amount"));

        Claim claim = new Claim();
        claim.setPolicyNumber(policyNumber);
        claim.setClaimType(claimType);
        claim.setDescription(description);
        claim.setAmount(amount);

        // Simulate saving the claim, in reality, this should be saved in a database
        String claimId = "CLM" + (int) (Math.random() * 10000);
        claim.setClaimId(claimId);

        request.setAttribute("claim", claim);
        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
    }
}