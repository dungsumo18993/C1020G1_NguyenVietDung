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
select danh_sach.id_nhanvien
from (
		select nhanvien.id_nhanvien
		from nhanvien
			left join hopdong on nhanvien.id_nhanvien = hopdong.nhanvien_id_nhanvien
		where year(hopdong.ngaylamhopdong) in ("2017","2018","2019")
		group by nhanvien.id_nhanvien ) as danh_sach
);

-- Yêu cầu 17: Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
update khachhang
set khachhang.id_khachhang = 1
where khachhang.id_khachhang = 2 and khachhang.id_khachhang in (
select hopdong.khachhang_id_khachhang
from hopdong 
where hopdong.tongtien >= 1000 and hopdong.ngaylamhopdong between "2019-01-01" and "2019-12-31"
);

-- Yêu cầu 18: Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).
delete from khachhang
where khachhang.id_khachhang not in (
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
    