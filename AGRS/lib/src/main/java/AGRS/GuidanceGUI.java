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
	
	/**
	 * �׽�Ʈ��
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GuidanceGUI frame = new GuidanceGUI(2);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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
		
		
		//���� �޼��� ��º�
		JPanel titlePanel = new JPanel();
		contentPane.add(titlePanel, BorderLayout.NORTH);

		msg="\uAE38\uC744 \uC548\uB0B4 \uC911 \uC785\uB2C8\uB2E4...";
		
		JLabel titleLabel = new JLabel(msg);
		titleLabel.setFont(new Font("����", Font.PLAIN, 18));
		titlePanel.add(titleLabel);
		
		
		// ����º�
//		JPanel mapPanel = new JPanel();
//		mapPanel.setBorder(new EmptyBorder(8, 0, 0, 0));
////		mapPanel.setLayout(null);
//		contentPane.add(mapPanel, BorderLayout.CENTER);
		
		
		
		layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);
		
		JButton Goal = new JButton("G");
		Goal.setEnabled(false);
		Goal.setForeground(Color.BLACK);
		layeredPane.setLayer(Goal, 100);
		Goal.setFont(new Font("����", Font.BOLD, 14));
		Goal.setBackground(Color.GREEN);
		Goal.setBounds(76*endPoint.getX()-12,72*endPoint.getY()-12, 48, 48);
		layeredPane.add(Goal);
		
		
		tableMap = new JTable(6,12);
		tableMap.setEnabled(false);
		tableMap.setRowSelectionAllowed(false);
		tableMap.setBounds(12, 12, 912, 432);
		tableMap.setRowHeight(72);
		layeredPane.add(tableMap);
		
		JButton Robot = new JButton("R");
		
		// �׽�Ʈ��
//		Robot.addMouseListener(new MouseAdapter() {		//�ӽ� �׽�Ʈ�� R Ŭ�������� ������Ʈ �Ǵ��� Ȯ�ο�.
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Point p1 = new Point(3, 4);
//				Point p2 = new Point(3, 3);
//				makeRouteY(p1, p2);
//				System.out.println(RouteList.get(0).getX());
//				printRoute();
//				
//			}
//		});
		Robot.setFont(new Font("����", Font.BOLD, 14));
		layeredPane.setLayer(Robot, 101);
		Robot.setBackground(Color.RED);
		Robot.setBounds(76*myPoint.getX()-12,72*myPoint.getY()-12,48,48);
		layeredPane.add(Robot);
		
		//��ã�� �ùķ��̼Ǻ�
		RouteList = new Vector<JPanel>();
		for(int i=0;i<path.size()-1;i++) {
	         if(path.get(i).getX()==path.get(i+1).getX()) {   //y�� �̵��� ���
	            makeRouteY(path.get(i),path.get(i+1));
	         }else if(path.get(i).getY()==path.get(i+1).getY()) {   //x�� �̵��� ���
	            makeRouteX(path.get(i),path.get(i+1));
	         }else {
	            System.out.println("error");
	         }
	         layeredPane.setLayer(RouteList.elementAt(i), 10);
	         layeredPane.add(RouteList.elementAt(i));
	    }
		
		
	}
	
//	public void makeRoute() {	// �̰� �ڵ鷯���� �ؾ��Ұ� ���Ƽ� �ӽ÷� �ּ�ó��.
//		if() {
//			
//		}else if(){
//			
//		}else if() {
//			
//		}else if(){
//			
//		}else {
//			
//		}
//	}
	
	
	public void makeRouteX(Point previous, Point current){	//x�� ��Ʈ ����� ������
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
	
	
	
	public void makeRouteY(Point previous, Point current) {	//y�� ��Ʈ ����� ������
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
	
	
//	public void printRoute() {	//��Ʈ all print
//		for(int i=0; i<RouteList.size();i++) {
//			layeredPane.setLayer(RouteList.elementAt(i), 10);
//			contentPane.revalidate();
//			contentPane.repaint();
////			layeredPane.revalidate();
////			layeredPane.repaint();
//		}
//	}

	
	
}
