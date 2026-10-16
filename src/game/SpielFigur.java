

package game;


import javafx.scene.paint.Color;				// Farbdefinition,		erlaubt Nutzung von Standardfarben sowie RGB-, RGBA- und Hex-Farben für GUI-Elemente
import javafx.scene.shape.Rectangle;			// Grafik-Form,			erstellt 2D-Rechtecke mit anpassbarer Breite, Höhe, Farbe, abgerundete Ecken...

//=========================================================================================================================================

public class SpielFigur {

//=========================================================================================================================================
	
	// Deklaration und Initialisierung vom Rectangle -> SpielFigur:
	//									  X , Y,    breite, höhe
	Rectangle spielFigur = new Rectangle(100, 100,  10,     10);
	// Entfernung in px pro tastendruck -> Schrittlänge:
	double geschwindigkeit = 10;

	// Styling als Konstruktor: ->
	public SpielFigur() {
		spielFigur.setFill(Color.BLUE);
		spielFigur.setStroke(Color.BLACK);		// Rahmen
		spielFigur.setStrokeWidth(3);			// Rahmendicke in px
	}

//=========================================================================================================================================

	// Bewegung der spielFigur:  	
	// spielFigur neue Y-Position = aktuelle Y-Position - geschwindigkeit
	// Kollisionsprüfung im if Block
	public void bewegeHoch(Hinderniss randLinks,
						   Hinderniss randRechts,
						   Hinderniss randOben,
						   Hinderniss randUnten) {
		// bewegen: Y - = nach oben:
		spielFigur.setY(spielFigur.getY() - geschwindigkeit);
		
			// wenn Kollision -> 1 Schritt zurück
			if (pruefeKollision(randLinks, randRechts, randOben, randUnten)) {
				spielFigur.setY(spielFigur.getY() + geschwindigkeit);
			}
	}
	
//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

	public void bewegeRunter(Hinderniss randLinks,
			   				 Hinderniss randRechts,
			   				 Hinderniss randOben,
			   				 Hinderniss randUnten) {
		// Y + = nach unten
		spielFigur.setY(spielFigur.getY() + geschwindigkeit);
		
			// wenn Kollision -> 1 Schritt zurück
			if (pruefeKollision(randLinks, randRechts, randOben, randUnten)) {
				spielFigur.setY(spielFigur.getY() - geschwindigkeit);
			}
	}

//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
	
	public void bewegeLinks(Hinderniss randLinks,
			   				Hinderniss randRechts,
			   				Hinderniss randOben,
			   				Hinderniss randUnten)  {
		// X - = nach links
		spielFigur.setX(spielFigur.getX() - geschwindigkeit);
		
			if (pruefeKollision(randLinks, randRechts, randOben, randUnten)) {
				spielFigur.setX(spielFigur.getX() + geschwindigkeit);
			}
	}

//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
	
	public void bewegeRechts(Hinderniss randLinks,
						     Hinderniss randRechts,
						     Hinderniss randOben,
						     Hinderniss randUnten) {
		// X + = nach rechts
		spielFigur.setX(spielFigur.getX() + geschwindigkeit);
		
			if (pruefeKollision(randLinks, randRechts, randOben, randUnten)) {
				spielFigur.setX(spielFigur.getX() - geschwindigkeit);
			}
	}

//=========================================================================================================================================

	// Kollisionsprüfung -> vergleicht Fläche (Bounds) von spielFigur und hinderniss:
	// intersects() liefert true wenn sich beide Rechtecke überschneiden
	private boolean pruefeKollision(Hinderniss randLinks,
								    Hinderniss randRechts,
								    Hinderniss randOben,
								    Hinderniss randUnten) {
		return spielFigur.getBoundsInParent().intersects(randLinks.getShape().getBoundsInParent())
			|| spielFigur.getBoundsInParent().intersects(randRechts.getShape().getBoundsInParent())
			|| spielFigur.getBoundsInParent().intersects(randOben.getShape().getBoundsInParent())
			|| spielFigur.getBoundsInParent().intersects(randUnten.getShape().getBoundsInParent());
	}
	
//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
	
	// Getter für Spielfigur:
	public Rectangle getShape() {
	    return this.spielFigur;
	}

	
	
}



