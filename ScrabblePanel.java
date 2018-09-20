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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;



/**
  * 2018-09-17
  */

public class ScrabblePanel {
	private JFrame frmScrabble;
	private JPanel gameBoard;
	private JPanel menu;
	private JTextField[][] board;
	private JButton btnInput;
	private JButton btnVoteWord;
	private JButton btnVote;
	private JTextArea MessageBoard;
	
	private JButton btnPlay;
	private ScrabbleClient sc;
	private JButton btnPass;
	private JPanel alp;
	private JPanel dig;
	
	/**
	 * Create the application.
	 */
	public ScrabblePanel() {
		sc = new ScrabbleClient();
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
	@SuppressWarnings("deprecation")
	private void initialize() {
		frmScrabble = new JFrame();
		frmScrabble.setTitle("Scrabble");
		frmScrabble.setBounds(100, 100, 810, 611);
		frmScrabble.getContentPane().setLayout(null);

		// 20*20 gameboard
		gameBoard = new JPanel(new GridLayout(20, 20));
		gameBoard.setBounds(33, 34, 500, 500);
		frmScrabble.getContentPane().add(gameBoard);
			
		// control pane
		menu = new JPanel();
		menu.setBounds(561, 34, 217, 500);
		frmScrabble.getContentPane().add(menu);
		menu.setLayout(null);
		
		btnInput = new JButton("Input");
		btnInput.setBounds(55, 26, 125, 31);
		btnInput.setContentAreaFilled(false);
		btnInput.setFont(new Font("Calibri", Font.PLAIN, 18));
		menu.add(btnInput);
		
		btnPlay = new JButton("Play");
		btnPlay.setBounds(55, 202, 125, 31);
		btnPlay.setContentAreaFilled(false);
		btnPlay.setFont(new Font("Calibri", Font.PLAIN, 18));
		menu.add(btnPlay);
		
		btnVoteWord = new JButton("VoteWord");
		btnVoteWord.setBounds(55, 70, 125, 31);
		btnVoteWord.setContentAreaFilled(false);
		btnVoteWord.setFont(new Font("Calibri", Font.PLAIN, 18));
		menu.add(btnVoteWord);
		
		
		btnVote = new JButton("Vote");
		btnVote.setBounds(55, 114, 125, 31);
		btnVote.setContentAreaFilled(false);
		btnVote.setFont(new Font("Calibri", Font.PLAIN, 18));
		menu.add(btnVote);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 256, 217, 244);
		menu.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 217, 244);
		panel.add(scrollPane);
		
		MessageBoard = new JTextArea();
		MessageBoard.setLineWrap(true);
		scrollPane.setViewportView(MessageBoard);
		
		btnPass = new JButton("Pass");
		btnPass.setBounds(55, 158, 125, 31);
		btnPass.setContentAreaFilled(false);
		btnPass.setFont(new Font("Calibri", Font.PLAIN, 18));
		menu.add(btnPass);
		
		//20*1 and 1*20 label
		alp = new JPanel();
		alp.setBounds(33, 9, 500, 25);
		frmScrabble.getContentPane().add(alp);
		alp.setLayout(new GridLayout(1, 0, 0, 0));
		
		dig = new JPanel();
		dig.setBounds(9, 34, 25, 500);
		frmScrabble.getContentPane().add(dig);
		dig.setLayout(new GridLayout(0, 1, 0, 0));

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
		
		//labels shows the grid
		JTextField[] alpha = new JTextField[20];
		JTextField[] digit = new JTextField[20];
		char alpha_ = 'A';
		int digit_ = 1;
		for(int i=0; i<20;i++) {
			alpha[i] = new JTextField();
			alpha[i].setText(String.valueOf(alpha_));
			alpha[i].setHorizontalAlignment(JTextField.CENTER);
			alpha[i].setFont(new Font("Arial", Font.BOLD, 16));
			alpha[i].disable();
			alp.add(alpha[i]);
			digit[i] = new JTextField();
			digit[i].setText(String.valueOf(digit_));
			digit[i].setHorizontalAlignment(JTextField.CENTER);
			digit[i].setFont(new Font("Arial", Font.BOLD, 16));
			digit[i].disable();
			dig.add(digit[i]);
			alpha_++;
			digit_++;	
		}
		
