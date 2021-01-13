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


