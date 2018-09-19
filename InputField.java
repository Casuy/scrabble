import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
  * @author Kuan Tian
  * 2018-09-18
  */

public class InputField1 {

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
				String operation = col.getText()+" "+row.getText()+" "+letter.getText();
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
