import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class Table implements Serializable{
	private myLL<fields> fieldsList = new myLL<fields>();
	private myLL<tuple> tupleList = new myLL<tuple>();
	String tableName;
	int numberoffields = 0;
	
	
	Table(String name) throws IOException
	{
		tableName = name;
		Update();
		
	}
	
	
	
	
	public void addField(String s, int n) throws IOException
	{
		fieldsList.push(new fields(s,n,numberoffields));
		
		numberoffields++;
		Update();
		
	}
	
	public int getFieldNum()
	{
		return numberoffields;
	}
	
	public String addTuple(String[] rawData) throws IOException
	{
		String result ="";
		 if(rawData.length > numberoffields)
		 {
			 result = "Unforseen error, please contact admin";
		 }
		 else if(rawData.length < numberoffields)
		 {
			 result = "Please do not leave empty fields";
		 }
		 else 
		 {
			 myLL<fieldData> tupleEntry = new myLL<fieldData>();

			 for(String s: rawData)
			 {
				 tupleEntry.push(new fieldData(s));
			 }
			 tupleList.push(new tuple(tupleEntry));

			 System.out.println("Tupple added, new size is " + tupleList.size());
			 
		 }
		 Update();

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
		
		if(tupleList.element() == null)
		{
			return null;
		}
		else {
			tuple toGet =  (tuple) tupleList.get(i);
			
			return toGet.toString();
		}
		
	}
	
	public String getFields() 
	{
		String fieldNames = ""; 
		for(int i = fieldsList.size()-1; i >-1; i--) 
		{
			fieldNames += ((fields) fieldsList.get(i)).getfieldName() + "\t";
		}
		
		return fieldNames;
	}

	
}
