package QLTT_GiangDay;

import QLTT_GiangDay.entities.LopHoc;
import QLTT_GiangDay.entities.SinhVien;
import QLTT_GiangDay.utils.IO;

public class Test {
    public static void main(String[] args){
        LK<SinhVien> listSV = new LK<>();
//        System.out.println(listSV.isEmpty());
//        System.out.println(listSV.size());
        SinhVien sv = new SinhVien("vd","vd",234,"Nu","d16");
        //listSV.insertAtEnd(sv);
        LK<LopHoc> listLH = new LK<>();
        LopHoc lh = new LopHoc("sd","sd","lh","mact",8);
        //System.out.println(listLH.isEmpty());
//        listLH.insertAtEnd(lh);
//        System.out.println(listLH.isEmpty());
        IO io = new IO();
        io.inputDSSV(listSV);
        io.printDSSinhVien(listSV);
        System.out.println(listSV.size());
        io.printDSSinhVien(listSV);

    }
}
