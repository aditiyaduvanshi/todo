
import java.awt.*;
import java.awt.*;

import javax.swing.JFrame;
import java.awt.event.*;
import java.io.*;
public class Home extends Frame implements ActionListener,ItemListener{
	
	Panel p1,p2;
	Button b1,b2,b3,b4;
	TextArea ta1;
	Choice c1;
		
	    Home(){
		p1=new Panel();	
		p2=new Panel();
		b1=new Button(" + ");
		b2=new Button("save");
		b3=new Button("clear list");
		b4=new Button("dlt todo");
	    c1=new Choice();
	    ta1=new TextArea();
	     
	    b1.setFont(new Font("Courier",Font.BOLD,15));
	    ta1.setFont(new Font("Courier",Font.BOLD+Font.ITALIC,20));
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b4.addActionListener(this);
	    c1.addItemListener(this);
	    c1.add("todo list 1 ");
	    c1.add("todo list 2 ");
	    c1.add("todo list 3 ");
	    c1.add("todo list 4 ");
	    
	    Color c=new Color(246, 207, 171);
	    Color r=new Color(201, 197, 170);
	    Color o=new Color(0, 101, 102);
	    b1.setBackground(r);
	    b2.setBackground(r);
	    b3.setBackground(r);
	    b4.setBackground(r);
	    ta1.setForeground(o);
	    p1.add(c1);
	    p1.add(b2);
	    p1.add(b3);
	    p2.setBackground(c);
	    p1.setBackground(c);
	    p2.add(b1);
	    p2.add(b4);
	    add(p1,"North");
	    add(ta1);
	    add(p2,"South");
	    setBounds(30,30,700,500);
	    setTitle("first project");
	    setVisible(true);
	    
	    addWindowListener(new WindowAdapter()
	    {
	    	public void windowClosing(WindowEvent ae)
	    	{
	    		Frame f=(Frame)ae.getWindow();
	    		f.dispose();
	    	}
	    });

	    
		}
	    
	    public void actionPerformed(ActionEvent ae)
	    {
	    	Button b=(Button)ae.getSource();
	    	if(b==b3)
	    		ta1.setText("");
	    	else if(b==b1)
	    	{
	    		
	    		ta1.append("\n\n>");
	    	}
	    	else if(b==b4)
	    	{
	    		int k=ta1.getSelectionStart();
	    		int l;
	    		String k1=ta1.getText();
	    		for(l=(k+1);k1.charAt(l)!='\n';l++);
	    		ta1.replaceRange("", k+1, l);
	    		ta1.replaceRange("> --- completed ---", k, k+1);
	    	}
	    	else
	    	{
	    		try {
	    			if(c1.getSelectedItem()=="todo list 1 ")
	    			{
	    				BufferedWriter fileOut = new BufferedWriter(new FileWriter("a.txt")); 
	    				String myString1 =ta1.getText();
	    				fileOut.write(myString1);
	    				fileOut.close();
	    			}
	    			else if(c1.getSelectedItem()=="todo list 2 ")
	    			{
	    				BufferedWriter fileOut = new BufferedWriter(new FileWriter("b.txt")); 
	    				String myString1 =ta1.getText();
	    				fileOut.write(myString1);
	    				fileOut.close();
	    			}
	    			else if(c1.getSelectedItem()=="todo list 3 ")
	    			{
	    				BufferedWriter fileOut = new BufferedWriter(new FileWriter("c.txt")); 
	    				String myString1 =ta1.getText();
	    				fileOut.write(myString1);
	    				fileOut.close();
	    			}
	    			else
	    			{
	    				BufferedWriter fileOut = new BufferedWriter(new FileWriter("d.txt")); 
	    				String myString1 =ta1.getText();
	    				fileOut.write(myString1);
	    				fileOut.close();
	    			}
	    		} catch (IOException ioe) {
	    		    ioe.printStackTrace();
	    		}
	    	}
	    }
	    
	    public void itemStateChanged(ItemEvent ie)
		{	
			String s=c1.getSelectedItem();
			if(s.equals("todo list 1 "))
			{
				ta1.setText("");
				FileInputStream fis=null;
				try
				{
					fis=new FileInputStream("a.txt");
					int n;
					while((n=fis.read())!=-1)
					{   
						char a[]=new char[1];
						a[0]=(char)n;
						String s1=new String(a);
						ta1.append(s1);
					}
				}
				catch(FileNotFoundException e)
				{
				System.out.println(e.getMessage());
			    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}	
			else if(s.equals("todo list 2 "))
			{
				ta1.setText("");
				FileInputStream fis=null;
				try
				{
					fis=new FileInputStream("b.txt");
					int n;
					while((n=fis.read())!=-1)
					{   
						char a[]=new char[1];
						a[0]=(char)n;
						String s1=new String(a);
						ta1.append(s1);
					}
				}
				catch(FileNotFoundException e)
				{
				System.out.println(e.getMessage());
			    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(s.equals("todo list 3 "))
			{
				ta1.setText("");
				FileInputStream fis=null;
				try
				{
					fis=new FileInputStream("c.txt");
					int n;
					while((n=fis.read())!=-1)
					{   
						char a[]=new char[1];
						a[0]=(char)n;
						String s1=new String(a);
						ta1.append(s1);
					}
				}
				catch(FileNotFoundException e)
				{
				System.out.println(e.getMessage());
			    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				ta1.setText("");
				FileInputStream fis=null;
				try
				{
					fis=new FileInputStream("d.txt");
					int n;
					while((n=fis.read())!=-1)
					{   
						char a[]=new char[1];
						a[0]=(char)n;
						String s1=new String(a);
						ta1.append(s1);
					}
				}
				catch(FileNotFoundException e)
				{
				System.out.println(e.getMessage());
			    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	    	
	
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		new Home();
	}
}





