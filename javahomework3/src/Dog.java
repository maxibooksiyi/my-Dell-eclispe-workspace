//package inheritance;

import javax.swing.Spring;

/**
 * This is a superclass.
 * @version1.0, 2018-10-19
 * @author He Yongqiang.
 *
 */
public class Dog 
{
	private String name="noname";
	private String color="unknown";
	private double age=0.0;
	////////////////////
	public static void info()
	{
		System.out.println("Dog绫绘弿杩扮嫍杩欑鍔ㄧ墿銆�");
	}
	public Dog(String name, String color)
	{
		this.name=name;
		this.color=color;
		this.age=0;
	}
	public Dog(String name, String color, double age)
	{
		this( name, color);
		this.age=age;
	}
	
	public  Dog()
	{
//		this.name="noname";
//		this.color="not know";
//		this.age=0;
	}
	
	public void setDog(String name, String color, double age)
	{
		this.name=name;
		this.color=color;
		this.age=age;		
	}
	public void show()
	{
		System.out.println("name:"+name);
		System.out.println("color:"+color);
		System.out.println("age:"+age);
	}
	public void run()
	{
		System.out.println("鎴戝彲浠ヨ窇銆�");
	}
	
	
	public boolean equals(Object otherObject)
	{
		if(this==otherObject)
			return true;
		
		if(otherObject==null)
			return false;
		
		if(getClass()!=otherObject.getClass())
			return false;
		
		Dog other=(Dog)otherObject;
		
		return name.equals(other.name)&&color.equals(other.color)&&age==other.age ;
		
	//	if((this.name==D.name)&&(this.color==D.color)&&(this.age==D.age))
	//		return true;
	}
	
	public void hashcode()
	{
		System.out.println(this.hashCode());
	}
	
	public String toString()
	{
		return "Dog[name="+name+",color="+color+",age="+age+"]";
	}
	}
	

