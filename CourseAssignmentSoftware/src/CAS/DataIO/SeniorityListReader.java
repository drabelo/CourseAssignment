/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAS.DataIO;
import java.util.*;
import java.io.*;
import CAS.Data.*;
/**
 *
 * @author Eric Sullivan
 */

public class SeniorityListReader
{
    private Scanner scan;
    private String workArea;
    private int senior;
    private String name;
    private String input;
    
    /*
    public SeniorityListReader() throws IOException {
        super("FakeSeniority.txt");
        scan = new Scanner(super.getFile());
        workArea = "";
        senior =0;
        name ="";
        input = "";
    }
    * */
    
    public static HashMap<String,Instructor> loadSeniorityList(String filename, HashMap<String,Instructor> theMap)
            throws FileNotFoundException
    {
        return loadSeniorityList(new File(filename), theMap);
    }
    
    public static HashMap<String,Instructor> loadSeniorityList(File file, HashMap<String,Instructor> theMap)
            throws FileNotFoundException
    {
        
        Scanner scan = new Scanner(file);
        String workArea;
        int senior;
        String name;
        String input;
        
        
        workArea = "";
        senior =0;
        name ="";
        input = "";
        
        
        StringBuilder snip;
        StringTokenizer st;
        while(scan.hasNextLine()){
            input = scan.nextLine();
            //System.out.println("input: " + input);
            if(!input.equals("")){
            if(input.charAt(0)=='-'&&input.charAt(1)=='-'){
                snip = new StringBuilder(input);
                workArea = snip.substring(2);
                //System.out.println("work area: " + workArea);
                
            }
            else{
                st = new StringTokenizer(input,"\r\n\t\f");
                name = st.nextToken();
                //System.out.println("name: " + name);
                senior =Integer.parseInt(st.nextToken());
                //System.out.println("senior: " + senior);
                //try {
                theMap.get(name).getSeniorities().put(workArea,senior);
                //}
                /*
                catch (NullPointerException e) {
                    System.out.println("get: " + theMap.get(name));
                    System.out.println("null for: " + name + workArea + senior);
                }
                catch (NoSuchElementException e) {
                    System.out.println("can't find info for: " + name);
                }
                * */
            }
            }
        }
        return theMap;
    }
}