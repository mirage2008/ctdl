package QLTT_GiangDay;

import QLTT_GiangDay.entities.SinhVien;

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
    public void insertAtEnd(SinhVien sv) {
        NodeSV newNode = new NodeSV(sv, null);
        if (isEmpty()){
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
    public int search(String key){
        if (isEmpty()){
            System.out.println("Empty!");
            return 0;
        }
        NodeSV current = head;
        int i = 1;
        boolean flag = false;
        while (current != null){
            if (current.getSinhVien().getMaSV().equals(key)) {
                flag = true;
                current.printSvInfo();
                break;
            }
            i++;
            current = current.getNext();
        }
        if (flag){
            System.out.println("Found at the position: " +i);
            return i;
        } else {
            System.out.println("Not found!");
            return 0;
        }
    }
    public void replace(String key){
        int vt = search(key);
        if (vt == 0) return;
        SinhVien sv = new SinhVien();
        inputSV(sv);
        NodeSV current = head;
        for (int i = 1; i < size ; i++) {
            if (i == vt) {
                current.setSinhVien(sv);
            }
            current = current.getNext();
        }

    }
    public void insertAtPosition(int vt, SinhVien sv) {
        // if  vt < 1 invalid
        // if vt == 1 insert head
        if (vt == 1) {
            insertAtHead(sv);
        }
        NodeSV newSv = new NodeSV(sv, null);
        NodeSV ptr = head;
        vt = vt - 1;
        for (int i = 1; i < size; i++){
            if (i == vt){
                NodeSV temp = ptr.getNext();
                ptr.setNext(newSv);
                newSv.setNext(temp);
                break;
            }
            ptr = ptr.getNext();
        }
        size++;
    }
    public void deleteSvByMaSv(String key){
        if (isEmpty()){
            System.out.println("Empty!");
            return;
        }
        // delete first
        if (head.getSinhVien().getMaSV().equals(key)){
            if (head.getNext() == null) {
                head = null;
                tail = null;
                size--;
                return;
            } else if (head.getNext() != null) {
                head = head.getNext();
                size--;
                return;
            }
        }
        NodeSV startPtr = head;
        NodeSV prevLink = startPtr;
        startPtr = startPtr.getNext();
        while (!startPtr.getSinhVien().getMaSV().equals(key) && startPtr.getNext() != null){
            prevLink = startPtr;
            startPtr = startPtr.getNext();
        }
        if (startPtr.getSinhVien().getMaSV().equals(key)){
            NodeSV temp = prevLink.getNext();
            temp = temp.getNext();
            prevLink.setNext(temp);
            size--;
            return;
        }
        System.out.println("Not found!");
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
            //Write1SvToFile(sv);
            System.out.println("tiep tuc? (0/1): ");
            Scanner sc = new Scanner(System.in);
            tt = sc.nextInt();
            if (tt == 0)
                break;
        }while (tt == 1);
    }
    public static void Write1SvToFile(SinhVien sv){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("SinhVien.dat", true));
            String data = sv.getMaSV() +";"+sv.getHoTen()+";"+sv.getNamSinh() +";"+sv.getGioiTinh()+";"+sv.getMaLop()+"\n";
            writer.append(data);
            writer.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void WriteListSvToFile() throws IOException {
        NodeSV currentNode = head;
        BufferedWriter writer = new BufferedWriter(new FileWriter("SinhVien.dat", false));
        while (currentNode != null) {
            SinhVien sv = currentNode.getSinhVien();
            String data = sv.getMaSV() +";"+sv.getHoTen()+";"+sv.getNamSinh() +";"+sv.getGioiTinh()+";"+sv.getMaLop()+"\n";
            writer.append(data);
            currentNode = currentNode.getNext();
        }
        writer.close();
    }
    public void ReadFile_DSSV(DSSinhVien dsSinhVien) throws IOException {
        File fileSV = new File("DoAn_CTDL/SinhVien.dat");
        FileReader fr = new FileReader(fileSV);
        BufferedReader reader = new BufferedReader(fr);
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] tempLine = line.split(";");
            String maSv = tempLine[0];
            String hoTen = tempLine[1];
            int namSinh = Integer.parseInt(tempLine[2]);
            String gioiTinh = tempLine[3];
            String lop = tempLine[4];
            SinhVien sv = new SinhVien(maSv,hoTen,namSinh,gioiTinh,lop);
            dsSinhVien.insertAtEnd(sv);
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
