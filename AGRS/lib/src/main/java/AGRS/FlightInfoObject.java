package AGRS;

public class FlightInfoObject implements Comparable<FlightInfoObject>{
	private String departure_time;//출발시간
	private String arrive_time;//도착시간
	private String airline;//항공사
	private String flight_num;//항공편번호
	private String starting_point;//출발지
	private String destination;//도착지
	private int gate_num;//게이트번호
	
	public FlightInfoObject() {
		this.departure_time = "";
		this.arrive_time = "";
		this.airline = "";
		this.flight_num = "";
		this.starting_point = "";
		this.destination = "";
		this.gate_num = 0;
	}
	
	public FlightInfoObject(String departure_time, String arrive_time, String airline, String flight_num,
			String starting_point, String destination, int gate_num) {
		this.departure_time = departure_time;
		this.arrive_time = arrive_time;
		this.airline = airline;
		this.flight_num = flight_num;
		this.starting_point = starting_point;
		this.destination = destination;
		this.gate_num = gate_num;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getArrive_time() {
		return arrive_time;
	}

	public void setArrive_time(String arrive_time) {
		this.arrive_time = arrive_time;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFlight_num() {
		return flight_num;
	}

	public void setFlight_num(String flight_num) {
		this.flight_num = flight_num;
	}

	public String getStarting_point() {
		return starting_point;
	}

	public void setStarting_point(String starting_point) {
		this.starting_point = starting_point;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getGate_num() {
		return gate_num;
	}

	public void setGate_num(int gate_num) {
		this.gate_num = gate_num;
	}

	@Override
	public int compareTo(FlightInfoObject o) {
		// TODO Auto-generated method stub
		if(this.departure_time.equals("null")) {
			return this.arrive_time.compareTo(o.getArrive_time());
		}
		else {
			return this.departure_time.compareTo(o.getDeparture_time());
		}
	}
}
