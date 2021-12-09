package AGRS;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class ServerAdapter implements ServerTarget{
	private Firestore db;
	
	public ServerAdapter() {
		initialize();
	}
	
	public void initialize() {
		try {
			FileInputStream accountPath =
					new FileInputStream("src/main/resources/sa-airportserver-firebase-adminsdk-h57g4-c032473b32.json");
			FirebaseOptions option = FirebaseOptions.builder()
					.setCredentials(GoogleCredentials.fromStream(accountPath))
					.build();
			FirebaseApp.initializeApp(option);
			db = FirestoreClient.getFirestore();
		}catch(Exception e) {
			e.printStackTrace();
			//System.out.println("서버 접속 오류");
		}
	}
	
	public void inputData(FlightInfoObject input_info) {
		try {
			db.collection("2021_12_09").document(input_info.getFlight_num()).set(input_info).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<FlightInfoObject> flightInfoReq(String date) {
		ArrayList<FlightInfoObject> info_list = new ArrayList<>();
		try {
			List<QueryDocumentSnapshot> documents = db.collection(date).get().get().getDocuments();
			for(QueryDocumentSnapshot document : documents) {
				info_list.add(document.toObject(FlightInfoObject.class));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info_list;
	}
	
	public ArrayList<ArrayList<Integer>> mapReq(){
		return null;
	}
}
