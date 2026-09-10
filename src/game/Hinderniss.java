

package game;


import javafx.scene.shape.Rectangle;			// Grafik-Form,			erstellt 2D-Rechtecke mit anpassbarer Breite, Höhe, Farbe, abgerundete Ecken...
import javafx.scene.paint.Color;				// Farbdefinition,		erlaubt Nutzung von Standardfarben sowie RGB-, RGBA- und Hex-Farben für GUI-Elemente



//=========================================================================================================================================

public class Hinderniss {

//=========================================================================================================================================

	
	Rectangle hinderniss;
	
	// Konstruktor für Hindernisse:
	public Hinderniss(
			double positionImRaumX,
			double positionImRaumY,
			double breite,
			double hoehe,
			Color farbe) {
				
		hinderniss = new Rectangle(positionImRaumX, positionImRaumY, breite, hoehe);
		hinderniss.setFill(farbe);
		hinderniss.setStroke(Color.BLACK);		// Rahmen
		hinderniss.setStrokeWidth(3);
			}
	
//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
	
	// Kollisionsprüfung:
	// Getter-Methode, um das Rechteck für die Kollisionsprüfung bereitzustellen
	public Rectangle getShape() {
	    return this.hinderniss;
	}
	
//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
	
}



