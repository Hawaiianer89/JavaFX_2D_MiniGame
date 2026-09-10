

package game;


import javafx.scene.Scene;						// Scene-Klasse,		für Fensterinhalt
import javafx.scene.input.KeyCode;				// TastenEingabe,		Enum für physische Tasten zur Erkennung von Tastatureingaben   (zB. ENTER, SPACE)
import javafx.scene.layout.Pane;				// LayoutFläche, 		BasisLayout zur Positionierung von GUI-Elementen über absolute Koordinaten (X/Y)
import javafx.scene.layout.VBox;				// VertikalBox,			Ordnet Elemente untereinander an

//=========================================================================================================================================

public class Steuerung {

	// Konstruktor -> bekommt alles, was für Bewegung + Menü-Logik gebraucht wird:
	public Steuerung(
		Scene scene, 
		SpielFigur hauptProtagonist, 
		VBox hauptMenue, 
		Pane spielFenster, 
		VBox optionsFenster, 
		VBox pauseMenue,
		Hinderniss hindernis
	){

//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
		
		// ein setOnKeyPressed-Aufruf für ALLES (Bewegung + Escape)
		//     setOnKeyPressed = Setter
		scene.setOnKeyPressed(tastenDruck -> {

			// Bewegung der Spielfigur WASD:
			// erkennt welche Taste gedrückt wird (KeyCode):
			if (tastenDruck.getCode() == KeyCode.W) {
				hauptProtagonist.bewegeHoch(hindernis);

			} else if (tastenDruck.getCode() == KeyCode.S) {
				hauptProtagonist.bewegeRunter(hindernis);

			} else if (tastenDruck.getCode() == KeyCode.A) {
				hauptProtagonist.bewegeLinks(hindernis);

			} else if (tastenDruck.getCode() == KeyCode.D) {
				hauptProtagonist.bewegeRechts(hindernis);
			}

//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
			
			// Escape-Taste -> Menü-Logik:
			if (tastenDruck.getCode() == KeyCode.ESCAPE) {

				// 1: Wenn OptionsFenster offen -> OptionsFenster schließen:
				if (optionsFenster.isVisible()) {
					optionsFenster.setVisible(false);

					// Wenn OptionsFenster im PauseMenü offen -> schließen -> zurück zum PauseMenü:
					if (spielFenster.isVisible()) {
						pauseMenue.setVisible(true);

					// Wenn OptionsFenster im Hauptmenü geöffnet -> zurück ins Hauptmenü:
					} else {
						hauptMenue.setVisible(true);
					}

				// 2. Wenn PauseMenü offen -> PauseMenü schließen -> zurück ins Spiel:
				} else if (spielFenster.isVisible() && pauseMenue.isVisible()) {
					pauseMenue.setVisible(false);

				// 3. Wenn im Spiel -> PauseMenü noch zu -> Menü frisch öffnen:
				} else if (spielFenster.isVisible()) {
					pauseMenue.setVisible(true);
				}
			}
		});
	}
}




