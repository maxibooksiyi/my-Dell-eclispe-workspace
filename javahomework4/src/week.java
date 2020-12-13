

//必须大写，不然会报错。
public enum week {
    MON,TUE,WED,THU,FRI,SAT,SUN;   
	
	
	public static void main(String[] args)  //main必须写在类里面，哪怕是枚举类，还有String[] args必须要写，不然run不了。
	{
		
		week d = week.MON;
		  switch(d) {
		    case MON: System.out.println(d.toString());break;
		    case TUE: System.out.println(d.toString());break;
		    case WED: System.out.println(d.toString());break;
		    case THU: System.out.println(d.toString());break;
		    case FRI: System.out.println(d.toString());break;
		    case SAT: System.out.println(d.toString());break;
		    case SUN: System.out.println(d.toString());break;
		    default:System.out.println("无效的名称");
		}
	}
}


