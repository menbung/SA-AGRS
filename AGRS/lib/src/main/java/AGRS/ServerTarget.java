package AGRS;

import java.util.ArrayList;

public interface ServerTarget {
	public ArrayList<FlightInfoObject> flightInfoReq(String date);
	public ArrayList<ArrayList<Integer>> mapReq();
}
