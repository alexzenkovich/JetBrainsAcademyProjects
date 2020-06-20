class Problem {
    public static void main(String[] args) {
        boolean flag = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("test")) {
                System.out.println(i);
                flag = true;
            }
        }
        if (!flag) System.out.println("-1");
    }
}