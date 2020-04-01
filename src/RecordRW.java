import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecordRW {
    static ArrayList<File> files = new ArrayList<>();
    String[] sentences;
    File currentFile;
    String currDir=System.getProperty("user.dir");
    Scanner in = new Scanner(System.in);
    File fileLookup= new File(System.getProperty("user.dir")+"\\src\\"+"files"+".txt");;
    public void readSaveFile(int index)
    {
        for(File a : files)
        {
            if(files.size()<index-1)
            {
                System.out.println("Pick a number in the List");
                readSaveFile(in.nextInt()-1);
            }
            else {
                currentFile = files.get(index-1);
            }
        }
        try{
        Scanner read = new Scanner(currentFile);
        while(read.hasNextLine())
            System.out.println(read.nextLine());
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
    }
    public void writeDailyRecord(String name)
    {
        String currDir=System.getProperty("user.dir");
        try{
            File file = new File(currDir+"\\src\\"+name+".txt");
            files.add(file);
            FileWriter fw= new FileWriter(file);
            FileWriter fLookup = new FileWriter(fileLookup);
            int x =0;
            while(x<=files.size()-1)
            {
                if(fileLookup.exists())
                {
                    fLookup.append((x + 1) +". "+files.get(x).getName());
                    fLookup.append("\n");
                }
                else {
                fLookup.write((x + 1) +". "+files.get(x).getName());
                fLookup.write("\n");}
                x++;
            }
            fLookup.close();
            System.out.println("Type in the file");
            String paragraph=in.nextLine();
            fw.write(paragraph);
            fw.close();
            System.out.println("Done");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void write(String name, List<Employee> emp) throws IOException {

            int x=0;
            File file = new File(currDir+"\\src\\"+name+".txt");
            files.add(file);

        FileOutputStream fos = new FileOutputStream(file);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));



        for(Employee a:emp){
            String line= String.format(a.firstName+","+a.lastName+","+a.email+","+a.phone+"\n");
            bw.append(line);

        }
        bw.close();
    }
    public ArrayList<Employee> read()
    {
        ArrayList<Employee> de=new ArrayList<>();

        File file = new File(currDir+"\\src\\Employees.txt");
        try {
            Scanner readF=new Scanner(file);
            while(readF.hasNextLine())
            {
                String [] r=readF.nextLine().split(",");
                    Employee t = new Employee(r[0],r[1]);
                    t.email=r[2];
                    t.phone=r[3];
                    de.add(t);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

return de;
    }
    public void update(List<Employee> d)
    {
        File file = new File(currDir+"\\src\\Employees.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for(Employee r:d)
            {
                bw.write(r.firstName+","+r.lastName+","+r.email+","+r.phone+"\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
