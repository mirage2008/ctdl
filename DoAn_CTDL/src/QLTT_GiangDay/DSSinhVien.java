package QLTT_GiangDay;

import java.io.*;
import java.util.Scanner;

public class DSSinhVien {
    private NodeSV head;
    private NodeSV tail;
    private int size;

    public DSSinhVien() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    // lay size ds
    public int size() {
        return this.size;
    }
    // check ds rong
    public boolean isEmpty() {
        return this.head == null;
    }
    public void insertAtHead(SinhVien sv) {
        NodeSV newNode = new NodeSV(sv, null);
        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }
    public void inputSV(SinhVien sv) {
        Scanner sc = new Scanner(System.in);
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
    public void inputDSSV() {
        int tt = 1;
        do {
            SinhVien sv = new SinhVien();
            System.out.println("Nhap Thong Tin Sinh Vien");
            inputSV(sv);
            insertAtHead(sv);
            WriteFile_DSSV(sv);
            System.out.println("tiep tuc? (0/1): ");
            Scanner sc = new Scanner(System.in);
            tt = sc.nextInt();
            if (tt == 0)
                break;
        }while (tt == 1);
    }
    public static void WriteFile_DSSV(SinhVien sv){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("SinhVien.txt", true));
            String data = sv.getMaSV() +";"+sv.getHoTen()+";"+sv.getNamSinh() +";"+sv.getGioiTinh()+";"+sv.getMaLop()+"\n";
            writer.append(data);
            writer.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void ReadFile_DSSV(DSSinhVien dsSinhVien) throws IOException {
        File fileSV = new File("sinhvien.txt");
        FileReader fr = new FileReader(fileSV);
        BufferedReader reader = new BufferedReader(fr);
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            String[] tempLine = line.split(";");
            String maSv = tempLine[0];
            String hoTen = tempLine[1];
            int namSinh = Integer.parseInt(tempLine[2]);
            String gioiTinh = tempLine[3];
            String lop = tempLine[4];
            SinhVien sv = new SinhVien(maSv,hoTen,namSinh,gioiTinh,lop);
            dsSinhVien.insertAtHead(sv);
        }
    }
    public void printDSSinhVien() {
        System.out.println("==== Danh Sach Sinh Vien =====");
        NodeSV currentNode = head;
        while (currentNode != null) {
            currentNode.printSvInfo();
            currentNode = currentNode.getNext();
        }
    }
}
