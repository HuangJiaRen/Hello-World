package com.xdf.huangli.factory.func;


import com.xdf.huangli.factory.Benz;
import com.xdf.huangli.factory.Car;

public class BenzFactory implements Factory {

	@Override
	public Car getCar() {
		return new Benz();
	}

}
