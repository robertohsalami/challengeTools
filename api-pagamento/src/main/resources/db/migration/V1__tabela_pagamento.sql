CREATE TABLE pagamento (
	id INTEGER NOT NULL,
	cartao varchar(255) NOT NULL,
	valor double(5,2) NOT NULL,
	data_hora varchar(255) NOT NULL,
	estabelecimento varchar(255) NOT NULL,
	nsu varchar(255) NOT NULL,
    codigo_autorizacao varchar(255) NOT NULL,
    status ENUM('AUTORIZADO','NEGADO', 'CANCELADO') NOT NULL,
    tipo_pagamento ENUM('AVISTA','PARCELADO_LOJA', 'PARCELADO_EMISSOR') NOT NULL,
    parcelas int2 NOT NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (id)
);
