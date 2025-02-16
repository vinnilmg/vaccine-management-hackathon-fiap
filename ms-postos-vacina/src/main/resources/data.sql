INSERT INTO endereco (id, rua, numero, complemento, bairro, cidade, estado, cep)
VALUES ('1', 'Rua Hortência Pedro', '200', null, 'Jardim Vaz de Lima', 'São Paulo', 'SP', '05833140');

INSERT INTO funcionamento(id, dia_semana, horario_inicio, horario_fim)
VALUES ('1', 'SEGUNDA', '07:00', '16:00'),
       ('2', 'TERCA', '08:00', '15:00');

INSERT INTO posto (id, nome, endereco_id, tipo_local, funcionamento_id, status)
VALUES ('1', 'UBS Jardim Vaz de Lima', '1', 'UBS', '1', 'ATIVO');