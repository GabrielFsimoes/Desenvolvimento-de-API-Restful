create table clientes(
id serial, nome varchar(60) not null, cpf varchar(11) not null, email varchar(50), 
data_nasc date, primary key(id)
);

insert into clientes(nome, cpf, email, data_nasc) values 
('robs', '12345678901', 'robs@mail.com', '03-17-1999');