		frmScrabble.setVisible(true);
		event();
	}
		
	//加字母到特定位置
	public void setWord(String operation) {
		String[] operations = operation.split(" ");
		int x = Integer.parseInt(operations[1]) - 1;
		int y = operations[0].toUpperCase().toCharArray()[0] - 'A';
		char a = operations[2].toUpperCase().toCharArray()[0];
		board[x][y].setText(String.valueOf(a));
	}
	
	//将各类message展示在消息板上
	public void showMessage(String message) {
		String[] messages = message.split("::@:");
		if(messages[0].equals("Vote")) {
			MessageBoard.append(messages[1]+" is voting for the word "+messages[2]+"\r\n");
		}
		else if(messages[0].equals("GameOver")) {
			MessageBoard.append("GameOver, the winner is "+messages[1]+" with a score of "+messages[2]+"\r\n");
		}
		else {
			MessageBoard.append(message+"\r\n");
		}
	}

	//各个button的点击事件
	private void event(){
		//input button弹出窗口输入字符
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new InputField();
			}
		});	
		btnVoteWord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Vote();
			}
		});	
		btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String message = sc.operate("Play::@:");
				showMessage(message);
			}
		});	
		btnPass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String message = sc.operate("Pass::@:");
				showMessage(message);
			}
		});
		btnVote.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String message = sc.operate("VoteYes::@:");
				showMessage(message);
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
			row.setDocument(new LimitDoc());
			frame.getContentPane().add(row);
			row.setColumns(10);
			
			JLabel lblLetter = new JLabel("Letter");
			lblLetter.setBounds(167, 51, 72, 18);
			frame.getContentPane().add(lblLetter);
			
			letter = new JTextField();
			letter.setBounds(167, 81, 49, 24);
			frame.getContentPane().add(letter);
			letter.setColumns(10);
			letter.setDocument(new LimitDoc());
			
			JButton btnInput = new JButton("Confirm");
			btnInput.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String operation = "Set::@:"+col.getText()+" "+row.getText()+" "+letter.getText();
					String message=sc.operate(operation);
					setWord(col.getText()+" "+row.getText()+" "+letter.getText());
					showMessage(message);
					frame.dispose();
				}
			});
			btnInput.setBounds(65, 159, 113, 27);
			frame.getContentPane().add(btnInput);
			
			col = new JTextField();
			col.setBounds(28, 82, 38, 24);
			frame.getContentPane().add(col);
			col.setColumns(10);
			col.setDocument(new LimitDoc());
			frame.setVisible(true);
		}		
	}
	
	
	class Vote {

		private JFrame frame;
		private JTextField text_x1;
		private JTextField text_y1;
		private JTextField text_x2;
		private JTextField text_y2;

		/**
		 * Create the application.
		 */
		public Vote() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblX = new JLabel("x1:");
			lblX.setBounds(39, 43, 72, 18);
			frame.getContentPane().add(lblX);
			
			JLabel lblY = new JLabel("y1:");
			lblY.setBounds(196, 43, 72, 18);
			frame.getContentPane().add(lblY);
			
			JLabel lblX_1 = new JLabel("x2:");
			lblX_1.setBounds(39, 106, 72, 18);
			frame.getContentPane().add(lblX_1);
			
			JLabel lblY_1 = new JLabel("y2:");
			lblY_1.setBounds(196, 106, 72, 18);
			frame.getContentPane().add(lblY_1);
			
			text_x1 = new JTextField();
			text_x1.setBounds(72, 40, 86, 24);
			frame.getContentPane().add(text_x1);
			text_x1.setColumns(10);
			
			text_y1 = new JTextField();
			text_y1.setBounds(237, 40, 86, 24);
			frame.getContentPane().add(text_y1);
			text_y1.setColumns(10);
			
			text_x2 = new JTextField();
			text_x2.setBounds(72, 103, 86, 24);
			frame.getContentPane().add(text_x2);
			text_x2.setColumns(10);
			
			text_y2 = new JTextField();
			text_y2.setBounds(237, 106, 86, 24);
			frame.getContentPane().add(text_y2);
			text_y2.setColumns(10);
			
			text_x1.setDocument(new LimitDoc());
			text_x2.setDocument(new LimitDoc());
			text_y1.setDocument(new LimitDoc());
			text_y2.setDocument(new LimitDoc());
			
			JButton btnConfirm = new JButton("Confirm");
			btnConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String operation = "Vote::@:"+text_x1.getText()+" "+text_x2.getText()+" "+text_y1.getText()+" "+text_y2.getText();
					String message = sc.operate(operation);
					showMessage(message);
					frame.dispose();
				}
			});
			btnConfirm.setBounds(72, 182, 113, 27);
			frame.getContentPane().add(btnConfirm);
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


