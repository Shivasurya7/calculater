package calculater;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class calculater extends JFrame implements ActionListener, FocusListener{
	JPanel p1,p2,p3,p4;
	JTextField l;
	JTextField r;
	JTextField a;
	JButton n[];
	JButton p,s,m,d,f,c,o,e;
	boolean lf=false,rf=false;
	calculater(){
		p1 = new JPanel();
		p1.setLayout(new GridLayout());
		l = new JTextField(9);
		l.addFocusListener(this);
		p1.add(l);
		o = new JButton();
		p1.add(o);
		r = new JTextField(9);
		r.addFocusListener(this);
		p1.add(r);
		e = new JButton("=");
		p1.add(e);
		a = new JTextField(9);
		p1.add(a);
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(2,3));
		n = new JButton[10];
		for(int i = 0; i < 10; i++) {
			n[i] = new JButton(""+i);
			n[i].addActionListener(this);
			p2.add(n[i]);
		}
		
		p3 = new JPanel();
		p3.setLayout(new GridLayout(2,2));
		p = new JButton("➕");
		p.addActionListener(this);
		p3.add(p);
		s = new JButton("➖");
		s.addActionListener(this);
		p3.add(s);
		m = new JButton("✕");
		m.addActionListener(this);
		p3.add(m);
		d = new JButton("➗");
		d.addActionListener(this);
		p3.add(d);
		
		p4 = new JPanel();
		p4.setLayout(new GridLayout(1,2));
		f = new JButton("=");
		f.addActionListener(this);
		p4.add(f);
		c = new JButton("C");
		c.addActionListener(this);
		p4.add(c);
		
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		
		setVisible(true);
		setSize(400,400);
		setTitle("CALCULATER");
		setLayout(new GridLayout(4,1));
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent k) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String args[]) {
		new calculater();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == f) {
			calculate(o.getText());
		}
		else if(e.getSource() == c) {
			l.setText("");
			o.setText("");
			r.setText("");
			a.setText("");
		}
		else if(e.getSource() == p) {
			o.setText("➕");
		}
		else if(e.getSource() == s) {
			o.setText("➖");
		}
		else if(e.getSource() == m) {
			o.setText("✕");
		}
		else if(e.getSource() == d) {
			o.setText("➗");
		}
		
		
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == n[i]) {
				paint(""+i);
				break;
			}
		}
	}
	public void focusGained(FocusEvent e) {
		if(e.getSource() == l) {
			rf = false;
			lf = true;
		}
		if(e.getSource() == r) {
			rf = true;
			lf = false;
		}
		
	}
	public void focusLost(FocusEvent e) {}
	
	public void paint(String c) {
		if(lf) {
			String temp = l.getText();
			l.setText(temp+c);
		}
		if(rf) {
			String temp = r.getText();
			r.setText(temp+c);
		}
	}
	
	public void calculate(String s) {
		int op1,op2;
		op1 = Integer.parseInt(l.getText());
		op2 = Integer.parseInt(r.getText());
		if(s.charAt(0) == '➕') {
			a.setText(""+(op1+op2));
		}
		else if(s.charAt(0) == '➖') {
			a.setText(""+(op1-op2));
		}
		else if(s.charAt(0) == '✕') {
			a.setText(""+(op1*op2));	
		}
		else if(s.charAt(0) == '➗') {
			if(op2 == 0) {
				a.setText("ERROR");
			}
			else {
				a.setText(""+(op1/op2));
			}
		}
	}
	
}
