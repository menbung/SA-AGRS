package AGRS;

public class A_Data {
	public int x;
	public int y;
	public int p_index;
	public int G;
	public int H;
	public int F;
	

	public A_Data(int x, int y, int p_index, int G, int H) {
		this.x=x;
		this.y=y;
		this.p_index=p_index;
		this.G=G;
		this.H=H;
		this.F=G+H;
	}	
}
