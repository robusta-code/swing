package io.robusta.fora.swing;

import io.robusta.fora.annotations.View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

@View
public class CreateCommentView extends JPanel {

	CreateCommentController controller;
	CreateCommentModel model;
	
	
	JLabel errorLabel;
	public CreateCommentView() {
		model = new CreateCommentModel();
		initView();
		
	}
	
	public CreateCommentView(CreateCommentModel model ) {
		this.model = model;
		initView();
	}
	
	JTextPane contentPane ;
	/**
	 * Create the panel.
	 */
	private void initView() {
		setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		contentPane = new JTextPane();
		add(contentPane);
		
		final JCheckBox anonymousCheckBox = new JCheckBox("anonymous");
		add(anonymousCheckBox);
		
		
		JPanel buttonsPanel = new JPanel();
		add(buttonsPanel);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetView();
			}
		});
		buttonsPanel.add(cancelButton);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				String content = contentPane.getText();
				boolean isAnonymous = anonymousCheckBox.isSelected();
				controller.createComment(content, isAnonymous);
				
			}
			
		});
		buttonsPanel.add(okButton);
		
		errorLabel = new JLabel("");
		add(errorLabel);
	}
	
	public void resetView(){
		showError("");
		contentPane.setText("");
		
	}
	
	
	public void showError(String error){
		errorLabel.setText(error);
	}
	
	
	public void setController(CreateCommentController controller) {
		this.controller = controller;
	}

}
