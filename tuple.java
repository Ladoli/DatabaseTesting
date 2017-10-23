import java.io.Serializable;
import java.util.LinkedList;

public class tuple implements Serializable{
	
	private LinkedList<fieldData> dataList = new LinkedList<fieldData>();
	
	
	public tuple(LinkedList<fieldData> record)
	{
		dataList = record;
	}
}
