package am.aua.checkers.ui;
import java.awt.Color;

import javax.swing.*;

import am.aua.checkers.core.*;
/**
 * 
 * @author Arman Khachatryan
 * @referance Arman Khachatryan's HW 10
 */

public class BoardSquare extends JButton {
	/**
	 * 
	 */
	public static final Color dark = Color.black;
	public static final Color light= Color.white;
	int x;
	int y;
	Color c;
	BoardSquare(boolean f, int x, int y){
		this.x=x;
		this.y=y;
		if(f) {
			this.c=light;
		}
		else {
			this.c=dark;
		}
	}
	public int[] getCordinatesBoard(){
		int[] a= new int[2];
		a[0]=this.x;
		a[1]=this.y;
		return a;
	}
	public void setPiece(String a) {
		JButton button=null;
		try{switch (a.charAt(0)) {
        case 'M':
            ImageIcon ManW=new ImageIcon("ManW.png");
            button=new JButton(ManW);
            break;
        case 'K':
        	ImageIcon KingW=new ImageIcon("KingW.png");
            button=new JButton(KingW);
            break;
        case 'm':
            ImageIcon ManB=new ImageIcon("ManB.png");
            button=new JButton(ManB);
            break;
        case 'k':
        	ImageIcon KingB=new ImageIcon("KingB.png");
            button=new JButton(KingB);
            break;
        default:
        	throw new IllegalArrangementException();
    }
	}catch(IllegalArrangementException e){
        	System.out.println("illegal character");
	}
	}
	public void setPiece() {
		ImageIcon def=new ImageIcon();
        JButton button=new JButton(def);
	}
	public void setHighlight(boolean f) {
		if(!f) {
			this.setBackground(Color.red);
		}
		else {
			this.setBackground(this.c);
		}
	}
	
}
