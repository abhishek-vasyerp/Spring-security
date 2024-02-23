
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<div>
	 <h2>Registration</h2>
    <form action="/public/addUser" method="post">
     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <label>Role:</label>
        <input type="radio" id="authority" name="authority" value="2" required>
        <label for="authority">User</label>

        <input type="radio" id="authority" name="authority" value="1" required>
        <label for="authority">Admin</label>

        <button type="submit">Sign Up</button>
    </form>
</div>
</body>
</html>