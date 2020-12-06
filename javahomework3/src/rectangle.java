

public class rectangle extends Shape
{
//	private double a;
//	private double b;
//	private double c;
//	private double d;
	
	private point A;
	private point B;

	public rectangle(String color , point A , point B)
		{
			super(color);
			this.A = A;
			this.B = B;
//			this.c = c;
//			this.d = d;
		}
	
	
	public boolean equals(Object otherObject)
	{
		if(this==otherObject)
			return true;
		
		if(otherObject==null)
			return false;
		
		if(getClass()!=otherObject.getClass())
			return false;
		
		rectangle other=(rectangle)otherObject;
		
		return A.x==other.A.x&&A.y==other.A.y&&B.x==other.B.x&&B.y==other.B.y ;
		
	//	if((this.name==D.name)&&(this.color==D.color)&&(this.age==D.age))
	//		return true;
	}
	
	public String toString()
	{
		return "rectangle[A="+A+",B="+B+"]";
	}
	
	
//	public boolean equals(rectangle r)
//	{
//		if((this.color==r.color)&&(this.a==r.a)&&(this.b==r.b)&&(this.c==r.c)&&(this.d==r.d))
//			return true;
//	}
	
	
	public static void main(String[] args)
	{
		String r="red";
		point A=new point(1,1);  //我需要用构造函数创建，不能这样创建一个对象。
		point B=new point(2,2);
	//	A.x=1;
	//    A.y=1;
	//   B.x=2;
	//   B.y=2;
		
		rectangle R=new rectangle(r,A,B);
		
		rectangle R1=new rectangle(r,A,B);
		
		System.out.println(R.equals(R1));
		System.out.println(R.toString());
		
	}


	@Override
	public double calPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	}
	
