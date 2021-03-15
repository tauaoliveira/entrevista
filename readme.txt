Documentação API

Endpoints:

//// CLIENTE

- Cadastrar cliente
	.tipo: POST
	.url: http://localhost:8080/api/cliente
	.json: {
	"nome":"Taua Oliveira",
	"sexo":"M",
	"dataNascimento":"10/10/1995",
	"idade":"18",
	"cidade":"Salvador"
	}

- Alterar nome do cliente obs *obrigatório passar o id do cliente
	.tipo: PATCH
	.url: http://localhost:8080/api/cliente
	.json: {
	"id":1
	"nome":"Yuri",
	"sexo":"M",
	"dataNascimento":"10/10/1995",
	"idade":"18",
	"cidade":"Salvador"
	}

- Consultar cliente pelo id
	.tipo: GET
	.url: http://localhost:8080/api/cliente/find-by-id/{id}

- Consultar cliente pelo nome
	.tipo: GET
	.url: http://localhost:8080/api/cliente/find-by-nome/{nome}

- Deletar cliente pelo id
	.tipo: DELETE
	.url:http://localhost:8080/api/cliente/{id}

//// CIDADE

- Cadastrar cidade
	.tipo: POST
	.url:http://localhost:8080/api/cidade
	.json: {
	"nome":"Salvador",
	"estado":"Bahia"
	}

- Consultar cidade pelo nome
	tipo: GET
	url: http://localhost:8080/api/cidade/find-by-nome/{nome}

- Consultar cidade pelo nome do Estado
	tipo: GET
	url: http://localhost:8080/api/cidade/find-by-estado/{estado}	
