package access_Modifiers.class_problems;

public class AccessChecker {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("SAME_CLASS".equals(accessorContext)) return "ALLOWED";

        if ("SAME_PACKAGE".equals(accessorContext))
            return fieldModifier.equals("private") ? "DENIED" : "ALLOWED";

        if ("DIFFERENT_PACKAGE".equals(accessorContext))
            return fieldModifier.equals("public") ? "ALLOWED" : "DENIED";

        if ("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext))
            return fieldModifier.equals("protected") || fieldModifier.equals("public") ? "ALLOWED" : "DENIED";

        if ("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE".equals(accessorContext))
            return fieldModifier.equals("public") ? "ALLOWED" : "DENIED";

        return "DENIED";
    }

    static String summarizeBatch(String[][] attempts) {
        int allowed = 0, denied = 0;
        for (String[] attempt : attempts) {
            if ("ALLOWED".equals(classifyAccess(attempt[0], attempt[1])))
                allowed++;
            else
                denied++;
        }
        return "Allowed: " + allowed + " | Denied: " + denied;
    }
}
