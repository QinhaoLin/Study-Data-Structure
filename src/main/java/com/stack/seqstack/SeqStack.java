package com.stack.seqstack;

import java.lang.reflect.Array;

import com.stack.IStack;

/**
 * 顺序栈
 */
public class SeqStack<E> implements IStack<E> {
	// 顺序栈的容量
	private int maxSize;
	// 数组，用于存储顺序栈中的数据元素
	private E[] data;
	// 指示顺序栈的栈顶
	private int top;
	
	@SuppressWarnings("unchecked")
	public SeqStack(Class<E> type, int size) {
		data = (E[]) Array.newInstance(type, size);
		maxSize = size;
		top = -1;
	}
	
	// 入栈操作
	@Override
	public E push(E item) {
		if (!IsFull()) {
			data[++top] = item;
			return item;
		} else {
			return null;
		}
	}

	// 出栈操作
	@Override
	public E pop() {
		E item = null;
		if (!empty()) {
			item = data[top--];
		}
		return item;
	}

	// 获取栈顶数据元素
	@Override
	public E peek() {
		E item = null;
		if (!empty()) {
			item = data[top];
		}
		return item;
	}

	// 求栈的长度
	@Override
	public int size() {
		return top + 1;
	}

	// 判断顺序栈是否为空
	@Override
	public boolean empty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	// 判断顺序栈是否为满
	private boolean IsFull() {
		if (top == maxSize - 1) {
			return true;
		} else {
			return false;
		}
	}

}
