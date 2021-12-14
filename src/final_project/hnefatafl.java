package final_project;
//Bryan Zang
//June 14 2019
//unit 6 ICS3U0 final game - grid based applet
//Hnefatafl - Viking chess
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
public class hnefatafl extends Applet implements ActionListener {
	//to hold all of the screens
	Panel p_card;
	//the screens
	Panel card1, card2, card3, card4, card5, card6;
	CardLayout cdLayout = new CardLayout ();
	//used in AP
	int last = -1;
	// turn pic on the game screen
	JLabel turnpic;
	char turn = 'a';
	//char choice;

	JRadioButton z;
	JRadioButton z1;

	JButton next;
	//grid
	int row = 9;
	int col = 9;
	JButton a[] = new JButton [row * col];
	//board to reset to
	char r [][] = {{'e', 'e', 'e', 'a', 'a', 'a', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'a', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'e'},
			{'a', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'a'},
			{'a', 'a', 'd', 'd', 'k', 'd', 'd', 'a', 'a'},
			{'a', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'a'},
			{'e', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'a', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'a', 'a', 'a', 'e', 'e', 'e'},};
	//reset array for the team array
	char team2[][] = {{'e', 'e', 'e', 'a', 'a', 'a', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'a', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'e'},
			{'a', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'a'},
			{'a', 'a', 'd', 'd', 'd', 'd', 'd', 'a', 'a'},
			{'a', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'a'},
			{'e', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'a', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'a', 'a', 'a', 'e', 'e', 'e'},};
	//holds the background
	char board[][] = {{'c', 'e', 'e', 'x', 'x', 'x', 'e', 'e', 'c'},
			{'e', 'e', 'e', 'e', 'x', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'x', 'e', 'e', 'e', 'e'},
			{'x', 'e', 'e', 'e', 'x', 'e', 'e', 'e', 'x'},
			{'x', 'x', 'x', 'x', 'z', 'x', 'x', 'x', 'x'},
			{'x', 'e', 'e', 'e', 'x', 'e', 'e', 'e', 'x'},
			{'e', 'e', 'e', 'e', 'x', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'x', 'e', 'e', 'e', 'e'},
			{'c', 'e', 'e', 'x', 'x', 'x', 'e', 'e', 'c'},};
	//holds the pieces
	char piece[][]= {{'e', 'e', 'e', 'a', 'a', 'a', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'a', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'e'},
			{'a', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'a'},
			{'a', 'a', 'd', 'd', 'k', 'd', 'd', 'a', 'a'},
			{'a', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'a'},
			{'e', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'a', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'a', 'a', 'a', 'e', 'e', 'e'},};
	//selection array
	//selected (s) and unselected (u)
	char select[][] = {{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},};
	//specifies team turns
	char team[][] =  {{'e', 'e', 'e', 'a', 'a', 'a', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'a', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'e'},
			{'a', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'a'},
			{'a', 'a', 'd', 'd', 'd', 'd', 'd', 'a', 'a'},
			{'a', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'a'},
			{'e', 'e', 'e', 'e', 'd', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'e', 'a', 'e', 'e', 'e', 'e'},
			{'e', 'e', 'e', 'a', 'a', 'a', 'e', 'e', 'e'},};
	Panel grid = new Panel (new GridLayout (row, col));
	public void init() {
		resize(630, 690);
		p_card = new Panel ();
		p_card.setLayout (cdLayout);
		screen1 ();
		screen2 ();
		screen3();
		game();
		screen4();
		screen5();
		setLayout (new BorderLayout ());
		add ("Center", p_card);
	}
	public void screen1 () { //screen 1 - welcome screen
		card1 = new Panel ();
		card1.setBackground (new Color(43, 107, 139));
		JLabel title = new JLabel ("Welcome to");
		title.setForeground(new Color(219, 145, 60));
		title.setFont(new Font("Constantia", Font.PLAIN, 70));
		JLabel t2 = new JLabel("Hnefatafl");
		t2.setForeground(new Color(219, 145, 60));
		t2.setFont(new Font("Constantia", Font.ITALIC, 120));
		JLabel name = new JLabel ("By: Bryan Zang");
		name.setForeground(new Color(219, 145, 60));
		name.setFont(new Font("Constantia", Font.PLAIN, 25));
		JLabel pic = new JLabel (new ImageIcon("warriors.jpg"));
		JButton next = new JButton ("Next");
		next.setFont(new Font("Constantia", Font.PLAIN, 40));
		next.setForeground(new Color(219, 145, 60));
		next.setBackground(new Color(43, 107, 139));
		next.setActionCommand ("s2");
		next.addActionListener (this);
		card1.add (title);card1.add(t2);card1.add(name);card1.add(pic);card1.add(next);
		p_card.add ("1", card1);
	}
	public void screen2 () { //screen 2 is set up - instructions screen
		card2 = new Panel ();
		card2.setBackground (new Color(23, 92, 126));
		JLabel title = new JLabel ("Instructions");
		title.setForeground(new Color(43, 156, 92));
		title.setFont(new Font ("Constantia", Font.PLAIN, 60));
		JLabel ins = new JLabel ("The objective of the game is to have the defenders escort");
		ins.setFont(new Font ("Constantia", Font.PLAIN, 19));
		ins.setForeground(new Color(219, 145, 60));
		JLabel ins2 = new JLabel ("the King into 1 of the 4 corner castles while under attack");
		ins2.setFont(new Font ("Constantia", Font.PLAIN, 19));
		ins2.setForeground(new Color(219, 145, 60));
		JLabel ins3 = new JLabel ("from the attacking team who has twice as much pieces. Capture");
		ins3.setFont(new Font ("Constantia", Font.PLAIN, 19));
		ins3.setForeground(new Color(219, 145, 60));
		JLabel ins4 = new JLabel ("the opponent's pieces by surrounding on 2 opposite sides,");
		ins4.setFont(new Font ("Constantia", Font.PLAIN, 19));
		ins4.setForeground(new Color(219, 145, 60));
		JLabel ins5 = new JLabel ("and capture the King by surrounding on 4 sides. Castles can also");
		ins5.setFont(new Font ("Constantia", Font.PLAIN, 19));
		ins5.setForeground(new Color(219, 145, 60));
		JLabel ins6 = new JLabel ("act as pieces when aiding in captures. Pieces can move as far as");
		ins6.setFont(new Font ("Constantia", Font.PLAIN, 19));
		ins6.setForeground(new Color(219, 145, 60));
		JLabel ins7= new JLabel ("they wish horizontally or vertically. However, they cannot move");
		ins7.setFont(new Font ("Constantia", Font.PLAIN, 19));
		ins7.setForeground(new Color(219, 145, 60));
		JLabel ins8 = new JLabel ("nor can they kill; only capture. Attackers are red and move first.");
		ins8.setFont(new Font ("Constantia", Font.PLAIN, 19));
		ins8.setForeground(new Color(219, 145, 60));
		JLabel ins9 = new JLabel ("The game ends when the King is captured or he successfully escapes.");
		ins9.setFont(new Font ("Constantia", Font.PLAIN, 19));
		ins9.setForeground(new Color(219, 145, 60));
		JButton next = new JButton ("Next");
		next.setForeground(new Color(219, 145, 60));
		next.setBackground(new Color(43, 107, 139));
		next.setFont(new Font("COnstantia", Font.PLAIN, 30));
		next.setActionCommand ("s7");
		next.addActionListener (this);
		JLabel pic = new JLabel (new ImageIcon("ins1.jpg"));
		card2.add (title); card2.add(ins); card2.add(ins2); card2.add(ins3); card2.add(ins4); card2.add(ins5); card2.add(ins6); card2.add(ins7); card2.add(ins8); card2.add(ins9); card2.add(pic); card2.add(next);
		p_card.add ("2", card2);
	}

