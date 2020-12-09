package QLTT_GiangDay;

import QLTT_GiangDay.entities.SinhVien;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // khai bao dssv
        DSSinhVien dsSinhVien = new DSSinhVien();
        String choice;
        boolean stop = false;

        // load file
        dsSinhVien.ReadFile_DSSV(dsSinhVien);

        // display menu
        System.out.println("\n========================================");
        System.out.println("DO AN MON CAU TRUC DU LIEU VA GIAI THUAT");
        System.out.println("========================================");
        System.out.println("MENU");
        System.out.println("1: Nhap du lieu\t2: Xuat Thong Tin\t3: Tim kiem\t4: Chen & Xoa\t5: Cap Nhat\t6: Luu DS\t7: Gioi thieu\t8: Thoat chuong trinh");

        while (!stop) {
            System.out.print("Nhap lua chon: ");
            Scanner in = new Scanner(System.in);
            choice = in.next();
            switch (choice) {
                case "1":
                    System.out.println("chuc nang 1: Nhap du lieu");
                    dsSinhVien.inputDSSV();
                    break;
                case "2":
                    System.out.println("chuc nang 2: Xuat Thong Tin");
                    dsSinhVien.printDSSinhVien();
                    break;
                case "3":
                    System.out.println("chuc nang 3: Tim kiem");
                    System.out.print("Nhap ma sinh vien can tim: ");
                    String searchMAsv = in.next();
                    dsSinhVien.search(searchMAsv);
                    break;
                case "4":
                    System.out.println("chuc nang 4: Chen & Xoa");
                    System.out.print("Input vi tri can chen: ");
                    int vt = in.nextInt();
                    SinhVien sv = new SinhVien();
                    dsSinhVien.inputSV(sv);
                    dsSinhVien.insertAtPosition(vt,sv);

                    System.out.println("Input maSv can xoa: ");
                    String masv = in.next();
                    dsSinhVien.deleteSvByMaSv(masv);
                    break;
                case "5":
                    System.out.println("chuc nang 5: Cap Nhat");
                    System.out.print("Input maSv can cap nhat: ");
                    String masv2 = in.next();
                    dsSinhVien.replace(masv2);
                    break;
                case "6":
                    System.out.println("chuc nang 6: Save Danh Sach");
                    dsSinhVien.WriteListSvToFile();
                    break;
                case "7":
                    System.out.println("Chuc nang 7: Gioi thieu");
                    System.out.println("Thông tin thành viên nhóm:");
                    System.out.println("(\"n15dcat065\", \"Chau Thanh Sang\", \"D15CQAT01-N\")");
                    System.out.println("(\"n15dcat070\", \"Do Thanh Hai\", \"D15CCAT01-N\")");
                    System.out.println("(\"n15dcat054\", \"Nguyen Chi Cong\", \"D15CQAT01-N\")");
                    break;
                case "8":
                    System.out.println("Thoat chuong trinh. GoodBye!!!!");
                    stop = true;
                    break;
                case "0":
                    System.out.println("Saving data!");
                default:
                    System.out.println("invalid value!!!!!");
                    break;
            }
        }
    }
}
