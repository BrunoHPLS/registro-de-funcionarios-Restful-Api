# registro-de-funcionarios-Restful-Api
Esta API tem como objetivo simular um simples registro de funcionários de uma empresa por meio de um CRUD.
- Utiliza JPA, H2 Database, Lombok e a Api do Spring starter web.

### Explicação das classes:
- model.Funcionario - Representa um funcionário comum da empresa, com um id,nome,salario,data de admissao, data de nascimento e profissao.

- repository.FuncionarioRepository - Um repositório JPA de Funcionários com as implementações de um crud básico e de outras 2 querys, uma para listar funcionarios por profissão e outra para listar todas as profissões adicionadas até então.

- controller.FuncionarioController - Um controlador que realiza os métodos GET,POST,PUT e DELETE sempre gerando e consumindo um JSON.

Por ser um projeto inicial que decidi criar para testar meus conhecimentos básicos em spring, está muito simples, porém irei tomar este como base para a ciação de outros neste famework.
