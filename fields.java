import java.io.Serializable;
import java.util.Date;

public class fields implements Serializable{
	String fieldName;
	int fieldType;
	String fieldTypeName;
	int fieldnumber;
	
	
	public fields(String name, int type, int n2)
	{
		fieldName = name;
		fieldType = type;
		fieldnumber = n2;
		setField(type);
	}
	





	
	public void setField(int n)
	{
		fieldType = n;
		if(n==0)
		{
			fieldTypeName = "String";
		}
		else if(n==1)
		{
			fieldTypeName = "Integer";
		}
		else if(n==2)
		{
			fieldTypeName = "Double";
		}
		else if(n==3)
		{
			fieldTypeName = "Date";
		}
	}
	
	/*
	public String datatypeCheck(String s)
	{
		String result = "Operation not completed";
		
		if(fieldType == 0)
		{
			result = "Data added";
		}
		else if(fieldType == 1)
		{
			try {
			Integer.parseInt(s);
			}
			catch(Exception e)
			{
				result = "Wrong input format";
			}

			
		}
		else if(fieldType == 2)
		{
			try {
			Double.parseDouble(s);
			result = "Data added";
			}
			catch(Exception e)
			{
				result = "Wrong input format";
			}

			
		}
		else if(fieldType == 3)
		{
			try {
			Date.parse(s);
			result = "Data added";
			}
			catch(Exception e)
			{
				result = "Wrong input format";
			}

			
		}
		
		
		
		return result;
	}
	*/
}
