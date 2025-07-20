# Users Application


### user list
```sh
curl -X GET -s http://localhost:8080/users | jq .
```

### create user
```sh
curl -X POST -s -H "Content-Type: application/json" -d '{"email": "nayely@email.com", "name": "Nayely"}' http://localhost:8080/users | jq .
```

### get user by email
```sh
curl -X GET -s http://localhost:8080/users/ximena@email.com | jq .
```

### delete user by email
```sh
curl -X DELETE  http://localhost:8080/users/ximena@email.com
```

