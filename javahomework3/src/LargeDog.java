//package inheritance;
/**
 * This is a class which extended from Dog class.
 * 
 * @version 1.0, 2018-10-19.
 * @author He Yongqiang.
 *
 */
public class LargeDog extends Dog
{
	private double weight;
	
	public static void info()
	{
		System.out.println("LargeDog绫绘弿杩板法鍨嬬姮銆�");
	}

	public LargeDog(int weight)
	{
		this.weight=weight;
	}
	public LargeDog(String name, String color, double age,double weight)
	{
		super(name,color,age);
		this.weight=weight;
	}
	
	@Override
	public void run()
	{
		System.out.println("鎴戝彲浠ヨ窇鐨勯蹇紒");
	}
	@Override
	public void show()
	{
		super.show();
		System.out.println("weight:"+weight);
		
	}
	public double getWight()
	{
		return weight;
	}
	
	
	public boolean equals(Object otherObject)
	{
		if(this==otherObject)
			return true;
		
		if(otherObject==null)
			return false;
		
		if(getClass()!=otherObject.getClass())
			return false;
		
		LargeDog other=(LargeDog)otherObject;
		
		return name.equals(other.name)&&color.equals(other.color)&&age==other.age&&weight==other.weight ;
		
	//	if((this.name==D.name)&&(this.color==D.color)&&(this.age==D.age))
	//		return true;
	}
//	public boolean equals(LargeDog L)
//	{
//		if((this.name==L.name)&&(this.color==L.color)&&(this.age==L.age)&&(this.weight==L.weight))
//			return true;
//	}
	
	public void hashcode()
	{
		System.out.println(this.hashCode());
	}
	
	public String toString()
	{
		return "Dog[name="+name+",color="+color+",age="+age+",weight="+weight+"]";
	}
	}
	

