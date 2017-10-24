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

		return dataList.toString();
		
	}

	public void removeFieldEntry(int n) {
			dataList.remove(n);
		
	}
	
	public void setNull(int n)
	{
		
		dataList.push(null);
		
		
	}
}
