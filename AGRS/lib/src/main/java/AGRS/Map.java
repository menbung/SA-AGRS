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
    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
    			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
    			));
    	
    	map=new Vector<Vector<Integer>>();
    	for(int row=0;row<mapW.size()/mapSizeW;row++)
    	    map.add(new Vector<Integer>(mapW.subList(row*mapSizeW, (row+1)*mapSizeW)));
    	
    	
    	gate_location.add(new Point(3,0));	//1�� ����Ʈ
    	gate_location.add(new Point(6,0));	//2�� ����Ʈ
    	gate_location.add(new Point(9,0));	//3�� ����Ʈ
    	gate_location.add(new Point(3,6));	//4�� ����Ʈ
    	gate_location.add(new Point(6,6));	//5�� ����Ʈ
    	gate_location.add(new Point(9,6));	//6�� ����Ʈ
    	gate_location.add(new Point(0,3));	//7�� ����Ʈ
    	gate_location.add(new Point(12,3));	//8�� ����Ʈ
    	
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

    
  //row = ���� = height , col = ���� = width, row-col ���� �Է�= ���θ��� �Է��Ұ�
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


