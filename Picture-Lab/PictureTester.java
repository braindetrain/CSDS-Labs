/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * 
 */
public class PictureTester {
    /** Method to test edgeDetection */
    public static void testEdgeDetection() {
        Picture karel = new Picture("stock_karel.jpg");
        karel = karel.scale(0.25, 0.25);
        karel.explore();
        karel.edgeDetection(60);
        karel.explore();
    }
    
    public static void testCustonEdgeDetection() {
        Picture karel = new Picture("stock_karel.jpg");
        karel = karel.scale(0.25, 0.25);
        karel.explore();
        karel.customEdgeDetection(60);
        karel.explore();
    }

    /** Main method for testing.  Every class can have a main
     * method in Java */
    public static void main(String[] args) {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
        testEdgeDetection();    
        // testCustomEdgeDetection();
    }
}
