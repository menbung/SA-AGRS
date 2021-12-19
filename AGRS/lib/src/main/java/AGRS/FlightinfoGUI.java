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
import java.util.ArrayList;

import javax.swing.JScrollPane;

public class FlightinfoGUI extends JFrame {

	private JPanel contentPane;
	private JTable departureTable;	// 출발항공표
	private JTable arrivalTable;	// 도착항공표
	private JButton departureBtn;	// 춟발리스트보는버튼 
	private JButton arrivalBtn;		// 도착리스트보는버튼
	private JButton menuBtn;		// 메인화면으로가는버튼
	private DefaultTableModel departure_model;	//출발항공표리스트
	private DefaultTableModel arrive_model;		//도착항공표리스트
	private JPanel tables;			//리스트 출력 패널
	private CardLayout card;		//패널 관리
	
	public FlightinfoGUI() {
		//패널 생성 및 디자인 관련
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(20, 20));
		
		JPanel titlePanel = new JPanel();
		contentPane.add(titlePanel, BorderLayout.NORTH);
		
		// 테이블
		JLabel titlelabel = new JLabel("<< \uD56D\uACF5\uD3B8 \uC548\uB0B4 >>");
		titlelabel.setFont(new Font("����", Font.BOLD, 20));
		titlePanel.add(titlelabel);
		
		
		JPanel tablePanel = new JPanel();
		contentPane.add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new BorderLayout(0, 0));
		
		//테이블 생성 출력부

		tables = new JPanel();
		tablePanel.add(tables, BorderLayout.CENTER);
		card = new CardLayout();
		tables.setLayout(card);
		
		
		// 출발 항공표 리스트 연결 및 출력
		String[] dep_colTitle= new String[]{
				"\uCD9C\uBC1C\uC2DC\uAC04", "\uB3C4\uCC29\uC9C0", "\uD56D\uACF5\uD3B8",
				"\uD56D\uACF5\uC0AC", "\uAC8C\uC774\uD2B8"};
		departure_model = new DefaultTableModel(dep_colTitle, 0);
		departureTable = new JTable(departure_model);
		JScrollPane dep_scroll = new JScrollPane(departureTable);
		tables.add("dep", dep_scroll);
		// 도착 항공표 리스트 연결 및 출력
		String[] ar_colTitle= new String[]{
				"\uB3C4\uCC29\uC2DC\uAC04", "\uCD9C\uBC1C\uC9C0", "\uD56D\uACF5\uD3B8",
				"\uD56D\uACF5\uC0AC", "\uAC8C\uC774\uD2B8"};
		arrive_model = new DefaultTableModel(ar_colTitle, 0);
		arrivalTable = new JTable(arrive_model);
		JScrollPane ar_scroll = new JScrollPane(arrivalTable);
		tables.add("ar", ar_scroll);
		
		
		// 출발, 도착 버튼 추가
		JPanel tableBtns = new JPanel();
		FlowLayout flowLayout = (FlowLayout) tableBtns.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		tablePanel.add(tableBtns, BorderLayout.NORTH);
		
		departureBtn = new JButton("\uCD9C\uBC1C");	//출발버튼
		departureBtn.setFont(new Font("굴림", Font.ITALIC, 16));
		tableBtns.add(departureBtn);
		
		arrivalBtn = new JButton("\uB3C4\uCC29");	//도착버튼
		arrivalBtn.setFont(new Font("굴림", Font.ITALIC, 16));
		tableBtns.add(arrivalBtn);
		
		
		JPanel btnPanel = new JPanel();
		contentPane.add(btnPanel, BorderLayout.SOUTH);
		
		menuBtn = new JButton("MENU");				// 메뉴 화면 버튼
		menuBtn.setFont(new Font("굴림", Font.BOLD, 20));
		btnPanel.add(menuBtn);
	}

	// 출발 항공편 리스트 추가
	public void updateDeparture(ArrayList<FlightInfoObject> data) {
		String[] row = new String[5];
		for(FlightInfoObject info : data) {
			row[0] = info.getDeparture_time();
			row[1] = info.getDestination();
			row[2] = info.getFlight_num();
			row[3] = info.getAirline();
			row[4] = Integer.toString(info.getGate_num());
			departure_model.addRow(row);
		}
	}
	
	//도착 항공편 리스트 추가
	public void updateArrive(ArrayList<FlightInfoObject> data) {
		String[] row = new String[5];
		for(FlightInfoObject info : data) {
			row[0] = info.getArrive_time();
			row[1] = info.getStarting_point();
			row[2] = info.getFlight_num();
			row[3] = info.getAirline();
			row[4] = Integer.toString(info.getGate_num());
			arrive_model.addRow(row);
		}
	}

	// 출발항공편, 도착항공편 화면 전환
	public void showFlightList(int code) {
		switch(code) {
		case 1:
			card.show(tables, "dep");//���ǥ�� �����ش�.
			break;
		case 2:
			card.show(tables, "ar");//����ǥ�� �����ش�.
			break;
		}
	}
	
	public JTable getDepartureTable() {
		return departureTable;
	}

	public JTable getArrivalTable() {
		return arrivalTable;
	}

	public JButton getDepartureBtn() {
		return departureBtn;
	}

	public JButton getArrivalBtn() {
		return arrivalBtn;
	}

	public JButton getMenuBtn() {
		return menuBtn;
	}
	
}
