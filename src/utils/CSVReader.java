package utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import structures.Arco;
import structures.ArcoEstacion;


public class CSVReader {

	private String path;
	private LinkedList<Arco<Integer>> archs;
	
	public CSVReader(String path) {
		
		this.path = path;
		this.archs = new LinkedList<>();
	}
	
	public LinkedList<Arco<Integer>> read() {
		
		ArrayList<String[]> lines = this.readContent();
		
		for (String[] line: lines) {
			Integer origen = Integer.parseInt(line[0].trim().substring(1));
			Integer destino = Integer.parseInt(line[1].trim().substring(1));
			Integer etiqueta = Integer.parseInt(line[2].trim());
			Arco<Integer> arco = new ArcoEstacion<>(origen, destino, etiqueta);
			this.archs.add(arco);
		}
		return this.archs;
	}

	private ArrayList<String[]> readContent() {
		
		ArrayList<String[]> lines = new ArrayList<String[]>();

		File file = new File(this.path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				lines.add(line.split(";"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		
		return lines;
	}

}