package io.robusta.fora.swing;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.annotations.Controller;
import io.robusta.fora.domain.Flag;
import io.robusta.fora.domain.Subject;

import javax.swing.JOptionPane;

@Controller
public class FlagController {

	Flag model;
	FlagView view;
	EditableFlagController editableFlagController;

	public FlagController(Flag model, FlagView view) {
		this.model = model;
		this.view = view;
	}

	public void del() {
		String[] listeChoix = { "Flag", "Commentaire" };
		int choix = JOptionPane.showOptionDialog(null,
				"Que souhaitez-vous supprimer ?", "Confirmation",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, listeChoix, listeChoix[0]);

		if (choix >= 0) {
			ForaDataSource
					.getInstance()
					.getFlags()
					.remove(ForaDataSource.getInstance().getFlags()
							.indexOf(model));
			model.getComment().getFlags()
					.remove(model.getComment().getFlags().indexOf(model));
			editableFlagController.updateView();
		}
		if (choix == 1) {
			ForaDataSource
					.getInstance()
					.getComments()
					.remove(ForaDataSource.getInstance().getComments()
							.indexOf(model.getComment()));
			for (Subject s : ForaDataSource.getInstance().getSubjects()) {
				if (s.getComments().indexOf(model.getComment()) >= 0) {
					s.getComments().remove(
							s.getComments().indexOf(model.getComment()));
				}
			}
		}

	}

	public void setEditableFlagController(EditableFlagController Controller) {
		this.editableFlagController = Controller;
	}

}
