# E-verything API

Bem-vindo ao E-verything, este é um experimento para explorar o cadastro e gerenciamento de produtos no universo E-commerce.

**Este repositório é a API do projeto.** [Clique aqui para ver o repositório da web](https://github.com/Samukaii/e-verything-web)

## Visão Geral

A API do E-verything é responsável por fornecer os endpoints necessários para o cadastramento, gerenciamento e manipulação de produtos. Desenvolvida em Spring Boot, esta API oferece funcionalidades robustas para interagir com o sistema de forma eficiente e segura.

## Recursos Principais

- **Endpoints RESTful**: A API segue os princípios RESTful, fornecendo endpoints para realizar operações CRUD (Create, Read, Update, Delete) nos produtos e uma rota de recover.
- **Validação de Dados**: Realiza validação de entrada para garantir a integridade dos dados enviados para a API.

## Endpoints Principais

- `GET /products`: Retorna todos os produtos cadastrados.
- `GET /products/{id}`: Retorna um produto específico com o ID fornecido.
- `POST /products`: Cria um novo produto com os dados fornecidos.
- `PUT /products/{id}`: Atualiza os detalhes de um produto existente com o ID fornecido.
- `DELETE /products/{id}`: Exclui um produto com o ID fornecido.
- `PUT /products/{id}/recover`: Recupera um produto com o ID fornecido.

## Requisitos
- Java 17

## Configuração e Execução

Para configurar e executar a API do E-verything em seu ambiente local, siga estas etapas:

1. Clone este repositório para o seu ambiente local.
2. Certifique-se de ter o Java e o Maven instalados em sua máquina.
3. Importe o projeto para sua IDE preferida.
4. Configure as propriedades do banco de dados no arquivo `application.properties`.
5. Compile e execute o projeto.

## Contribuição

Se você está interessado em contribuir para o desenvolvimento da API do E-verything, sinta-se à vontade para explorar o código, abrir issues e enviar pull requests. Estou aberto a colaborações e sugestões!

## Contato

Para mais informações ou dúvidas sobre a API do E-verything, entre em contato através do email samuelalejandro.dev@gmail.com.

Obrigado por contribuir para o projeto. Estou ansioso para ver como podemos melhorar juntos!
