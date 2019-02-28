package com.demo.springboot.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {
	public synchronized static byte[] serialize(Object object) {
		if(object==null){
			return null;
		}
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(baos!=null){
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public synchronized static Object unserialize(byte[] bytes) {
		if(bytes==null){
			return null;
		}
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bais!=null){
				try {
					bais.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
