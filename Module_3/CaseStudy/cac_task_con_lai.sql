-- yêu cầu 2
SELECT 
    *
FROM
    nhanvien
WHERE
    (hoten LIKE 'H%' OR hoten LIKE 'T%'
        OR hoten LIKE 'K%')
        AND LENGTH(hoten) < 15;

-- yêu cầu 3
SELECT 
    *
FROM
    khachhang
WHERE
    diachi IN ('Da Nang' , 'Quang Tri')
        AND (CURDATE() - ngaysinh > (18 * 30 * 365)
        AND CURDATE() - ngaysinh < (50 * 30 * 365));
        
-- Yêu cầu 4
SELECT 
    k.hoten, COUNT(h.id_hopdong) 'so_lan_dat'
FROM
    khachhang k
        JOIN
    hopdong h ON k.id_khachhang = h.khachhang_id_khachhang
        JOIN
    loaikhach l ON l.id_loaikhach = k.loaikhach_id_loaikhach
WHERE
    l.tenloaikhach = 'Diamond';
    
-- Yêu cầu 5
SELECT 
    k.id_khachhang,
    k.hoten,
    l.tenloaikhach,
    h.id_hopdong,
    d.tendichvu,
    h.ngaylamhopdong,
    h.ngayketthuc,
    SUM(d.chiphithue + hd.soluong * dvdk.gia) 'Tổng'
FROM
    khachhang k
        LEFT JOIN
    loaikhach l ON l.id_loaikhach = k.loaikhach_id_loaikhach
        LEFT JOIN
    hopdong h ON h.khachhang_id_khachhang = k.id_khachhang
        LEFT JOIN
    hopdongchitiet hd ON hd.hopdong_id_hopdong = h.id_hopdong
        LEFT JOIN
    dichvudikem dvdk ON dvdk.id_dichvudikem = hd.dichvu_id_dichvudikem
        LEFT JOIN
    dichvu d ON d.id_dichvu = h.dichvu_id_dichvu
GROUP BY h.id_hopdong;

-- Yêu cầu 6
select dichvu.id_dichvu, dichvu.tendichvu, dichvu.dientich, dichvu.chiphithue, loaidichvu.tenloaidichvu
from dichvu
join loaidichvu on dichvu.loaidichvu_id_loaidichvu = loaidichvu.id_loaidichvu
where not exists (
select hopdong.id_hopdong
from hopdong
where (hopdong.ngaylamhopdong between "2019-01-01" and "2019-03-31") and hopdong.dichvu_id_dichvu = dichvu.id_dichvu
);

--  Yêu cầu 7 : Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu
--  của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng 
--  chưa từng được Khách hàng đặt phòng  trong năm 2019.
select dichvu.id_dichvu, dichvu.tendichvu, dichvu.dientich, dichvu.songuoitoida, dichvu.chiphithue, loaidichvu.tenloaidichvu
from dichvu
join loaidichvu on dichvu.loaidichvu_id_loaidichvu = loaidichvu.id_loaidichvu
where exists (
select *
from hopdong
where year(hopdong.ngaylamhopdong) = "2018" and hopdong.dichvu_id_dichvu = dichvu.id_dichvu)
and not exists (
select hopdong.id_hopdong
from hopdong
where year(hopdong.ngaylamhopdong) = "2019" and hopdong.dichvu_id_dichvu = dichvu.id_dichvu);

-- Yêu cầu 8: Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
-- Cách 1: 
-- select distinct hoten
-- from khachhang;
-- Cách 2: 
-- select hoten
-- from khachhang
-- group by hoten;
-- Cách 3:
select hoten
from khachhang
union
select hoten
from khachhang;

-- Yêu cầu 9: Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng
-- trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select temp.month, count(month(hopdong.ngaylamhopdong)) so_khach_da_dk, sum(hopdong.tongtien) tong_tien
from
(select 1 month
union select 2 month
union select 3 month
union select 4 month
union select 5 month
union select 6 month
union select 7 month
union select 8 month
union select 9 month
union select 10 month
union select 11 month
union select 12 month) temp
left join hopdong on month(hopdong.ngaylamhopdong) = temp.month
left join khachhang on khachhang.id_khachhang = hopdong.khachhang_id_khachhang
where year(hopdong.ngaylamhopdong) = "2019" or year(hopdong.ngaylamhopdong) is null
group by temp.month
order by temp.month;

