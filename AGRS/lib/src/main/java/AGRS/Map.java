package AGRS;


import java.util.*;
/**
 * 
 */
public class Map {
	private static Map instance;
	private int mapSizeW; //map width size
	private int mapSizeH; //map height size
	private Vector<Vector<Integer>> map;
	private int gateNum; //total number of Gates
	private Point robot; // robot's current location
	private Point start_point; //robot's starting location;
	private ArrayList<Point> gate_location; //list of gates' location
	private ServerTarget server; //server adapter
	
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
    	start_point = new Point(6,2);
    	
    	map=new Vector<Vector<Integer>>(); //initialize map
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
    	
    	
    	gate_location.add(new Point(3,0));	//1 gate location
    	gate_location.add(new Point(6,0));	//2 gate location
    	gate_location.add(new Point(9,0));	//3 gate location
    	gate_location.add(new Point(3,6));	//4 gate location
    	gate_location.add(new Point(6,6));	//5 gate location
    	gate_location.add(new Point(9,6));	//6 gate location
    	gate_location.add(new Point(0,3));	//7 gate location
    	gate_location.add(new Point(12,3));	//8 gate location
    	
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

    
  //row = height , col = width
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

	public void setRobot(int x, int y) {
		robot.setXY(x, y);
	}
	
	public void robotInit() {
		robot.setXY(start_point.getX(), start_point.getY());
	}
}

