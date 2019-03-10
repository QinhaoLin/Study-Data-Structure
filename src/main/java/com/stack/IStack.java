package com.stack;

/**
 * ADT
 * 数据元素：可以是任意类型，只要同属于一种数据类型即可。
 * 数据结构：数据元素之间呈线性关系，假设栈中有n个元素（a1,a2,a3,...,an），
 * 		      则对每一个元素ai（i=1,2,...,n-1）都在关系（ai,ai+1），并且a1无前趋，an无后继。
 * 数据操作：将对栈的操作定义接口中
 */
public interface IStack<E> {
	// 入栈
	E push(E item);
	
	// 出栈
	E pop();
	
	// 取栈顶元素
	E peek();
	
	// 返回栈中元素的个数
	int size();
	
	// 判断栈是否为空
	boolean empty();
}
