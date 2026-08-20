package testingdao;

import javabean.Job;
import negocio.IJobDao;
import negocio.JobDaoImplList;

public class TestJobDao {

	public static void main(String[] args) {
		IJobDao iJobDao = new JobDaoImplList();
		
		for (Job ele: iJobDao.findAll())
			System.out.println(ele);

	}

}
