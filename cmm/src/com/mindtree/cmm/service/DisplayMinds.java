package com.mindtree.cmm.service;

import com.mindtree.cmm.model.CampusMind;

public class DisplayMinds {

	public static void displayMinds(CampusMind []minds,int pId)
	{
		for(int i=0;i<minds.length;i++)
		{
			if(minds[i].getProjectId()==pId)
			{
				displayParticularMind(minds[i]);
			}
		}
	}
	public static void displayParticularMind(CampusMind mind)
	{
		System.out.println("\nmind id :"+mind.getId());
		System.out.println("mind name :"+mind.getName());
		System.out.println("mind location :"+mind.getLocation());
		System.out.println("mind project id :"+mind.getProjectId());
	}
	public static void displayAllMinds(CampusMind []minds)
	{
		for(int i=0;i<minds.length;i++)
		{
			displayParticularMind(minds[i]);
		}
	}
}
