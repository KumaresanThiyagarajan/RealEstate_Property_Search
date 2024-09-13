package propertySearch;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class searchMain extends Frame implements ItemListener{
	GridBagConstraints gbc = new GridBagConstraints();
	Checkbox propertyHolder, phoneNo, documentNo, surveyNo;
	TextField propertyHoldertf, phoneNotf, documentNotf, surveyNotf;
	CheckboxGroup buttonGrp = new CheckboxGroup();
	Label l0, l1, l2, l3, l4;
	Button search;
	String[] holderNameList = {"nitish", "karthik", "kumaresan"};
	int[] phoneNumberList = {11111, 22222, 33333};
	int[] documentNumberList = {1, 2, 3};
	int[] surveyNumberList = {123, 456, 789};

	public searchMain() {
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
		propertyHoldertf = new TextField();
		phoneNotf = new TextField();
		documentNotf = new TextField();
		surveyNotf = new TextField();
		propertyHolder.addItemListener(this);
		phoneNo.addItemListener(this);
		documentNo.addItemListener(this);
		surveyNo.addItemListener(this);

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
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		add(propertyHoldertf, gbc);
		add(documentNotf, gbc);
		add(phoneNotf, gbc);
		add(surveyNotf, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
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
		} 
		else if(source == phoneNo) {
			l2.setVisible(true);
			documentNotf.setVisible(true);
		} 
		else if(source == documentNo) {
			l3.setVisible(true);
			phoneNotf.setVisible(true);
		} 
		else if(source == surveyNo) {
			l4.setVisible(true);
			surveyNotf.setVisible(true);
		}
		revalidate();
		repaint();
	}

	public static void main(String[] args) {
		searchMain obj = new searchMain();
		obj.setVisible(true);
	}
}
