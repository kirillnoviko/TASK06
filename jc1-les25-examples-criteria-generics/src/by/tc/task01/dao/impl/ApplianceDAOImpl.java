package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;

public class ApplianceDAOImpl implements ApplianceDAO{

	private static final String SOURCE_PATH = "E:\\eclipseProject\\jc1-les25-examples-criteria-generics\\resources\\appliances_db.txt";
	private static final String SOURCE_DEVIDER_APPLIANCE_PROPERTY = "\\s+:\\s+";

	@Override
	public <E> List<Appliance> find(Criteria<E> criteria) {

		BufferedReader allInfoFile=null;
		String paramsAll=null;

		List<Appliance> result = new ArrayList<Appliance>();
		int flag = 0;


	

		try {
			
			allInfoFile = new BufferedReader(new FileReader(new File(SOURCE_PATH)));

	
			while ((paramsAll = allInfoFile.readLine()) != null) {
				flag = 0;

					for (Entry<E, Object> entry : criteria.getCriteria()) {

						String param = entry.getKey() + "=" + entry.getValue();
						Pattern pattern = Pattern.compile(param);
						Matcher m = pattern.matcher(paramsAll);

						if (!m.find()) {
							flag = 1;
						}

					}
				
					if (flag == 0) {
						//создаем объект Applience  и возвращаем его
						// не придумал как это коректно сделать, кроме как реализовать паттерн команд
						// но  вы говорили что это не сильно корректно поэтому не стал реализовывать
					}
					
				

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	// you may add your own code here

}



//you may add your own new classes
