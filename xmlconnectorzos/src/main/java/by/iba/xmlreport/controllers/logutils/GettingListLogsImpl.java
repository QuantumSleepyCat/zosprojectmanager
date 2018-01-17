package by.iba.xmlreport.controllers.logutils;

import org.springframework.stereotype.Service;

@Service
public class GettingListLogsImpl implements GettingListLogs{

	@Override
	public String[] execute(String logs) {
		return logs.split("##########end#########\n");
	}

}
