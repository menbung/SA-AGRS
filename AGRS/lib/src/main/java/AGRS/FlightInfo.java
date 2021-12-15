package AGRS;

import java.util.ArrayList;

public class FlightInfo {
	private static FlightInfo instance;//�̱��� ����� ���� ����
	private ServerTarget server;
	private ArrayList<FlightInfoObject> flight_infos;
	private FlightInfoObject target_info;//������ ������ �װ��� ����

	private FlightInfo() {//�ܺο��� �߰� �����ϴ°� �������� private
		server = ServerAdapter.getInstance();
	}
	
	public static FlightInfo getInstance() {//�̱����� ���� �ν��Ͻ� ��ȯ �Լ�
		if (instance == null) //���� �ѹ��� new �����ڸ� ���� �޸𸮿� �Ҵ�
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
