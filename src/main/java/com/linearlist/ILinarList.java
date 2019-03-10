package com.linearlist;

/**
 * ADT线性表（linearlist）
 * 数据元素：可以是任意类型，只要同属一个数据对象即可。
 * 数据关系：数据元素之间呈线性关系，假设线性表中有n个元素（a1,a2,a3,...,an），
 * 		      则对每一个元素ai（i=1,2,...,n-1）都存在关系（ai,ai+1），并且a1无前趋，an无后继。
 * 数据操作：将线性表的基本操作定义在接口ILinarList中。
 */
public interface ILinarList<E> {
	// 添加元素
	boolean add(E item);
	// 插入元素
	boolean add(int i, E item);
	// 删除元素
	E remove(int i);
	// 定位元素
	int indexOf(E item);
	// 取表元素
	E get(int i);
	// 求线性表长度
	int size();
	//清空线性表
	void clear();
	//判断线性表是否为空
	boolean isEmpty();
}
