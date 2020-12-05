import java.math.*;
import java.util.Random;



public class zuihanxingzou
{
   public static void main(String[] args)
    {
		int i;
		double y=0;
		double x=0;
		double n;
		double m;
		double b;
		double a,zong = 0,fangxiang=0;
		double xiaolv = 0;
		for( i = 0 ; i < 1000 ; i++ )
		{
			//Random ran1 = new Random(1);
			//Random ran2 = new Random(1);
			
			a=Math.random();
			b=Math.random();
			m=Math.sin(b);
			n=Math.cos(b);
			y=y+a*m;
			x=x+a*n;
			zong=Math.sqrt(x*x+y*y);
			fangxiang=Math.atan(y/x);
			xiaolv=Math.sqrt(x*x+y*y)/1000;  //计算效率
			
		}
		
		
		
		System.out.println("x方向的位移是");
		System.out.println(x);  
		System.out.println("y方向的位移是");
		System.out.println(y);
		System.out.println("总的直线位移是");
		System.out.println(zong);
		System.out.println("总的走路方向是");
		System.out.println(fangxiang);
		System.out.println("走路的效率是：");
		System.out.println(xiaolv);
   }

}
