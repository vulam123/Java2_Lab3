import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NhanVien implements Serializable{
	public NhanVien(String manv, String hoten, int tuoi, float luong) {
		super();
		this.manv = manv;
		this.hoten = hoten;
		this.tuoi = tuoi;
		this.luong = luong;
	}

	private String manv;
	private String hoten;
	private int tuoi;
	private float luong;

	@Override
	public String toString() {
		return "NhanVien [manv=" + manv + ", hoten=" + hoten + ", tuoi=" + tuoi + ", luong=" + luong + "]";
	}

	public static void main(String[] args) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		NhanVien a = new NhanVien("123", "abc", 20, 2000);
		list.add(a);
		a = new NhanVien("456", "def", 30, 3000);
		list.add(a);
		a = new NhanVien("789", "ghi", 40, 4000);
		list.add(a);
		try {
			NhanVien.WriteFile("nhanvien.txt", list);
			NhanVien.ReadFile("nhanvien.txt");
			NhanVien.WriteObJect("data.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void WriteFile(String fileName, List<NhanVien> list) throws IOException {
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(fw);
		for (NhanVien x : list) {
			String s = x.toString();
			bw.write(s+"\r\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void ReadFile(String fileName) throws IOException {
		FileReader input = new FileReader(fileName);
		int ch = input.read();
		while(ch!=-1) {
			System.out.print((char)ch);
			ch = input.read();
		}
	}
	
	public static void WriteObJect(String filename) throws IOException {
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream os = new ObjectOutputStream(fos);
		NhanVien[] arr = {new NhanVien("123", "abc", 40, 4000),new NhanVien("3456", "gasdasdhi", 40, 4000),new NhanVien("qwe", "gasdasdhi", 40, 4000)};
		os.writeObject(arr);
		os.close();
	}
	
	
}
