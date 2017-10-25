import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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
		for(int i = 0; i<tupleList.size(); i++)
		{
			((tuple) tupleList.get(i)).setNull(numberoffields);
		}
		numberoffields++;
		Update();
		
	}
	
	public void removeField(int n) throws IOException
	{
		for(int i = 0; i<tupleList.size(); i++)
		{
			((tuple) tupleList.get(i)).removeFieldEntry(n);
		}
		fieldsList.remove(n);
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
	
	
	public void removeTuple(int n) throws IOException
	{
		tupleList.remove(n);
		 Update();

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
	
	
	public void printEntries() 
	{
		System.out.println(getFields().toString());
		for(int i = tupleList.size()-1; i >-1; i--) 		
		{
			System.out.println(getTuple(i).toString());
		}
		
	}
	
	public void importdata() throws IOException
	{
		File file = new File("MockData.txt");
		BufferedReader bR = new BufferedReader(new FileReader(file));
		String entry = bR.readLine();
		while(entry != null)
		{
			String[] enterThis = entry.split(",");
			addTuple(enterThis);
			entry = bR.readLine();
		}
		bR.close();
		
	}
	
//	public static <T extends Comparable<T>> void quickSorter(int left, int right, myLL<T> list)
//	{
//		
//		if (list == null || left >= right-1 || left == right ) 
//		{
//			return; 
//		}
//
//	     int front = left - 1;
//	     int last = right - 1;
//	     T pivot = (T) list.get(last);
//	     boolean needsWork = true;
//	     while (needsWork)
//	     {
//	         while (((Comparable<T>) list.get(++front)).compareTo(pivot) < 0);
//	         while (((Comparable<T>) list.get(--last)).compareTo(pivot) > 0  && last > left);
//	         if (front < last)
//	         {
//	             swap(front,last, list);
//	         }
//	         else if(front != (right-1))
//	         {
//	        	 swap(front,right-1, list);
//	             needsWork = false;   
//	         }
//	         else
//	         {
//	        	 needsWork = false;
//	         }
//	     }
//	     
//	     quickSorter(left, front, list);
//	     quickSorter(front + 1, right, list);
//	    
//	}
//	
//	 
//	 public static <T extends Comparable<T>> void swap(int a, int b, myLL<T> list)
//	 {
//			 T temp = (T) list.get(a);
//			 list.set(a, list.get(b));
//			 list.set(b, temp);
//
//	 }

	
}
