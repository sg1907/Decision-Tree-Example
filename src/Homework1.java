import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Homework1 {

	public static void main(String[] args) throws IOException {

		int attributes = 1000000;  // if you want , you can use more or less attributes
		
		int[][] a = new int[attributes][5];
		String[][] b = new String[attributes][5];
		Random rnd = new Random();
		int[] result = new int[attributes];
		boolean[] bool = new boolean[attributes];
		String[] str = new String[attributes];
		
		// get random 1 or 0 and into to array
		
		for (int i = 0; i < attributes; i++) {
			for (int j = 0; j < 5; j++) {
				a[i][j] = rnd.nextInt(2);
			}
		}
		
		// attributes and or process
		
		for (int i = 0; i < attributes; i++) {
			for (int j = 0; j < 5; j++) {
				result[i] = (a[i][0] & a[i][1]) | (a[i][1] & a[i][2]) | (a[i][2] & a[i][3]) | (a[i][3] & a[i][4]);
				if (result[i] == 1)
					bool[i] = true;
				else
					bool[i] = false;
			}
		}
		
		// convert bool array to str array
		
		for (int i = 0; i < attributes; i++) {
			if (bool[i] == true)
				str[i] = "True";
			else
				str[i] = "False";
		}
		
		// convert int array to str array from result of process compare to attributes
		
		for(int i=0; i<attributes; i++) {
			for(int j=0; j<5; j++) {
				if(a[i][j] == 0)
					b[i][j] = "False";
				else if( a[i][j] == 1)
					b[i][j] = "True";
			}
		}
		
		// write to arff txt by use to write file process 
		
		File dosya = new File("tree.arff");
		FileWriter writer = new FileWriter(dosya);
		BufferedWriter w = new BufferedWriter(writer);
		String arff_type = "@relation class\r\n" + 
				"@attribute A1 	{True, False}\r\n" + 
				"@attribute A2	{True, False}\r\n" + 
				"@attribute A3	{True, False}\r\n" + 
				"@attribute A4	{True, False}\r\n" + 
				"@attribute A5	{True, False}\r\n" + 
				"@attribute class	{True, False}\r\n" + 
				"@data \n";
		w.write(arff_type);
		for (int i = 0; i < attributes; i++) {
			for(int j=0; j<5; j++) {
				w.write(b[i][j]+",");
			}
			w.write(str[i] + "\n");
		}
		w.close();
	}
}
