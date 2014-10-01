package CAS.GUI.Login;
import CAS.GUI.FileSelectorWindow;

/*
  Tauseef Pirzada
  06122013
*/
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

public class LoginFrame extends JFrame
{
  
  private UserBase ub;
  private JFrame thisFrame;
  private LoginPanel loginPanel;
  
  private final int WIDTH = 400;
  private final int HEIGHT = 300;
  
  public LoginFrame()
  {
    super("User Login");
    ub = new UserBase();
    buildThatNotAsAwesomeAsTheLoginPanelLoginFrameYo();
    thisFrame = this;
  }
  private void buildThatNotAsAwesomeAsTheLoginPanelLoginFrameYo()
  {
    loginPanel = new LoginPanel();
    setSize(WIDTH,HEIGHT);
    OnAction onAction = new OnAction();
    loginPanel.getLoginButton().addActionListener(onAction);
    loginPanel.getRegisterButton().addActionListener(onAction);
    loginPanel.getRecoveryButton().addActionListener(onAction);
    add(loginPanel);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setResizable(false);
  }
  private class OnAction implements ActionListener
  {
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource() == loginPanel.getLoginButton())
      {
        String szUsername = loginPanel.getUsernameField();
        String szPasscode = loginPanel.getPasscodeField();
        if(!(szUsername.isEmpty() || szPasscode.isEmpty()))
        {
          try
          {
            
            if(ub.authenticate(szUsername,szPasscode))
            {
              setVisible(false);
              new FileSelectorWindow();
              dispose();
            }
            else
              JOptionPane.showMessageDialog(null,"Incorrect Username or Passcode.",
                                            "Case Sensitive",
                                            JOptionPane.ERROR_MESSAGE);
          }
          catch(IOException ioe)
          {
            JOptionPane.showMessageDialog(null,ioe.getMessage());
          }
        }
        else
          JOptionPane.showMessageDialog(null,"Username or Passcode fields can not be empty.");
      }
      else if (ae.getSource() == loginPanel.getRegisterButton())
      {
        setVisible(false);
        new RegisterFrame(thisFrame,ub);
      }
      else if (ae.getSource() == loginPanel.getRecoveryButton())
      {
        setVisible(false);
        new RecoverFrame(thisFrame,ub);
      }
    }
  }
}