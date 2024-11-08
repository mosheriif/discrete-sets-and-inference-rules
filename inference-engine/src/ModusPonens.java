public class ModusPonens implements InferenceRule{
    public boolean matches(Expression exp1, Expression exp2){
        String one = exp1.getRepresentation();
        String two = exp2.getRepresentation();
        if ( (one.length() > 2) && (two.length() > 2) )
        {
            return false;
        }
        if (one.length() > two.length())
        {
            for (int i = 0; i < two.length(); i++)
            {
                if (one.charAt(i) != two.charAt(i))
                {
                    return false;
                }
            }
        }
        else
        {
            for (int i = 0; i < one.length(); i++)
            {
                if (two.charAt(i) != one.charAt(i))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public Expression apply(Expression exp1, Expression exp2){
        Expression applied = new Expression();
        String one = exp1.getRepresentation();
        String two = exp2.getRepresentation();
        if (matches(exp1, exp2))
        {
            if (one.length() > two.length())
            {
                for (int i = 0; i < one.length(); i++)
                {
                    if (one.charAt(i) == '>')
                    {
                        applied.setRepresentation(one.substring(i+1));
                    }
                }
            }
            else
            {
                for (int i = 0; i < two.length(); i++)
                {
                    if (two.charAt(i) == '>')
                    {
                        applied.setRepresentation(two.substring(i+1));
                    }
                }
            }
        }
        return applied;
    }
}