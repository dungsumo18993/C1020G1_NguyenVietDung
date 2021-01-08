create database furama;

use furama;

create table nhanvien (
id_nhanvien int,
hoten varchar(50),
id_vitri int,
id_trinhdo int,
id_bophan int,
ngaysinh date,
cmnd varchar(50),
luong varchar(50),
sdt varchar(50),
email varchar(50),
diachi varchar(50)
);

create table vitri(
id_vitri int,
tenvitri varchar(50)
);

create table trinhdo(
id_trinhdo int,
trinhdo varchar(50)
);

create table bophan(
id_bophan int,
tenbophan varchar(50)
);

create table hopdong(
id_hopdong int,
id_nhanvien int,
id_khachhang int,
id_dichvu int,
ngaylamhopdong date,
ngayketthuc date,
tiendatcoc int,
tongtien int
);

create table hopdongchitiet(
id_hopdongchitiet int,
id_hopdong int,
id_dichvudikem int,
soluong int
);

create table dichvudikem(
id_dichvudikem int,
tendichvudikem varchar(50),
gia int,
donvi int,
trangthaikhadung varchar(50)
);

create table khachhang(
id_khachhang int,
id_loaikhach int,
hoten varchar(50),
ngaysinh date,
cmnd varchar(50),
sdt varchar(50),
email varchar(50),
diachi varchar(50)
);

create table loaikhach(
id_loaikhach int,
tenloaikhach varchar(50)
);

create table dichvu(
id_dichvu int,
tendichvu varchar(50),
dientich int,
sotang int,
songuoitoida varchar(50),
chiphithue varchar(50),
id_kieuthue int,
id_loaidichvu int,
trangthai varchar(50)
);

create table kieuthue(
id_kieuthue int,
tenkieuthue varchar(50),
gia int
);

create table loaidichvu(
id_loaidichvu int,
tenloaidichvu varchar(50)
);