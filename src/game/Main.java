
package game;


import javafx.scene.layout.Pane;				// LayoutFläche, 		BasisLayout zur Positionierung von GUI-Elementen über absolute Koordinaten (X/Y)
import javafx.scene.Scene;						// Scene-Klasse,		für Fensterinhalt
import javafx.scene.layout.VBox;				// VertikalBox,			Ordnet Elemente untereinander an
import javafx.stage.Stage;						// HauptFenster,		eigentliches Anwendungsfenster (Rahmen, minimieren, schließen,...)
import javafx.scene.control.Button;				// Schaltfläche,		klickbares BedienElement für Interaktionen
import javafx.application.Application;			// Basisklasse,			Grundgerüst für JavaFX Anwenudngen
import javafx.geometry.Pos;						// Ausrichtung,			Definiert vertikale + horizontale Positionierung von Elementen (zB. CENTER oder TOP_LEFT)
import javafx.scene.input.KeyCode;				// TastenEingabe,		Enum für physische Tasten zur Erkennung von Tastatureingaben   (zB. ENTER, SPACE)


public class Main extends Application{
	
	@Override
	public void start(Stage stage) {
	// Stage ist das eigentliche Fenster -> Objekt mit Rahmen, minimieren, schließen,...

//=========================================================================================================================================\\

//		______                                       _                   _ _               
//		| ___ \                                     | |                 (_) |            _ 
//		| |_/ / _____  _____ _ __   __   _____  _ __| |__   ___ _ __ ___ _| |_ ___ _ __ (_)
//		| ___ \/ _ \ \/ / _ \ '_ \  \ \ / / _ \| '__| '_ \ / _ \ '__/ _ \ | __/ _ \ '_ \   
//		| |_/ / (_) >  <  __/ | | |  \ V / (_) | |  | |_) |  __/ | |  __/ | ||  __/ | | |_ 
//		\____/ \___/_/\_\___|_| |_|   \_/ \___/|_|  |_.__/ \___|_|  \___|_|\__\___|_| |_(_)
		                                                                                   
//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

	// HauptContainer: -> hier wird die komplette Nutzeroberfläche geregelt 
	Pane hauptContainer = new Pane();
	// Scene ist der Inhalt, der innerhalb der Stage angezeigt wird
	Scene scene = new Scene(hauptContainer, 1280, 760);

//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

	// HauotMenü -> Menüauswahl erstellen:
	// VertikalBox:			  (20) -> Abstand zwischen den Buttons
	VBox hauptMenue = new VBox(20);
	hauptMenue.setPrefSize(1280, 760);
	hauptMenue.setAlignment(Pos.CENTER);
	hauptMenue.setStyle("-fx-border-color: black; " +
									  "-fx-border-width: 2; " 	+
									  "-fx-background-color: green;"
									  );

	// MenüPunkte erstellen:
	Button startBtn  = new Button("Spiel starten");
	Button optionBtn = new Button("Optionen");
	Button exitBtn   = new Button("Beenden");

	// Button Größe:
	startBtn.setPrefWidth(200);
	startBtn.setPrefHeight(20);

	optionBtn.setPrefWidth(200);
	optionBtn.setPrefHeight(20);

	exitBtn.setPrefWidth(200);
	exitBtn.setPrefHeight(20);

	// Buttons dem Hauptmenü (VertikalBox) hinzufügen:
	hauptMenue.getChildren().addAll(startBtn, optionBtn, exitBtn);

//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

	// das eigentliche Spiel"fenster" erstellen:
	Pane spielFenster = new Pane();
	spielFenster.setPrefSize(1280, 760);
	spielFenster.setVisible(false);
	spielFenster.setStyle("-fx-border-color: black; " +
			  "-fx-border-width: 2; " 	+
			  "-fx-background-color: lightblue;"
			  );

//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

	// OptionsFenster erstellen:
	// VertikalBox:				  (20) -> Abstand zwischen den Buttons
	VBox optionsFenster = new VBox(20);
	optionsFenster.setPrefSize(800, 600);
	optionsFenster.setAlignment(Pos.CENTER);
	optionsFenster.setVisible(false);
	optionsFenster.setStyle("-fx-border-color: black; " +
		    				"-fx-border-width: 2; " 	+
		    				"-fx-background-color: lightgray;"
							);
	
	// Position so berechnet, dass die 800x600 Box mittig im 1280x760 hauptContainer sitzt:
	optionsFenster.setLayoutX((1280 - 800) / 2.0);
	optionsFenster.setLayoutY((760 - 600) / 2.0);

	// OptionsMenüPunkte erstellen:
	Button optionsMenuePunkt1 = new Button("Option 1");
	Button optionsMenuePunkt2 = new Button("Option 2");
	Button optionsMenuePunkt3 = new Button("Option 3");
	Button optionsMenuePunkt4 = new Button("Option 4");

	// Button Größe:
	optionsMenuePunkt1.setPrefWidth(200);
	optionsMenuePunkt1.setPrefHeight(20);

	optionsMenuePunkt2.setPrefWidth(200);
	optionsMenuePunkt2.setPrefHeight(20);

	optionsMenuePunkt3.setPrefWidth(200);
	optionsMenuePunkt3.setPrefHeight(20);

	optionsMenuePunkt4.setPrefWidth(200);
	optionsMenuePunkt4.setPrefHeight(20);

	// Buttons der VertikalBox hinzufügen:
	optionsFenster.getChildren().addAll(optionsMenuePunkt1, optionsMenuePunkt2, optionsMenuePunkt3, optionsMenuePunkt4);

//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

	// MenüFenster wenn im Game Escape gedrückt wird:
	VBox pauseMenue = new VBox(20);
	pauseMenue.setPrefSize(800, 600);
	pauseMenue.setAlignment(Pos.CENTER);
	pauseMenue.setVisible(false);
	pauseMenue.setStyle("-fx-border-color: black; " +
		    				   "-fx-border-width: 2; " 	+
		    				   "-fx-background-color: gray;"
	);
	
	// Position so berechnet, dass die 800x600 Box mittig im 1280x760 hauptContainer sitzt:
	pauseMenue.setLayoutX((1280 - 800) / 2.0);
	pauseMenue.setLayoutY((760 - 600) / 2.0);
	
	
	// MenüPunkte erstellen:
	Button spielOptionsMenuePunkt1 = new Button ("Fortsetzen");
	Button spielOptionsMenuePunkt2 = new Button ("Hauptmenü");
	Button spielOptionsMenuePunkt3 = new Button ("Optionen");
	Button spielOptionsMenuePunkt4 = new Button ("Beenden");
	
	// Button Größe:
	spielOptionsMenuePunkt1.setPrefWidth(200);
	spielOptionsMenuePunkt1.setPrefHeight(20);

	spielOptionsMenuePunkt2.setPrefWidth(200);
	spielOptionsMenuePunkt2.setPrefHeight(20);

	spielOptionsMenuePunkt3.setPrefWidth(200);
	spielOptionsMenuePunkt3.setPrefHeight(20);

	spielOptionsMenuePunkt4.setPrefWidth(200);
	spielOptionsMenuePunkt4.setPrefHeight(20);
	
	// Buttons dem pauseMenue hinzufügen
	pauseMenue.getChildren().addAll(spielOptionsMenuePunkt1, spielOptionsMenuePunkt2, spielOptionsMenuePunkt3, spielOptionsMenuePunkt4);
	
	
//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

	// alle Fenster/Boxen dem hauptContainer übergeben:
	hauptContainer.getChildren().addAll(
		hauptMenue, 
		spielFenster, 
		optionsFenster,
		pauseMenue
	);

//=========================================================================================================================================
		
//	  _____         _        _              _____ _                   _            
//	 |_   _|       | |      | |            |  ___(_)                 | |         _ 
//	   | | __ _ ___| |_ __ _| |_ _   _ _ __| |__  _ _ __   __ _  __ _| |__   ___(_)
//	   | |/ _` / __| __/ _` | __| | | | '__|  __|| | '_ \ / _` |/ _` | '_ \ / _ \  
//	   | | (_| \__ \ || (_| | |_| |_| | |  | |___| | | | | (_| | (_| | |_) |  __/_ 
//	   \_/\__,_|___/\__\__,_|\__|\__,_|_|  \____/|_|_| |_|\__, |\__,_|_.__/ \___(_)
//	                                                       __/ |                   
//	                                                      |___/                    
	
//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -	
	
	// Tastatureingabe auf Scene-Ebene, weil VBox/Pane selbst keinen Fokus bekommen können:
	// -> nur einmalig registriert, nicht innerhalb eines Button-Handlers
	// Lambda + Keycode 
	
	// Escape Taste:
	scene.setOnKeyPressed(tastenDruckEscape -> {
		if (tastenDruckEscape.getCode() == KeyCode.ESCAPE) {
			
			// OptionsFenster:
	        if (optionsFenster.isVisible()) {
	    
	            // Optionen schließen:
	            optionsFenster.setVisible(false);
	            
	            // zurück ins Pause-Menü:
	            if (spielFenster.isVisible()) {
	                pauseMenue.setVisible(true); 
	                
	            // zurück ins Hauptmenü:
	            } else {
	                hauptMenue.setVisible(true);
	            }
				
	        // PauseMenü schließen -> zurück ins Spiel:
	        } else if (spielFenster.isVisible() && pauseMenue.isVisible()) {
	            pauseMenue.setVisible(false);

	        // Pause-Menü öffnen:
	        } else if (spielFenster.isVisible()) {
	            pauseMenue.setVisible(true);
	        }
	    }
	});

	
	
//=========================================================================================================================================	

//	______       _   _                    _   ___ _      _                                   _          _ _               
//	| ___ \     | | | |                  | | / / (_)    | |                                 | |        (_) |            _ 
//	| |_/ /_   _| |_| |_ ___  _ __ ______| |/ /| |_  ___| | _____  __   _____ _ __ __ _ _ __| |__   ___ _| |_ ___ _ __ (_)
//	| ___ \ | | | __| __/ _ \| '_ \______|    \| | |/ __| |/ / __| \ \ / / _ \ '__/ _` | '__| '_ \ / _ \ | __/ _ \ '_ \   
//	| |_/ / |_| | |_| || (_) | | | |     | |\  \ | | (__|   <\__ \  \ V /  __/ | | (_| | |  | |_) |  __/ | ||  __/ | | |_ 
//	\____/ \__,_|\__|\__\___/|_| |_|     \_| \_/_|_|\___|_|\_\___/   \_/ \___|_|  \__,_|_|  |_.__/ \___|_|\__\___|_| |_(_)
	                                                                                                                      

	
// ============================================================== \\
// ================== startMenueAuswahlFenster ================== \\
// ============================================================== \\
	
	// Spiel starten:
	startBtn.setOnAction(ereignisStarMenueStartSpiel -> {
		hauptMenue.setVisible(false);
		spielFenster.setVisible(true);
	});
	
	// Optionen:
	optionBtn.setOnAction(ereignisStartMenueOption -> {
		optionsFenster.setVisible(true);
		optionsMenuePunkt1.requestFocus();
	});
	
	// Beenden:
	exitBtn.setOnAction(ereignisSpielBeenden -> {
		System.exit(0);
	});

//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

// ============================================================== \\
// ======================= optionsFenster ======================= \\
// ============================================================== \\
		
	// Option 1:
//	spielOptionsMenuePunkt1.setOnAction();
	
	// Option 2:
//	spielOptionsMenuePunkt2.setOnAction();
	
	// Option 3:
//	spielOptionsMenuePunkt3.setOnAction();
	
	// Option 4:
//	spielOptionsMenuePunkt4.setOnAction();

//-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
	
// ================================================================= \\
// ======================= spielMenueFenster ======================= \\
// ================================================================= \\
		
	// Fortsetzen:
	spielOptionsMenuePunkt1.setOnAction(zurueckZumSpiel -> {
		pauseMenue.setVisible(false);
	});
	
	// Hauptmenü:
	spielOptionsMenuePunkt2.setOnAction(zurueckZumHauptmenue -> {
		spielFenster.setVisible(false);
		pauseMenue.setVisible(false);
		hauptMenue.setVisible(true);
	});
	
	// Optionen:
	spielOptionsMenuePunkt3.setOnAction(optionenAnzeigen -> {
	    pauseMenue.setVisible(false);
		optionsFenster.setVisible(true);
	});
	
	// Programm beenden:
	spielOptionsMenuePunkt4.setOnAction(ereignisSpielBeenden ->{
		System.exit(0);
	});


//=========================================================================================================================================
	
	stage.setScene(scene);
	stage.setTitle("Spiel");
	stage.show();
	
	}

//=========================================================================================================================================
	
    public static void main(String[] args) {
        launch(args);
	
	}

}
