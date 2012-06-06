import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.print.*;
import java.util.StringTokenizer;

class Editor extends JFrame
{
	//declaring all the required components
	private javax.swing.JMenuItem AboutUs;
    private javax.swing.JRadioButtonMenuItem BrailletoText;
    private javax.swing.JMenuItem Copy;
    private javax.swing.JMenuItem Cut;
    private javax.swing.JMenuItem Delete;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem Find;
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem Paste;
    private javax.swing.JMenuItem PrintBraille;
    private javax.swing.JMenuItem PrintText;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem SelectAll;
    private javax.swing.JTextArea TextArea1;
    private javax.swing.JTextArea TextArea2;
    private javax.swing.JRadioButtonMenuItem TexttoBraille;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
	//declaring the required global variables
	private String selectedText="";
	private String fname="";
	private boolean IsEdited=false;
	boolean edited=false;
//declaring the constructor
public Editor()
{
		super("Editor");
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextArea2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        Open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Cut = new javax.swing.JMenuItem();
        Copy = new javax.swing.JMenuItem();
        Paste = new javax.swing.JMenuItem();
        SelectAll = new javax.swing.JMenuItem();
        Find = new javax.swing.JMenuItem();
        Delete = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        PrintText = new javax.swing.JMenuItem();
        PrintBraille = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        BrailletoText = new javax.swing.JRadioButtonMenuItem();
        TexttoBraille = new javax.swing.JRadioButtonMenuItem();
        Help = new javax.swing.JMenu();
        AboutUs = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setSize(600,600);

        TextArea1.setColumns(20);
        TextArea1.setFont(new java.awt.Font("Braille", 0, 24)); 
        TextArea1.setRows(5);
        TextArea1.setMaximumSize(getMaximumSize());
        TextArea1.setMinimumSize(getMaximumSize());
        TextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextArea1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TextArea1);

        TextArea2.setColumns(20);
        TextArea2.setEditable(false);
        TextArea2.setFont(new java.awt.Font("Times New Roman", 0, 24));
        TextArea2.setRows(3);
        TextArea2.setMaximumSize(getMaximumSize());
        TextArea2.setMinimumSize(getMaximumSize());
        jScrollPane2.setViewportView(TextArea2);

        jMenu1.setText("File");

