import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Tester {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		Table test = new Table("Test");
		test.addField("Name", 0);
		String[] arrayTest = {"Angelo"};
		test.addTuple(arrayTest);
		test.addField("Delete Field", 0);
		test.addField("Added Field", 0);
		String[] arrayTest2 = {"Yes","May this be gone","Vi"};
		test.addTuple(arrayTest2);
		String[] arrayTest3 = {"No","May this be gone","La"};
		test.addTuple(arrayTest3);
		String[] arrayTest4 = {"Angelo", "Dupli", "Dupli"};
		test.addTuple(arrayTest4);
		test.addTuple(arrayTest4);
		test.addTuple(arrayTest4);
		test.addTuple(arrayTest4);
		test.printEntries();
		test.importdata();
		 File file = new File("Default\\Test.txt");
		 FileInputStream fileIn = new FileInputStream(file);
		 ObjectInputStream objReader = new ObjectInputStream(fileIn);
		 Table test2 = (Table) objReader.readObject();
		 test2.printEntries();
		 objReader.close();
			test.genBin("Angelo", 2); //Sort works, but needs change. tuple searchField needs to be revised and based on Table instead or atleast passed from table.
			
			

	}
	
	

}
