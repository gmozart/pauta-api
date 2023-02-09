CREATE TABLE pautas (

      id INT PRIMARY KEY NOT NULL,
      titulo VARCHAR(150) NOT NULL,
      descricao VARCHAR(250) NOT NULL,
      abertura DATETIME NOT NULL,
      fechamento DATETIME NOT NULL,
      sn_aprovada CHAR(1) DEFAULT 'N'

);

INSERT INTO pautas VALUES(1, 'Pauta para o aumento do salário.', 'O salário dos funcionários deve ter um aumento de 5%', '2023-02-8 19:50:23', '2023-02-08 19:50:23', 'N');
