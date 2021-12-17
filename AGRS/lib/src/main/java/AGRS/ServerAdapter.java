package AGRS;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class ServerAdapter implements ServerTarget{
	private static ServerAdapter instance = new ServerAdapter();//�̱��� ����� ���� ����
	private Firestore db;
	
	private ServerAdapter() {//�ܺο��� �߰� �����ϴ°� �������� private
		initialize();
	}
	
	public static ServerAdapter getInstance() {//�̱����� ���� �ν��Ͻ� ��ȯ �Լ�
		return instance;
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
			//System.out.println("���� ���� ����");
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
	
	public int[] mapReq(){
		int[] map_size = new int[2];
		try {
			DocumentSnapshot document = db.collection("airport_map").document("1f_map").get().get();
			map_size[0] = document.getLong("map_width").intValue();
			map_size[1] = document.getLong("map_height").intValue();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map_size;
	}
}