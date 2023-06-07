package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	private static String full_path_file_log = KEY.pathFile + "/" + KEY.fileName;

	public void writeFile(SnackeModel snackeModel) {
		File fileLog = new File(full_path_file_log);
		if (!fileLog.exists()) {
			try {
				fileLog.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		try {
			FileWriter fileWriter = new FileWriter(fileLog);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(ClassToString(snackeModel));
			printWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<SnackeModel> readFile() {
		List<SnackeModel> lstRes = new ArrayList<>();
	File fileLog = new File(full_path_file_log);
	if (!fileLog.exists()) {
		return lstRes;
	}
	BufferedReader br = null;
	try {
		  br = new BufferedReader(new FileReader(fileLog));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	// doc file
	String[] lstSplit = br.toString().split("\\r\\n");
	for (int i = 0; i <= lstSplit.length; i++) {
		SnackeModel model = new SnackeModel();
		if (lstSplit[i].trim().length() <= 0 && i + 3 <= lstSplit.length) {
			if (lstSplit[i + 3].trim().length() <= 0)
				break;
		}
		model.setName_user(formatValueR(lstSplit[i]));
		model.setValue(formatValueR(lstSplit[i] + 1));
		model.setName_user(formatValueR(lstSplit[i + 2]));
		model.setValue(formatValueR(lstSplit[i + 3]));
		lstRes.add(model);
		i = i + 3;
	}
	return lstRes;
	}

	public String ClassToString(SnackeModel snackeModel) {
		String res = "";
		res += snackeModel.getName_user() != null ? snackeModel.getName_user() : KEY.NULL;
		res += "\n";
		res += snackeModel.getValue() != null ? snackeModel.getValue() : KEY.NULL;
		res += "\n";
		res += snackeModel.getStart_time().toString() != null ? snackeModel.getStart_time().toString() : KEY.NULL;
		res += "\n";
		res += snackeModel.getEnd_time().toString() != null ? snackeModel.getEnd_time().toString() : KEY.NULL;
		res += "\n";
		res += "\n";
		return res;
	}

	public static String formatValueR(String value) {
		String res = "";
		if (!value.endsWith(KEY.NULL))
			res = value;
		return res;
	}
}
