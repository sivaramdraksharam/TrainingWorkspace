package io.thrill.bookmark.utils;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class IOUtil {
	
	public static String[] read(String[] data,String fileName) {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
			String line;
			int count = 0;
			while((line=reader.readLine())!=null) {
				data[count] = line;
				count++;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}

	public static String read(InputStream inputStream) {
		StringBuilder strBuilder = new StringBuilder();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
			String line;
			//int count = 0;
			while((line=reader.readLine())!=null) {
				strBuilder.append(line).append("\n");
				//count++;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strBuilder.toString();
	}

	public static void write(String content, String filePath) {
		try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),"UTF-8")) ){
			writer.write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
