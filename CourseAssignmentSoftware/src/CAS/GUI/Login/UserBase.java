package CAS.GUI.Login;

/*
  Tauseef Pirzada
  06122013
*/
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

import java.util.Scanner;

public class UserBase
{
  private File file;
  public UserBase()
  {
    file = new File("UserLoginData.waldo");
  }
  public UserBase(File file)
  {
    this.file = new File(file.toString());
    file = null;
  }
  public boolean authenticate(String szUsername,String szPasscode)throws IOException
  {
    Scanner scan = new Scanner(file);
    String[] szDec = null;
    boolean bRet = false;
    while(scan.hasNextLine())
    {
      szDec = Xor.decrypt(scan.nextLine()).split(":");
      if(szDec[0].equals(szUsername)&&szDec[1].equals(szPasscode))
        bRet = true;
    }
    scan.close();
    return bRet;
  }
  public String recover(String szUsername,String szEmail,String szQuestion,
                        String szAnswer)throws IOException
  {
    Scanner scan = new Scanner(file);
    String[] szDec = null;
    String szPasscode = null;
    while(scan.hasNextLine())
    {
      szDec = Xor.decrypt(scan.nextLine()).split(":");
      if(szDec[0].equalsIgnoreCase(szUsername)&&
         szDec[2].equalsIgnoreCase(szEmail)&&
         szDec[3].equalsIgnoreCase(szQuestion)&&
         szDec[4].equalsIgnoreCase(szAnswer)
        )
        szPasscode = szDec[1];
    }
    scan.close();
    return szPasscode;
  }
  private String buildEncryptedString(String szUsername,String szPasscode,
                                      String szEmail,String szQuestion,
                                      String szAnswer)
  {
    String szUserData = szUsername+":"+szPasscode+":"+szEmail+":"+szQuestion+
      ":"+szAnswer;
    return Xor.encrypt(szUserData);
  }
  private boolean doesUsernameExist(String szUsername)throws IOException
  {
    Scanner scan = new Scanner(file);
    String[] szDec = null;
    boolean bRet = false;
    while(scan.hasNextLine())
    {
      szDec = Xor.decrypt(scan.nextLine()).split(":");
      if(szDec[0].equalsIgnoreCase(szUsername))
        bRet = true;
    }
    scan.close();
    return bRet;
  }
  public boolean register(String szUsername,String szPasscode,
                          String szEmail,String szQuestion,
                          String szAnswer)throws IOException
  {
    if(file.exists())
    {
      if(doesUsernameExist(szUsername))
        return false;
    }
    else
      file.createNewFile();
    
    String szEncStr = buildEncryptedString(szUsername,szPasscode,
                                           szEmail,szQuestion,
                                           szAnswer);
    BufferedWriter br = new BufferedWriter(new FileWriter(file,true));
    br.write(szEncStr);
    br.newLine();
    br.close();
    return true;
  }
}