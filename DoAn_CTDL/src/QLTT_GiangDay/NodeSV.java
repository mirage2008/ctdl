package QLTT_GiangDay;

import QLTT_GiangDay.entities.SinhVien;

public class NodeSV {
    private SinhVien sinhVien;
    private NodeSV next;

    public NodeSV(SinhVien sinhVien, NodeSV next) {
        this.sinhVien = sinhVien;
        this.next = next;
    }

    public NodeSV(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
        this.next = null;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public NodeSV getNext() {
        return next;
    }

    public void setNext(NodeSV next) {
        this.next = next;
    }

    public void printSvInfo() {
        System.out.println(sinhVien.toString());
    }
}
