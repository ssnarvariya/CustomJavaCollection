package com.custom.hashmap;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		HashTable t = new HashTable();
		t.put("Shubham", "Singh");
		t.put("Vinieta", "VSingh");
		t.put("Jovan", "JSingh");
		System.out.println("trying to get value:"+t.getValue("Vinieta"));
	}

}