	public void screen3() {
		card6 = new Panel();
		card6.setBackground (new Color(23, 92, 126));
		JLabel eg = new JLabel ("Examples");
		eg.setForeground(new Color(43, 156, 92));
		eg.setFont(new Font ("Constantia", Font.PLAIN, 60));
		JLabel dsc = new JLabel ("");
		dsc.setFont(new Font ("Constantia", Font.PLAIN, 19));
		dsc.setForeground(new Color(219, 145, 60));
		JLabel pic1 = new JLabel (createImageIcon("capturesoldier.png"));
		JButton next = new JButton ("To Game");
		next.setForeground(new Color(219, 145, 60));
		next.setBackground(new Color(43, 107, 139));
		next.setFont(new Font("Constantia", Font.PLAIN, 30));
		next.setActionCommand ("s3");
		next.addActionListener (this);
		z = new JRadioButton("Attackers (red) play first");
		z.setActionCommand("z");
		z.addActionListener(this);
		z1 = new JRadioButton("Defenders (green) play first");
		z1.setActionCommand("z1");
		z1.addActionListener(this);
		ButtonGroup group = new ButtonGroup();
		group.add(z);
		group.add(z1);
		Panel p2 = new Panel (new GridLayout (2, 1));
		p2.add (z);
		p2.add (z1);
		JLabel choose = new JLabel ("The result is: ");
		choose.setPreferredSize (new Dimension (250, 20));
		choose.setFont(new Font ("Constantia", Font.PLAIN, 19));
		choose.setForeground(new Color(219, 145, 60));
		card6.add (z);
		card6.add (z1);
		card6.add (choose);
		card6.add(eg); card6.add(dsc); card6.add(pic1); card6.add(next);
		p_card.add ("6", card6);
	}

