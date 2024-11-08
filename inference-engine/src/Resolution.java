public class Resolution implements InferenceRule{
    public boolean matches(Expression exp1, Expression exp2){
        String one = exp1.getRepresentation();
        String two = exp2.getRepresentation();
        String s1 = "";
        String s2 = "";
        String s3 = "";
        for (int i = 0; i < one.length(); i++)
        {
            if (one.charAt(i) == 'v')
            {
                s1 = one.substring(0,i);
                break;
            }
        }
        if (!(s1.equals("")))
        {
            if (s1.charAt(0) == '~') {
                s2 = String.valueOf(s1.charAt(1));
            } else {
                s2 = "~" + s1;
            }
            for (int i = 0; i < two.length(); i++) {
                if (two.charAt(i) == 'v') {
                    s3 = two.substring(0, i);
                    break;
                }
            }
            if (!(s2.equals(s3))) {
                for (int i = 0; i < two.length(); i++) {
                    if (two.charAt(i) == 'v') {
                        s3 = two.substring(i + 1);
                        break;
                    }
                }
                if (!(s2.equals(s3))) {
                    for (int i = 0; i < one.length(); i++) {
                        if (one.charAt(i) == 'v') {
                            s1 = one.substring(i + 1);
                            break;
                        }
                    }
                    if (s1.charAt(0) == '~') {
                        s2 = String.valueOf(s1.charAt(1));
                    } else {
                        s2 = "~" + s1;
                    }
                    if (!(s2.equals(s3))) {
                        for (int i = 0; i < two.length(); i++) {
                            if (two.charAt(i) == 'v') {
                                s3 = two.substring(0, i);
                                break;
                            }
                        }
                        if (!(s2.equals(s3))) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    public Expression apply(Expression exp1, Expression exp2){
        Expression applied = new Expression();
        String one = exp1.getRepresentation();
        String two = exp2.getRepresentation();
        String s1 = "";
        String s2 = "";
        String s3 = "";
        if (matches(exp1, exp2))
        {
            for (int i = 0; i < one.length(); i++)
            {
                if (one.charAt(i) == 'v')
                {
                    s1 = one.substring(0,i);
                    break;
                }
            }
            if (s1.charAt(0) == '~')
            {
                s2 = String.valueOf(s1.charAt(1));
            }
            else
            {
                s2 = "~" + s1;
            }
            for (int i = 0; i < two.length(); i++)
            {
                if (two.charAt(i) == 'v')
                {
                    s3 = two.substring(0,i);
                    break;
                }
            }
            if (s2.equals(s3))
            {
                for (int i = 0; i < one.length(); i++)
                {
                    if (one.charAt(i) == 'v')
                    {
                        s1 = one.substring(i+1);
                        break;
                    }
                }
                for (int i = 0; i < two.length(); i++)
                {
                    if (two.charAt(i) == 'v')
                    {
                        s2 = two.substring(i+1);
                        break;
                    }
                }
                applied.setRepresentation(s1 + "v" + s2);
            }
            else
            {
                for (int i = 0; i < two.length(); i++)
                {
                    if (two.charAt(i) == 'v')
                    {
                        s3 = two.substring(i+1);
                        break;
                    }
                }
                if (s2.equals(s3))
                {
                    for (int i = 0; i < one.length(); i++)
                    {
                        if (one.charAt(i) == 'v')
                        {
                            s1 = one.substring(i+1);
                            break;
                        }
                    }
                    for (int i = 0; i < two.length(); i++)
                    {
                        if (two.charAt(i) == 'v')
                        {
                            s2 = two.substring(0,i);
                            break;
                        }
                    }
                    applied.setRepresentation(s1 + "v" + s2);
                }
                else
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
                    else
                    {
                        s2 = "~" + s1;
                    }
                    if (s2.equals(s3))
                    {
                        for (int i = 0; i < one.length(); i++)
                        {
                            if (one.charAt(i) == 'v')
                            {
                                s1 = one.substring(0, i);
                                break;
                            }
                        }
                        for (int i = 0; i < two.length(); i++)
                        {
                            if (two.charAt(i) == 'v')
                            {
                                s2 = two.substring(0,i);
                                break;
                            }
                        }
                        applied.setRepresentation(s1 + "v" + s2);
                    }
                    else
                    {
                        for (int i = 0; i < one.length(); i++)
                        {
                            if (one.charAt(i) == 'v')
                            {
                                s1 = one.substring(0, i);
                                break;
                            }
                        }
                        for (int i = 0; i < two.length(); i++)
                        {
                            if (two.charAt(i) == 'v')
                            {
                                s2 = two.substring(i+1);
                                break;
                            }
                        }
                        applied.setRepresentation(s1 + "v" + s2);
                    }
                }
            }
        }
        return applied;
    }
}