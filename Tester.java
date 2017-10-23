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
		test.addField("Added Field", 0);
		String[] arrayTest2 = {"Yes","Vi"};
		test.addTuple(arrayTest2);
		 File file = new File("Test.txt");
		 FileInputStream fileIn = new FileInputStream(file);
		 ObjectInputStream objReader = new ObjectInputStream(fileIn);
		 Table test2 = (Table) objReader.readObject();
		 	System.out.println(test2.getFields());
		 	System.out.println(test2.getTuple(0)); //Because new entries are added to top of stack in a LinkedList, this one prints Vi, Yes
			System.out.println(test2.getTuple(1));
			
			objReader.close();
	}

}
