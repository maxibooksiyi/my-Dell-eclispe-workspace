package packanimaltest;
import packanimal.Animal;

public class AnimalTest
{
	
    
	public static void main(String[] args)
    {     
    	 String n="bird";
    	 String b="blue";
    	 String r="red";
    	 Animal  A = new Animal(n,b,10) ;
    	 
	     A.setcolor(r);
	     A.getinformation();
    }

}