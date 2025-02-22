INSERT INTO ENDERECO (rua, numero, bairro, complemento, cidade, estado, cep)
VALUES
('Rua das Flores', '123', 'Centro', 'Apto 101', 'São Paulo', 'SP', '01001-000'),
('Avenida Brasil', '456', 'Jardim América', 'Casa 2', 'Rio de Janeiro', 'RJ', '20040-000'),
('Rua dos Pinheiros', '789', 'Pinheiros', 'Sala 3', 'São Paulo', 'SP', '05422-000');



INSERT INTO USUARIOS (nome, cpf, email, telefone, endereco_id, data_nascimento, numero_carteirinha_sus, tipo, dependente_id)
VALUES
('João Silva', '123.456.789-00', 'joao.silva@example.com', '(11) 9999-8888', 1, '1980-05-15', '123456789012345', 'TITULAR', NULL),
('Maria Oliveira', '987.654.321-00', 'maria.oliveira@example.com', '(21) 8888-7777', 2, '1990-10-20', '987654321098765', 'TITULAR', NULL),
('Pedro Souza', '111.222.333-44', 'pedro.souza@example.com', '(11) 7777-6666', 3, '2005-03-25', '111222333444555', 'DEPENDENTE', 1),
('Ana Costa', '555.666.777-88', 'ana.costa@example.com', '(21) 6666-5555', 2, '2008-07-30', '555666777888999', 'DEPENDENTE', 2);


INSERT INTO MOVIMENTACAO_VACINA (sequence, vacina_id, data_aplicacao, local_id, usuario_id)
VALUES
(1, 101, '2023-10-01', 1, 1),
(2, 101, '2023-10-15', 1, 1),
(1, 102, '2023-10-05', 2, 2),
(1, 103, '2023-10-10', 3, 3),
(1, 104, '2023-10-20', 2, 4);