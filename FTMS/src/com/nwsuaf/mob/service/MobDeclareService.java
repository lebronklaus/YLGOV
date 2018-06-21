package com.nwsuaf.mob.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ftms.dao.ResultsDAO;
import com.ftms.entity.Results;
import com.nwsuaf.mob.domain.DeclareInfo;

public class MobDeclareService {
	/*
	 * ע��web���ResultsDAO
	 */
	private ResultsDAO resultsDAO;

	public void setResultsDAO(ResultsDAO resultsDAO) {
		this.resultsDAO = resultsDAO;
	}
	/*
	 * �����û����������֤����Ϣ
	 */
	public List<DeclareInfo> getUserResult(String username, String level) {
		List<Results> re=resultsDAO.getUserResult(username, level);
		
		//�洢ת��֮�������֤����Ϣ
		List<DeclareInfo> list = new ArrayList<DeclareInfo>();
		
		
		
		Iterator iter = re.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();		
			list.add(new DeclareInfo(data[0]+"",data[3]+"", data[4]+"", "", data[5]+"",data[6]+"",data[7]+"",data[8]+"", "", level,data[2]+"", data[9]+""));
		}
		
		
		
		/*for (Results result : re) {
			list.add(new DeclareInfo(result.getAchievement(), result.getWritescore()+"", result.getInterviewscore()+"", result.getTotalscore()+"", result.getTotal()+"", result.getCanjia()+"", result.getApproval()+"", result.getOpposition()+"", result.getChecktime().toString().split(" ")[0], result.getLevel(), result.getUser().getProf2().getName(), result.getNumber()));
		}*/

		return list;
	}
}
