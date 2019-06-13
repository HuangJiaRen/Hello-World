package com.xdf.huangli.factory.abstr;


import com.xdf.huangli.factory.Bmw;
import com.xdf.huangli.factory.Car;

public class BmwFactory extends AbstractFactory {

	@Override
	public Car getCar() {
		return new Bmw();
	}

}
