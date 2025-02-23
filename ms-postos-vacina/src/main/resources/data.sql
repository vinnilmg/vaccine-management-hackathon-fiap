INSERT INTO posto (nome, tipo_local, status)
VALUES ('UBS Jardim Vaz de Lima', 'UBS', 'ATIVO');

INSERT INTO funcionamento(dia_semana, horario_inicio, horario_fim, posto_id)
VALUES ('SEGUNDA', '07:00', '16:00', 1),
       ('TERCA', '08:00', '17:00', 1);

INSERT INTO endereco (rua, numero, complemento, bairro, cidade, estado, cep, posto_id)
VALUES ('Rua Hortência Pedro', '200', null, 'Jardim Vaz de Lima', 'São Paulo', 'SP', '05833140', 1);

INSERT INTO lote (numero, posto_vacinacao_id, vacina_id, validade, estoque)
values  ('1111', 1, 2, '2025-03-05', 20),
        ('2222', 1, 2, '2025-03-25', 10),
        ('123456', 2, 2, '2025-03-15', 3);
