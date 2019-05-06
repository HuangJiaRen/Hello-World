package com.xdf.huangli.factory.abstr;


import com.xdf.huangli.factory.Audi;
import com.xdf.huangli.factory.Car;

//具体的业务逻辑封装
public class AudiFactory extends AbstractFactory {

	@Override
	public Car getCar() {
		return new Audi();
	}

}
