package AGRS;

import java.util.ArrayList;
import java.util.Collections;

public class FlightInfo {
	private static FlightInfo instance;//for singleton pattern
	private ServerTarget server;
	private ArrayList<FlightInfoObject> departure_flights;//departure flight list
	private ArrayList<FlightInfoObject> arrive_flights;//arrival flight list
	private FlightInfoObject target_info;//flight information chosen by user

	private FlightInfo() {//외부에서 추가 생성하는걸 막는 private
		server = ServerAdapter.getInstance();
		departure_flights = new ArrayList<>();
		arrive_flights = new ArrayList<>();
	}
	
	public static FlightInfo getInstance() {//싱글톤을 위한 인스턴스 반환 함수
		if (instance == null)
			instance = new FlightInfo();
		return instance;
	}
	
	public void getFlightInfos(String date) {//서버에서 항공편 리스트를 받아와 가공 및 저장
		ArrayList<FlightInfoObject> flight_infos = server.flightInfoReq(date);
		//리스트 포맷
		departure_flights.clear();
		arrive_flights.clear();
		for (FlightInfoObject info : flight_infos) {
			if (info.getArrive_time().equals("null")) { //출발 항공편인지 도착 항공편인지 분류
				departure_flights.add(info);
			}
			else {
				arrive_flights.add(info);
			}
		}
		//항공편 정렬
		Collections.sort(departure_flights);
		Collections.sort(arrive_flights);
	}
	
	public FlightInfoObject getTarget_info() {
		return target_info;
	}

	public void setTarget_info(int type, int index) {
		//1이면 출발 항공편, 2이면 도착 항공편
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
