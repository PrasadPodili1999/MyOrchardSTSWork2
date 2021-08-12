package com.mindtree.cmm;

import java.util.Scanner;

import com.mindtree.cmm.model.CampusMind;
import com.mindtree.cmm.service.AddMind;
import com.mindtree.cmm.service.DisplayMinds;
import com.mindtree.cmm.service.SearchMind;
import com.mindtree.cmm.service.SortAndDisplay;
import com.mindtree.cmm.service.UpdateMind;

/*
 * 
    Campusmind
id
name
location
projectId

Write a menu driven program for the below provided options
1. Display the campusMinds details of a particular project.
2. Update the projectid of a particular campusmind
3. Print the campus minds in decending order based on location using insertion sort.
4. Search campusmind by name using Binary Search
5. Exit

Note :
1. Solve in modular approach with correct return types
2. No printing of results in methods
3. One method should do only one job
4. return result to main and call respective method for printing the result.

 */
public class MindManagementApp {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int loopVar=1;
		CampusMind []minds=new CampusMind[0];
		do
		{
			
			displayMenu();
			System.out.println("enter your choice\n");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:System.out.println("enter how many minds you want to add:");
					int mindsCount=sc.nextInt();
					minds=AddMind.addMinds(mindsCount, minds);
				break;
			case 2:
				System.out.println("enter project Id :");
				int pId=sc.nextInt();
				DisplayMinds.displayMinds(minds, pId);
				break;
			case 3:
				System.out.println("enter mind Id");
				int mId=sc.nextInt();
				System.out.println("enter project Id :");
				int projectId=sc.nextInt();
				minds=UpdateMind.updateprojectIdForMind(minds, mId, projectId);
				break;
			case 4:
				CampusMind[] temp=SortAndDisplay.sortAndDisplay(minds);
				DisplayMinds.displayAllMinds(temp);
				break;
			case 5:
				System.out.println("enter mind name");
				String name=sc.next();
				CampusMind mind=SearchMind.searchMindByName(name, minds);
				DisplayMinds.displayParticularMind(mind);
				break;
			case 6:
				CampusMind[] temp2=SortAndDisplay.sort(minds);
				DisplayMinds.displayAllMinds(temp2);
				break;
			case 7:loopVar++;
				break;
			default:System.out.println("you entered invalid option");
			   
			
			}
		}while(loopVar==1);

	}
	public static void displayMenu()
	{
		System.out.println("1.add minds");
		System.out.println("2.Display All Minds Based on Particular projectId");
		System.out.println("3.update project Id");
		System.out.println("4.display minds in descending order");
		System.out.println("5.search minds by name");
		System.out.println("6.exit");
	}

}