	public void game() { //screen 3; game screen is set up
		card3 = new Panel ();
		card3.setBackground (new Color(43, 107, 139));
		JLabel title = new JLabel ("HNEFATAFl");
		title.setFont(new Font ("Constantia", Font.PLAIN, 45));
		title.setForeground(new Color(43, 156, 92));
		JButton reset = new JButton ("Reset");
		reset.setActionCommand("r");
		reset.setFont(new Font("Constantia", Font.PLAIN, 20));
		reset.setForeground(new Color(219, 145, 60));
		reset.setBackground(new Color(43, 107, 139));
		reset.addActionListener (this);
		JLabel t = new JLabel ("Turn:");
		t.setForeground(new Color(219, 145, 60));
		t.setFont(new Font("Constantia", Font.PLAIN, 30));
		turnpic = new JLabel(new ImageIcon("p1.png"));
		turnpic.setPreferredSize(new Dimension(62, 62));
		Panel p = new Panel (new GridLayout (row, col)); //displaying the game board
		int move = 0;
		for (int i = 0 ; i < row ; i++) {
			for (int j = 0 ; j < col ; j++) {
				a [move] = new JButton ("");
				a [move] = new JButton (createImageIcon (board[i][j] +""+ piece[i][j] + select[i][j] +".jpg"));
				a [move].setPreferredSize (new Dimension (61, 61));
				a [move].addActionListener (this);
				a [move].setActionCommand ("" + move);
				p.add (a [move]);
				move++;
			}
		}
		card3.add (title); card3.add(p); card3.add(t); card3.add(turnpic);card3.add(reset);
		p_card.add ("3", card3);
	}
	public void screen4 () { //screen 4 is set up; shows after game end
		card4 = new Panel ();
		card4.setBackground (new Color(255, 255, 255));
		JLabel title = new JLabel ("");
		JButton next = new JButton ("Next");
		next.setActionCommand ("s5");
		next.addActionListener (this);
		card4.add (title); card4.add (next);
		p_card.add ("4", card4);
	}
	public void screen5 () { //screen 5 is set up.
		card5 = new Panel ();
		card5.setBackground (new Color(255, 255, 255));
		JLabel title = new JLabel ("You Lose.");
		JButton next = new JButton ("Back to Introduction?");
		next.setActionCommand ("s1");
		next.addActionListener (this);
		JButton end = new JButton ("Quit?");
		end.setActionCommand ("s6");
		end.addActionListener (this);
		card5.add (title); card5.add (next); card5.add (end);
		p_card.add ("5", card5);
	}
	public void move(int x, int y) { //same movement as rook from chess - no killing
		int cx1 = x - 1;//up
		int cx2 = x + 1;//down
		int cy1 = y - 1;//left
		int cy2 = y + 1;//right
		while (cx1 >= 0 && piece [cx1][y] == 'e') {//up movement
			select[cx1][y] = 's';
			cx1--;
		}
		while (cx2 < col && piece [cx2][y] == 'e') {//down movement
			select[cx2][y] = 's';
			cx2++;
		}
		while (cy1 >= 0 && piece [x][cy1] == 'e') {//left movement
			select[x][cy1] = 's';
			cy1--;
		}
		while (cy2 < col && piece [x][cy2] == 'e') {//right movement
			select[x][cy2] = 's';
			cy2++;
		} 
	}
	public void actionPerformed (ActionEvent e) { //moves between the screens; should take some out once coded the game end-screen
		if (e.getActionCommand ().equals ("s1"))
			cdLayout.show (p_card, "1");
		else if (e.getActionCommand ().equals ("s2"))
			cdLayout.show (p_card, "2");
		else if (e.getActionCommand ().equals ("s3"))
			cdLayout.show(p_card, "3");
		else if (e.getActionCommand ().equals ("s4"))
			cdLayout.show (p_card, "4");
		else if (e.getActionCommand ().equals ("s5")) {
			cdLayout.show (p_card, "5");
			reset();
		} else if (e.getActionCommand().equals("s7"))
			cdLayout.show(p_card, "6");
		else if (e.getActionCommand ().equals ("s6"))
			System.exit (0);
		else if (e.getActionCommand().equals("r"))
			reset();
		else if (e.getActionCommand().equals("z")) {
			turn = 'a';
			turns();
		} else if (e.getActionCommand().equals("z1")) {
			turn = 'd';
			turns();
			//playturn();
		} else { //code to handle the game
			int n = Integer.parseInt (e.getActionCommand ());
			int x = n / col;
			int y = n % col;
			if(turn != team[x][y] && last == -1)
				showStatus("Not your turn");
			//first click
			else if (last == -1 && turn == team [x][y]) {
				move(x, y);
				last = n;
				showStatus("Good");
			} else {
				//second click
				showStatus("Move");
				int prex = last/row;
				int prey = last%row;
				if(select[x][y] == 's') {
					piece[x][y] = piece[prex][prey];
					piece[prex][prey] = 'e';
					team[x][y] = team[prex][prey];
					team[prex][prey] = 'e';
					if(captureleft(x, y) == true) {
						piece[x][y-1] = 'e';
						team[x][y-1] = 'e';
					} else if(captureright(x, y) == true) {
						piece[x][y+1] = 'e';
						team[x][y+1] = 'e';
					} else if(captureup(x, y) == true) {
						piece[x-1][y] = 'e';
						team[x-1][y] = 'e';
					} else if (capturedown(x, y) == true) {
						piece[x+1][y] = 'e';
						team[x+1][y] = 'e';
					}
					if(kwin(x, y) == true) {
						JOptionPane.showMessageDialog (null, "The King has escaped! Defenders win!", "Win!", JOptionPane.INFORMATION_MESSAGE);
						JButton next = new JButton ("Next");
						next.setActionCommand ("s4");
						next.setFont(new Font("Constantia", Font.PLAIN, 21));
						next.setForeground(new Color(219, 145, 60));
						next.setBackground(new Color(43, 107, 139));
						next.addActionListener (this);
						card3.add(next);
					} else if(awin(x, y) == true)
						JOptionPane.showMessageDialog (null, "The King has been captured! Attackers win!", "Win!", JOptionPane.INFORMATION_MESSAGE);
					turns();
				}
				for(int i = 0; i < row; i++)
					for(int j = 0; j < row; j++)
						select[i][j] = 'u';
				last = -1;
			}
			redraw();
		}
	}
	public void turns() {
		//turn = choice;
		if (turn == 'd'){
			turnpic.setIcon(createImageIcon("p1.png"));
			turn ='a';
		} else {
			turnpic.setIcon(createImageIcon("p2.png"));
			turn = 'd';
		}
	}
	public void redraw () {
		int move = 0;
		for (int i = 0 ; i < row ; i++) {
			for (int j = 0 ; j < col ; j++) {
				a [move].setIcon (createImageIcon (board [i] [j] + "" + piece[i][j] + "" + select[i][j] + ".jpg"));
				move++;
			}
		}
	}
	//for when a piece is captured whilst moving left
	public boolean captureleft(int x, int y) {
		if (team[x][y] == 'a' && (y-2) >= 0 && team[x][y-2] == 'a'&& team[x][y-1] == 'd' && piece[x][y-1] != 'k')
			return true;
		else if (team[x][y] == 'd' && (y-2) >= 0 && team[x][y-2] == 'd'&& team[x][y-1] == 'a' && piece[x][y-1] != 'k')
			return true;
		else
			return false;
	}
	//for when a piece is captured whilst moving right
	public boolean captureright(int x, int y) {
		if (team[x][y] == 'a' && (y+2) < col && team[x][y+2] == 'a'&& team[x][y+1] == 'd' && piece[x][y+1] != 'k')
			return true;
		else if (team[x][y] == 'd' && (y+2) < col && team[x][y+2] == 'd'&& team[x][y+1] == 'a' && piece[x][y+1] != 'k')
			return true;
		else
			return false;
	}
	//for when a piece is captured whilst moving up
	public boolean captureup(int x, int y) {
		if (team[x][y] == 'a' && (x-2) >= 0 && team[x-2][y] == 'a' && team[x-1][y] == 'd' && piece[x-1][y] != 'k')
			return true;
		else if (team[x][y] == 'd' && (x-2) >= 0 && team[x-2][y] == 'd'&& team[x-1][y] == 'a' && piece[x-1][y] != 'k')
			return true;
		else
			return false;
	}
	//for when a piece is captured whilst moving down
	public boolean capturedown(int x, int y) {
		if (team[x][y] == 'a' && (x+2) < row && team[x+2][y] == 'a' && team[x+1][y] == 'd' && piece[x+1][y] != 'k')
			return true;
		else if (team[x][y] == 'd' && (x+2) < row && team[x+2][y] == 'd' && team[x+1][y] == 'a' && piece[x+1][y] != 'k')
			return true;
		else
			return false;
	}
	//king - win
	public boolean kwin(int x, int y) {
		if(piece[x][y] == 'k') {
			if(x == 0 && y == 0)
				return true;
			else if(x == 8 && y == 8)
				return true;
			else if(x == 0 && y == 8)
				return true;
			else if (x == 8 && y == 0)
				return true;
			else
				return false;
		} else
			return false;
	}
	//does not win yet for attackers
	//attacker - win
	public boolean awin(int x, int y) {
		//up win
		if(team[x][y] == 'a' && (x-2) >= 0 && team[x-2][y] == 'a' && team[x-1][y-1] == 'a' && team[x-1][y+1] == 'a' && piece[x-1][y] == 'k')
			return true;
		//down win
		else if (team[x][y] == 'a' && (x+2) < row && team[x+2][y] == 'a' && team[x+1][y-1] == 'a' && team[x+1][y+1] == 'a' && piece[x+1][y] == 'k')
			return true;
		//right win
		else if(team[x][y] == 'a' && (y+2) < col && team[x][y+2] == 'a' && team[x-1][y+1] == 'a' && team[x+1][y+1] == 'a' && piece[x][y+1] == 'k')
			return true;
		//left win
		else if(team[x][y] == 'a' && (y-2) >= 0 && team[x][y-2] == 'a' && team[x-1][y-1] == 'a' && team[x+1][y-1] == 'a' && piece[x][y-1] == 'k')
			return true;
		else
			return false;
	}
	public void reset () { //copy every element of r into b
		//that sets it back to the original
		for (int i = 0 ; i < row ; i++)
			for (int j = 0 ; j < col ; j++) {
				piece [i] [j] = r [i] [j];
				team [i][j] = team2 [i][j];
			}
		turns();
		//turn = choice;
		//call redraw to update b on the screen
		redraw ();
	}
	protected static ImageIcon createImageIcon (String path) {
		java.net.URL imgURL = hnefatafl.class.getResource (path);
		if (imgURL != null)
			return new ImageIcon (imgURL);
		else
			return null;
	}
}


