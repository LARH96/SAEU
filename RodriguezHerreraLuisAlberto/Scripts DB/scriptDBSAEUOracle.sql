
CREATE DATABASE SAEU2
 
ALTER SESSION SET CURRENT_SCHEMA = SAEU2;

CREATE TABLE ActividadDeportiva
(
	id number(10)  NOT NULL,
	idPlanEntrenamiento number(10) NOT NULL,
	nombre nvarchar2(50) NOT NULL,
	explicacion nvarchar2(100) NOT NULL,
	duracion timestamp(7) NOT NULL,
	cantidadRepeticiones number(10) NOT NULL,
	log_estado number(1) NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra timestamp(0) NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita timestamp(0) NULL
);

CREATE SEQUENCE ActividadDeportiva_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER ActividadDeportiva_seq_tr
 BEFORE INSERT ON ActividadDeportiva FOR EACH ROW
 WHEN (NEW.id IS NULL)
BEGIN
 SELECT ActividadDeportiva_seq.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/

ALTER TABLE ActividadDeportiva ADD CONSTRAINT PK_ActividadDeportiva PRIMARY KEY (id);

CREATE TABLE AsignDeportistaPorInstructor
(
	idInstructor char(9) NOT NULL,
	idDeportista char(9) NOT NULL,
	log_estado number(1) NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra timestamp(0) NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita timestamp(0) NULL
);

ALTER TABLE AsignDeportistaPorInstructor ADD CONSTRAINT PK_AsignDeportistaPorInstructor PRIMARY KEY (idInstructor,idDeportista);

CREATE TABLE Barrio
(
	COD_PROVINCIA number(1, 0) NOT NULL,
	COD_CANTON number(2, 0) NOT NULL,
	COD_DISTRITO number(3, 0) NOT NULL,
	COD_BARRIO number(4, 0) NOT NULL,
	DSC_BARRIO nvarchar2(255) NULL,
	LOG_ACTIVO number(1, 0) NULL,
);

ALTER TABLE Barrio ADD CONSTRAINT PK_Barrio PRIMARY KEY (COD_PROVINCIA,COD_CANTON,COD_DISTRITO,COD_BARRIO);

CREATE TABLE Canton
(
	COD_PROVINCIA number(1, 0) NOT NULL,
	COD_CANTON number(2, 0) NOT NULL,
	DSC_CANTON nvarchar2(255) NULL,
	LOG_ACTIVO number(1, 0) NULL,
);

ALTER TABLE Canton ADD CONSTRAINT PK_Canton PRIMARY KEY (COD_PROVINCIA,COD_CANTON);

CREATE TABLE Contrasenna
(
	idUsuario char(9) NOT NULL,
	actual varchar2(20) NOT NULL,
	anterior varchar2(20) NULL,
	trasanterior varchar2(20) NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra timestamp(0) NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita timestamp(0) NULL
);

ALTER TABLE Contrasenna ADD CONSTRAINT PK_Contrasenna PRIMARY KEY (idUsuario);

CREATE TABLE CumplimActivDeportiva
(
	id number(10) NOT NULL,
	fecha timestamp(3) NOT NULL,
	cantidadRepeticiones number(10) NOT NULL,
	duracion timestamp(7) NOT NULL,
	observacion varchar2(50) NULL,
	observacionInstructor nchar(10) NULL,
	log_estado number(1) NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra timestamp(0) NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita timestamp(0) NULL
);

ALTER TABLE CumplimActivDeportiva ADD CONSTRAINT PK_CumplimActivDeportiva PRIMARY KEY (id);

CREATE TABLE Deportista
(
	id char(9) NOT NULL,
	idTipoIdentificacion char(1) NOT NULL,
	nombre nvarchar2(20) NOT NULL,
	apellido1 nvarchar2(20) NOT NULL,
	apellido2 nvarchar2(20) NOT NULL,
	correoElectronico varchar2(320) NOT NULL,
	idDisciplinaDeportiva varchar2(2) NOT NULL,
	peso binary_double NOT NULL,
	talla varchar2(2) NOT NULL,
	altura binary_double NOT NULL,
	objetivoDeporte1 varchar2(50) NOT NULL,
	objetivoDeporte2 varchar2(50) NULL,
	objetivoDeporte3 varchar2(50) NULL,
	log_estado number(1) NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra timestamp(0) NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita timestamp(0) NULL,
	pago number(1) NOT NULL
);

ALTER TABLE Deportista ADD CONSTRAINT PK_Deportista PRIMARY KEY (id);

CREATE TABLE Direccion
(
	id char(9) NOT NULL,
	idProvincia number(1, 0) NOT NULL,
	idCanton number(2, 0) NOT NULL,
	idDistrito number(3, 0) NOT NULL,
	idBarrio number(4, 0) NOT NULL,
	OtrasSennas varchar2(100) NOT NULL
);

