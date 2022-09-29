import java.io.*;
import java.util.*;

class fileNames{
	protected void fileNames(String rootDir1) throws IOException{
		int i =1;
		File flist=new File(rootDir1);
		File list[]=flist.listFiles();
		Arrays.sort(list);
		for(File e:list) {
			if(e.isFile()) {
				System.out.println(i+". "+e.getName());
				i++;
			}
		}
		if(i==1) {
			System.out.println("No file available in the folder.");
		}
	}
}

class addFile{
	protected void addfile(String rootDir1, String fileName1) throws IOException{
		String fname=rootDir1+"/"+fileName1;
		File f=new File(fname);
		if(f.createNewFile()) {
		System.out.println("File is created.");
		}else {
			System.out.println("File already exist.");
		}
	}
}

class delFile{
	protected void delfile(String rootDir1, String fileName1) throws IOException{
		String fname=rootDir1+"/"+fileName1;
		File f=new File(fname);
		if(f.delete()) {
		System.out.println("File got deleted.");
		}else {
			System.out.println("File not available.");
		}
	}
}

class serchFile{
	protected void serchfile(String rootDir1, String fileName1) throws IOException{
		String fname=rootDir1+"/"+fileName1;
		File f=new File(fname);
		if(f.isFile()) {
		System.out.println("File is available.");
		System.out.println("File Name: "+f.getName());
		System.out.println("Path of the file: "+f.getAbsolutePath());
		}else {
			System.out.println("File not available.");
		}
	}
}

class checkPath{
	protected boolean checkPath(String rootDir1) throws IOException{
		File dir=new File(rootDir1);
		if(dir.exists()) {
			boolean b=true;
			return b;
		}else {
			boolean b = false;
			return b;
		}
	}
}

class case2{
	protected void case2() throws IOException{
		String rootDir1, fileName1;
		boolean b1;
		Scanner sc1=new Scanner(System.in);
		System.out.println("*Welcome to File Management*");
		do {
		System.out.println("What do you want to do?");
		System.out.println("Type 1 to add file");
		System.out.println("Type 2 to delete file");
		System.out.println("Type 3 to search file");
		System.out.println("Type 4 to go back to Main Menu");
		System.out.print("Type your option: ");
		int suboption1=sc1.nextInt();
		if(suboption1==1||suboption1==2||suboption1==3) {
			System.out.print("Path of Directory: ");
			rootDir1=sc1.next();
			checkPath checkP=new checkPath();
			b1=checkP.checkPath(rootDir1);
			if(b1) {
			System.out.print("File Name: ");
			fileName1=sc1.next();
				switch(suboption1) {
				case 1:
					addFile add=new addFile();
					add.addfile(rootDir1, fileName1);
					break;
				case 2:
					delFile del=new delFile();
					del.delfile(rootDir1, fileName1);
					break;
				case 3:
					serchFile serch=new serchFile();
					serch.serchfile(rootDir1, fileName1);
					break;
				}
				}else {
					System.out.println("Provided path of directory not available.");
					}
			}else if(suboption1==4){
				return;
			}else
				{
				System.out.println("Please type correct option.");
				}
		}while(true);
	}
}

public class Menu {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int option;
		boolean b;
		String rootDir, fileName;
		System.out.println("||* Welcome to LockedMe.com *||\n");
		System.out.println("Application Developer: Rahul Ojha\n");
		do {
			System.out.println("Choose Your Option");
			System.out.println("Type 1 to Display the files name in the directory");
			System.out.println("Type 2 for File Management");
			System.out.println("Type 3 to close the application");
			System.out.print("Your Option: ");
			option=sc.nextInt();
			if(option==1||option==2||option==3){
			switch(option) {
			case 1:
				System.out.print("Path of Directory: ");
				rootDir=sc.next();
				checkPath checkP=new checkPath();
				b=checkP.checkPath(rootDir);
				if(b) {
				fileNames files=new fileNames();
				files.fileNames(rootDir);
				}else
					System.out.println("Provided path of directory not available.");
				break;
			case 2:
			case2 fileM=new case2();
			fileM.case2();
				break;
			case 3:
				System.out.println("Application Closed");
				return;
			}
			}else
				System.out.println("Warning: Wrong option selected.");
		}while(true);

	}

}
