

package game;


import javafx.scene.paint.Color;				// Farbdefinition,		erlaubt Nutzung von Standardfarben sowie RGB-, RGBA- und Hex-Farben für GUI-Elemente
import javafx.scene.shape.Rectangle;			// Grafik-Form,			erstellt 2D-Rechtecke mit anpassbarer Breite, Höhe, Farbe, abgerundete Ecken...

//=========================================================================================================================================

public class SpielFigur {

//=========================================================================================================================================
	
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
	// Kollisionsprüfung im if Block
	public void bewegeHoch(Hinderniss wand) {
		// bewegen: Y - = nach oben:
		spielFigur.setY(spielFigur.getY() - geschwindigkeit);
		
			// wenn Kollision -> 1 Schritt zurück
			if (pruefeKollision(wand)) {
				spielFigur.setY(spielFigur.getY() + geschwindigkeit);
			}
	}
	
//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

	public void bewegeRunter(Hinderniss hindernis) {
		// Y + = nach unten
		spielFigur.setY(spielFigur.getY() + geschwindigkeit);
		
			// wenn Kollision -> 1 Schritt zurück
			if (pruefeKollision(hindernis)) {
				spielFigur.setY(spielFigur.getY() - geschwindigkeit);
			}
	}

//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
	
	public void bewegeLinks(Hinderniss wand) {
		// X - = nach links
		spielFigur.setX(spielFigur.getX() - geschwindigkeit);
		
			if (pruefeKollision(wand)) {
				spielFigur.setX(spielFigur.getX() + geschwindigkeit);
			}
	}

//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
	
	public void bewegeRechts(Hinderniss wand) {
		// X + = nach rechts
		spielFigur.setX(spielFigur.getX() + geschwindigkeit);
		
			if (pruefeKollision(wand)) {
				spielFigur.setX(spielFigur.getX() - geschwindigkeit);
			}
	}

//=========================================================================================================================================

	// Kollisionsprüfung -> vergleicht Fläche (Bounds) von spielFigur und hinderniss:
	// intersects() liefert true wenn sich beide Rechtecke überschneiden
	private boolean pruefeKollision(Hinderniss wand) {
		return spielFigur.getBoundsInParent().intersects(wand.getShape().getBoundsInParent());
	}
	
//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
	
	// Getter für Spielfigur:
	public Rectangle getShape() {
	    return this.spielFigur;
	}

	
	
}



