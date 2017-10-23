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
}
