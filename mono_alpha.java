
import java.io.File;
import java.io.FileWriter;
import java.util.*;
class mono_alpha
{
    public static void encrypt(String text) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        List<String> list = Arrays.asList(alphabets.split(""));
        Collections.shuffle(list);
        String shuffled = "";
        for (String s : list) {
            shuffled = shuffled + s;
        }
        char[] keys = shuffled.toCharArray();
        
        String cipher="";
        for(int i=0;i<text.length();i++)
        {
            int ascii = text.charAt(i);
            if(ascii>=97 && ascii<=122)
            {
                ascii-=97;
                cipher+=keys[ascii];
            }
            else{
                cipher+=(char)ascii;
            }
            
        } 
        try {
            File encrypt = new File("encrypt.txt");
            encrypt.createNewFile();
            
            FileWriter ob = new FileWriter("encrypt.txt");
            ob.write(cipher);
            ob.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String text="";
        try {
            File obj = new File("/Users/kd/Documents/SEM_6/CryptoGraphy/mono_alpa/intput.txt");
            Scanner o = new Scanner(obj);
            while(o.hasNextLine())
            {
                text+=o.nextLine();
            }
            encrypt(text);
            o.close();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
}