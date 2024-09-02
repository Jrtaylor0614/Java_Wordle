package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.util.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SampleController extends Main{
	
	private boolean debugMode = true;
	statsCollection sc = statsCollection.getInstance();
	private double test = 0.2;
	public boolean continuegamecheck;
	private int currentStreak = 0;
	private int maxStreak;
	private int percentage = 0;
	private int winTracker;
	private int gamesPlayed = 0;
	private int attemptsLeft = 6;
	private int index = 0;
	private int a1 ;
	private int a2 ;
	private int a3;
	private int a4;
	private int a5;
	private int a6;	
	
	private String answer = " ";
	private String answerr = "Answer: ";
	private String letter;
	private String endgamechecker = "";

	@FXML
	private TextField playersInput;
	
	@FXML
	private Label ww;
	@FXML
	private Label wordammount = new Label() ;
	@FXML
	private Label resetted = new Label();
	@FXML
	private Label saved = new Label();
	@FXML
	private Label loaded = new Label();
	
	@FXML
	private Label box01 = new Label();
	@FXML
	private Label box02 = new Label();
	@FXML
	private Label box03 = new Label();
	@FXML
	private Label box04 = new Label();
	@FXML
	private Label box05 = new Label();
	@FXML 
	private Label box06 = new Label();
	@FXML 
	private Label box07 = new Label();
	@FXML 
	private Label box08 = new Label();
	@FXML 
	private Label box09 = new Label();
	@FXML 
	private Label box10 = new Label();
	@FXML private Label box11 = new Label();
	@FXML private Label box12 = new Label();
	@FXML private Label box13 = new Label();
	@FXML private Label box14 = new Label();
	@FXML private Label box15 = new Label();
	@FXML private Label box16 = new Label();
	@FXML private Label box17 = new Label();
	@FXML private Label box18 = new Label();
	@FXML private Label box19 = new Label();
	@FXML private Label box20 = new Label();
	@FXML private Label box21 = new Label();
	@FXML private Label box22 = new Label();
	@FXML private Label box23 = new Label();
	@FXML private Label box24 = new Label();
	@FXML private Label box25 = new Label();
	@FXML private Label box26 = new Label();
	@FXML private Label box27 = new Label();
	@FXML private Label box28 = new Label();
	@FXML private Label box29 = new Label();
	@FXML private Label box30 = new Label();
	@FXML private Button a;
	@FXML private Button b;
	@FXML private Button c;
	@FXML private Button e;
	@FXML private Button d;
	@FXML private Button f;
	@FXML private Button g;
	@FXML private Button h;
	@FXML private Button i;
	@FXML private Button j;
	@FXML private Button k;
	@FXML private Button l;
	@FXML private Button m;
	@FXML private Button n;
	@FXML private Button o;
	@FXML private Button p;
	@FXML private Button q;
	@FXML private Button r;
	@FXML private Button s;
	@FXML private Button t;
	@FXML private Button u;
	@FXML private Button v;
	@FXML private Button w;
	@FXML private Button x;
	@FXML private Button y;
	@FXML private Button z;
	@FXML private Label percent = new Label();
	
	private String he = "aback";
	@FXML
	private AnchorPane ap;
	
	
	private void loadResultsScene() throws IOException {

		
		sc.setAnswer(answerr + answer);
		
		sc.setPercent(percentage);
		if(currentStreak > maxStreak) {
			maxStreak = currentStreak;
			sc.setMax(maxStreak);
		} else {
			maxStreak = sc.getMax();
			sc.setMax(maxStreak);
		}
		

		Stage stage = (Stage) ap.getScene().getWindow();


        Parent root = FXMLLoader.load(getClass().getResource("Results.fxml"));

        Scene scene = new Scene(root);


        stage.setScene(scene);
    }
	
	
	@FXML
	public void endGame(ActionEvent event) throws IOException {

		sc.setAnswer(answerr);
		sc.getCurrent();
		sc.getPlayed();
		sc.getMax();
		sc.getPercent();
		Stage stage = (Stage) ap.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Results.fxml"));

        Scene scene = new Scene(root);


        stage.setScene(scene);
	}
	

	
	@FXML
	protected void checkplayersGuess() throws Exception {
		if(sc.getCurrent() > 0) {
			currentStreak = 1 + sc.getCurrent();
			gamesPlayed = 1 + sc.getCurrent();
			if(sc.getWin() > 0) {
				test = ((double)winTracker/sc.getCurrent()) * 100;
				percentage = (int)test;
			}
		}
		
		if(answer.isBlank() == true) {
//			getnewWord();
			answer = setnewWord();
//			he = answer;
		}
		
		if(debugMode == true) {
			ww.setText(he);
		}

			if(attemptsLeft == 6) {
				String guess = "";
				endgamechecker = "";
				Label[] set01 = {box01,box02,box03,box04,box05};
				for (int k = 0; k < 5; k++) {
					 guess += set01[k].getText().toLowerCase();
					 endgamechecker += set01[k].getText().toLowerCase();
				}
				
				if(guess.length() == 5) {
					for(int i = 0; i < guess.length(); i++) {
						String guessedletter = guess.substring(i,i+1);
						if(guessedletter.equals(he.substring(i, i+1))) {
							set01[i].setStyle("-fx-background-color: green ;-fx-border-color: black");
							if(guess.equals(he)) {
								disableLetter(guessedletter);
								//call end game
							}
						} else if(he.indexOf(guessedletter) > -1) {
							set01[i].setStyle("-fx-background-color: yellow ;-fx-border-color: black");
	
						} else {
							set01[i].setStyle("-fx-background-color: white ;-fx-border-color: black");
							disableLetter(guessedletter);
						}
					
					}
					decreaseAttempts();
					resetIndex();
					if(endgamechecker.equals(he)) {
						a1++;
						sc.setAttempts1(a1);
						if(sc.getCurrent() == 0) {
							currentStreak++;
							gamesPlayed++;
							winTracker+= 1;
							sc.setWin(winTracker);
							sc.setPlayed(gamesPlayed);
							sc.setCurrent(currentStreak);
							percentage = (winTracker/gamesPlayed) * 100;
							loadResultsScene();
						}
						if(sc.getCurrent() > 0) {
							winTracker+= 1;
							sc.setWin(winTracker);
							sc.setPlayed(gamesPlayed);
							sc.setCurrent(currentStreak);
							loadResultsScene();
						}
					}
				} else if(guess.length() < 5) {
					wordammount.setText("Not Enough letters");
				} else {
					wordammount.setText("Too many letters");
				}
			} else if (attemptsLeft == 5) {
				String guess = "";
				endgamechecker = "";
				Label[] set02 = {box06,box07,box08,box09,box10};
				for (int k = 0; k < 5; k++) {
					 guess += set02[k].getText().toLowerCase();
					 endgamechecker += set02[k].getText().toLowerCase();
				}
				if(guess.length() == 5) {
					for(int i = 0; i < guess.length(); i++) {
						String guessedletter = guess.substring(i,i+1);
						if(guessedletter.equals(he.substring(i, i+1))) {
							set02[i].setStyle("-fx-background-color: green ;-fx-border-color: black");
							if(guess.equals(he)) {
								disableLetter(guessedletter);

							}
						} else if(he.indexOf(guessedletter) > -1) {
							set02[i].setStyle("-fx-background-color: yellow;-fx-border-color: black");
	
						} else {
							set02[i].setStyle("-fx-background-color: white;-fx-border-color: black");
							disableLetter(guessedletter);
						}
					}
					decreaseAttempts();
					resetIndex();
					if(endgamechecker.equals(he)) {
						a2++;
						sc.setAttempts2(a2);
						if(sc.getCurrent() == 0) {
							currentStreak++;
							gamesPlayed++;
							winTracker+= 1;
							sc.setWin(winTracker);
							sc.setPlayed(gamesPlayed);
							sc.setCurrent(currentStreak);
							percentage = (winTracker/gamesPlayed) * 100;
							loadResultsScene();
						}
						if(sc.getCurrent() > 0) {
							winTracker+= 1;
							sc.setWin(winTracker);
							sc.setPlayed(gamesPlayed);
							sc.setCurrent(currentStreak);
							loadResultsScene();
						}
					}
				} else if(guess.length() < 5) {
					wordammount.setText("Not Enough letters");
				} else {
					wordammount.setText("Too many letters");
				}
			} else if (attemptsLeft == 4) {
				String guess = "";
				endgamechecker = "";
				Label[] set03 = {box11,box12,box13,box14,box15};
				for (int k = 0; k < 5; k++) {
					 guess += set03[k].getText().toLowerCase();
					 endgamechecker += set03[k].getText().toLowerCase();
				}
				if(guess.length() == 5) {
					for(int i = 0; i < guess.length(); i++) {
						String guessedletter = guess.substring(i,i+1);
						if(guessedletter.equals(he.substring(i, i+1))) {
							set03[i].setStyle("-fx-background-color: green;-fx-border-color: black");
							if(guess.equals(he)) {
								disableLetter(guessedletter);
								//call end game
							}
						} else if(answer.indexOf(guessedletter) > -1) {
							set03[i].setStyle("-fx-background-color: yellow;-fx-border-color: black");
	
						} else {
							set03[i].setStyle("-fx-background-color: white;-fx-border-color: black");
							disableLetter(guessedletter);
						}
					}
					decreaseAttempts();
					resetIndex();
					if(endgamechecker.equals(he)) {
						a3++;
						sc.setAttempts3(a3);
						if(sc.getCurrent() == 0) {
							currentStreak++;
							gamesPlayed++;
							winTracker+= 1;
							sc.setWin(winTracker);
							sc.setPlayed(gamesPlayed);
							sc.setCurrent(currentStreak);
							percentage = (winTracker/gamesPlayed) * 100;
							loadResultsScene();
						}
						if(sc.getCurrent() > 0) {
							winTracker+= 1;
							sc.setWin(winTracker);
							sc.setPlayed(gamesPlayed);
							sc.setCurrent(currentStreak);
							loadResultsScene();
						}
					}
				} else if(guess.length() < 5) {
					wordammount.setText("Not Enough letters");
				} else {
					wordammount.setText("Too many letters");
				}
			} else if (attemptsLeft == 3) {
				String guess = "";
				endgamechecker = "";
				Label[] set04 = {box16,box17,box18,box19,box20};
				for (int k = 0; k < 5; k++) {
					 guess += set04[k].getText().toLowerCase();
					 endgamechecker += set04[k].getText().toLowerCase();
				}
				if(guess.length() == 5) {
					for(int i = 0; i < guess.length(); i++) {
						String guessedletter = guess.substring(i,i+1);
						if(guessedletter.equals(he.substring(i, i+1))) {
							set04[i].setStyle("-fx-background-color: green;-fx-border-color: black");
							if(guess.equals(he)) {
								disableLetter(guessedletter);
								//call end game
							}
						} else if(answer.indexOf(guessedletter) > -1) {
							set04[i].setStyle("-fx-background-color: yellow;-fx-border-color: black");
	
						} else {
							set04[i].setStyle("-fx-background-color: white;-fx-border-color: black");
							disableLetter(guessedletter);
						}
					}
					decreaseAttempts();
					resetIndex();
					if(endgamechecker.equals(he)) {
						a4++;
						sc.setAttempts4(a4);
						if(sc.getCurrent() == 0) {
							currentStreak++;
							gamesPlayed++;
							winTracker+= 1;
							sc.setWin(winTracker);
							sc.setPlayed(gamesPlayed);
							sc.setCurrent(currentStreak);
							percentage = (winTracker/gamesPlayed) * 100;
							loadResultsScene();
						}
						if(sc.getCurrent() > 0) {
							winTracker+= 1;
							sc.setWin(winTracker);
							sc.setPlayed(gamesPlayed);
							sc.setCurrent(currentStreak);
							loadResultsScene();
						}
					}
				} else if(guess.length() < 5) {
					wordammount.setText("Not Enough letters");
				} else {
					wordammount.setText("Too many letters");
				}
			} else if (attemptsLeft == 2) {
				String guess = "";
				endgamechecker = "";
				Label[] set05 = {box21,box22,box23,box24,box25};
				for (int k = 0; k < 5; k++) {
					 guess += set05[k].getText().toLowerCase();
					 endgamechecker += set05[k].getText().toLowerCase();
				}
				if(guess.length() == 5) {
					for(int i = 0; i < guess.length(); i++) {
						String guessedletter = guess.substring(i,i+1);
						if(guessedletter.equals(he.substring(i, i+1))) {
							set05[i].setStyle("-fx-background-color: green;-fx-border-color: black");
							if(guess.equals(he)) {
								disableLetter(guessedletter);
							}
						} else if(he.indexOf(guessedletter) > -1) {
							set05[i].setStyle("-fx-background-color: yellow;-fx-border-color: black");
	
						} else {
							set05[i].setStyle("-fx-background-color: white;-fx-border-color: black");
							disableLetter(guessedletter);
						}
					}
					decreaseAttempts();
					resetIndex();
					if(endgamechecker.equals(he)) {
						a5++;
						sc.setAttempts5(a5);
						if(sc.getCurrent() == 0) {
							currentStreak++;
							gamesPlayed++;
							winTracker+= 1;
							sc.setWin(winTracker);
							sc.setPlayed(gamesPlayed);
							sc.setCurrent(currentStreak);
							percentage = (winTracker/gamesPlayed) * 100;
							loadResultsScene();
						}
						if(sc.getCurrent() > 0) {
							winTracker+= 1;
							sc.setWin(winTracker);
							sc.setPlayed(gamesPlayed);
							sc.setCurrent(currentStreak);
							loadResultsScene();
						}
					}
				} else if(guess.length() < 5) {
					wordammount.setText("Not Enough letters");
				} else {
					wordammount.setText("Too many letters");
				}
			} else if (attemptsLeft == 1) {
				String guess = "";
				endgamechecker = "";
				Label[] set06 = {box26,box27,box28,box29,box30};
				for (int k = 0; k < 5; k++) {
					 guess += set06[k].getText().toLowerCase();
					 endgamechecker += set06[k].getText().toLowerCase();
				}
				if(guess.length() == 5) {
					for(int i = 0; i < guess.length(); i++) {
						String guessedletter = guess.substring(i,i+1);
						if(guessedletter.equals(he.substring(i, i+1))) {
							set06[i].setStyle("-fx-background-color: green;-fx-border-color: black");
							if(guess.equals(answer)) {
								disableLetter(guessedletter);
								//call end game
							}
						} else if(answer.indexOf(guessedletter) > -1) {
							set06[i].setStyle("-fx-background-color: yellow;-fx-border-color: black");
	
						} else {
							set06[i].setStyle("-fx-background-color: white;-fx-border-color: black");
							disableLetter(guessedletter);
						}
					}
					decreaseAttempts();
					resetIndex();
					if(endgamechecker.equals(he)) {
						if(sc.getCurrent() == 0) {
							a6++;
							sc.setAttempts1(a6);
							currentStreak++;
							gamesPlayed++;
							winTracker+= 1;
							sc.setWin(winTracker);
							sc.setPlayed(gamesPlayed);
							sc.setCurrent(currentStreak);
							percentage = (winTracker/gamesPlayed) * 100;
							loadResultsScene();
						}
						if(sc.getCurrent() > 0) {
							a6++;
							sc.setAttempts1(a6);
							winTracker+= 1;
							sc.setWin(winTracker);
							sc.setPlayed(gamesPlayed);
							sc.setCurrent(currentStreak);
//							percentage = (winTracker/gamesPlayed) * 100;
							loadResultsScene();
						}
					} else {
						currentStreak = 0;
						sc.setPlayed(gamesPlayed);
						sc.setCurrent(currentStreak);
						percentage = (winTracker/gamesPlayed) * 100;
						sc.setPercent(percentage);
						loadResultsScene();
					}
				} else if(guess.length() < 5) {
					wordammount.setText("Not Enough letters");
				} else {
					wordammount.setText("Too many letters");
				}
			} 
	}

	

	
	private void disableLetter(String letters) {
		if(letters.equals("a")) {
			a.setDisable(true);
		}
		if(letters.equals("b")) {
			b.setDisable(true);
		}
		if(letters.equals("c")) {
			c.setDisable(true);
		}
		if(letters.equals("d")) {
			d.setDisable(true);
		}
		if(letters.equals("e")) {
			e.setDisable(true);
		}
		if(letters.equals("f")) {
			f.setDisable(true);
		}
		if(letters.equals("g")) {
			g.setDisable(true);
		}
		if(letters.equals("h")) {
			h.setDisable(true);
		}
		if(letters.equals("i")) {
			i.setDisable(true);
		}
		if(letters.equals("j")) {
			j.setDisable(true);
		}
		if(letters.equals("k")) {
			k.setDisable(true);
		}
		if(letters.equals("l")) {
			l.setDisable(true);
		}
		if(letters.equals("m")) {
			m.setDisable(true);
		}
		if(letters.equals("n")) {
			n.setDisable(true);
		}
		if(letters.equals("o")) {
			o.setDisable(true);
		}
		if(letters.equals("p")) {
			p.setDisable(true);
		}
		if(letters.equals("q")) {
			q.setDisable(true);
		}
		if(letters.equals("r")) {
			r.setDisable(true);
		}
		if(letters.equals("s")) {
			s.setDisable(true);
		}
		if(letters.equals("t")) {
			t.setDisable(true);
		}
		if(letters.equals("u")) {
			u.setDisable(true);
		}
		if(letters.equals("v")) {
			v.setDisable(true);
		}
		if(letters.equals("w")) {
			w.setDisable(true);
		}
		if(letters.equals("x")) {
			x.setDisable(true);
		}
		if(letters.equals("y")) {
			y.setDisable(true);
		}
		if(letters.equals("z")) {
			z.setDisable(true);
		}
		
	}
	
	private int decreaseAttempts() {
		return attemptsLeft--;
	}
	
	private void resetIndex() {
		index = 0;

	}
	
	/*private void getnewWord() {
		answer = setnewWord();
	}*/
	
	
	
	private String setnewWord() throws FileNotFoundException {
		String [] listofAnswer = new String[2310];

	    File txtfile = new File("wordlist.txt");
	    Scanner read = new Scanner(txtfile);
	    int c = 0;
	    while(read.hasNextLine()) {
	      String word = read.nextLine();
	      listofAnswer[c] = word;
	      c++;
	    }
	    read.close();

	    Random r = new Random();
	    int rint = r.nextInt(2310);
	    return listofAnswer[rint];
	}
	
	
	@FXML
	private void resetGame() throws Exception {
		resetted.setText("Reset");
		endgamechecker = "";
		attemptsLeft = 6;
		resetIndex();
//		getnewWord();
		answer = setnewWord();
		box01.setStyle("-fx-border-color: black");
		box01.setText("");
		box02.setStyle("-fx-border-color: black");
		box02.setText("");
		box03.setStyle("-fx-border-color: black");
		box03.setText("");
		box04.setStyle("-fx-border-color: black");
		box04.setText("");
		box05.setStyle("-fx-border-color: black");
		box05.setText("");
		box06.setStyle("-fx-border-color: black");
		box06.setText("");
		box07.setStyle("-fx-border-color: black");
		box07.setText("");
		box08.setStyle("-fx-border-color: black");
		box08.setText("");
		box09.setStyle("-fx-border-color: black");
		box09.setText("");
		box10.setStyle("-fx-border-color: black");
		box10.setText("");
		box11.setStyle("-fx-border-color: black");
		box11.setText("");
		box12.setStyle("-fx-border-color: black");
		box12.setText("");
		box13.setStyle("-fx-border-color: black");
		box13.setText("");
		box14.setStyle("-fx-border-color: black");
		box14.setText("");
		box15.setStyle("-fx-border-color: black");
		box15.setText("");
		box16.setStyle("-fx-border-color: black");
		box16.setText("");
		box17.setStyle("-fx-border-color: black");
		box17.setText("");
		box18.setStyle("-fx-border-color: black");
		box18.setText("");
		box19.setStyle("-fx-border-color: black");
		box19.setText("");
		box20.setStyle("-fx-border-color: black");
		box20.setText("");
		box21.setStyle("-fx-border-color: black");
		box21.setText("");
		box22.setStyle("-fx-border-color: black");
		box22.setText("");
		box23.setStyle("-fx-border-color: black");
		box23.setText("");
		box24.setStyle("-fx-border-color: black");
		box24.setText("");
		box25.setStyle("-fx-border-color: black");
		box25.setText("");
		box26.setStyle("-fx-border-color: black");
		box26.setText("");
		box27.setStyle("-fx-border-color: black");
		box27.setText("");
		box28.setStyle("-fx-border-color: black");
		box28.setText("");
		box29.setStyle("-fx-border-color: black");
		box29.setText("");
		box30.setStyle("-fx-border-color: black");
		box30.setText("");
		a.setDisable(false);
		b.setDisable(false);
		c.setDisable(false);
		d.setDisable(false);
		e.setDisable(false);
		f.setDisable(false);
		g.setDisable(false);
		h.setDisable(false);
		i.setDisable(false);
		j.setDisable(false);
		k.setDisable(false);
		l.setDisable(false);
		m.setDisable(false);
		n.setDisable(false);
		o.setDisable(false);
		p.setDisable(false);
		q.setDisable(false);
		r.setDisable(false);
		s.setDisable(false);
		t.setDisable(false);
		u.setDisable(false);
		v.setDisable(false);
		w.setDisable(false);
		x.setDisable(false);
		y.setDisable(false);
		z.setDisable(false);
		
	}
	
	@FXML
	private void deleteLetter() {
		if(attemptsLeft == 6 && index == 1) {
			box01.setText("");
			index--;
		}
		if(attemptsLeft == 6 && index == 2) {
			box02.setText("");
			index--;
		}
		if(attemptsLeft == 6 && index == 3) {
			box03.setText("");
			index--;
		}
		if(attemptsLeft == 6 && index == 4) {
			box04.setText("");
			index--;
		}
		if(attemptsLeft == 6 && index == 5) {
			box05.setText("");
			index--;
		}
		if(attemptsLeft == 5 && index == 1) {
			box06.setText("");
			index--;
		}
		if(attemptsLeft == 5 && index == 2) {
			box07.setText("");
			index--;
		}
		if(attemptsLeft == 5 && index == 3) {
			box08.setText("");
			index--;
		}
		if(attemptsLeft == 5 && index == 4) {
			box09.setText("");
			index--;
		}
		if(attemptsLeft == 5 && index == 5) {
			box10.setText("");
			index--;
		}
		if(attemptsLeft == 4 && index == 1) {
			box11.setText("");
			index--;
		}
		if(attemptsLeft == 4 && index == 2) {
			box12.setText("");
			index--;
		}
		if(attemptsLeft == 4 && index == 3) {
			box13.setText("");
			index--;
		}
		if(attemptsLeft == 4 && index == 4) {
			box14.setText("");
			index--;
		}
		if(attemptsLeft == 4 && index == 5) {
			box15.setText("");
			index--;
		}
		if(attemptsLeft == 3 && index == 1) {
			box16.setText("");
			index--;
		}
		if(attemptsLeft == 3 && index == 2) {
			box17.setText("");
			index--;
		}
		if(attemptsLeft == 3 && index == 3) {
			box18.setText("");
			index--;
		}
		if(attemptsLeft == 3 && index == 4) {
			box19.setText("");
			index--;
		}
		if(attemptsLeft == 3 && index == 5) {
			box20.setText("");
			index--;
		}
		if(attemptsLeft == 2 && index == 1) {
			box21.setText("");
			index--;
		}
		if(attemptsLeft == 2 && index == 2) {
			box22.setText("");
			index--;
		}
		if(attemptsLeft == 2 && index == 3) {
			box23.setText("");
			index--;
		}
		if(attemptsLeft == 2 && index == 4) {
			box24.setText("");
			index--;
		}
		if(attemptsLeft == 2 && index == 5) {
			box25.setText("");
			index--;
		}
		if(attemptsLeft == 1 && index == 1) {
			box26.setText("");
			index--;
		}
		if(attemptsLeft == 1 && index == 2) {
			box27.setText("");
			index--;
		}
		if(attemptsLeft == 1 && index == 3) {
			box28.setText("");
			index--;
		}
		if(attemptsLeft == 1 && index == 4) {
			box29.setText("");
			index--;
		}
		if(attemptsLeft == 1 && index == 5) {
			box30.setText("");
			index--;
		}
	}
	
	@FXML
	private void aa() {
		letter = a.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void b() {
		letter = b.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void c() {
		letter = c.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void d() {
		letter = d.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void e() {
		letter = e.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void f() {
		letter = f.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void g() {
		letter = g.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void h() {
		letter = h.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void i() {
		letter = i.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void j() {
		letter = j.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void k() {
		letter = k.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void l() {
		letter = l.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void m() {
		letter = m.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void n() {
		letter = n.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void o() {
		letter = o.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void p() {
		letter = p.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void q() {
		letter = q.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void r() {
		letter = r.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void s() {
		letter = s.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void t() {
		letter = t.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void u() {
		letter = u.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void v() {
		letter = v.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void w() {
		letter = w.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void x() {
		letter = x.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void y() {
		letter = y.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	@FXML
	private void z() {
		letter = z.getText();
		if(attemptsLeft == 6 && index == 0) {
			box01.setText(letter);
		}
		if(attemptsLeft == 6 && index == 1) {
			box02.setText(letter);
		}
		if(attemptsLeft == 6 && index == 2) {
			box03.setText(letter);
		}
		if(attemptsLeft == 6 && index == 3) {
			box04.setText(letter);
		}
		if(attemptsLeft == 6 && index == 4) {
			box05.setText(letter);
		}
		if(attemptsLeft == 5 && index == 0) {
			box06.setText(letter);
		}
		if(attemptsLeft == 5 && index == 1) {
			box07.setText(letter);
		}
		if(attemptsLeft == 5 && index == 2) {
			box08.setText(letter);
		}
		if(attemptsLeft == 5 && index == 3) {
			box09.setText(letter);
		}
		if(attemptsLeft == 5 && index == 4) {
			box10.setText(letter);
		}
		if(attemptsLeft == 4 && index == 0) {
			box11.setText(letter);
		}
		if(attemptsLeft == 4 && index == 1) {
			box12.setText(letter);
		}
		if(attemptsLeft == 4 && index == 2) {
			box13.setText(letter);
		}
		if(attemptsLeft == 4 && index == 3) {
			box14.setText(letter);
		}
		if(attemptsLeft == 4 && index == 4) {
			box15.setText(letter);
		}
		if(attemptsLeft == 3 && index == 0) {
			box16.setText(letter);
		}
		if(attemptsLeft == 3 && index == 1) {
			box17.setText(letter);
		}
		if(attemptsLeft == 3 && index == 2) {
			box18.setText(letter);
		}
		if(attemptsLeft == 3 && index == 3) {
			box19.setText(letter);
		}
		if(attemptsLeft == 3 && index == 4) {
			box20.setText(letter);
		}
		if(attemptsLeft == 2 && index == 0) {
			box21.setText(letter);
		}
		if(attemptsLeft == 2 && index == 1) {
			box22.setText(letter);
		}
		if(attemptsLeft == 2 && index == 2) {
			box23.setText(letter);
		}
		if(attemptsLeft == 2 && index == 3) {
			box24.setText(letter);
		}
		if(attemptsLeft == 2 && index == 4) {
			box25.setText(letter);
		}
		if(attemptsLeft == 1 && index == 0) {
			box26.setText(letter);
		}
		if(attemptsLeft == 1 && index == 1) {
			box27.setText(letter);
		}
		if(attemptsLeft == 1 && index == 2) {
			box28.setText(letter);
		}
		if(attemptsLeft == 1 && index == 3) {
			box29.setText(letter);
		}
		if(attemptsLeft == 1 && index == 4) {
			box30.setText(letter);
		}
		index++;
	}
	
	
	@FXML
	private void saveGame() {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("saved_game.dat"))) {
            gameSaves gs = new gameSaves(sc.getCurrent(), sc.getMax(), sc.getPlayed(), sc.getPercent());
            outputStream.writeObject(gs);
            saved.setText("Saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	@FXML
	private void loadGame() {
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("saved_game.dat"))) {
			gameSaves gs = (gameSaves) inputStream.readObject();
			currentStreak = gs.getcurrentStreak();
			maxStreak = gs.getmaxStreak();
            gamesPlayed = gs.getgamesPlayed();
            percentage = gs.getwinPercent();
            sc.setCurrent(currentStreak);
            sc.setMax(maxStreak);
            sc.setPlayed(gamesPlayed);
            sc.setPercent(percentage);
            
            loaded.setText("Loaded!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}


}
