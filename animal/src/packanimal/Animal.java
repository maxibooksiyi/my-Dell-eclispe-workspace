
//写程序关键是真正自己开始动手写，不要总是想着等全部弄懂了再写，可以自己先定个小目标，先写个小点简单点的功能，再一步步往上加。真正自己写起来之后其实感觉也还好。你甚至就可以根据自己的理解去写。
//不要总是想着等我花很多时间把书都真正看懂整理清楚了再写，那你永远都可能没底气，你也没那么多时间。

package packanimal;
public class Animal
{
	
	private
	String  name;
	String  color;
	int     weight;
	int     number;
	static int  nextId; 
	
	
	
	
//	public static void main(String[] args)
//    {
	   
//    }
   
   

void Animal()
   {
	   
   }
   
   public Animal(String  name,String  color,int     weight)
   {
	   this.name=name;
	   this.color=color;
	   this.weight=weight;
	   nextId++;
   }
   
   
   public void getinformation()
   {
	   System.out.println(this.name);
	   System.out.println(this.color);
	   System.out.println(this.weight);
	   System.out.println(nextId);
   }
   
   public void setcolor(String  color)
   {
	   this.color=color;
   }
   
   public void setweight(int  weight)
   {
	   this.weight=weight;
   }
   
 }