create table flexiones(
	id_flex 
	fecha_test date;
	drop table flexiones_brazos;
drop table test_abdominales;
drop table test_caminar;
drop table test_cooper;
drop table tren_inferior;
drop table tren_superior;
drop table usuario_pesos;
drop table pesos;
drop table registro;
drop table usuario_test;
drop table usuarios;
--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
select * from flexiones_brazos;
select * from test_abdominales;
select * from test_caminar;
select * from test_cooper;
select * from tren_inferior;
select * from tren_superior;
select * from usuario_pesos;
select * from pesos;
select * from registro;
select * from usuario_test;
select * from usuarios;
--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
create table usuarios(
    numero_cedula int not null,
    altura int not null,--en cm
    primer_apellido varchar(50) not null,
    segundo_apellido varchar(50) not null,
    nombre varchar(50) not null,
    sexo varchar(7) not null,
    telefono int,
    fecha_nacimiento date not null,
    constraint usuario_id_pk primary key (numero_cedula)
);
	
	
alter table usuarios add constraint CK_sexo check (sexo in ('Hombre','Mujer'));
insert into usuarios
    (numero_cedula, altura, primer_apellido, segundo_apellido, nombre, sexo,     telefono, fecha_nacimiento) values
    (207940344,     177,    'Murillo',      'Jimenez',       'Ricardo','Hombre', 83802264, to_date('04 JUL 1999', 'DD MON YYYY'));
insert into usuarios 
    (numero_cedula, altura, primer_apellido, segundo_apellido, nombre, sexo,     telefono, fecha_nacimiento) values
    (502460924,       180,  'Murillo',       'Jimenez',       'Gabriel','Mujer',  8086015, to_date('09 NOV 1992', 'DD MON YYYY'));
insert into usuarios 
    (numero_cedula, altura, primer_apellido, segundo_apellido, nombre, sexo,     telefono, fecha_nacimiento) values
    (208020900,       181, 'Lopez',       'Esquivel',       'Ronald','Hombre',    86314653, to_date('04 JAN 1999', 'DD MON YYYY'));
select * from usuarios;
--delete from usuarios where numero_cedula=50246924;
--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
create table pesos(
    id_pesos int GENERATED ALWAYS AS IDENTITY,
    descripcion varchar(50),
    fecha date not null,
    peso int not null,
    constraint pesos_id_pk primary key (id_pesos)
);
	
insert into pesos
    (descripcion,      fecha,                                 peso) values
    ('primera prueba', to_date('09 NOV 2020', 'DD MON YYYY'), 73);
insert into pesos
    (descripcion,      fecha,                                peso) values
    ('segunda prueba', to_date('10 AUG 2020', 'DD MON YYYY'), 80);
insert into pesos
    (descripcion,      fecha,                                peso) values
    ('tercera prueba', to_date('4 FEB 2019', 'DD MON YYYY'), 65);
select * from pesos;
--delete from pesos;
--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
create table usuario_pesos(
    numero_cedula int not null,
    id_pesos int GENERATED ALWAYS AS IDENTITY,
    constraint usuario_id_fk foreign key (numero_cedula) references usuarios(numero_cedula),
    constraint pesos_id_fk foreign key (id_pesos) references pesos(id_pesos)
);
	
drop table usuario_pesos
--select * from usuario_pesos;
insert into usuario_pesos values (207940344, 5);
insert into usuario_pesos values (208020900, 4);
insert into usuario_pesos values (208020900, 6);
--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
create table registro(
    numero_cedula int,
    nombre_usuario varchar(55) not null,
    contrasena varchar(55) unique not null,
    res_pre_1 varchar(50),
    res_pre_2 varchar(50),
    res_pre_3 varchar(50),
    constraint nombre_usuario_pk primary key (nombre_usuario),
    constraint numero_cedula_fk foreign key (numero_cedula) references usuarios(numero_cedula)
);
	
--select * from registro;
insert into registro values
    (207940344, 'ricardomj0499', 'aaaaa', 'azul', 'sutia', 'Neron');
insert into registro values
    (502460924, 'Garyen', 'bbbbb', 'celeste', 'mitia', 'Blacky');
insert into registro values
    (208020900, 'Ron', 'ccccc', 'rojo', 'tutia', 'Draco');
--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
create table test_cooper(
    cooper_id int GENERATED ALWAYS AS IDENTITY,
    fecha_test date not null,
    distancia int not null,
    resultado varchar(50),
    constraint cooper_pk primary key (cooper_id)
);
	
drop table usuario_cooper;	
drop table test_cooper;

--select * from test_cooper;
select * from insert into test_cooper (fecha_test, distancia, resultado) values (to_date('08 JAN 2020', 'DD MON YYYY'), 1000, null);
insert into test_cooper (fecha_test, distancia, resultado) values (to_date('08 JAN 2020', 'DD MON YYYY'), 1000, null);
insert into test_cooper (fecha_test, distancia, resultado) values (to_date('10 JAN 2019', 'DD MON YYYY'), 950, null);

create table usuario_cooper(
    id_cooper int GENERATED ALWAYS AS IDENTITY,
	numero_cedula int ,
    constraint usuario_cooper_fk foreign key (numero_cedula) references usuarios(numero_cedula),
    constraint pesos_cooper_fk foreign key (id_cooper) references test_cooper(cooper_id)
);
insert into usuario_cooper (numero_cedula, id_cooper) values (207940344, 1);
insert into usuario_cooper (numero_cedula, id_cooper) values (502460924, 2);
--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
create table flexiones(
    id_flex int GENERATED ALWAYS AS IDENTITY,
    fecha_test date not null,
    cantidad_flexiones int,
    resultado varchar(70),
    constraint id_flex_pk primary key (id_flex)
);
	
	
select * from flexiones_brazos;
insert into flexiones_brazos (fecha_test, cantidad_flexiones, resultado) values (to_date('04 JAN 2018', 'DD MON YYYY'), 30, null);

create table usuario_flexiones(
    numero_cedula int not null,
    id_flexiones int GENERATED ALWAYS AS IDENTITY,
    constraint usuario_flex_fk foreign key (numero_cedula) references usuarios(numero_cedula),
    constraint flex_usuario_fk foreign key (id_flexiones) references flexiones(id_flex)
);
	
insert into usuario_flexiones (numero_cedula, id_flexiones) values (502460924, 1);
select * from usuario_flexiones;
--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
"INSERT INTO frecuencias(descripcion,frecuencia,fecha) VALUES ('"+descripcion+"', "+frecuencia+", to_date('" + fecha + "', 'YYYY-MM-DD'))"
	
create table frecuencias(
    id_frecuencias int GENERATED ALWAYS AS IDENTITY,
    descripcion varchar(500),
    frecuencia int not null,
	fecha date not null,
    constraint frecuencias_pk primary key (id_frecuencias)
);
	
drop table usuario_frecuencias;	
drop table frecuencias;

create table usuario_frecuencias(
	id_frecuencias int GENERATED ALWAYS AS IDENTITY,
    numero_cedula int,
    constraint usuario_frecuencias_fk foreign key (numero_cedula) references usuarios(numero_cedula),
    constraint pesos_frecuencias_fk foreign key (id_frecuencias) references frecuencias(id_frecuencias)
);	

--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
create table test_abdominales(
    abdominables_id number GENERATED ALWAYS AS IDENTITY,
    fecha_test date not null,
    cantidad_abdominales number(10),
    resultado varchar(50),
    constraint abdominales_pk primary key (abdominables_id)
);
insert into test_abdominales (fecha_test, cantidad_abdominales, resultado) values (to_date('06 FEB 2019', 'DD MON YYYY'), 10, 'bien');
select * from test_abdominales;

create table usuario_abdominales(
    numero_cedula number(15) not null,
    id_abdominales number not null,
    constraint usuario_abdo_fk foreign key (numero_cedula) references usuarios(numero_cedula),
    constraint abdo_fk foreign key (id_abdominales) references test_abdominales(abdominables_id)
);
insert into usuario_abdominales (numero_cedula, id_abdominales) values (207940344, 1);
select * from usuario_abdominales;
--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
create table test_caminar(
    caminar_id number GENERATED ALWAYS AS IDENTITY,
    fecha_test date not null,
    pulsaciones_final number(10),
    tiempo_total number(10),
    resultado varchar(50),
    constraint caminar_id_pk primary key (caminar_id)
);
insert into test_caminar (fecha_test, pulsaciones_final, tiempo_total, resultado) values (to_date('06 MAY 2020', 'DD MON YYYY'), 180, 45, 'Excelente');
select * from test_caminar;

create table usuario_caminar(
    numero_cedula number(15) not null,
    caminar_id number not null,
    constraint usuario_caminar_fk foreign key (numero_cedula) references usuarios(numero_cedula),
    constraint caminar_fk foreign key (caminar_id) references test_caminar(caminar_id)
);
insert into usuario_caminar (numero_cedula, caminar_id) values (207940344, 1);
select * from usuario_caminar;
--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
create table tren_superior(
    superior_id number GENERATED ALWAYS AS IDENTITY,
    fecha_test date not null,
    ancho_hombros number(10),
    dist_pulgares number(10),
    resultado varchar(50),
    constraint superior_pk primary key (superior_id)
);
insert into tren_superior (fecha_test, ancho_hombros, dist_pulgares, resultado) values 
    (to_date('01 MAY 2017', 'DD MON YYYY'), 45, 75, 'Malo');
select * from tren_superior;

create table usuario_superior(
    numero_cedula number(15) not null,
    superior_id number not null,
    constraint usuario_superior_fk foreign key (numero_cedula) references usuarios(numero_cedula),
    constraint superior_fk foreign key (superior_id) references tren_superior(superior_id)
);
insert into usuario_superior (numero_cedula, superior_id) values (207940344, 1);
select * from usuario_superior;
--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
create table tren_inferior(
    inferior_id number GENERATED ALWAYS AS IDENTITY,
    fecha_test date not null,
    largo number(10),
    resultado varchar(50),
    constraint inferior_pk primary key (inferior_id)
);

insert into tren_inferior (fecha_test, largo, resultado) values 
    (to_date('07 JUL 2020', 'DD MON YYYY'), 25, null);
select * from tren_inferior;

create table usuario_inferior(
    numero_cedula number(15) not null,
    inferior_id number not null,
    constraint usuario_inferior_fk foreign key (numero_cedula) references usuarios(numero_cedula),
    constraint inferior_fk foreign key (inferior_id) references tren_inferior(inferior_id)
);
insert into usuario_inferior (numero_cedula, inferior_id) values (207940344, 1);
select * from usuario_inferior;
--=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
--=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
--=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

create or replace function return_pass (user_name varchar) return varchar is 
pass varchar(50);
begin

	SELECT contrasena INTO pass from registro where nombre_usuario = user_name;
        return (pass);

exception
        when NO_DATA_FOUND then
        pass:='null';
        return (pass);
end;

select * from registro;

select return_pass('rrrr') from registro;


SELECT * FROM test_cooper;

CREATE OR REPLACE TRIGGER insert_on_test
  AFTER INSERT OR UPDATE OR DELETE
  ON EVALUATIONS
DECLARE
  log_action  EVALUATIONS_LOG.action%TYPE;
BEGIN
  IF INSERTING THEN
    log_action := 'Insert';
  ELSIF UPDATING THEN
    log_action := 'Update';
  ELSIF DELETING THEN
    log_action := 'Delete';
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;

  INSERT INTO EVALUATIONS_LOG (log_date, action)
    VALUES (SYSDATE, log_action);
END;
--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
CREATE OR REPLACE TRIGGER insert_on_peso
  AFTER INSERT OR DELETE
  ON pesos
  for each row
DECLARE
  nombre_usuario VARCHAR(25);
BEGIN
  select Username into nombre_usuario FROM USER_USERS;
  IF INSERTING THEN
    log_action := 'Insert';
  ELSIF UPDATING THEN
    log_action := 'Update';
  ELSIF DELETING THEN
    log_action := 'Delete';
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;

  INSERT INTO EVALUATIONS_LOG (log_date, action)
    VALUES (SYSDATE, log_action);
END;
usuario_pesos
);
