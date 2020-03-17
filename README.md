### Este projeto está hospedado no Heroku, caso queira consumir as APIs, a URL base é [ https://module-bank.herokuapp.com/ ]

## Utilizei o Swagger para gerar a documentação das APIs deste projeto.
###### URL da documentação das APIs deste projeto: https://module-bank.herokuapp.com/swagger-ui.html#/

### Visão Geral das APIs
![Abaixo está a representação da documentação das APIs com o SWAGGER](https://github.com/muriloalvesdev/bank/blob/master/src/main/resources/swagger/swagger-documentation.png)


#### Descrição da API Available
##### Este endpoint é responsável por exibir o valor disponível de uma conta bancária informada no body da requisição. Caso a conta bancária não exista o endpoint vai enviar uma resposta assim: BANK NOT EXIST!.
![available](https://github.com/muriloalvesdev/bank/blob/master/src/main/resources/swagger/swagger-available.png)


#### Descrição da API authDebit
##### Este endpoint é responsável por receber uma requisição do módulo Holder, o mesmo deve efetuar o débito na conta do cliente ou diminuir o valor disponível para compra no cartão de crédito informado.
![auth-debit](https://github.com/muriloalvesdev/bank/blob/master/src/main/resources/swagger/debit-auth-swagger.png)


#### Descrição da API Deposit
##### Este endpoint representa um depósito em conta do cliente.
![deposit](https://github.com/muriloalvesdev/bank/blob/master/src/main/resources/swagger/swagger-deposit.png)


#### Descrição da API findByCode
##### Este endpoint é responsável por buscar um cartão cadastrado no banco de dados através do code-security informado.
![deposit](https://github.com/muriloalvesdev/bank/blob/master/src/main/resources/swagger/swagger-find-code.png)
