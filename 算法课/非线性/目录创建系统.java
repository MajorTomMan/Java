package 非线性;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Structure.Data;
import Structure.TRnode;
import Structure.Tree;

public class 目录创建系统 {
    static Scanner scanner;
    public static void main(String[] args) {
        Tree<String> tree=new Tree<>();
        String choose=Menu();
        while(Integer.parseInt(choose)!=5){
            switch(Integer.parseInt(choose)){
                case 1:tree.Show(tree.getRoot());break;
                case 2:System.out.println("请输入要创建的文件夹名称:");
                       String chose=scanner.nextLine();
                       TRnode<String> node=new TRnode<>();
                       node.data=new Data<>();
                       node.child=new ArrayList<>();
                       node.data.saveData=chose;
                       tree.Insert(node,tree.getRoot());
                       System.out.println("文件夹创建成功!");
                       break;
                case 3:System.out.println("请输入要进入的目录名:");
                       String dirname=scanner.nextLine();
                       TRnode<String> dirpath=tree.Search(dirname);
                       if(dirpath==null){
                        System.out.println("没有找到目录名,请重试一遍");
                        break;
                       }

                case 4:System.out.println("请输入要删除的文件夹名称:");
                       String dir=scanner.nextLine();
                       TRnode<String> d_node=new TRnode<>();
                       Data<String> d_data=new Data<>();
                       d_node.data=d_data;
                       d_node.data.saveData=dir;
                       tree.Delete(d_node,tree.getRoot());
                       break;
            }
            choose=Menu();
        }
        System.out.println("Bye!");
    }
    public static String Menu(){
        System.out.println("目录创建系统:\n"
        +"1.显示所在目录\n"
        +"2.创建文件夹\n"
        +"3.进入目录\n"
        +"4.删除文件夹\n"
        +"5.退出\n"
        +"请输入序号:"
        );
        scanner=new Scanner(System.in);
        String choose=scanner.nextLine();
        return choose;
    }
}
