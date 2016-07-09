/*ID: neungsz1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class gift1 {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    int numberOfPeople = Integer.parseInt(f.readLine());

    Map<String, Integer> map = new LinkedHashMap<String, Integer>();

    for (int i = 0; i < numberOfPeople; i++) {
      map.put(f.readLine(), 0);
    }

    for (int i = 0; i < numberOfPeople; i++) {
      String name = f.readLine();
      String[] giveInfo = f.readLine().split(" ");
      int people = Integer.parseInt(giveInfo[1]);

      if (people > 0) {
        int money = Integer.parseInt(giveInfo[0]);
        int moneyShard = money / people;
        int remain = money % people;

        map.put(name, (map.get(name) - money) + remain);

        for (int j = 0; j < people; j++) {
          String fName = f.readLine();
          map.put(fName, map.get(fName) + moneyShard);
        }
      }
    }

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      String key = entry.getKey();
      Integer value = entry.getValue();

      out.println(key + " " + value);
    }

    out.close();
  }
}
