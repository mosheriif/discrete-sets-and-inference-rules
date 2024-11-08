public class ModusTollens implements InferenceRule{
    public boolean matches(Expression exp1, Expression exp2){
        String one = exp1.getRepresentation();
        String two = exp2.getRepresentation();
        String s = "";
        if ( (one.length() > 2) && (two.length() > 2) )
        {
            return false;
        }
        if (one.length() > two.length())
        {
            for (int i = 0; i < one.length(); i++)
            {
                if (one.charAt(i) == '>')
                {
                    s = one.substring(i+1);
                    if (s.length() < two.length())
                    {
                        if (s.charAt(0) != two.charAt(1))
                        {
                            return false;
                        }
                    }
                    else
                    {
                        if (s.charAt(1) != two.charAt(0))
                        {
                            return false;
                        }
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < two.length(); i++)
            {
                if (two.charAt(i) == '>')
                {
                    s = two.substring(i+1);
                    if (s.length() < one.length())
                    {
                        if (s.charAt(0) != one.charAt(1))
                        {
                            return false;
                        }
                    }
                    else
                    {
                        if (s.charAt(1) != one.charAt(0))
                        {
                            return false;
                        }
                    }
                }
            }
        }
        if (s.equals(""))
        {
            return false;
        }
        return true;
    }
    public Expression apply(Expression exp1, Expression exp2){
        Expression applied = new Expression();
        String one = exp1.getRepresentation();
        String two = exp2.getRepresentation();
        String s = "";
        if (matches(exp1, exp2))
        {
            if (one.length() > two.length())
            {
                if (one.charAt(0) == '~')
                {
                    applied.setRepresentation(String.valueOf(one.charAt(1)));
                }
                else
                {
                    applied.setRepresentation("~" + String.valueOf(one.charAt(0)));
                }
            }
            else
            {
                if (two.charAt(0) == '~')
                {
                    applied.setRepresentation(String.valueOf(two.charAt(1)));
                }
                else
                {
                    applied.setRepresentation("~" + String.valueOf(two.charAt(0)));
                }
            }
        }
        return applied;
    }
}