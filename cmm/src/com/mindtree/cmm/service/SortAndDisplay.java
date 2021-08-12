package com.mindtree.cmm.service;

import com.mindtree.cmm.model.CampusMind;

public class SortAndDisplay {

	// insertion SORT
	public static CampusMind[] sortAndDisplay(CampusMind[] minds) {
		CampusMind[] temp = new CampusMind[minds.length];
		copyExtingMindsIntoNewArray(temp, minds);
		int j = 0;
		for (int i = 1; i < temp.length; i++) {
			CampusMind mind = temp[i];
			for (j = i - 1; j >= 0 && temp[j].getLocation().compareTo(mind.getLocation()) < 0; j--) {
				temp[j + 1] = temp[j];
			}
			temp[j + 1] = mind;
		}
		// displayAllMinds(temp);
		return temp;
	}

	// bubble SORT
	public static CampusMind[] sort(CampusMind[] minds) {
		CampusMind[] temp = new CampusMind[minds.length];
		copyExtingMindsIntoNewArray(temp, minds);
		for (int i = 0; i < temp.length - 1; i++) {
			for (int j = 0; j < temp.length - i - 1; i++) {
				if (temp[j].getLocation().compareTo(temp[j + 1].getLocation()) < 0) {
					CampusMind mind = temp[j];
					temp[j] = temp[j + 1];
					temp[j + 1] = mind;
				}
			}
		}
		return temp;
	}

	public static void copyExtingMindsIntoNewArray(CampusMind minds[], CampusMind existingMinds[]) {
		for (int i = 0; i < existingMinds.length; i++) {
			minds[i] = existingMinds[i];
		}
	}

}
