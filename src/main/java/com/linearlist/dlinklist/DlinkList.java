package com.linearlist.dlinklist;

import com.linearlist.ILinarList;

/**
 * 线性表-双向链表
 */
public class DlinkList<E> implements ILinarList<E> {
	private Node<E> start; // 双向链表的头引用
	private int size; // 单链表的长度

	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		Node(E element, Node<E> prev, Node<E> next) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}

	// 初始化双向链表
	public DlinkList() {
		start = null;
	}

	// 在双向链表的末尾追加数据元素
	@Override
	public boolean add(E item) {
		Node<E> newnode = new Node<E>(item, null, null);
		if (isEmpty()) {
			start = newnode;
			size++;
			return true;
		}
		Node<E> current = start;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newnode;
		newnode.prev = current;
		newnode.next = null;
		size++;
		return true;
	}

	// 在双向链表的第i索引位置前插入一个数据元素
	@Override
	public boolean add(int i, E item) {
		Node<E> current;
		Node<E> previous;
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index:" + i + ",Size:" + size);
		}
		Node<E> newnode = new Node<E>(item, null, null);
		// 在空链表或第一个元素前插入第一个元素
		if (i == 0) {
			newnode.next = start;
			start = newnode;
			size++;
			return true;
		}
		// 双向链表的两个元素间插入一个元素
		current = start;
		previous = null;
		int j = 0;
		while (current != null && j < i) {
			previous = current;
			current = current.next;
			j++;
		}
		if (j == i) {
			newnode.next = current;
			newnode.prev = previous;
			if (current != null){
				current.prev = newnode;
			}
			previous.next = newnode;
			size++;
		}
		return true;
	}

	// 删除双向链表中索引位置为i的数据元素
	@Override
	public E remove(int i) {
		E oldValue = null;
		if (isEmpty() || i < 0 || i > size - 1) {
			oldValue = null;
		}
		Node<E> current = start;
		if (i == 0) {
			oldValue = current.item;
			start = current.next;
			size--;
		} else {
			Node<E> previous = null;
			int j = 1;
			while (current.next != null && j <= i) {
				previous = current;
				current = current.next;
				j++;
			}
			previous.next = current.next;
			if (current.next != null) {
				current.next.prev = previous;
			}
			oldValue = current.item;
			current = null;
			previous = null;
			size--;
		}
		return oldValue;
	}

	// 在双向链表中查找值为item的数据元素
	@Override
	public int indexOf(E item) {
		int index = 0;
		if (item == null) {
			for (Node<E> current = start; current != null; current = current.next) {
				if (current.item == null) {
					return index;
				}
				index++;
			}
		} else {
			for (Node<E> current = start; current != null; current = current.next) {
				if (item.equals(current.item)) {
					return index;
				}
				index++;
			}

		}
		return -1;
	}

	// 获得双向链表的第i个索引位置的数据元素
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

	// 双向链表的长度
	@Override
	public int size() {
		return size;
	}

	// 清空双向链表
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

	// 判断双向链表是否为空
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
