package AGRS;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ServerTarget adapter = new ServerAdapter();
		
		ArrayList<FlightInfoObject> infos = adapter.flightInfoReq("2021_12_09");
		for(FlightInfoObject info : infos) {
			System.out.println(info.getFlight_num());
		}
		System.out.println("confirm");
	}

}
