package io.robusta.fora.swing;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.annotations.View;
import io.robusta.fora.domain.Flag;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@View
public class EditableFlagView extends JPanel {

	List<Flag>model ;
	EditableFlagController editableFlagController;

	public EditableFlagController getEditableFlagController() {
		return editableFlagController;
	}

	public void setEditableFlagController(
			EditableFlagController editableFlagController) {
		this.editableFlagController = editableFlagController;
	}

	public List<Flag> getModel() {
		return model;
	}

	public EditableFlagView() {
		super();
		this.model=ForaDataSource.getInstance().getFlags();
		initView();
	}

	JLabel numberLabel;
	JPanel flagsPanel;
	
	private void initView() {

		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));


		numberLabel = new JLabel(this.model.size()+ " flags");
		panel.add(numberLabel, BorderLayout.EAST);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(700,600));
		add(scrollPane, BorderLayout.CENTER);

		flagsPanel = new JPanel();
		scrollPane.setViewportView(flagsPanel);
		flagsPanel.setLayout(new BoxLayout(flagsPanel, BoxLayout.Y_AXIS));

		// affichage des flags
		for (Flag flag : model) {
			FlagView flagView = createFlagView(flag);
			flagsPanel.add(flagView);
		}

	}


	public void updateView() {
		flagsPanel.removeAll();
		this.model=ForaDataSource.getInstance().getFlags();
		// affichage des flags
		for (Flag flag : model) {
			FlagView flagView = createFlagView(flag);
			flagsPanel.add(flagView);
		}
		flagsPanel.validate();
		updateNumberLabel();

	}

	private FlagView createFlagView(Flag flag) {

		FlagView flagView = new FlagView(flag);
		FlagController controller = new FlagController(flag,
				flagView);
		controller.setEditableFlagController(editableFlagController);
		flagView.setController(controller);
		return flagView;
	}

	
	void updateNumberLabel(){
		numberLabel.setText(this.model.size()+ " flags");
	}
	

}
