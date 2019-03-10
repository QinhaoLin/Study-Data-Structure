package com.queue.seqqueue;

import com.queue.IQueue;

import java.lang.reflect.Array;


/**
 * 顺序队列
 */
public class SeqQueue<E> implements IQueue<E> {
	// 队列的容量
	private int maxsize;
	// 存储循环顺序队列中的数据元素
	private E[] data;
	// 指示最近一个已经离开队列的元素所占的位置
	private int front;
	// 指示最近一个进入队列的元素的位置
	private int rear;

	@SuppressWarnings("unchecked")
	public SeqQueue(Class<E> type, int size) {
		data = (E[]) Array.newInstance(type, size);
		maxsize = size;
		front = -1;
		rear = -1;
	}


	// 入队列操作
	public boolean eqnqueue(E item) {
		if (!isFull()) {
			rear = (rear + 1) % maxsize;
			data[rear] = item;
			return true;
		} else {
			return false;
		}
	}

	// 出队列操作
	public E dequeue() {
		if (!isEmpty()) {
			front = (front + 1) % maxsize;
			return data[front];
		} else {
			return null;
		}
	}

	// 取对头元素
	public E peek() {
		if (!isEmpty()) {
			return data[(front + 1) % maxsize];
		}else {
			return null;
		}
	}

	// 求队列的长度
	public int size() {
		if (rear > front) {
			return rear - front;
		} else {
			return (rear - front + maxsize) % maxsize;
		}
	}

	// 判断循环顺序队列是否为空
	public boolean isEmpty() {
		if (front==rear) {
			return true;
		}else {
			return false;
		}
	}

	// 判断循环顺序队列是否为满
	public boolean isFull() {
		if ((front == -1 && rear == maxsize - 1) || (rear + 1) % maxsize == front) {
			return true;
		} else {
			return false;
		}
	}
}
