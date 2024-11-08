public class DisjunctiveSyllogism implements InferenceRule{
    public boolean matches(Expression exp1, Expression exp2){
        String one = exp1.getRepresentation();
        String two = exp2.getRepresentation();
        String s1 = "";
        if ( (one.length() > 2) && (two.length() > 2) )
        {
            return false;
        }
        if (one.length() > two.length())
        {
            if (one.charAt(0) == '~')
            {
                s1 = String.valueOf(one.charAt(1));
            }
            else
            {
                s1 = "~" + String.valueOf(one.charAt(0));
            }
            if (s1.equals(two))
            {
                return true;
            }
            else
            {
                if (one.charAt(one.length() - 2) == '~')
                {
                    s1 = String.valueOf(one.charAt(one.length() - 1));
                }
                else
                {
                    s1 = "~" + String.valueOf(one.charAt(one.length() - 1));
                }
                if (s1.equals(two))
                {
                    return true;
                }
            }
        }
        else
        {
            if (two.charAt(0) == '~')
            {
                s1 = String.valueOf(two.charAt(1));
            }
            else
            {
                s1 = "~" + String.valueOf(two.charAt(0));
            }
            if (s1.equals(one))
            {
                return true;
            }
            else
            {
                if (two.charAt(two.length() - 2) == '~')
                {
                    s1 = String.valueOf(two.charAt(two.length() - 1));
                }
                else
                {
                    s1 = "~" + String.valueOf(two.charAt(two.length() - 1));
                }
                if (s1.equals(one))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public Expression apply(Expression exp1, Expression exp2){
        Expression applied = new Expression();
        String one = exp1.getRepresentation();
        String two = exp2.getRepresentation();
        String s1 = "";
        String s2 = "";
        if (matches(exp1, exp2))
        {
            if (one.length() > two.length())
            {
                for (int i = 0; i < one.length(); i++)
                {
                    if (one.charAt(i) == 'v')
                    {
                        s1 = one.substring(i+1);
                        break;
                    }
                }
                if (s1.charAt(0) == '~')
                {
                    s2 = String.valueOf(s1.charAt(1));
                }
                else {
                    s2 = "~" + s1;
                }
                if (s2.equals(two))
                {
                    for (int i = 0; i < one.length(); i++)
                    {
                        if (one.charAt(i) == 'v')
                        {
                            s1 = one.substring(0, i);
                            break;
                        }
                    }
                }
                applied.setRepresentation(s1);
            }
            else
            {
                for (int i = 0; i < two.length(); i++)
                {
                    if (two.charAt(i) == 'v')
                    {
                        s1 = two.substring(i+1);
                        break;
                    }
                }
                if (s1.charAt(0) == '~')
                {
                    s2 = String.valueOf(s1.charAt(1));
                }
                else {
                    s2 = "~" + s1;
                }
                if (s2.equals(one))
                {
                    for (int i = 0; i < two.length(); i++)
                    {
                        if (two.charAt(i) == 'v')
                        {
                            s1 = two.substring(0, i);
                            break;
                        }
                    }
                }
                applied.setRepresentation(s1);
            }
        }
        return applied;
    }
}