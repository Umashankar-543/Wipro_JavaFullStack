<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.Claim"%>
<%
    Claim claim = (Claim) request.getAttribute("claim");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Claim Confirmation</title>
</head>
<body>
    <h2>Claim Confirmation</h2>
    <p>Your claim has been submitted successfully!</p>
    <p>Claim ID: <%= claim.getClaimId() %></p>
    <p>Policy Number: <%= claim.getPolicyNumber() %></p>
    <p>Claim Type: <%= claim.getClaimType() %></p>
    <p>Description: <%= claim.getDescription() %></p>
    <p>Amount: <%= claim.getAmount() %></p>
</body>
</html>