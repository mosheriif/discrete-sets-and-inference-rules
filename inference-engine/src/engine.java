import java.util.ArrayList;

public class engine implements InferenceEngine{
    ArrayList<InferenceRule> rules = new ArrayList<>();
    ArrayList<Expression> expressions = new ArrayList<>();
    public void addRule(InferenceRule rule){
        rules.add(rule);
    }
    public void addExpression(Expression exp){
        expressions.add(exp);
    }
    public Expression applyRules(){
        int accepted = 0;
        Expression e = new Expression();
        for(int i = 0; i < rules.size(); i++)
        {
            if (rules.get(i).matches(expressions.get(0), expressions.get(1)))
            {
                e = rules.get(i).apply(expressions.get(0), expressions.get(1));
                accepted = i;
                break;
            }
        }
        if (e.getRepresentation() == null)
        {
            System.out.println("The input expression cannot be inferred");
        }
        else
        {
            System.out.println(e.getRepresentation() + " " + "(" + rules.get(accepted).getClass().getSimpleName() + ")");
        }
        return e;
    }
}