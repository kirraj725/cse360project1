// This is the csv handler class that reads and writes data between gui and csv
package TEST1Phase1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVfileHandler
{
	private String fileName;
	
	public CSVfileHandler(String fileName) 
	{
        this.fileName = fileName;
    }
	
	// Reading data from a csv file
	public List<String[]> readFromCSV()
	{
		List<String[]> accounts = new ArrayList<>();
		String line;
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
		{
			br.readLine();
			
			while ((line = br.readLine()) != null)
			{
				String[] accountDetails = line.split(",");
				accounts.add(accountDetails);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return accounts;
	}
	
	// Writing data from a csv file
	public void writeToCSV(List<String[]> data)
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true)))
		{
			for (String[] account : data)
			{
				bw.write(String.join(",", account));
				bw.newLine();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	// Checking to see if the csv file is empty
	public boolean isCSVFileEmpty(String fileName) {
	        try {
	            Path path = Paths.get(fileName);
	            return Files.size(path) == 0; // Returns true if file is empty
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false; // Handle exceptions, return false or throw
	        }
	
	
	}
}
