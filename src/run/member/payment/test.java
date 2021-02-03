package run.member.payment;

import javax.swing.JFrame;



public class test  extends JFrame{

	public test() {

		this.setBounds(200,100,1200,850);
	
		new Paymentrun(this);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

}
