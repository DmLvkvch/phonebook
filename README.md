# phonebook
Test task DINS

# RUN
## docker-compose build
## docker-compose up


# http://localhost:8081/users

[{"name":"Dima","phoneBook":[{"id":2,"phoneNumber":"1231","name":"qeqwe"},{"id":3,"phoneNumber":"12341","name":"qeqwe"},{"id":4,"phoneNumber":"1235","name":"qeqwe"}]}]

# http://localhost:8081/user/1

{"name":"Dima","phoneBook":[{"id":2,"phoneNumber":"1231","name":"qeqwe"},{"id":3,"phoneNumber":"12341","name":"qeqwe"},{"id":4,"phoneNumber":"1235","name":"qeqwe"}],"_links":{"self":{"href":"http://localhost:8080/user/1"},"users":{"href":"http://localhost:8080/users"}}}

# http://localhost:8081/user/1/notes

[{"id":2,"phoneNumber":"1231","name":"qeqwe"},{"id":3,"phoneNumber":"12341","name":"qeqwe"},{"id":4,"phoneNumber":"1235","name":"qeqwe"}]

# http://localhost:8080/user/1/note/2

{"id":2,"phoneNumber":"1231","name":"qeqwe","_links":{"self":{"href":"http://localhost:8080/user/1/note/2"},"user_notes":{"href":"http://localhost:8080/user/1/notes"}}}
