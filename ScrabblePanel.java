import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;



/**
  * 2018-09-17
  */

public class ScrabblePanel {
	private JFrame frmScrabble;
	private JPanel gameBoard;
	private JPanel menu;
	private JTextField[][] board;
	private JButton btnInput;
	public String operation;
	private JButton btnPlay;
	
	/**
	 * Create the application.
	 */
	public ScrabblePanel() {
		initialize();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ScrabblePanel();	
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
		});
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScrabble = new JFrame();
		frmScrabble.setTitle("Scrabble");
		frmScrabble.setBounds(100, 100, 718, 611);
		frmScrabble.getContentPane().setLayout(null);

		// 19*19 gameboard
		gameBoard = new JPanel(new GridLayout(20, 20));
		gameBoard.setBounds(33, 34, 500, 500);
		frmScrabble.getContentPane().add(gameBoard);
			
		// control pane
		menu = new JPanel();
		menu.setBounds(561, 13, 125, 538);
		frmScrabble.getContentPane().add(menu);
		menu.setLayout(null);
		
		btnInput = new JButton("Input");
		btnInput.setBounds(14, 26, 97, 31);
		btnInput.setContentAreaFilled(false);
		btnInput.setFont(new Font("Calibri", Font.PLAIN, 18));
		menu.add(btnInput);
		
		btnPlay = new JButton("Play");
		btnPlay.setBounds(0, 415, 97, 31);
		btnInput.setContentAreaFilled(false);
		btnInput.setFont(new Font("Calibri", Font.PLAIN, 18));
		menu.add(btnPlay);

		// create 19*19 textfields in the gameboard
		board = new JTextField[20][20];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				board[i][j] = new JTextField();
				board[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

				if ((i == j || i + j == 19) && (i < 6 || i == 8 || i > 10)) {
					board[i][j].setBackground(Color.RED);
				}

				else if (((i == 3 || i == 9 || i == 15) && (j == 0 || j == 19))
						|| ((j == 3 || j == 9 || j == 15) && (i == 0 || i == 19))) {
					board[i][j].setBackground(Color.BLUE);
				}

				else if (((i - j) == 5 && (j > 8 || j < 4) && j != 0 && i != 13 && i != 19)) {
					board[i][j].setBackground(Color.GREEN);
					board[j][i].setBackground(Color.GREEN);
				}

				else if ((i + j) == 13 && (i > 8 || i < 5) && i != 0 && j != 0) {
					board[i][j].setBackground(Color.GREEN);
				}

				else if ((i + j) == 23 && (j < 10 || j > 14) && i != 19 && j != 19) {
					board[i][j].setBackground(Color.GREEN);
				}

				else {
					board[i][j].setHorizontalAlignment(JTextField.CENTER);
					board[i][j].setFont(new Font("Arial", Font.PLAIN, 16));
					board[i][j].setBackground(Color.WHITE);
					board[i][j].setDocument(new LimitDoc());

				}
				gameBoard.add(board[i][j]);
			}
		}
		frmScrabble.setVisible(true);
		event();
	}
		
	//加特定字母到特定位置
	public void setWord(String operation) {
		String[] operations = operation.split(" ");
		int x = Integer.parseInt(operations[1]) - 1;
		int y = operations[0].toUpperCase().toCharArray()[0] - 'A';
		char a = operations[2].toUpperCase().toCharArray()[0];
		board[x][y].setText(String.valueOf(a));
	}

	//input button打开新的添加字母的窗口
	private void event(){
		//confirm the input
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new InputField();
			}
		});	
		btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});	
	}
	
	
	//添加字母的窗口
	class InputField {

		private JFrame frame;
		private JTextField row;
		private JTextField letter;
		private JTextField col;

		/**
		 * Create the application.
		 */
		public InputField() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 269, 269);
			frame.getContentPane().setLayout(null);
			
			JLabel lblCol = new JLabel("Col");
			lblCol.setBounds(28, 51, 72, 18);
			frame.getContentPane().add(lblCol);
			
			JLabel lblRow = new JLabel("Row");
			lblRow.setBounds(103, 51, 72, 18);
			frame.getContentPane().add(lblRow);
			
			row = new JTextField();
			row.setBounds(103, 82, 38, 24);
			frame.getContentPane().add(row);
			row.setColumns(10);
			
			JLabel lblLetter = new JLabel("Letter");
			lblLetter.setBounds(167, 51, 72, 18);
			frame.getContentPane().add(lblLetter);
			
			letter = new JTextField();
			letter.setBounds(167, 81, 49, 24);
			frame.getContentPane().add(letter);
			letter.setColumns(10);
			
			JButton btnInput = new JButton("Confirm");
			btnInput.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					operation = col.getText()+" "+row.getText()+" "+letter.getText();
					setWord(operation);
					frame.dispose();
				}
			});
			btnInput.setBounds(65, 159, 113, 27);
			frame.getContentPane().add(btnInput);
			
			col = new JTextField();
			col.setBounds(28, 82, 38, 24);
			frame.getContentPane().add(col);
			col.setColumns(10);
			frame.setVisible(true);
		}		
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


