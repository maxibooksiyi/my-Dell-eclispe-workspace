

//�����д����Ȼ�ᱨ��
public enum week {
    MON,TUE,WED,THU,FRI,SAT,SUN;   
	
	
	public static void main(String[] args)  //main����д�������棬������ö���࣬����String[] args����Ҫд����Ȼrun���ˡ�
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
		    default:System.out.println("��Ч������");
		}
	}
}


