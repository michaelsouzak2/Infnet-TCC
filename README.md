### Infnet-TCC
Sistema de Avaliação de Módulo - TCC da pós-graduação em Engenharia de Software com Java.
Tecnologias usadas: Spring MVC, Spring Security, JPA, Hibernate, Maven, Bootstrap e MySQL.

## Configurações
JPAConfiguration: No método dataSource, mude a senha do banco e a estratégia do hibernate de update para create.

## SQL:
create database sisam;
use sisam;

Levante o servidor, vincule o projeto ao servidor e execute a aplicação. 
Em seguida, abre o terminal do MySQL e insira os comandos para incluir o usuário base:

insert into permissao(nome) values ('ROLE_ADMINISTRADOR');
