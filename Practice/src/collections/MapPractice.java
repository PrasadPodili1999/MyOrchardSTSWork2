package collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapPractice {

	public static void main(String[] args) {
		
		Map<Integer, Department> deptMap=new HashMap<Integer, Department>();
		
		deptMap.put(1, new Department(1, "sales", "delhi"));
		deptMap.put(0, new Department(4, "dev", "ranchi"));
		deptMap.put(3, new Department(10, "test", "gurgaon"));
		for(Map.Entry m:deptMap.entrySet())
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
		System.out.println("=====================");
		deptMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(n->System.out.println(n));
		System.out.println("=====================");
		TreeMap<Integer, String> map=new TreeMap<>();
		map.put(1, "smith");
		map.put(0, "varun");
		map.put(8, "value");
		for(Map.Entry<Integer, String> m:map.entrySet())
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
		
		System.out.println("=====================");
		TreeMap<Integer, String> map2=new TreeMap<>();
		map2.put(1, "smith");
		map2.put(10, "varun");
		map2.put(48, "value");
		
		map.putAll(map2);
		for(Map.Entry m:map.entrySet())
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
		System.out.println("=====================");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(n->System.out.println(n));
		
//		map.remove(1);
//		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(n->System.out.println(n));
//		map.remove(48,"value");
//		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(n->System.out.println(n));
//		map.replaceAll((k,v)->"adam");
//		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(n->System.out.println(n));
////		Iterator<Integer> itr=map.keySet().iterator();
////		while(itr.hasNext())
////		{
////			int key=(int)itr.next();
////			System.out.println(key+" "+map.get(key));
////		}
////		System.out.println(map.keySet());
////		System.out.println(map.values());
		
		
		
	}

}

class Employee {
	private int id;
	private String name;
	private double sal;
	private Department dept;

	public Employee() {
		super();
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Employee(int id, String name, double sal, Department dept) {
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

class Department {
	private int id;
	private String name;
	private String loc;

	public Department(int id, String name, String loc) {
		super();
		this.id = id;
		this.name = name;
		this.loc = loc;
	}

	public Department() {
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
		return "Department [id=" + id + ", name=" + name + ", loc=" + loc + "]";
	}

}
