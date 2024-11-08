import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ModusPonens modusP = new ModusPonens();
        ModusTollens modusT = new ModusTollens();
        HypotheticalSyllogism hs = new HypotheticalSyllogism();
        DisjunctiveSyllogism ds = new DisjunctiveSyllogism();
        Resolution res = new Resolution();
        engine Iengine = new engine();
        Expression exp1 = new Expression();
        Expression exp2 = new Expression();
        Expression result = new Expression();

        Iengine.addRule(modusP);
        Iengine.addRule(modusT);
        Iengine.addRule(hs);
        Iengine.addRule(ds);
        Iengine.addRule(res);

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.replaceAll("expressions are ", "");
        s = s.replaceAll("\"","");
        String[] s2 = s.split(" and ");
        exp1.setRepresentation(s2[0]);
        exp2.setRepresentation(s2[1]);
        Iengine.addExpression(exp1);
        Iengine.addExpression(exp2);
        result = Iengine.applyRules();
        //System.out.print(result.getRepresentation());
    }
}