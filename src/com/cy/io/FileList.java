package com.cy.io;

import java.io.File;

/**
 * 递归列出目录结构
 * @author CY
 * @version 2014年7月19日
 */
public class FileList {

	public static void main(String[] args) {
		File path = new File("E:/视频");
		FileList.tree(path, 0);
	}
	
	/**
	 * 打印出文件列表
	 * @param path
	 */
	public static void tree(File path, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("-----");
		}
		System.out.println(path.getName());
		if(path.isDirectory()){
			File[] f = path.listFiles();
			level++;
			for(File file : f) {
				tree(file, level);
			}
		}
	}

}
