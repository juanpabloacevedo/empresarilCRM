CREATE SCHEMA nomina;
set schema 'nomina';

/*==============================================================*/
/* Table: HOJA_VIDA                                          */
/*==============================================================*/

CREATE TABLE nomina.HOJA_VIDA(
    DOCUMENTO        INT PRIMARY KEY,
    NOMBRE           VARCHAR(100) NOT NULL,
    APELLIDO         VARCHAR(100) NOT NULL,
    NACIMIENTO_FECHA DATE         NOT NULL,
    NACIMIENTO_LUGAR VARCHAR(100) NOT NULL,
    DIRECCION        VARCHAR(100) NOT NULL,
    TELEFONO         INT          NOT NULL

);

comment on column nomina.HOJA_VIDA.DOCUMENTO is 'Número de documento';
comment on column nomina.HOJA_VIDA.NOMBRE is 'Nombre de la persona';
comment on column nomina.HOJA_VIDA.APELLIDO is 'Apellidos de la persona';
comment on column nomina.HOJA_VIDA.NACIMIENTO_FECHA is 'Fecha de nacimiento';
comment on column nomina.HOJA_VIDA.NACIMIENTO_LUGAR is 'Lugar de nacimiento';
comment on column nomina.HOJA_VIDA.DIRECCION is 'Dirección de residencia';
comment on column nomina.HOJA_VIDA.TELEFONO is 'Número telefónico';


/*==============================================================*/
/* Table: DEPENDENCIA                                          */
/*==============================================================*/

CREATE TABLE nomina.DEPENDENCIA(
    CODIGO            SERIAL PRIMARY KEY,
    NOMBRE            VARCHAR(100) NOT NULL,
    DEPENDENCIA_PADRE INT,
    ESTADO            BOOLEAN      NOT NULL,

    FOREIGN KEY (DEPENDENCIA_PADRE) REFERENCES nomina.DEPENDENCIA (CODIGO)
);

comment on column nomina.DEPENDENCIA.CODIGO is 'Código';
comment on column nomina.DEPENDENCIA.NOMBRE is 'Nombre de la dependencia';
comment on column nomina.DEPENDENCIA.DEPENDENCIA_PADRE is 'Código dependencia padre';
comment on column nomina.DEPENDENCIA.ESTADO is 'Activo (1), inactivo (0)';

/*==============================================================*/
/* Table: CARGO                                          */
/*==============================================================*/

CREATE TABLE nomina.CARGO(
    CODIGO       SERIAL PRIMARY KEY,
    NOMBRE       VARCHAR(100) NOT NULL,
    FUNCION      VARCHAR(100) NOT NULL,
    COMPETENCIAS VARCHAR(100) NOT NULL

);

comment on column nomina.CARGO.CODIGO is 'Código del cargo';
comment on column nomina.CARGO.NOMBRE is 'Nombre del cargo';
comment on column nomina.CARGO.FUNCION is 'Funciones del cargo';
comment on column nomina.CARGO.COMPETENCIAS is 'Competencias';


/*==============================================================*/
/* Table: CONTRATO                                          */
/*==============================================================*/

CREATE TABLE nomina.CONTRATO(
    CODIGO          SERIAL PRIMARY KEY,
    FECHA_INICIO    DATE NOT NULL,
    FECHA_FIN       DATE NOT NULL,
    SALARIO         INT  NOT NULL,
    HOJA_VIDA_DOC   INT  NOT NULL,
    DEPENDENCIA_COD INT  NOT NULL,
    CARGO_COD       INT  NOT NULL,
    FOREIGN KEY (HOJA_VIDA_DOC) REFERENCES nomina.HOJA_VIDA (DOCUMENTO),
    FOREIGN KEY (DEPENDENCIA_COD) REFERENCES nomina.DEPENDENCIA (CODIGO),
    FOREIGN KEY (CARGO_COD) REFERENCES nomina.CARGO (CODIGO)


);


