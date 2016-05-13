/*
ID: neungsz1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    String cometName = f.readLine();
    String groupName = f.readLine();

    Map<String, Integer> alphabet = new HashMap<String, Integer>();
    int i = 1;
    for (char txt = 'A'; txt <= 'Z'; txt++){
      alphabet.put(""+txt, i++);
    }

    int resultComet = alphabet.get(""+cometName.charAt(0));
    for (int j = 1; j < cometName.length(); j++){
      resultComet *=  alphabet.get(""+cometName.charAt(j));
    }

    int resultGroup = alphabet.get(""+groupName.charAt(0));
    for (int j = 1; j < groupName.length(); j++){
      resultGroup *=  alphabet.get(""+groupName.charAt(j));
    }

    if (resultComet%47 == resultGroup%47)
      out.println("GO");
    else
      out.println("STAY");

    out.close();
  }
}