-- Yêu cầu 10: Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu
-- Dịch vụ đi kèm. Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc,
-- TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
select hopdong.id_hopdong, hopdong.ngaylamhopdong, hopdong.ngayketthuc, hopdong.tiendatcoc, count(hopdongchitiet.id_hopdongchitiet) so_luong_dich_vu_di_kem
from hopdong
inner join hopdongchitiet on hopdong.id_hopdong = hopdongchitiet.hopdong_id_hopdong
group by hopdong.id_hopdong;

-- Yêu cầu 11: Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có
-- TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select dichvudikem.id_dichvudikem, dichvudikem.tendichvudikem, dichvudikem.gia, dichvudikem.trangthaikhadung
from dichvudikem
inner join hopdongchitiet on dichvudikem.id_dichvudikem = hopdongchitiet.dichvu_id_dichvudikem
inner join hopdong on hopdongchitiet.hopdong_id_hopdong = hopdong.id_hopdong
inner join khachhang on hopdong.khachhang_id_khachhang = khachhang.id_khachhang
inner join loaikhach on khachhang.loaikhach_id_loaikhach = loaikhach.id_loaikhach
where khachhang.diachi in ('Vinh','Quảng Ngãi') and loaikhach.tenloaikhach = 'Diamond';

-- Yêu cầu 12: Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019
select hopdong.id_hopdong, nhanvien.hoten, khachhang.hoten, khachhang.sdt, dichvu.tendichvu, hopdong.tiendatcoc, count(hopdongchitiet.dichvu_id_dichvudikem) so_lan_su_dung
from hopdong
inner join nhanvien on hopdong.nhanvien_id_nhanvien = nhanvien.id_nhanvien
inner join khachhang on hopdong.khachhang_id_khachhang = khachhang.id_khachhang
inner join hopdongchitiet on hopdong.id_hopdong = hopdongchitiet.hopdong_id_hopdong
inner join dichvudikem on hopdongchitiet.dichvu_id_dichvudikem = dichvudikem.id_dichvudikem
inner join dichvu on hopdong.dichvu_id_dichvu = dichvu.id_dichvu
where not exists (select hopdong.id_hopdong where hopdong.ngaylamhopdong between "2019-01-01" and "2019-06-31")
and
exists (select hopdong.id_hopdong where hopdong.ngaylamhopdong between "2019-09-01" and "2019-12-31");

-- Yêu cầu 13: Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
create temporary table temp
select dichvudikem.tendichvudikem, count(hopdongchitiet.dichvu_id_dichvudikem) so_lan_su_dung
from hopdongchitiet
inner join dichvudikem on dichvudikem.id_dichvudikem = hopdongchitiet.dichvu_id_dichvudikem
group by dichvudikem.tendichvudikem;

select * from temp;

create temporary table temp1
select max(temp.so_lan_su_dung) max_so_lan_su_dung
from temp;

select * from temp1;

select temp.tendichvudikem, temp.so_lan_su_dung 
from temp
inner join temp1 on temp1.max_so_lan_su_dung = temp.so_lan_su_dung;

drop temporary table temp;
drop temporary table temp1;

-- Yêu cầu 14: Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select hopdong.id_hopdong, loaidichvu.tenloaidichvu, dichvudikem.tendichvudikem, count(hopdongchitiet.dichvu_id_dichvudikem) so_lan_su_dung
from hopdong
inner join dichvu on dichvu.id_dichvu = hopdong.dichvu_id_dichvu
inner join loaidichvu on loaidichvu.id_loaidichvu = dichvu.loaidichvu_id_loaidichvu
inner join hopdongchitiet on hopdong.id_hopdong = hopdongchitiet.hopdong_id_hopdong
inner join dichvudikem on dichvudikem.id_dichvudikem = hopdongchitiet.dichvu_id_dichvudikem
group by dichvudikem.tendichvudikem
having so_lan_su_dung = 1;