ALTER TABLE Direccion ADD CONSTRAINT PK_Direccion PRIMARY KEY (id); 

CREATE TABLE DisciplinaDeportiva
(
	id varchar2(2) NOT NULL,
	descripcion varchar2(30) NOT NULL,
	log_estado number(1) NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra timestamp(0) NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita timestamp(0) NULL
);

ALTER TABLE DisciplinaDeportiva ADD CONSTRAINT PK_DisciplinaDeportiva PRIMARY KEY (id);

CREATE TABLE Distrito
(
	COD_PROVINCIA number(1, 0) NOT NULL,
	COD_CANTON number(2, 0) NOT NULL,
	COD_DISTRITO number(3, 0) NOT NULL,
	DSC_DISTRITO nvarchar2(255) NULL,
	LOG_ACTIVO number(1, 0) NULL
);

ALTER TABLE Distrito ADD CONSTRAINT PK_Distrito PRIMARY KEY (COD_PROVINCIA,COD_CANTON,COD_DISTRITO);

CREATE TABLE Instructor
(
	id char(9) NOT NULL,
	idTipoIdentificacion char(1) NOT NULL,
	nombre nvarchar2(20) NOT NULL,
	apellido1 nvarchar2(20) NOT NULL,
	apellido2 nvarchar2(20) NOT NULL,
	correoElectronico varchar2(320) NOT NULL,
	log_estado number(1) NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra timestamp(0) NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita timestamp(0) NULL
);
 
ALTER TABLE Instructor ADD CONSTRAINT PK_Instructor PRIMARY KEY (id);

CREATE TABLE InstructorDisciplinaDeportiva
(
	idInstructor char(9) NOT NULL,
	idDisciplinaDeportiva varchar2(2) NOT NULL,
	id number(10)  NOT NULL
);

CREATE SEQUENCE InstructorDisciplinaDeportiva_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER InstructorDisciplinaDeportiva_seq_tr
 BEFORE INSERT ON InstructorDisciplinaDeportiva FOR EACH ROW
 WHEN (NEW.id IS NULL)
BEGIN
 SELECT InstructorDisciplinaDeportiva_seq.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/

ALTER TABLE InstructorDisciplinaDeportiva ADD CONSTRAINT PK_InstructorDisciplinaDeportiva PRIMARY KEY
(idInstructor, idDisciplinaDeportiva, id);

CREATE TABLE Periodicidad
(
	id char(1) NOT NULL,
	descripcion varchar2(20) NOT NULL,
	log_estado number(1) NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra timestamp(0) NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita timestamp(0) NULL
);
ALTER TABLE Periodicidad ADD CONSTRAINT PK_Periodicidad PRIMARY KEY (id);

CREATE TABLE PlanEntrenamiento
(
	id number(10)  NOT NULL,
	idPeriodicidad char(1) NOT NULL,
	fechaInicio timestamp(3) NOT NULL,
	fechaFinal timestamp(3) NOT NULL,
	idDeportista char(9) NOT NULL,
	log_estado number(1) NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra timestamp(0) NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita timestamp(0) NULL
);

CREATE SEQUENCE PlanEntrenamiento_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER PlanEntrenamiento_seq_tr
 BEFORE INSERT ON PlanEntrenamiento FOR EACH ROW
 WHEN (NEW.id IS NULL)
BEGIN
 SELECT PlanEntrenamiento_seq.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
ALTER TABLE PlanEntrenamiento ADD CONSTRAINT PK_PlanEntrenamiento PRIMARY KEY (id)

CREATE TABLE Provincia
(
	COD_PROVINCIA number(1, 0) NOT NULL,
	DSC_CORTA_PROVINCIA nvarchar2(255) NULL,
	DSC_PROVINCIA nvarchar2(255) NULL,
	LOG_ACTIVO number(1, 0) NULL
);
ALTER TABLE Provincia ADD CONSTRAINT PK_Provincia PRIMARY KEY (COD_PROVINCIA);

CREATE TABLE Telefono
(
	id char(9) NOT NULL,
	numero number(10) NOT NULL,
	log_estado number(1) NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra timestamp(0) NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita timestamp(0) NULL
);
ALTER TABLE Telefono ADD CONSTRAINT PK_Telefono PRIMARY KEY (id);


CREATE TABLE TipoIdentificacion
(
	id char(1) NOT NULL,
	descripcion varchar2(9) NOT NULL,
	log_estado number(1) NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra timestamp(0) NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita timestamp(0) NULL
);
ALTER TABLE TipoIdentificacion ADD CONSTRAINT PK_TipoIdentificacion PRIMARY KEY (id);

CREATE TABLE TipoUsuario
(
	id char(1) NOT NULL,
	nombre varchar2(20) NOT NULL,
	log_estado number(1) NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra timestamp(0) NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita timestamp(0) NULL
);
ALTER TABLE TipoUsuario ADD CONSTRAINT PK_TipoUsuario PRIMARY KEY (id);

