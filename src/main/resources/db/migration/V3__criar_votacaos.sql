CREATE TABLE votacaos (
      id  INT PRIMARY KEY NOT NULL,
      pauta_id INT NOT NULL,
      associado_id INT NOT NULL,
      voto BOOLEAN NOT NULL,
      FOREIGN KEY (pauta_id) REFERENCES pautas(id),
      FOREIGN KEY (associado_id) REFERENCES associados(id)
);


  INSERT INTO votacaos VALUES(1, 1, 1, TRUE);
  INSERT INTO votacaos VALUES(2, 1, 2, TRUE);
  INSERT INTO votacaos VALUES(3, 1, 3, TRUE);
  INSERT INTO votacaos VALUES(4, 1, 4, FALSE);
  INSERT INTO votacaos VALUES(5, 1, 5, FALSE);