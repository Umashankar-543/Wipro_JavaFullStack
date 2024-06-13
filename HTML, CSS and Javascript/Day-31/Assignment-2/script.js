// Function to validate the email format 
function isValidEmail(email) { 
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; 
    return emailRegex.test(email); 
} 
// Function to validate email and display a message 
function validateEmail() { 
    const newEmail = document.getElementById('new-email').value; 
    const emailError = document.getElementById('email-error'); 
    if (isValidEmail(newEmail)) { 
        emailError.textContent = 'Email is valid.'; 
        emailError.style.color = 'green'; 
    } else { 
        emailError.textContent = 'Please enter a valid email address.'; 
        emailError.style.color = 'red'; 
    } 
} 