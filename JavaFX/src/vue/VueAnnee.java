package vue;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class VueAnnee extends Scene {
	
	public VueAnnee() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleTemperature = new GridPane();
	}
}
