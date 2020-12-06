//package inheritance;

public abstract class Shape
{
	{
		System.out.println("鎵цShape鐨勫垵濮嬪寲鍧�...");
	}
	private String color;
	// 瀹氫箟涓�涓绠楀懆闀跨殑鎶借薄鏂规硶
	public abstract double calPerimeter();
	// 瀹氫箟涓�涓繑鍥炲舰鐘剁殑鎶借薄鏂规硶
	public abstract String getType();
	// 瀹氫箟Shape鐨勬瀯閫犲櫒锛岃鏋勯�犲櫒骞朵笉鏄敤浜庡垱寤篠hape瀵硅薄锛�
	// 鑰屾槸鐢ㄤ簬琚瓙绫昏皟鐢�
	public Shape(){}
	public Shape(String color)
	{
		System.out.println("鎵цShape鐨勬瀯閫犲櫒...");
		this.color = color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public String getColor()
	{
		return this.color;
	}
}