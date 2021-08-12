package com.mindtree.cmm.service;

import com.mindtree.cmm.model.CampusMind;

public class SearchMind {

	public static CampusMind searchMindByName(String name,CampusMind[] minds)
	{
		int low=0,high=minds.length-1,flag=0;
		int resultIndex=0;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(name.equals(minds[mid].getName()))
			{
				flag=1;
				resultIndex=mid;
				break;
			}
			else if(name.compareTo(minds[mid].getName())>0)
			{
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		}
		if(flag==1)
		{
			return minds[resultIndex];
		}
		return null;
	}
}
