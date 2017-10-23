import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Tester {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		Table test = new Table("Test");
		test.addField("Name", 0);
		String[] arrayTest = {"Angelo"};
		test.addTuple(arrayTest);
		System.out.println(test.getFieldNum());
		 File file = new File("Test.txt");
		 FileInputStream fileIn = new FileInputStream(file);
		 ObjectInputStream objReader = new ObjectInputStream(fileIn);
		 Table test2 = (Table) objReader.readObject();
			System.out.println(test2.getFieldNum());
			System.out.println(test2.getTuple(0));
			System.out.println(test.getTuple(0));
			System.out.println(test2.tableName);


	}

}
