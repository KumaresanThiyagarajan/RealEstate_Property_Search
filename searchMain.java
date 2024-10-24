package propertySearch2;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class Node1{
	String name,phoneNumber,patta,docNo,location,landType,nearBy;
	double area,price;
	Node1 next;
	Node1(){
		next = null;
	}
}

class userData{
	Node1 head;
	userData(){
		head = null;
	}
	
	void addData(String landType,String nearBy,double area,double price,String name,String phoneNumber,String patta,String docNo,String location) {
		Node1 L = new Node1();
		L.landType = landType;
		L.nearBy = nearBy;
		L.area = area;
		L.price = price;
		L.name = name;
		L.phoneNumber = phoneNumber;
		L.patta = patta;
		L.docNo = docNo;		
		L.location = location;
		
		if(head == null) {
			head = L;
		}
		else {
			Node1 temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = L;
		}
	}
	
	Node1 sendHead() {
		return head;
	}
	
	void display() {
		Node1 temp = head;
		while(temp != null) {
			System.out.println(temp.name);
			temp = temp.next;
		}
	}
	
}


public class searchMain2 extends Frame implements ItemListener,ActionListener{
	GridBagConstraints gbc = new GridBagConstraints();
	Checkbox landType, landSize, documentNo, surveyNo;
	TextField landSizetf, documentNotf, surveyNotf;
	Choice landTypeChoice;
	CheckboxGroup buttonGrp = new CheckboxGroup();
	Label l0, l1, l2, l3, l4;
	Button search;
	Image img;
	userData obj = new userData();
	String tempString1,tempString2,tempString3,tempString4;
	int choice = 1;
	boolean shouldPaint = false,icon = true;
	
