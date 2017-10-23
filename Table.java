import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class Table implements Serializable{
	private LinkedList<fields> fieldsList = new LinkedList<fields>();
	private LinkedList<tuple> tupleList = new LinkedList<tuple>();
	String tableName;
	int numberoffields = 0;
	
	
	Table(String name) throws IOException
	{
		tableName = name;
		Update();
		
	}
	
	
	
	
	public void addField(String s, int n) throws IOException
	{
		fieldsList.add(new fields(s,n,numberoffields));
		
		numberoffields++;
		Update();
		
	}
	
	public int getFieldNum()
	{
		return numberoffields;
	}
	
	public String addTuple(String[] rawData)
	{
		String result ="";
		 if(rawData.length > numberoffields)
		 {
			 result = "Unforseen error, please contact admin";
		 }
		 else if(rawData.length > numberoffields)
		 {
			 result = "Please do not leave empty fields";
		 }
		 else if(tupleList.size() == 0)
		 {
			 LinkedList<fieldData> tupleEntry = new LinkedList<fieldData>();

			 for(String s: rawData)
			 {
				 tupleEntry.addFirst(new fieldData(s));
			 }
			 tupleList.addFirst(new tuple(tupleEntry));
			 System.out.println("Tupple added, new size is " + tupleList.size());
			 
		 }
		 else
		 {
			 LinkedList<fieldData> tupleEntry = new LinkedList<fieldData>();

			 for(String s: rawData)
			 {
				 tupleEntry.add(new fieldData(s));
			 }
			 tupleList.add(new tuple(tupleEntry));
			 System.out.println("Tupple added, new size is " + tupleList.size());
			 
		 }
		 return result;
	}
	
	public void Update() throws IOException
	{
		 File file = new File(tableName + ".txt");
		 FileOutputStream fileOut = new FileOutputStream(file);
		 ObjectOutputStream objWriter = new ObjectOutputStream(fileOut);
		 objWriter.writeObject(this);
		 objWriter.close();
	}




	public String getTuple(int i) {
		
		if(tupleList.peekFirst() == null)
		{
			return "Empty";
		}
		else {
			tuple toGet =  tupleList.peekFirst();
			
			return toGet.toString();
		}
		
	}
	

	
}
