import java.net.URLEncoder;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


import org.json.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Chert_E_Pert_Timer {
	public static void main(String[] args) {
		File f = new File("file_jsone.txt");
		String str = "";
		try {
			Scanner cin = new Scanner(f);
			while (cin.hasNext()) {
				str += cin.next();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
		String jsonString = str; //assign your JSON String here
		JSONObject obj = new JSONObject(jsonString);
		String name = obj.getString("SSID");
		System.out.println(name);
//		JSONArray arr = obj.getJSONArray("posts"); // notice that `"posts": [...]`
//		for (int i = 0; i < arr.length(); i++)
//		{
//		    String post_id = arr.getJSONObject(i).getString("post_id");
//
//		}
	} 
	
	public void load() {
		
	}
	
	
	public static String spaceKiller(String str) {
		char[] arr_str = str.toCharArray();
		for(int i=0; i<str.length(); i++) 
			if(str.charAt(i) == ' ') arr_str[i] = '$';
		str = String.valueOf(arr_str);
		return str;
	}
}
