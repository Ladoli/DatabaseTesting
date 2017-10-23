import java.io.Serializable;
import java.util.Date;

public class fieldData implements Serializable{
	
	Object data;
	
	
	int fieldType;
	
	public fieldData(String rawData)
	{
		data = rawData;
	}
	
	public String toString()
	{

		return data.toString();
		
	}

}
