package AGRS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(20, 20));
		setContentPane(contentPane);
		
		JPanel titlePanel = new JPanel();
		contentPane.add(titlePanel, BorderLayout.NORTH);
		
		JLabel titleLabel = new JLabel("AGRS");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 42));
		titlePanel.add(titleLabel);
		
		JPanel btnPanel = new JPanel();
		contentPane.add(btnPanel, BorderLayout.CENTER);
		GridBagLayout gbl_btnPanel = new GridBagLayout();
		gbl_btnPanel.columnWidths = new int[]{934, 0};
		gbl_btnPanel.rowHeights = new int[]{23, 23, 0};
		gbl_btnPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_btnPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		btnPanel.setLayout(gbl_btnPanel);
		
		JButton btn1 = new JButton("\uD56D\uACF5\uD3B8 \uC815\uBCF4\uC548\uB0B4");//항공편 정보 버튼
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FlightInfoHandler(false);
				setVisible(false);
			}
		});
		btn1.setFont(new Font("굴림", Font.BOLD, 20));

		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.fill = GridBagConstraints.BOTH;
		gbc_btn1.insets = new Insets(10, 360, 10, 360);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 0;
		btnPanel.add(btn1, gbc_btn1);
		
		JButton btn2 = new JButton("\uACF5\uD56D \uAE38 \uC548\uB0B4");//길 안내 버튼
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FlightInfoHandler(true);
				setVisible(false);
			}
		});
		btn2.setFont(new Font("굴림", Font.BOLD, 20));
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.insets = new Insets(10, 360, 10, 360);
		gbc_btn2.fill = GridBagConstraints.BOTH;
		gbc_btn2.gridx = 0;
		gbc_btn2.gridy = 1;
		btnPanel.add(btn2, gbc_btn2);
	}

}
