package com.stack.linkstack;

import com.stack.IStack;

/**
 * 链栈
 */
public class LinkStack<E> implements IStack<E> {
	// 栈顶指示器
	private StackNode<E> top;
	// 栈中节点的个数
	private int size;

	// 初始化
	public LinkStack() {
		top = null;
		size = 0;
	}

	// 入栈操作
	@Override
	public E push(E item) {
		StackNode<E> newNode = new StackNode<E>(item, null);
		if (!empty()) {
			newNode.setNext(top);
		}
		top = newNode;
		++size;
		return item;
	}

	// 出栈操作
	@Override
	public E pop() {
		E item = null;
		if (!empty()) {
			item = top.getData();
			top = top.getNext();
			size--;
		}
		return item;
	}

	// 获取栈顶元素
	@Override
	public E peek() {
		E item = null;
		if (!empty()) {
			item = top.getData();
		}
		return item;
	}

	// 求栈长度
	@Override
	public int size() {
		return size;
	}

	// 判断链栈是否为空
	@Override
	public boolean empty() {
		if ((top == null) && (size == 0)) {
			return true;
		} else {
			return false;
		}
	}

}
