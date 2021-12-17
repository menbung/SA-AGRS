package AGRS;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.awt.*;
/**
 * 
 */
public class Map {
	private int mapSizeW;
	private int mapSizeH;
	private Vector<Vector<Integer>> map = null;
	private int gateNum;
	private Point robot;
	private ArrayList<Point> gate_location;
	
	
    /**
     * Default constructor
     */
    public Map() {
    	gateNum=10;
    	mapSizeW=24;
    	mapSizeH=12;
//    	robot.setLocation(6,2);
    	
//    	// ���߿� DB���� �ʺҷ����� �Ѵٸ� �̰� �ݺ��� ����ؼ� �̿�.
//    	ArrayList mapArray = new ArrayList();
//    	mapArray.add("1");
//    	mapArray.add("0");
//    	mapArray.add("0");
    	
//    	Vector<Integer> vector=new Vector<Integer>(mapArray);
    	
    	//Map(0~12, 0~6 ũ��) ǥ�� ��� 0 ������� 1 ��ֹ� 
    	//row = ���� = height , col = ���� = width
    	
    	Vector<Integer> mapW=new Vector<Integer>(Arrays.asList(
    			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
    			1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1,
    			1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1,
    			1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1,
    			1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1,
    			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
    			));
    	
    	map=new Vector<Vector<Integer>>();
    	for(int row=0;row<mapW.size()/mapSizeW;row++)
    	    map.add(new Vector<Integer>(mapW.subList(row*mapSizeW, (row+1)*mapSizeW)));
    	
    	
    	gate_location.add(convertPoint(0,3));	//1�� ����Ʈ
    	gate_location.add(convertPoint(0,6));	//2�� ����Ʈ
    	gate_location.add(convertPoint(0,9));	//3�� ����Ʈ
    	gate_location.add(convertPoint(6,3));	//4�� ����Ʈ
    	gate_location.add(convertPoint(6,6));	//5�� ����Ʈ
    	gate_location.add(convertPoint(6,9));	//6�� ����Ʈ
    	gate_location.add(convertPoint(3,0));	//7�� ����Ʈ
    	gate_location.add(convertPoint(3,12));	//8�� ����Ʈ
    	
    	
    	
    	
    }


    public Vector<Vector<Integer>> getMap() {
        // TODO implement here
    	
        return map;
    }
    
    public int getWidth() {
    
    	return mapSizeW;
    }
    
    public int getHeight() {
    	
    	return mapSizeH;
    }

    
  //row = ���� = height , col = ���� = width, row-col ���� �Է�= ���θ��� �Է��Ұ�
	public int get(int row, int col) {
		// TODO Auto-generated method stub
		return map.get(row).get(col);
		
	}
    
    
	public Point convertPoint(int row, int col) {
		Point p1=null;
//		p1.setLocation(row,col);
		
		return p1;
	}
	
	
}