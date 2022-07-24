package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */

	JFrame frame = new JFrame();
	
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack <String> letters = new Stack();
	
	public static void main(String[] args) {
		new _02_TextUndoRedo().setup();
}
	
	void setup(){

		frame.setVisible(true);
		
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		String letter = label.getText() + e.getKeyChar();
		if (e.getKeyCode() != 8 && e.getKeyCode() != 10) {
		label.setText(letter);
		}
		
		if (e.getKeyCode() == 8) {
		letters.push(label.getText().substring(label.getText().length()-1));
		String backspace = label.getText().substring(0, label.getText().length()-1);
		label.setText(backspace);
		}
		
		if (e.getKeyCode() == 10 && !letters.isEmpty()) {
		String enter = label.getText() + letters.pop();
		label.setText(enter);
		}
		
		frame.pack();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}