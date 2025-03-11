create table usr_usuario (
    usr_id BIGINT generated always as identity,
    usr_nome varchar(20) not null,
    usr_senha varchar(150) not null,
    primary key (usr_id),
    unique (usr_nome)
);

CREATE TABLE aut_autorizacao (
    aut_id BIGINT generated always as identity,
    aut_nome varchar(20) not null,
    primary key (aut_id),
    unique (aut_nome)
)

CREATE table uau_usuario_autorizacao (
    usr_id BIGINT not null,
    aut_id BIGINT not null,
    primary key (usr_id, aut_id),
    foreign key (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
    foreign key (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

CREATE TABLE ant_anotacao (
    ant_id BIGINT generated always as identity,
    ant_texto varchar(256) not null,
    ant_data_hora timestamp not null,
    ant_usr_id BIGINT not null,
    primary key (ant_id),
    foreign key (ant_usr_id) references usr_usuario(usr_id)
);