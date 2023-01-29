CREATE TABLE pautas (

      id INT PRIMARY KEY NOT NULL,
      titulo VARCHAR(150) NOT NULL,
      descricao VARCHAR(250) NOT NULL,
      abertura DATETIME NOT NULL,
      encerramento DATETIME NOT NULL

);

INSERT INTO pautas VALUES(1, 'Pauta para o aumento do salário.', 'O salário dos funcionários deve ter um aumento de 5%', '2023-01-29 15:10:23', '2023-01-29 15:20:23');

