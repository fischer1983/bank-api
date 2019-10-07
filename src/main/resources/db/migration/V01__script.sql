create table pessoa (
  cpf_cnpj varchar(14) not null primary key
  ,tipo_pessoa varchar(2)  not null
  ,score integer default 0
);

create table cartao_credito (
    id serial not null primary key
    ,limite numeric(8,2) not null default 0
);

create table conta (
    numero varchar(6) not null primary key
    ,agencia varchar(6) not null
    ,limite_cheque_especial numeric(8,2)
    ,tipo_conta varchar(1) not null
    ,cpf_cnpj_pessoa varchar(14) not null
    ,id_cartao_credito integer

    ,constraint fk_conta__id_pessoa foreign key (cpf_cnpj_pessoa) references pessoa(cpf_cnpj)
    ,constraint fk_conta__id_cartao foreign key (id_cartao_credito) references cartao_credito(id)
);

create table parametro(
  chave varchar(100) not null primary key
  ,valor varchar(100) not null
);

create table faixa_limite(
  score_min integer not null
  ,score_max  integer not null

  ,limite_cheque_especial numeric(8,2)
  ,limite_cartao_credito numeric(8,2)

  ,primary key(score_min, score_max)
  ,unique (score_min)
  ,unique (score_max)
);


insert into parametro (chave, valor) values ('AGENCIA', '1005');

insert into faixa_limite (score_min, score_max, limite_cheque_especial, limite_cartao_credito) values (2, 5, 1000, 200);
insert into faixa_limite (score_min, score_max, limite_cheque_especial, limite_cartao_credito) values (6, 8, 2000, 2000);
insert into faixa_limite (score_min, score_max, limite_cheque_especial, limite_cartao_credito) values (9, 9, 5000, 15000);
