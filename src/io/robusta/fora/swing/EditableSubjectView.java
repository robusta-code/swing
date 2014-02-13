package io.robusta.fora.swing;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.annotations.View;
import io.robusta.fora.domain.Subject;

import java.awt.BorderLayout;

import javax.swing.JPanel;

@View
public class EditableSubjectView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Subject subject;
	SubjectView subjectView;
	
	public SubjectView getSubjectView() {
		return subjectView;
	}

	public EditableSubjectView(Subject subject){
		this.subject = subject;
		initView();
	}
	

	public void setSubjectView(SubjectView subjectView) {
		this.subjectView = subjectView;
	}


	public EditableSubjectView(){
		this.subject = ForaDataSource.getInstance().getSubjects().get(0);
		initView();
	}
	/**
	 * Create the panel.
	 */
	public void initView() {
		setLayout(new BorderLayout(0, 0));
		
		subjectView = new SubjectView(subject);
		add(subjectView, BorderLayout.NORTH);
		
		CreateCommentModel createCommentModel = new CreateCommentModel();
		createCommentModel.setSubject(subject);
		CreateCommentView createCommentView = new CreateCommentView(createCommentModel);
		add(createCommentView, BorderLayout.SOUTH);
		
		SubjectController subjectController = new SubjectController(subjectView, subject);
		subjectView.setController(subjectController);
		
		CreateCommentController createCommentController = new CreateCommentController(createCommentView, createCommentModel);
		createCommentView.setController(createCommentController );
		createCommentController.setSubjectController(subjectController);
		

	}

}
