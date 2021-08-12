package fileIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class SerializationEx {

	public static void main(String[] args) {
	

		Employee e=new Employee(1,"smith");
		File f1=new File("C:\\JavaFiles/emp2.ser");
		if(f1.exists()==false)
		{
			OutputStream fos=null;
			try {
				f1.createNewFile();
				fos=new FileOutputStream(f1);
				ObjectOutputStream os=new ObjectOutputStream(fos);
				os.writeObject(e);
				System.out.println("object written");
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			finally
			{
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
class Employee implements Serializable
{
	private int id;
	private String name;
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Employee() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	};
	
}
