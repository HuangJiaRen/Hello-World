package com.xdf.huangli.factory.func;


import com.xdf.huangli.factory.Audi;
import com.xdf.huangli.factory.Car;

public class AudiFactory implements Factory {

	@Override
	public Car getCar() {
		return new Audi();
	}

}
