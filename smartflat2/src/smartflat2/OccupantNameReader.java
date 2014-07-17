package smartflat2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class OccupantNameReader {
	String filelocation;
	BufferedReader br;
	String line;
	String cvsSplitBy;
	String[][] occupants;
	
	OccupantNameReader(){
		filelocation = "C:/Users/Stephen/Google Drive/SmartFlatting/Test Data/FakeNames.csv";
		br = null;
		line = "";
		cvsSplitBy = ",";
	}
	
	String[][] readFile(){
		try {
			 
			ArrayList <String> firstNames = new ArrayList<String>();
			ArrayList <String> lastNames = new ArrayList<String>();
			
			br = new BufferedReader(new FileReader(filelocation));
			while ((line = br.readLine()) != null) {
	 
			    // use comma as separator
				String[] names = line.split(cvsSplitBy);
				firstNames.add(names[0].toString());
				lastNames.add(names[1].toString());
				
				/*String[][] occupants = line.split(cvsSplitBy);
	 
				System.out.println("FirstName = " + occupants[0] 
	                                 + " , name=" + occupants[1] + "]");*/
	 
			}
			occupants = new String[firstNames.size()][2];
			
			for (int i = 0; i < firstNames.size(); i++){
				occupants[i][1] = firstNames.get(i);
				occupants[i][0] = lastNames.get(i);
			}
	 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		return occupants;
	}
	
	
}