	public searchMain2() {
		obj.addData("Agriculture", "Super market", 1000, 550000.95, "Nitish", "1234567890", "100", "1", "Kamaraj street, Perundurai");
		obj.addData("Residential", "Hospital", 2000, 650000.95, "Kumaresan", "2345678901", "101", "2", "Raja street, Thiruppur");
		obj.addData("Commercial", "Airport", 3000, 750000.95, "Karthik", "3456789012", "102", "3", "Jayam nagar, VIP city, Karur");
		obj.addData("Non agricultural", "Malls", 4000, 850000.95, "MohanRaja", "4567890123", "103", "4", "Capital city, Salem");
		
		setLayout(new GridBagLayout());
		setSize(new Dimension(600, 600));
		setTitle("Property Search Toolkit");
		
		img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\nitis\\Downloads\\bg.jpg");

		
		l0 = new Label("Select any one of the method :");
		landType = new Checkbox("Land type", buttonGrp, true);
		landSize = new Checkbox("Based on land size", buttonGrp, false);
		documentNo = new Checkbox("Document number", buttonGrp, false);
		surveyNo = new Checkbox("Patta/Survey number", buttonGrp, false);
		
		l1 = new Label("Enter the type of land : ");
		l2 = new Label("Enter your land size preference : ");
		l3 = new Label("Enter your document number : ");
		l4 = new Label("Enter your patta/survey number : ");
		
		search = new Button("Search");
		landTypeChoice = new Choice();
		landTypeChoice.add("Agriculture");
		landTypeChoice.add("Residential");
		landTypeChoice.add("Commercial");
		landTypeChoice.add("Non agricultural");
		
		landSizetf = new TextField(20);
		documentNotf = new TextField(20);
		surveyNotf = new TextField(20);
		
		landType.addItemListener(this);
		landSize.addItemListener(this);
		documentNo.addItemListener(this);
		surveyNo.addItemListener(this);
		search.addActionListener(this);
		
		l1.setVisible(true);
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(false);
		landTypeChoice.setVisible(true);
		documentNotf.setVisible(false);
		landSizetf.setVisible(false);
		surveyNotf.setVisible(false);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		add(l0, gbc);

		gbc.gridwidth = 1;
		gbc.gridy = 1;
		gbc.gridx = 0;
		add(landType, gbc);

		gbc.gridx = 1;
		add(landSize, gbc);

		gbc.gridx = 2;
		add(documentNo, gbc);

		gbc.gridx = 3;
		add(surveyNo, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		add(l1, gbc);
		add(l2, gbc);
		add(l3, gbc);
		add(l4, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		add(landTypeChoice, gbc);
		add(documentNotf, gbc);
		add(landSizetf, gbc);
		add(surveyNotf, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 4;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		add(search, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(new Label(), gbc);
		

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
	}
	
	public void itemStateChanged(ItemEvent ie) {
		l1.setVisible(false);
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(false);
		
		landTypeChoice.setVisible(false);
		documentNotf.setVisible(false);
		landSizetf.setVisible(false);
		surveyNotf.setVisible(false);
		Checkbox source = (Checkbox) ie.getSource();
		
		if(source == landType) {
			l2.setVisible(false);
			l3.setVisible(false);
			l4.setVisible(false);
			l1.setVisible(true);
			documentNotf.setVisible(false);
			landSizetf.setVisible(false);
			surveyNotf.setVisible(false);
			landTypeChoice.setVisible(true);
			choice = 1;
			revalidate();
		} 
		else if(source == landSize) {
			l1.setVisible(false);
			l3.setVisible(false);
			l4.setVisible(false);
			l2.setVisible(true);
			landSizetf.setVisible(true);
			landTypeChoice.setVisible(false);
			documentNotf.setVisible(false);
			surveyNotf.setVisible(false);
			choice = 2;
			revalidate();
		} 
		else if(source == documentNo) {
			l1.setVisible(false);
			l2.setVisible(false);
			l4.setVisible(false);
			l3.setVisible(true);
			documentNotf.setVisible(true);
			landTypeChoice.setVisible(false);
			landSizetf.setVisible(false);
			surveyNotf.setVisible(false);
			choice = 3;
			revalidate();
		} 
		else if(source == surveyNo) {
			l1.setVisible(false);
			l2.setVisible(false);
			l3.setVisible(false);
			l4.setVisible(true);
			surveyNotf.setVisible(true);
			landTypeChoice.setVisible(false);
			documentNotf.setVisible(false);
			landSizetf.setVisible(false);
			choice = 4;
			revalidate();
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		shouldPaint = true;
		
		tempString1 = null;
	    tempString2 = null;
	    tempString3 = null;
	    tempString4 = null;
		if(choice == 1) {
			tempString1 = landTypeChoice.getSelectedItem().toString();
			repaint();
		}
		else if(choice == 2) {
			tempString2 = landSizetf.getText().toString();
			repaint();
		}
		else if(choice == 3) {
			tempString3 = documentNotf.getText().toString();
			repaint();
		}
		else if(choice == 4) {
			tempString4 = surveyNotf.getText().toString();
			repaint();
		}
		else {
			Dialog dialog1 = new Dialog(new Frame(),"Error",true);
            dialog1.setSize(200,80);
            dialog1.setLayout(new FlowLayout());
            Label notFound = new Label("Please select any");
            dialog1.add(notFound);
            
            dialog1.addWindowListener(new WindowAdapter() {
        		public void windowClosing(WindowEvent we) {
        			dialog1.setVisible(false);
        		}
        	});
            
            dialog1.setVisible(true);
		}
	}
	
	public void paint(Graphics g) {
		
		
		g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(getBackground());
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        
        
		boolean userFound = true;
		int rectWidth = 0;
		if(shouldPaint) {
			Node1 current = obj.head;
			Node1 foundNode = new Node1();
			int x = 50,y = 200;
			while(current != null) {
				if(tempString1 != null) {
					if(current.landType.compareToIgnoreCase(tempString1)==0) {
						g.setColor(Color.GREEN);
						Node1 L = new Node1();
						L.name = current.name;
						L.docNo = current.docNo;
						L.patta = current.patta;
						L.phoneNumber = current.phoneNumber;
						L.landType = current.landType;
						L.price = current.price;
						L.area = current.area;
						L.nearBy = current.nearBy;
						
						L.next = foundNode;
						foundNode = L;
						userFound = false;
					}
					else {
						g.setColor(Color.BLACK);
					}
				}
				else if(tempString2 != null) {
					if(current.area >= Double.parseDouble(tempString2)) {
						g.setColor(Color.GREEN);
						Node1 L = new Node1();
						L.name = current.name;
						L.docNo = current.docNo;
						L.patta = current.patta;
						L.phoneNumber = current.phoneNumber;
						L.landType = current.landType;
						L.price = current.price;
						L.area = current.area;
						L.nearBy = current.nearBy;
						
						L.next = foundNode;
						foundNode = L;
						userFound = false;
					}
					else {
						g.setColor(Color.BLACK);
					}
				}
				else if(tempString3 != null) {
					if(current.docNo.compareToIgnoreCase(tempString3)==0) {
						g.setColor(Color.GREEN);
						Node1 L = new Node1();
						L.name = current.name;
						L.docNo = current.docNo;
						L.patta = current.patta;
						L.phoneNumber = current.phoneNumber;
						L.landType = current.landType;
						L.price = current.price;
						L.area = current.area;
						L.nearBy = current.nearBy;
						
						L.next = foundNode;
						foundNode = L;
						userFound = false;
					}
					else {
						g.setColor(Color.BLACK);
					}
					
				}
				else if(tempString4 != null) {
					if(current.patta.compareToIgnoreCase(tempString4)==0) {
						g.setColor(Color.GREEN);
						Node1 L = new Node1();
						L.name = current.name;
						L.docNo = current.docNo;
						L.patta = current.patta;
						L.phoneNumber = current.phoneNumber;
						L.landType = current.landType;
						L.price = current.price;
						L.area = current.area;
						L.nearBy = current.nearBy;
						
						L.next = foundNode;
						foundNode = L;
						userFound = false;
					}
					else {
						g.setColor(Color.BLACK);
					}
				}
				rectWidth = current.docNo.length()*10+20;
				g.drawRect(x, y, rectWidth, 30);
				g.drawString(current.docNo, x+10, y+20);
				if (current.next != null) {
					int arrowStartX = x + rectWidth ; 
					int arrowEndX = arrowStartX + 30;
					g.drawLine(arrowStartX, y + 15, arrowEndX, y + 15);
					g.drawLine(arrowEndX - 5, y + 10, arrowEndX, y + 15); 
					g.drawLine(arrowEndX - 5, y + 20, arrowEndX, y + 15); 
				}
				if(x+(rectWidth+30) >= (600-100)) {
					x = 50;
					y = 250;
				}
				else {				
					x+=(rectWidth+30);
				}
				current = current.next;
			}
			if(userFound) {
				Dialog dialog1 = new Dialog(new Frame(),"Error",true);
                dialog1.setSize(200,80);
                dialog1.setLayout(new FlowLayout());
                Label notFound = new Label("Details not found");
                dialog1.add(notFound);
                
                dialog1.addWindowListener(new WindowAdapter() {
            		public void windowClosing(WindowEvent we) {
            			dialog1.setVisible(false);
            		}
            	});
                
                dialog1.setVisible(true);
			}
			else {
				g.setColor(Color.BLACK);
				Node1 temp = foundNode;
				int currentx = 50,currenty = y+rectWidth;
				g.drawString("Land record details: ", currentx, currenty+50);
				currentx+=20;
				currenty+=50;
				int a = 20,b = 0;
				while(temp.next != null) {
					currenty+=20;
					g.drawString("Name : "+temp.name, currentx+a, currenty+b);
					currenty+=20;
					g.drawString("Document number : "+temp.docNo, currentx+a, currenty+b);
					currenty+=20;
					g.drawString("Patta number : "+temp.patta, currentx+a, currenty+b);
					currenty+=20;
					g.drawString("Land amount : "+String.valueOf(temp.price), currentx+a, currenty+b);
					currenty+=20;
					temp = temp.next;
				}
			}
		}
		revalidate();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchMain2 obj = new searchMain2();
		obj.setVisible(true);
	}

}
