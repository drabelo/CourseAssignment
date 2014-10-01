package CAS.GUI.Login;

/*
  Tauseef Pirzada
  06122013
*/
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
public class LoginButtonPanel extends JPanel
{
  private JButton jbLogin;
  private JButton jbRecover;
  private JButton jbRegister;
  public LoginButtonPanel()
  {
    super(new GridBagLayout());
    buildLoginButtonPanel();
  }
  private void buildLoginButtonPanel()
  {
    jbLogin = new JButton("Login");
    jbRecover = new JButton("Recovery");
    jbRegister = new JButton("Register");
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    add(jbLogin,gbc);
    
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    add(jbRegister,gbc);
    
    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    add(jbRecover,gbc);
  }
  public final JButton getLoginButton()
  {
    return jbLogin;
  }
  public final JButton getRegisterButton()
  {
    return jbRegister;
  }
  public final JButton getRecoveryButton()
  {
    return jbRecover;
  }
}