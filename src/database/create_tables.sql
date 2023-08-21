create table ativo
(
    ticker varchar(20) primary key not null,
    quantidade_em_carteira int not null,
    preco_medio float not null,
    mes_entrada_na_carteira timestamp not null
);

create table darf
(
    cod_darf   int primary key not null,
    cod_do_imposto bigint not null,
    valor float not null
);

create table usuario
(
    cod_usuario   int primary key not null,
    nome varchar(30) not null,
    sobrenome varchar(255) not null,
    email varchar(50) not null,
    password varchar(255) not null
);

create table notaCorretagem
(
    numero_nota      bigint auto_increment primary key not null,
    nome_arquivo     varchar(30) not null,
    quantidade      float not null,
    preco           float not null,
    data_da_nota      timestamp not null,
    valor_da_operacao float not null,
    total_da_operacao float not null,
    taxa_de_liquidacao float not null,
    emolumentos     float not null,
    corretagem      float not null,
    dedo_duro        float not null
);

create table operacao
(
    cod_operacao   int primary key not null,
    quantidade bigint not null,
    preco float not null,
    data_da_operacao timestamp not null,
    valor_da_operacao float not null,
    total_da_operacao float not null,
    taxa_de_liquidacao float not null,
    emolumentos     float not null,
    corretagem      float not null,
    dedo_duro        float not null,

    numero_nota bigint ,
    cod_darf  int ,
    cod_usuario  int ,
    ticker  varchar(20) ,

    CONSTRAINT fk_ope_nota FOREIGN KEY (numero_nota) REFERENCES notaCorretagem (numero_nota),
    CONSTRAINT fk_ope_darf FOREIGN KEY (cod_darf) REFERENCES darf (cod_darf),
    CONSTRAINT fk_ope_usuario FOREIGN KEY (cod_usuario) REFERENCES usuario (cod_usuario),
    CONSTRAINT fk_ope_ativo FOREIGN KEY (ticker) REFERENCES ativo (ticker)
);

create table notacorretagemativo
(
    codigoNotaCorretagemAtivo bigint primary key not null,

    numero_nota bigint not null,
    ticker  varchar(20) not null,

    CONSTRAINT fk_notaCorretagemAtivo_ativo FOREIGN KEY (numero_nota) REFERENCES notaCorretagem (numero_nota),
    CONSTRAINT fk_notaCorretagemAtivo_notacorretagem FOREIGN KEY (ticker) REFERENCES ativo (ticker)
);

# create table notacorretagemativo
# (
#     numero_nota bigint not null,
#     ticker  varchar(20) not null,
#
#     PRIMARY KEY (numero_nota, ticker),
#     FOREIGN KEY (numero_nota) REFERENCES notaCorretagem(numero_nota),
#     FOREIGN KEY (ticker) REFERENCES ativo(ticker)
# );

#     CONSTRAINT fk_nota_corretagem_ativo_ativo FOREIGN KEY (numero_nota) REFERENCES notaCorretagem (numero_nota),
#     CONSTRAINT fk_nota_corretagem_ativo_nota_corretagem FOREIGN KEY (ticker) REFERENCES ativo (ticker)

# ALTER TABLE notaCorretagem ADD FOREIGN KEY (codigo_nota_corretagem_ativo) REFERENCES notacorretagemativo(codigo_nota_corretagem_ativo);
#
# ALTER TABLE ativo ADD FOREIGN KEY (codigo_nota_corretagem_ativo) REFERENCES notacorretagemativo(codigo_nota_corretagem_ativo);


-- ******************************************-----------------------------------****************************


-- create table ativo
-- (
--     ticker varchar(20) primary key not null,
--     quantidadeEmCarteira int not null,
--     precoMedio float not null,
--     mesEntradaNaCarteira timestamp not null,

--     codigoNotaCorretagemAtivo bigint not null
-- );

-- create table darf
-- (
--     codDarf   int primary key not null,
--     codDoImposto bigint not null,
--     valor float not null
-- );

-- create table usuario
-- (
--     codUsuario   int primary key not null,
--     nome varchar(30) not null,
--     sobrenome varchar(255) not null,
--     email varchar(50) not null,
--     password varchar(255) not null
-- );

-- create table notaCorretagem
-- (
--     numeroNota      bigint auto_increment primary key not null,
--     nomeArquivo     varchar(30) not null,
--     quantidade      float not null,
--     preco           float not null,
--     dataDaNota      timestamp not null,
--     valorDaOperacao float not null,
--     totalDaOperacao float not null,
--     taxaDeLiquidacao float not null,
--     emolumentos     float not null,
--     corretagem      float not null,
--     dedoDuro        float not null,

--     codigoNotaCorretagemAtivo bigint not null
-- );

-- create table operacao
-- (
--     quantidade bigint not null,
--     preco float not null,
--     dataDaOperacao timestamp not null,
--     valorDaOperacao float not null,
--     totalDaOperacao float not null,
--     taxaDeLiquidacao float not null,
--     emolumentos     float not null,
--     corretagem      float not null,
--     dedoDuro        float not null,

--     numeroNota bigint not null,
--     codDarf  int not null,
--     codUsuario  int not null,
--     ticker  varchar(20) not null,

--     CONSTRAINT fk_opeNota FOREIGN KEY (numeroNota) REFERENCES notaCorretagem (numeroNota),
--     CONSTRAINT fk_opeDarf FOREIGN KEY (codDarf) REFERENCES darf (codDarf),
--     CONSTRAINT fk_opeUsuario FOREIGN KEY (codUsuario) REFERENCES usuario (codUsuario),
--     CONSTRAINT fk_opeAtivo FOREIGN KEY (ticker) REFERENCES ativo (ticker)
-- );

-- create table notacorretagemativo
-- (
--     codigoNotaCorretagemAtivo bigint primary key not null,

--     numeroNota bigint not null,
--     ticker  varchar(20) not null,
    
--     CONSTRAINT fk_notaCorretagemAtivo_ativo FOREIGN KEY (numeroNota) REFERENCES notaCorretagem (numeroNota),
--     CONSTRAINT fk_notaCorretagemAtivo_notacorretagem FOREIGN KEY (ticker) REFERENCES ativo (ticker)
-- );

-- ALTER TABLE notaCorretagem ADD FOREIGN KEY (codigoNotaCorretagemAtivo) REFERENCES notacorretagemativo(codigoNotaCorretagemAtivo);

-- ALTER TABLE ativo ADD FOREIGN KEY (codigoNotaCorretagemAtivo) REFERENCES notacorretagemativo(codigoNotaCorretagemAtivo);
