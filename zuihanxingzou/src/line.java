import java.math.*;

public class line extends point
{
	float xielv;
	String color;
	float xiankuan;
	float changdu;
	
	
	 

    public line(int a[],int b[],String color,float xiankuan)   //似乎构造函数这里需要加个public，不然创建类对象时不行、
	{
		this.xielv=(a[1]-b[1])/(a[0]-b[0]);
		this.changdu=(float) Math.sqrt((a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]));
		this.color=color;
		this.xiankuan=xiankuan;
			
	}
	
	public static void main(String[] args)
	{
		
		String r="red";
		float k=1;
		int a[]= {0,1};
		int b[]= {1,2};
		
		line L =new line(a,b,r,k);
	    
		L.lineinformateion();
	}
	
	public void lineinformateion()    //打印线的信息
	{
		System.out.println(this.changdu);
	}

	

}