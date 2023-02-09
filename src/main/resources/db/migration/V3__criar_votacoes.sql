CREATE TABLE votacoes (
      id INT PRIMARY KEY NOT NULL,
      pauta_id INT NOT NULL,
      associado_id INT NOT NULL,
      sn_voto CHAR(1) NOT NULL,
      CHECK (sn_voto in ('S','N')),
      FOREIGN KEY (pauta_id) REFERENCES pautas(id),
      FOREIGN KEY (associado_id) REFERENCES associados(id)
);


  INSERT INTO votacoes VALUES(1, 1, 1, 'S');
  INSERT INTO votacoes VALUES(2, 1, 2, 'S');
  INSERT INTO votacoes VALUES(3, 1, 3, 'S');
  INSERT INTO votacoes VALUES(4, 1, 4, 'N');
  INSERT INTO votacoes VALUES(5, 1, 5, 'N');