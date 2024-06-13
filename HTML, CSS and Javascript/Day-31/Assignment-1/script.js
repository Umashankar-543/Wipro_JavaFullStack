// User object definition 
const user = { 
    name: 'John Doe', 
    email: 'john.doe@example.com', 
    age: 21 
}; 
// Function to change the user's name 
function changeName() { 
    const newName = document.getElementById('new-name').value; 
    if (newName) { 
        user.name = newName; 
        updateUserInfo(); 
    } 
} 
// Function to update the user's email 
function updateEmail() { 
    const newEmail = document.getElementById('new-email').value; 
    if (newEmail) { 
        user.email = newEmail; 
        updateUserInfo(); 
    } 
} 
// Function to calculate the user's birth year 
function calculateBirthYear() { 
    const currentYear = new Date().getFullYear(); 
    return currentYear - user.age; 
} 
// Function to display the user's birth year 
function displayBirthYear() { 
    const birthYear = calculateBirthYear(); 
    document.getElementById('birth-year').textContent = `User's birth year is: ${birthYear}`; 
} 
// Function to update the displayed user info 
function updateUserInfo() { 
    document.getElementById('user-info').textContent = `Name: ${user.name}, Email: ${user.email}, Age: ${user.age}`; 
} 
// Initial display of user info 
updateUserInfo(); 