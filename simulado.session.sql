create table tra_trabalho (
    tra_id bigint generated always as identity,
    tra_titulo varchar(100) not null unique,
    tra_data_hora_entrega timestamp not null,
    tra_descricao varchar(200),
    tra_grupo varchar(20) not null,
    tra_nota int,
    tra_justificativa varchar(100)
);

insert into tra_trabalho (tra_titulo, tra_data_hora_entrega, tra_grupo, tra_nota, tra_justificativa)
    values ('Teste 1', current_timestamp, 'Alpha', 6, 'Bom, mas falta conteúdo'),
            ('Teste 2', current_timestamp, 'Beta', null, 'Incompleto');