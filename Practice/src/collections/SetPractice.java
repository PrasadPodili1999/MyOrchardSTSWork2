package collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetPractice {

	public static void main(String[] args) {
		Employeee e1=new Employeee(1, "smith", 1234, new Departmentt(11, "sales", "hyderabad"));
		Employeee e2=new Employeee(2, "amith", 234, new Departmentt(12, "les", "yderabad"));
		Employeee e3=new Employeee(3, "ith", 34, new Departmentt(13, "ales", "derabad"));
		Set<Employeee> set=new HashSet<Employeee>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		Iterator<Employeee> itr=set.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		for(Employeee e:set)
		{
			System.out.println(e);
		}
		set.stream().forEach(e->{
			System.out.println(e);
		});
		set.forEach(e->{
			System.out.println(e.getDept());
		});
		//set.remove(e1);
		set.forEach(e->{
			System.out.println(e);
		});
		List<Employeee> list=set.stream().collect(Collectors.toList());
		Collections.sort(list,(l1,l2)->l1.getName().compareTo(l2.getName()));
		list.forEach(l->{
			System.out.println(l);
		});
	}

}

class Employeee {
	private int id;
	private String name;
	private double sal;
	private Departmentt dept;

	public Employeee() {
		super();
	}

	public Departmentt getDept() {
		return dept;
	}

	public void setDept(Departmentt dept) {
		this.dept = dept;
	}

	public Employeee(int id, String name, double sal, Departmentt dept) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.dept = dept;
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

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + ", dept=" + dept + "]";
	}

}

class Departmentt {
	private int id;
	private String name;
	private String loc;

	public Departmentt(int id, String name, String loc) {
		super();
		this.id = id;
		this.name = name;
		this.loc = loc;
	}

	public Departmentt() {
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
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Departmentt [id=" + id + ", name=" + name + ", loc=" + loc + "]";
	}

}
