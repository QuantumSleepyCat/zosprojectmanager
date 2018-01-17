package by.iba.logsgetter.getlogs.reading.util;

public class StatusChecker {
	public static boolean getStatus(String logs)
	{
		int lineRCnumber=-1;
		int counter=0;
		String [] lines = logs.split("\n");
		for(String line:lines)
		{
			if(line.contains("STEPNAME PROCSTEP    RC   EXCP"))
			{
				System.out.println(line);
				lineRCnumber=counter;
				System.out.println(lineRCnumber);
			}
			counter++;
		};
		int rc=-2;
		try{
		System.out.println(Integer.valueOf(lines[lineRCnumber+1].substring(lines[lineRCnumber].indexOf("RC")-5, lines[lineRCnumber].indexOf("RC")+2).trim()));
		rc=Integer.valueOf(lines[lineRCnumber+1].substring(lines[lineRCnumber].indexOf("RC")-5, lines[lineRCnumber].indexOf("RC")+2).trim());
		}
		catch(NumberFormatException e)
		{
			rc=-1;
			System.err.println(rc);
		}
		if(lineRCnumber==-1)
		{
			rc=-1;
		}
		if(rc==0 || rc==4)
		{
			return true;
		}
		return false;		
	}
}
