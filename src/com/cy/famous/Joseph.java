package com.cy.famous;

import com.cy.datastructure.CircularLinkList;

/**
 * 约瑟夫问题，又称“丢手绢问题”。 据说著名犹太历史学家 Josephus有过以下的故事：在罗马人占领乔塔帕特后，39
 * 个犹太人与Josephus及他的朋友躲到一个洞中，39个犹太人决定宁愿死也不要被敌人抓到
 * ，于是决定了一个自杀方式，41个人排成一个圆圈，由第1个人开始报数，
 * 每报数到第3人该人就必须自杀，然后再由下一个重新报数，直到所有人都自杀身亡为止。然而Josephus
 * 和他的朋友并不想遵从。首先从一个人开始，越过k-2个人
 * （因为第一个人已经被越过），并杀掉第k个人。接着，再越过k-1个人，并杀掉第k个人。这个过程沿着圆圈一直进行
 * ，直到最终只剩下一个人留下，这个人就可以继续活着
 * 。问题是，给定了和，一开始要站在什么地方才能避免被处决？Josephus要他的朋友先假装遵从，他将朋友与自己安排在第16个与第31个位置
 * ，于是逃过了这场死亡游戏。
 * 
 * @author CY
 * @version 2014年7月14日
 */
public class Joseph {

	public static void main(String[] args) {
//		Joseph.aliveSite_1(10, 3, 2);
		Joseph.aliveSite_2(10, 3, 2);
	}

	/**
	 * 利用循环链表解决
	 * @param total 总人数
	 * @param offset 要跳过的人数
	 * @param aliveNum 最后要活下的人数
	 * @return 可以活的位置
	 */
	public static void aliveSite_1(int total, int offset, int aliveNum) {
		// 创建一个圈子
		CircularLinkList cll = new CircularLinkList();
		// 为这个圈子的每个位置标号
		for (int i = 1; i <= total; i++) {
			cll.add(i);
		}
		//剩下aliveNum个人之后，游戏结束。
		cll.init();
		while(cll.getLength() > aliveNum){
			for (int i = 0; i < offset; i++) {
				cll.next();
			}
			// 杀死
			cll.deleteByElem(cll.getPointer().getElem());
		}
		// 输出可以存活下来的位置。
		cll.init();
		for (int i = 0; i < cll.getLength(); i++) {
			System.out.println(cll.next().getElem());
		}
	}
	
	/**
	 * 利用数组来解决约瑟夫问题
	 * @param total
	 * @param offset
	 * @param aliveNum
	 */
	public static void aliveSite_2(int total, int offset, int aliveNum) {
		// 创建一个圈子
		int[] circul = new int[total];
		// 为圈子里的每个成员编号
		for (int i = 0; i < total; i++) {
			circul[i] = i+1;
		}
		// 标记第几次报数
		int tag = 0;
		// 标识第几个人报数
		int i = 0;
		// 剩下aliveNum个人之后，游戏结束。
		while (total > aliveNum) {
			// 该位置的人未死
			if(circul[i] != 0){
				// 报数
				tag++;
				// 要杀死此人
				if(tag >= 3){
					circul[i] = 0;
					tag = 0;
					total--;
				}
			}
			i = ++i%circul.length;
		}
		
		//输出最后可以活下的位置。
		for(int p : circul) {
			if(p != 0) {
				System.out.println(p);
			}
		}
	}
	
}