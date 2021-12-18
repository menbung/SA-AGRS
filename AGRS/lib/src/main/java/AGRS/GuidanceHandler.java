package AGRS;


import java.util.*;
import java.awt.*;

/**
 * 
 */
public class GuidanceHandler {

	public Point myPoint;
   	public Point endPoint;
   	public ArrayList<Point> path;

	private Map airport_map;
    /**
     * Default constructor
     */
    public GuidanceHandler(int gateNum) {
    	airport_map = Map.getInstance();
    	FindPathStrategy find_path = new FindPath();
        path=find_path.findPath(gateNum);
        myPoint=airport_map.getRobot();
        endPoint=airport_map.getGateLocation(gateNum);
        System.out.println(myPoint.getX()+"/"+ myPoint.getY());
        System.out.println(endPoint.getX()+"/"+endPoint.getY());
        GuidanceGUI guidancegui = new GuidanceGUI(myPoint,endPoint,path);
       guidancegui.setVisible(true);
    }

    /**
     * 
     */
    /**
     * 
     */
//    public ActionListener guidance_listener;






    /**
     * 
     */
    public void printMap() {
        // TODO implement here
    }

}