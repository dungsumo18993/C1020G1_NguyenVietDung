package _11_generic_stack_queue_.bai_tap.demerging_sd_queue;

import sun.plugin.javascript.navig.Link;

import java.text.ParseException;
import java.util.*;

public class TestNhanVien {
    public static void main(String[] args) throws ParseException {
        Queue<NhanVien> NU=new LinkedList<>();
        Queue<NhanVien> NAM=new LinkedList<>();

        List<NhanVien> nhanViens = new ArrayList<>();
        NhanVien nv1 = new NhanVien("Linh","Nu","06/12/2001");
        NhanVien nv2 = new NhanVien("Hai","Nam","01/09/1996");
        NhanVien nv3 = new NhanVien("Dương","Nam","18/9/1993");
        NhanVien nv4 = new NhanVien("Thanh","Nu","28/3/2000");
        nhanViens.add(nv1);
        nhanViens.add(nv2);
        nhanViens.add(nv3);
        nhanViens.add(nv4);

        Collections.sort(nhanViens);
        System.out.println(nhanViens);


        for (NhanVien element: nhanViens){
            if (element.getGender()=="Nu"){
                NU.add(element);
            } else if(element.getGender()=="Nam"){
                NAM.add(element);
            }
        }

        List<NhanVien> ketQua = new LinkedList<>();
            if (!NU.isEmpty()) {
                ketQua.add(NU.poll());
            }

            if (!NAM.isEmpty()){
                ketQua.add(NAM.poll());
            }

        for (NhanVien element : ketQua){
            System.out.println(element.toString());
        }
    }
}
