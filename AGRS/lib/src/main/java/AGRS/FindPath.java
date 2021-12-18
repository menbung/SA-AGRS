package AGRS;


import java.util.*;


import java.awt.*;
/**
 * 
 */
public class FindPath implements FindPathStrategy {
	
    /**
     * Default constructor
     */
	
	private ArrayList<A_Data> OpenList = new ArrayList<A_Data>();
	private ArrayList<A_Data> CloseList = new ArrayList<A_Data>();
	private ArrayList<Point> Path = new ArrayList<>(); //留덉�留됱뿉 寃쎈줈瑜� ���옣�븷 怨녹씠�떎.
	
    public FindPath() {
    	
    }

    public ArrayList<Point> findPath(int gate_num) {
    	// Map 占쌀뤄옙占쏙옙占쏙옙
    	Map airportMap = Map.getInstance();
    	
    	int startx = airportMap.getRobot().getX();
    	int starty = airportMap.getRobot().getY();
    	
    	int endx = airportMap.getGateLocation(gate_num).getX();
    	int endy = airportMap.getGateLocation(gate_num).getY();
    	
    	int nowIndex = 0;
    	CloseList.add(new A_Data(startx, starty, -1, 0, 0)); //�떆�옉吏��젏�쓣 諛붾줈 �깘�깋�븷 �닔 �엳�룄濡� CloseList�뿉 誘몃━ �꽔�뼱以��떎.
    	while (CloseList.get(nowIndex).x != endx || CloseList.get(nowIndex).y != endy) { // 紐⑹쟻吏��뿉 �룄李⑺븷�븣源뚯� 諛섎났�븳�떎.
    		for (int way = 0; way < 4; way++) { // �긽�븯醫뚯슦 �닚�꽌
    			int nowx = CloseList.get(nowIndex).x;
    			int nowy = CloseList.get(nowIndex).y;
    			boolean flag = false;	// �빐�떦 �쐞移섍� �뿴由�, �떕�엺由ъ뒪�듃以묒뿉 �엳�뒗媛� �솗�씤�븷�븣 �벖�떎.
    			if (way == 0) nowy++;
    			else if (way == 1) nowy--;
    			else if (way == 2) nowx--;
    			else if (way == 3) nowx++;
    		
    			for (int i = 0; i < CloseList.size(); i++) {
    				if (CloseList.get(i).x == nowx && CloseList.get(i).y == nowy) {
    					flag = true;
    				}
    			}
    			
    			for (int i = 0; i < OpenList.size(); i++) { // �뿴由곕━�뒪�듃�뿉 �씠誘� 議댁옱�븳�떎硫�
    				if (OpenList.get(i).x == nowx && OpenList.get(i).y == nowy) {
    					flag = true;
    					 if (OpenList.get(i).G > CloseList.get(nowIndex).G + 1) {
    						 OpenList.set(i,new A_Data(nowx, nowy, nowIndex, CloseList.get(nowIndex).G + 1, OpenList.get(i).H));
    					 }
    				}
    			}
    			
    			if (flag == false) { // �뿴由�, �떕�엺由ъ뒪�듃�뿉 �뾾�떎硫� �뿴由곕━�뒪�듃�뿉 �깉濡� 異붽��빐以�
    				OpenList.add(new A_Data(nowx, nowy, nowIndex, CloseList.get(nowIndex).G + 1,Math.abs(endx - nowx) + Math.abs(endy - nowy)));
    			}
    		}
    		
    		if (OpenList.size() != 0) { // �삤�뵂由ъ뒪�듃�뿉�꽌 湲곕�嫄곕━媛� �젣�씪 �옉��寃껋쓣 怨⑤씪 �깘�깋�쐞移섎줈 �꽕�젙
    			int Ftemp = OpenList.get(0).F;
    			int Indextemp = 0;
    			for (int i = 0; i < OpenList.size(); i++) {
    				if (OpenList.get(i).F < Ftemp) {
    					Ftemp = OpenList.get(i).F;
    					Indextemp = i;
    				}
    				else if (OpenList.get(i).F == Ftemp) { // 留뚯씪 F媛믪씠 �룞�씪�븯�떎硫� H媛믪씠 �옉��寃껋쓣 �깮�븳�떎.
    					 if (OpenList.get(i).H < OpenList.get(Indextemp).H) {
    						 Indextemp = i;
    					 }
    				}
    			}
    			CloseList.add(OpenList.get(Indextemp));
    			OpenList.remove(Indextemp);  //CloseList�뿉 �깘�깋�븷 �쐞移섎�� �꽔�뼱二쇨퀬 OpenList�뿉�꽌 吏��슫�떎.
    			nowIndex++;
    			
    		}else {// OpenList媛� 鍮꾩뿀�떎硫� 寃쎈줈 �뾾�쓬
    			System.out.println("Location Error");
    			break;
    		}
    		
    	}
    	
    	while (nowIndex != -1) { // �룄李⑹��젏遺��꽣 �뿭�닚�쑝濡� �릺吏싳뼱媛꾨떎
    		Point path_point = new Point(CloseList.get(nowIndex).x, CloseList.get(nowIndex).y);
    		Path.add(path_point);// + " " + CloseList.get(nowIndex).y);
    		nowIndex = CloseList.get(nowIndex).p_index;
    	}
    	
//    	while (Path.size() != 0) { // �릺吏싳뼱媛� 寃쎈줈瑜� �떎�떆 �썝�옒��濡� 異쒕젰�븳�떎.
//    		// �뿬湲곗꽌 Handler瑜� �뜥�꽌 �꽆�뼱媛덇쾬. GUI泥섎━ �븘�슂.
//    		
//    		System.out.println(Path.get(Path.size() - 1)[0] + " " + Path.get(Path.size() - 1)[1]);
//    		Path.remove(Path.size() - 1);
//    	}
        return Path;
    }

}