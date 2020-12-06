package inheritance;

public class Triangle extends Shape
{
	// 瀹氫箟涓夎褰㈢殑涓夎竟
	private double a;
	private double b;
	private double c;
	public Triangle(String color , double a
		, double b , double c)
	{
		super(color);
		this.setSides(a , b , c);
	}
	public void setSides(double a , double b , double c)
	{
		if (a >= b + c || b >= a + c || c >= a + b)
		{
			System.out.println("涓夎褰袱杈逛箣鍜屽繀椤诲ぇ浜庣涓夎竟");
			return;
		}
		this.a = a;
		this.b = b;
		this.c = c;
	}
	// 閲嶅啓Shape绫荤殑鐨勮绠楀懆闀跨殑鎶借薄鏂规硶
	public double calPerimeter()
	{
		return a + b + c;
	}
	// 閲嶅啓Shape绫荤殑鐨勮繑鍥炲舰鐘剁殑鎶借薄鏂规硶
	public String getType()
	{
		return "涓夎褰�";
	}
	
	public boolean equals(Object otherObject)
	{
		
		if(this==otherObject)
			return true;
		
		if(otherObject==null)
			return false;
		
		if(getClass()!=otherObject.getClass())
			return false;
		
		Triangle other=(Triangle)otherObject;
		
	   return	(color.equals(other.color))&&(this.a==T.a)&&(this.b==T.b)&&(this.c==T.c) ;
		
	}
	
	public String toString()
	{
		return "Triangle[color="+color+",a="+a+",b="+b+",c="+c+"]";
	}
}
