# Projeto-Aluno-online

# Visão Geral

Este projeto é uma API RESTful desenvolvida com Spring Boot e PostgreSQL, que gerencia entidades como "Aluno". A aplicação utiliza uma arquitetura limpa e organizada para facilitar o desenvolvimento, manutenção e escalabilidade.

---

# Tecnologias Utilizadas

- *Java* com Spring Boot: Desenvolvimento do backend.
- *PostgreSQL*: Banco de dados relacional.
- *Visual Studio Code*: IDE utilizada para codificação em Java.
- *DBeaver*: Ferramenta para gerenciar o banco de dados.
- *Insomnia*: Simulação de requisições HTTP.

No Spring Boot, a estrutura da API é organizada em quatro pacotes principais:

1. *Controller*: Recebe as requisições do frontend, define os endpoints e repassa os dados para outras camadas. Anotações principais:
   - `@RestController`: Identifica como controlador REST.
   - `@RequestMapping`: Define o endpoint, como `/alunos`.
   - `@RequestBody`: Converte o JSON recebido em um objeto Java.
   Exemplo: O método `criarAluno` cria um novo registro.

2. *Service*: Liga o Controller ao Repository, realiza validações e aplica regras de negócio. Usa a anotação `@Service` e possui métodos como `criarAluno` para processar dados e enviá-los ao Repository.

3. *Repository*: Gerencia as interações com o banco de dados, utilizando `@Repository` e `JpaRepository` para implementar operações CRUD.

4. *Model*: Representa as entidades do banco de dados, como a classe `Aluno`. Anotações importantes:
   - `@Entity`: Define a classe como uma tabela.
   - `@NoArgsConstructor` e `@AllArgsConstructor`: Facilitam a criação de objetos.

No *Insomnia*, simulamos requisições como se fossem do frontend. Para o método `POST` no endpoint `/alunos`, enviamos um JSON com informações como nome, e-mail e CPF, que são processadas pelo Controller.
