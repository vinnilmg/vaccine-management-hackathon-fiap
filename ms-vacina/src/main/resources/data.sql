INSERT INTO vacinas (nome, fabricante, tipo, doencas_previnidas, numero_doses, intervalo_doses, idade_minima, idade_maxima, contra_indicacoes, efeitos_colaterais)
VALUES
    ('BCG', 'Fiocruz', 'Bacteriana', 'Tuberculose', 1, 0, 0, 5, 'Não aplicar em imunossuprimidos', 'Dor local, febre baixa'),
    ('Hepatite B', 'Butantan', 'Viral', 'Hepatite B', 3, 30, 0, 18, 'Alergia a componentes da vacina', 'Dor no local, febre leve'),
    ('Tríplice Viral', 'Instituto Serum', 'Viral', 'Sarampo, Caxumba, Rubéola', 2, 30, 1, 29, 'Gestantes e imunodeprimidos', 'Febre, vermelhidão na pele'),
    ('DTP', 'Sanofi', 'Bacteriana', 'Difteria, Tétano, Coqueluche', 3, 60, 2, 7, 'Histórico de reações graves', 'Febre alta, irritabilidade'),
    ('Febre Amarela', 'Bio-Manguinhos', 'Viral', 'Febre Amarela', 1, 0, 9, 60, 'Gestantes, alérgicos a ovo', 'Dor muscular, febre leve');