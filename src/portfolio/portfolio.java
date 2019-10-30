
package portfolio;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
public class portfolio
{

	@SuppressWarnings(
	{ "resource", "unused" })
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String filename = scanner.nextLine();
		File file = new File(filename);

//		System.out.println("File path : " + filename);
		BufferedReader reader;
		try
		{
			reader = new BufferedReader(new FileReader((filename)));
			String line = reader.readLine();
			HashMap<Integer, String> sum = new HashMap<Integer,String>();
			ArrayList<Integer> compare = new ArrayList<Integer>();
			while (line != null)
			{
//				System.out.println(line);

				String[] stockMetrics = line.split(",");

				HashMap<String, Integer> stockOrderingMap = new HashMap<>();
				

				for (int i = 0; i < stockMetrics.length; i++)
				{
					String stock = stockMetrics[i];
					int value = Integer.valueOf(stock.trim().split("-")[1].trim());

					stockOrderingMap.put(stock, value);
					
				}
				Integer integerSum = stockOrderingMap.values().stream().mapToInt(Integer::intValue).sum();
		       
//				System.out.println("summ: " + integerSum);
		        
				compare.add(integerSum);
				
				 
				sum.put(integerSum, line);
				
				
				// read next line
				line = reader.readLine();
			}
			Collections.sort(compare, Collections.reverseOrder());
			
			for (int i = 0; i < compare.size(); i++) {
				
				System.out.println(sum.get(compare.get(i)));
				
			}
	        
			reader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
