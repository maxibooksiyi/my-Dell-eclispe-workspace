import java.util.Random;
import java.math.*;


public class RW
{
public static void main(String[] args)
{
	int t;
	double a1=0,a2=0,n,m,e=0,jiaodu,buchang,buchang1=0,Z=0;
		for(t=0;t<200;t++)
		{
			buchang=Math.random();
			jiaodu=Math.random();
			m=Math.sin(jiaodu);
			n=Math.cos(jiaodu);
			
			buchang1=buchang1+buchang;
			
			a1=a1+buchang*m;
			a2=a2+buchang*n;
			e=Math.atan(a2/a1);
			Z=(a1+a2)/(2*buchang1);
			
		}
		System.out.println("路程：");
		System.out.println(a1);
		System.out.println("方向：");
		System.out.println(e);
		System.out.println("效率：");
		System.out.println(Z);
}
}