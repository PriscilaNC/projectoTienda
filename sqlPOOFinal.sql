CREATE USER 'uwu'@'localhost' IDENTIFIED BY '12345678qwerty';
GRANT ALL PRIVILEGES ON tienda_mascota.* TO 'uwu'@'localhost';
FLUSH PRIVILEGES;

CREATE Database tienda_mascota;
use tienda_mascota;

create table acuatico (
	codigo int unsigned not null auto_increment,
    nombre varchar(45) not null,
    raza varchar (20) not null,
    especie varchar(50) not null,
    color varchar(20) not null,
    masa double unsigned not null,
    edad tinyint unsigned not null,
    valor int unsigned not null,
    sexo varchar(6) not null,
    pais_origen varchar(40),
    tipo_alimentacion varchar(40),
    tipo_agua varchar(6),
    temperatura_agua tinyint,
    primary Key (codigo)
);

create table aereo (
	codigo int unsigned not null auto_increment,
    nombre varchar(45) not null,
    raza varchar (20) not null,
    especie varchar(50) not null,
    color varchar(20) not null,
    masa double unsigned not null,
    edad tinyint unsigned not null,
    valor int unsigned not null,
    sexo varchar(6) not null,
    pais_origen varchar(40),
    tipo_alimentacion varchar(40),
    primary Key (codigo)
);

create table terrestre (
	codigo int unsigned not null auto_increment,
    nombre varchar(45) not null,
    raza varchar (20) not null,
    especie varchar(50) not null,
    color varchar(20) not null,
    masa double unsigned not null,
    edad tinyint unsigned not null,
    valor int unsigned not null,
    sexo varchar(6) not null,
    pais_origen varchar(40),
    tipo_alimentacion varchar(40),
    primary Key (codigo)
);

create table accesorio (
	codigo int unsigned not null auto_increment,
    precio int unsigned not null,
    nombre varchar(45) not null,
    descripcion text,
    material varchar(20),
    tipo varchar(20),
    primary key (codigo)
);

create table alimento (
	codigo int unsigned not null auto_increment,
    precio int unsigned not null,
    nombre varchar(45) not null,
    descripcion text,
    fecha_elab date not null,
    fecha_caduc date not null,
    tipo_animal varchar(100),
    cantidadkg double unsigned not null,
    primary key (codigo)
);
    
create table medicamento (
	codigo int unsigned not null auto_increment,
    precio int unsigned not null,
    nombre varchar(45) not null,
    descripcion text,
    fecha_elab date not null,
    fecha_caduc date not null,
    tipo_uso varchar (15),
    primary key (codigo)
);

create table cliente (
	rut varchar(12) not null,
    nombre varchar(60) not null,
    edad tinyint not null,
    primary key (rut)
);

create table funcionario (
	rut varchar(12) not null,
    nombre varchar(60) not null,
    edad tinyint not null,
    cargo varchar(20),
    fono varchar(12),
    correo varchar(100),
    direccion varchar(100),
    sueldo int unsigned,
    tipo_jornada varchar(7),
    primary key (rut)
);

create table proveedor (
	rut varchar(12) not null,
    nombre varchar(60) not null,
    edad tinyint not null,
    organizacion varchar(45),
    tipo_proveedor varchar(45),
    primary key (rut)
);

create table pago (
	codigo int unsigned not null auto_increment,
    tipo varchar(30) not null,
    monto int unsigned not null,
    fecha date not null,
    -- cobrador
    -- pagador
    direccion varchar(100),
    primary key (codigo)
);
