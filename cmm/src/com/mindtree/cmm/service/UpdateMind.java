package com.mindtree.cmm.service;

import com.mindtree.cmm.model.CampusMind;

public class UpdateMind {

	public static CampusMind [] updateprojectIdForMind(CampusMind []minds,int mId,int pId)
	{
		for(int i=0;i<minds.length;i++)
		{
			if(minds[i].getId()==mId)
			{
				minds[i].setProjectId(pId);
			}
		}
		return minds;
	}
}