CREATE TABLE Usuario
(
	id char(9) NOT NULL,
	nombre nvarchar2(20) NOT NULL,
	idTipoPerfil char(1) NOT NULL,
	log_estado number(1) NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra timestamp(0) NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita timestamp(0) NULL
);
ALTER TABLE Usuario ADD CONSTRAINT PK_Usuario PRIMARY KEY (id);

ALTER TABLE ActividadDeportiva ADD CONSTRAINT FK_ActividadDeportiva_CumplimActivDeportiva FOREIGN KEY(id)
REFERENCES CumplimActivDeportiva (id);

ALTER TABLE ActividadDeportiva ADD CONSTRAINT FK_ActividadDeportiva_PlanEntrenamiento FOREIGN KEY(idPlanEntrenamiento)
REFERENCES PlanEntrenamiento (id);

ALTER TABLE AsignDeportistaPorInstructor ADD  CONSTRAINT FK_AsignDeportistaPorInstructor_Deportista FOREIGN KEY(idDeportista)
REFERENCES Deportista (id);

ALTER TABLE AsignDeportistaPorInstructor ADD  CONSTRAINT FK_AsignDeportistaPorInstructor_Instructor FOREIGN KEY(idInstructor)
REFERENCES Instructor (id);

ALTER TABLE Barrio ADD CONSTRAINT FK_Barrio_Distrito FOREIGN KEY(COD_PROVINCIA, COD_CANTON, COD_DISTRITO)
REFERENCES Distrito (COD_PROVINCIA, COD_CANTON, COD_DISTRITO);

ALTER TABLE Canton ADD  CONSTRAINT FK_Canton_Provincia FOREIGN KEY(COD_PROVINCIA)
REFERENCES Provincia (COD_PROVINCIA);

ALTER TABLE Deportista ADD  CONSTRAINT FK_Deportista_Direccion FOREIGN KEY(id)
REFERENCES Direccion (id);

ALTER TABLE Deportista ADD CONSTRAINT FK_Deportista_DisciplinaDeportiva FOREIGN KEY(idDisciplinaDeportiva)
REFERENCES DisciplinaDeportiva (id);

ALTER TABLE Deportista ADD  CONSTRAINT FK_Deportista_TipoIdentificacion FOREIGN KEY(idTipoIdentificacion)
REFERENCES TipoIdentificacion (id);

ALTER TABLE Direccion ADD  CONSTRAINT FK_Direccion_Barrio FOREIGN KEY(idProvincia, idCanton, idDistrito, idBarrio)
REFERENCES Barrio (COD_PROVINCIA, COD_CANTON, COD_DISTRITO, COD_BARRIO)

ALTER TABLE Distrito ADD  CONSTRAINT FK_Distrito_Canton FOREIGN KEY(COD_PROVINCIA, COD_CANTON)
REFERENCES Canton (COD_PROVINCIA, COD_CANTON)

ALTER TABLE Instructor ADD  CONSTRAINT FK_Instructor_Direccion FOREIGN KEY(id)
REFERENCES Direccion (id)

ALTER TABLE Instructor ADD  CONSTRAINT FK_Instructor_TipoIdentificacion FOREIGN KEY(idTipoIdentificacion)
REFERENCES TipoIdentificacion (id)

ALTER TABLE InstructorDisciplinaDeportiva ADD CONSTRAINT FK_InstructorDisciplinaDeportiva_DisciplinaDeportiva FOREIGN KEY(idDisciplinaDeportiva)
REFERENCES DisciplinaDeportiva (id)

ALTER TABLE InstructorDisciplinaDeportiva ADD  CONSTRAINT FK_InstructorDisciplinaDeportiva_Instructor FOREIGN KEY(idInstructor)
REFERENCES Instructor (id)

ALTER TABLE PlanEntrenamiento ADD  CONSTRAINT FK_PlanEntrenamiento_Deportista FOREIGN KEY(idDeportista)
REFERENCES Deportista (id)

ALTER TABLE PlanEntrenamiento ADD  CONSTRAINT FK_PlanEntrenamiento_Periodicidad FOREIGN KEY(idPeriodicidad)
REFERENCES Periodicidad (id)

ALTER TABLE Telefono ADD  CONSTRAINT FK_Telefono_Deportista FOREIGN KEY(id)
REFERENCES Deportista (id)

ALTER TABLE Telefono ADD  CONSTRAINT FK_Telefono_Instructor FOREIGN KEY(id)
REFERENCES Instructor (id)

ALTER TABLE Usuario  ADD  CONSTRAINT FK_Usuario_Contrasenna FOREIGN KEY(id)
REFERENCES Contrasenna (idUsuario)

ALTER TABLE Usuario ADD  CONSTRAINT FK_Usuario_TipoUsuario FOREIGN KEY(idTipoPerfil)
REFERENCES TipoUsuario (id)