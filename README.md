## Infnet-TCC
Sistema de Avaliação de Módulo(SISAM) 
Trabalho de conclusão de curso da pós-graduação em Engenharia de Software com Java.
Tecnologias usadas: Spring MVC, Spring Security, JPA, Hibernate, Maven, Bootstrap e MySQL.

### Configurações:	
Em JPAConfiguration, alterar de update para create a propriedade hibernate.hbm2ddl.auto.
Senha criptografada com BCrypt. Equivale à 123456.

MySQL:
drop database sisam;
create database sisam;
use sisam;

Inclua a aplicação em um conteiner web, de preferência o Apache Tomcat 8.5. Após a primeira execução da aplicação, faça:

MySQL:
insert into permissao (nome) values ('ROLE_ADMINISTRADOR');
insert into usuario (email, nome, senha, permissao) values (
'adm@infnet.edu.br', 'Administrador', '$2a$10$lt7pS7Kxxe5JfP.vjLNSyOXP11eHgh7RoPxo5fvvbMCZkCUss2DGu', 'ROLE_ADMINISTRADOR');


