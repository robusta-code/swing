package io.robusta.fora.swing;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Subject;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class EditableSubjectView extends JPanel {

	Subject subject;
	
	
	public EditableSubjectView(Subject subject){
		this.subject = subject;
		initView();
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
		
		SubjectView subjectView = new SubjectView(subject);
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