comment on column nomina.CONTRATO.CODIGO is 'Código del contrato';
comment on column nomina.CONTRATO.FECHA_INICIO is 'Fecha inicio';
comment on column nomina.CONTRATO.FECHA_FIN is 'Fecha fin';
comment on column nomina.CONTRATO.SALARIO is 'Salario';
comment on column nomina.CONTRATO.HOJA_VIDA_DOC is 'Documento de la hoja de vida';
comment on column nomina.CONTRATO.DEPENDENCIA_COD is 'Código de la dependencia';
comment on column nomina.CONTRATO.CARGO_COD is 'Código del cargo';


/*==============================================================*/
/* Table: CONCEPTO                                          */
/*==============================================================*/

CREATE TABLE nomina.CONCEPTO(
    CODIGO      SERIAL PRIMARY KEY,
    NOMBRE      VARCHAR(100) NOT NULL,
    DESCRIPCION VARCHAR(100) NOT NULL,
    TIPO        BOOLEAN      NOT NULL,
    FORMULA     VARCHAR(100) NOT NULL,
    ESTADO      BOOLEAN      NOT NULL

);

comment on column nomina.CONCEPTO.CODIGO is 'Código del concepto';
comment on column nomina.CONCEPTO.NOMBRE is 'Nombre del concepto';
comment on column nomina.CONCEPTO.DESCRIPCION is 'Descripcion concepto';
comment on column nomina.CONCEPTO.TIPO is 'Devengado(1), deducido (0)';
comment on column nomina.CONCEPTO.FORMULA is 'Formula de calculo';
comment on column nomina.CONCEPTO.ESTADO is 'Activo (1), inactivo (0)';


/*==============================================================*/
/* Table: PERIODO                                          */
/*==============================================================*/

CREATE TABLE nomina.PERIODO(
    CODIGO       SERIAL PRIMARY KEY,
    FECHA_INICIO DATE    NOT NULL,
    FECHA_FIN    DATE    NOT NULL,
    ESTADO       BOOLEAN NOT NULL
);

comment on column nomina.PERIODO.CODIGO is 'Código del periodo';
comment on column nomina.PERIODO.FECHA_FIN is 'Fecha final';
comment on column nomina.PERIODO.FECHA_INICIO is 'Fecha de inicio';
comment on column nomina.PERIODO.ESTADO is 'Activo (1), inactivo (0)';


/*==============================================================*/
/* Table: NOMINA                                          */
/*==============================================================*/

CREATE TABLE nomina.NOMINA(
    CONTRATO_COD   INT          NOT NULL,
    CONCEPTO_COD   INT          NOT NULL,
    PERIODO_COD    INT          NOT NULL,
    VALOR          INT          NOT NULL,
    USUARIO_INSERT VARCHAR(100) NOT NULL,
    FECHA_INSERT   DATE         NOT NULL,
    USUARIO_UPDATE VARCHAR(100) NOT NULL,
    FECHA_UPDATE   VARCHAR(100) NOT NULL,
    FOREIGN KEY (CONCEPTO_COD) REFERENCES nomina.CONCEPTO (CODIGO),
    FOREIGN KEY (CONTRATO_COD) REFERENCES nomina.CONTRATO (CODIGO),
    FOREIGN KEY (PERIODO_COD) REFERENCES nomina.PERIODO (CODIGO),
    PRIMARY KEY (CONTRATO_COD, CONCEPTO_COD, PERIODO_COD)

);

comment on column nomina.NOMINA.CONCEPTO_COD is 'Código del concepto';
comment on column nomina.NOMINA.CONTRATO_COD is 'Código del contrato';
comment on column nomina.NOMINA.PERIODO_COD is 'Código del periodo';
comment on column nomina.NOMINA.VALOR is 'Valor liquidado';
comment on column nomina.NOMINA.USUARIO_INSERT is 'Usuario que hizo insert';
comment on column nomina.NOMINA.FECHA_INSERT is 'Fecha que se hizo insert';
comment on column nomina.NOMINA.USUARIO_UPDATE is 'Usuario que hizo update';
comment on column nomina.NOMINA.FECHA_UPDATE is 'Fecha que se hizo update';