-- Yêu cầu 15: Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
select nhanvien.id_nhanvien, nhanvien.hoten, nhanvien.sdt, nhanvien.diachi, trinhdo.trinhdo, bophan.tenbophan, count(hopdong.nhanvien_id_nhanvien) so_lan_lam_hop_dong
from nhanvien
inner join trinhdo on nhanvien.trinhdo_id_trinhdo = trinhdo.id_trinhdo
inner join bophan on nhanvien.bophan_id_bophan = bophan.id_bophan
inner join hopdong on nhanvien.id_nhanvien = hopdong.nhanvien_id_nhanvien
where hopdong.ngaylamhopdong between "2018-01-01" and "2019-12-31"
group by nhanvien.hoten
having so_lan_lam_hop_dong <= 3;

-- Yêu cầu 16: Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
delete from nhanvien
where nhanvien.id_nhanvien not in (
select hopdong.nhanvien_id_nhanvien
from hopdong
where year(hopdong.ngaylamhopdong) in ("2017","2018","2019")
group by hopdong.nhanvien_id_nhanvien
);

-- Yêu cầu 17: Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
update khachhang
set khachhang.loaikhach_id_loaikhach = 1
where khachhang.loaikhach_id_loaikhach = 3 and khachhang.loaikhach_id_loaikhach in (
select hopdong.khachhang_id_khachhang
from hopdong 
where hopdong.ngaylamhopdong between "2019-01-01" and "2019-12-31"
group by hopdong.khachhang_id_khachhang
having sum(hopdong.tongtien) >= 1000
);

-- Yêu cầu 18: Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).
delete from khachhang
where khachhang.id_khachhang in (
select hopdong.khachhang_id_khachhang
from hopdong
where year(hopdong.ngaylamhopdong) < 2016
);

-- Yêu cầu 19: Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
update dichvudikem
set dichvudikem.gia = dichvudikem.gia * 2
where dichvudikem.id_dichvudikem in (
	select hopdongchitiet.dichvu_id_dichvudikem
    from hopdongchitiet
    inner join hopdong on hopdongchitiet.hopdong_id_hopdong = hopdong.id_hopdong
    where year(hopdong.ngaylamhopdong) = "2019"
    group by hopdongchitiet.dichvu_id_dichvudikem
    having count(hopdongchitiet.dichvu_id_dichvudikem) > 10
    );
    
-- Yêu cầu 20: Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm
-- ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select nhanvien.id_nhanvien, nhanvien.hoten, nhanvien.email, nhanvien.sdt, nhanvien.ngaysinh, nhanvien.diachi
from nhanvien
union all
select khachhang.id_khachhang, khachhang.hoten, khachhang.email, khachhang.sdt, khachhang.ngaysinh, khachhang.diachi
from khachhang;

-- Task 21: Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu”
-- và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
create view v_nhanvien as
select nhanvien.id_nhanvien, nhanvien.hoten, nhanvien.ngaysinh, nhanvien.cmnd, nhanvien.sdt, nhanvien.email, nhanvien.diachi
from nhanvien
inner join hopdong on hopdong.nhanvien_id_nhanvien = nhanvien.id_nhanvien
where nhanvien.diachi = "Hải Châu" and hopdong.ngaylamhopdong = "2019/12/12";

select *
from v_nhanvien;

-- Task 22: Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
update v_nhanvien
set diachi = "Liên Chiểu";

-- Task 23: Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1
delimiter //
create procedure sp_1(id int)
begin
	delete from khachhang
    where khachhang.id_khachhang = id;
end;
// delimiter ;

call sp_1(5);

-- Task 24: Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện kiểm tra
-- tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan
delimiter //
create procedure sp_2 (
id_hop_dong int,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int)
begin
if id_hop_dong in (
	select hopdong.id_hopdong
	from hopdong ) then
	select "id hợp đồng đã bị trùng";
elseif id_nhan_vien not in (
	select nhanvien.id_nhanvien
    from nhanvien ) then
	select "id nhân viên không tồn tại";
elseif id_khach_hang not in (
	select khachhang.id_khachhang
	from khachhang ) then
	select "id khách hàng không tồn tại";
elseif id_dich_vu not in (
	select dichvu.id_dichvu
	from dichvu ) then 
	select "id dịch vụ không tồn tại";
else
	insert into hopdong
	values(id_hop_dong, id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, tong_tien);
end if;
end;
// delimiter ;

call sp_2 (3,3,1,1,"2020-02-12","2020-04-14",400,1000);

    