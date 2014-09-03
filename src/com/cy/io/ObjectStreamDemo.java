package com.cy.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStreamDemo {

	public static void main(String[] args) {
		T t = new T();
		//将对象写入到文件
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("d:/test.txt"));
			oos.writeObject(t);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//将对象从文件中读取
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("d:/test.txt"));
			T t1 = (T)ois.readObject();
			System.out.println(t1.a+"-"+t1.b+"-"+t1.c+"-"+t1.d);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

//Serializable 接口 标记该类可以被序列化
//externalizable 接口 自定义如何序列化

@SuppressWarnings("serial")
class T implements Serializable {
	int a = 123;
	float b = 1.2f;
	double c = 2.3;
	transient boolean d = true; //这个属性不会被写入
}