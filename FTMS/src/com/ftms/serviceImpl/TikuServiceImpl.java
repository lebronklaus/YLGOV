package com.ftms.serviceImpl;

import net.sf.json.JSONArray;

import com.ftms.dao.TikuDAO;
import com.ftms.entity.Tiku;
import com.ftms.service.TikuService;

public class TikuServiceImpl implements TikuService {
	private TikuDAO tikuDAO;

	public TikuDAO getTikuDAO() {
		return tikuDAO;
	}

	public void setTikuDAO(TikuDAO tikuDAO) {
		this.tikuDAO = tikuDAO;
	}

	@Override
	public JSONArray findQuestion(String profession, String questionType,
			String difficulty, String question) {
		// TODO Auto-generated method stub
		return JSONArray.fromObject(tikuDAO.findQuestion(profession, questionType, difficulty, question));
	}
	@Override
	public void deleteQuestion(int questionid) {
		// TODO Auto-generated method stub
		tikuDAO.delete(tikuDAO.findById(questionid));
	}

	@Override
	public void editQuestion(Tiku tiku) {
		// TODO Auto-generated method stub
		if("判断题".equals(tiku.getQuestionType())){
			tiku.setSelectionA("");
			tiku.setSelectionB("");
			tiku.setSelectionC("");
			tiku.setSelectionD("");
		}
		tikuDAO.merge(tiku);
	}

	@Override
	public void addQuestion(Tiku tiku) {
		// TODO Auto-generated method stub
		if("判断题".equals(tiku.getQuestionType())){
			tiku.setSelectionA("");
			tiku.setSelectionB("");
			tiku.setSelectionC("");
			tiku.setSelectionD("");
		}
		tikuDAO.save(tiku);
	}
}
