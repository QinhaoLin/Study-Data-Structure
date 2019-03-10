package com.linearlist;

import java.util.Scanner;

import com.linearlist.slinklist.SLinkList;

public class TestILinarList {
	public static void main(String[] args) {
//		ILinarList<Integer> list = new SeqList<>(Integer.class, 50);
		ILinarList<Integer> list = new SLinkList<>();
		int[] data = { 23, 45, 3, 7, 6, 945 };
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------------------------------------");
		System.out.println("操作选项菜单");
		System.out.println("1.添加元素");
		System.out.println("2.插入元素");
		System.out.println("3.删除元素");
		System.out.println("4.定位元素");
		System.out.println("5.取表元素");
		System.out.println("6.显示线性表");
		System.out.println("0.退出");
		System.out.println("-------------------------------------------");

		char ch;
		do {
			System.out.println("请输入操作选项：");
			ch = scanner.next().charAt(0);
			switch (ch) {
			case '1':
				for (int i = 0; i < data.length; i++) {
					list.add(data[i]);
				}
				System.out.println("添加操作成功！");
				break;
			case '2':
				// 位置是从1开始的
				System.out.println("请输入要插入的位置：");
				int loc = scanner.nextInt();
				System.out.println("请输入要插入该位置的值：");
				int num = scanner.nextInt();
				list.add(loc - 1, num);
				System.out.println("插入操作成功！");
				break;
			case '3':
				System.out.println("请输入要删除元素的位置：");
				loc = scanner.nextInt();
				list.remove(loc - 1);
				System.out.println("删除操作成功！");
				break;
			case '4':
				System.out.println("请输入要查找元素：");
				num = scanner.nextInt();
				System.out.println(num + "在列表中的位置为：" + (list.indexOf(num) + 1));
				break;
			case '5':
				System.out.println("请输入要查找元素的位置：");
				loc = scanner.nextInt();
				System.out.println(loc + "位置上的元素为：" + list.get(loc - 1));
				break;
			case '6':
				System.out.println("线性表中的元素有：");
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i) + " ");
				}
				System.out.println();
				break;
			}
		} while (ch != '0');
		scanner.close();

	}
}
