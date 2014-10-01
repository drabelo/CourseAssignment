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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class RecoverPanel extends JPanel
{
  private JButton jbCancel;
  private JButton jbGetPasscode;
  
  private JLabel jLabelUser;
  private JLabel jLabelEmail;
  private JLabel jLabelSecurityAnswer;
  private JLabel jLabelSecurityQuestion;
  
  private JTextField jTextEmail;
  private JTextField jTextUsername;
  private JTextField jTextSecurityAnswer;
  
  private JComboBox<String> jComboQuestion;
  
  private final int TEXT_LENGTH = 20;
  public RecoverPanel()
  {
    super(new GridBagLayout());
    buildThatReallyCoolRegisterPanel();
    setVisible(true);
    
  }
  private void buildThatReallyCoolRegisterPanel()
  {
    String[] securityQuestions =
    {
      "In what school did you attend sixth grade?",
      "In what city or town was your first job?",
      "How many colleges did you apply to?",
      "What was your childhood nickname?",
      "What was your first payed job?",
      "Who was your first roommate?",
      "Is this a joke?"
    };
    jComboQuestion = new JComboBox<String>(securityQuestions);
    jbCancel = new JButton("Cancel");
    jbGetPasscode = new JButton("Recover Passcode");
    
    jTextEmail = new JTextField(TEXT_LENGTH);
    jTextUsername = new JTextField(TEXT_LENGTH);
    jTextSecurityAnswer = new JTextField(TEXT_LENGTH);
    
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
    
    jLabelEmail = new JLabel("Email: ");
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    add(jLabelEmail, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    add(jTextEmail, gbc);
    
    jLabelSecurityQuestion = new JLabel("Question: ");
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    add(jLabelSecurityQuestion, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    add(jComboQuestion, gbc);
    
    jLabelSecurityAnswer = new JLabel("Answer: ");
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    add(jLabelSecurityAnswer, gbc);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.gridwidth = 2;
    add(jTextSecurityAnswer, gbc);
    
    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    add(jbCancel, gbc);
    gbc.gridx = 2;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    add(jbGetPasscode, gbc);
    
    setBorder(new LineBorder(Color.GRAY));
  }
  public String getEmailField()
  {
    return jTextEmail.
      getText();
  }
  public String getUsernameField()
  {
    return jTextUsername.
      getText();
  }
  public final JButton getCancelButton()
  {
    return jbCancel;
  }
  public String getSecurityAnswerField()
  {
    return jTextSecurityAnswer.
      getText();
  }
  public final JComboBox getQuestionBox()
  {
    return jComboQuestion;
  }
  public String getSecurityQuestionField()
  {
    return (String)jComboQuestion.
      getSelectedItem();
  }
  public final JButton getRecoveryButton()
  {
    return jbGetPasscode;
  }
  
}