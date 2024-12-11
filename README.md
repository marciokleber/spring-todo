> ## FindAll
> ```shell 
> curl -X GET http://localhost:8080/spring-todo/api/categoria | jq


> ## Create
> ```shell 
> curl -X POST  -H 'Content-Type: application/json' -d '{"nome": "categoria 1"}' http://localhost:8080/spring-todo/api/categoria | jq



> ## FindById
> ```shell
> curl -X GET http://localhost:8080/spring-todo/api/categoria/1 | jq



> ## update
> ```shell 
> curl -X PUT  -H 'Content-Type: application/json' -d '{"nome": "teste"}' http://localhost:8080/spring-todo/api/categoria/1 | jq


> ## Delete
> ```shell 
> curl -X DELETE http://localhost:8080/spring-todo/api/categoria/1 | jq
