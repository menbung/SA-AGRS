package AGRS;

import java.util.ArrayList;
import java.util.Collections;

public class FlightInfo {
	private static FlightInfo instance;//싱글톤 사용을 위한 변수
	private ServerTarget server;
	private ArrayList<FlightInfoObject> departure_flights;
	private ArrayList<FlightInfoObject> arrive_flights;
	private FlightInfoObject target_info;//유저가 선택한 항공편 정보

	private FlightInfo() {//외부에서 추가 생성하는걸 막기위한 private
		server = ServerAdapter.getInstance();
		departure_flights = new ArrayList<>();
		arrive_flights = new ArrayList<>();
	}
	
	public static FlightInfo getInstance() {//싱글톤을 위한 인스턴스 반환 함수
		if (instance == null) //최초 한번만 new 연산자를 통해 메모리에 할당
			instance = new FlightInfo();
		return instance;
	}
	
	public void getFlightInfos(String date) {
		ArrayList<FlightInfoObject> flight_infos = server.flightInfoReq(date);
		departure_flights.clear();
		arrive_flights.clear();
		for (FlightInfoObject info : flight_infos) {
			if (info.getArrive_time().equals("null")) {
				departure_flights.add(info);
			}
			else {
				arrive_flights.add(info);
			}
		}
		Collections.sort(departure_flights);
		Collections.sort(arrive_flights);
	}
	
	public FlightInfoObject getTarget_info() {
		return target_info;
	}

	public void setTarget_info(int type, int index) {
		switch(type) {
		case 1:
			this.target_info = this.departure_flights.get(index);
			break;
		case 2:
			this.target_info = this.arrive_flights.get(index);
			break;
		}
	}

	public ArrayList<FlightInfoObject> getDeparture_flights() {
		return departure_flights;
	}

	public ArrayList<FlightInfoObject> getArrive_flights() {
		return arrive_flights;
	}
}
