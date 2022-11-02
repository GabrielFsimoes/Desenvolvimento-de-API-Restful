CREATE TABLE categoria (
id_categoria serial PRIMARY KEY, 
nome varchar(30)NOT NULL, 
descricao varchar(200));

CREATE TABLE livro (
id_livro serial PRIMARY KEY, 
titulo varchar (40) NOT null,
id_categoria int,
FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria),
isbn varchar(20) NOT NULL UNIQUE, 
data_publicacao date);