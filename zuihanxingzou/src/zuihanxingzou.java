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
			xiaolv=Math.sqrt(x*x+y*y)/1000;  //����Ч��
			
		}
		
		
		
		System.out.println("x�����λ����");
		System.out.println(x);  
		System.out.println("y�����λ����");
		System.out.println(y);
		System.out.println("�ܵ�ֱ��λ����");
		System.out.println(zong);
		System.out.println("�ܵ���·������");
		System.out.println(fangxiang);
		System.out.println("��·��Ч���ǣ�");
		System.out.println(xiaolv);
   }

}
