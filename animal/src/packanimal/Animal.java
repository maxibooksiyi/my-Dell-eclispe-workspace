
//д����ؼ��������Լ���ʼ����д����Ҫ�������ŵ�ȫ��Ū������д�������Լ��ȶ���СĿ�꣬��д��С��򵥵�Ĺ��ܣ���һ�������ϼӡ������Լ�д����֮����ʵ�о�Ҳ���á��������Ϳ��Ը����Լ������ȥд��
//��Ҫ�������ŵ��һ��ܶ�ʱ����鶼�������������������д��������Զ������û��������Ҳû��ô��ʱ�䡣

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