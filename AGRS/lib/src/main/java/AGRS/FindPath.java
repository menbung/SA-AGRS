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
	private static ArrayList<int[]> Path = new ArrayList<int[]>(); //�������� ��θ� ������ ���̴�.
	
    public FindPath() {
    	System.out.println("error_test");	// ����Ʈ ������ �ȵ��� ���.
    	
    }
    
    public FindPath(String gate_num) {
    	// Map �ҷ�����
//    	Map airportMap = new Map();	//�׳� static���� ��.
//    	map=airportMap.getMap();
    	
    	int startx = Map.getRobot().getX();
    	int starty = Map.getRobot().getY();
    	
    	int endx = Map.getGateLocation(Integer.parseInt(gate_num)).getX();
    	int endy = Map.getGateLocation(Integer.parseInt(gate_num)).getY();
    	
    	int nowIndex = 0;
    	CloseList.add(new A_Data(startx, starty, -1, 0, 0)); //���������� �ٷ� Ž���� �� �ֵ��� CloseList�� �̸� �־��ش�.
    	while (CloseList.get(nowIndex).x != endx || CloseList.get(nowIndex).y != endy) { // �������� �����Ҷ����� �ݺ��Ѵ�.
    		for (int way = 0; way < 4; way++) { // �����¿� ����
    			int nowx = CloseList.get(nowIndex).x;
    			int nowy = CloseList.get(nowIndex).y;
    			boolean flag = false;	// �ش� ��ġ�� ����, ��������Ʈ�߿� �ִ°� Ȯ���Ҷ� ����.
    			if (way == 0) nowy++;
    			else if (way == 1) nowy--;
    			else if (way == 2) nowx--;
    			else if (way == 3) nowx++;
    		
    			for (int i = 0; i < CloseList.size(); i++) {
    				if (CloseList.get(i).x == nowx && CloseList.get(i).y == nowy) {
    					flag = true;
    				}
    			}
    			
    			for (int i = 0; i < OpenList.size(); i++) { // ��������Ʈ�� �̹� �����Ѵٸ�
    				if (OpenList.get(i).x == nowx && OpenList.get(i).y == nowy) {
    					flag = true;
    					 if (OpenList.get(i).G > CloseList.get(nowIndex).G + 1) {
    						 OpenList.set(i,new A_Data(nowx, nowy, nowIndex, CloseList.get(nowIndex).G + 1, OpenList.get(i).H));
    					 }
    				}
    			}
    			
    			if (flag == false) { // ����, ��������Ʈ�� ���ٸ� ��������Ʈ�� ���� �߰�����
    				OpenList.add(new A_Data(nowx, nowy, nowIndex, CloseList.get(nowIndex).G + 1,Math.abs(endx - nowx) + Math.abs(endy - nowy)));
    			}
    		}
    		
    		if (OpenList.size() != 0) { // ���¸���Ʈ���� ���Ÿ��� ���� �������� ��� Ž����ġ�� ����
    			int Ftemp = OpenList.get(0).F;
    			int Indextemp = 0;
    			for (int i = 0; i < OpenList.size(); i++) {
    				if (OpenList.get(i).F < Ftemp) {
    					Ftemp = OpenList.get(i).F;
    					Indextemp = i;
    				}
    				else if (OpenList.get(i).F == Ftemp) { // ���� F���� �����ϴٸ� H���� �������� ���Ѵ�.
    					 if (OpenList.get(i).H < OpenList.get(Indextemp).H) {
    						 Indextemp = i;
    					 }
    				}
    			}
    			CloseList.add(OpenList.get(Indextemp));
    			OpenList.remove(Indextemp); //CloseList�� Ž���� ��ġ�� �־��ְ� OpenList���� �����.
    			nowIndex++;
    			
    		}else {// OpenList�� ����ٸ� ��� ����
    			System.out.println("Location Error");
    			break;
    		}
    		
    	}
    	
    	while (nowIndex != -1) { // ������������ �������� ��¤���
    		int[] pathtemp = { CloseList.get(nowIndex).x, CloseList.get(nowIndex).y };
    		Path.add(pathtemp);// + " " + CloseList.get(nowIndex).y);
    		nowIndex = CloseList.get(nowIndex).p_index;
    	}
    	
    	while (Path.size() != 0) { // ��¤� ��θ� �ٽ� ������� ����Ѵ�.
    		// ���⼭ Handler�� �Ἥ �Ѿ��. GUIó�� �ʿ�.
    		
    		System.out.println(Path.get(Path.size() - 1)[0] + " " + Path.get(Path.size() - 1)[1]);
    		Path.remove(Path.size() - 1);
    	}
    }



    /**
     * @return
     */
    public Vector<Point> findPath() {
        // TODO implement here
    	
    	//�̰� �����
        return null;
    }

}
