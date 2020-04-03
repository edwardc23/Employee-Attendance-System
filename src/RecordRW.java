import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public void writeAttendance(ArrayList<Logger.Stu> list,String name)
    {
        try {
            File file = new File(currDir+"\\src\\"+name+".txt");
            boolean fvar=file.createNewFile();
            FileWriter fw;
            if(fvar){fw= new FileWriter(file,false);}
            else{ fw= new FileWriter(file,true);}


            LocalDate localDate = LocalDate.now();
            System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate));

            fw.append(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate) + "\n");
            for(Logger.Stu l:list)
            {
                fw.write(l.name1+"  "+l.choice+"\n");
            }
            fw.close();
        } catch (IOException e) {
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
            String line= String.format(a.firstName+","+a.lastName+","+a.email+","+a.phone+","+a.id+","+a.numOfTimesAbsent+"\n");
            bw.append(line);
            System.out.println();
        }
        bw.flush();
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
                    t.id=Integer.parseInt(r[4]);
                    t.numOfTimesAbsent=Integer.parseInt(r[5]);
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
