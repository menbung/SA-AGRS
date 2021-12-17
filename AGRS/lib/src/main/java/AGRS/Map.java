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
    	
//    	// 나중에 DB에서 맵불러오기 한다면 이거 반복문 사용해서 이용.
//    	ArrayList mapArray = new ArrayList();
//    	mapArray.add("1");
//    	mapArray.add("0");
//    	mapArray.add("0");
    	
//    	Vector<Integer> vector=new Vector<Integer>(mapArray);
    	
    	//Map(0~12, 0~6 크기) 표시 방법 0 비어있음 1 장애물 
    	//row = 세로 = height , col = 가로 = width
    	
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
    	
    	
    	gate_location.add(convertPoint(0,3));	//1번 게이트
    	gate_location.add(convertPoint(0,6));	//2번 게이트
    	gate_location.add(convertPoint(0,9));	//3번 게이트
    	gate_location.add(convertPoint(6,3));	//4번 게이트
    	gate_location.add(convertPoint(6,6));	//5번 게이트
    	gate_location.add(convertPoint(6,9));	//6번 게이트
    	gate_location.add(convertPoint(3,0));	//7번 게이트
    	gate_location.add(convertPoint(3,12));	//8번 게이트
    	
    	
    	
    	
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

    
  //row = 세로 = height , col = 가로 = width, row-col 순의 입력= 세로먼저 입력할것
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