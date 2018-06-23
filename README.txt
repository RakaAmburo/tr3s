jwt:
The passwords are Bcrypted as password1, password2, password3 
for corresponding users user1, user2, user3. 

API to create new user
URL: http:localhost:8080/signup
Method: POST
Payload: { "username": "user4", "password": "password5", "age": 33, "salary": 898999 }

API to generate token
URL: http:localhost:8080/token/generate-token
Method: POST
Payload: { "username": "user4", "password": "password5" }

API to Fetch All User(ADMIN Role)
URL: http:localhost:8080/user
Method: GET