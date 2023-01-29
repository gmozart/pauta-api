CREATE TABLE PUBLIC.pauta (

      id INT PRIMARY KEY NOT NULL,
      titulo VARCHAR(150) NOT NULL,
      descricao VARCHAR(250) NOT NULL,
      abertura TIMESTAMP NOT NULL,
      encerramento TIMESTAMP NOT NULL

);

INSERT INTO pauta VALUES(1, 'Pauta para o aumento do salário.', 'O salário dos funcionários deve ter um aumento de 5%', '2023-01-29 15:10:23', '2023-01-29 15:20:23');

