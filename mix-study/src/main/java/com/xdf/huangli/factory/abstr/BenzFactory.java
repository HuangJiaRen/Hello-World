package com.xdf.huangli.factory.abstr;


import com.xdf.huangli.factory.Benz;
import com.xdf.huangli.factory.Car;

public class BenzFactory extends AbstractFactory {

	@Override
	public Car getCar() {
		return new Benz();
	}

}
