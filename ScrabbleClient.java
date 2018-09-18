import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
  * @author DSH1
  * 2018-09-17
  */

public class ScrabbleClient {

	private JFrame frmScrabble;
	private JPanel gameBoard;
	private JPanel menu;
	private JTextField[][] board;
	private JButton btnConfirm;
	private user user1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrabbleClient window = new ScrabbleClient();
					window.frmScrabble.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScrabbleClient() {
		initialize();
		user1 = new user();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frmScrabble = new JFrame();
		frmScrabble.setTitle("Scrabble");
		frmScrabble.setBounds(100, 100, 685, 576);
		frmScrabble.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScrabble.getContentPane().setLayout(null);

		// 19*19 gameboard
		gameBoard = new JPanel(new GridLayout(19, 19));
		gameBoard.setBounds(14, 13, 500, 500);
		frmScrabble.getContentPane().add(gameBoard);
			
		// control pane
		menu = new JPanel();
		menu.setBounds(528, 13, 125, 500);
		frmScrabble.getContentPane().add(menu);
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(0, 13, 127, 42);
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setFont(new Font("Calibri", Font.PLAIN, 18));
		menu.add(btnConfirm);

		// create 19*19 textfields in the gameboard
		board = new JTextField[19][19];
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				board[i][j] = new JTextField();
				board[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

				if ((i == j || i + j == 18) && (i < 6 || i == 8 || i > 9)) {
					board[i][j].setBackground(Color.RED);
					board[i][j].setText("1");
					board[i][j].disable();
				}

				else if (((i == 3 || i == 9 || i == 15) && (j == 0 || j == 18))
						|| ((j == 3 || j == 9 || j == 15) && (i == 0 || i == 18))) {
					board[i][j].setBackground(Color.BLUE);
					board[i][j].setText("1");
					board[i][j].disable();
				}

				else if (((i - j) == 5 && (j > 8 || j < 4) && j != 0 && i != 13 && i != 18)) {
					board[i][j].setBackground(Color.GREEN);
					board[j][i].setBackground(Color.GREEN);
					board[i][j].setText("1");
					board[j][i].setText("1");
					board[i][j].disable();
					board[j][i].disable();
				}

				else if ((i + j) == 13 && (i > 8 || i < 5) && i != 0 && j != 0) {
					board[i][j].setBackground(Color.GREEN);
					board[i][j].setText("1");
					board[i][j].disable();
				}

				else if ((i + j) == 23 && (j < 10 || j > 14) && i != 18 && j != 18) {
					board[i][j].setBackground(Color.GREEN);
					board[i][j].setText("1");
					board[i][j].disable();
				}

				else {
					board[i][j].setHorizontalAlignment(JTextField.CENTER);
					Font font = new Font("Arial", Font.PLAIN, 16);
					board[i][j].setFont(font);
					board[i][j].setBackground(Color.WHITE);
					board[i][j].setDocument(new LimitDoc());

					board[i][j].addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent e) {
							int keyChar = e.getKeyChar();
							if (user1.getTimes()==0) e.consume();   //to ensure that each user can only insert once
							else if (keyChar < 97 || keyChar > 122) e.consume();
						}
					});
				}
				gameBoard.add(board[i][j]);
			}
		}
		event();
	}
	
	@SuppressWarnings("deprecation")
	private void event(){
		for (int i = 1; i < 19; i++) {
			for (int j = 1; j < 19; j++) {
				if(board[i-1][j].getText().equals("")&&board[j-1][i].getText().equals("")) board[i][j].disable();
				}
			}
		
		frmScrabble.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		//monitor each textfield
		Document[][] dt = new Document[19][19];
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				dt[i][j] = board[i][j].getDocument();
				dt[i][j].addDocumentListener(new DocumentListener() {

					@Override
					public void changedUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						user1.insert();
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						user1.delete();
					}
					
				});
				}
			}
		
		//confirm the input
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for (int i = 1; i < 19; i++) {
					for (int j = 1; j < 19; j++) {
						if(board[i-1][j].getText().matches("\\w")||board[i][j-1].getText().matches("\\w")) {
							if(board[i][j].getText().equals("")) board[i][j].enable();
						}
					}
				}
				user1.setTimes();
			}
		});	
	}
}


//define the user class
class user{
	private int times=1;
	
	public void insert() {
		this.times-=1;
	}
	
	public void delete() {
		this.times+=1;
	}
	
	public void setTimes() {
		this.times=1;
	}
	
	public int getTimes() {
		return this.times;
	}
}


// limit the length of the document 1
@SuppressWarnings("serial")
class LimitDoc extends PlainDocument {
	private final int maxLength = 1;

	public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
		if (getLength() + str.length() > maxLength) {
			return;
		} else {
			super.insertString(offset, str, a);
		}
	}
}