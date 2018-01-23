package by.iba.logsgetter.getlogs;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

@Service 
public class GetLogsByFtpImpl implements GetLogsByFtp{

	@Override
	public void execute(String appName, String fileName) {
		 FTPClient client = new FTPClient();
	     try {
			client.connect("172.20.2.116");
			client.login("user06a", "user06a");
			
			OutputStream outStr =  null;
			boolean statusCreDir=new File("logs/"+appName).mkdirs();
			if(fileName!=null)
			{
				//infos[i].replace("USER06A.", "");
				String dir="logs/"+appName+"/"+fileName;
				outStr = new BufferedOutputStream(new FileOutputStream(dir));
				boolean status = client.retrieveFile(fileName, outStr);
				System.out.println("Результат загрузки файла-лога: "+status);
			}
			outStr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
