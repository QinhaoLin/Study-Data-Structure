package com.stack.linkstack;

/**
 * 链栈的节点
 */
public class StackNode<E> {
	// 数据域
	private E data;
	// 引用域
	private StackNode<E> next;

	// 构造函数
	public StackNode() {
	}

	public StackNode(E data, StackNode<E> next) {
		super();
		this.data = data;
		this.next = next;
	}

	// 数据域get属性
	public E getData() {
		return data;
	}

	// 数据域set属性
	public void setData(E data) {
		this.data = data;
	}

	// 引用域get属性
	public StackNode<E> getNext() {
		return next;
	}

	// 引用域set属性
	public void setNext(StackNode<E> next) {
		this.next = next;
	}
}
