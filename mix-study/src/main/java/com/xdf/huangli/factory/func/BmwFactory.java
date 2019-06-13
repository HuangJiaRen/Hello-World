package com.xdf.huangli.factory.func;


import com.xdf.huangli.factory.Bmw;
import com.xdf.huangli.factory.Car;

public class BmwFactory implements Factory {

	@Override
	public Car getCar() {
		return new Bmw();
	}

}
