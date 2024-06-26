<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Submit Claim</title>
</head>
<body>
    <h2>Submit Claim</h2>
    <form action="submitClaim" method="post">
        <label for="policyNumber">Policy Number:</label>
        <input type="text" id="policyNumber" name="policyNumber" required><br><br>

        <label for="claimType">Claim Type:</label>
        <input type="text" id="claimType" name="claimType" required><br><br>

        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea><br><br>

        <label for="amount">Amount:</label>
        <input type="number" step="0.01" id="amount" name="amount" required><br><br>

        <button type="submit">Submit Claim</button>
    </form>
</body>
</html>