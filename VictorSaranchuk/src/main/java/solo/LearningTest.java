package solo;


import java.io.*;
import java.util.LinkedList;

public class LearningTest {
    public static void main(String[] args) throws IOException {
        File file=new File ("test.txt");
        PrintWriter pr = new PrintWriter(new FileWriter(file.getName(), true));
        String j="00";
        String s = j+"12345end";
        StringBuilder sb=new StringBuilder();
        sb.append(s).append("11");
        pr.println(sb);
        pr.println("9end");
        pr.println(sb);
        pr.flush();

        BufferedReader br=new BufferedReader(new FileReader(file.getName()));
            LinkedList<String> ll=new LinkedList<>();
            String s1;
            while ((s1=br.readLine())!=null){
                ll.add(s1);
            }
            for (int i=0; i<ll.size();i++) {
                if (ll.get(i).contains("9")) ll.remove(i);
            }

            PrintWriter pr1=new PrintWriter(new FileWriter(file.getName()));
        for (int i=0; i<ll.size();i++){
            pr1.println(ll.get(i));
        }
            pr1.flush();

        for (String l:ll
             ) {
            System.out.println(l);
        }


    }
}

