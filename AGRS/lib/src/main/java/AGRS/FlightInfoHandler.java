package AGRS;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTable;

public class FlightInfoHandler {
	private FlightinfoGUI flight_info_gui; //view
	private FlightInfo flight_model; //model
	
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
    
    void updateView() {//view에 리스트 업데이트
    	flight_model.getFlightInfos("2021_12_09");
    	flight_info_gui.updateDeparture(flight_model.getDeparture_flights());
    	flight_info_gui.updateArrive(flight_model.getArrive_flights());
    }
    
    void connectTable() {//리스트에 항공편 클릭 리스터 연결
    	JTable departureTable = flight_info_gui.getDepartureTable();
    	departureTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = departureTable.getSelectedRow();
				flight_model.setTarget_info(1, index);
				int gateNum = flight_model.getTarget_info().getGate_num();
				
				new GuidanceHandler(gateNum);
				flight_info_gui.dispose();
			}
		});
    	
    	JTable arrivalTable = flight_info_gui.getArrivalTable();
    	arrivalTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = arrivalTable.getSelectedRow();
				flight_model.setTarget_info(2, 1);
				int gateNum = flight_model.getTarget_info().getGate_num();
				
				new GuidanceHandler(gateNum);
				flight_info_gui.dispose();
			}
		});
    }

    void init() {
    	JButton departureBtn = flight_info_gui.getDepartureBtn();//출발버튼 리스너 연결
    	departureBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				flight_info_gui.showFlightList(1);
			}
		});
    	
    	JButton arrivalBtn = flight_info_gui.getArrivalBtn();//도착버튼 리스너 연결
    	arrivalBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				flight_info_gui.showFlightList(2);
			}
		});
    	
    	JButton menuBtn = flight_info_gui.getMenuBtn();//메뉴버튼 리스너 연결
    	menuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MainGUI();
				flight_info_gui.dispose();
			}
		});
    }
}