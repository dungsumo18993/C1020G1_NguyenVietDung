drop database if exists furama;

create database furama;

use furama;

create table vitri(
id_vitri int not null primary key,
tenvitri varchar(50)
);

create table trinhdo(
id_trinhdo int not null primary key,
trinhdo varchar(50)
);

create table bophan(
id_bophan int not null primary key,
tenbophan varchar(50)
);

create table nhanvien (
id_nhanvien int not null auto_increment primary key,
hoten varchar(50),
ngaysinh date,
cmnd varchar(50),
luong int(50),
sdt varchar(50),
email varchar(50),
diachi varchar(50),
vitri_id_vitri int,
trinhdo_id_trinhdo int,
bophan_id_bophan int,

foreign key (vitri_id_vitri) references vitri (id_vitri),
foreign key (trinhdo_id_trinhdo) references trinhdo (id_trinhdo),
foreign key (bophan_id_bophan) references bophan (id_bophan)
);

create table loaikhach(
id_loaikhach int not null primary key,
tenloaikhach varchar(50)
);

create table khachhang(
id_khachhang int not null primary key,
loaikhach_id_loaikhach int,
foreign key (loaikhach_id_loaikhach) references loaikhach (id_loaikhach),
hoten varchar(50),
ngaysinh date,
cmnd varchar(50),
sdt varchar(50),
email varchar(50),
diachi varchar(50)
);

create table kieuthue(
id_kieuthue int not null primary key,
tenkieuthue varchar(50),
gia int
);

create table loaidichvu(
id_loaidichvu int not null primary key,
tenloaidichvu varchar(50)
);

create table dichvu(
id_dichvu int not null primary key,
tendichvu varchar(50),
dientich int,
sotang int,
songuoitoida int(50),
chiphithue int(50),
kieuthue_id_kieuthue int,
foreign key (kieuthue_id_kieuthue) references kieuthue (id_kieuthue),
loaidichvu_id_loaidichvu int,
foreign key (loaidichvu_id_loaidichvu) references loaidichvu (id_loaidichvu),
trangthai varchar(50)
);

create table hopdong(
id_hopdong int not null primary key,
nhanvien_id_nhanvien int,
foreign key (nhanvien_id_nhanvien) references nhanvien (id_nhanvien),
khachhang_id_khachhang int,
foreign key (khachhang_id_khachhang) references khachhang (id_khachhang),
dichvu_id_dichvu int,
foreign key (dichvu_id_dichvu) references dichvu (id_dichvu),
ngaylamhopdong date,
ngayketthuc date,
tiendatcoc int,
tongtien int
);

create table dichvudikem(
id_dichvudikem int not null primary key,
tendichvudikem varchar(50),
gia int,
donvi int,
trangthaikhadung varchar(50)
);

create table hopdongchitiet(
id_hopdongchitiet int not null primary key,
hopdong_id_hopdong int,
foreign key (hopdong_id_hopdong) references hopdong (id_hopdong),
dichvu_id_dichvudikem int,
foreign key (dichvu_id_dichvudikem) references dichvudikem (id_dichvudikem),
soluong int
);



