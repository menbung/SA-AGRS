package AGRS;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuidanceGUI extends JFrame {

	private JPanel contentPane;
	private JTable tableMap;
	private String msg;
	private Vector<JPanel> RouteList;
	private JLayeredPane layeredPane;
	private JButton Robot = new JButton("R");
	private JButton menu_btn;
	private JLabel titleLabel;

	/**
	 * Create the frame.
	 */
	
	public GuidanceGUI(Point myPoint,Point endPoint, ArrayList<Point> path) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		//상단 메세지
		JPanel titlePanel = new JPanel();
		contentPane.add(titlePanel, BorderLayout.NORTH);

		msg="\uAE38\uC744 \uC548\uB0B4 \uC911 \uC785\uB2C8\uB2E4...";
		
		titleLabel = new JLabel(msg);
		titleLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		titlePanel.add(titleLabel);
		
		//메인화면으로 돌아가는 버튼
		menu_btn = new JButton("\uC548\uB0B4 \uC885\uB8CC");
		menu_btn.setFont(new Font("굴림", Font.BOLD, 18));
		titlePanel.add(menu_btn);
		
		//가운데 화면
		layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);
		
		//도착지 표시
		JButton Goal = new JButton("G");
		Goal.setEnabled(false);
		Goal.setForeground(Color.BLACK);
		layeredPane.setLayer(Goal, 100);
		Goal.setFont(new Font("굴림", Font.BOLD, 14));
		Goal.setBackground(Color.GREEN);
		Goal.setBounds(76*endPoint.getX()-12,72*endPoint.getY()-12, 48, 48);
		layeredPane.add(Goal);
		
		//맵
		tableMap = new JTable(6,12);
		tableMap.setEnabled(false);
		tableMap.setRowSelectionAllowed(false);
		tableMap.setBounds(12, 12, 912, 432);
		tableMap.setRowHeight(72);
		layeredPane.add(tableMap);
		
		//로봇 위치
		Robot.setFont(new Font("굴림", Font.BOLD, 14));
		layeredPane.setLayer(Robot, 101);
		Robot.setBackground(Color.RED);
		Robot.setBounds(76*myPoint.getX()-12,72*myPoint.getY()-12,48,48);
		layeredPane.add(Robot);
		
		//경로 출력
		RouteList = new Vector<JPanel>();
		for(int i=0;i<path.size()-1;i++) {
	         if(path.get(i).getX()==path.get(i+1).getX()) {   
	            makeRouteY(path.get(i),path.get(i+1));
	         }else if(path.get(i).getY()==path.get(i+1).getY()) {   
	            makeRouteX(path.get(i),path.get(i+1));
	         }else {
	            System.out.println("error");
	         }
	         layeredPane.setLayer(RouteList.elementAt(i), 10);
	         layeredPane.add(RouteList.elementAt(i));
	    }
		
	}
	
	
	public void makeRouteX(Point previous, Point current){	//x축 경로 추가
		if(previous.getX()<current.getX()) {
			JPanel RouteX = new JPanel();
			RouteX.setBackground(Color.RED);
			RouteX.setBounds(76*previous.getX()+8, 72*previous.getY()+8, 84, 8);
			RouteList.add(RouteX);
		}else if(previous.getX()>current.getX()){
			JPanel RouteX = new JPanel();
			RouteX.setBackground(Color.RED);
			RouteX.setBounds(76*current.getX()+8, 72*current.getY()+8, 84, 8);
			RouteList.add(RouteX);
			
		}else {
			System.out.println("error in makeRoute x");
		}
	}
	
	
	
	public void makeRouteY(Point previous, Point current) {	//y축 경로 추가
		if(previous.getY()<current.getY()) {
			JPanel RouteY = new JPanel();
			RouteY.setBackground(Color.RED);
			RouteY.setBounds(76*previous.getX()+8, 72*previous.getY()+8, 8, 84);
			RouteList.add(RouteY);
		}else if(previous.getY()>current.getY()){
			JPanel RouteY = new JPanel();
			RouteY.setBackground(Color.RED);
			RouteY.setBounds(76*current.getX()+8, 72*current.getY()+8, 8, 84);
			RouteList.add(RouteY);
			
		}else {
			System.out.println("error in makeRoute y");
		}
	}
	
	public void UpdateRoute(int x, int y, int i) {//로봇 이동 후 경로 갱신
		RouteList.get(RouteList.size()-i-1).setVisible(false);
		Robot.setBounds(x*76 - 12, 72*y - 12, 48, 48);
		
		layeredPane.revalidate();
		layeredPane.repaint();
	}

	public void setTitleText(String text) {
		this.titleLabel.setText(text);
	}
	
	public JButton getMenuBtn() {
		return this.menu_btn;
	}
	
}
