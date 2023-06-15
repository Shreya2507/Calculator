package org.ncu.Calculator;

import org.springframework.stereotype.Component;

@Component
public class DivisionService implements MathService{
	public void operate(int x, int y) {
		System.out.println("Result = " + (x/y));
	}

}
