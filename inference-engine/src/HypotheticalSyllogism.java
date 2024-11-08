public class HypotheticalSyllogism implements InferenceRule{
    public boolean matches(Expression exp1, Expression exp2){
        String one = exp1.getRepresentation();
        String two = exp2.getRepresentation();
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < one.length(); i++)
        {
            if (one.charAt(i) == '>')
            {
                s1 = one.substring(i+1);
                break;
            }
        }
        for (int i = 0; i < two.length(); i++)
        {
            if (two.charAt(i) == '>')
            {
                s2 = two.substring(0, i);
                break;
            }
        }
        if ( (!(s1.equals(s2))) && (!(s1.equals(""))) )
        {
            for (int i = 0; i < one.length(); i++)
            {
                if (one.charAt(i) == '>')
                {
                    s1 = one.substring(0, i);
                    break;
                }
            }
            for (int i = 0; i < two.length(); i++)
            {
                if (two.charAt(i) == '>')
                {
                    s2 = two.substring(i+1);
                    break;
                }
            }
            if (!(s1.equals(s2)))
            {
                return false;
            }
        }
        if (s1.equals(""))
        {
            return false;
        }
        return true;
    }
    public Expression apply(Expression exp1, Expression exp2){
        Expression applied = new Expression();
        String one = exp1.getRepresentation();
        String two = exp2.getRepresentation();
        String s1 = "";
        String s2 = "";
        if (matches(exp1, exp2))
        {
            for (int i = 0; i < one.length(); i++)
            {
                if (one.charAt(i) == '>')
                {
                    s1 = one.substring(0,i);
                    break;
                }
            }
            for (int i = 0; i < two.length(); i++)
            {
                if (two.charAt(i) == '>')
                {
                    s2 = two.substring(i+1);
                    break;
                }
            }
            if (!(s1.equals(s2)))
            {
                applied.setRepresentation(s1 + ">" + s2);
            }
            else
            {
                for (int i = 0; i < one.length(); i++)
                {
                    if (one.charAt(i) == '>')
                    {
                        s1 = one.substring(i+1);
                        break;
                    }
                }
                for (int i = 0; i < two.length(); i++)
                {
                    if (two.charAt(i) == '>')
                    {
                        s2 = two.substring(0,i);
                        break;
                    }
                }
                applied.setRepresentation(s2 + ">" + s1);
            }
        }
        return applied;
    }
}