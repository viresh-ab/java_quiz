import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JavaQuiz extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	JavaQuiz(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Mark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Mark"))
		{
			JButton bk=new JButton("Mark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Mark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Q1: What is the size of double variable?");
			jb[0].setText("8 bit");jb[1].setText("12 bit");jb[2].setText("32 bit");jb[3].setText("64 bit");	
		}
		if(current==1)
		{
			l.setText("Q2: Which Set class should be most popular in a multi-threading environment, considering performance constraint?");
			jb[0].setText(" HashSet");jb[1].setText(" ConcurrentSkipListSet");jb[2].setText(" LinkedHashSet");jb[3].setText("CopyOnWriteArraySet");
		}
		if(current==2)
		{
			l.setText("Q3: Which Map class should be most popular in a multi-threading environment, considering performance constraint?");
			jb[0].setText("Hashtable");jb[1].setText(" CopyOnWriteMap");jb[2].setText("ConcurrentHashMap");jb[3].setText("ConcurrentMap");
		}
		if(current==3)
		{
			l.setText("Q4: Which allows the removal of elements from a collection?");
			jb[0].setText("Enumeration");jb[1].setText("Iterator");jb[2].setText("Both");jb[3].setText("None of the above");
		}
		if(current==4)
		{
			l.setText("Q5: Automatic type conversion is possible in which of the possible cases?");
			jb[0].setText("Byte to Int");jb[1].setText("Int to Long");jb[2].setText("Long to Int");jb[3].setText("Short to int");
		}
		if(current==5)
		{
			l.setText("Q6: When is the object created with new keyword?");
			jb[0].setText("At run time");jb[1].setText("At compile time");jb[2].setText("Depends on the code");jb[3].setText("None");
		}
		if(current==6)
		{
			l.setText("Q7: compareTo() returns");
			jb[0].setText("True");jb[1].setText("False");jb[2].setText("An int value");jb[3].setText("None");
		}
		if(current==7)
		{
			l.setText("Q8: To which of the following does the class string belong to.");
			jb[0].setText("java.lang");jb[1].setText("java.awt");jb[2].setText("java.applet");jb[3].setText("java.string");		
		}
		if(current==8)
		{
			l.setText("Q9: Identify the return type of a method that does not return any value.");
			jb[0].setText("init");jb[1].setText("void");jb[2].setText("double");jb[3].setText("none");
		}
		if(current==9)
		{
			l.setText("Q10: Output of Math.floor(3.6)?");
			jb[0].setText("3");jb[1].setText("3.0");jb[2].setText("4");jb[3].setText("4.0");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[3].isSelected());
		if(current==1)
			return(jb[1].isSelected());
		if(current==2)
			return(jb[1].isSelected());
		if(current==3)
			return(jb[3].isSelected());
		if(current==4)
			return(jb[1].isSelected());
		if(current==5)
			return(jb[0].isSelected());
		if(current==6)
			return(jb[2].isSelected());
		if(current==7)
			return(jb[0].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[1].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new JavaQuiz("Java Online Quiz");
	}


}
