package in.ajay.AnnieProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.apache.hc.client5.http.impl.classic.MainClientExec;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataForm extends JFrame {
	 public static String multiplier[] = { "", "Trillion", "Billion",
	            "Million", "Thousand" };

	    // Array to store numbers till 20
	    public static String first_twenty[] = {
	            "",	 "One",	 "Two",	 "Three",
	            "Four", "Five",	 "Six",	 "Seven",
	            "Eight", "Nine",	 "Ten",	 "Eleven",
	            "Twelve", "Thirteen", "Fourteen", "Fifteen",
	            "Sixteen", "Seventeen", "Eighteen", "Nineteen"
	    };
	    public static String ten[] = {
	            "Zero",	 "One",	 "Two",	 "Three",
	            "Four", "Five",	 "Six",	 "Seven",
	            "Eight", "Nine"
	    };

	    // Array to store multiples of ten
	    public static String tens[] = { "",	 "Twenty", "Thirty",
	            "Forty", "Fifty", "Sixty",
	            "Seventy", "Eighty", "Ninety" };

	private JPanel CenterPanel;
	private JPanel leftPanel;
	private JPanel bottomPanel,topPanel;
	private JButton submit;
	private JTextField FileNo,FormNo,Title,FirstName,LastName,Initial,Email,Fathername,DOB,Gender,Profession,MailingStreet,
	MailingCity,MailingPostalCode,MailingCountry,ServiceProvider,Fileno2,ReferenceNumber,SimNo,TypeOfNetwork,CellModelNumber,IMMEI1,
	IMMEI2,TypeOfPlan,CreditCardType,ContactValue,DateOfIssue,DateOfRenewal,Installments,AmountInWords,Remarks;
	
	private JLabel fileNo,formNo,title,firstName,lastName,initial,email,fathername,dOB,gender,profession,mailingStreet,
	mailingCity,mailingPostalCode,mailingCountry,serviceProvider,fileno2,referenceNumber,simNo,typeOfNetwork,cellModelNumber,iMMEI1,
	iMMEI2,typeOfPlan,creditCardType,contactValue,dateOfIssue,dateOfRenewal,installments,amountInWords,remarks;
	 
	private JTextField [] textfield = {FileNo,FormNo,Title,FirstName,LastName,Initial,Email,Fathername,DOB,Gender,Profession,MailingStreet,
			MailingCity,MailingPostalCode,MailingCountry,ServiceProvider,Fileno2,ReferenceNumber,SimNo,TypeOfNetwork,CellModelNumber,IMMEI1,
			IMMEI2,TypeOfPlan,CreditCardType,ContactValue,DateOfIssue,DateOfRenewal,Installments,AmountInWords,Remarks};
	private JLabel []  label = {fileNo,formNo,title,firstName,lastName,initial,email,fathername,dOB,gender,profession,mailingStreet,
			mailingCity,mailingPostalCode,mailingCountry,serviceProvider,fileno2,referenceNumber,simNo,typeOfNetwork,cellModelNumber,iMMEI1,
			iMMEI2,typeOfPlan,creditCardType,contactValue,dateOfIssue,dateOfRenewal,installments,amountInWords,remarks};
	private JButton login,forms,reports,logout,inibutton,instacal,reset;
	private WebDriver driver;
	private WebElement drop;
	private Select option;
	
	public DataForm() {
		

		setTitle("-----Data Entry Form-------");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLayout(new BorderLayout());
		
	
		// -----------------label-close-----------------------//
		

		forms = new JButton("Forms");
		forms.addActionListener(e -> driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]")).click());
		buttonProperties(forms);

		login = new JButton("Login");
		buttonProperties(login);
		login.addActionListener(e -> {
			driver = new ChromeDriver();
			driver.get("https://server360filesdatabackup.com/");
			driver.findElement(By.name("username")).sendKeys("mrajesh90");
			 driver.findElement(By.name("password")).sendKeys("Raji@123");
			 drop = driver.findElement(By.name("branch")); 
			 
			 option=new Select(drop);
			 option.selectByVisibleText("SERVER 5");
			 
			 driver.findElement(By.name("login")).click();
			
			
			
			System.out.println("login");});
		
		logout = new JButton("Logout");
		buttonProperties(logout);
		logout.addActionListener(e -> {
			 // Display confirmation dialog
            int result = JOptionPane.showConfirmDialog(DataForm.this,
                    "Confirm Logout?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
            	driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[4]")).click();
            	driver.close();
                // Perform actions upon confirmation (you can customize this part)
            
                System.out.println("logout");
            }
		});
		
		reports = new JButton("Reports");
		buttonProperties(reports);
		reports.addActionListener(e -> driver.findElement(By.cssSelector("i[class='glyphicon glyphicon-stats text-red']")).click());
		CenterPanel = new JPanel();
		CenterPanel.setLayout(new GridLayout(31,1));
		CenterPanel.setPreferredSize(new Dimension(100, 1000));
		CenterPanel.setBackground(Color.white);
		
		
		//-----------------button-close------------------------//
		
		/*FileNo,FormNo,Title,FirstName,LastName,Initial,Email,Fathername,DOB,Gender,Profession,MailingStreet,
		MailingCity,MailingPostalCode,MailingCountry,ServiceProvider,Fileno2,ReferenceNumber,SimNo,TypeOfNetwork,CellModelNumber,IMMEI1,
		IMMEI2,TypeOfPlan,CreditCardType,ContactValue,DateOfIssue,DateOfRenewal,Installments,AmountInWords,Remarks;*/
		String[] labelname = {"FileNo","FormNo","Title","FirstName","LastName","Initial","Email","Fathername","DOB","Gender","Profession","MailingStreet",
		"MailingCity","MailingPostalCode","MailingCountry","ServiceProvider","Fileno2","ReferenceNumber","SimNo","TypeOfNetwork","CellModelNumber","IMMEI1",
		"IMMEI2","TypeOfPlan","CreditCardType","ContactValue","DateOfIssue","DateOfRenewal","Installments","AmountInWords","Remarks"};
		for(int i=0;i<label.length;i++) {
			label[i]=labelcreat(label[i],labelname[i]);
			CenterPanel.add(label[i]);
			textfield[i]=textFieldCreate(textfield[i]);
			CenterPanel.add(textfield[i]);
			CenterPanel.add(Box.createHorizontalStrut(30));
		}
		submit = new JButton("Submit");
		buttonProperties(submit);
		submit.addActionListener(e -> {
			 // Display confirmation dialog
            int result = JOptionPane.showConfirmDialog(DataForm.this,
            		"Are you sure you want to submit the form?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
            	
            	try {
            	/*private JTextField [] textfield = {FileNo,FormNo,Title,FirstName,LastName,Initial,Email,Fathername,DOB,Gender,Profession,MailingStreet,
            			MailingCity,MailingPostalCode,MailingCountry,ServiceProvider,Fileno2,ReferenceNumber,SimNo,TypeOfNetwork,CellModelNumber,IMMEI1,
            			IMMEI2,TypeOfPlan,CreditCardType,ContactValue,DateOfIssue,DateOfRenewal,Installments,AmountInWords,Remarks};*/
            	driver.findElement(By.name("file_no")).sendKeys(textfield[0].getText());
            	driver.findElement(By.name("form_no")).sendKeys(textfield[1].getText());
            	driver.findElement(By.name("title")).sendKeys(textfield[2].getText());
            	driver.findElement(By.name("first")).sendKeys(textfield[3].getText());
            	driver.findElement(By.name("last")).sendKeys(textfield[4].getText());
            	driver.findElement(By.name("initial")).sendKeys(textfield[5].getText());
            	driver.findElement(By.name("email")).sendKeys(textfield[6].getText());
            	driver.findElement(By.name("father")).sendKeys(textfield[7].getText());
            	driver.findElement(By.name("dob")).sendKeys(textfield[8].getText());
            	driver.findElement(By.name("gender")).sendKeys(textfield[9].getText());
            	driver.findElement(By.name("profession")).sendKeys(textfield[10].getText());
            	driver.findElement(By.name("street")).sendKeys(textfield[11].getText());
            	driver.findElement(By.name("city")).sendKeys(textfield[12].getText());
            	driver.findElement(By.name("postal_code")).sendKeys(textfield[13].getText());
            	driver.findElement(By.name("country")).sendKeys(textfield[14].getText());
            	driver.findElement(By.name("service_provider")).sendKeys(textfield[15].getText());
            	driver.findElement(By.name("file")).sendKeys(textfield[16].getText());
            	driver.findElement(By.name("reference")).sendKeys(textfield[17].getText());
            	driver.findElement(By.name("sim_no")).sendKeys(textfield[18].getText());
            	driver.findElement(By.name("network")).sendKeys(textfield[19].getText());
            	driver.findElement(By.name("cell")).sendKeys(textfield[20].getText());
            	driver.findElement(By.name("immei_1")).sendKeys(textfield[21].getText());
            	driver.findElement(By.name("immei_2")).sendKeys(textfield[22].getText());
            	driver.findElement(By.name("plan")).sendKeys(textfield[23].getText());
            	driver.findElement(By.name("credit")).sendKeys(textfield[24].getText());
            	driver.findElement(By.name("contact")).sendKeys(textfield[25].getText());
            	driver.findElement(By.name("date_issue")).sendKeys(textfield[26].getText());
            	driver.findElement(By.name("date_renewal")).sendKeys(textfield[27].getText());
            	driver.findElement(By.name("installments")).sendKeys(textfield[28].getText());
            	driver.findElement(By.name("words")).sendKeys(textfield[29].getText());
            	driver.findElement(By.name("remarks")).sendKeys(textfield[30].getText());
            	
            	driver.findElement(By.id("daterange-btn"));
            	System.out.println(textfield[0].getText());
            	for(JTextField m:textfield) {
            		
            		m.setText("");
            		
            	}
            	textfield[30].setText("Not Applicable");
            	
            	JOptionPane.showMessageDialog(DataForm.this, "Form submitted successfully!");
            	}catch(NoSuchElementException l) {
            		JOptionPane.showMessageDialog(DataForm.this, "Go to FORMS to submit");
            	}
                // Perform actions upon confirmation (you can customize this part)
            	
                
            }
		});
		
		inibutton = new JButton("initial");
		smallButtonProperties(inibutton);
		inibutton.addActionListener(e -> {
			try {
			char tit=textfield[2].getText().charAt(0);
			char fn=textfield[3].getText().charAt(0);
			char ln=textfield[4].getText().charAt(0);
			textfield[5].setText(""+tit+fn+ln);
			}catch(Exception r) {
				
			}
			
			
		});
		
		reset = new JButton("Reset");
		smallButtonProperties(reset);
		reset.addActionListener(e -> {
			for(JTextField m:textfield) {
        		
        		m.setText("");
        		
        	}
		});
		
		
		instacal = new JButton("Calc");
		smallButtonProperties(instacal);
		
		instacal.addActionListener(e -> {
			try {
				String fdate = textfield[26].getText().trim();
				String ldate = textfield[27].getText().trim();
				int fd = Integer.parseInt(fdate.substring(fdate.length()-4));
				int ld = Integer.parseInt(ldate.substring(ldate.length()-4)); 
				int mon = (ld-fd)*12;
				//System.out.println(mon);
				 int con = Integer.parseInt(textfield[25].getText());
				 
				 double x = ((double) con / mon)+10.33;
					
					DecimalFormat df = new DecimalFormat(".00");
					df.setRoundingMode(RoundingMode.DOWN);
					
					double d = Double.parseDouble(df.format(x));				
				 textfield[28].setText(df.format(x));
				 textfield[29].setText(convertNumberToWords(d));
				 
				
			}catch(Exception r) {
				
				JOptionPane.showMessageDialog(DataForm.this,r.toString() );
			}
			
			
		});
		
		
		// ----------------panel-----------------------------//


		

		leftPanel = new JPanel();
//		leftPanel.setLayout(new FlowLayout());
		leftPanel.setPreferredSize(new Dimension(200, 40));
		leftPanel.setBackground(Color.gray);
		
		bottomPanel = new JPanel();
		//bottomPanel.setLayout(new FlowLayout());
		bottomPanel.setPreferredSize(new Dimension(200, 50));
		bottomPanel.setBackground(new Color(180,180,180));

		leftPanel.add(login);
		leftPanel.add(forms);
		leftPanel.add(reports);
		leftPanel.add(inibutton);
		leftPanel.add(instacal);
		leftPanel.add(reset);
		bottomPanel.add(submit);
		leftPanel.add(reports);
		leftPanel.add(logout);
		
		
//		CenterPanel.add(FileNo);
		
		JScrollPane scrollpane = new JScrollPane(CenterPanel);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(scrollpane, BorderLayout.CENTER);
		add(leftPanel, BorderLayout.WEST);
		add(bottomPanel,BorderLayout.SOUTH);
		setVisible(true);
		System.out.println(textfield.length);
		System.out.println(label.length);
		

		// ---------------panel-close-----------------------//

//      

		// -----------button----------------//

	}
	static String decimalConvert(String s){
        
		int f=Integer.parseInt(s.charAt(0)+"");
		int l=Integer.parseInt(s.charAt(1)+"");

    return ten[f]+" "+ten[l];
	}
	 public static String convertNumberToWords(double number) {
		 
		 String [] ss = String.valueOf(number).split("\\.");
		 
	        int wholePart = (int) number;
	        //int decimalPart = (int) ((number - wholePart) * 100);



	        String words = numberToWords(wholePart) + "Point " + decimalConvert(ss[1]);
	        return words;
	    }
	 static String numberToWords(long n)
	    {
	        long limit = 1000000000000L, curr_hun, t = 0;

	        // If zero return zero
	        if (n == 0)
	            return ("Zero");

	        // Array to store the powers of 10

	        // If number is less than 20, return without any
	        // further computation
	        if (n < 20L)
	            return (first_twenty[(int)n]);
	        String answer = "";
	        for (long i = n; i > 0; i %= limit, limit /= 1000) {

	            // Store the value in multiplier[t], i.e n =
	            // 1000000, then r = 1, for multiplier(million),
	            // 0 for multipliers(trillion and billion)
	            // multiplier here refers to the current
	            // accessible limit
	            curr_hun = i / limit;

	            // It might be possible that the current
	            // multiplier is bigger than your number
	            while (curr_hun == 0) {

	                // Set i as the remainder obtained when n
	                // was divided by the limit
	                i %= limit;

	                // Divide the limit by 1000, shifts the
	                // multiplier
	                limit /= 1000;

	                // Get the current value in hundreds, as
	                // English system works in hundreds
	                curr_hun = i / limit;

	                // Shift the multiplier
	                ++t;
	            }

	            // If current hundred is greater than 99, Add
	            // the hundreds' place
	            if (curr_hun > 99)
	                answer += (first_twenty[(int)curr_hun / 100]
	                        + " Hundred ");

	            // Bring the current hundred to tens
	            curr_hun = curr_hun % 100;

	            // If the value in tens belongs to [1,19], add
	            // using the first_twenty
	            if (curr_hun > 0 && curr_hun < 20)
	                answer
	                        += (first_twenty[(int)curr_hun] + " ");

	                // If curr_hun is now a multiple of 10, but not
	                // 0 Add the tens' value using the tens array
	            else if (curr_hun % 10 == 0 && curr_hun != 0)
	                answer
	                        += (tens[(int)curr_hun / 10 - 1] + " ");

	                // If the value belongs to [21,99], excluding
	                // the multiples of 10 Get the ten's place and
	                // one's place, and print using the first_twenty
	                // array
	            else if (curr_hun > 20 && curr_hun < 100)
	                answer
	                        += (tens[(int)curr_hun / 10 - 1] + " "
	                        + first_twenty[(int)curr_hun % 10]
	                        + " ");

	            // If Multiplier has not become less than 1000,
	            // shift it
	            if (t < 4)
	                answer += (multiplier[(int)++t] + " ");
	        }
	        return (answer);
	    }
	public static void submitSelenium() {
		
	
	}
	public static JLabel labelcreat(JLabel label,String s) {
		label = new JLabel(s);
		labelProperties(label);
		return label;
		
	}
	public static JTextField textFieldCreate(JTextField textfiel) {
		
		textfiel = new JTextField();
		largeTextFieldProperties(textfiel);
		return textfiel;
		
		
	}
	
	public static void smallButtonProperties(JButton botton) {
		botton.setBounds(0,60,90,50);
		botton.setFocusable(false);
		botton.setBackground(new Color(200, 200, 200));
		botton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	}
	
	public static void buttonProperties(JButton button) {
		button.setPreferredSize(new Dimension(180, 50));
		button.setFocusable(false);
		button.setBackground(new Color(200, 200, 200));
		button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	}
	
	public static void labelProperties(JLabel label) {
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
	}
	public static void smallTextFieldProperties(JTextField text) {
		text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		text.setPreferredSize(new Dimension(100,40));
	}
	public static void largeTextFieldProperties(JTextField text) {
		text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		text.setPreferredSize(new Dimension(250,30));
	}
	public static void main(String[] args) {

		DataForm df = new DataForm();
		

	}

}
