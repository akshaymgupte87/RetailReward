package com.retail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class RetailReward {

	public static void main(String[] args) {
		HashMap <Integer, HashMap<String,List<Integer>>> customer = 
				createData();
		processAllCustomers(customer);

	}

	public static void processRewardPointsforOneCustomer(HashMap transaction) {
		List transactionsForMonth1 = (List<Integer>) transaction.get("Month1");
		List transactionsForMonth2 = (List<Integer>) transaction.get("Month2");
		List transactionsForMonth3 = (List<Integer>) transaction.get("Month3");
		int totalRewardPoints = 0;
		int rewardPoints1 = 0;
		int rewardPoints2 = 0;
		int rewardPoints3 = 0;
		
		/*
		 * for (int i=0; i<transaction.size(); i++) { transactionAmount = transaction;
		 * if (transactionAmount) }
		 */
		for (int i=0; i<transactionsForMonth1.size(); i++) {
			int transactionAmount;
			transactionAmount = (int) transactionsForMonth1.get(i);
			if(transactionAmount > 100) {
				rewardPoints1 = rewardPoints1 + ((2 * (transactionAmount-100))+ (1 * 50));
			} else if (transactionAmount > 50 && transactionAmount <=100) {
				rewardPoints1 = rewardPoints1 + (1*(transactionAmount - 50));
			} 
		}
		System.out.println("Rewards for Month 1 is "+ rewardPoints1);
		
		for (int i=0; i<transactionsForMonth2.size(); i++) {
			int transactionAmount;
			transactionAmount = (int) transactionsForMonth2.get(i);
			if(transactionAmount > 100) {
				rewardPoints2 = rewardPoints2 + ((2 * (transactionAmount-100))+ (1 * 50));
			} else if (transactionAmount > 50 && transactionAmount <=100) {
				rewardPoints2 = rewardPoints2 + (1*(transactionAmount - 50));
			} 
		}
		System.out.println("Rewards for Month 2 is "+ rewardPoints2);
		
		for (int i=0; i<transactionsForMonth3.size(); i++) {
			int transactionAmount;
			transactionAmount = (int) transactionsForMonth3.get(i);
			if(transactionAmount > 100) {
				rewardPoints3 = rewardPoints3 + ((2 * (transactionAmount-100))+ (1 * 50));
			} else if (transactionAmount > 50 && transactionAmount <=100) {
				rewardPoints3 = rewardPoints3 + (1*(transactionAmount - 50));
			} 
		}
		System.out.println("Rewards for Month 3 is "+ rewardPoints3);
		
		totalRewardPoints = rewardPoints1 + rewardPoints2 + rewardPoints3;
		
		System.out.println("Total Reward Points for the customer are "+ totalRewardPoints);
		
	}
	
	public static void processAllCustomers(HashMap customer) {
		int totalNumberofCustomers = customer.size();
		for (int i=1; i<=totalNumberofCustomers; i++) {
			HashMap<String,Integer> transactionsForCustomer = 
					(HashMap<String, Integer>) customer.get(i);	
			System.out.println("Processing for Customer number "+ i);
			processRewardPointsforOneCustomer(transactionsForCustomer);
		}
		
	}
	
	public static HashMap <Integer, HashMap<String,List<Integer>>> createData(){
		
		HashMap <String,List<Integer>> transaction = new HashMap<String,List<Integer>>();
		//assuming date is in mm-dd-yy and in one map
		//transaction map has transactions for 3 months
		transaction.put("Month1", new ArrayList<Integer>());
		transaction.put("Month2", new ArrayList<Integer>());
		transaction.put("Month3", new ArrayList<Integer>());
		transaction.get("Month1").add(120);
		transaction.get("Month1").add(110);
		transaction.get("Month2").add(77);
		transaction.get("Month3").add(55);
		//customer map has customer number as key and this transaction map as value
		HashMap <String,List<Integer>> transaction2 = new HashMap<String,List<Integer>>();
		transaction2.put("Month1", new ArrayList<Integer>());
		transaction2.put("Month2", new ArrayList<Integer>());
		transaction2.put("Month3", new ArrayList<Integer>());
		transaction2.get("Month1").add(150);
		transaction2.get("Month1").add(110);
		transaction2.get("Month2").add(98);
		transaction2.get("Month3").add(65);
		HashMap <Integer, HashMap<String,List<Integer>>> customer = 
				new HashMap<Integer,HashMap<String,List<Integer>>>();
		customer.put(1,transaction);
		customer.put(2, transaction2);
		return customer;
	}
}


