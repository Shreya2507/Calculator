package org.ncu.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//Factory Class
@Component
public class Calculator {
	
	//--------------------------------- ANNOTATION CONFIG -----------------------------------------

	MathService add;
	MathService sub;
	MathService mult;
	MathService div;

	/*
	//CONSTRUCTOR INJECTION 
	@Autowired
	Calculator(@Qualifier("additionService")MathService add, @Qualifier("subtractionService")MathService sub, 
	           @Qualifier("multiplicationService") MathService mult, @Qualifier("divisionService")MathService div){ 
		 this.add = add; 
		 this.sub = sub; 
		 this.mult = mult; 
		 this.div = div; 
	}
	*/
	
	// SETTER INJECTION
		//@Autowired
		public void setAdd(@Qualifier("additionService") MathService add) {
			this.add = add;
		}
		
		//@Autowired
		public void setSub(@Qualifier("subtractionService") MathService sub) {
			this.sub = sub;
		}

		//@Autowired
		public void setMult(@Qualifier("multiplicationService") MathService mult) {
			this.mult = mult;
		}

		//@Autowired
		public void setDiv(@Qualifier("divisionService") MathService div) {
			this.div = div;
		}
	
		
	/*
	 
	 
	 
	 
	
	------------------------------------ XML CONFIG -------------------------------------
	AdditionService add;
	SubtractionService sub;
	MultiplicationService mult;
	DivisionService div;

	
	//CONSTRUCTOR INJECTION 
	Calculator(AdditionService add, SubtractionService sub, MultiplicationService mult,	DivisionService div){ 
			this.add = add; 
			this.sub = sub; 
			this.mult = mult; 
			this.div = div; 
	}
		
	// SETTER INJECTION - XML
	public void setAdd(AdditionService add) {
		this.add = add;
	}
	
	
	public void setSub(SubtractionService sub) {
		this.sub = sub;
	}

	
	public void setMult(MultiplicationService mult) {
		this.mult = mult;
	}

	
	public void setDiv(DivisionService div) {
		this.div = div;
	}

	*/

	public void compute(String op, int x, int y) {
		if (op == "add") {
			add.operate(x, y);

		} else if (op == "sub") {
			sub.operate(x, y);

		} else if (op == "mult") {
			mult.operate(x, y);

		} else if (op == "div") {
			div.operate(x, y);

		} else {
			throw new RuntimeException("Sorry! Invalid operation.");
		}
	}

}
