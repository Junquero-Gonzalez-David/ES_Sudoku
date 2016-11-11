package presentacio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aplicacio.ControlJoc;
import domini.Casella;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class IUSwing extends JFrame {
	private  ControlJoc sudoku = new ControlJoc();	
	private JTextField[][] caselles = new JTextField[9][9];
	private int[][] valors;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IUSwing frame = new IUSwing("EL SUDOKU");
					frame.setSize(300,300);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IUSwing(String titol){
		super(titol);
		initComponents();
	}
	public void initComponents() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		valors = sudoku.getValorsGraella();
		this.setLayout(null);
		this.setLayout(new GridLayout(9,9));
		
		for(int i=0; i<9;i++){
			int x=i;
			for(int j=0; j<9;j++){
				int y=j;
				
				caselles[i][j]=new JTextField();
				caselles[i][j].setHorizontalAlignment(JTextField.CENTER);
				caselles[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
				caselles[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				
				if(valors[i][j]!=0){
					caselles[i][j].setText(Integer.toString(valors[i][j]));
					caselles[i][j].setBackground(Color.DARK_GRAY);
					caselles[i][j].setForeground(Color.blue);
					caselles[i][j].setDisabledTextColor(Color.yellow);;
					caselles[i][j].setEditable(false);

				}
				caselles[i][j].addKeyListener(new KeyAdapter() {
					
					
					// Event handler: keyTyped
					
					public void keyPressed(KeyEvent arg0) {
						caselles[x][y].setText("");
						caselles[x][y].setBackground(Color.white);		
						char input=arg0.getKeyChar();
						int num=0;
						try{
						if(arg0.getKeyChar() == KeyEvent.VK_BACK_SPACE){
							sudoku.eliminarValor(x+1,y+1);
							caselles[x][y].setText("");
						}
						else if((!(Character.isDigit(input)) || input =='0')){
							caselles[x][y].setBackground(Color.red);
							caselles[x][y].setText("");
						}
						else{
							num = (int)Character.getNumericValue(input);
								sudoku.afegirNouValor(x+1,y+1,num);
								caselles[x][y].setText("");
							}
						}
						
						catch (Exception e) {
							caselles[x][y].setBackground(Color.red);
							JOptionPane.showMessageDialog(null, e.getMessage());
							caselles[x][y].setText("");
						}
							
							if(sudoku.jocCompletat()){
								JOptionPane.showMessageDialog(null, "Felicitats! Has completat el joc.");

								for(int i=0; i<9;i++){
									for(int j=0; j<9;j++){
										caselles[i][j].setEditable(false);
									}
								}
							}
					}
				});
				this.getContentPane().add(caselles[i][j]);
			}
		}
	}
}