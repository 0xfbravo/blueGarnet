/* Criação da Tabela de Login*/
create table bg_informacoesLogin(
	Usuario varchar(255),
	Senha varchar(255),
	Permissao tinyint,
)

/* Criação da Tabela Empresas (informações Extra-Alterdata)*/
create table bg_informacoesExtrasEmpresas(
	NumEmpresa int,
);

/*
	Criação da Tabela de Cobranças Extras
		:: O programa buscará todas as Cobranças Extras e somará os valores definidos no ENUM 
*/
create table bg_cobrancasExtras(
	NumEmpresa int,
	CodCobranca tinyint,
);

/*
	Criação da Tabela de Relação de E-mails Clientes
		:: O programa através do código do cliente buscará todos os e-mails cadastrados.
			obs.: Foi definido um máximo de 3 e-mail's por clientes.
*/
create table bg_relacaoEmailCliente(
	NumEmpresa int,
	Email1 varchar(255),
	Email2 varchar(255),
	Email3 varchar(255),
);