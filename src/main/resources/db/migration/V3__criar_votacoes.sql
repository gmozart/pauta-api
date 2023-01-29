CREATE TABLE votacoes (
      id  INT PRIMARY KEY NOT NULL,
      pauta_id INT NOT NULL,
      associado_id INT NOT NULL,
      voto BOOLEAN NOT NULL,
      FOREIGN KEY (pauta_id) REFERENCES pautas(id),
      FOREIGN KEY (associado_id) REFERENCES associados(id)
);


  INSERT INTO votacoes VALUES(1, 1, 1, TRUE);
  INSERT INTO votacoes VALUES(2, 1, 2, TRUE);
  INSERT INTO votacoes VALUES(3, 1, 3, TRUE);
  INSERT INTO votacoes VALUES(4, 1, 4, FALSE);
  INSERT INTO votacoes VALUES(5, 1, 5, FALSE);