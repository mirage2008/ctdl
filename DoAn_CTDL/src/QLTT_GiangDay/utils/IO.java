package QLTT_GiangDay.utils;

import QLTT_GiangDay.LK;
import QLTT_GiangDay.Node;
import QLTT_GiangDay.NodeSV;
import QLTT_GiangDay.entities.LopHoc;
import QLTT_GiangDay.entities.SinhVien;

import java.util.Scanner;

public class IO extends LK {
    Scanner sc = new Scanner(System.in);
    public void inputSV(SinhVien sv) {
//        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma SV: ");
        sv.setMaSV(sc.nextLine());
        System.out.print("Nhap Ho & Ten: ");
        sv.setHoTen(sc.nextLine());
        System.out.print("Nhap Nam Sinh: ");
        sv.setNamSinh(Integer.parseInt(sc.nextLine()));
        System.out.print("Nhap Gioi Tinh (Nam/Nu/Khac): ");
        sv.setGioiTinh(sc.nextLine());
        System.out.print("Nhap Ma Lop: ");
        sv.setMaLop(sc.nextLine());
    }
    public void inputDSSV(LK<SinhVien> listSV) {
        int tt = 1;
        do {
            SinhVien sv = new SinhVien();
            System.out.println("Nhap Thong Tin Sinh Vien");
            inputSV(sv);
            listSV.insertAtEnd(sv);
            //insertAtHead(sv);
            //Write1SvToFile(sv);
            System.out.println("tiep tuc? (0/1): ");
            Scanner sc = new Scanner(System.in);
            tt = sc.nextInt();
            if (tt == 0)
                break;
        }while (tt == 1);
    }
    public void printDSSinhVien(LK<SinhVien> listSV) {
        Node currentNode = listSV.getHead();
        while (currentNode != null) {
            currentNode.printInfo();
            currentNode = currentNode.getNext();
        }
    }

    public void inputLopHoc(LopHoc lh){
        System.out.println("Nhap ma lop: ");
        lh.setMaLop(sc.next());
    }
}
