package com.mc.gestionformation.view;

import java.lang.reflect.InvocationTargetException;

public class TestReflection {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("com.mc.gestionformation.view.MyBean");
			Object myinstance = clazz.newInstance();
			System.out.println(myinstance);

		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
