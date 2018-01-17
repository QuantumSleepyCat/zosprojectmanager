package by.iba.logsgetter.getlogs.reading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

import by.iba.logsgetter.getlogs.reading.util.StatusChecker;
import by.iba.projmanmodels.model.statuslist.StatusBarList;
import by.iba.projmanmodels.model.statuslist.item.StatusItem;

@Service
public class ReadLogsImpl implements ReadLogs{

	@Override
	public void read(String appName, String fileName) {
		for(StatusItem statusIt : StatusBarList.getInstance().getStatusItems().values())
		{
			System.out.println(statusIt.getAppName().toUpperCase());
			String name=statusIt.getAppName();
			if(name.equals(appName))
			{
				System.out.println("flag");
				String logs = readLog(appName, fileName);
			    if(StatusChecker.getStatus(logs))
			    {
			    	statusIt.setStatus("Finished");
			    	statusIt.setStyleClass("list-group-item list-group-item-primary");
			    	statusIt.setLogs(logs);
			    }
			    else
			    {
			    	statusIt.setStatus("Failed");
			    	statusIt.setStyleClass("list-group-item list-group-item-danger");
			    	statusIt.setLogs(logs);
			    }
			    }
			else
			{
				System.err.println(name);
			}
			}
		
		}
		
	
	
/*	public static void main(String [] args) throws UnsupportedEncodingException
	{
		ReadLogsImpl read = new ReadLogsImpl();
		//System.out.println(StatusChecker.getStatus(read.readLog("ASDSA")));
		//System.out.println("testAP3".toUpperCase());
		StatusItem statusIt=new StatusItem();
		statusIt.setAppName("TESTap3");
		StatusBarList.getInstance().getStatusItems().put(12,statusIt);
		String str = new String("TESTAP3".getBytes(),"UTF-16");
		read.read("TESTAP3".replace("TESTAP3".substring(0, 1), ""));
		for(int i=0;i<"TESTAP3".length();i++)
		{
			int k=0, l=0;
			k="TESTAP3".charAt(i);
			l="TESTAP3".replace("TESTAP3".substring(0, 1), "").charAt(i);
			System.out.println("Норм знач: "+k+" Мейнфрейм знач: "+l);
			//System.err.println(l);
		}
		System.out.println("TESTAP3".getBytes());
		System.err.println("TESTAP3".getBytes());
	}*/
	
	public String readLog(String appName, String fileName)
	{
		String logs="";
		//File dir = new File("logs/"+appName);
		//List<File> files = new ArrayList<>(Arrays.asList(dir.listFiles()));
		//File log = null;
		//long time=0;
		/*for(File file:files)
		{
			if(file.lastModified()>time)
			{
				time=file.lastModified();
				log=file;
			}
		}*/
		File file = new File("logs/"+appName+"/"+fileName);
		try {
			BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
			while(bufferedReader.ready())
			{
				logs+=bufferedReader.readLine()+"\n";
			}
			logs+="##########end#########\n";
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return logs;
	}

}
