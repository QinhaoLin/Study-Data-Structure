package com.queue;

/**
 * 队列
 * 数据元素：可以是任意类型，是要同属一种数据类型即可。
 * 数据结构：数据元素之间呈线性关系，假设队列中有n个元素（n0,a1,a2,...,an），
 * 		      则对每一个元素ai(i=1,2,...,n-1)都存在关系（ai,ai+1），并且a1无前趋，an无后继。
 * 数据操作：将队列的基本操作定义在接口IQueue<E>中
 */
public interface IQueue<E> {
	// 入队列操作
	boolean eqnqueue(E item);
	
	// 出队列操作
	E dequeue();
	
	// 取头元素
	E peek();
	
	// 求队列的长度
	int size();
	
	// 判断队列是否为空
	boolean isEmpty();
	
	// 判断队列是否为满
	boolean isFull();
}
