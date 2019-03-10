package com.linearlist.slinklist;

import com.linearlist.ILinarList;

/**
 * 线性表-单链表
 */
public class SLinkList<E> implements ILinarList<E> {
	private Node<E> start; // 单链表的头引用
	private int size; // 单链表的长度

	private static class Node<E> {
		E item;
		Node<E> next;

		Node(E element, Node<E> next) {
			this.item = element;
			this.next = next;
		}
	}

	// 初始化线性表
	public SLinkList() {
		start = null;
	}

	// 添加元素，将元素添加在单链表末尾
	@Override
	public boolean add(E item) {
		if (start == null) {
			start = new Node<E>(item, null);
		} else {
			Node<E> current = start;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node<E>(item, null);
		}
		size++;
		return true;
	}

	// 在单链表的第i个索引位置前插入一个数据元素
	@Override
	public boolean add(int i, E item) {
		Node<E> current;
		Node<E> previous;
		if (i < 0 || i > size) {
			return false;
		}
		Node<E> newnode = new Node<E>(item, null);
		// 在空链表或第一个元素前插入第一个元素
		if (i == 0) {
			newnode.next = start;
			start = newnode;
			size++;
		} else {
			// 在单链表的两个元素间插入一个元素
			current = start;
			previous = null;
			int j = 0;
			while (current != null && j < i) {
				previous = current;
				current = current.next;
				j++;
			}
			if (j == i) {
				previous.next = newnode;
				newnode.next = current;
				size++;
			}
		}
		return true;
	}

	// 删除单链表中的索引位置为i的数据元素
	@Override
	public E remove(int i) {
		E oldValue = null;
		if (isEmpty() || i < 0 || i > size - 1) {
			oldValue = null;
		}
		Node<E> current = start;
		// 在空链表或第一个元素前删除第一个元素
		if (i == 0) {
			oldValue = current.item;
			start = current.next;
			size--;
		} else {
			// 单链表的两个元素间删除一个元素
			Node<E> previous = null;
			int j = 1;
			while (current.next != null && j <= i) {
				previous = current;
				current = current.next;
				j++;
			}
			previous.next = current.next;
			oldValue = current.item;
			current = null;
			size--;
		}
		return oldValue;
	}

	// 在单链表中查找数据元素item数据位置
	@Override
	public int indexOf(E item) {
		int i = 0;
		if (item == null) {
			for (Node<E> x = start; x != null; x = x.next) {
				if (x.item == null) {
					return i;
				}
				i++;
			}
		} else {
			for (Node<E> x = start; x != null; x = x.next) {
				if (item.equals(x.item)) {
					return i;
				}
				i++;
			}
		}
		return -1;
	}

	// 获取单链表的第i索引位置的数据元素
	@Override
	public E get(int i) {
		E item = null;
		if (isEmpty() || i < 0 || i > size - 1) {
			item = null;
		}
		Node<E> current = start;
		int j = 0;
		while (current.next != null && j < i) {
			current = current.next;
			j++;
		}
		if (j == i) {
			item = current.item;
		}
		return item;
	}

	// 求单链表的长度
	@Override
	public int size() {
		return size;
	}

	// 清空单链表
	@Override
	public void clear() {
		for (Node<E> x = start; x != null;) {
			Node<E> next = x.next;
			x.item = null;
			x.next = null;
			x = next;
		}
		start = null;
		size = 0;
	}

	// 判断单链表是否为空
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
