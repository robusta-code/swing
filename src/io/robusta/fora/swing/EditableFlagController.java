package io.robusta.fora.swing;

import java.util.List;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.annotations.Controller;
import io.robusta.fora.domain.Comment;
import io.robusta.fora.domain.Flag;
import io.robusta.fora.domain.Subject;

@Controller
public class EditableFlagController {


	EditableFlagView view;
	List<Flag>model ;
	
	
	public EditableFlagController(EditableFlagView view, List<Flag> model) {
		this.view = view;
		this.model = model;
	}
	
	
	public void updateView(){
		this.view.updateView();
	}
}
