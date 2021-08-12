package com.mindtree.cmm.service;

import java.util.Scanner;

import com.mindtree.cmm.model.CampusMind;

public class AddMind {

	public static CampusMind [] addMinds(int count,CampusMind [] existMinds)
	{
		Scanner sc=new Scanner(System.in);
		CampusMind []minds=new CampusMind[count+existMinds.length];
		copyExtingMindsIntoNewArray(minds,existMinds);
		for(int i=0;i<count;i++)
		{
			System.out.println("enter mind id");
			int id=sc.nextInt();
			System.out.println("enter mind name");
			String name=sc.next();
			System.out.println("enter location");
			String loc=sc.next();
			System.out.println("enter project id");
			int pId=sc.nextInt();
			CampusMind mind=new CampusMind(id, name, loc, pId);
			minds[existMinds.length+i]=mind;	
		}
		return minds;
	}
	public static void copyExtingMindsIntoNewArray(CampusMind minds[],CampusMind existingMinds[])
	{
		for(int i=0;i<existingMinds.length;i++)
		{
			minds[i]=existingMinds[i];
		}
	}
}
