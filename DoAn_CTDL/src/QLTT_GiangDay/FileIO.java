package QLTT_GiangDay;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileIO {
    public static void WriteToFile(SinhVien sv){
        try {
            FileOutputStream fos = new FileOutputStream ("SinhVien.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sv);
            fos.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
