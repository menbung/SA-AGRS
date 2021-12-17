package AGRS;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GuidanceGUI extends JFrame {

	private JPanel contentPane;
	private JTable tableMap;
	private String msg;
	
	/**
	 * Launch the application.
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
		
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);
		
		JButton btnNewButton = new JButton("G");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(-12, -12, 48, 48);
		layeredPane.add(btnNewButton);
		
		
		tableMap = new JTable(6,12);
		tableMap.setBounds(12, 12, 912, 432);
		tableMap.setRowHeight(72);
		layeredPane.add(tableMap);
		
		JButton Robot = new JButton("R");
		Robot.setFont(new Font("굴림", Font.BOLD, 14));
		layeredPane.setLayer(Robot, 1);
		Robot.setBackground(Color.RED);
		Robot.setBounds(672,204,48,48);
		layeredPane.add(Robot);
		
		//길찾기 시뮬레이션부
		
		
		
	}
	class tableMap extends JPanel{
		public void paintComponent(Graphics g){
			g.drawOval(120, 70, 60, 60);
		}
	}
}
