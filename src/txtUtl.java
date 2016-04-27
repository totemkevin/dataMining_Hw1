import java.io.BufferedReader;

import java.io.BufferedWriter;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;


public class txtUtl {
	
	public static void writerTxt(String inputMsg) {

		BufferedWriter fw = null;

		try {

			File file = new File("C:/GAtest/GA.txt");

			fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")); // 指點編碼格式，以免讀取時中文字符異常

			fw.append(inputMsg);

			fw.flush(); // 全部寫入緩存中的內容

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (fw != null) {

				try {

					fw.close();

				} catch (IOException e) {

					e.printStackTrace();

				}

			}

		}

	}

		 

	// 讀文件

	public static String readTxt() {

		//String filePath = txtUtl.class.getResource("").getPath().replace("file:", "")	+ "/GA.txt"; // 文件和該類在同個目錄下
		String filePath ="C:/GAtest/GA.txt";
		
		BufferedReader reader = null;
		String output = "";
		try {

			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8")); // 指定讀取文件的編碼格式，以免出現中文亂碼

			String str = null;

			while ((str = reader.readLine()) != null) {

				output+=str+"\n";
				
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				reader.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}
		return output;

	}
	public static void clean()
	{
		try{
			File file = new File("C:/GAtest/GA.txt");//这里是你txt的路径，记得路径下一级用“\\"实现
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bw1 = new BufferedWriter(fileWriter);
			bw1.write("");
		}
		catch (Exception e)
		{
			
		}
	}
	/*public static void main(String[] arg)
	{
		writerTxt("789");
		readTxt();
	}*/

}
