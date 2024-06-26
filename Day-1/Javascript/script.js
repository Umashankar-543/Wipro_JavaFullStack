document.addEventListener('DOMContentLoaded', function() {
    // Registration Page Logic
    const registrationForm = document.getElementById('registrationForm');
    if (registrationForm) {
        registrationForm.addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent form submission

            // Form validation logic
            const username = document.getElementById('username').value.trim();
            const email = document.getElementById('email').value.trim();
            const password = document.getElementById('password').value.trim();
            const confirmPassword = document.getElementById('confirmPassword').value.trim();

            // Example validation (you can customize as per your requirements)
            if (username === '') {
                showAlert('Please enter a username.');
                return;
            }
            if (email === '') {
                showValidationError('Please enter an email.', 'registration');
                return;
            }
            if (!isValidEmail(email)) {
                showValidationError('Please enter a valid email address.', 'registration');
                return;
            }
            if (password === '') {
                showAlert('Please enter a password.');
                return;
            }
            if (!isValidPasswordFormat(password)) {
                showValidationError('Password must meet the following criteria:\n' +
                                    '- At least 8 characters long\n' +
                                    '- Contains at least one uppercase letter\n' +
                                    '- Contains at least one lowercase letter\n' +
                                    '- Contains at least one number\n' +
                                    '- Contains at least one special character', 'registration');
                return;
            }
            if (password !== confirmPassword) {
                showValidationError('Passwords do not match.', 'registration');
                return;
            }

            // Simulate successful registration
            showSuccessPopup('Registration successful! <br><br> Redirecting to login page...');
            registrationForm.reset();
            setTimeout(function() {
                window.location.href = 'login.html';
            }, 1500);
        });

        const emailInput = document.getElementById('email');
        const emailValidationMessage = document.createElement('div');
        emailValidationMessage.classList.add('validation-message');
        emailInput.parentNode.insertBefore(emailValidationMessage, emailInput.nextSibling);

        emailInput.addEventListener('input', function() {
            const emailValue = emailInput.value.trim();
            if (emailValue === '') {
                emailValidationMessage.textContent = '';
            } else if (!isValidEmail(emailValue)) {
                emailValidationMessage.textContent = 'Please enter a valid email address.';
            } else {
                emailValidationMessage.textContent = '';
            }
        });
    }

    // Login Page Logic
    const loginForm = document.getElementById('loginForm');
    if (loginForm) {
        loginForm.addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent form submission

            // Form validation logic
            const email = document.getElementById('email').value.trim();
            const password = document.getElementById('password').value.trim();

            if (email === '') {
                showValidationError('Please enter an email.', 'login');
                return;
            }
            if (!isValidEmail(email)) {
                showValidationError('Please enter a valid email address.', 'login');
                return;
            }
            if (password === '') {
                showAlert('Please enter a password.');
                return;
            }
            if (!isValidPasswordFormat(password)) {
                showValidationError('Incorrect password format.', 'login');
                return;
            }

            // Simulate successful login
            // window.location.href = 'dashboard.html';
        });

        const loginEmailInput = document.getElementById('email');
        const loginEmailValidationMessage = document.createElement('div');
        loginEmailValidationMessage.classList.add('validation-message');
        loginEmailInput.parentNode.insertBefore(loginEmailValidationMessage, loginEmailInput.nextSibling);

        loginEmailInput.addEventListener('input', function() {
            const emailValue = loginEmailInput.value.trim();
            if (emailValue === '') {
                loginEmailValidationMessage.textContent = '';
            } else if (!isValidEmail(emailValue)) {
                loginEmailValidationMessage.textContent = 'Please enter a valid email address.';
            } else {
                loginEmailValidationMessage.textContent = '';
            }
        });
    }

    // Function to display a styled success popup
    function showSuccessPopup(message) {
        const successPopup = document.createElement('div');
        successPopup.classList.add('success-popup');
        successPopup.innerHTML = `<p>${message}</p>`;
        document.body.appendChild(successPopup);
        setTimeout(function() {
            document.body.removeChild(successPopup);
        }, 3000);
    }

    // Function to display an alert message
    function showAlert(message) {
        alert(message);
    }

    // Function to display a validation error message
    function showValidationError(message, formType) {
        const emailValidationMessage = formType === 'registration' ? document.querySelector('.validation-message') : document.querySelector('.validation-message');
        emailValidationMessage.textContent = message;
    }

    // Example function for email validation
    function isValidEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }

    // Example function for password validation
    function isValidPasswordFormat(password) {
        const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        return passwordRegex.test(password);
    }
});
