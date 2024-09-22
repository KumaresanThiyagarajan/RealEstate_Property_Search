package propertySearch;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class Node{
	String name,phoneNo,patta,docNo;
	Node next;
	Node(){
		next = null;
	}
}

class userData{
	Node head;
	userData(){
		head = null;
	}
	
	void addData(String name) {
		Node L = new Node();
		L.name = name;
		L.patta = " ";
		L.phoneNo = " ";
		L.docNo = " ";
		if(head == null) {
			head = L;
		}
		else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = L;
		}
	}
	
	Node sendHead() {
		return head;
	}
	
	void display() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.name);
			temp = temp.next;
		}
	}
	
}

public class searchMain extends Frame implements ItemListener,ActionListener{
	GridBagConstraints gbc = new GridBagConstraints();
	Checkbox propertyHolder, phoneNo, documentNo, surveyNo;
	TextField propertyHoldertf, phoneNotf, documentNotf, surveyNotf;
	CheckboxGroup buttonGrp = new CheckboxGroup();
	Label l0, l1, l2, l3, l4;
	Button search;
	userData obj = new userData();
	String pName = "";
	int choice = 1;
	boolean shouldPaint = false;
	String[] holderNameList = {"nitish", "karthik", "kumaresan"};
	int[] phoneNumberList = {11111, 22222, 33333};
	int[] documentNumberList = {1, 2, 3};
	int[] surveyNumberList = {123, 456, 789};

	public searchMain() {
		obj.addData("Hello hielsafjbKDFkjBdfkjSDFHjSFLKAF");
		obj.addData("World");
		obj.addData("Hii");
		obj.addData("Pro");
		
		setLayout(new GridBagLayout());
		setSize(new Dimension(600, 600));
		setTitle("Property Search Toolkit");

		l0 = new Label("Select any one of the method :");
		propertyHolder = new Checkbox("Holder name", buttonGrp, true);
		phoneNo = new Checkbox("Phone number", buttonGrp, false);
		documentNo = new Checkbox("Document number", buttonGrp, false);
		surveyNo = new Checkbox("Patta/Survey number", buttonGrp, false);
		l1 = new Label("Enter property holder name : ");
		l2 = new Label("Enter your phone number : ");
		l3 = new Label("Enter your document number : ");
		l4 = new Label("Enter your patta/survey number : ");
		search = new Button("Search");
		propertyHoldertf = new TextField(20);
		phoneNotf = new TextField(20);
		documentNotf = new TextField(20);
		surveyNotf = new TextField(20);
		propertyHolder.addItemListener(this);
		phoneNo.addItemListener(this);
		documentNo.addItemListener(this);
		surveyNo.addItemListener(this);
		search.addActionListener(this);

		l1.setVisible(true);
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(false);
		propertyHoldertf.setVisible(true);
		documentNotf.setVisible(false);
		phoneNotf.setVisible(false);
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
		add(propertyHolder, gbc);

		gbc.gridx = 1;
		add(phoneNo, gbc);

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
		add(propertyHoldertf, gbc);
		add(documentNotf, gbc);
		add(phoneNotf, gbc);
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
		propertyHoldertf.setVisible(false);
		documentNotf.setVisible(false);
		phoneNotf.setVisible(false);
		surveyNotf.setVisible(false);
		Checkbox source = (Checkbox) ie.getSource();
		if(source == propertyHolder) {
			l1.setVisible(true);
			propertyHoldertf.setVisible(true);
			choice = 1;
		} 
		else if(source == phoneNo) {
			l2.setVisible(true);
			documentNotf.setVisible(true);
			choice = 2;
		} 
		else if(source == documentNo) {
			l3.setVisible(true);
			phoneNotf.setVisible(true);
			choice = 3;
		} 
		else if(source == surveyNo) {
			l4.setVisible(true);
			surveyNotf.setVisible(true);
			choice = 4;
		}
		revalidate();
	}
	
	public void actionPerformed(ActionEvent ae) {
		shouldPaint = true;
		repaint();
		if(choice == 1) {
			pName = propertyHoldertf.getText().toString();
		}
		else if(choice == 2) {
			pName = phoneNotf.getText().toString();
		}
		else if(choice == 3) {
			pName = documentNotf.getText().toString();
		}
		else if(choice == 4) {
			pName = surveyNotf.getText().toString();
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
		boolean userFound = true;
		if(shouldPaint) {
			Node current = obj.head;
			int x = 50,y = 200;
			while(current != null) {
				if(current.name.compareTo(pName)==0 || current.phoneNo.compareTo(pName)==0 || current.docNo.compareTo(pName)==0 || current.patta.compareTo(pName)==0) {
					g.setColor(Color.GREEN);
					userFound = false;
				}
				else {
					g.setColor(Color.BLACK);
				}
				int rectWidth = current.name.length()*10+20;
				g.drawRect(x-10, y, rectWidth, 30);
				g.drawString(current.name, x+10, y+20);
				if (current.next != null) {
					int arrowStartX = x + rectWidth - 10; 
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
		}
	}

	public static void main(String[] args) {
		searchMain obj = new searchMain();
		obj.setVisible(true);
	}
}
