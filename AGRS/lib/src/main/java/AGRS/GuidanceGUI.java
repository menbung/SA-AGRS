package AGRS;

import java.awt.*;
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
	 * 테스트용
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuidanceGUI frame = new GuidanceGUI(2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public GuidanceGUI(int gateNum) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		//위에 메세지 출력부
		JPanel titlePanel = new JPanel();
		contentPane.add(titlePanel, BorderLayout.NORTH);

		msg="\uAE38\uC744 \uC548\uB0B4 \uC911 \uC785\uB2C8\uB2E4...";
		
		JLabel titleLabel = new JLabel(msg);
		titleLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		titlePanel.add(titleLabel);
		
		
		// 맵출력부
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
		Goal.setFont(new Font("굴림", Font.BOLD, 14));
		Goal.setBackground(Color.GREEN);
		Goal.setBounds(-12, -12, 48, 48);
		layeredPane.add(Goal);
		
		
		tableMap = new JTable(6,12);
		tableMap.setEnabled(false);
		tableMap.setRowSelectionAllowed(false);
		tableMap.setBounds(12, 12, 912, 432);
		tableMap.setRowHeight(72);
		layeredPane.add(tableMap);
		
		JButton Robot = new JButton("R");
		
		// 테스트용
		Robot.addMouseListener(new MouseAdapter() {		//임시 테스트용 R 클릭했을때 리페인트 되는지 확인용.
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p1 = new Point(3, 4);
				Point p2 = new Point(3, 3);
				makeRouteY(p1, p2);
				System.out.println(RouteList.get(0).getX());
				printRoute();
				
			}
		});
		Robot.setFont(new Font("굴림", Font.BOLD, 14));
		layeredPane.setLayer(Robot, 101);
		Robot.setBackground(Color.RED);
		Robot.setBounds(672,204,48,48);
		layeredPane.add(Robot);
		
//		JPanel RouteX = new JPanel();	// 크기 테스트용
//		layeredPane.setLayer(RouteX, 1);
//		RouteX.setBackground(Color.RED);
//		RouteX.setBounds(236, 152, 84, 8);
//		layeredPane.add(RouteX);
//		
//		JPanel RouteY = new JPanel();
//		RouteY.setBackground(Color.RED);
//		layeredPane.setLayer(RouteY, 1);
//		RouteY.setBounds(312, 152, 8, 80);
//		layeredPane.add(RouteY);
		
		//길찾기 시뮬레이션부
		RouteList = new Vector<JPanel>();
		
		
		
	}
	
//	public void makeRoute() {	// 이건 핸들러에서 해야할것 같아서 임시로 주석처리.
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
	
	
	public void makeRouteX(Point previous, Point current){	//x축 루트 막대기 생성용
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
	
	
	
	public void makeRouteY(Point previous, Point current) {	//y축 루트 막대기 생성용
		if(previous.getY()<current.getY()) {
			JPanel RouteY = new JPanel();
			RouteY.setBackground(Color.RED);
			RouteY.setBounds(76*previous.getY()+8, 72*previous.getY()+8, 8, 84);
			RouteList.add(RouteY);
		}else if(previous.getY()>current.getY()){
			JPanel RouteY = new JPanel();
			RouteY.setBackground(Color.RED);
			RouteY.setBounds(76*current.getY()+8, 72*current.getY()+8, 8, 84);
			RouteList.add(RouteY);
			
		}else {
			System.out.println("error in makeRoute y");
		}
	}
	
	
	public void printRoute() {	//루트 all print
		for(int i=0; i<RouteList.size();i++) {
			layeredPane.setLayer(RouteList.elementAt(i), 10);
			contentPane.revalidate();
			contentPane.repaint();
//			layeredPane.revalidate();
//			layeredPane.repaint();
		}
	}

	
	
}
