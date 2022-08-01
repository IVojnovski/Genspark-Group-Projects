import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// 2 columns displayed max == 7 items
// items amount > 0 && items amount <= 8
//4 items per column
// 3 columns displayed max == 25 items
// items amount > 8 && items amount <= 26
// 9 items per column
// 4 columns displayed max == 84 items
//items amount > 26 && items amount <= 85
// 14 items per column
// make an algorithm that grows each of these values and formats it 
// to the desired column wise output

//format function should be able to detect the amount of items that are in the list and edit the printf functions so that it prints all of the 
// parts of the list that exist in the list into the appropriate columns


public class Challenge_1 {
	public static void main (String args[]) {
		try {
			List<String> lines = Files.readAllLines(Paths.get("C:\\Genspark-Group-Projects\\Challenge-1\\challenge-1.txt"),
					StandardCharsets.UTF_8); //this is the stream from the text file put into a List
			int size = lines.size(); //size of the list
			format(size, lines); //function that formats all of the list contents from the file stream and prints them in the column format
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	static void format (int size, List<String> list) {
		if (size <= 8) {
			System.out.printf("%-15s%-15s\n", list.get(0), list.get(4));
			System.out.printf("%-15s%-15s\n", list.get(1), list.get(5));
			System.out.printf("%-15s%-15s\n", list.get(2), list.get(6));
			System.out.printf("%-15s\n", list.get(3));
		}
		if (size > 8 && size <= 26) {
			System.out.printf("%-15s%-15s%-15s\n", list.get(0), list.get(9), list.get(18));
			System.out.printf("%-15s%-15s%-15s\n", list.get(1), list.get(10), list.get(19));
			System.out.printf("%-15s%-15s%-15s\n", list.get(2), list.get(11), list.get(20));
			System.out.printf("%-15s%-15s%-15s\n", list.get(3), list.get(12), list.get(21));
			System.out.printf("%-15s%-15s%-15s\n", list.get(4), list.get(13), list.get(22));
			System.out.printf("%-15s%-15s%-15s\n", list.get(5), list.get(14), list.get(23));
			System.out.printf("%-15s%-15s%-15s\n", list.get(6), list.get(15), list.get(24));
			System.out.printf("%-15s%-15s\n", list.get(7), list.get(16));
			System.out.printf("%-15s%-15s\n", list.get(8), list.get(17));
		}
	}
}
