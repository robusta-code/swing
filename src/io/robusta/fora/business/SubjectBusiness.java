package io.robusta.fora.business;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.beans.SubjectBean;
import io.robusta.fora.domain.Subject;

import java.util.List;
import java.util.logging.Logger;


public class SubjectBusiness {

	private final  static Logger logger = Logger.getLogger(SubjectBusiness.class.getName()); 
	
	ForaDataSource fora = ForaDataSource.getInstance();



	public Subject getSubjectById(long id) {
		synchronized (fora) {
			for (Subject s : fora.getSubjects()){
				if (s.getId() == id){
					return s;
				}
			}
		}
		
		return null;//or throw exception
	}
	
	public SubjectBean getSubjectBean(long id) {
		return getSubjectBean(id, 0, -1);
	}
	
	public List<Subject> getAllSubjects() {
		return fora.getSubjects();
		
	}

	
	public SubjectBean getSubjectBean(long id, int commentStart, int length) {
		Subject s = getSubjectById(id);		
		SubjectBean bean = new SubjectBean(s);
		bean.setCommentCount(s.getComments().size());
		return bean;
	}
	
	public int countSubjects(){
		synchronized (fora) {
			return fora.getSubjects().size();
		}
		
	}
}
