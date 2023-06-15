package org.ncu.Calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	/*
	//------------------------CONSTRUCTOR INJECTION-------------------------------
	
	//dependent class
	
	@Bean
	Calculator calc(){
		return new Calculator(add(), sub(), mult(), div());	 
		
      }
	
	@Bean
    MathService add(){
		return new AdditionService();
    }
	
	@Bean
    MathService sub(){
		return new SubtractionService();
    }
	
	@Bean
    MathService mult(){
		return new MultiplicationService();
    }
	
	@Bean
    MathService div(){
		return new DivisionService();
    }
    */
	
	//------------------------SETTER INJECTION-------------------------------
	
		//dependent class
		@Bean
		Calculator calc(){	 
			Calculator c = new Calculator();
			c.setAdd(add());
			c.setSub(sub());
			c.setMult(mult());
			c.setDiv(div());	
			return c;
	    }
		
		//dependencies
		@Bean
	    MathService add(){
			return new AdditionService();
	    }
		
		@Bean
	    MathService sub(){
			return new SubtractionService();
	    }
		
		@Bean
	    MathService mult(){
			return new MultiplicationService();
	    }
		
		@Bean
	    MathService div(){
			return new DivisionService();
	    }
	

}
