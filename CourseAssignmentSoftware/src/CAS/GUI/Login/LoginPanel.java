package CAS.GUI.Login;

/*
  Tauseef Pirzada
  06122013
*/
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

public class LoginPanel extends JPanel
{
  
  private JLabel jLabelUser;
  private JLabel jLabelPass;
  
  private final int TEXT_LENGTH = 20;
  
  private JTextField jTextUsername;
  private JPasswordField jTextPasscode;
  
  private LoginButtonPanel lbPanel;
  
  public LoginPanel()
  {
    super(new GridBagLayout());
    buildThatAwesomeLoginPanelYo();
    setVisible(true);
  }
  private void buildThatAwesomeLoginPanelYo()
  {
    jTextUsername = new JTextField(TEXT_LENGTH);
    jTextPasscode = new JPasswordField(TEXT_LENGTH);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    
    jLabelUser = new JLabel("Username: ");
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    add(jLabelUser, gbc);
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    add(jTextUsername, gbc);
    
    jLabelPass = new JLabel("Passcode: ");
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    add(jLabelPass, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    add(jTextPasscode, gbc);
    
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    lbPanel = new LoginButtonPanel();
    add(lbPanel,gbc);
    setBorder(new LineBorder(Color.GRAY));
  }
  public String getPasscodeField()
  {
    return String.
      valueOf(jTextPasscode.
                getPassword());
  }
  public String getUsernameField()
  {
    return jTextUsername.
      getText();
  }
  public final JButton getLoginButton()
  {
    return lbPanel.getLoginButton();
  }
  public final JButton getRegisterButton()
  {
    return lbPanel.getRegisterButton();
  }
  public final JButton getRecoveryButton()
  {
    return lbPanel.getRecoveryButton();
  }
}