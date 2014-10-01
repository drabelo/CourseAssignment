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

public class RecoverFrame extends JFrame
{
  private UserBase ub;
  private JFrame jLoginFrame;
  private RecoverPanel jRecoverPanel;
  
  
  private final int WIDTH = 400;
  private final int HEIGHT = 300;
  
  public RecoverFrame(JFrame jLoginFrame,UserBase ub)
  {
    super("Recover Passcode");
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
    jRecoverPanel = new RecoverPanel();
    
    jRecoverPanel.getQuestionBox().addActionListener(onAction);
    jRecoverPanel.getCancelButton().addActionListener(onAction);
    jRecoverPanel.getRecoveryButton().addActionListener(onAction);
    
    add(jRecoverPanel);
  }
  private class OnAction implements ActionListener
  {
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource() == jRecoverPanel.getCancelButton())
      {
        setVisible(false);
        jLoginFrame.setVisible(true);
        dispose();
      }
      else if (ae.getSource() == jRecoverPanel.getRecoveryButton())
      {
        String szEmail = jRecoverPanel.getEmailField();
        String szUsername = jRecoverPanel.getUsernameField();
        String szAnswer = jRecoverPanel.getSecurityAnswerField();
        String szQuestion = jRecoverPanel.getSecurityQuestionField();
        if(! (szEmail.isEmpty() || szUsername.isEmpty() ||
              szAnswer.isEmpty() || szQuestion.isEmpty()) )
        {
          try
          {
            String rec = ub.recover(szUsername,szEmail,szQuestion,szAnswer);
            if(rec!=null)
            {
              JOptionPane.showMessageDialog(null,"Your passcode is\r\n"+
                                            rec);
              setVisible(false);
              jLoginFrame.setVisible(true);
              dispose();
            }
            else
              JOptionPane.showMessageDialog(null,"Your passcode could not be recovered.\r\nVerify you've entered the fields correctly");
          }
          catch(IOException e)
          {
            JOptionPane.showMessageDialog(null,e.getMessage());
          }
        }
        else
          JOptionPane.showMessageDialog(null,"Recovery fields can not be empty");
      }
    }
  }
}