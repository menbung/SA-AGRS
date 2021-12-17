package AGRS;


import java.util.*;


import java.awt.*;
/**
 * 
 */
public class FindPath implements Strategy {
	
    /**
     * Default constructor
     */
	
	private static ArrayList<A_Data> OpenList = new ArrayList<A_Data>();
	private static ArrayList<A_Data> CloseList = new ArrayList<A_Data>();
	private static ArrayList<int[]> Path = new ArrayList<int[]>(); //마지막에 경로를 저장할 곳이다.
	
    public FindPath() {
    	System.out.println("error_test");	// 게이트 정보가 안들어올 경우.
    	
    }
    
    public FindPath(String gate_num) {
    	// Map 불러오기
//    	Map airportMap = new Map();	//그냥 static으로 함.
//    	map=airportMap.getMap();
    	
    	int startx = Map.getRobot().getX();
    	int starty = Map.getRobot().getY();
    	
    	int endx = Map.getGateLocation(Integer.parseInt(gate_num)).getX();
    	int endy = Map.getGateLocation(Integer.parseInt(gate_num)).getY();
    	
    	int nowIndex = 0;
    	CloseList.add(new A_Data(startx, starty, -1, 0, 0)); //시작지점을 바로 탐색할 수 있도록 CloseList에 미리 넣어준다.
    	while (CloseList.get(nowIndex).x != endx || CloseList.get(nowIndex).y != endy) { // 목적지에 도착할때까지 반복한다.
    		for (int way = 0; way < 4; way++) { // 상하좌우 순서
    			int nowx = CloseList.get(nowIndex).x;
    			int nowy = CloseList.get(nowIndex).y;
    			boolean flag = false;	// 해당 위치가 열린, 닫힌리스트중에 있는가 확인할때 쓴다.
    			if (way == 0) nowy++;
    			else if (way == 1) nowy--;
    			else if (way == 2) nowx--;
    			else if (way == 3) nowx++;
    		
    			for (int i = 0; i < CloseList.size(); i++) {
    				if (CloseList.get(i).x == nowx && CloseList.get(i).y == nowy) {
    					flag = true;
    				}
    			}
    			
    			for (int i = 0; i < OpenList.size(); i++) { // 열린리스트에 이미 존재한다면
    				if (OpenList.get(i).x == nowx && OpenList.get(i).y == nowy) {
    					flag = true;
    					 if (OpenList.get(i).G > CloseList.get(nowIndex).G + 1) {
    						 OpenList.set(i,new A_Data(nowx, nowy, nowIndex, CloseList.get(nowIndex).G + 1, OpenList.get(i).H));
    					 }
    				}
    			}
    			
    			if (flag == false) { // 열린, 닫힌리스트에 없다면 열린리스트에 새로 추가해줌
    				OpenList.add(new A_Data(nowx, nowy, nowIndex, CloseList.get(nowIndex).G + 1,Math.abs(endx - nowx) + Math.abs(endy - nowy)));
    			}
    		}
    		
    		if (OpenList.size() != 0) { // 오픈리스트에서 기대거리가 제일 작은것을 골라 탐색위치로 설정
    			int Ftemp = OpenList.get(0).F;
    			int Indextemp = 0;
    			for (int i = 0; i < OpenList.size(); i++) {
    				if (OpenList.get(i).F < Ftemp) {
    					Ftemp = OpenList.get(i).F;
    					Indextemp = i;
    				}
    				else if (OpenList.get(i).F == Ftemp) { // 만일 F값이 동일하다면 H값이 작은것을 택한다.
    					 if (OpenList.get(i).H < OpenList.get(Indextemp).H) {
    						 Indextemp = i;
    					 }
    				}
    			}
    			CloseList.add(OpenList.get(Indextemp));
    			OpenList.remove(Indextemp); //CloseList에 탐색할 위치를 넣어주고 OpenList에서 지운다.
    			nowIndex++;
    			
    		}else {// OpenList가 비었다면 경로 없음
    			System.out.println("Location Error");
    			break;
    		}
    		
    	}
    	
    	while (nowIndex != -1) { // 도착지점부터 역순으로 되짚어간다
    		int[] pathtemp = { CloseList.get(nowIndex).x, CloseList.get(nowIndex).y };
    		Path.add(pathtemp);// + " " + CloseList.get(nowIndex).y);
    		nowIndex = CloseList.get(nowIndex).p_index;
    	}
    	
    	while (Path.size() != 0) { // 되짚어간 경로를 다시 원래대로 출력한다.
    		// 여기서 Handler를 써서 넘어갈것. GUI처리 필요.
    		
    		System.out.println(Path.get(Path.size() - 1)[0] + " " + Path.get(Path.size() - 1)[1]);
    		Path.remove(Path.size() - 1);
    	}
    }



    /**
     * @return
     */
    public Vector<Point> findPath() {
        // TODO implement here
    	
    	//이거 어따씀
        return null;
    }

}
