package AGRS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class FlightinfoGUI extends JFrame {

	private JPanel contentPane;
	private JTable departureTable;	// ����װ�ǥ
	private JTable arrivalTable;	// �����װ�ǥ
	private boolean is_Departure;	// ���� ������� ȭ���� ���ǥ�ΰ� ����ǥ�ΰ�
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FlightinfoGUI(boolean guiflag) {
		//�г� ���� �� ������ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(20, 20));
		
		JPanel titlePanel = new JPanel();
		contentPane.add(titlePanel, BorderLayout.NORTH);
		
		// Ÿ��Ʋ
		JLabel titlelabel = new JLabel("<< \uD56D\uACF5\uD3B8 \uC548\uB0B4 >>");
		titlelabel.setFont(new Font("����", Font.BOLD, 20));
		titlePanel.add(titlelabel);
		
		
		JPanel tablePanel = new JPanel();
		contentPane.add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new BorderLayout(0, 0));
		
		
		//���̺�

		JPanel tables = new JPanel();
		tablePanel.add(tables, BorderLayout.CENTER);
		tables.setLayout(new CardLayout(0, 0));
		
		
		// ���̺� ���� ��º�
		String[] colTitle= new String[]{"�ð�", "�����", "������", "�װ���"};		// �߰����ٰ�
		DefaultTableModel model = new DefaultTableModel(colTitle,0);
		departureTable = new JTable(model);

//		departureTable.setCellSelectionEnabled(true);
		tables.add(departureTable);
		arrivalTable = new JTable();
		arrivalTable.setEnabled(false);
		tables.add(arrivalTable);
		
		
		
		
//#�ؾ��Ұ�# ���̺��� ��߰� �������� ������ �ִٰ� �Ҷ�, ���� ���̺� FlightInfo ArrayList�� �־������.
//		FlightInfo flightinfo = new FlightInfo();
//		String[] data = new String[4];
//		data[0] = flightinfo.get();		// �̰ŷ� �� ����Ÿ�� ä���
//		
//		departureTable.addRow(data);
//		
//		if() {
//			// ����� departureTable
//			String[] data = new String[4];		// �̷������� ǥ�� �߰�.
//			data[0]="1";
//			data[1]="1";
//			data[2]="1";
//			data[3]="1";
//			model.addRow(data);
//			
//		}else if() {
//			// ������ arrivialTable
//			
//			
//		}else {
//			System.out.println("error data in loading flight table");
//		}
		
		

		
		
		//���̺� Ŭ���� (��ȳ��� ���)

		if(guiflag==true) {
			departureTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index=departureTable.getSelectedRow();
					
					/* ���� ����Ʈ���� �ش� index�� �ش��ϴ� ����Ʈ�� �������� �ڵ尡 ������*/
					
					//�ش� �Ʒ��� �ӽ�
					int gateNum=8;
					
					GuidanceGUI guidancegui = new GuidanceGUI(gateNum);
					guidancegui.setVisible(true);
					setVisible(false);
				}
			});
			
			arrivalTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index=arrivalTable.getSelectedRow();
					
					/* ���� ����Ʈ���� �ش� �ε����� �ش��ϴ� ����Ʈ�� �������� �ڵ尡 ������*/
					
					//�ش� �Ʒ��� �ӽ�
					int gateNum=3;
					
					GuidanceGUI guidancegui = new GuidanceGUI(gateNum);
					guidancegui.setVisible(true);
					setVisible(false);

				}
			});
			
		}
		
		
		// ��ư��
		JPanel tableBtns = new JPanel();
		FlowLayout flowLayout = (FlowLayout) tableBtns.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		tablePanel.add(tableBtns, BorderLayout.NORTH);
		
		JButton departureBtn = new JButton("\uCD9C\uBC1C");	//���ǥ ���� ��ư
		departureBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	//���ǥ ���� ��ư��
				if(is_Departure==false) {				//���ǥ �����ִ� ���°� false�϶�
					arrivalTable.setVisible(false);		//����ǥ�� ������
					departureTable.setVisible(true);	//���ǥ�� �����ش�.
					is_Departure=true;
				}
			}
		});
		departureBtn.setFont(new Font("����", Font.ITALIC, 16));
		tableBtns.add(departureBtn);
		
		JButton arrivalBtn = new JButton("\uB3C4\uCC29");	//����ǥ ���� ��ư
		arrivalBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {		//����ǥ�� ���� ��ư��
				if(is_Departure==true) {						//���ǥ�� �����ִ� ���°� true�϶�,
					departureTable.setVisible(false);		//���ǥ�� ������
					arrivalTable.setVisible(true);			//����ǥ�� �����ش�.
					is_Departure=false;						//�׸��� ���ǥ�ΰ���?�� false�� �Ѵ�.
				}
			}
		});
		arrivalBtn.setFont(new Font("����", Font.ITALIC, 16));
		tableBtns.add(arrivalBtn);
		
		
		JPanel btnPanel = new JPanel();
		contentPane.add(btnPanel, BorderLayout.SOUTH);
		
		JButton menuBtn = new JButton("MENU");
		menuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//menu��ư Ŭ����
				MainGUI maingui = new MainGUI();
				maingui.setVisible(true);
				setVisible(false);
			}
		});
		menuBtn.setFont(new Font("����", Font.BOLD, 20));
		btnPanel.add(menuBtn);
	}
	

}
