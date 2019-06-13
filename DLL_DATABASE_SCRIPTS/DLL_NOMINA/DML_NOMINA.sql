INSERT INTO nomina.HOJA_VIDA(DOCUMENTO, NOMBRE, APELLIDO, NACIMIENTO_FECHA, NACIMIENTO_LUGAR, DIRECCION, TELEFONO)
values (10208, 'Laura', 'Castillo Cortes', '1956-02-16', 'Tunja', 'cra9#24-71', 30172);

INSERT INTO nomina.CARGO(CODIGO, NOMBRE, FUNCION, COMPETENCIAS)
VALUES (1020, 'Presidente', 'Administrar toda la empresa', 'Altruista y honesto');

INSERT INTO nomina.DEPENDENCIA(CODIGO, NOMBRE, DEPENDENCIA_PADRE, ESTADO)
VALUES (1021, 'Nomina', null, true);

INSERT INTO nomina.DEPENDENCIA(CODIGO, NOMBRE, DEPENDENCIA_PADRE, ESTADO)
VALUES (1022, 'Finanzas', 1021, true);

INSERT INTO nomina.CONTRATO(CODIGO, FECHA_INICIO, FECHA_FIN, SALARIO, HOJA_VIDA_DOC, DEPENDENCIA_COD, CARGO_COD)
VALUES (1, '2019-02-16', '2020-02-16', 1000000, 10208, 1022, 1020),
		(2, '2019-02-20', '2020-02-16', 2000000, 10208, 1022, 1020);

INSERT INTO nomina.PERIODO(CODIGO, FECHA_INICIO, FECHA_FIN, ESTADO)
VALUES (1, '2019-01-01', '2019-06-01', true);

INSERT INTO nomina.concepto (codigo, nombre, descripcion, tipo, formula, estado)
VALUES (1, 'pension', 'Aportes a pension', false, '-0.04', true),
       (2, 'salud', 'Aportes a salud', false, '-0.04', true),
       (3, 'hora_recargo_nocturno', '', true, '0.35', true),
       (4, 'hora_extra_diurna_dominical_festivo', '', true, '1', true),
       (5, 'hora_extra_nocturna', '', true, '0.75', true),
       (6, 'hora_extra_diurna', '', true, '0.25', true),
       (7, 'hora_extra_nocturna_dominical_festivo', '', true, '1.5', true),
       (8, 'auxilio_transporte', 'Ayuda transporte 2019', true, '97032', true);

INSERT INTO nomina.nomina (contrato_cod, concepto_cod, periodo_cod, valor, usuario_insert, fecha_insert, usuario_update, fecha_update)
VALUES (1, 1, 1, 30, 'LAURA', '2019-05-20', '', ''),
       (1, 2, 1, 30, 'Pedro Marco', '2019-05-20', '', ''),
       (1, 3, 1, 30, 'Carmensa', '2019-05-20', '', ''),
       (1, 4, 1, 30, 'LAURA', '2019-05-20', '', ''),
       (1, 5, 1, 30, 'Willian Bermudez', '2019-05-20', '', ''),
       (1, 6, 1, 30, 'LAURA', '2019-05-20', '', ''),
       (1, 7, 1, 30, 'LAURA', '2019-05-20', '', ''),
       (1, 8, 1, 100000, 'LAURA', '2019-02-12', 'LAURA', '2019-04-12'),
       (2, 1, 1, 30, 'LAURA', '2019-05-20', '', ''),
       (2, 2, 1, 30, 'Pedro Marco', '2019-05-20', '', ''),
       (2, 3, 1, 30, 'Carmensa', '2019-05-20', '', ''),
       (2, 4, 1, 30, 'LAURA', '2019-05-20', '', ''),
       (2, 5, 1, 30, 'Willian Bermudez', '2019-05-20', '', ''),
       (2, 6, 1, 30, 'LAURA', '2019-05-20', '', ''),
       (2, 7, 1, 30, 'LAURA', '2019-05-20', '', ''),
       (2, 8, 1, 100000, 'LAURA', '2019-02-12', 'LAURA', '2019-04-12');