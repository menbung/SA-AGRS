package AGRS;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.awt.*;
/**
 * 
 */
public class Map {
	private static Map instance;
	private String Map;
	private int mapSizeW;
	private int mapSizeH;
	private Vector<Vector<Integer>> map;
	private int gateNum;
	private Point robot;
	private ArrayList<Point> gate_location;
	
	
    /**
     * Default constructor
     */
    private Map() {
    	gate_location=new ArrayList<>();
    	gateNum=8;
    	mapSizeW=25;
    	mapSizeH=13;
    	robot = new Point(6,2);
    	
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
    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
    			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
    			));
    	
    	map=new Vector<Vector<Integer>>();
    	for(int row=0;row<mapW.size()/mapSizeW;row++)
    	    map.add(new Vector<Integer>(mapW.subList(row*mapSizeW, (row+1)*mapSizeW)));
    	
    	
    	gate_location.add(new Point(3,0));	//1번 게이트
    	gate_location.add(new Point(6,0));	//2번 게이트
    	gate_location.add(new Point(9,0));	//3번 게이트
    	gate_location.add(new Point(3,6));	//4번 게이트
    	gate_location.add(new Point(6,6));	//5번 게이트
    	gate_location.add(new Point(9,6));	//6번 게이트
    	gate_location.add(new Point(0,3));	//7번 게이트
    	gate_location.add(new Point(12,3));	//8번 게이트
    	
    }

    public static Map getInstance() {
    	if (instance == null)
    		instance = new Map();
    	return instance;
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
	
	public Point getGateLocation(int gate_num) {
		return gate_location.get(gate_num);
	}
	
	
	public Point getRobot() {
		return robot;
	}
	
	
}


