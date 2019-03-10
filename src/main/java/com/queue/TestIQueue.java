package com.queue;

import java.util.ArrayList;
import java.util.List;

public class TestIQueue {

	public static void main(String[] args) {
		
		 List<String> list1 = new ArrayList<String>();
		 List<String> list2 = new ArrayList<String>();
		 for (int i = 0; i < 50000; i++) {
			 list1.add(i+"");
		 }
		 for (int i = 0; i < 1000; i++) {
			 list2.add(i+"");
		 }
		 System.out.println("list1.size()"+list1.size());
		 System.out.println("list2.size()"+list2.size());
		 list1.retainAll(list2);
		 System.out.println("list1.size()"+list1);
		 System.out.println("list2.size()"+list2);
	}

}
