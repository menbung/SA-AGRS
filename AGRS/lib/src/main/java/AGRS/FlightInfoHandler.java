package AGRS;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTable;

public class FlightInfoHandler {
	private FlightinfoGUI flight_info_gui;
	private FlightInfo flight_model;
	
	public FlightInfoHandler() {
		this(true);
	}
	
    public FlightInfoHandler(boolean guiflag) {
    	flight_info_gui = new FlightinfoGUI();
    	flight_info_gui.setVisible(true);
    	flight_model = FlightInfo.getInstance();
    	updateView();
    	if(guiflag)
    		connectTable();
    	init();
    }
    
    void updateView() {//GUI에 리스트 업데이트
    	flight_model.getFlightInfos("2021_12_09");
    	flight_info_gui.updateDeparture(flight_model.getDeparture_flights());
    	flight_info_gui.updateArrive(flight_model.getArrive_flights());
    }
    
    void connectTable() {
    	JTable departureTable = flight_info_gui.getDepartureTable();
    	departureTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = departureTable.getSelectedRow();
				flight_model.setTarget_info(1, index);
				int gateNum = flight_model.getTarget_info().getGate_num();
				
				GuidanceGUI guidancegui = new GuidanceGUI(gateNum);
				guidancegui.setVisible(true);
				flight_info_gui.setVisible(false);
			}
		});
    	
    	JTable arrivalTable = flight_info_gui.getArrivalTable();
    	arrivalTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = arrivalTable.getSelectedRow();
				flight_model.setTarget_info(2, index);
				int gateNum = flight_model.getTarget_info().getGate_num();
				
				GuidanceGUI guidancegui = new GuidanceGUI(gateNum);
				guidancegui.setVisible(true);
				flight_info_gui.setVisible(false);
			}
		});
    }

    void init() {
    	JButton departureBtn = flight_info_gui.getDepartureBtn();//출발표 보는 버튼
    	departureBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				flight_info_gui.showFlightList(1);
			}
		});
    	
    	JButton arrivalBtn = flight_info_gui.getArrivalBtn();//도착표를 보는 버튼
    	arrivalBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				flight_info_gui.showFlightList(2);
			}
		});
    	
    	JButton menuBtn = flight_info_gui.getMenuBtn();//메뉴화면으로 돌아가는 버튼
    	menuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//menu버튼 클릭시
				MainGUI maingui = new MainGUI();
				maingui.setVisible(true);
				flight_info_gui.setVisible(false);
			}
		});
    }
}