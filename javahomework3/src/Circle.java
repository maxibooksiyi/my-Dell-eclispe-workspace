package inheritance;

public class Circle extends Shape
{
	private double radius;
	private point A;
	public Circle(String color , double radius , point A)
	{
		super(color);
		this.radius = radius;
		this.A=A;
	}
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	// 重写Shape类的的计算周长的抽象方法
	@Override
	public double calPerimeter()
	{
		return 2 * Math.PI * radius;
	}
	// 重写Shape类的的返回形状的抽象方法
	@Override
	public String getType()
	{
		return getColor() + "圆形";
	}
	
	public boolean equals(Object otherObject)
	{
		if(this==otherObject)
			return true;
		
		if(otherObject==null)
			return false;
		
		if(getClass()!=otherObject.getClass())
			return false;
		
		Circle other=(Circle)otherObject;
		
		return color.equals(other.color)&&A.x==other.A.X&&A.y==other.A.y ;
		
	//	if((this.name==D.name)&&(this.color==D.color)&&(this.age==D.age))
	//		return true;
	}
	
	public String toString()
	{
		return "Circle[color="+color+",radius="+radius+",A="+A+"]";
	}
	
	public static void main(String[] args)
	{
		Shape s1 = new Triangle("黑色" , 3 , 4, 5);
		Shape s2 = new Circle("黄色" , 3);
		System.out.println(s1.getType());
		System.out.println(s1.calPerimeter());
		System.out.println(s2.getType());
		System.out.println(s2.calPerimeter());
	}
}
