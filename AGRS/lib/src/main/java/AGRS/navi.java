package AGRS;

import java.util.ArrayList;

/**
 * 
 */
public class navi implements Runnable{
	private ArrayList<Point> path;
	private GuidanceGUI guidance_gui;
	private Map map_model;
	private int gate_num;
    public navi(ArrayList<Point> path, GuidanceGUI guidance_gui, int gate_num) {
    	this.path = path;
    	this.guidance_gui = guidance_gui;
    	this.gate_num = gate_num;
    	map_model = Map.getInstance();
    }

	@Override
	public void run() {//멀티 쓰레드로 하는 기능
		// TODO Auto-generated method stub
		System.out.println("nivi start");
		try {
			//3초에 한번씩 이동 및 경로 업데이트
			for(int i=0; i<path.size()-1; i++) {
				Thread.sleep(3000);
				int x = path.get(path.size()-i-2).getX();
				int y = path.get(path.size()-i-2).getY();
				map_model.setRobot(x, y);
				guidance_gui.UpdateRoute(x, y, i);
			}
			String text = Integer.toString(gate_num);
			text += "\uBC88 \uAC8C\uC774\uD2B8\uC5D0 \uB3C4\uCC29\uD588\uC2B5\uB2C8\uB2E4";
			guidance_gui.setTitleText(text);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		
		System.out.println("novi end");
	}

}