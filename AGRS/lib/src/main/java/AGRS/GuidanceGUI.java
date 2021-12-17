package AGRS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTable;

public class GuidanceGUI extends JFrame {

	private JPanel contentPane;
	private JTable tableMap;
	private String msg;
	
	/**
	 * Launch the application.
	 */

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
		
		
		//���� �޼��� ��º�
		JPanel titlePanel = new JPanel();
		contentPane.add(titlePanel, BorderLayout.NORTH);

		msg="\uAE38\uC744 \uC548\uB0B4 \uC911 \uC785\uB2C8\uB2E4...";
		
		JLabel titleLabel = new JLabel(msg);
		titleLabel.setFont(new Font("����", Font.PLAIN, 18));
		titlePanel.add(titleLabel);
		
		
		// ����º�
		JPanel mapPanel = new JPanel();
		mapPanel.setBorder(new EmptyBorder(8, 0, 0, 0));
		FlowLayout flowLayout = (FlowLayout) mapPanel.getLayout();
		contentPane.add(mapPanel, BorderLayout.CENTER);
		
		tableMap = new JTable(6,12);
		tableMap.setRowHeight(72);

		mapPanel.add(tableMap);
		
		//��ã�� �ùķ��̼Ǻ�
		
		
		
	}

}
