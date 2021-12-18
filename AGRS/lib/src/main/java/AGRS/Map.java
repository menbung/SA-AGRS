package AGRS;


import java.util.*;
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
	private ServerTarget server;
	
    /**
     * Default constructor
     */
    private Map() {
    	server = ServerAdapter.getInstance();
    	gate_location=new ArrayList<>();
    	gateNum=8;
    	
    	int[] map_size = server.mapReq();
    	mapSizeW=map_size[0];
    	mapSizeH=map_size[1];
    	robot = new Point(6,2);
    	
    	
//    	Vector<Integer> mapW=new Vector<Integer>(Arrays.asList(
//    			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
//    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
//    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
//    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
//    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
//    			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
//    			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
//    			));
    	
    	map=new Vector<Vector<Integer>>();
    	for(int row=0; row<mapSizeH; row++) {
    		Vector<Integer> row_vec = new Vector<Integer>();
    		for(int col=0; col<mapSizeW; col++) {
    			if(row == 0 || row == mapSizeH-1 || col == 0 || col == mapSizeW-1)
    				row_vec.add(1);
    			else
    				row_vec.add(0);
    		}
    		map.add(row_vec);
    	}
    	
    	
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
		return gate_location.get(gate_num-1);
	}
	
	
	public Point getRobot() {
		return robot;
	}

	
}

