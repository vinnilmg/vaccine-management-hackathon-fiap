INSERT INTO endereco (id, rua, numero, complemento, bairro, cidade, estado, cep)
VALUES (1, 'Rua Hortência Pedro', '200', null, 'Jardim Vaz de Lima', 'São Paulo', 'SP', '05833140');

INSERT INTO posto (id, nome, endereco_id, tipo_local, status)
VALUES (1, 'UBS Jardim Vaz de Lima', 1, 'UBS', 'ATIVO');

INSERT INTO funcionamento(id, dia_semana, horario_inicio, horario_fim, posto_id)
VALUES (1, 'SEGUNDA', '07:00', '16:00', 1),
       (2, 'TERCA', '08:00', '17:00', 1);