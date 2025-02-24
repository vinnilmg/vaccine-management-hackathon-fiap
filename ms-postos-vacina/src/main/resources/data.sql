INSERT INTO posto (nome, tipo_local, status)
VALUES ('UBS Jardim Vaz de Lima', 'UBS', 'ATIVO'),
       ('Hospital Pirituba', 'HOSPITAL', 'ATIVO'),
       ('UBS Santo Amaro', 'UBS', 'ATIVO'),
       ('UBS SP', 'UBS', 'ATIVO'),
       ('UBS Mooca', 'UBS', 'ATIVO');

INSERT INTO funcionamento(dia_semana, horario_inicio, horario_fim, posto_id)
VALUES ('SEGUNDA', '07:00', '16:00', 1),
       ('TERCA', '08:00', '17:00', 1),
       ('SEGUNDA', '07:00', '16:00', 2),
       ('TERCA', '08:00', '17:00', 2),
       ('QUARTA', '08:00', '17:00', 2),
       ('QUINTA', '08:00', '17:00', 2),
       ('SEXTA', '08:00', '17:00', 2),
       ('SEGUNDA', '07:00', '16:00', 3),
       ('TERCA', '08:00', '17:00', 3),
       ('QUARTA', '08:00', '17:00', 3),
       ('QUINTA', '08:00', '17:00', 3),
       ('SEXTA', '08:00', '17:00', 3),
       ('SEGUNDA', '07:00', '16:00', 4),
       ('TERCA', '08:00', '17:00', 4),
       ('QUARTA', '08:00', '17:00', 4),
       ('QUINTA', '08:00', '17:00', 4),
       ('SEXTA', '08:00', '17:00', 4),
       ('SEGUNDA', '07:00', '16:00', 5),
       ('TERCA', '08:00', '17:00', 5);

INSERT INTO endereco (rua, numero, complemento, bairro, cidade, estado, cep, posto_id)
VALUES ('Rua Hortência Pedro', '200', null, 'Jardim Vaz de Lima', 'São Paulo', 'SP', '05833140', 1);

INSERT INTO lote (numero, posto_vacinacao_id, vacina_id, validade, estoque)
VALUES  ('1111', 2, 2, '2026-03-05', 20),
        ('1111', 1, 1, '2026-03-05', 1),
        ('2222', 1, 2, '2026-03-25', 10),
        ('123456', 2, 3, '2026-03-15', 3);
