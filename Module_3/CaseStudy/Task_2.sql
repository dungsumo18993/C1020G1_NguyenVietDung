-- yêu cầu 2
SELECT 
    *
FROM
    nhanvien
WHERE
    (hoten LIKE 'h%' OR hoten LIKE 't%'
        OR hoten LIKE 'k%')
        AND LENGTH(hoten) < 15;

-- yêu cầu 3
select * from khachhang 
where diachi in ('Da Nang','Quang Tri') and (curdate()-ngaysinh>(18*30*365) and curdate()-ngaysinh<50(50*30*365));
