package org.ncu.Calculator;

import org.springframework.stereotype.Component;

@Component
public class AdditionService implements MathService{
	public void operate(int x, int y) {
		System.out.println("Sum = " + (x+y));
	}

}
