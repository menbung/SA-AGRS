package AGRS;


import java.util.*;

import javax.swing.JButton;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 */
public class GuidanceHandler {

	private Point myPoint;
   	private Point endPoint;
   	private ArrayList<Point> path;

	private Map airport_map;
	private GuidanceGUI guidancegui;
	private FindPathStrategy find_path;
    /**
     * Default constructor
     */
    public GuidanceHandler(int gateNum) {
    	init(gateNum);
    	Thread navi_thread = new Thread(new navi(path, guidancegui, gateNum));//길 안내 기능 쓰레드로 생성
    	navi_thread.start();//길 안내 시작
    	JButton menu_btn = guidancegui.getMenuBtn();
        menu_btn.addMouseListener(new MouseAdapter() {//메뉴 버튼에 리스너 연결
			@Override
			public void mousePressed(MouseEvent e) {
				navi_thread.interrupt();//길 안내 기능(쓰레드) 종료
				airport_map.robotInit();
				new MainGUI();
				guidancegui.dispose();
			}
		});
    }
    
    public void init(int gateNum) {
    	airport_map = Map.getInstance();
    	find_path = new FindPath();
        path=find_path.findPath(gateNum);
        myPoint=airport_map.getRobot();
        endPoint=airport_map.getGateLocation(gateNum);
        guidancegui = new GuidanceGUI(myPoint,endPoint,path);
        guidancegui.setVisible(true);
    }

}