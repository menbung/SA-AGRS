package AGRS;

public class FlightInfoObject {
	private String departure_time;
	private String arrive_time;
	private String airline;
	private String flight_num;
	private String starting_point;
	private String destination;
	private int gate_num;
	
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
}
