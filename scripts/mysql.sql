
-- MySql schema( SpringMult )
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `referencia` varchar(200) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `whatsapp` char(1) DEFAULT NULL,
  `datacriacao` date DEFAULT NULL,
  `dataatualizacao` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;