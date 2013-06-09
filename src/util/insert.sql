INSERT INTO SIAC.Version (Version) 
	VALUES ('0,9');
INSERT INTO SIAC.Empresas (nit, direccion, nivel, nombre, telefono, Empresas_nit) 
	VALUES (12345, 'Calle 25C #102-26', 'ADMINISTRADORA', 'UnalSoft', '3214567892', NULL);
INSERT INTO SIAC.Usuarios (dni, clave, correo, nombre, nombreDeUsuario, rol, empresasNIT) 
	VALUES (1030300300, '27703c8f150ac4bb0a3a83a7857353af', 'provider@unalsoft.un', 'Provider', 'Provider', 'PROVEEDOR_DE_TI', 12345);
INSERT INTO SIAC.Empresas (nit, direccion, nivel, nombre, telefono, Empresas_nit) 
	VALUES (56789, 'Calle Falsa 123', 'DISTRIBUIDORA', 'Sindrome S.A.S', '3012345678', NULL);
INSERT INTO SIAC.Usuarios (dni, clave, correo, nombre, nombreDeUsuario, rol, empresasNIT) 
	VALUES (1040400400, '35967052d1a3751e5507f6c621528689', 'firstadministrator@unalsoft.un', 'First Administrator', 'FirstAdministrator', 'PRIMER_ADMINISTRADOR', 56789);
INSERT INTO SIAC.Usuarios (dni, clave, correo, nombre, nombreDeUsuario, rol, empresasNIT) 
	VALUES (1050500500, '7b7bc2512ee1fedcd76bdc68926d4f7b', 'administrator@unalsoft.un', 'Administrator', 'Administrator', 'ADMINISTRADOR', 56789);
INSERT INTO SIAC.Usuarios (dni, clave, correo, nombre, nombreDeUsuario, rol, empresasNIT) 
	VALUES (1060600600, '66c1b4c7f3dc385b68a9fa903ccd016d', 'query@unalsoft.un', 'Query', 'Query', 'CONSULTA', 56789);
INSERT INTO SIAC.Usuarios (dni, clave, correo, nombre, nombreDeUsuario, rol, empresasNIT) 
	VALUES (1020200200, '6311ae17c1ee52b36e68aaf4ad066387', 'other@unalsoft.un', 'Other', 'Other', 'OTRO', 56789);