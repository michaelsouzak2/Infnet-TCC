--
-- Dumping data for table `tipocurso`
--

LOCK TABLES `tipocurso` WRITE;
/*!40000 ALTER TABLE `tipocurso` DISABLE KEYS */;
INSERT INTO `tipocurso` VALUES (4,'PÓS GRADUAÇÃO'),(5,'TÉCNICO'),(6,'GRADUAÇÃO');
/*!40000 ALTER TABLE `tipocurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (2,'JAVA PERSISTÊNCIA',4),(3,'JAVA WEB',4),(4,'MÉTRICAS',4),(5,'PROCESSOS AGÉIS',4),(6,'REDES',5),(7,'JAVA',4),(8,'ENGENHARIA DE SOFTWARE',4),(9,'PROJETO DE BLOCO',4);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bloco`
--

LOCK TABLES `bloco` WRITE;
/*!40000 ALTER TABLE `bloco` DISABLE KEYS */;
INSERT INTO `bloco` VALUES (2,'BLOCO A',8),(3,'BLOCO B',5),(4,'BLOCO C',2),(5,'BLOCO D',3);
/*!40000 ALTER TABLE `bloco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `modulo`
--

LOCK TABLES `modulo` WRITE;
/*!40000 ALTER TABLE `modulo` DISABLE KEYS */;
INSERT INTO `modulo` VALUES (2,'MIT EM ENGENHARIA DE SOFTWARE - JAVA',2),(3,'MIT EM ENGENHARIA DE SOFTWARE - .NET',2);
/*!40000 ALTER TABLE `modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (2,201701,'VELOSO'),(3,201702,'AQUINO'),(4,201703,'ELBERTH');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (3,'2017-12-16 00:00:00','2017-12-01 00:00:00','01 - SEXTA-FEIRA A NOITE (JAVA)',NULL,2,2),(4,'2017-12-18 00:00:00','2017-12-15 00:00:00','02 - SEXTA-FEIRA A NOITE',NULL,2,4);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (3,'abiliobrio@gmail.com',1,'ABILIO BEZERRA DO RIO','M',3),(4,'michael.ssantos@al.infnet.edu.br ',2,'MICHAEL SANTOS','M',3),(5,'raffamz@gmail.com',3,'RAFAEL','M',3);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `grupoquestoes`
--

LOCK TABLES `grupoquestoes` WRITE;
/*!40000 ALTER TABLE `grupoquestoes` DISABLE KEYS */;
INSERT INTO `grupoquestoes` VALUES (2,'Avaliação geral da Pós-Graduação'),(3,'Avaliação do professor no módulo'),(4,'Avaliação de conteúdo e infra-estrutura no módulo');
/*!40000 ALTER TABLE `grupoquestoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `questao`
--

LOCK TABLES `questao` WRITE;
/*!40000 ALTER TABLE `questao` DISABLE KEYS */;
INSERT INTO `questao` VALUES (2,NULL,'Até agora, o curso está atingindo as minhas expectativas.',2),(3,NULL,'Até agora, eu indicaria o curso para um amigo.',2),(4,NULL,'Até agora, o curso me parece voltado para as necessidades do mercado.',2),(5,NULL,'Até agora, a coordenação pedagógica parece comprometida com a\r\nqualidade do curso.',2),(6,NULL,'Até agora, minha turma parece proporcionar um networking relevante\r\npara a minha carreira.',2),(7,NULL,'Até agora, o atendimento de Secretaria que recebi está atingindo as',2),(8,NULL,'O professor contribuiu para o meu aprendizado.',3),(9,NULL,'O professor é atencioso e esteve disponível para tirar dúvidas.',3),(10,NULL,'O professor aproveitou bem o tempo em sala de aula.',3),(11,NULL,'O professor utilizou o Moodle e outros recursos didáticos para ajudar no\r\nmeu aprendizado.',3),(12,NULL,'O professor aproveitou bem os recursos da sala de aula.',3),(13,NULL,'Gostaria de cursar outros módulos com esse professor.',3),(14,NULL,'Eu adquiri as competências propostas para o módulo.',4),(15,NULL,'O módulo foi útil para o meu crescimento profissional.',4),(16,NULL,'A carga horária do módulo foi apropriada.',4),(17,NULL,'O acervo da biblioteca atendeu as necessidades desse módulo.',4),(18,NULL,'A configuração do(s) computadore(s) e equipamentos da sala de aula e a\r\nqualidade do suporte foi apropriada.',4),(19,NULL,'Você tem comentários e sugestões?',4);
/*!40000 ALTER TABLE `questao` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `permissao` WRITE;
/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
INSERT INTO `permissao` VALUES (1,'ROLE_ADMINISTRADOR'),(2,'ROLE_SECRETARIA');
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'adm@infnet.edu.br','Administrador','$2a$10$lt7pS7Kxxe5JfP.vjLNSyOXP11eHgh7RoPxo5fvvbMCZkCUss2DGu',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-17 22:04:01
