package CAS.GUI.Login;

/*
  Tauseef Pirzada
  06122013
*/
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

public class RegisterFrame extends JFrame
{
  private UserBase ub;
  private JFrame jLoginFrame;
  private RegisterPanel jRegisterPanel;
  
  
  private final int WIDTH = 400;
  private final int HEIGHT = 300;
  
  public RegisterFrame(JFrame jLoginFrame,UserBase ub)
  {
    super("Register");
    this.jLoginFrame = jLoginFrame;
    this.ub = ub;
    builtThatAwesomeRegisterFrame();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(WIDTH,HEIGHT);
    setVisible(true);
    
  }
  private void builtThatAwesomeRegisterFrame()
  {
    OnAction onAction = new OnAction();
    jRegisterPanel = new RegisterPanel();
    
    jRegisterPanel.getQuestionBox().addActionListener(onAction);
    jRegisterPanel.getCancelButton().addActionListener(onAction);
    jRegisterPanel.getRegisterButton().addActionListener(onAction);
    
    add(jRegisterPanel);
  }
  private class OnAction implements ActionListener
  {
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource() == jRegisterPanel.getCancelButton())
      {
        setVisible(false);
        jLoginFrame.setVisible(true);
        dispose();
      }
      else if (ae.getSource() == jRegisterPanel.getRegisterButton())
      {
        String szEmail = jRegisterPanel.getEmailField();
        String szUsername = jRegisterPanel.getUsernameField();
        String szPasscode = jRegisterPanel.getPasscodeField();
        String szAnswer = jRegisterPanel.getSecurityAnswerField();
        String szQuestion = jRegisterPanel.getSecurityQuestionField();
        if(! (szEmail.isEmpty() || szUsername.isEmpty() || szPasscode.isEmpty() ||
              szAnswer.isEmpty() || szQuestion.isEmpty()) )
        {
          try
          {
            if(!ub.register(szUsername,szPasscode,
                            szEmail,szQuestion,
                            szAnswer))
              JOptionPane.showMessageDialog(null,"Account: "+szUsername+" already exists.","Duplicate Username",JOptionPane.INFORMATION_MESSAGE);
            else
            {
              JOptionPane.showMessageDialog(null,"Account: "+
                                            szUsername+" created successfully!");
              setVisible(false);
              jLoginFrame.setVisible(true);
              dispose();
            }
          }
          catch(IOException ioe)
          {
            JOptionPane.showMessageDialog(null,ioe.getMessage());
          }
        }
        else
          JOptionPane.showMessageDialog(null,"Registration fields can not be empty");
      }
    }
  }
}