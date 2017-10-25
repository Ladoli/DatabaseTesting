import java.io.Serializable;
import java.util.LinkedList;

public class tuple implements Serializable{
	
	private myLL<fieldData> dataList = new myLL<fieldData>();
	
	
	public tuple(myLL<fieldData> record)
	{
		dataList = record;
	}
	
	public String toString()
	{
		String tupleRecord ="";

		for(int i = dataList.size()-1; i > -1; i--) 		
		{
			if(dataList.get(i) == null)
			{
				tupleRecord += "null" + "\t";
			}
			else
			tupleRecord += ((fieldData) dataList.get(i)).toString() + "\t";
		}	
			
			
			
		dataList.toString();

		return tupleRecord;
		
	}

	public void removeFieldEntry(int n) {
			dataList.remove(n);
		
	}
	
	public void setNull(int n)
	{
		
		dataList.push(null);
		
		
	}
}
