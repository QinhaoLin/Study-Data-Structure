package com.linearlist.seqlist;

import java.lang.reflect.Array;

import com.linearlist.ILinarList;

/**
 * 线性表-顺序表 
 */
public class SeqList<E> implements ILinarList<E> {
	// 顺序表的最大容量
	private int maxSize;
	// 存储顺序表中数据元素的数组
	private E[] data;
	// 顺序表的实际长度
	private int size;

	// 初始化线性表
	@SuppressWarnings("unchecked")
	public SeqList(Class<E> type, int maxSize) {
		this.maxSize = maxSize;
		data = (E[]) Array.newInstance(type, maxSize);
		size = 0;
	}

	// 添加元素，将元素添加在顺序表的末尾
	@Override
	public boolean add(E item) {
		if (!isFull()) {
			data[size++] = item;
			return true;
		} else {
			return false;
		}
	}

	// 插入元素，将元素添加在顺序表指定的索引位置i处
	@Override
	public boolean add(int i, E item) {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index:" + i + ",Size:" + size);
		}
		if (!isFull()) {
			for (int j = size - 1; j >= i; j--) {
				data[j + 1] = data[j];
			}
			data[i] = item;
			size++;
			return true;
		} else {
			return false;
		}
	}

	// 删除元素，删除顺序表的第i个数据元素
	@Override
	public E remove(int i) {
		rangeCheck(i);
		if (!isEmpty()) {
			E oldValue = data[i];
			for (int j = i; j < size - 1; j++) {
				data[j] = data[j + 1];
			}
			data[--size] = null; // 清除最后一个元素
			return oldValue;
		} else {
			return null;
		}
	}

	// 定位元素，返回对象item在顺序表中首出现的索引位置，不存在item，则返回-1
	@Override
	public int indexOf(E item) {
		if (item == null) {
			for (int i = 0; i < size; i++) {
				if (data[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (item.equals(data[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	// 取表元素，返回顺序表中指定索引位置i处的数据元素
	@Override
	public E get(int i) {
		rangeCheck(i);
		return data[i];
	}

	// 获取顺序表长度
	@Override
	public int size() {
		return size;
	}

	// 清空顺序表
	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}
		size = 0;
	}

	// 判断顺序表是否为空
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// 判断顺序表是否为满
	private boolean isFull() {
		if (size == maxSize) {
			return true;
		} else {
			return false;
		}
	}

	// 判断给定的索引位置i是否在指定的范围，如果不在，抛出索引越界异常
	private void rangeCheck(int i) {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index:" + i + ",Size:" + size);
		}
	}

}