        New.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        jMenu1.add(New);

        Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });        
		jMenu1.add(Open);

        Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });		
        jMenu1.add(Save);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenu1.add(Exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        Cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        Cut.setText("Cut");
        Cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutActionPerformed(evt);
            }
        });
		jMenu2.add(Cut);

        Copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        Copy.setText("Copy");
        Copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyActionPerformed(evt);
            }
        });
		jMenu2.add(Copy);

        Paste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        Paste.setText("Paste");
        Paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasteActionPerformed(evt);
            }
        });
        jMenu2.add(Paste);

        SelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        SelectAll.setText("Select All");
        SelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectAllActionPerformed(evt);
            }
        });
        jMenu2.add(SelectAll);

        Find.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        Find.setText("Find");
        Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindActionPerformed(evt);
            }
        });
        jMenu2.add(Find);

        Delete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jMenu2.add(Delete);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Print");
		
        PrintText.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        PrintText.setText("Print Text");
        PrintText.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            PrintActionPerformed(evt);
        }
        });		        
		jMenu3.add(PrintText);

        PrintBraille.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        PrintBraille.setText("Print Braille");
        PrintBraille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });           
		jMenu3.add(PrintBraille);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Action");

        BrailletoText.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK));
        buttonGroup1.add(BrailletoText);
        BrailletoText.setSelected(true);
        BrailletoText.setText("Braille to Text");
        BrailletoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrailletoTextActionPerformed(evt);
            }
        });
        jMenu4.add(BrailletoText);

        TexttoBraille.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK));
        buttonGroup1.add(TexttoBraille);
        TexttoBraille.setText("Text to Braille");
        TexttoBraille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TexttoBrailleActionPerformed(evt);
            }
        });
        jMenu4.add(TexttoBraille);

        jMenuBar1.add(jMenu4);

        Help.setText("Help");

        AboutUs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        AboutUs.setText("About Us");
        AboutUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutUsActionPerformed(evt);
            }
        });
        Help.add(AboutUs);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);
		Container c=getContentPane();
		GridLayout g=new GridLayout(2,1);
		c.setLayout(g);
		g.setVgap(5);
		c.add(jScrollPane1);
		c.add(jScrollPane2);
	}//end of contructor
	boolean isSymbolMode=false;
	//method that reflects the changes in textarea1 to textarea2
    private void TextArea1KeyReleased(java.awt.event.KeyEvent evt) {
	
		edited=true;
        if(isBraille)
        {
            //handling braille text
			if(evt.getKeyCode()==8 || evt.getKeyCode()==127)
			{
			//handle backspace and delete key
			int i=TextArea1.getSelectionStart();
			String s=TextArea1.getText();
			s=s.substring(0,i)+s.substring(i,s.length());
			TextArea1.setText(s);
			if(i<TextArea2.getText().length())
				TextArea2.setText(s.substring(0,TextArea2.getText().length()-1));
			}
			else if(evt.getKeyChar()==' ')
			{
			int p=TextArea2.getText().length();
			String s=TextArea1.getText().substring(p,TextArea1.getText().length());
			if(s.length()>6)
			{
			//beep sound
			TextArea1.setText(TextArea2.getText());
			}
			else
			{
				char ch[]=new char[6];
				int b1;
				String str;
				for(int i=0;i<s.length()-1;i++)
					ch[i]=s.charAt(i);
				if((b1=binConvert(ch))!=0)
					str=connectCSV(b1);
				else
					str=" ";
				TextArea2.append(str);
				TextArea1.setText(TextArea2.getText());
			}
			}
			else if(evt.getKeyCode()==118)
			{
			//handle symbol mode
			if(isSymbolMode)
				isSymbolMode=false;
			else
				isSymbolMode=true;
			}
			else if(!(evt.getKeyCode()==70||evt.getKeyCode()==68||evt.getKeyCode()==83||evt.getKeyCode()==74||evt.getKeyCode()==75||evt.getKeyCode()==76))
			{
			//beep	
			}
        }
        else
        {
            //TextArea1.setText(String.valueOf(evt.getKeyCode()));
			TextArea2.setText(TextArea1.getText());
        }    
	}//end of TextArea1KeyReleased
	
	//method for the Exit option in the File Menu
	private void ExitActionPerformed(java.awt.event.ActionEvent evt) {
    
		System.exit(0);

	}//End of Exit Operation
	
	//method for Braille to Text Operation in the Action Menu
    private void BrailletoTextActionPerformed(java.awt.event.ActionEvent evt) {
		if(confirmSave(evt))
		{
		TextArea1.setText("");
        TextArea2.setText("");
        Font f=new Font("Braille",0,24);
        TextArea1.setFont(f);        
        TextArea2.setFont(new Font("Times New Roman",0,24));
		isBraille=true;
		}
	}//End of BrailletoTextActionPErformed
	
	//method for Text to Braille Operation in the Action Menu
    private void TexttoBrailleActionPerformed(java.awt.event.ActionEvent evt) {
		if(confirmSave(evt))
		{		
		TextArea1.setText("");
        TextArea2.setText("");
        Font f=new Font("Times New Roman",0,24);
        TextArea1.setFont(f);       
        TextArea2.setFont(new Font("Braille",0,24));
		isBraille=false;
		}
	}//End of TexttoBrailleActionPerformed
	
	//method for displaying the about us content, AboutUs Option in the Help Menu
    private void AboutUsActionPerformed(java.awt.event.ActionEvent evt) {
	
        JOptionPane.showMessageDialog(null,"\nWe Ananth, Laxmi and Saradi, developed this application as a part of our acadamic mini-project.\n Thank you for using this.", "About Us",JOptionPane.INFORMATION_MESSAGE);
    
	}//End of AboutUsActionPerformed
	
	//method for Selecting all the text in TextArea1, SelectAll Option in the Edit Menu
    private void SelectAllActionPerformed(java.awt.event.ActionEvent evt) {
	
        TextArea1.setSelectionStart(0);
        TextArea1.setSelectionEnd(TextArea1.getText().length());

	}//End of SelectAllActionPerformed
	
	//method for finding the first occurence of a given word, Find Operation in the Edit Menu
    private void FindActionPerformed(java.awt.event.ActionEvent evt) {
	
		String value=JOptionPane.showInputDialog("Enter the text to search :");
        String content=TextArea1.getText();
        int i=0,j=0,l=content.length();
        String str="";
        while(i<l)
        {
            str="";
            j=i;
            while((content.charAt(j)!=' ')&& j<l)
            {               
                str+=String.valueOf(content.charAt(j));
                j++;
            }
            if(value.equalsIgnoreCase(str))
            {
                TextArea1.setSelectionStart(i);
                TextArea1.setSelectionEnd(j);
                break;
            }
            i=j+1;
        }        
		
    }//End of FindActionPerformed

	//function for new option in the file menu
	private void NewActionPerformed(java.awt.event.ActionEvent evt)
	{
		if(confirmSave(evt))
		{
			TextArea1.setText("");
			TextArea2.setText("");
			edited=false;
		}
	}//end of new option

	//function for open option in the file menu
	private void OpenActionPerformed(java.awt.event.ActionEvent evt)
	{
		if(confirmSave(evt))
		{
		try
		{
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(Editor.this);

        if (returnVal == JFileChooser.APPROVE_OPTION)
		{
            File file = fc.getSelectedFile();
            //This is where a real application would open the file.
			fname= fc.getCurrentDirectory()+"\\"+file.getName();
            FileReader fr= new FileReader(fname);
			String text = "";
			int ch=fr.read();
			while(ch!=-1)
			{
				text+=String.valueOf((char)ch);
				ch=fr.read();
			}
			fr.close();
			TextArea1.setText(text);
			TextArea2.setText(text);
			edited=false;
        } 
		else
		{
            //do nothing
        }
		}
		catch(Exception e)
		{
		JOptionPane.showMessageDialog(null,e.getMessage(), "About Us",JOptionPane.INFORMATION_MESSAGE);
		}
		}
	}//end of open function

	//function for save option in the file menu
	private void SaveActionPerformed(java.awt.event.ActionEvent evt)
	{
		try
		{
		int returnVal=-1;
		JFileChooser fc=null;
		if(fname.equals(""))
		{
		fc = new JFileChooser();
		returnVal = fc.showSaveDialog(Editor.this);
		}
        if (returnVal == JFileChooser.APPROVE_OPTION )
		{
            File file = fc.getSelectedFile();
            //This is where a real application would open the file.
			fname= fc.getCurrentDirectory()+"\\"+file.getName();
		}
		if(!fname.equals(""))
		{
            FileWriter fr= new FileWriter(fname);
			String text = TextArea1.getText();
			fr.write(text);
			fr.close();
			edited=false;
		} 
		}
		catch(Exception e)
		{
		JOptionPane.showMessageDialog(null,e.getMessage(), "About Us",JOptionPane.INFORMATION_MESSAGE);
		}
	}//end of save option

	//function for cut option in the file menu
	private void CutActionPerformed(java.awt.event.ActionEvent evt)
	{
		int i=TextArea1.getSelectionStart();
		int j=TextArea1.getSelectionEnd();
		String str=TextArea1.getText();		
		selectedText=str.substring(i,j);
		str=str.substring(0,i)+str.substring(j,str.length());
		TextArea1.setText(str);
		TextArea2.setText(str);
	}//end of cut option

	//function for copy option in the file menu
	private void CopyActionPerformed(java.awt.event.ActionEvent evt)
	{
		int i=TextArea1.getSelectionStart();
		int j=TextArea1.getSelectionEnd();
		String str=TextArea1.getText();
		selectedText=str.substring(i,j);
	}//end of copy option

	//function for paste option in the file menu
	private void PasteActionPerformed(java.awt.event.ActionEvent evt)
	{
		int i=TextArea1.getSelectionStart();
		int j=TextArea1.getSelectionEnd();
		String str=TextArea1.getText();
		str=str.substring(0,i)+selectedText+str.substring(j,str.length());
		TextArea1.setText(str);
		TextArea2.setText(str);		
	
	}//end of Paste option
	
	//function for delete option in the edit menu
	private void DeleteActionPerformed(java.awt.event.ActionEvent evt)
	{
		int i=TextArea1.getSelectionStart();
		int j=TextArea1.getSelectionEnd();
		String str=TextArea1.getText();
		str=str.substring(0,i)+str.substring(j,str.length());
		TextArea1.setText(str);
		TextArea2.setText(str);		
	}//end of delete option in the file menu
	
	//function to save in between
	private boolean confirmSave(java.awt.event.ActionEvent evt)
	{	
		if((!TextArea1.getText().equals("") || !fname.equals("")) && edited)
		{
			int c=JOptionPane.showConfirmDialog(null,"save the previous one?","save",1);
			if(c==0)
			{
				SaveActionPerformed(evt);					
			}
			else if(c==1)
			{
			//do nothing
			}
			else
			{
			return false;
			}					
		}
		fname="";
		return true;
	}//end of conform save
	
	//Global variables here
    boolean isBraille=true;
    String s1=null;
	//function for convert character to binary
	public int binConvert(char[] c)
	{
		int[] bin1=new int[6];
         int[] n={100000,10000,1000,100,10,1};
           int b1=0;
            for(int j1=0;j1<6;j1++)
            {
                if(c[j1]=='f' || c[j1]=='F')
                    bin1[0]=1;
                if(c[j1]=='d' || c[j1]=='D')
                    bin1[1]=1;
                if(c[j1]=='s' || c[j1]=='S')
                    bin1[2]=1;
                if(c[j1]=='j' || c[j1]=='J')
                    bin1[3]=1;
                if(c[j1]=='k' || c[j1]=='K')
                    bin1[4]=1;
                if(c[j1]=='l' || c[j1]=='L')
                    bin1[5]=1;
            }

            for(int j=0;j<6;j++)
            {
                b1=b1+(bin1[j]*n[j]);
            }
                for(int j=0;j<6;j++)
                    bin1[j]=0;
			//TextArea2.setText(String.valueOf(b1));
			return b1;
	}
	//Connecting to csv file 
	public String connectCSV(int b1)
    {
          char[] q=new char[2];
          int b = 0;
          int i=0;
        try {
            FileReader fr = null;
            String file = "D:/Braille.csv";
            String line;
			int lp=0;
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null)
            {
                StringTokenizer str = new StringTokenizer(line, ",");
                s1 = str.nextToken();
                b = Integer.parseInt(s1);
                if (!str.hasMoreTokens())
                {
                    s1 = ",";
                } else
                {
                    s1 = str.nextToken();
                }
				if(b==b1)
                {
                    if(isSymbolMode)
					{
						if(lp==1)
							break;
						lp=1;
					}
					else
						break;
                }
				else
				{
					if(lp==1)
					{
					s1="";
					break;
					}
				}
            }
        } 
		catch (IOException ex) 
		{  
			JOptionPane.showMessageDialog(null,ex.getMessage(), "About Us",JOptionPane.INFORMATION_MESSAGE);
        }
        return s1.toLowerCase();
    }
	
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException 
	{
        if (page > 0) { // We have only one page, and 'page' is zero-based
            return 0;
        }
        //User (0,0) is typically outside the imageable area, so we must
		//translate by the X and Y values in the PageFormat to avoid clipping
		//
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        //Now we perform our rendering
        g.drawString("Hello world!", 100, 100);
        //tell the caller that this page is part of the printed document 
        return 1;
    }

	
	//function for printtext/printbraille in the print menu
	private void PrintActionPerformed(java.awt.event.ActionEvent evt)
	{
		PrinterJob pj=PrinterJob.getPrinterJob();		
		if(pj.printDialog())
		{
		try
		{
			pj.print();
		}
		catch(PrinterException e)
		{		
			JOptionPane.showMessageDialog(null,e.getMessage(), "About Us",JOptionPane.INFORMATION_MESSAGE);
		}
		}
	}//end of PrintActionPerformed
	//the main method
	public static void main(String args[]) {	
		new Editor().setVisible(true);	
	}//end of main method
}