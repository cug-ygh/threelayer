package three_layers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class frmLogin {
	static public UserBUS _userBUS;
	
	public frmLogin() {
		_userBUS = new UserBUS();
	}
	
	public static void main(String[] args) {
	JFrame frame = new JFrame("Login");
    frame.setSize(560, 400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//����
	JPanel panel = new JPanel(); 
	frame.add(panel);
	panel.setLayout(null);
	
	//��ѯ��
	JTextArea jta_search = new JTextArea();
	jta_search.setBounds(10, 100, 500, 200);
	jta_search.setVisible(true);
	panel.add(jta_search);

	
	//��ѯ
	JButton btn_search = new JButton("��ѯ");
	btn_search.setBounds(10,20,100,40);
	panel.add(btn_search);
	btn_search.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserVO _userVO = new UserVO();
			try {
				_userVO = _userBUS.getUserEmailByName(jta_search.getText().toString());
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
});
	
	//ɾ��
	JButton btn_cancel = new JButton("ɾ��");
	btn_cancel.setBounds(200,20,100,40);
	panel.add(btn_cancel);
	btn_cancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
});
	
	frame.setVisible(true);
	
	}

}
