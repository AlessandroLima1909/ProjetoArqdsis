-----------------------------------------------------
CREATE DATABASE PROJETOARQDSIS;
USE PROJETOARQDSIS;
-----------------------------------------------------



CREATE TABLE CONJUNTOS(
	
id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
	
numero VARCHAR(10)
status VARCHAR(10)
);


-----------------------------------------------------

CREATE TABLE EMPRESAS(
	
id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
	
cnpj VARCHAR(14),
	
razaoSocial VARCHAR(1000),
	
horarioFuncionamento TIME,
	
temperaturaMaxima INTEGER,

horarioAr TIME, 	
idConjunto INTEGER,
	
FOREIGN KEY (idConjunto) REFERENCES CONJUNTOS(id)
);


-----------------------------------------------------
CREATE TABLE USUARIOS(
	
id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
	
login VARCHAR(200),
	
senha VARCHAR(32),
	
nome VARCHAR(1000),
	
cpf VARCHAR(14),
	
horarioTrabalho INTEGER,
	
tipoUsuario INTEGER,
	
idEmpresa INTEGER,
	
FOREIGN KEY (idEmpresa) REFERENCES EMPRESAS(id)
);



-----------------------------------------------------
CREATE TABLE ACESSOS (
	
id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
	
dataEntrada DATETIME,
	
dataSaida DATETIME,
	
idUsuario INTEGER,
	
FOREIGN KEY (idUsuario) REFERENCES USUARIOS(id)
);


-----------------------------------------------------

CREATE TABLE FUNCIONARIOS(
	
id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
	
horarioAcesso DATETIME,
	
permissaoTemperatura TINYINT,
	
idUsuario INTEGER,
	
FOREIGN KEY (idUsuario) REFERENCES USUARIOS(id)
);

-----------------------------------------------------