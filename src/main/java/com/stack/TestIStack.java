package com.stack;

import com.stack.seqstack.SeqStack;

/**
 * 测试栈
 */
public class TestIStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = { 23, 45, 3, 7, 6, 945 };
		IStack<Integer> stack = new SeqStack<>(Integer.class, data.length);
		// 入栈操作
		System.out.println("**************入栈操作**************");
		for (int i = 0; i < data.length; i++) {
			stack.push(data[i]);
			System.out.println(data[i] + " 入栈");
		}
		int size = stack.size();
		// 出栈操作
		System.out.println("**************出栈操作**************");
		for (int i = 0; i < size; i++) {
			System.out.println(stack.pop() + " 出栈");
		}
	}

}
