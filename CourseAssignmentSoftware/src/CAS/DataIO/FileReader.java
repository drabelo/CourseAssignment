/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CAS.DataIO;

/**
 *
 * @author Justin
 */
import java.io.*;

public class FileReader
{
    private File file;
    
    public FileReader(String filename) throws FileNotFoundException
    {
        this.file = new File(filename);
    }
    
    public boolean loadFile()
    {
        if(file != null)
            return true;
        else
            return false;
    }
    
    public File getFile()
    {
        return file;
    }
}
