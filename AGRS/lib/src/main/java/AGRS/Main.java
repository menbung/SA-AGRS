package AGRS;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		//ServerTarget adapter = ServerAdapter.getInstance();
//		FlightInfo flight_info = FlightInfo.getInstance();
//		
//		ArrayList<FlightInfoObject> infos = flight_info.getFlightInfos();
//		for(FlightInfoObject info : infos) {
//			System.out.println(info.getFlight_num());
//		}
		
		MainGUI gui = new MainGUI();
		gui.setVisible(true);
	}

}
