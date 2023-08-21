

INSERT INTO ativo (ticker, quantidade_em_carteira, preco_medio, mes_entrada_na_carteira)
VALUES (1, 500, 16.56, current_timestamp());

INSERT INTO ativo (ticker, quantidade_em_carteira, preco_medio, mes_entrada_na_carteira)
VALUES (2, 300, 14.56, current_timestamp());

INSERT INTO ativo (ticker, quantidade_em_carteira, preco_medio, mes_entrada_na_carteira)
VALUES (3, 200, 15.58, current_timestamp());

INSERT INTO ativo (ticker, quantidade_em_carteira, preco_medio, mes_entrada_na_carteira)
VALUES (4, 100, 12.23, current_timestamp());

INSERT INTO ativo (ticker, quantidade_em_carteira, preco_medio, mes_entrada_na_carteira)
VALUES (2, 100, 14, current_timestamp());


INSERT INTO notacorretagem (numero_nota, nome_arquivo, quantidade, preco, data_da_nota, valor_da_operacao, total_da_operacao,taxa_de_liquidacao, emolumentos, corretagem,dedo_duro)
VALUES (121, 'clear_nota_1', 800,15.48, current_timestamp(),12148.00,12149.08,0.59,0.44,0.5,0 );

INSERT INTO notacorretagem (numero_nota, nome_arquivo, quantidade, preco, data_da_nota, valor_da_operacao, total_da_operacao,taxa_de_liquidacao, emolumentos, corretagem,dedo_duro)
VALUES (122, 'clear_nota_2', 300,14.08, current_timestamp(),4339,4340.08,0.59,0.44,0.5,0 );

INSERT INTO notacorretagem (numero_nota, nome_arquivo, quantidade, preco, data_da_nota, valor_da_operacao, total_da_operacao,taxa_de_liquidacao, emolumentos, corretagem,dedo_duro)
VALUES (123, 'clear_nota_3', 100,24.27, current_timestamp(),1400,1401.08,0.59,0.44,0.5,0 );

INSERT INTO notacorretagemativo (notacorretagem_numero_nota, ativo_ticker)
VALUES (121, 1);

INSERT INTO notacorretagemativo (notacorretagem_numero_nota, ativo_ticker)
VALUES (121, 2);

INSERT INTO notacorretagemativo (notacorretagem_numero_nota, ativo_ticker)
VALUES (122, 3);

INSERT INTO notacorretagemativo (notacorretagem_numero_nota, ativo_ticker)
VALUES (122, 4);

INSERT INTO notacorretagemativo (notacorretagem_numero_nota, ativo_ticker)
VALUES (123, 5);