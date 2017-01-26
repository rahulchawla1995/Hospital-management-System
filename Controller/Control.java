import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;








public class Control {

	private boolean login_auth;
	
	public void Login_Auth(Login login,DB db){		

				try {
					login.btnLogin.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							try{
								db.User_Auth(login.getTextField().getText(),login.getTextField_1().getText());
								login_auth = db.isUser_result();
								if(login_auth == true){
								
								JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFULLY");
								login.frmSmsHospital.dispose();
								Menu menu = new Menu();
								Menu_c menu_c = new Menu_c();
								
								menu.setVisible(true);
								menu_c.select(menu);
								
								
								
								
								}else{
									JOptionPane.showMessageDialog(null, "TRY AGAIN!!");
								}
							}catch(Exception e ){
								e.printStackTrace();
							}
						}
					});
				}catch (Exception e) {
					e.printStackTrace();
				}
				
		}
	
	
	
	
	public boolean isLogin_auth() {
		return login_auth;
	}

	public void setLogin_auth(boolean login_auth) {
		this.login_auth = login_auth;
	}
	
}
