package org.ncu.Calculator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    
    	//1. Initialize the spring container
    	//XML config
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		//annotation config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    	
    	//2. get the desired beans
		Calculator service = context.getBean("calc", Calculator.class);
				
		//3. call the desired method/operation
		service.compute("mult", 5, 5);
		
		//4. Close the spring context
		context.close();
    }
}



/*
 TO USE SPRING -
 1)Add dependencies(from mvn repository):
   Spring core
   Spring context
 
 2)To configure spring IoC (3 ways):
    1. XML config (old, no longer used)
    		XML config:
			inside src/main/java----
			-> ApplicationContext.xml file //telling spring that these beans/objects will be needed
			//id - unique string value - reference variable
			//class - fully qualified name/address [right click on class & copy qualified name] 
			
			<bean id="EnglishService" class="org.ncu.greeting_app.EngGreetingServ"></bean>
			<bean id="FrenchService" class="org.ncu.greeting_app.FreGreetingServ"></bean>
			<bean id="SpanishService" class="org.ncu.greeting_app.SpaGreetingServ"></bean>

    
    2. annotations (annotation is kind of meta-data)
    
    		ANNOTATIONS - flag, @, gives meta data of the underlying functionality of method or class
    		-> tells underlying environment or compiler, tells them at compilation time to tell that this is being used
    		
    		1. optional annotations (eg - override)
    		2. mandatory annotations (given by spring to automate the process) (eg - @component instead of using bean tag - its a class level annotation)
    		eg-
    		@component
    		class abc{
    		}
    	    
    	    
    	    ---------------------- WE WANT TO USE XML -------------------------------------------------------------------------------
    	    "context:component-scan" tag on top of xml file
    	    spring project will SCAN complete project and look for COMPONENT annotations - scan will need the location of project
    	    - uses classPathXmlApplicationContext class
    		
    		
    		
    		--------> XML file:
    		[ctr = shft +/ ]
    		Enable component scan
    		<context:component-scan base-package="org.ncu.Calculator"></context:component-scan>
    		
    		--------> DEPENDENCY CLASSES AND DEPENDANT CLASS - classes that have beans
    		@component  ..........ctrl+space
    		- takes class name as bean id with first letter small [default]
    		- if we want to change --- @component("calc") -- calc is bean id 
    		we should not put custom bean id as a good coding practice...they should be default only
    		
    		@component annotation  --- stereotype annotation (templates, no implementation, only declared)
    		  -@controller 
    		  -@repository
    		  -@service
    		     ---concrete annotations ( implementation done in subclass )
    		     
    		     
    		----------------- WE DONT WANT TO USE XML ----------------------------------------------------------------------------------
    		--WE WANT TO MAKE DUMMY JAVA CLASS - has no code , only 1 empty class annotated with 
    		  @ComponentScan("location of package")
    		- uses AnnotationConfigApplicationContext("name_of_java_class.class")
    		
    		
    		classpathaplicationcontext -- loads xml file
    		instead use - AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("name of java dummy file")
    		
    		AnnotationConfig - dummy class
    		@configuration
    		@componentScan("location of package")
    		
    		
    		
    		--------- DEPENDENCY INJECTION ---------------------------------------------------------------------------------------------
    		------CONSTRUTOR INJECTION
    		Above constructor - @Autowired 
    		-Make parameterized constructor in calculator & make object of MathService
    			- initialize object of interface MathService
    			--------gives error because 4 beans implement MathService so ambiguous as to which we need
    			
    			-- So, make 4 objects of type MathService
    			-- @Qualifier("additionService") - bean id of class -----add before all arguments
    		
    		------SETTER INJECTION
    		@Autowired - ABOVE SETTER METHOD
    		@Qualifier("additionService") - bean id of class -----add before all arguments
    		
    3. java config 
    
    	1.Initialize spring container
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("config.java")
    	
    	-->config.java - NOT dummy class -- factory class
	    	configurations:
		    	@Configuration
		    	
		    	@Bean -- method level annotation
		    	GreetingService getEngBean(){
		    	 return new EnglishGreetingService();  //hard code return
		    	}
		    	
		    	@Bean
		    	FortuneService getFortuneBean(){
		    		return new FortuneService();
		    	}
		    	
		    	-- GreetingService - type of bean created -- SO SHOULD NOT BE VOID
		    	                                          -- AND SHOULD return some value
		    	-- name of method is bean id
		    	-- custom bean id -> @Bean("---")
	    	
	    
	    CalculatorConfig.java :
	    	@Configuration ---- at top
	    	
	    	whichever bean we need - make method for it
	    	[dependent class]
	    	- @Bean
	    	  Calculator calc(){
	    		return new Calculator();	    		
	          }
	          
	       [dependency classes] - make for all 4
	       - @Bean
	         MathService add(){
	         }
	         
	       FOR INJECTION:
	       	inside method of calculator class : return new Calculator(add(), sub());
	       	
	       	-- add(), sub() are beans of dependency classes [ methods which return beans ]
	       	
	       * no need for componentScan 
	        
	        ------------------------------------------------------------------------------
	        daily workouts:
	        
	        based on sport  - sports interface with method getDailyWorkout()--
	        -- basketball, cricket, football classes with method which prints custom msg 
	        
	        through annotations/ java config
    	    ------------------------------------------------------------------------------
    
 3) -> mainApp.java
	1. Initialize the spring container [done only once in whole spring application]
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("name of xml file");
		
	2. get the desired beans
		GreetingService service = context.getBean("EnglishService", GreetingService.class) -- (unique identifier,type) 
		[creates object and assigns it a type] --.class as it takes bytecode
		
	3. call the desired method/operation
		service.greet("Shreya")
		
	4. Close the spring context [make it available for garbage disposal]
		context.close()
    
    
    



 */