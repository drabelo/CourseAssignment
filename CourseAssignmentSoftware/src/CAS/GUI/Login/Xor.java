package CAS.GUI.Login;

/*
  Tauseef Pirzada
  06122013
*/
import java.util.ArrayList;
public class Xor
{
  public static final byte[] KEY = {0xD,0xE,0xA,0xD,0xB,0xE,0xE,0xF};
  public static String  encrypt(String szUser)
  {
    byte[] bUser = szUser.getBytes();
    String szEncrypt = "";
    for(int i = 0; i < bUser.length; ++i)
    {
      bUser[i] ^= KEY[i%KEY.length];
      szEncrypt+= String.format("%02X",bUser[i]);
    }
    return szEncrypt;
  }
  private static String undoHex(String str){
    
    StringBuilder sb = new StringBuilder();
    for( int i=0; i<str.length()-1; i+=2 )
      sb.append((char)Byte.parseByte(str.substring(i, (i + 2)), 16));
    return sb.toString();
  }
  public static String decrypt(String szUser)
  {
    byte[] bUser = undoHex(szUser).getBytes();
    for(int i = 0; i < bUser.length;++i)
      bUser[i] ^= KEY[i%KEY.length];
    return new String(bUser);
  }
}