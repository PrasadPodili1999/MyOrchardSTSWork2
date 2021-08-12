package fileIO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class DeSerializationEx {

	public static void main(String[] args) {
		
		File f1=new File("C:\\JavaFiles/emp2.ser");
		InputStream fis=null;
		try
		{
			fis=new BufferedInputStream(new FileInputStream(f1));
			ObjectInputStream oi=new ObjectInputStream(fis);
			Object obj=oi.readObject();
			Employee e=(Employee)obj;
			
			System.out.println(e.getId());
			System.out.println(e.getName());
			System.out.println(obj.toString()+"\n");
			System.out.println("object read successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
class Employee implements Serializable
{
	int id;
	String name;
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	}
	
}

