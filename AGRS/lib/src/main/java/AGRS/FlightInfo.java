package AGRS;

import java.util.ArrayList;

public class FlightInfo {
	private static FlightInfo instance;//싱글톤 사용을 위한 변수
	private ServerTarget server;
	private ArrayList<FlightInfoObject> flight_infos;
	private FlightInfoObject target_info;//유저가 선택한 항공편 정보

	private FlightInfo() {//외부에서 추가 생성하는걸 막기위한 private
		server = ServerAdapter.getInstance();
	}
	
	public static FlightInfo getInstance() {//싱글톤을 위한 인스턴스 반환 함수
		if (instance == null) //최초 한번만 new 연산자를 통해 메모리에 할당
			instance = new FlightInfo();
		return instance;
	}
	
	public ArrayList<FlightInfoObject> getFlightInfos() {
		flight_infos = server.flightInfoReq("2021_12_09");
		return flight_infos;
	}
	
	public FlightInfoObject getTarget_info() {
		return target_info;
	}

	public void setTarget_info(FlightInfoObject target_info) {
		this.target_info = target_info;
	}
}
