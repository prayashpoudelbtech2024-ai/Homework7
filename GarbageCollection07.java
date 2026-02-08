class Test {
    public static void main(String[] args) {
        Test obj = new Test(); // object created
        obj = null;           // now eligible for garbage collection
        System.gc();          // request GC (not guaranteed)
    }
}