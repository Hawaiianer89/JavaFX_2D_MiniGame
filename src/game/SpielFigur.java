

package game;

import javafx.scene.paint.Color;				// Farbdefinition,		erlaubt Nutzung von Standardfarben sowie RGB-, RGBA- und Hex-Farben für GUI-Elemente
import javafx.scene.shape.Rectangle;			// Grafik-Form,			erstellt 2D-Rechtecke mit anpassbarer Breite, Höhe, Farbe, abgerundete Ecken...

//=========================================================================================================================================

public class SpielFigur {

	// Deklaration und Initialisierung vom Rectangle -> SpielFigur:
	//									  X , Y,  breite, höhe
	Rectangle spielFigur = new Rectangle(10, 10,  10,     10);
	// Entfernung in px pro tastendruck -> Schrittlänge:
	double geschwindigkeit = 5;

	// Styling als Konstruktor: ->
	public SpielFigur() {
		spielFigur.setFill(Color.BLUE);
		spielFigur.setStroke(Color.BLACK);		// Rahmen
		spielFigur.setStrokeWidth(3);			// Rahmendicke in px

		spielFigur.setX(10);
		spielFigur.setY(10);
	}

//=========================================================================================================================================

	// Bewegung der spielFigur:  	
	// spielFigur neue Y-Position = aktuelle Y-Position - geschwindigkeit
	public void bewegeHoch() {
		spielFigur.setY(spielFigur.getY() - geschwindigkeit);
	}

	public void bewegeRunter() {
		spielFigur.setY(spielFigur.getY() + geschwindigkeit);
	}

	public void bewegeLinks() {
		spielFigur.setX(spielFigur.getX() - geschwindigkeit);
	}

	public void bewegeRechts() {
		spielFigur.setX(spielFigur.getX() + geschwindigkeit);
	}

//=========================================================================================================================================

}
