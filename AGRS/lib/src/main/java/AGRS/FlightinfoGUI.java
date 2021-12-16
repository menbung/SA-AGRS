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
	private JTable departureTable;	// 출발항공표
	private JTable arrivalTable;	// 도착항공표
	private boolean is_Departure;	// 지금 출력중인 화면이 출발표인가 도착표인가
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FlightinfoGUI(boolean guiflag) {
		//패널 생성 및 디자인 관련
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(20, 20));
		
		JPanel titlePanel = new JPanel();
		contentPane.add(titlePanel, BorderLayout.NORTH);
		
		// 타이틀
		JLabel titlelabel = new JLabel("<< \uD56D\uACF5\uD3B8 \uC548\uB0B4 >>");
		titlelabel.setFont(new Font("굴림", Font.BOLD, 20));
		titlePanel.add(titlelabel);
		
		
		JPanel tablePanel = new JPanel();
		contentPane.add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new BorderLayout(0, 0));
		
		
		//테이블

		JPanel tables = new JPanel();
		tablePanel.add(tables, BorderLayout.CENTER);
		tables.setLayout(new CardLayout(0, 0));
		
		
		// 테이블 생성 출력부
		String[] colTitle= new String[]{"시간", "출발지", "도착지", "항공사"};		// 추가해줄것
		DefaultTableModel model = new DefaultTableModel(colTitle,0);
		departureTable = new JTable(model);

//		departureTable.setCellSelectionEnabled(true);
		tables.add(departureTable);
		arrivalTable = new JTable();
		arrivalTable.setEnabled(false);
		tables.add(arrivalTable);
		
		
		
		
//#해야할것# 테이블이 출발과 도착으로 나뉘어 있다고 할때, 각각 테이블에 FlightInfo ArrayList를 넣어줘야함.
//		FlightInfo flightinfo = new FlightInfo();
//		String[] data = new String[4];
//		data[0] = flightinfo.get();		// 이거로 다 데이타값 채우기
//		
//		departureTable.addRow(data);
//		
//		if() {
//			// 출발행 departureTable
//			String[] data = new String[4];		// 이런식으로 표에 추가.
//			data[0]="1";
//			data[1]="1";
//			data[2]="1";
//			data[3]="1";
//			model.addRow(data);
//			
//		}else if() {
//			// 도착행 arrivialTable
//			
//			
//		}else {
//			System.out.println("error data in loading flight table");
//		}
		
		

		
		
		//테이블 클릭시 (길안내의 경우)

		if(guiflag==true) {
			departureTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index=departureTable.getSelectedRow();
					
					/* 대충 리스트에서 해당 index에 해당하는 게이트를 가져오는 코드가 들어가야함*/
					
					//해당 아래는 임시
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
					
					/* 대충 리스트에서 해당 인덱스에 해당하는 게이트를 가져오는 코드가 들어가야함*/
					
					//해당 아래는 임시
					int gateNum=3;
					
					GuidanceGUI guidancegui = new GuidanceGUI(gateNum);
					guidancegui.setVisible(true);
					setVisible(false);

				}
			});
			
		}
		
		
		// 버튼부
		JPanel tableBtns = new JPanel();
		FlowLayout flowLayout = (FlowLayout) tableBtns.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		tablePanel.add(tableBtns, BorderLayout.NORTH);
		
		JButton departureBtn = new JButton("\uCD9C\uBC1C");	//출발표 보는 버튼
		departureBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	//출발표 보는 버튼은
				if(is_Departure==false) {				//출발표 보여주는 상태가 false일때
					arrivalTable.setVisible(false);		//도착표를 내리고
					departureTable.setVisible(true);	//출발표를 보여준다.
					is_Departure=true;
				}
			}
		});
		departureBtn.setFont(new Font("굴림", Font.ITALIC, 16));
		tableBtns.add(departureBtn);
		
		JButton arrivalBtn = new JButton("\uB3C4\uCC29");	//도착표 보는 버튼
		arrivalBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {		//도착표를 보는 버튼은
				if(is_Departure==true) {						//출발표를 보여주는 상태가 true일때,
					departureTable.setVisible(false);		//출발표를 내리고
					arrivalTable.setVisible(true);			//도착표를 보여준다.
					is_Departure=false;						//그리고 출발표인가요?는 false로 한다.
				}
			}
		});
		arrivalBtn.setFont(new Font("굴림", Font.ITALIC, 16));
		tableBtns.add(arrivalBtn);
		
		
		JPanel btnPanel = new JPanel();
		contentPane.add(btnPanel, BorderLayout.SOUTH);
		
		JButton menuBtn = new JButton("MENU");
		menuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//menu버튼 클릭시
				MainGUI maingui = new MainGUI();
				maingui.setVisible(true);
				setVisible(false);
			}
		});
		menuBtn.setFont(new Font("굴림", Font.BOLD, 20));
		btnPanel.add(menuBtn);
	}
	

}
