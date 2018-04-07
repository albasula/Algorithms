/**
 * Calculates a simple addition-subtraction expression by
 * placing the numbers in the nodes of a binary tree and
 * operations as parents then recursively making the calculations
 * by going up, therefore the root node will have he final result
 * Created on 26/12/2017.
 */

import static java.lang.Math.pow;
class Tree {
    public String data;
    public Tree left;
    public Tree right;
    public Tree(String rootData) {
        this.data=rootData;
    }
}
public class binaryTreeCalculations {
    static boolean isNumber(String exp){
        try{
            double a=Double.parseDouble(exp);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    static Tree parseAS(String eq, Tree root){
        int indexlA=eq.lastIndexOf("+");
        int indexlS=eq.lastIndexOf("-");
        String u;
        String v;
        if(indexlA>indexlS){
            root.data="+";
            root.left=new Tree("");
            root.right=new Tree("");
            u=eq.substring(0,indexlA);
            v=eq.substring(indexlA+1);
            if(isNumber(u)){
                root.left=new Tree(u);
                root.right=new Tree("");
                if(isNumber(v)){
                    root.right=new Tree(v);
                    return root;
                }
            }
            if(isNumber(v)){
                root.right=new Tree(v);
                root.left=new Tree("");
                parseAS(u,root.left);
            }
        }
        else if(indexlA<indexlS){
            root.data="-";
            u=eq.substring(0,indexlS);
            v=eq.substring(indexlS+1);
            if(isNumber(u)){
                root.left=new Tree(u);
                root.right=new Tree("0");
                if(isNumber(v)){
                    root.right=new Tree(v);
                    return root;
                }
            }
            if(isNumber(v)){
                root.right=new Tree(v);
                root.left=new Tree("0");
                parseAS(u,root.left);
            }
        }
        return root;
    }
    
    static void calculate(Tree root){
        if (isNumber(root.data))
            return;
        if (isNumber(root.left.data) && isNumber(root.right.data)) {
            root.data = aSDMP(root.left.data, root.data, root.right.data);
            return;
        }
        calculate(root.left);
        calculate(root.right);
        if(isNumber(root.left.data)&&isNumber(root.right.data)) {
            root.data = aSDMP(root.left.data, root.data, root.right.data);
        }
    }
    static String aSDMP(String a,String b,String c){
        switch(b){
            case "+": return Integer.parseInt(a)+Integer.parseInt(c)+"";
            case "-": return Integer.parseInt(a)-Integer.parseInt(c)+"";
            case "*": return Integer.parseInt(a)*Integer.parseInt(c)+"";
            case "/": return Integer.parseInt(a)/Integer.parseInt(c)+"";
            case "^": return pow(Integer.parseInt(a),Integer.parseInt(c))+"";
            default: return "Calculating error...";
        }
    }

    public static void main(String args[]) {
        String a = "-1+2+8+29-200";
        Tree t=new Tree("");
        Tree outP=parseAS(a,t);
        try{
            calculate(outP);
            System.out.println("The result is: "+outP.data);
        }catch(Exception e){
            System.out.println("There is a logical issue with the expression");
        }

    }
}
