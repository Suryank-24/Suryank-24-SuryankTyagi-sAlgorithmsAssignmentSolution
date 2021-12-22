package com.greatlearning.dsa.assignment.main;

import java.util.Scanner;

import com.greatlearning.dsa.assignment.service.AdditionalServices;
import com.greatlearning.dsa.assignment.service.BinarySearchImplementation;
import com.greatlearning.dsa.assignment.service.LinearSearchImplementation;
import com.greatlearning.dsa.assignment.service.MergeSortImplementation;

public class DriverClassMain {

	public static void main(String[] args) {
		int noOfCompanies;
		int option;
		System.out.println("Enter the no. of Companies :");
		Scanner sc = new Scanner(System.in);	
		noOfCompanies = sc.nextInt();
		
		double[] priceArray = new double[noOfCompanies];
		boolean[] profitArray = new boolean[noOfCompanies];
		
		for(int i = 0; i < noOfCompanies; i++) {
			System.out.println("Enter current stock price of Company "+(i + 1));
			priceArray[i] = sc.nextDouble();
			System.out.println("Whether Company's stock price rose today compare to yesterday?");
			profitArray[i] = sc.nextBoolean();
		}
		
		//creating objects of different classes
		MergeSortImplementation msi = new MergeSortImplementation();
		msi.sort(priceArray, 0, priceArray.length - 1);
		AdditionalServices as = new AdditionalServices();
		LinearSearchImplementation lsi = new LinearSearchImplementation();
		BinarySearchImplementation bsi = new BinarySearchImplementation();
		
		do {
			System.out.println();
			System.out.println("--------------------------------------");
			System.out.println("Enter the operation you want to perform :");
			System.out.println("1. Display the Company stock price in ascending order :");
			System.out.println("2. Display the Company stock price in descending order :");
			System.out.println("3. Display the total no. of Companies for which stock prices rose today :");
			System.out.println("4. Display the total no. of Companies for which stock prices declined today :");
			System.out.println("5. Search a specific stock price :");
			System.out.println("6. Press 0 to exit");
			System.out.println("---------------------------------------");
			
			option = sc.nextInt();
			switch(option) {
			
				case 0:
					option = 0;
					break;
				case 1:
				{
					as.displayPricesAscendingOrder(priceArray);
				}
				break;
				case 2:
				{
					as.displayPricesDescendingOrder(priceArray);
				}
				break;
				case 3:
				{
					System.out.println("Total no. of Comapnies whose stock price rose today : " + lsi.countCompaniesInProfit(profitArray));	
				}
				break;
				case 4:
				{
					System.out.println("Total no. of Companies whose stock price declined today : "+ (noOfCompanies - lsi.countCompaniesInProfit(profitArray)));	
				}
				break;
				case 5:
				{
					double key;
					System.out.println("Enter the key value : ");
					key = sc.nextDouble();
					bsi.searchValue(priceArray, key);
				}
				break;
				default:
					System.out.println("Enter valid option!");
			}
		}
		while(option != 0);
		System.out.println("Exited Succesfully!!!");
		sc.close();
	}
}
